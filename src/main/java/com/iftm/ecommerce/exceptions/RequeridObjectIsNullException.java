package com.iftm.ecommerce.exceptions;

public class RequeridObjectIsNullException extends RuntimeException {
    public RequeridObjectIsNullException () {
        super("It is not allowed to persist a null object!");
    }


    public RequeridObjectIsNullException (String message) {
        super(message);
    }
}
