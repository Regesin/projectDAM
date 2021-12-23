package com.company.controllers;

import com.company.model.Company;
import com.company.service.CompanyServiceImpl;
import com.company.service.ICompanyService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company-api")
public class CompanyController {
    ICompanyService companyService;

    public CompanyController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/companies/add-company")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding Company");
      Company company1=   companyService.addCompany(company);
         return ResponseEntity.status(HttpStatus.CREATED).body(company1);

    }

    @PutMapping("/companies")
    public ResponseEntity<Void> updateCompany(@RequestBody Company company){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating company");
        companyService.updateCompany(company);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @DeleteMapping("/companies/id/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable("companyId") int companyId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting company");
        companyService.deleteCompany( companyId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("Deleted");
    }

    @GetMapping("/companies/id/{companyId}")
    public ResponseEntity<Company> getById(@PathVariable("companyId") int companyId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting by id");
        Company ncompany=companyService.getById(companyId);
        return ResponseEntity.ok().headers(headers).body(ncompany);
    }

    @GetMapping("/companies/all-companies")
    public ResponseEntity<List<Company>> getAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all companies");
        headers.add("info", "Company details");
        List<Company> companies = companyService.getAll();
        ResponseEntity<List<Company>> companyResponse = new ResponseEntity(companies, headers, HttpStatus.OK);
        return companyResponse;
    }

    @GetMapping("/companies/city/{city}")
    public ResponseEntity<List<Company>> getByCity(@PathVariable("city") String city){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all companies");
        headers.add("info", "Company details");
        List<Company> companies = companyService.getByCity(city);
        ResponseEntity<List<Company>> companyResponse = new ResponseEntity(companies, headers, HttpStatus.OK);
        return companyResponse;
    }
    @GetMapping("/companies/category/{category}")
    public ResponseEntity<List<Company>> getByCategory(@PathVariable("category") String category){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all companies");
        headers.add("info", "Company details");
        List<Company> companies = companyService.getByCategory(category);
        ResponseEntity<List<Company>> companyResponse = new ResponseEntity(companies, headers, HttpStatus.OK);
        return companyResponse;
    }





}
