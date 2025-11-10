package com.devlab.bankledger.domain.exception;

public class CustomerDocumentNotValidException extends RuntimeException {
    public CustomerDocumentNotValidException(String message) {
        super(message);
    }
}
