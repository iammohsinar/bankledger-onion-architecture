package com.devlab.bankledger.application.repository;

import com.devlab.bankledger.domain.entity.DomainCustomerAccountDetail;
import com.devlab.bankledger.domain.repository.IDomainCustomerAccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerAccountRepository implements IDomainCustomerAccountRepository {

    @Override
    public DomainCustomerAccountDetail createAccount(DomainCustomerAccountDetail customerAccount) {
        return null;
    }

    @Override
    public boolean existByAccountNumber(String accountNumber) {
        return false;
    }

    @Override
    public DomainCustomerAccountDetail findByAccountNumber(String accountNumber) {
        return null;
    }
}
