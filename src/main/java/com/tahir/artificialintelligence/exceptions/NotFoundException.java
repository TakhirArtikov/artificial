package com.tahir.artificialintelligence.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("No data found");
    }
}
