package com.devlab.bankledger.infra.config;

import com.devlab.bankledger.domain.repository.IDomainCustomerAccountRepository;
import com.devlab.bankledger.domain.repository.IDomainCustomerRepository;
import com.devlab.bankledger.domain.repository.IDomainPeerToPeerFundTransferRepository;
import com.devlab.bankledger.domain.service.IDomainCustomerAccountService;
import com.devlab.bankledger.domain.service.IDomainFundTransferService;
import com.devlab.bankledger.domain.service.Impl.DomainCustomerAccountServiceImpl;
import com.devlab.bankledger.domain.service.Impl.DomainFundTransferServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

  @Bean
  public IDomainCustomerAccountService domainCustomerAccountService(
      IDomainCustomerRepository customerRepository,
      IDomainCustomerAccountRepository customerAccountRepository) {
    return new DomainCustomerAccountServiceImpl(customerRepository, customerAccountRepository);
  }

  @Bean
  public IDomainFundTransferService domainFundTransferService(
      IDomainPeerToPeerFundTransferRepository p2pFundTransferRepo,
      IDomainCustomerAccountRepository customerAccountDomainRepository) {
    return new DomainFundTransferServiceImpl(p2pFundTransferRepo, customerAccountDomainRepository);
  }
}
