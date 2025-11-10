package com.devlab.bankledger.application.repository;

import com.devlab.bankledger.application.mapper.CustomerMapper;
import com.devlab.bankledger.domain.entity.DomainCustomer;
import com.devlab.bankledger.domain.repository.IDomainCustomerRepository;
import com.devlab.bankledger.infra.entity.CustomerEntity;
import com.devlab.bankledger.infra.repository.ICustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class CustomerRepository implements IDomainCustomerRepository {

    private final ICustomerJpaRepository iCustomerJpaRepository;

    @Override
    public void saveCustomer(DomainCustomer domainCustomer) {
        CustomerEntity ce = CustomerMapper.toEntity(domainCustomer);
        iCustomerJpaRepository.save(ce);
    }

    @Override
    public DomainCustomer findCustomerById(Long id) {
        return null;
    }

    @Override
    public List<DomainCustomer> findAllCustomers() {
        return List.of();
    }

    @Override
    public boolean existByCustomerid(Long id) {
        return false;
    }
}
