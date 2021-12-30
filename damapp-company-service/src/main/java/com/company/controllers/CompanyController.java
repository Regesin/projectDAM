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
        logger.debug("Get company By company id");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Orders details");
        headers.add("info", "Getting Orders details");
        List<Order> orders = companyService.getByCompanyId(companyId);
        logger.info("All" + orders);
        ResponseEntity<List<Order>> orderResponse = new ResponseEntity(orders, headers, HttpStatus.OK);
        return orderResponse;
    }

    @GetMapping("/companies/produces/kind/{kind}")
    public ResponseEntity<List<Produce>> getByProduceKind(@PathVariable("kind") String kind) {
        logger.debug("Get produces by kind");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByKind(kind);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }
    @GetMapping("/companies/produces/produce/{produce}")
    public ResponseEntity<List<Produce>> getByProduce(@PathVariable("produce") String produce) {
        logger.debug("Get produces by produce");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByProduce(produce);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }

    @GetMapping("/companies/produces/type/{type}")
    public ResponseEntity<List<Produce>> getByProduceType(@PathVariable("type") String type) {
        logger.debug("Get produces by type");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByType(type);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }
    @GetMapping("/companies/produces/produce/{produce}/quintal/{quintal}/bidPrice/{bidPrice}")
    public ResponseEntity<List<Produce>> getByProQuiBid(@PathVariable("produce") String produce, @PathVariable("quintal") double quintal, @PathVariable("bidPrice") double bidPrice) {
        logger.debug("Get produces by produce,quintal,bidprice");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByProQuiBid(produce,quintal,bidPrice);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }
    @GetMapping("/companies/produces/produce/{produce}/fertilizer/{fertilizer}")
    public ResponseEntity<List<Produce>> getByProFerti(@PathVariable("produce") String produce, @PathVariable("fertilizer") String fertilizer) {
        logger.debug("Get produces by produce and fertilizer");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByProFerti(produce,fertilizer);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }

       @GetMapping("/companies/produces/startdate/{startdate}")
    public ResponseEntity<List<Produce>> getByStartDate(@PathVariable("startdate") String startdate) {
        logger.debug("Get produces by startdate");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByStartDate(startdate);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }

    @GetMapping("/companies/produces/enddate/{enddate}")
    public ResponseEntity<List<Produce>> getByEndDate(@PathVariable("enddate") String enddate) {
        logger.debug("Get produces by enddate");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByEndDate(enddate);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }
    @GetMapping("/companies/produces/price/{price}")
    public ResponseEntity<List<Produce>> getByPriceLessThan(@PathVariable("price") double price) {
        logger.debug("Get produces by price");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByPriceLessThan(price);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }
    @GetMapping("/companies/produces/startprice/{startprice}/endprice/{endprice}")
    public ResponseEntity<List<Produce>> getByPriceBetween(@PathVariable("startprice") double startPrice,@PathVariable("endprice") double endPrice) {
        logger.debug("Get produces by price between");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByPriceBetween(startPrice,endPrice);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }
    @GetMapping("/companies/produces/type/{type}/produce/{produce}")
    public ResponseEntity<List<Produce>> getByTypeProduce(@PathVariable("type") String type, @PathVariable("produce") String produce) {
        logger.debug("Get produces by type and produce");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = companyService.getByTypeProduce(type,produce);
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }

}
