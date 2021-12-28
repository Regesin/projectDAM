package com.farmer.controller;/*
 *@created 23-12-2021/12/2021 - 03:02 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.farmer.model.FarmDetails;
import com.farmer.service.IFarmDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("farm-api")
public class FarmController {

    private final IFarmDetailsService farmDetailsService;

    public FarmController(IFarmDetailsService farmDetailsService) {
        this.farmDetailsService = farmDetailsService;
    }

    private final Logger logger = LoggerFactory.getLogger(FarmController.class);

    @PostMapping("/farms")
    public ResponseEntity<String> addFarm(@RequestBody FarmDetails farmDetails) {
        logger.debug("inside farm method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding a Farm");
        farmDetailsService.addFarm(farmDetails);
        logger.info("Farm Added");
        return ResponseEntity.status(HttpStatus.CREATED).body("added");
    }

    @PutMapping("/farms")
    public ResponseEntity<Void> updateFarm(@RequestBody FarmDetails farmDetails) {
        logger.debug("inside updated a farm method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a Farm");
        farmDetailsService.updateFarm(farmDetails);
        logger.info("produce updated");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @DeleteMapping("/farms/id/{farmId}")
    public ResponseEntity<Void> deleteFarm(@PathVariable int farmId) {
        logger.debug("delete a farm method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a Farm");
        farmDetailsService.deleteFarm(farmId);
        logger.info("deleted");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }
    @GetMapping("/farms/all")
    public ResponseEntity<List<FarmDetails>> getAll() {
        logger.debug("Get All");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms");
        List<FarmDetails> farmers = farmDetailsService.getAll();
        logger.info("All"+farmers);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }
    @GetMapping("/farms/acres/{acres}")
    public ResponseEntity<List<FarmDetails>> getByAcres(@PathVariable("acres") double acres) {
        logger.debug("farm acres");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms by acres Size");
        List<FarmDetails> farmers = farmDetailsService.getByAcres(acres);
        logger.info("acres"+farmers);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }
    @GetMapping("/farms/city/{city}")
    public ResponseEntity<List<FarmDetails>> getByCity(@PathVariable("city") String city) {
        logger.debug("farm city");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms in a City");
        List<FarmDetails> farmers = farmDetailsService.getByCity(city);
        logger.info("city"+farmers);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }
    @GetMapping("/farms/soil/{soil}")
    public ResponseEntity<List<FarmDetails>> getBySoil(@PathVariable("soil") String soil) {
        logger.debug("farm soil");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms according to soil");
        List<FarmDetails> farmers = farmDetailsService.getBySoil(soil);
        logger.info("soil"+farmers);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }
    @GetMapping("/farms/zipcode/{zipcode}")
    public ResponseEntity<List<FarmDetails>> getBYZipcode(@PathVariable("zipcode") String zipcode) {
        logger.debug("zipcode ");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms according to zipcode");
        List<FarmDetails> farmers = farmDetailsService.getBYZipcode(zipcode);
        logger.info("zipcode"+farmers);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }
    @GetMapping("/farms/acres/{acres}/city/{city}")
    public ResponseEntity<List<FarmDetails>> getByAcersCity(@PathVariable("acres") double acres, @PathVariable("city") String city) {
        logger.debug("acres city");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms based on Acers and City");
        List<FarmDetails> farmers = farmDetailsService.getByAcersCity(acres, city);
        logger.info("acres and city"+farmers);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }
    @GetMapping("/farms/city/{city}/soil/{soil}")
    public ResponseEntity<List<FarmDetails>> getByCitySoil(@PathVariable("city") String city, @PathVariable("soil") String soil) {
        logger.debug("city and soil");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms in city and City");
        List<FarmDetails> farmers = farmDetailsService.getByCitySoil(city, soil);
        logger.info("city and soil"+farmers);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }
    @GetMapping("/farms/zipcode/{zipcode}/soil/{soil}")
    public ResponseEntity<List<FarmDetails>> getByZipcodeSoil(@PathVariable("zipcode") String zipcode, @PathVariable("soil") String soil) {
        logger.debug("zipcode and soil");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms in zipcode and soil");
        List<FarmDetails> farmers = farmDetailsService.getByZipcodeSoil(zipcode, soil);
        logger.info("zipcode and soil"+farmers);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }


}
