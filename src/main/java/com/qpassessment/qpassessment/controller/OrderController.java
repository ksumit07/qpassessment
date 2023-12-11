package com.qpassessment.qpassessment.controller;

import com.qpassessment.qpassessment.dto.UserOrderDTO;
import com.qpassessment.qpassessment.exception.QuantityExceededException;
import com.qpassessment.qpassessment.model.Order;
import com.qpassessment.qpassessment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestBody UserOrderDTO userOrderDTO) throws QuantityExceededException {
        return new ResponseEntity<Order>(orderService.placeOrder(userOrderDTO), HttpStatus.CREATED);
    }
}
