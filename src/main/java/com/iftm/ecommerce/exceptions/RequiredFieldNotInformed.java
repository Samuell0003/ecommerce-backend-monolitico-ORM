package com.iftm.ecommerce.exceptions;

public class RequiredFieldNotInformed extends RuntimeException {
    public RequiredFieldNotInformed() {
        super("null or blank attributes");
    }
}
