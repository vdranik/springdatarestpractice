package com.springdatarest.practice.exceptions;

public class NotCheckInException extends RuntimeException {

    public NotCheckInException(String message) {
        super(message);
    }
}
