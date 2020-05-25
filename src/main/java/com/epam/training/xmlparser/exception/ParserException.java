package com.epam.training.xmlparser.exception;

public class ParserException extends Throwable {
    public ParserException(String message, Exception e) {
        super(message, e);
    }
}
