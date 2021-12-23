package com.farmer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ComProjectdamFarmerApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ComProjectdamFarmerApplication.class, args);
    }


}
