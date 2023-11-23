package com.my.fim.exceptions;

public class NotFoundExceptionMessage extends RuntimeException{

    public NotFoundExceptionMessage(String message) {
        super(message);
    }
}
