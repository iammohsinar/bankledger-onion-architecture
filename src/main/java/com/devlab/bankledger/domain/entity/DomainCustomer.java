package com.devlab.bankledger.domain.entity;

public class DomainCustomer {

  private Long id;
  private String name;
  private String cellPhoneNumber;
  private String email;
  private String idCardNumber;
  private String passportNumber;
  private boolean isBusinessCustomer;
  private DomainCustomerAccountDetail accountDetail;
  private DomainCustomerDocument customerDocument;
  private String address;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    if (id <= 0) {
      throw new IllegalArgumentException("customer id cannot be zero or negative");
    }
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("customer name cannot be zero or negative");
    }
    this.name = name;
  }

  public String getCellPhoneNumber() {
    return cellPhoneNumber;
  }

  public void setCellPhoneNumber(String cellPhoneNumber) {
    this.cellPhoneNumber = cellPhoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getIdCardNumber() {
    return idCardNumber;
  }

  public void setIdCardNumber(String idCardNumber) {
    this.idCardNumber = idCardNumber;
  }

  public String getPassportNumber() {
    return passportNumber;
  }

  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }

  public boolean isBusinessCustomer() {
    return isBusinessCustomer;
  }

  public void setBusinessCustomer(boolean businessCustomer) {
    isBusinessCustomer = businessCustomer;
  }

  public DomainCustomerAccountDetail getAccountDetail() {
    return accountDetail;
  }

  public void setAccountDetail(DomainCustomerAccountDetail accountDetail) {
    this.accountDetail = accountDetail;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public DomainCustomerDocument getCustomerDocument() {
    return customerDocument;
  }

  public void setCustomerDocument(DomainCustomerDocument customerDocument) {
    this.customerDocument = customerDocument;
  }
}
