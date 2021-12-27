package com.bid.service;/*
 *@created 27-12-2021/12/2021 - 01:59 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.bid.exceptions.BidNotFoundException;
import com.bid.model.Bid;
import com.bid.repository.IBidRepository;

import java.util.List;

public class BidServiceImpl implements IBidService{

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
    public List<Bid> getWinner(int produceId) throws BidNotFoundException {
        return bidRepository.getWinner(produceId);
    }

    @Override
    public void addOrder(int produceId) throws BidNotFoundException {
        bidRepository.addOrder(produceId);
    }
}
