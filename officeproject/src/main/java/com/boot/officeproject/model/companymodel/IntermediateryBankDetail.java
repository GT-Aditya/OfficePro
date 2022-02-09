package com.boot.officeproject.model.companymodel;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Intermediatery_bank_details")
public class IntermediateryBankDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bankName="";
    private String companyCode="";
    private String routedThrough="";
    private String routedName="";
    private String routedBranch="";
    private String routedIfsc="";
    private long routedAccountNo;
    private String routedAddress="";
    private String routedSwiftCode="";
    private LocalDate routedCreateDate;
    private LocalDate routedUpdateDate;

    public IntermediateryBankDetail() {
    }

    public IntermediateryBankDetail(int id, String bankName, String companyCode, String routedThrough,
            String routedName, String routedBranch, String routedIfsc, long routedAccountNo, String routedAddress,
            String routedSwiftCode, LocalDate routedCreateDate, LocalDate routedUpdateDate) {
        this.id = id;
        this.bankName = bankName;
        this.companyCode = companyCode;
        this.routedThrough = routedThrough;
        this.routedName = routedName;
        this.routedBranch = routedBranch;
        this.routedIfsc = routedIfsc;
        this.routedAccountNo = routedAccountNo;
        this.routedAddress = routedAddress;
        this.routedSwiftCode = routedSwiftCode;
        this.routedCreateDate = routedCreateDate;
        this.routedUpdateDate = routedUpdateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getRoutedThrough() {
        return routedThrough;
    }

    public void setRoutedThrough(String routedThrough) {
        this.routedThrough = routedThrough;
    }

    public String getRoutedName() {
        return routedName;
    }

    public void setRoutedName(String routedName) {
        this.routedName = routedName;
    }

    public String getRoutedBranch() {
        return routedBranch;
    }

    public void setRoutedBranch(String routedBranch) {
        this.routedBranch = routedBranch;
    }

    public String getRoutedIfsc() {
        return routedIfsc;
    }

    public void setRoutedIfsc(String routedIfsc) {
        this.routedIfsc = routedIfsc;
    }

    public long getRoutedAccountNo() {
        return routedAccountNo;
    }

    public void setRoutedAccountNo(long routedAccountNo) {
        this.routedAccountNo = routedAccountNo;
    }

    public String getRoutedAddress() {
        return routedAddress;
    }

    public void setRoutedAddress(String routedAddress) {
        this.routedAddress = routedAddress;
    }

    public String getRoutedSwiftCode() {
        return routedSwiftCode;
    }

    public void setRoutedSwiftCode(String routedSwiftCode) {
        this.routedSwiftCode = routedSwiftCode;
    }

    public LocalDate getRoutedCreateDate() {
        return routedCreateDate;
    }

    public void setRoutedCreateDate(LocalDate routedCreateDate) {
        this.routedCreateDate = routedCreateDate;
    }

    public LocalDate getRoutedUpdateDate() {
        return routedUpdateDate;
    }

    public void setRoutedUpdateDate(LocalDate routedUpdateDate) {
        this.routedUpdateDate = routedUpdateDate;
    }
    
}
