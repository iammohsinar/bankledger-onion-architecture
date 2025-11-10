package com.devlab.bankledger.domain.exception;

public class InactiveCustomerAccountException extends RuntimeException{

    public InactiveCustomerAccountException(String customerAccount) {
        super(customerAccount+ "account is inactive");
    }
}
