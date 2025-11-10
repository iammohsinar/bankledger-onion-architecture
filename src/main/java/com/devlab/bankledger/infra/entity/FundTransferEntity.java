package com.devlab.bankledger.infra.entity;

import com.devlab.bankledger.infra.enums.AccountStatus;
import com.devlab.bankledger.infra.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "fund_transfer_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundTransferEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String transactionId;
  private BigDecimal transferAmount;
  private BigDecimal transferFee;
  private BigDecimal tax;

  @ManyToOne
  @JoinColumn(name = "from_customer_id")
  private CustomerAccountDetailEntity transferFromCustomer;

  @ManyToOne
  @JoinColumn(name = "to_customer_id")
  private CustomerAccountDetailEntity transferToCustomer;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}
