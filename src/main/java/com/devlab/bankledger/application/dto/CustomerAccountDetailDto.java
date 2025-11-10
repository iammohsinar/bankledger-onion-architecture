package com.devlab.bankledger.application.dto;

import com.devlab.bankledger.domain.enums.AccountStatus;
import com.devlab.bankledger.domain.enums.AccountType;

public class CustomerAccountDetailDto {

    private String accountNumber;
    private boolean isBusinessAccount;
    private AccountType accountType;
    private AccountStatus accountStatus;


}
