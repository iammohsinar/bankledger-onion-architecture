package com.devlab.bankledger.infra.repository;

import com.devlab.bankledger.infra.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {}
