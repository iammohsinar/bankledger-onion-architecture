package com.devlab.bankledger.domain.entity;

public class DomainCustomerDocument {
    private Long length;
    private String extension;


    public Long getLength() {

        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
