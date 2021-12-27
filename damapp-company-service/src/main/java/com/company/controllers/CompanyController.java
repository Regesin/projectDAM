package com.company.controllers;

import com.company.model.*;
import com.company.service.ICompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company-api")
public class CompanyController {
    private Logger logger = LoggerFactory.getLogger(CompanyController.class);

    ICompanyService companyService;

    @Autowired
    public void setCompanyService(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/companies/add-company")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        logger.debug("inside add frame method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding Company");
        Company company1 = companyService.addCompany(company);
        logger.info(" add brand" + company1);
        return ResponseEntity.status(HttpStatus.CREATED).body(company1);

    }

    @PutMapping("/companies")
    public ResponseEntity<Void> updateCompany(@RequestBody Company company) {
        logger.debug("inside update frame method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating company");
        companyService.updateCompany(company);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @DeleteMapping("/companies/id/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable("companyId") int companyId) {
        logger.debug("inside delete frame method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting company");
        companyService.deleteCompany(companyId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("Deleted");
    }

    @GetMapping("/companies/id/{companyId}")
    public ResponseEntity<Company> getById(@PathVariable("companyId") int companyId) {
        logger.debug("inside id");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting by id");
        Company ncompany = companyService.getById(companyId);
        logger.info("got one " + ncompany);
        return ResponseEntity.ok().headers(headers).body(ncompany);
    }

    @GetMapping("/companies/all-companies")
    public ResponseEntity<List<Company>> getAll() {
        logger.debug("inside get all frame method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all companies");
        headers.add("info", "Company details");
        List<Company> companies = companyService.getAll();
        ResponseEntity<List<Company>> companyResponse = new ResponseEntity(companies, headers, HttpStatus.OK);
        logger.info("got list of companies " + companies);
        return companyResponse;
    }

    @GetMapping("/companies/city/{city}")
    public ResponseEntity<List<Company>> getByCity(@PathVariable("city") String city) {
        logger.debug("inside get frame by city");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all companies");
        headers.add("info", "Company details");
        List<Company> companies = companyService.getByCity(city);
        ResponseEntity<List<Company>> companyResponse = new ResponseEntity(companies, headers, HttpStatus.OK);
        logger.info("got list of companies " + companies);
        return companyResponse;
    }

    @GetMapping("/companies/category/{category}")
    public ResponseEntity<List<Company>> getByCategory(@PathVariable("category") String category) {
        logger.debug("inside get by category method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all companies");
        headers.add("info", "Company details");
        List<Company> companies = companyService.getByCategory(category);
        ResponseEntity<List<Company>> companyResponse = new ResponseEntity(companies, headers, HttpStatus.OK);
        logger.info("got list of companies " + companies);
        return companyResponse;
    }

    @GetMapping("/companies/state/{state}")
    public ResponseEntity<List<Company>> getByState(@PathVariable("state") String state) {
        logger.debug("inside get by state method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all companies");
        headers.add("info", "Company details");
        List<Company> companies = companyService.getByState(state);
        ResponseEntity<List<Company>> companyResponse = new ResponseEntity(companies, headers, HttpStatus.OK);
        logger.info("got list of companies " + companies);
        return companyResponse;
    }

    @GetMapping("/companies/category/{category}/city/{city}")
    public ResponseEntity<List<Company>> getByCategoryAndCity(@PathVariable("category") String category, @PathVariable("city") String city) {
        logger.debug("inside get by category and city method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all companies");
        headers.add("info", "Company details");
        List<Company> companies = companyService.getByCategoryAndCity(category, city);
        ResponseEntity<List<Company>> companyResponse = new ResponseEntity(companies, headers, HttpStatus.OK);
        logger.info("got list of companies " + companies);
        return companyResponse;
    }

    @GetMapping("/companies/location/{location}")
    public ResponseEntity<List<Company>> getByLocation(@PathVariable("location") String location) {
        logger.debug("inside get by location method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all companies");
        headers.add("info", "Company details");
        List<Company> companies = companyService.getByLocation(location);
        ResponseEntity<List<Company>> companyResponse = new ResponseEntity(companies, headers, HttpStatus.OK);
        logger.info("got list of companies " + companies);
        return companyResponse;
    }

    @GetMapping("/companies/order/companyId/{companyId}")
    public ResponseEntity<List<Order>> getByCompany(@PathVariable("companyId") int companyId) {
        logger.debug("Get All By company");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Orders details");
        headers.add("info", "Getting Orders details");
        List<Order> orders = companyService.getByCompanyId(companyId);
        logger.info("All" + orders);
        ResponseEntity<List<Order>> orderResponse = new ResponseEntity(orders, headers, HttpStatus.OK);
        return orderResponse;
    }




}
