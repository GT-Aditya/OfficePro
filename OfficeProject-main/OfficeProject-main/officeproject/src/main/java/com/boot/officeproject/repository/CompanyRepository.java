package com.boot.officeproject.repository;

import com.boot.officeproject.model.Company;
import com.boot.officeproject.model.CompanyBankDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, String>{
    
    @Query(value = "select concat('COMP',REPLICATE(0,4-len(isNull(max(cast(convert(varchar,substring(company_code,5,15))as int)),1)+1)),isNull(max(cast(convert(varchar, substring(company_code, 5, 15)) as int)),0)+1) from Company_details", nativeQuery = true)
    public String findcompanyCode();

    @Query(value = "select * from Bank_details where bank_code :n", nativeQuery = true)
    public CompanyBankDetails findByBankCode(@Param("n") String bankCode);

}