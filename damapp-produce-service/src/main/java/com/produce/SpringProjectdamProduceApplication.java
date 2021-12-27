package com.produce;

import com.produce.model.Fertilizer;
import com.produce.model.Produce;
import com.produce.model.Type;
import com.produce.service.IProduceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

       Produce produce1=new Produce("Grapes",Fertilizer.ORGANIC,20,200000,"Sweet Jubliee",Type.NORMAl, LocalDate.parse("2021-12-28"),LocalDate.parse("2021-12-28"), LocalTime.parse("18:00"),LocalTime.parse("19:00"));

        Produce produce2=new Produce("Tomatoes",Fertilizer.ORGANIC,30,250000,"Roma",Type.NORMAl, LocalDate.parse("2021-12-29"),LocalDate.parse("2021-12-29"), LocalTime.parse("20:00"),LocalTime.parse("21:00"));
  //   Produce produce1=new Produce("Grapes",Fertilizer.ORGANIC,20,200000,"Sweet Jubliee",Type.NORMAl, LocalDate.parse("2021-12-28"),LocalDate.parse("2021-12-28"), LocalTime.parse("18:00"),LocalTime.parse("19:00"));
//
//        Produce produce1=new Produce("Grapes",Fertilizer.ORGANIC,20,200000,"Sweet Jubliee",Type.NORMAl, LocalDate.parse("2021-12-28"),LocalDate.parse("2021-12-28"), LocalTime.parse("18:00"),LocalTime.parse("19:00"));
//        Produce produce1=new Produce("Grapes",Fertilizer.ORGANIC,20,200000,"Sweet Jubliee",Type.NORMAl, LocalDate.parse("2021-12-28"),LocalDate.parse("2021-12-28"), LocalTime.parse("18:00"),LocalTime.parse("19:00"));



        produceService.addProduce(produce1);

        produceService.addProduce(produce2);

//        produceService.addProduce(produce1);
//
//        produceService.addProduce(produce1);
//
//        produceService.addProduce(produce1);

    }
}
