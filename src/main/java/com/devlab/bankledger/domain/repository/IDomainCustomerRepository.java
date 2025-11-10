package com.devlab.bankledger.domain.repository;

import com.devlab.bankledger.domain.entity.DomainCustomer;

import java.util.List;

public interface IDomainCustomerRepository {

    void saveCustomer(DomainCustomer customer);
    DomainCustomer findCustomerById(Long id);
    List<DomainCustomer> findAllCustomers();
    boolean existByCustomerid(Long id);
}
