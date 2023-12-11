package com.qpassessment.qpassessment.service;

import com.qpassessment.qpassessment.dto.UserGroceryItemsDTO;
import com.qpassessment.qpassessment.dto.UserGroceryItemsIdDTO;
import com.qpassessment.qpassessment.exception.UnAuthorizedRequestException;
import com.qpassessment.qpassessment.model.GroceryItem;
import com.qpassessment.qpassessment.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    @Autowired
    GroceryItemRepository groceryItemRepository;

    @Autowired
    UserService userService;

    public List<GroceryItem> getGroceryItemList() {
        return groceryItemRepository.findAll();
    }

    public List<GroceryItem> getAvailableGroceryItemList() {
        return groceryItemRepository.findByQuantityNot(0);
    }

    public List<GroceryItem> addGroceryItemList(UserGroceryItemsDTO userGroceryItemsDTO) throws UnAuthorizedRequestException {
        if (!userService.isUserAdmin(userGroceryItemsDTO.getUserId())) {
            throw new UnAuthorizedRequestException();
        }
        return groceryItemRepository.saveAll(userGroceryItemsDTO.getGroceryItemList());
    }

    public GroceryItem saveGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> removeGroceryItemList(UserGroceryItemsIdDTO userGroceryItemsIdDTO) throws UnAuthorizedRequestException {
        if (!userService.isUserAdmin(userGroceryItemsIdDTO.getUserId())) {
            throw new UnAuthorizedRequestException();
        }
        List<GroceryItem> removedGroceryItemList = new ArrayList<>();
        userGroceryItemsIdDTO.getGroceryItemIdList().forEach(id -> {
            Optional<GroceryItem> groceryItemOptional = groceryItemRepository.findById(id.longValue());
            if (groceryItemOptional.isEmpty()) {
                return;
            }
            removedGroceryItemList.add(groceryItemOptional.get());
            groceryItemRepository.deleteById(id.longValue());
        });
        return removedGroceryItemList;
    }

    public List<GroceryItem> updateGroceryItemList(UserGroceryItemsDTO userGroceryItemsDTO) throws UnAuthorizedRequestException {
        if (!userService.isUserAdmin(userGroceryItemsDTO.getUserId())) {
            throw new UnAuthorizedRequestException();
        }
        return groceryItemRepository.saveAll(userGroceryItemsDTO.getGroceryItemList());
    }

}
