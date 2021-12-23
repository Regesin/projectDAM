package com.produce.exceptions;

public class ProduceNotFoundException extends RuntimeException{
    public ProduceNotFoundException() {
        super();
    }

    public ProduceNotFoundException(String message) {
        super(message);
    }
}
