package com.devlab.bankledger.application.dto;

import com.devlab.bankledger.domain.entity.DomainCustomer;
import com.devlab.bankledger.domain.entity.DomainCustomerAccountDetail;
import com.devlab.bankledger.domain.entity.DomainCustomerDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private String cellPhoneNumber;
    private String email;
    private String idCardNumber;
    private String passportNumber;
    private boolean businessCustomer;
    private DomainCustomerAccountDetail accountDetail;
    private DomainCustomerDocument customerDocument;
    private String address;


    public DomainCustomer toDomain() {
        DomainCustomer customer = new DomainCustomer();
        customer.setId(this.id);
        customer.setName(this.name);
        customer.setCellPhoneNumber(this.cellPhoneNumber);
        customer.setEmail(this.email);
        customer.setIdCardNumber(this.idCardNumber);
        customer.setPassportNumber(this.passportNumber);
        customer.setBusinessCustomer(this.businessCustomer);
        customer.setAccountDetail(this.accountDetail);
        customer.setCustomerDocument(this.customerDocument);
        customer.setAddress(this.address);
        return customer;
    }
}
