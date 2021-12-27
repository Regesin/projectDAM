package com.order.service;/*
 *@created 27-12-2021/12/2021 - 02:59 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.order.exceptions.OrderNotFoundException;
import com.order.model.Order;
import com.order.repository.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{

    IOrderRepository orderRepository;

    public OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(int orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public List<Order> getAll() throws OrderNotFoundException {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getByCompanyId(int companyId) throws OrderNotFoundException {
        return orderRepository.getByCompanyId(companyId);
    }


}
