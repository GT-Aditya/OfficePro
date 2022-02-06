package com.boot.officeproject.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;
import com.boot.officeproject.model.Company;
import com.boot.officeproject.model.CompanyBankDetails;
import com.boot.officeproject.model.IntermediateryBankDetail;
import com.boot.officeproject.repository.BankRepository;
import com.boot.officeproject.repository.CompanyRepository;
import com.boot.officeproject.repository.IntermediateryBankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private IntermediateryBankDetailsRepository iBankDetailsRepository;

    //continue, discontinue
    @PostMapping("/company/{id}/{action}")
    public Company continueEmployee(@PathVariable("action") String value,@PathVariable("id") String id){
        Company company = companyRepository.findById(id).get();

        company.setCompanyStatus(Boolean.parseBoolean(value));
        
        return companyRepository.save(company);
    }
    

    //add Company
    @PostMapping("/company")
    public List<Company> addCompany(@RequestBody Company company)  throws IOException{

        if(company==null) return null;

        String companyCode=companyRepository.findcompanyCode();
        
        company.setCompanyCode(companyCode);

        byte [] data = Base64.getDecoder().decode(company.getPicture());
        OutputStream os = new FileOutputStream(new File("C:\\Users\\DELL\\Documents\\Spring-Projects\\company\\src\\main\\resources\\static\\Images\\"+companyCode+".jpeg"));
        os.write(data);
        os.close();

        company.setPicture(companyCode+".jpeg");

        if(company.getBank()==null) company.setBank(new Company().getBank());
        
        else{
        
            for(int i=0;i<company.getBank().size();i++){

                company.getBank().get(i).setCompanyCode(companyCode);
                company.getBank().get(i).setCreateDate(java.time.LocalDate.now());

            }
        }
        if(company.getiBankDetails()==null) company.setiBankDetails(new Company().getiBankDetails());
        
        else{

            List<IntermediateryBankDetail> iBankList = company.getiBankDetails();

            int length = iBankList.size();

            for(int i=0;i<length;i++){

                company.getiBankDetails().get(i).setBankName(iBankList.get(i).getBankName());
                company.getiBankDetails().get(i).setCompanyCode(companyCode);

                boolean check = iBankList.get(i).getRoutedThrough().equalsIgnoreCase("Bank");

                if(check){
                    company.getiBankDetails().get(i).setRoutedName(iBankList.get(i).getRoutedName());
                    company.getiBankDetails().get(i).setRoutedAddress(iBankList.get(i).getRoutedAddress());
                    company.getiBankDetails().get(i).setRoutedAccountNo(iBankList.get(i).getRoutedAccountNo());
                    company.getiBankDetails().get(i).setRoutedBranch(iBankList.get(i).getRoutedBranch());
                    company.getiBankDetails().get(i).setRoutedIfsc(iBankList.get(i).getRoutedIfsc());
                    company.getiBankDetails().get(i).setRoutedSwiftCode(iBankList.get(i).getRoutedSwiftCode());
                    company.getiBankDetails().get(i).setRoutedCreateDate(java.time.LocalDate.now());
                }
                else{
                    company.getiBankDetails().get(i).setRoutedName("");
                    company.getiBankDetails().get(i).setRoutedAddress("");
                    company.getiBankDetails().get(i).setRoutedAccountNo(0);
                    company.getiBankDetails().get(i).setRoutedBranch("");
                    company.getiBankDetails().get(i).setRoutedIfsc("");
                    company.getiBankDetails().get(i).setRoutedSwiftCode("");
                }
            }
        }
          
        companyRepository.save(company);

    return companyRepository.findAll();

    }

    //update Company
    @PutMapping("/company/{companyCode}")
    public List<Company> update(@PathVariable("companyCode") String cCode, @RequestBody Company company) throws IOException{
        
        if(cCode==null) return null;

        Company comp = companyRepository.findById(cCode).get();

        byte [] data = Base64.getDecoder().decode(company.getPicture());
        OutputStream os = new FileOutputStream(new File("C:\\Users\\DELL\\Documents\\Spring-Projects\\company\\src\\main\\resources\\static\\Images\\"+comp.getCompanyCode()+".jpeg"));
        os.write(data);
        os.close();

        comp.setPicture(comp.getCompanyCode()+".jpeg");

            comp.setName(company.getName());
            comp.setAddress(company.getAddress());
            comp.setLocality(company.getLocality());
            comp.setStreet(company.getStreet());
            comp.setCountry(company.getCountry());
            comp.setState(company.getState());
            comp.setCity(company.getCity());
            comp.setPinCode(company.getPinCode());
            comp.setRegistrationType(company.getRegistrationType());
            comp.setOrganisationType(company.getOrganisationType());
            comp.setContactNo1(company.getContactNo1());
            comp.setContactNo2(company.getContactNo2());
            comp.setFax(company.getFax());
            comp.setEmail(company.getEmail());
            comp.setWebsite(company.getWebsite());
            comp.setCompanyINR(company.getCompanyINR());
            comp.setPanNo(company.getPanNo());
            comp.setBin(company.getBin());
            comp.setCstNo(company.getCstNo());
            comp.setGstNo(company.getGstNo());
            comp.setIecCode(company.getIecCode());
            comp.setReg_cin(company.getReg_cin());
            comp.setOtherTax(company.getOtherTax());
            comp.setTinNo(company.getTinNo());
            comp.setSelfSealNo(company.getSelfSealNo());

            if(company.getBank()!=null)
            {
                CompanyBankDetails details = bankRepository.findById(company.getBank().get(0).getBankId()).get();
                details.setName(company.getBank().get(0).getName());
                details.setBranch(company.getBank().get(0).getBranch());
                details.setAddress(company.getBank().get(0).getAddress());
                details.setIfsc(company.getBank().get(0).getIfsc());
                details.setAccountNo(company.getBank().get(0).getAccountNo());
                details.setSwiftCode(company.getBank().get(0).getSwiftCode());
                details.setUpdateDate(java.time.LocalDate.now());
                bankRepository.save(details);
            }
            if(company.getiBankDetails()!=null)
            {
                IntermediateryBankDetail iBankDetails = iBankDetailsRepository.findById(company.getiBankDetails().get(0).getId()).get();
                iBankDetails.setBankName(company.getiBankDetails().get(0).getBankName());
                iBankDetails.setRoutedThrough(company.getiBankDetails().get(0).getRoutedThrough());
                iBankDetails.setRoutedName(company.getiBankDetails().get(0).getRoutedName());
                iBankDetails.setRoutedBranch(company.getiBankDetails().get(0).getRoutedBranch());
                iBankDetails.setRoutedAddress(company.getiBankDetails().get(0).getRoutedAddress());
                iBankDetails.setRoutedAccountNo(company.getiBankDetails().get(0).getRoutedAccountNo());
                iBankDetails.setRoutedIfsc(company.getiBankDetails().get(0).getRoutedIfsc());
                iBankDetails.setRoutedSwiftCode(company.getiBankDetails().get(0).getRoutedSwiftCode());
                iBankDetails.setRoutedUpdateDate(java.time.LocalDate.now());
                iBankDetailsRepository.save(iBankDetails);
            }

        companyRepository.save(comp);

        return companyRepository.findAll();
        
    }

    // Retrieving all recordes
    @GetMapping("/company")
    public List<Company>  getAll(){
        return companyRepository.findAll();
    }

    // Retrieving specific record by using id
    @GetMapping("/company/{id}")
    public Company getCompanyById(@PathVariable("id") String id){
        return companyRepository.findById(id).orElseThrow();
    }

    
}
