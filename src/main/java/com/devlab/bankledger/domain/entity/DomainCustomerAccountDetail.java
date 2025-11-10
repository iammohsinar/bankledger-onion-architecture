package com.devlab.bankledger.domain.entity;

import com.devlab.bankledger.domain.enums.AccountStatus;
import com.devlab.bankledger.domain.enums.AccountType;

public class DomainCustomerAccountDetail {

    private String accountNumber;
    private boolean isBusinessAccount;
    private AccountType accountType;
    private AccountStatus accountStatus;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isBusinessAccount() {
        return isBusinessAccount;
    }

    public void setBusinessAccount(boolean businessAccount) {
        isBusinessAccount = businessAccount;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
