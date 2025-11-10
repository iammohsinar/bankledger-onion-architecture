package com.devlab.bankledger.domain.service;

import com.devlab.bankledger.domain.entity.DomainCustomerAccountDetail;
import com.devlab.bankledger.domain.entity.DomainCustomer;

public interface IDomainCustomerAccountService {

    void createCustomer(DomainCustomer customer);
    boolean validateCustomerDocument(DomainCustomer document);
    DomainCustomerAccountDetail createCustomerAccount(DomainCustomer document);

}
