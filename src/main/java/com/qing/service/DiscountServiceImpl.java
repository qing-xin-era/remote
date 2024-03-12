package com.qing.service;

import com.qing.Dao.DiscountMapper;
import com.qing.pojo.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class DiscountServiceImpl implements  DiscountService{
    @Autowired
    DiscountMapper discountMapper;

    @Override
    public int addDiscount(Discount discount) {
        return discountMapper.addDiscount(discount);
    }

    @Override
    public int deleteDiscountById(int id) {
        return discountMapper.deleteDiscountById(id);
    }

    @Override
    public int updateDiscount(Discount discount) {
        return discountMapper.updateDiscount(discount);
    }

    @Override
    public Discount queryDiscountById(int id) {
        return discountMapper.queryDiscountById(id);
    }

    @Override
    public List<Discount> queryDiscountByName(String discountName) {
        return discountMapper.queryDiscountByName(discountName);
    }

    @Override
    public List<Discount> queryAllDiscount() {
        return discountMapper.queryAllDiscount();
    }
}
