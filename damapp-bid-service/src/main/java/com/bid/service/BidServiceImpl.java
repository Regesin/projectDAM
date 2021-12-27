package com.bid.service;/*
 *@created 27-12-2021/12/2021 - 01:59 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.bid.exceptions.BidNotFoundException;
import com.bid.model.Bid;
import com.bid.model.Company;
import com.bid.model.Produce;
import com.bid.repository.IBidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BidServiceImpl implements IBidService{
    public static final String BASEURL1="http://COMPANY-SERVICE/company-api";
    public static final String BASEURL2="http://PRODUCE-SERVICE/produce-api";

    RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(@Lazy RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    IBidRepository bidRepository;

    public BidServiceImpl(IBidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public void addBid(Bid bid) {
        bidRepository.save(bid);
    }

    @Override
    public void updateBid(Bid bid) {

        bidRepository.save(bid);
    }

    @Override
    public void deleteByid(int bidId) throws BidNotFoundException {

        bidRepository.deleteById(bidId);
    }

    @Override
    public List<Bid> getAll() throws BidNotFoundException {
        return bidRepository.findAll();
    }

    @Override
    public Bid getById(int bidId) throws BidNotFoundException {
        return bidRepository.findById(bidId).get();
    }

    @Override
    public Bid getWinner(int produceId) throws BidNotFoundException {
        return bidRepository.getWinner(produceId);
    }

    @Override
    public void addOrder(int produceId) throws BidNotFoundException {
        bidRepository.addOrder(produceId);
    }

    @Override
    public Produce getByProduceId(int produceId) {
        String url=BASEURL2+"/produces/id/"+produceId;
        ResponseEntity<Produce> produceResponse=restTemplate.getForEntity(url,Produce.class);
        Produce produce=produceResponse.getBody();
        System.out.println(produce);
        return produce;
    }

    @Override
    public Company getByCompanyId(int companyId) {
        String url=BASEURL1+"/companies/id/"+companyId;
        ResponseEntity<Company> companyResponse=restTemplate.getForEntity(url,Company.class);
        Company company=companyResponse.getBody();
        System.out.println(company);
        return company;
    }

}
