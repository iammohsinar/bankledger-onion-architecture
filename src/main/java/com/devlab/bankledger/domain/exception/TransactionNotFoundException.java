package com.devlab.bankledger.domain.exception;

public class TransactionNotFoundException extends  RuntimeException{
    public TransactionNotFoundException(String message){
        super(message);
    };
}
