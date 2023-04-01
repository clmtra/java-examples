package com.clmtra.javaexamples.exception;

public class TemplateNotFoundException extends RuntimeException {

    public TemplateNotFoundException() {
    }

    public TemplateNotFoundException(String message) {
        super(message);
    }
}
