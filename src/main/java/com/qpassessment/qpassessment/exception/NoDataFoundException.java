package com.qpassessment.qpassessment.exception;

public class NoDataFoundException extends Exception{

    public NoDataFoundException(Long id) {
        super(String.format("No Data with Id %d found", id));
    }
}
