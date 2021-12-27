package com.bid.service;/*
 *@created 27-12-2021/12/2021 - 01:57 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.bid.exceptions.BidNotFoundException;
import com.bid.model.Bid;

import java.util.List;

public interface IBidService {

    void addBid(Bid bid);

    void updateBid(Bid bid);

    void deleteByid(int bidId) throws BidNotFoundException;

    List<Bid> getAll() throws BidNotFoundException;

    Bid getById(int bidId) throws BidNotFoundException;

    Bid getWinner(int produceId) throws BidNotFoundException;

    void addOrder(int produceId) throws BidNotFoundException;

}
