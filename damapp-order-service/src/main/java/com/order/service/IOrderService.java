package com.order.service;/*
 *@created 27-12-2021/12/2021 - 02:59 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.order.exceptions.OrderNotFoundException;
import com.order.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface IOrderService {

    Order getById(int orderId) throws OrderNotFoundException;

    List<Order> getAll() throws OrderNotFoundException;

    List<Order> getByCompanyId(int companyId) throws OrderNotFoundException;

    List<Object> getByFarmerId(int farmerId);

}
