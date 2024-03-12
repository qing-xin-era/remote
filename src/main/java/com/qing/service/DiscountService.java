package com.qing.service;

import com.qing.pojo.Discount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiscountService {
    //增加
    int addDiscount(Discount discount);
    //删除
    int deleteDiscountById(@Param("discountID") int id);
    //更新
    int updateDiscount(Discount discount);
    //单查询
    Discount queryDiscountById(@Param("discountID") int id);
    //多查询通过名称
    List<Discount> queryDiscountByName(@Param("discountName") String discountName);
    //查询全部的书
    List<Discount> queryAllDiscount();

}
