package com.farmer.controller;/*
 *@created 23-12-2021/12/2021 - 12:30 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.farmer.exceptions.FarmerNotFoundException;
import com.farmer.model.Farmer;
import com.farmer.service.IFarmerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("farmer-api")
public class FarmerController {

    private final IFarmerService farmerService;

    public FarmerController(IFarmerService farmerService) {
        this.farmerService = farmerService;
    }

    private final Logger logger = LoggerFactory.getLogger(FarmerController.class);

    @PostMapping("/farmers")
    ResponseEntity <String>addFarmer(@RequestBody Farmer farmer){
        logger.debug("added farmer");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding a Farmer");
        farmerService.addFarmer(farmer);
        logger.info("Farmer Added");
        return ResponseEntity.status(HttpStatus.CREATED).body("added");
    }

    @PutMapping("/farmers")
    ResponseEntity <String>updateFarmer(@RequestBody Farmer farmer) {
        logger.debug("updated farmer");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a Farmer");
        farmerService.updateFarmer(farmer);
        logger.info("updated");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/farmers/{farmerId}")
    ResponseEntity <Void> deleteFarmer(@PathVariable("farmerId") int farmerId) {
        logger.debug("delete farmer");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a Farmer");
        farmerService.deleteFarmer(farmerId);
        logger.info("deleted");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @GetMapping("/farmers")
    ResponseEntity<List<Farmer>> getAll(){
        logger.debug("get all");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farmers");
        List<Farmer> farmers = farmerService.getAll();
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        logger.info("all"+farmers);
        return farmerResponse;
    }

    @GetMapping("/farmers/id/{farmerId}")
    ResponseEntity<List<Farmer>> getById(@PathVariable("farmerId") int farmerId) {
        logger.debug("farmer id");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting a Farmer By Id");
        Farmer farmer = farmerService.getById(farmerId);
        logger.info("got one"+farmer);
        return (ResponseEntity<List<Farmer>>) new ResponseEntity(farmer, headers, HttpStatus.OK);
    }

    @GetMapping("/farmers/name/{name}")
    ResponseEntity<List<Farmer>> getByName(@PathVariable("name") String name) {
        logger.debug("farmer name");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmers names");
        List<Farmer> farmers = farmerService.getByName(name);
        logger.info("got farmer name"+farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, HttpStatus.OK);
        return farmerResponse;
    }

    @GetMapping("/farmers/mobileNo/{mobileNo}")
    ResponseEntity<List<Farmer>> getByMobile(@PathVariable("mobileNo") String mobileNo) {
        logger.debug("mobile number");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmers Mobile Number");
        List<Farmer> farmers = farmerService.getByMobile(mobileNo);
        logger.info("got mobile number"+farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, HttpStatus.OK);
        return farmerResponse;
    }

    @GetMapping("/farmers/gender/{gender}")
    ResponseEntity<List<Farmer>> getByGender(@PathVariable("gender") String gender) {
        logger.debug("Gender");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmers by Gender");
        List<Farmer> farmers = farmerService.getByGender(gender);
        logger.info("got gender"+farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, HttpStatus.OK);
        return farmerResponse;
    }

    @GetMapping("/farmers/age/{age}")
    ResponseEntity<List<Farmer>> getByAge(@PathVariable("age") int age) {
        logger.debug("age");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmers based on Age");
        List<Farmer> farmers = farmerService.getByAge(age);
        logger.info("got age"+farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, HttpStatus.OK);
        return farmerResponse;
    }

    @GetMapping("/farmers/age/start/{start}/end/{end}")
    ResponseEntity<List<Farmer>> getByAgeBetween(@PathVariable("start") int start, @PathVariable("end") int end) {
        logger.debug("Framer age between");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmers Age in Between ");
        List<Farmer> farmers = farmerService.getByAgeBetween(start,end);
        logger.info("got farmer age between"+farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, HttpStatus.OK);
        return farmerResponse;
    }

    @GetMapping("/orders/farmers/id/{farmerId}")
    ResponseEntity<List<Object>> getOrdersByFarmerId(@PathVariable("farmerId") int farmerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmers Age in Between ");
        List<Object> objects = farmerService.getByFarmerId(farmerId);
        ResponseEntity<List<Object>> objectResponse = new ResponseEntity(objects, HttpStatus.OK);
        return objectResponse;
    }



}
