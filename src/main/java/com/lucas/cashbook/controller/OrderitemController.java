package com.lucas.cashbook.controller;

import com.lucas.cashbook.pojo.Orderitem;
import com.lucas.cashbook.pojo.User;
import com.lucas.cashbook.service.DateService;
import com.lucas.cashbook.service.OrderItemService;
import com.lucas.cashbook.service.UserService;
import com.lucas.cashbook.service.impl.DateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;


@Controller
@RequestMapping("")
public class OrderitemController {
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    DateService dateService;
    @Autowired
    UserService userService;
    @RequestMapping("orderItem")
    public String orderItem(Model model, int cid ,String userName){
        System.out.println(cid);
        System.out.println(userName);
        model.addAttribute("cid",cid);
        model.addAttribute("userName",userName);
        return "orderItem";
    }

    @RequestMapping("do_orderItem")
    public String doorderItem(Model model,int cid,String  userName,Float money){

        Date date=new Date();
        com.lucas.cashbook.pojo.Date date2=new com.lucas.cashbook.pojo.Date();
        date2.setDate(date);

        dateService.add(date2);
        com.lucas.cashbook.pojo.Date date3=dateService.get(date);
        System.out.println(date3.getId());
        Orderitem oi=new Orderitem();
        oi.setMoney(money);
        oi.setDateId(date3.getId());
        User user=userService.get(userName);
        oi.setUserId(user.getId());
        oi.setCategoryId(cid);
        orderItemService.add(oi);
        return "redirect:/category?userName="+userName;
    }


    @RequestMapping("orderItem2")
    public
    @ResponseBody  Orderitem orderItem2( int cid ,String userName){
        Orderitem orderitem=new Orderitem();
        orderitem.setCategoryId(cid);
        orderitem.setUserName(userName);

        return orderitem;
    }




}
