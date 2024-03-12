package com.qing.controller;

import com.qing.Dao.FileSrcMapper;
import com.qing.pojo.*;
import com.qing.service.*;
import com.qing.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class DiscountController {
    @Autowired
    OrderService orderService;
    @Autowired
    Order order;
    @Autowired
    TaskService taskService;
    @Autowired
    TaskRunService taskRunService;
    @Autowired
    DiscountService discountService;
    @Autowired
    UserService userService;
    @Autowired
    FileSrcMapper  fileSrcMapper;




    @GetMapping("/allDiscount")

    public  String allDiscount(Model model){
        List<Discount> discounts = discountService.queryAllDiscount();

        model.addAttribute("taskList",discounts);
        return "allDiscount";
    }
    @GetMapping("/queryDiscountByName")

    public  String queryDiscountByName(Model model,String discountName){
        List<Discount> discounts = discountService.queryDiscountByName(discountName);

        model.addAttribute("taskList",discounts);
        return "allDiscount";
    }


    @GetMapping("/toAddDiscount")

    public  String toAddDiscount(Model model ,String userName){
        Discount discount = new Discount();
        discount.setDiscountCreater(userName);
        System.out.println("discount=========="+discount.getDiscountCreater());


        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        discount.setDiscountTime(dateTime.format(formatter));

        model.addAttribute("discount",discount);
        return "addDiscount";

    }

    @PostMapping("/addDiscount")
    public  String addDiscount(Model model, Discount discount){

        if(discount==null){
            return "addDiscount";
        }
        int i = discountService.addDiscount(discount);
        if(i!=0) System.out.println("添加taskrun成功");
        return "redirect:/allDiscount";
    }


    @GetMapping("/deleteDiscount")
    public  String deleteDiscount(String discountCreater,String userName,int discountID ){
        if(discountCreater.equals(userName)){

            discountService.deleteDiscountById(discountID);
            System.out.println("删除成功");
            return "redirect:allDiscount";
        }else {
            return "redirect:allDiscount" ;
        }

    }

}
