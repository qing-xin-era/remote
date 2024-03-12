package com.qing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderID;
    private String payAccount;
    private String collectionPayAccount;
    private String orderHeadName;
    private String orderHeadID;
    private String orderHeadTel;
    private String orderState;
    private String orderSite;
    private String orderTime;
}
