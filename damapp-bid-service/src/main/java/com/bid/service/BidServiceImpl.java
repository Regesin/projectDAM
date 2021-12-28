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

    @Autowired
    public void setBidRepository(IBidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    /**
     *
     * @param bid --> for adding bid object to the database
     */
    @Override
    public void addBid(Bid bid) {
        bidRepository.save(bid);
    }

    /**
     *
     * @param bid --> for updating a bid object
     */

    @Override
    public void updateBid(Bid bid) {

        bidRepository.save(bid);
    }

    /**
     *
     * @param bidId bid Id in total bid ojects to delete a particular bid object
     * @throws BidNotFoundException If no bid is found in the database for the provided bid Id
     */
    @Override
    public void deleteByid(int bidId) throws BidNotFoundException {

        bidRepository.deleteById(bidId);
    }

    /**
     *
     * @return list of bids that are available in database
     * @throws BidNotFoundException If no bid is found in the database
     */
    @Override
    public List<Bid> getAll() throws BidNotFoundException {
        return bidRepository.findAll();
    }

    /**
     *
     * @param bidId
     * @return bid object based on bid Id
     * @throws BidNotFoundException If no bid is found in the database for the provided bid Id
     */
    @Override
    public Bid getById(int bidId) throws BidNotFoundException {
        return bidRepository.findById(bidId).get();
    }

    /**
     *
     * @param produceId
     * @return bid object based on produce Id
     * @throws BidNotFoundException If no bid is found in the database for the provided info
     */
    @Override
    public Bid getWinner(int produceId) throws BidNotFoundException {
        return bidRepository.getWinner(produceId);
    }

    /**
     *
     * @param produceId adding an order to the database based on the total highest bid amount and for a particular produce Id
     * @throws BidNotFoundException If no bid is found in the database for the provided info
     */
    @Override
    public void addOrder(int produceId) throws BidNotFoundException {
        bidRepository.addOrder(produceId);
    }

    /**
     *
     * @param produceId
     * @return produce object from Produce Microservice because it is one of parameter of bid
     */
    @Override
    public Produce getByProduceId(int produceId) {
        String url=BASEURL2+"/produces/id/"+produceId;
        ResponseEntity<Produce> produceResponse=restTemplate.getForEntity(url,Produce.class);
        Produce produce=produceResponse.getBody();
        System.out.println(produce);
        return produce;
    }

    /**
     *
     * @param companyId
     * @return Company object from Company Microservice because it is one of parameter of bid
     */
    @Override
    public Company getByCompanyId(int companyId) {
        String url=BASEURL1+"/companies/id/"+companyId;
        ResponseEntity<Company> companyResponse=restTemplate.getForEntity(url,Company.class);
        Company company=companyResponse.getBody();
        System.out.println(company);
        return company;
    }

}
