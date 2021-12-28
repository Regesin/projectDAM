package com.order;

import com.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ComProjectdamOrderApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ComProjectdamOrderApplication.class, args);
    }

    @Autowired
    IOrderService orderService;

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
//        orderService.getByFarmerId(4).forEach(System.out::println);
//        orderService.getByFarmerId(1).forEach();
    }
}
