package com.farmer;

import com.farmer.model.FarmDetails;
import com.farmer.model.Farmer;
import com.farmer.model.Produce;
import com.farmer.repository.IFarmerRepository;
import com.farmer.service.IFarmerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
//        Produce produce=new
//        FarmDetails farm=new FarmDetails(20,"Black Soil","Kadapa",515002,)
//        Farmer farmer1=new Farmer("Ramayya",26,"Male","1234567891",)

    }
}
