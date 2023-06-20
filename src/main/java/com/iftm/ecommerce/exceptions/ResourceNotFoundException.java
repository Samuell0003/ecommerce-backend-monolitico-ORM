package com.iftm.ecommerce.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Current resoucer not found!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
