package com.qing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    private int discountID;
    private String discountName;
    private String discountDetail;
    private String discountTime;
    private String discountSite;
    private String discountCreater;

}
