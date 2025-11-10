package com.devlab.bankledger.domain.exception;

public class TransactionIsNotApplicableForP2P extends RuntimeException {
  public TransactionIsNotApplicableForP2P(String message) {
      super(message);
  }
}
