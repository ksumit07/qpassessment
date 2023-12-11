package com.qpassessment.qpassessment.exception;

public class UnAuthorizedRequestException extends Exception{

    public UnAuthorizedRequestException() {
        super("You are not authorized to perform this action, only administrators can perform this action");
    }
}
