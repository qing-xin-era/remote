package com.qing.service;

import com.qing.Dao.OrderMapper;
import com.qing.pojo.Books;
import com.qing.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int deleteOrderById(int id) {
        return orderMapper.deleteOrderById(id);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public Order queryOrderById(int id) {
        return orderMapper.queryOrderById(id);
    }

    @Override
    public List<Order> queryOrderByCollectionPayAccount(String collectionPayAccount) {
        return orderMapper.queryOrderByCollectionPayAccount(collectionPayAccount);
    }

    @Override
    public List<Order> queryOrderByHeadID(String orderHeadID) {
        return orderMapper.queryOrderByHeadID(orderHeadID);
    }

    @Override
    public List<Order> queryAllOrder() {
        return orderMapper.queryAllOrder();
    }
}
