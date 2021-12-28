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

    /**
     *
     * @param farmer
     * @return
     */
    @PostMapping("/farmers")
    public ResponseEntity<String> addFarmer(@RequestBody Farmer farmer){
        logger.debug("inside add Farmer method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding farmer");
        farmerService.addFarmer(farmer);
        logger.info("Farmer Added");
        return ResponseEntity.status(HttpStatus.CREATED).body("Added");
    }

    /**
     *
     * @param farmer
     * @return
     */
    @PutMapping("/farmers")
    public ResponseEntity<Void> updateFarmer(@RequestBody Farmer farmer) {
        logger.debug("inside updated a Farmer method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating Farmer");
        farmerService.updateFarmer(farmer);
        logger.info("Farmer updated");
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     *
     * @param farmerId
     * @return
     */
    @DeleteMapping("/farmers/{farmerId}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable("farmerId") int farmerId) {
        logger.debug("delete a Farmer method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting Farmer");
        farmerService.deleteFarmer(farmerId);
        logger.info("Farmer deleted");
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     *
     * @return
     */
    @GetMapping("/farmers")
    public ResponseEntity<List<Farmer>> getAll(){
        logger.debug("Get All");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmer details");
        headers.add("info", "Getting Farmer details");
        List<Farmer> farmers = farmerService.getAll();
        logger.info("All" + farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, headers, HttpStatus.OK);
        return farmerResponse;
    }

    /**
     *
     * @param farmerId
     * @return
     */
    @GetMapping("/farmers/id/{farmerId}")
    public ResponseEntity<Farmer> getById(@PathVariable("farmerId") int farmerId) {
        logger.debug("Id method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting By Farmer id");
        Farmer farmer = farmerService.getById(farmerId);
        logger.info("bidId" + farmer);
        return ResponseEntity.ok().headers(headers).body(farmer);    }

    /**
     *
     * @param name
     * @return
     */
    @GetMapping("/farmers/name/{name}")
    public ResponseEntity<List<Farmer>> getByName(@PathVariable("name") String name) {
        logger.debug("Get By Name");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmer details");
        headers.add("info", "Getting Farmer details");
        List<Farmer> farmers = farmerService.getByName(name);
        logger.info("All" + farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, headers, HttpStatus.OK);
        return farmerResponse;
    }

    /**
     *
     * @param mobileNo
     * @return
     */
    @GetMapping("/farmers/mobileNo/{mobileNo}")
    public ResponseEntity<List<Farmer>> getByMobile(@PathVariable("mobileNo") String mobileNo) {
        logger.debug("Get By MobileNo");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmer details");
        headers.add("info", "Getting Farmer details");
        List<Farmer> farmers = farmerService.getByMobile(mobileNo);
        logger.info("All" + farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, headers, HttpStatus.OK);
        return farmerResponse;
    }

    /**
     *
     * @param gender
     * @return
     */
    @GetMapping("/farmers/gender/{gender}")
    ResponseEntity<List<Farmer>> getByGender(@PathVariable("gender") String gender) {
        logger.debug("Get By Gender");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmer details");
        headers.add("info", "Getting Farmer details");
        List<Farmer> farmers = farmerService.getByGender(gender);
        logger.info("All" + farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, headers, HttpStatus.OK);
        return farmerResponse;
    }

    /**
     *
     * @param age
     * @return
     */
    @GetMapping("/farmers/age/{age}")
    ResponseEntity<List<Farmer>> getByAge(@PathVariable("age") int age) {
        logger.debug("Get By Age");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmer details");
        headers.add("info", "Getting Farmer details");
        List<Farmer> farmers = farmerService.getByAge(age);
        logger.info("All" + farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, headers, HttpStatus.OK);
        return farmerResponse;
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/farmers/age/start/{start}/end/{end}")
    ResponseEntity<List<Farmer>> getByAgeBetween(@PathVariable("start") int start, @PathVariable("end") int end) {
        logger.debug("Get By Name");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Farmer details");
        headers.add("info", "Getting Farmer details");
        List<Farmer> farmers = farmerService.getByAgeBetween(start, end);
        logger.info("All" + farmers);
        ResponseEntity<List<Farmer>> farmerResponse = new ResponseEntity(farmers, headers, HttpStatus.OK);
        return farmerResponse;
    }

}
