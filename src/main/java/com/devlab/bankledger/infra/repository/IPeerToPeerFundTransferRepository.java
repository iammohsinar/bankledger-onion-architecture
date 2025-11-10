package com.devlab.bankledger.infra.repository;

import com.devlab.bankledger.infra.entity.FundTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPeerToPeerFundTransferRepository
    extends JpaRepository<FundTransferEntity, Long> {}
