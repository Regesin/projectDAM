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
    public ResponseEntity<List<FarmDetails>> addFarm(@RequestBody FarmDetails farmDetails) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding a Farm");
        farmDetailsService.addFarm(farmDetails);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @PutMapping("/farms")
    public ResponseEntity<List<FarmDetails>> updateFarm(@RequestBody FarmDetails farmDetails) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a Farm");
        farmDetailsService.updateFarm(farmDetails);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/farms/id/{farmId}")
    public ResponseEntity<List<FarmDetails>> deleteFarm(@PathVariable int farmId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a Farm");
        farmDetailsService.deleteFarm(farmId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    public ResponseEntity<List<FarmDetails>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms");
        List<FarmDetails> farmers = farmDetailsService.getAll();
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }

    public ResponseEntity<List<FarmDetails>> getByAcres(double acres) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms by acres Size");
        List<FarmDetails> farmers = farmDetailsService.getByAcres(acres);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }

    public ResponseEntity<List<FarmDetails>> getByCity(String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms in a City");
        List<FarmDetails> farmers = farmDetailsService.getByCity(city);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }

    public ResponseEntity<List<FarmDetails>> getBySoil(String soil) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms according to soil");
        List<FarmDetails> farmers = farmDetailsService.getBySoil(soil);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }

    public ResponseEntity<List<FarmDetails>> getBYZipcode(String zipcode) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms according to zipcode");
        List<FarmDetails> farmers = farmDetailsService.getBYZipcode(zipcode);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }

    public ResponseEntity<List<FarmDetails>> getByAcersCity(double acres, String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms based on Acers and City");
        List<FarmDetails> farmers = farmDetailsService.getByAcersCity(acres, city);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }

    public ResponseEntity<List<FarmDetails>> getByCitySoil(String city, String soil) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms in city and City");
        List<FarmDetails> farmers = farmDetailsService.getByCitySoil(city, soil);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }

    public ResponseEntity<List<FarmDetails>> getByZipcodeSoil(String zipcode, String soil) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all Farms in zipcode and soil");
        List<FarmDetails> farmers = farmDetailsService.getByZipcodeSoil(zipcode, soil);
        ResponseEntity<List<FarmDetails>> farmResponse = new ResponseEntity<>(farmers, headers, HttpStatus.OK);
        return farmResponse;
    }


}
