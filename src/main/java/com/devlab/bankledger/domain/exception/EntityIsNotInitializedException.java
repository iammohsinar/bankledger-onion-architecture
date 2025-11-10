package com.devlab.bankledger.domain.exception;

public class EntityIsNotInitializedException extends RuntimeException{
    public EntityIsNotInitializedException(String message) {
        super(message);
    }

}
