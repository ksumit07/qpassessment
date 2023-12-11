package com.qpassessment.qpassessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qpassessment.qpassessment.model.GroceryItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGroceryItemsDTO {

    private long userId;

    @JsonProperty("groceryItemList")
    private List<GroceryItem> groceryItemList;

    public UserGroceryItemsDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<GroceryItem> getGroceryItemList() {
        return groceryItemList;
    }

    public void setGroceryItemList(List<GroceryItem> groceryItemList) {
        this.groceryItemList = groceryItemList;
    }
}
