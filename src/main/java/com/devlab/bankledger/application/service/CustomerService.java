package com.devlab.bankledger.application.service;

import com.devlab.bankledger.application.dto.CustomerDto;
import com.devlab.bankledger.domain.entity.DomainCustomer;
import com.devlab.bankledger.domain.service.IDomainCustomerAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final IDomainCustomerAccountService customerAccountService;

  public void createCustomer(CustomerDto customerDto) {
    DomainCustomer domainCustomer = customerDto.toDomain();
    regulatoryCheck();
    customerAccountService.createCustomer(domainCustomer);
    notification();
  }

  private void notification() {
    System.out.println("Notification to customer");
  }

  private void regulatoryCheck() {
    System.out.println("Regulatory check before account creation");
  }
}
