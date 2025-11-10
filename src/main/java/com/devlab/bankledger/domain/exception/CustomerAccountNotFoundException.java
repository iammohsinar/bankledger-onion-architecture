package com.devlab.bankledger.domain.exception;

public class CustomerAccountNotFoundException extends  RuntimeException {
    public CustomerAccountNotFoundException(String account) {
        super(account + " number does not exist");
    }
}
