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
        String stringStartDateTime="26-12-2021 10:20";
        String stringEndDateTime="26-12-2021 10:40";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime startDateTime=LocalDateTime.parse(stringStartDateTime,formatter);
        LocalDateTime endDateTime=LocalDateTime.parse(stringEndDateTime,formatter);
        Produce produce=new Produce("Grapes", Fertilizer.ORGANIC,20,20000,"Sweet Jubliee", Type.NORMAl,startDateTime,endDateTime);
       // produceService.addProduce(produce);

        String stringStartDateTime1="27-12-2021 11:00";
        String stringEndDateTime1="27-12-2021 11:40";
        DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime startDateTime1=LocalDateTime.parse(stringStartDateTime,formatter);
        LocalDateTime endDateTime1=LocalDateTime.parse(stringEndDateTime,formatter);
        Produce produce1=new Produce("Tomatoes", Fertilizer.ORGANIC,30,20000,"Roma", Type.HYBRID,startDateTime,endDateTime);
       // produceService.addProduce(produce1);

        String stringStartDateTime2="28-12-2021 04:20";
        String stringEndDateTime2="28-12-2021 04:40";
        DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime startDateTime2=LocalDateTime.parse(stringStartDateTime,formatter);
        LocalDateTime endDateTime2=LocalDateTime.parse(stringEndDateTime,formatter);
        Produce produce2=new Produce("Apple", Fertilizer.ORGANIC,40,15000,"Kashmir", Type.HYBRID,startDateTime,endDateTime);
      //  produceService.addProduce(produce2);

        String stringStartDateTime3="29-12-2021 03:20";
        String stringEndDateTime3="29-12-2021 03:50";
        DateTimeFormatter formatter3=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime startDateTime3=LocalDateTime.parse(stringStartDateTime,formatter);
        LocalDateTime endDateTime3=LocalDateTime.parse(stringEndDateTime,formatter);
        Produce produce3=new Produce("Mirchi", Fertilizer.INORGANIC,10,18000,"Guntur Chilli", Type.NORMAl,startDateTime,endDateTime);
      //  produceService.addProduce(produce3);

        String stringStartDateTime4="31-12-2021 05:20";
        String stringEndDateTime4="31-12-2021 05:40";
        DateTimeFormatter formatter4=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime startDateTime4=LocalDateTime.parse(stringStartDateTime,formatter);
        LocalDateTime endDateTime4=LocalDateTime.parse(stringEndDateTime,formatter);
        Produce produce4=new Produce("Onions", Fertilizer.INORGANIC,50,5000,"White Onion", Type.HYBRID,startDateTime,endDateTime);
      //  produceService.addProduce(produce4);



    }
}
