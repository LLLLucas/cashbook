package com.lucas.cashbook.controller;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.cashbook.pojo.*;
import com.lucas.cashbook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    UserService userService;
    @Autowired
    DateService dateService;
    @Autowired
    TotalItemService totalItemService;
    @Autowired
    ImgService imgService;
    @RequestMapping("category")
    public String selCategory(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                              @RequestParam(value = "size",defaultValue = "5")int size,
                              String userName, HttpSession session){
        if(start<=0){
            start=1;
        }

        User usera=(User)session.getAttribute("user");
        System.out.println(usera.getPaasword()+","+usera.getUserName());
        System.out.println("用户名"+userName);
        User user=userService.get(usera.getUserName());

        System.out.println("这是用户名的id啊"+user.getId());

        PageHelper.startPage(start,size,"id desc");
        List<Orderitem> ois=orderItemService.list(user.getId());

        for (Orderitem s:ois
             ) {

            Category category=categoryService.get(s.getCategoryId());
            s.setCateName(category.getName());
            User user2=userService.get(s.getUserId());
            s.setUserName(user2.getUserName());
            Date date=dateService.get(s.getId());

            System.out.println("日期样式我看看："+date);
            s.setDate(date.getDate());




        }
        PageInfo<Orderitem> page=new PageInfo<>(ois);
        List<Orderitem> ois2=orderItemService.list(user.getId());
        Float sum=0.0f;
        for (Orderitem s:ois2
             ) {
            sum+=s.getMoney();
        }
        Totalitem totalitem=new Totalitem();
        totalitem.setUserId(user.getId());
        totalitem.setTotalMoney(sum);
        Totalitem ti1=totalItemService.get(user.getId());
        totalitem.setId(ti1.getId());

        totalItemService.update(totalitem);
        int count=1;
        List<Category> cs=categoryService.list();
        //List<Img> imgs=imgService.list();
        for (Category c:cs
             ) {

            String name1=String.valueOf(count++);
            String name="img\\"+name1+".png";
            c.setImgName(name);

        }

        model.addAttribute("cs",cs);
        model.addAttribute("ois",ois);
        model.addAttribute("sum",sum);
        model.addAttribute("page",page);

        return "main";
    }
    @RequestMapping("delete")
    public String delete(int id ){
        Orderitem o=orderItemService.get(id);
        User user=userService.get(o.getUserId());

        orderItemService.delete(id);

        return "redirect:/category?userName="+user.getUserName();
    }
    @RequestMapping("update")
    public String update(Model model,int id){
        Orderitem o=orderItemService.get(id);
        User user=userService.get(o.getUserId());
        o.setUserName(user.getUserName());

        Category category=categoryService.get(o.getCategoryId());
        o.setCateName(category.getName());
        Date date=dateService.get(o.getDateId());
        o.setDate(date.getDate());

        List<Category> categories=categoryService.list();
        model.addAttribute("o",o);
        model.addAttribute("categories",categories);
        return "update";


    }
    @RequestMapping(value = "update2")
    public @ResponseBody
    Orderitem update(int id){
        Orderitem o=orderItemService.get(id);
        User user=userService.get(o.getUserId());
        o.setUserName(user.getUserName());
        Category category=categoryService.get(o.getCategoryId());
        o.setCateName(category.getName());
        Date date=dateService.get(o.getDateId());
        o.setDate(date.getDate());
        System.out.println("日期我看看"+o.getDate());
        System.out.println("你为什么不进来"+o.getUserName());
        List<Category> categories=categoryService.list();
        System.out.println("我就看看你进没进来呀 宝贝");

       return o;



    }
    @RequestMapping("edit")
    public String edit(Orderitem orderitem){
        orderItemService.update(orderitem);
        User user=userService.get(orderitem.getUserId());
        return "redirect:/category?userName="+user.getUserName();
    }
}
