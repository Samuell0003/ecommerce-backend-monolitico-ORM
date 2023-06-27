package com.iftm.ecommerce.exceptions;

public class RequiredFieldNotInformed extends RuntimeException {
    public RequiredFieldNotInformed() {
        super("null or blank attributes: last name, first name or username!");
    }
}
