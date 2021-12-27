package com.company.service;/*
 *@created 27-12-2021/12/2021 - 03:38 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.company.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COMPANY-SERVICE", url = "http://localhost:8085/order-api")
public interface ICompanyFeignService {

    @GetMapping("/order/companyId/{companyId}")
    List<Order> getAllOrder(@PathVariable("companyId") int companyId);
}
