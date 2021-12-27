package com.farmer;

import com.farmer.model.*;
import com.farmer.repository.IFarmerRepository;
import com.farmer.service.IFarmDetailsService;
import com.farmer.service.IFarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableEurekaClient
public class SpringFarmerApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(SpringFarmerApplication.class, args);
    }
     IFarmerService farmerService;
    @Autowired
    public void setFarmerService(IFarmerService farmerService) {
        this.farmerService = farmerService;
    }

    IFarmDetailsService farmDetailsService;
    @Autowired
    public void setFarmDetailsService(IFarmDetailsService farmDetailsService) {
        this.farmDetailsService = farmDetailsService;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new  RestTemplate();
    }



    @Override
    public void run(String... args) throws Exception {

        Produce produce1=farmDetailsService.getByProduceId(1);

        Produce produce2=farmDetailsService.getByProduceId(2);

        Set producesSet1=new HashSet<>(Arrays.asList(produce1));

        Set producesSet2=new HashSet<>(Arrays.asList(produce2));

        FarmDetails farmDetails1=new FarmDetails(2.5,"Red","Kadapa",515008,producesSet1);

        FarmDetails farmDetails2=new FarmDetails(2.5,"Red","Kadapa",515008,producesSet2);

        Set farmDetailsSet1=new HashSet<>(Arrays.asList(farmDetails1));

        Set farmDetailsSet2=new HashSet<>(Arrays.asList(farmDetails2));


        Farmer farmer1=new Farmer("Mallika",20,Gender.F,"8976521987",farmDetailsSet1);
        Farmer farmer2=new Farmer("Divya",20,Gender.F,"8976421987",farmDetailsSet2);

        farmerService.addFarmer(farmer1);
        farmerService.addFarmer(farmer2);
       


    }
}
