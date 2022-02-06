package com.boot.officeproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company_details")
public class Company {
    
    
    @Id
    @Column(name = "company_code" ,nullable = false)
    private String companyCode;
    @Column(nullable = false)
    private String name="";
    @Column(nullable = false)
    private String address="";
    private String locality="";
    private String street="";
    private String country="";
    private String state="";
    private String city="";
    private int pinCode;
    private String registrationType="";
    private String organisationType="";
    private String contactNo1="", contactNo2="";
    private String fax="";
    private String email="";
    private String picture="";
    private String website="";
    private double companyINR;

    //to check continue or discontinue
    private boolean companyStatus=true;
    
    //Other details 
    @Column(nullable = false)
    private String panNo="";
    private String bin="";
    private String cstNo="";
    private String iecCode="";
    private String selfSealNo="";
    private String gstNo="";
    private String reg_cin="";
    private String otherTax="";
    private String tinNo="";

    //Bank Details
    @OneToMany(cascade = CascadeType.ALL)
    private List<CompanyBankDetails> bank;

    @OneToMany(cascade = CascadeType.ALL)
    private List<IntermediateryBankDetail> iBankDetails;

    public Company() {
    }
    

    public Company(String companyCode, String name, String address, String locality, String street,
            String country, String state, String city, int pinCode, String registrationType, String organisationType,
            String contactNo1, String contactNo2, String fax, String email, String picture, String website,
            double companyINR, boolean companyStatus, String panNo, String bin, String cstNo, String iecCode,
            String selfSealNo, String gstNo, String reg_cin, String otherTax, String tinNo, List<CompanyBankDetails> bank
            ,List<IntermediateryBankDetail> iBankDetails) {
        this.companyCode = companyCode;
       //this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.locality = locality;
        this.street = street;
        this.country = country;
        this.state = state;
        this.city = city;
        this.pinCode = pinCode;
        this.registrationType = registrationType;
        this.organisationType = organisationType;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.fax = fax;
        this.email = email;
        this.picture = picture;
        this.website = website;
        this.companyINR = companyINR;
        this.companyStatus = companyStatus;
        this.panNo = panNo;
        this.bin = bin;
        this.cstNo = cstNo;
        this.iecCode = iecCode;
        this.selfSealNo = selfSealNo;
        this.gstNo = gstNo;
        this.reg_cin = reg_cin;
        this.otherTax = otherTax;
        this.tinNo = tinNo;
        this.bank = bank;
        this.iBankDetails = iBankDetails;
    }


    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    // public int getCompanyId() {
    //     return companyId;
    // }

    // public void setCompanyId(int companyId) {
    //     this.companyId = companyId;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(String organisationType) {
        this.organisationType = organisationType;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public double getCompanyINR() {
        return companyINR;
    }

    public void setCompanyINR(double companyINR) {
        this.companyINR = companyINR;
    }

    public boolean isCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(boolean companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getCstNo() {
        return cstNo;
    }

    public void setCstNo(String cstNo) {
        this.cstNo = cstNo;
    }

    public String getIecCode() {
        return iecCode;
    }

    public void setIecCode(String iecCode) {
        this.iecCode = iecCode;
    }

    public String getSelfSealNo() {
        return selfSealNo;
    }

    public void setSelfSealNo(String selfSealNo) {
        this.selfSealNo = selfSealNo;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getReg_cin() {
        return reg_cin;
    }

    public void setReg_cin(String reg_cin) {
        this.reg_cin = reg_cin;
    }

    public String getOtherTax() {
        return otherTax;
    }

    public void setOtherTax(String otherTax) {
        this.otherTax = otherTax;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public List<CompanyBankDetails> getBank() {
        return bank;
    }

    public void setBank(List<CompanyBankDetails> bank) {
        this.bank = bank;
    }

    public List<IntermediateryBankDetail> getiBankDetails() {
        return iBankDetails;
    }

    public void setiBankDetails(List<IntermediateryBankDetail> iBankDetails) {
        this.iBankDetails = iBankDetails;
    }
    
}
