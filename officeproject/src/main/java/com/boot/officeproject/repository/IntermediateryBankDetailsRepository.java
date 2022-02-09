package com.boot.officeproject.repository;

import com.boot.officeproject.model.companymodel.IntermediateryBankDetail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IntermediateryBankDetailsRepository extends JpaRepository<IntermediateryBankDetail, Integer>{
}