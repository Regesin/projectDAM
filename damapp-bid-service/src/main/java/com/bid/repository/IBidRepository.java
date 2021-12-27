package com.bid.repository;/*
 *@created 27-12-2021/12/2021 - 01:59 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.bid.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IBidRepository extends JpaRepository<Bid, Integer> {

    @Query(value = "select * from bids where bidprice = (select max(bidprice) from bids) and produceid = ?1", nativeQuery = true)
    Bid getWinner(int produceId);

    @Modifying
    @Transactional
    @Query(value = " insert into orders(bidid,ordertotal) select bidid,bidprice from bids where bidprice = (select max(bidprice) from bids) and produceid = ?1", nativeQuery = true)
    void addOrder(@Param("produceid") int produceid);
}
