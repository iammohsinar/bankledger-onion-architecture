package com.devlab.bankledger.domain;

import com.devlab.bankledger.domain.entity.DomainCustomer;
import com.devlab.bankledger.domain.entity.DomainCustomerDocument;
import com.devlab.bankledger.domain.exception.CustomerDocumentNotValidException;
import com.devlab.bankledger.domain.repository.IDomainCustomerAccountRepository;
import com.devlab.bankledger.domain.repository.IDomainCustomerRepository;
import com.devlab.bankledger.domain.service.IDomainCustomerAccountService;
import com.devlab.bankledger.domain.service.Impl.DomainCustomerAccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DomainCustomerAccountServiceTests {

  private IDomainCustomerRepository customerRepository;
  private IDomainCustomerAccountRepository customerAccountRepository;
  private IDomainCustomerAccountService accountService;

  private DomainCustomer domainCustomer;
  private DomainCustomerDocument customerDocument;

  @BeforeEach
  void setup() {
    customerRepository = Mockito.mock(IDomainCustomerRepository.class);
    customerAccountRepository = Mockito.mock(IDomainCustomerAccountRepository.class);
    accountService =
        new DomainCustomerAccountServiceImpl(customerRepository, customerAccountRepository);
  }

  @Test
  void createCustomer_success_whenDocumentIsValid() {
    domainCustomer = new DomainCustomer();
    domainCustomer.setId(1L);
    domainCustomer.setName("Mohsin");
    customerDocument = new DomainCustomerDocument();
    customerDocument.setLength(20_000_000L);
    customerDocument.setExtension(".pdf");
    domainCustomer.setCustomerDocument(customerDocument);

    // Act
    accountService.createCustomer(domainCustomer);

    // Assert
    Mockito.verify(customerRepository, Mockito.times(1)).saveCustomer(domainCustomer);
  }

  @Test
  void createCustomer_failed_whenDocumentIsInvalid() {
    domainCustomer = new DomainCustomer();
    domainCustomer.setId(1L);
    domainCustomer.setName("Mohsin");
    customerDocument = new DomainCustomerDocument();
    customerDocument.setLength(5_000_000L);
    customerDocument.setExtension(".pdf");
    domainCustomer.setCustomerDocument(customerDocument);

    // Act
    CustomerDocumentNotValidException exception =
        Assertions.assertThrows(
            CustomerDocumentNotValidException.class,
            () -> accountService.createCustomer(domainCustomer));

    Assertions.assertEquals("Document length cannot be less than 10 MB", exception.getMessage());

    Mockito.verify(customerRepository, Mockito.never()).saveCustomer(domainCustomer);
  }
}
