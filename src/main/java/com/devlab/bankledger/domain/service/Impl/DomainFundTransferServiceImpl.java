package com.devlab.bankledger.domain.service.Impl;

import com.devlab.bankledger.domain.entity.DomainCustomerAccountDetail;
import com.devlab.bankledger.domain.entity.DomainFundTransfer;
import com.devlab.bankledger.domain.enums.AccountStatus;
import com.devlab.bankledger.domain.enums.TransactionAction;
import com.devlab.bankledger.domain.enums.TransactionStatus;
import com.devlab.bankledger.domain.exception.*;
import com.devlab.bankledger.domain.repository.IDomainCustomerAccountRepository;
import com.devlab.bankledger.domain.repository.IDomainPeerToPeerFundTransferRepository;
import com.devlab.bankledger.domain.service.IDomainFundTransferService;

import java.util.List;
import java.util.Objects;

public class DomainFundTransferServiceImpl implements IDomainFundTransferService {

  IDomainPeerToPeerFundTransferRepository p2pFundTransferRepo;
  IDomainCustomerAccountRepository customerAccountDomainRepository;
  private static final String ACCOUNT_PREFIX = "MA-1";

  public DomainFundTransferServiceImpl(IDomainPeerToPeerFundTransferRepository p2pFundTransferRepo,IDomainCustomerAccountRepository customerAccountDomainRepository) {
   this.p2pFundTransferRepo = p2pFundTransferRepo;
   this.customerAccountDomainRepository = customerAccountDomainRepository;
  }


  @Override
  public void initiateTransaction(DomainFundTransfer fundTransfer) {

    if (Objects.isNull(fundTransfer)) {
      throw new EntityIsNotInitializedException("FundTransferEntity is null");
    }

    // debitor customer account validation
    validateCustomerAccount(fundTransfer.getTransferFromCustomer());

    // creditor customer account validation
    validateCustomerAccount(fundTransfer.getTransferToCustomer());

    // amount validation
    validateAmount(fundTransfer);

    fundTransfer.setStatus(TransactionStatus.PENDING);
    fundTransfer.setAction(TransactionAction.DEBIT);

    // initiate transaction
    p2pFundTransferRepo.createTransaction(fundTransfer);
  }

  private void validateAmount(DomainFundTransfer fundTransfer) {
    if (Objects.isNull(fundTransfer.getTransferAmount())) {
      throw new InvalidAmountException("Amount is null");
    } else if (fundTransfer.getTransferAmount().doubleValue() <= 0.0) {
      throw new InvalidAmountException("Amount is negative");
    }
  }

  private void validateCustomerAccount(DomainCustomerAccountDetail customerAccount) {

    if (Objects.isNull(customerAccount)) {
      throw new EntityIsNotInitializedException("CustomerAccountDetailEntity is null");
    }

    DomainCustomerAccountDetail debitor =
        customerAccountDomainRepository.findByAccountNumber(customerAccount.getAccountNumber());
    if (debitor == null) {
      throw new CustomerAccountNotFoundException(customerAccount.getAccountNumber());
    }
    if (AccountStatus.INACTIVE.equals(debitor.getAccountStatus())) {
      throw new InactiveCustomerAccountException(customerAccount.getAccountNumber());
    }
  }

  @Override
  public DomainFundTransfer peerToPeerTransfer(DomainFundTransfer fundTransfer) {

    DomainCustomerAccountDetail debitor = fundTransfer.getTransferFromCustomer();
    DomainCustomerAccountDetail creditor = fundTransfer.getTransferToCustomer();

    // if not equal to prefix
    if (!(ACCOUNT_PREFIX.startsWith(debitor.getAccountNumber())
        && ACCOUNT_PREFIX.startsWith(creditor.getAccountNumber()))) {
      throw new TransactionIsNotApplicableForP2P("Transaction is not applicable for P2P");
    }

    fundTransfer.setStatus(TransactionStatus.PENDING);
    fundTransfer.setAction(TransactionAction.CREDIT);

    return p2pFundTransferRepo.createTransaction(fundTransfer);
  }

  @Override
  public DomainFundTransfer completeTransaction(DomainFundTransfer fundTransfer) {
    List<DomainFundTransfer> existingTransaction =
        p2pFundTransferRepo.findByTransactionId(fundTransfer.getTransactionId());

    if (Objects.isNull(existingTransaction)) {
      throw new TransactionNotFoundException("Transaction doest not exists");
    }

    return p2pFundTransferRepo.completeTransaction(
        fundTransfer.getTransactionId(), TransactionStatus.SUCCESS);
  }
}
