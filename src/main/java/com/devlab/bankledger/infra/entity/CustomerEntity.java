package com.devlab.bankledger.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String cellPhoneNumber;
  private String email;
  private String idCardNumber;
  private String passportNumber;
  private boolean businessCustomer;
  @OneToMany(mappedBy = "customer")
  private List<CustomerAccountDetailEntity> accountDetails;
  @OneToMany(mappedBy = "customer")
  private List<CustomerDocumentEntity> customerDocuments;
  private String address;




}
