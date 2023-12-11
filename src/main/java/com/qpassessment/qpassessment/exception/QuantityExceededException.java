package com.qpassessment.qpassessment.exception;

import com.qpassessment.qpassessment.model.GroceryItem;

public class QuantityExceededException extends Exception {

    public QuantityExceededException(GroceryItem groceryItem) {
        super(String.format("Quantity %d exceeded the available quantity of %s", groceryItem.getQuantity(), groceryItem.getName()));
    }
}
