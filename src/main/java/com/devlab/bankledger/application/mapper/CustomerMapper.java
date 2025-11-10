package com.devlab.bankledger.application.mapper;

import com.devlab.bankledger.domain.entity.DomainCustomer;
import com.devlab.bankledger.infra.entity.CustomerAccountDetailEntity;
import com.devlab.bankledger.infra.entity.CustomerDocumentEntity;
import com.devlab.bankledger.infra.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

public class CustomerMapper {

  public static CustomerEntity toEntity(DomainCustomer c) {

    CustomerEntity ce = new CustomerEntity();
    CustomerAccountDetailEntity cade = new CustomerAccountDetailEntity();
    CustomerDocumentEntity cde = new CustomerDocumentEntity();

    ce.setName(c.getName());
    ce.setCellPhoneNumber(c.getCellPhoneNumber());
    ce.setEmail(c.getEmail());
    ce.setIdCardNumber(c.getIdCardNumber());
    ce.setPassportNumber(c.getIdCardNumber());
    ce.setBusinessCustomer(c.isBusinessCustomer());

    if (Objects.nonNull(c.getAccountDetail())) {
      cade.setAccountNumber(c.getAccountDetail().getAccountNumber());
      cade.setAccountType(c.getAccountDetail().getAccountType().name());
      cade.setAccountStatus(c.getAccountDetail().getAccountStatus().name());
      ce.setAccountDetails(List.of(cade));
    }
    cde.setExtension(c.getCustomerDocument().getExtension());
    cde.setLength(c.getCustomerDocument().getLength());
    ce.setCustomerDocuments(List.of(cde));

    return ce;
  }
}
