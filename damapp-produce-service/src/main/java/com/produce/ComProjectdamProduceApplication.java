package com.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ComProjectdamProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComProjectdamProduceApplication.class, args);
    }

}
