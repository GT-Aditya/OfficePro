package com.boot.officeproject.model.companymodel;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "bank_details")
public class CompanyBankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;
    @Column(nullable = false)
    private String companyCode;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String branch;
    @Column(nullable = false)
    private String ifsc;
    @Column(nullable = false)
    private long accountNo;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String swiftCode;
    @Column(nullable = false)
    private LocalDate createDate;
    private LocalDate updateDate;

    public CompanyBankDetails() {
    }
    public CompanyBankDetails(int bankId, String companyCode, String name, String branch, String ifsc,
            long accountNo, String address, String swiftCode, LocalDate createDate, LocalDate updateDate) {
        this.bankId = bankId;
        this.companyCode = companyCode;
        this.name = name;
        this.branch = branch;
        this.ifsc = ifsc;
        this.accountNo = accountNo;
        this.address = address;
        this.swiftCode = swiftCode;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public int getBankId() {
        return bankId;
    }
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
    public String getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getIfsc() {
        return ifsc;
    }
    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }
    public long getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSwiftCode() {
        return swiftCode;
    }
    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
    public LocalDate getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    public LocalDate getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }


    
}
