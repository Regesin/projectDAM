package com.order.service;/*
 *@created 27-12-2021/12/2021 - 02:59 PM
 *@project IntelliJ IDEA
 *@author  ArunSaiSurapaneni
 */

import com.order.exceptions.OrderNotFoundException;
import com.order.model.FarmerOrderView;
import com.order.model.Order;
import com.order.repository.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{
    /**
     * calling the IOrderRepository in the OrderServiceImpl
     */

    IOrderRepository orderRepository;

    public OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     *
     * @param orderId getting the Id
     * @return
     * @throws OrderNotFoundException throws exception
     */

    @Override
    public Order getById(int orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId).get();
    }

    /**
     *
     * @return
     * @throws OrderNotFoundException
     */

    @Override
    public List<Order> getAll() throws OrderNotFoundException {
        return orderRepository.findAll();
    }

    /**
     *
     * @param companyId Getting the companyId
     * @return
     * @throws OrderNotFoundException throws an exception
     */

    @Override
    public List<Order> getByCompanyId(int companyId) throws OrderNotFoundException {
        return orderRepository.getByCompanyId(companyId);
    }

    @Override
    public List<FarmerOrderView> getByFarmerId(int farmerId) {
        return  orderRepository.getByFarmerId(farmerId);
    }


}
