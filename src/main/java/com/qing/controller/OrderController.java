package com.qing.controller;

import com.qing.pojo.*;
import com.qing.service.OrderService;
import com.qing.service.TaskService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    Order order;
    @Autowired
    TaskService taskService;


    //增
    @GetMapping("/toAddOrder")
    public String toAddOrder(Discount discount,Model model){
        System.out.println("----------------"+discount);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        discount.setDiscountTime(dateTime.format(formatter));

        System.out.println("----------------"+discount);
        model.addAttribute("discount",discount);

        return "addOrder";
    }
    @PostMapping("/addOrder")
    public String addOrder(Order order){
        if (order==null){
            return "addOrder";
        }
        System.out.println("------------------order"+order);
        order.setOrderState("预定");
        orderService.addOrder(order);

        return "redirect:/queryMyOrderByHeadID";
    }
    //删除订单通过订单ID  一般是管理员操作
    @GetMapping("/deleteOrderById")

    public  String deleteOrderById(Model model,String userName,String orderHeadID,int orderID){

        if(userName.equals(orderHeadID)){
            int i = orderService.deleteOrderById(orderID);
            model.addAttribute("deleteStat",i);
            return "redirect:/queryMyOrderByHeadID";
        }

        return "redirect:/queryMyOrderByHeadID";

    }
    //修改订单状态 ，一般是支付后进行修改
    @GetMapping("/toupdateOrder")
    public String toupdateOrder(String id, Model model) {
        Integer orderID = Integer.valueOf(id);
        Order order = orderService.queryOrderById(orderID);
        order.setOrderState("已支付");

        int updateStat = orderService.updateOrder(order);

        System.out.println("将要修改订单");
        model.addAttribute("updateStat", updateStat);
        return "showOrder";
    }
    //查询订单通过订单ID
    @GetMapping("/queryOrderByID")

    public  String queryOrderByID(Model model){
        Order order = orderService.queryOrderById(3);
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);


        model.addAttribute("orderList",orders);
        return "showOrder";
    }
    //查询订单通过负责人学号
    @GetMapping("/queryOrderByHeadID")
    public  String queryOrderByHeadID(Model model,String orderHeadID){
        List<Order> orders = orderService.queryOrderByHeadID(orderHeadID);
        model.addAttribute("orderList",orders);
        return "showOrder";
    }
    //查询订单通收款账户
    @GetMapping("/queryOrderByCollectionPayAccount")
    public  String queryOrderByCollectionPayAccount(Model model,String collectionPayAccount){
        List<Order> orders = orderService.queryOrderByCollectionPayAccount(collectionPayAccount);
        System.out.println("-----------------"+orders);
        model.addAttribute("orderList",orders);
        return "showOrder";
    }


    //查询订单通过负责人名字
    @GetMapping("/queryMyOrderByHeadID")

    public  String queryMyOrderByHeadID(Model model){
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        currentUser.getName();

        List<Order> orders = orderService.queryOrderByHeadID(currentUser.getName());
        //  int i = orderService.deleteOrderById(2);


        //order.setOrderHeadID("201451082408");
        //order.setOrderTime("17:50");

        //orderService.addOrder(order);
        model.addAttribute("orderList",orders);
        return "showOrder";
    }


    //查询所有
    @GetMapping("/allOrder")

    public  String allOrder(Model model){
      //  orderService.queryOrderByName();
        List<Order> orders = orderService.queryAllOrder();
        //Order order = orderService.queryOrderById(2);
        //List<Order> orders = orderService.queryOrderByName("晴新");
      //  int i = orderService.deleteOrderById(2);


        //order.setOrderHeadID("201451082408");
        //order.setOrderTime("17:50");

        //orderService.addOrder(order);
        model.addAttribute("orderList",orders);
        return "showOrder";
    }

    @GetMapping("/testTaskList")
    @ResponseBody
    public  String test(){
        //List<Task> tasks = taskService.queryAllTask();
//        List<Task> tasks = taskService.queryTaskByName("让人");
//        Task task = taskService.queryTaskById(3);
//        ArrayList<Task> tasks = new ArrayList<>();
//        tasks.add(task);

//        Task task = new Task();
//        task.setTaskName("篮球");
//        task.setTaskDetail("带球");
//        taskService.addTask(task);

        int i = taskService.deleteTaskById(6);

        return "大胆的"+i;
    }


}
