package com.produce;

import com.produce.model.Fertilizer;
import com.produce.model.Produce;
import com.produce.model.Type;
import com.produce.service.IProduceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableEurekaClient
public class SpringProjectdamProduceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectdamProduceApplication.class, args);
    }
     IProduceService produceService;

    public SpringProjectdamProduceApplication(IProduceService produceService) {
        this.produceService = produceService;
    }

    @Override
    public void run(String... args) throws Exception {
        String stringStartDateTime="31-12-2021 04:20";
        String stringEndDateTime="31-12-2021 04:40";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime startDateTime=LocalDateTime.parse(stringStartDateTime,formatter);
        LocalDateTime endDateTime=LocalDateTime.parse(stringEndDateTime,formatter);
        Produce produce=new Produce("Grapes", Fertilizer.ORGANIC,20,20000,"Sweet Jubliee", Type.NORMAl,startDateTime,endDateTime);
        produceService.addProduce(produce);



    }
}
