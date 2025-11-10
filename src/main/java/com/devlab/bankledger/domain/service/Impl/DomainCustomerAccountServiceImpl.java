package com.devlab.bankledger.domain.service.Impl;

import com.devlab.bankledger.domain.entity.DomainCustomerAccountDetail;
import com.devlab.bankledger.domain.entity.DomainCustomer;
import com.devlab.bankledger.domain.exception.CustomerDocumentNotValidException;
import com.devlab.bankledger.domain.exception.CustomerNullPointerException;
import com.devlab.bankledger.domain.repository.IDomainCustomerAccountRepository;
import com.devlab.bankledger.domain.repository.IDomainCustomerRepository;
import com.devlab.bankledger.domain.service.IDomainCustomerAccountService;

import java.util.Objects;

public class DomainCustomerAccountServiceImpl implements IDomainCustomerAccountService {

  private IDomainCustomerRepository customerRepository;
  private IDomainCustomerAccountRepository customerAccountRepository;

  public DomainCustomerAccountServiceImpl(
      IDomainCustomerRepository customerRepository,
      IDomainCustomerAccountRepository customerAccountRepository) {
    this.customerRepository = customerRepository;
    this.customerAccountRepository = customerAccountRepository;
  }

  @Override
  public void createCustomer(DomainCustomer customer) {
    if (Objects.isNull(customer)) {
      throw new CustomerNullPointerException("Customer cannot be null");
    }
    validateCustomerDocument(customer);
    customerRepository.saveCustomer(customer);
  }

  @Override
  public boolean validateCustomerDocument(DomainCustomer customer) {
    if (Objects.isNull(customer.getCustomerDocument())) {
      throw new CustomerDocumentNotValidException("Upload customer documents");
    } else if (customer.getCustomerDocument().getLength() < 10_000_000L) {
      throw new CustomerDocumentNotValidException("Document length cannot be less than 10 MB");
    } else if (!customer.getCustomerDocument().getExtension().equals(".pdf")) {
      throw new CustomerDocumentNotValidException("Document length can only be in .pdf format");
    }
    return true;
  }

  @Override
  public DomainCustomerAccountDetail createCustomerAccount(DomainCustomer customer) {
    DomainCustomer _customerEntity = customerRepository.findCustomerById(customer.getId());
    if (Objects.isNull(_customerEntity)) {
      createCustomer(customer);
    }
    return customerAccountRepository.createAccount(customer.getAccountDetail());
  }
}
