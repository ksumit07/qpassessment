package com.qpassessment.qpassessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserGroceryItemsIdDTO {
    private long userId;

    @JsonProperty("groceryItemIdList")
    private List<Long> groceryItemIdList;

    public UserGroceryItemsIdDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Long> getGroceryItemIdList() {
        return groceryItemIdList;
    }

    public void setGroceryItemIdList(List<Long> groceryItemIdList) {
        this.groceryItemIdList = groceryItemIdList;
    }
}
