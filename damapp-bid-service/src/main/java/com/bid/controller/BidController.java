package com.bid.controller;/*
 *@created 27-12-2021/12/2021 - 02:04 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.bid.exceptions.BidNotFoundException;
import com.bid.model.Bid;
import com.bid.service.IBidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bid-api")
public class BidController {

    private final IBidService bidService;

    public BidController(IBidService bidService) {
        this.bidService = bidService;
    }

    private final Logger logger = LoggerFactory.getLogger(BidController.class);

    @PostMapping("/bids")
    public ResponseEntity<String> addBid(@RequestBody Bid bid) {
        logger.debug("inside add Bid method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding Bid");
        bidService.addBid(bid);
        logger.info("Bid Added");
        return ResponseEntity.status(HttpStatus.CREATED).body("Added");
    }

    @PutMapping("/bids")
    public ResponseEntity<Void> updateBid(@RequestBody Bid bid) {
        logger.debug("inside updated a Bid method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating Bid");
        bidService.updateBid(bid);
        logger.info("Bid updated");
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/bids/bidId/{bidId}")
    public ResponseEntity<Void> deleteBid(@PathVariable("bidId") int bidId) {
        logger.debug("delete a Bid method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting Bid");
        bidService.deleteByid(bidId);
        logger.info("Bid deleted");
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/bids/id/{bidId}")
    public ResponseEntity<Bid> getById(@PathVariable("bidId") int bidId) {
        logger.debug("Id method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting By Bid id");
        Bid bids = bidService.getById(bidId);
        logger.info("bidId" + bids);
        return ResponseEntity.ok().headers(headers).body(bids);
    }

    @GetMapping("/bids")
    public ResponseEntity<List<Bid>> getAll() {
        logger.debug("Get All");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Bid details");
        headers.add("info", "Getting Bid details");
        List<Bid> bids = bidService.getAll();
        logger.info("All" + bids);
        ResponseEntity<List<Bid>> bidResponse = new ResponseEntity(bids, headers, HttpStatus.OK);
        return bidResponse;
    }

    @GetMapping("/bids/winner/{bidId}")
    public ResponseEntity<Bid> getWinner(@PathVariable("bidId") int bidId) {
        logger.debug("Bid Winner");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Bid details");
        headers.add("info", "Getting Bid details");
        Bid bids = bidService.getWinner(bidId);
        logger.info("bidId" + bids);
        return ResponseEntity.ok().headers(headers).body(bids);
    }

    @GetMapping("/bids/addBid/{bidId}")
    public ResponseEntity addOrder(@PathVariable("bidId") int produceId) {
        logger.debug("inside add Order method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding Bid to Order");
        bidService.addOrder(produceId);
        logger.info("Bid Added to Order");
        return ResponseEntity.status(HttpStatus.CREATED).body("Added");
    }


}
