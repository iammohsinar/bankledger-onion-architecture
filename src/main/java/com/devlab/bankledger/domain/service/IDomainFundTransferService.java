package com.devlab.bankledger.domain.service;

import com.devlab.bankledger.domain.entity.DomainFundTransfer;

public interface IDomainFundTransferService {

    void initiateTransaction(DomainFundTransfer fundTransfer);
    DomainFundTransfer peerToPeerTransfer(DomainFundTransfer fundTransfer);
    DomainFundTransfer completeTransaction(DomainFundTransfer fundTransfer);
}
