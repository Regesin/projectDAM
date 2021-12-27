package com.bid;

import com.bid.model.Bid;
import com.bid.model.Company;
import com.bid.model.PaymentMode;
import com.bid.model.Produce;
import com.bid.service.IBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ComProjectdamBidApplication implements CommandLineRunner {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new  RestTemplate();
    }

    IBidService bidService;
    @Autowired
    public void setBidService(IBidService bidService) {
        this.bidService = bidService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ComProjectdamBidApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Produce produce= bidService.getByProduceId(1);
        Company company1=bidService.getByCompanyId(1);
        Company company2=bidService.getByCompanyId(2);
        Company company3=bidService.getByCompanyId(3);
        Company company4=bidService.getByCompanyId(4);

        Bid bid1=new Bid(company1,2001000,produce, PaymentMode.OFFLINE);
        Bid bid2=new Bid(company2,2002500,produce, PaymentMode.ONLINE);
        Bid bid3=new Bid(company3,2009000,produce, PaymentMode.OFFLINE);
        Bid bid4=new Bid(company4,2003000,produce, PaymentMode.ONLINE);

//        bidService.addBid(bid1);
//        bidService.addBid(bid2);
//
//        bidService.addBid(bid3);
//
//        bidService.addBid(bid4);

        bidService.addOrder(1);
    }
}
