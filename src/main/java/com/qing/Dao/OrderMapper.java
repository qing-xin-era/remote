package com.qing.Dao;

import com.qing.pojo.Books;
import com.qing.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    //增加
    int addOrder(Order order);
    //删除
    int deleteOrderById(@Param("orderID") int id);
    //更新
    int updateOrder(Order order );
    //单查询
    Order queryOrderById(@Param("orderID") int id);
    //多查询通过收款账户
    List<Order> queryOrderByCollectionPayAccount(@Param("collectionPayAccount") String collectionPayAccount);
    //多查询通过负责人学号
    List<Order> queryOrderByHeadID(@Param("orderHeadID") String orderHeadID);
    //查询全部的书
    List<Order> queryAllOrder();

}
