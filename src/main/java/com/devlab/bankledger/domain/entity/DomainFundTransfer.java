package com.devlab.bankledger.domain.entity;

import com.devlab.bankledger.domain.enums.TransactionAction;
import com.devlab.bankledger.domain.enums.TransactionStatus;

import java.math.BigDecimal;

public class DomainFundTransfer {

    private String transactionId;
    private BigDecimal transferAmount;
    private BigDecimal transferFee;
    private BigDecimal tax;
    private DomainCustomerAccountDetail transferFromCustomer;
    private DomainCustomerAccountDetail transferToCustomer;
    private TransactionAction action;
    private TransactionStatus status;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public BigDecimal getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(BigDecimal transferFee) {
        this.transferFee = transferFee;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public DomainCustomerAccountDetail getTransferFromCustomer() {
        return transferFromCustomer;
    }

    public void setTransferFromCustomer(DomainCustomerAccountDetail transferFromCustomer) {
        this.transferFromCustomer = transferFromCustomer;
    }

    public DomainCustomerAccountDetail getTransferToCustomer() {
        return transferToCustomer;
    }

    public void setTransferToCustomer(DomainCustomerAccountDetail transferToCustomer) {
        this.transferToCustomer = transferToCustomer;
    }

    public TransactionAction getAction() {
        return action;
    }

    public void setAction(TransactionAction action) {
        this.action = action;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
