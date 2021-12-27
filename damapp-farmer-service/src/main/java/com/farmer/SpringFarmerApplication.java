package com.farmer;

import com.farmer.model.*;
import com.farmer.repository.IFarmerRepository;
import com.farmer.service.IFarmerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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

    public SpringFarmerApplication(IFarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @Override
    public void run(String... args) throws Exception {
//// 1) Produce
//        String stringStartDateTime = "26-12-2021 10:20";
//        String stringEndDateTime = "26-12-2021 10:40";
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//        LocalDateTime startDateTime = LocalDateTime.parse(stringStartDateTime, formatter);
//        LocalDateTime endDateTime = LocalDateTime.parse(stringEndDateTime, formatter);
//        Produce produce = new Produce("Grapes", Fertilizer.ORGANIC, 20, 20000, "Sweet Jubliee", Type.NORMAl, startDateTime, endDateTime);
//
//
//        // 2) produce
//
//        String stringStartDateTime2 = "28-12-2021 04:20";
//        String stringEndDateTime2 = "28-12-2021 04:40";
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//        LocalDateTime startDateTime2 = LocalDateTime.parse(stringStartDateTime, formatter);
//        LocalDateTime endDateTime2 = LocalDateTime.parse(stringEndDateTime, formatter);
//        Produce produce2 = new Produce("Apple", Fertilizer.ORGANIC, 40, 15000, "Kashmir", Type.HYBRID, startDateTime, endDateTime);
//
//        // 3) produce
//
//        String stringStartDateTime3 = "29-12-2021 03:20";
//        String stringEndDateTime3 = "29-12-2021 03:50";
//        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//        LocalDateTime startDateTime3 = LocalDateTime.parse(stringStartDateTime, formatter);
//        LocalDateTime endDateTime3 = LocalDateTime.parse(stringEndDateTime, formatter);
//        Produce produce3 = new Produce("Mirchi", Fertilizer.INORGANIC, 10, 18000, "Guntur Chilli", Type.NORMAl, startDateTime, endDateTime);
//
//        // 4) produce
//
//        String stringStartDateTime4 = "31-12-2021 05:20";
//        String stringEndDateTime4 = "31-12-2021 05:40";
//        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//        LocalDateTime startDateTime4 = LocalDateTime.parse(stringStartDateTime, formatter);
//        LocalDateTime endDateTime4 = LocalDateTime.parse(stringEndDateTime, formatter);
//        Produce produce4 = new Produce("Onions", Fertilizer.INORGANIC, 50, 5000, "White Onion", Type.HYBRID, startDateTime, endDateTime);
//
//        // Set of produces
//
//        Set<Produce> produceSet1 = new HashSet<>(Arrays.asList(produce));
//        Set<Produce> produceSet2 = new HashSet<>(Arrays.asList(produce2));
//        Set<Produce> produceSet3 = new HashSet<>(Arrays.asList(produce3));
//        Set<Produce> produceSet4 = new HashSet<>(Arrays.asList(produce4));
//
//        // ---------------------------------
//
//
//        FarmDetails farm1 = new FarmDetails(2.9, "black", "Khammam", 507154, produceSet1);
//        FarmDetails farm2 = new FarmDetails(11.4, "red", "Anantapur", 515001, produceSet2);
//        FarmDetails farm3 = new FarmDetails(29.4, "clay", "Kadapa", 516432, produceSet3);
//        FarmDetails farm4 = new FarmDetails(52, "black", "Khammam", 507154, produceSet4);
//
//
//        Set<FarmDetails> farmDetails1 = new HashSet<>(Arrays.asList(farm1));
//        Set<FarmDetails> farmDetails2 = new HashSet<>(Arrays.asList(farm2));
//        Set<FarmDetails> farmDetails3 = new HashSet<>(Arrays.asList(farm3));
//        Set<FarmDetails> farmDetails4 = new HashSet<>(Arrays.asList(farm4));
//
//        //------------------
//
//
//
//        Farmer farmer1 = new Farmer("Mallika", 22, Gender.F, "8639845412", farmDetails1);
//        Farmer farmer2 = new Farmer("Divya", 25, Gender.F, "9848754578", farmDetails2);
//        Farmer farmer3 = new Farmer("Arun",21 , Gender.M, "7515452136", farmDetails3);
//        Farmer farmer4 = new Farmer("Raj", 28, Gender.M, "8745129654", farmDetails4);
//
//
//        farmerService.addFarmer(farmer1);
//        farmerService.addFarmer(farmer2);
//        farmerService.addFarmer(farmer3);
//        farmerService.addFarmer(farmer4);
//

    }
}
