package com.devlab.bankledger.domain.repository;

import com.devlab.bankledger.domain.entity.DomainCustomerAccountDetail;

public interface IDomainCustomerAccountRepository {

    DomainCustomerAccountDetail createAccount(DomainCustomerAccountDetail customerAccount);
    boolean existByAccountNumber(String accountNumber);
    DomainCustomerAccountDetail findByAccountNumber(String accountNumber);

}
