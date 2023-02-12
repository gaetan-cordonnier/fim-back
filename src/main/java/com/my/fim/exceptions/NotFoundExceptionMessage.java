package com.my.fim.exceptions;

public class NotFoundExceptionMessage extends RuntimeException{
    private static final long serialVerisionUID = 1;

    public NotFoundExceptionMessage(String message) {
        super(message);
    }
}
