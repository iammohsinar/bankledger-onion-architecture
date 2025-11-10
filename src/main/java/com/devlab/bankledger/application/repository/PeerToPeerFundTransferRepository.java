package com.devlab.bankledger.application.repository;

import com.devlab.bankledger.domain.entity.DomainFundTransfer;
import com.devlab.bankledger.domain.enums.TransactionStatus;
import com.devlab.bankledger.domain.repository.IDomainPeerToPeerFundTransferRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeerToPeerFundTransferRepository implements IDomainPeerToPeerFundTransferRepository {
    @Override
    public DomainFundTransfer createTransaction(DomainFundTransfer fundTransfer) {
        return null;
    }

    @Override
    public DomainFundTransfer completeTransaction(String id, TransactionStatus status) {
        return null;
    }

    @Override
    public List<DomainFundTransfer> findByTransactionId(String transactionId) {
        return List.of();
    }
}
