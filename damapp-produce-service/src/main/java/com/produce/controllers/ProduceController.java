package com.produce.controllers;

import com.produce.model.Produce;
import com.produce.service.IProduceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produce-api")
public class ProduceController {
    IProduceService produceService;
    private Logger logger = LoggerFactory.getLogger(ProduceController.class);

    public ProduceController(IProduceService produceService) {
        this.produceService = produceService;
    }

    @PostMapping("/produces")
    public ResponseEntity<String> addProduce(@RequestBody Produce produce) {
        logger.debug("inside add produce method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding produce");
        produceService.addProduce(produce);
        logger.info("Produce Added");
        return ResponseEntity.status(HttpStatus.CREATED).body("added");
    }

    @PutMapping("/produces")
    public ResponseEntity<Void> updateProduce(@RequestBody Produce produce) {
        logger.debug("inside updated a produce method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating produce");
        produceService.updateProduce(produce);
        logger.info("produce updated");
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/produces/id/{produceId}")
    public ResponseEntity<Void> deleteProduce(@PathVariable("produceId") int produceId) {
        logger.debug("delete a produce method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting produce");
        produceService.deleteProduce(produceId);
        logger.info("produce deleted");
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/produces/id/{produceId}")
    public ResponseEntity<Produce> getById(@PathVariable("produceId") int produceId) {
        logger.debug("Id method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting By produce id");
        Produce produces = produceService.getById(produceId);
        logger.info("produce Id" + produces);
        return ResponseEntity.ok().headers(headers).body(produces);
    }

    @GetMapping("/produces/all")
    public ResponseEntity<List<Produce>> getAll() {
        logger.debug("Get All");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = produceService.getAll();
        logger.info("All" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }

    @GetMapping("/produces/kind/{kind}")
    public ResponseEntity<List<Produce>> getByKind(@PathVariable("kind") String kind) {
        logger.debug("produce Kind");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = produceService.getByKind(kind);
        logger.info("produce Kind" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }

    @GetMapping("/produces/produce/{produce}")
    public ResponseEntity<List<Produce>> getByProduce(@PathVariable("produce") String produce) {
        logger.debug("get produce");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = produceService.getByProduce(produce);
        logger.info("got produce" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }

    @GetMapping("/produces/type/{type}")
    public ResponseEntity<List<Produce>> getByType(@PathVariable("type") String type) {
        logger.debug("produce Type");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = produceService.getByType(type);
        logger.info("produce Type" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;

    }

    @GetMapping("/produces/produce/{produce}/quintal/{quintal}/bidPrice/{bidPrice}")
    public ResponseEntity<List<Produce>> getByProQuiBid(@PathVariable("produce") String produce, @PathVariable("quintal") double quintal, @PathVariable("bidPrice") double bidPrice) {
        logger.debug("Get produce Quintal Bid");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = produceService.getByProQuiBid(produce, quintal, bidPrice);
        logger.info("produce quintal Bid" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;
    }

    @GetMapping("produces/produce/{produce}/fertilizer/{fertilizer}")
    public ResponseEntity<List<Produce>> getByProFerti(@PathVariable("produce") String produce, @PathVariable("fertilizer") String fertilizer) {
        logger.debug("Get produce fertilizer");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce details");
        headers.add("info", "Getting produce details");
        List<Produce> produces = produceService.getByProFerti(produce, fertilizer);
        logger.info("produce fertilizer" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produceResponse;

    }


    @GetMapping("produces/startdate/{startdate}")
    public List<Produce> getByStartDate(@PathVariable("startdate") String startdate) {
        logger.debug("Get Date");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce date");
        headers.add("info", "Getting produce date");
        List<Produce> produces = produceService.getByStartDate(startdate);
        logger.info("Date" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produces;
    }

    @GetMapping("produces/enddate/{enddate}")
    public List<Produce> getByEndDate(@PathVariable("enddate") String enddate) {
        logger.debug("Get Date");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce date");
        headers.add("info", "Getting produce date");
        List<Produce> produces = produceService.getByStartDate(enddate);
        logger.info("Date" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produces;
    }

    @GetMapping("produces/price/{price}")
    public List<Produce> getByBidPriceLessThan(@PathVariable("price") double bidPrice) {
        logger.debug("Get price less");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce date");
        headers.add("info", "Getting produce date");
        List<Produce> produces = produceService.getByBidPriceLessThan(bidPrice);
        logger.info("price less" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produces;
    }

    @GetMapping("produces/startprice/{startprice}/endprice/{endprice}")
    public List<Produce> getByBidPriceBetween(@PathVariable("startprice") double startPrice,@PathVariable("endprice") double endPrice) {
        logger.debug("Get Price btw");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce date");
        headers.add("info", "Getting produce date");
        List<Produce> produces = produceService.getByBidPriceBetween(startPrice,endPrice);
        logger.info("Price btw" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produces;
    }

    @GetMapping("produces/type/{type}/produce/{produce}")
    public List<Produce> getByTypeProduce(@PathVariable("type") String type, @PathVariable("produce") String produce) {
        logger.debug("Get Price btw");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting produce date");
        headers.add("info", "Getting produce date");
        List<Produce> produces = produceService.getByTypeProduce(type, produce);
        logger.info("Price btw" + produces);
        ResponseEntity<List<Produce>> produceResponse = new ResponseEntity(produces, headers, HttpStatus.OK);
        return produces;


    }
}
