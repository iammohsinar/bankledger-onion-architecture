package com.devlab.bankledger.domain.repository;

import com.devlab.bankledger.domain.entity.DomainFundTransfer;
import com.devlab.bankledger.domain.enums.TransactionStatus;

import java.util.List;

public interface IDomainPeerToPeerFundTransferRepository {

    DomainFundTransfer createTransaction(DomainFundTransfer fundTransfer);
    DomainFundTransfer completeTransaction(String id, TransactionStatus status);
    List<DomainFundTransfer> findByTransactionId(String transactionId);

}
