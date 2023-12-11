package com.qpassessment.qpassessment.service;

import com.qpassessment.qpassessment.dto.UserOrderDTO;
import com.qpassessment.qpassessment.exception.QuantityExceededException;
import com.qpassessment.qpassessment.model.GroceryItem;
import com.qpassessment.qpassessment.model.Order;
import com.qpassessment.qpassessment.model.OrderItem;
import com.qpassessment.qpassessment.repository.GroceryItemRepository;
import com.qpassessment.qpassessment.repository.OrderItemRepository;
import com.qpassessment.qpassessment.repository.OrderRepository;
import com.qpassessment.qpassessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    GroceryItemRepository groceryItemRepository;

    @Transactional
    public Order placeOrder(UserOrderDTO userOrderDTO) throws QuantityExceededException {
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setStatus("Order placed successfully");
        order.setUser(userRepository.findById(userOrderDTO.getUserId()).get());
        Order savedOrder = orderRepository.save(order);
        for (GroceryItem groceryItem : userOrderDTO.getGroceryItemList()) {
            GroceryItem associatedGroceryItem = groceryItemRepository.findById(groceryItem.getId()).get();
            if (groceryItem.getQuantity() > associatedGroceryItem.getQuantity()) {
                throw new QuantityExceededException(groceryItem);
            }
            associatedGroceryItem.setQuantity(associatedGroceryItem.getQuantity() - groceryItem.getQuantity());
            groceryItemRepository.save(associatedGroceryItem);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setGroceryItem(groceryItem);
            orderItem.setQuantity(groceryItem.getQuantity());
            orderItemRepository.save(orderItem);
        }
        return savedOrder;
    }
}
