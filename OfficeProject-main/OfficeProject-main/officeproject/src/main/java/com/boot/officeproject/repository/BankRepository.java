package com.boot.officeproject.repository;

import com.boot.officeproject.model.CompanyBankDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<CompanyBankDetails, Integer>{
    
}
