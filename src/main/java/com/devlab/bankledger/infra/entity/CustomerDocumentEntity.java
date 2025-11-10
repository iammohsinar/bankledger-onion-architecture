package com.devlab.bankledger.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_document_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDocumentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long length;
  private String extension;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private CustomerEntity customer;
}
