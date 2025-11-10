package com.devlab.bankledger.infra.repository;

import com.devlab.bankledger.infra.entity.CustomerAccountDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerAccountRepository
    extends JpaRepository<CustomerAccountDetailEntity, Long> {}
