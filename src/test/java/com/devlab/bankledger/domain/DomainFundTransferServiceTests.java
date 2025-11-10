package com.devlab.bankledger.domain;

import com.devlab.bankledger.domain.entity.DomainCustomerAccountDetail;
import com.devlab.bankledger.domain.entity.DomainFundTransfer;
import com.devlab.bankledger.domain.enums.AccountStatus;
import com.devlab.bankledger.domain.exception.CustomerAccountNotFoundException;
import com.devlab.bankledger.domain.repository.IDomainCustomerAccountRepository;
import com.devlab.bankledger.domain.repository.IDomainPeerToPeerFundTransferRepository;
import com.devlab.bankledger.domain.service.IDomainFundTransferService;
import com.devlab.bankledger.domain.service.Impl.DomainFundTransferServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DomainFundTransferServiceTests {

  IDomainPeerToPeerFundTransferRepository p2pFundTransferRepo;
  IDomainCustomerAccountRepository customerAccountDomainRepository;
  IDomainFundTransferService fundTransferService;

  @BeforeEach
  void setup() {
    p2pFundTransferRepo = mock(IDomainPeerToPeerFundTransferRepository.class);
    customerAccountDomainRepository = mock(IDomainCustomerAccountRepository.class);
    fundTransferService =
        new DomainFundTransferServiceImpl(p2pFundTransferRepo, customerAccountDomainRepository);
  }

  @Test
  public void initiateTransaction_success_whenDebitCreditAndAmountAreValid() {

    // debitor
    DomainCustomerAccountDetail debitorAccount = new DomainCustomerAccountDetail();
    debitorAccount.setAccountNumber("1001010020200303");
    debitorAccount.setAccountStatus(AccountStatus.ACTIVE);

    // creditor
    DomainCustomerAccountDetail creditorAccount = new DomainCustomerAccountDetail();
    creditorAccount.setAccountNumber("1002020020200303");
    creditorAccount.setAccountStatus(AccountStatus.ACTIVE);

    DomainFundTransfer fundTransfer = new DomainFundTransfer();
    fundTransfer.setTransferAmount(new BigDecimal(100.10));
    fundTransfer.setTransferFromCustomer(debitorAccount);
    fundTransfer.setTransferToCustomer(creditorAccount);

    // mock repository
    // debitor
    when(customerAccountDomainRepository.findByAccountNumber(debitorAccount.getAccountNumber()))
        .thenReturn(debitorAccount);
    // creditor
    when(customerAccountDomainRepository.findByAccountNumber(creditorAccount.getAccountNumber()))
        .thenReturn(creditorAccount);

    // test actual business method
    fundTransferService.initiateTransaction(fundTransfer);

    verify(p2pFundTransferRepo, times(1)).createTransaction(fundTransfer);
  }

  @Test
  public void initiateTransaction_fail_whenDebitorAccountNotFoundException() {

    // debitor
    DomainCustomerAccountDetail debitorAccount = new DomainCustomerAccountDetail();
    debitorAccount.setAccountNumber("1001010020200303");
    debitorAccount.setAccountStatus(AccountStatus.ACTIVE);

    // creditor
    DomainCustomerAccountDetail creditorAccount = new DomainCustomerAccountDetail();
    creditorAccount.setAccountNumber("1002020020200303");
    creditorAccount.setAccountStatus(AccountStatus.ACTIVE);

    DomainFundTransfer fundTransfer = new DomainFundTransfer();
    fundTransfer.setTransferAmount(new BigDecimal(100.10));
    fundTransfer.setTransferFromCustomer(debitorAccount);
    fundTransfer.setTransferToCustomer(creditorAccount);

    // mock repository
    // debitor assert
    CustomerAccountNotFoundException exception =
        assertThrows(
            CustomerAccountNotFoundException.class,
            () -> fundTransferService.initiateTransaction(fundTransfer));
    assertEquals("1001010020200303 number does not exist", exception.getMessage());

    verify(p2pFundTransferRepo, never()).createTransaction(fundTransfer);
  }
}
