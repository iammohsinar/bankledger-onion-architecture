package com.devlab.bankledger.infra.entity;

import com.devlab.bankledger.domain.enums.AccountStatus;
import com.devlab.bankledger.domain.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer_account_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountDetailEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String accountNumber;

  private boolean businessAccount;
  private String accountType;
  private String accountStatus;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private CustomerEntity customer;

    @OneToMany(mappedBy = "transferFromCustomer")
    List<FundTransferEntity> fromFundTransfers;

    @OneToMany(mappedBy = "transferToCustomer")
    List<FundTransferEntity> toFundTransfers;
}
