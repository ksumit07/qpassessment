package com.qpassessment.qpassessment.controller;

import com.qpassessment.qpassessment.dto.UserGroceryItemsDTO;
import com.qpassessment.qpassessment.dto.UserGroceryItemsIdDTO;
import com.qpassessment.qpassessment.exception.UnAuthorizedRequestException;
import com.qpassessment.qpassessment.model.GroceryItem;
import com.qpassessment.qpassessment.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/grocery")
@RestController
public class GroceryItemController {

    @Autowired
    GroceryItemService groceryItemService;

    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getGroceryItemList() {
        return new ResponseEntity<List<GroceryItem>>(groceryItemService.getGroceryItemList(), HttpStatus.OK);
    }

    @GetMapping("/availableItems")
    public ResponseEntity<List<GroceryItem>> getAvailableGroceryItemList() {
        return new ResponseEntity<List<GroceryItem>>(groceryItemService.getAvailableGroceryItemList(), HttpStatus.OK);
    }

    @PostMapping("/addItems")
    public ResponseEntity<List<GroceryItem>> saveGroceryItemList(@RequestBody UserGroceryItemsDTO userGroceryItemsDTO) throws UnAuthorizedRequestException {
        return new ResponseEntity<List<GroceryItem>>(groceryItemService.addGroceryItemList(userGroceryItemsDTO), HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteItems")
    public ResponseEntity<List<GroceryItem>> removeGroceryItemList(@RequestBody UserGroceryItemsIdDTO userGroceryItemsIdDTO) throws UnAuthorizedRequestException {
        return new ResponseEntity<List<GroceryItem>>(groceryItemService.removeGroceryItemList(userGroceryItemsIdDTO), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/editItems")
    public ResponseEntity<List<GroceryItem>> updateGroceryItemList(@RequestBody UserGroceryItemsDTO userGroceryItemsDTO) throws UnAuthorizedRequestException {
        return new ResponseEntity<List<GroceryItem>>(groceryItemService.updateGroceryItemList(userGroceryItemsDTO), HttpStatus.ACCEPTED);
    }

}
