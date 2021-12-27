package com.order.controller;/*
 *@created 27-12-2021/12/2021 - 03:13 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.order.model.Order;
import com.order.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order-api")
public class orderController {

    private final IOrderService orderService;

    public orderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    private final Logger logger = LoggerFactory.getLogger(orderController.class);


    @GetMapping("/orders/id/{orderId}")
    public ResponseEntity<Order> getById(@PathVariable("orderId") int orderId) {
        logger.debug("Order method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting By Order id");
        Order orders = orderService.getById(orderId);
        logger.info("bidId" + orders);
        return ResponseEntity.ok().headers(headers).body(orders);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAll() {
        logger.debug("Get All");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Orders details");
        headers.add("info", "Getting Orders details");
        List<Order> orders = orderService.getAll();
        logger.info("All" + orders);
        ResponseEntity<List<Order>> orderResponse = new ResponseEntity(orders, headers, HttpStatus.OK);
        return orderResponse;
    }


    @GetMapping("/order/companyId/{companyId}")
    public ResponseEntity<List<Order>> getByCompanyId(@PathVariable("companyId") int companyId){
        logger.debug("Get All By company");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Orders details");
        headers.add("info", "Getting Orders details");
        List<Order> orders = orderService.getByCompanyId(companyId);
        logger.info("All" + orders);
        ResponseEntity<List<Order>> orderResponse = new ResponseEntity(orders, headers, HttpStatus.OK);
        return orderResponse;
    }



}
