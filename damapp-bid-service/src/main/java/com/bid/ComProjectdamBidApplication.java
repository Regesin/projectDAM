package com.bid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ComProjectdamBidApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComProjectdamBidApplication.class, args);
    }

}
