package com.order.repository;/*
 *@created 27-12-2021/12/2021 - 02:59 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.order.exceptions.OrderNotFoundException;
import com.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

    @Query("from Order o inner join o.bid b inner join b.company c where c.companyId = ?1 order by o.dateTime")
    List<Order> getByCompanyId(int companyId);

    @Query(value = "select orders.ordersid as ordersid, bids.bidid as bidid, bids.bidprice as bidprice, produces.produceid as produceid, farmdetails.farmid as farmid from orders INNER JOIN bids on orders.bidid = bids.bidid INNER JOIN produces on bids.produceid = produces.produceid INNER JOIN farmdetails on produces.farmid = farmdetails.farmid where farmer_id = ?1",nativeQuery = true)
    List<Object> getByFarmerId(int farmerId);



}
