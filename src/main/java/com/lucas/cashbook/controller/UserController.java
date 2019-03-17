package com.lucas.cashbook.controller;

import com.lucas.cashbook.pojo.Totalitem;
import com.lucas.cashbook.pojo.User;
import com.lucas.cashbook.service.TotalItemService;
import com.lucas.cashbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TotalItemService totalItemService;
    @RequestMapping("forelogin")
    public String login(@RequestParam("userName")String userName, @RequestParam("password")
            String password, Model model, HttpSession session){
        userName = HtmlUtils.htmlEscape(userName);
        User user=userService.get(userName,password);
        session.setAttribute("user",user);
        if(user==null){
            model.addAttribute("msg","账号或密码错误");
            return "login";
        }

        return "redirect:/category?userName="+user.getUserName();
    }
    @RequestMapping("login")
    public ModelAndView adminlogin() {
        ModelAndView modelAndView  = new ModelAndView("login");
        return modelAndView;

    }


    @RequestMapping("register")
    public String register(@RequestParam("userName")String userName, @RequestParam("password")
            String password, Model model, HttpSession session){
        userName = HtmlUtils.htmlEscape(userName);
        User user=userService.get(userName);
        //session.setAttribute("user",user);
        User user1=new User();
        user1.setUserName(userName);
        user1.setPaasword(password);
        if(user==null){
            userService.add(user1);
            User user2=userService.get(user1.getUserName());
            Totalitem totalitem=new Totalitem();
            totalitem.setUserId(user2.getId());
            totalitem.setTotalMoney(0.0f);
            totalItemService.add(totalitem);
            model.addAttribute("success","注册成功");
            return "login";
        }else{
            model.addAttribute("msg","用户名存在。请输入其他用户名");
            return "register";
        }


    }

    @RequestMapping("register1")
    public ModelAndView register1() {
        ModelAndView modelAndView  = new ModelAndView("register");

        return modelAndView;

    }




}
