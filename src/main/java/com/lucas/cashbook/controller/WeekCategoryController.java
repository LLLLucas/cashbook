package com.lucas.cashbook.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.cashbook.pojo.*;
import com.lucas.cashbook.pojo.Date;
import com.lucas.cashbook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("")
public class WeekCategoryController {
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
    @RequestMapping("week_category")
    public String week_selCategory(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                              @RequestParam(value = "size",defaultValue = "5")int size,
                              String userName, HttpSession session){

        java.util.Date dateWeek=new java.util.Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(dateWeek);
        int weekId=calendar.get(Calendar.WEEK_OF_YEAR);


        User usera=(User)session.getAttribute("user");
        System.out.println(usera.getPaasword()+","+usera.getUserName());
        System.out.println("用户名"+userName);
        User user=userService.get(usera.getUserName());

        System.out.println("这是用户名的id啊"+user.getId());

        PageHelper.startPage(start,size,"id desc");
        List<Orderitem> ois=orderItemService.list2(weekId,user.getId());
        Set<String> categorySet=new HashSet<>();
        for (Orderitem s:ois
        ) {
            categorySet.add(s.getCateName());
        }
        for (String s:categorySet
        ) {
            System.out.println(s);

        }



        for (Orderitem s:ois
        ) {

            Category category=categoryService.get(s.getCategoryId());
            s.setCateName(category.getName());
            User user2=userService.get(s.getUserId());
            s.setUserName(user2.getUserName());
            Date date=dateService.get(s.getId());


            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatDate = df.format(date.getDate());
            s.setDate(date.getDate());

            s.setShijian(formatDate);

        }
        PageInfo<Orderitem> page=new PageInfo<>(ois);


        Float sum=0.0f;
        for (Orderitem s:ois
        ) {
            sum+=s.getMoney();
        }






        /*Totalitem totalitem=new Totalitem();
        totalitem.setUserId(user.getId());
        totalitem.setTotalMoney(sum);
        Totalitem ti1=totalItemService.get(user.getId());
        totalitem.setId(ti1.getId());

        totalItemService.update(totalitem);*/
        model.addAttribute("ois",ois);
        model.addAttribute("sum",sum);
        model.addAttribute("page",page);
        model.addAttribute("weekId",weekId);


        return "week";
    }
    @RequestMapping("next_week_category")
    public String next_week_category(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                                   @RequestParam(value = "size",defaultValue = "5")int size,
                                   String userName, HttpSession session,int weekId){


        int weekId2=weekId+1;
        System.out.println("啊啊啊 WeekiD"+weekId);



        User usera=(User)session.getAttribute("user");
        System.out.println(usera.getPaasword()+","+usera.getUserName());
        System.out.println("用户名"+userName);
        User user=userService.get(usera.getUserName());

        System.out.println("这是用户名的id啊"+user.getId());

        PageHelper.startPage(start,size,"id desc");
        List<Orderitem> ois=orderItemService.list2(weekId2,user.getId());

        for (Orderitem s:ois
        ) {

            Category category=categoryService.get(s.getCategoryId());
            s.setCateName(category.getName());
            User user2=userService.get(s.getUserId());
            s.setUserName(user2.getUserName());
            Date date=dateService.get(s.getId());

            System.out.println("日期样式我看看："+date);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatDate = df.format(date.getDate());
            s.setDate(date.getDate());

            s.setShijian(formatDate);

        }
        PageInfo<Orderitem> page=new PageInfo<>(ois);
        Set<String> categorySet=new HashSet<>();
        for (Orderitem s:ois
        ) {
            categorySet.add(s.getCateName());
        }
        for (String s:categorySet
             ) {
            System.out.println(s);

        }

        Float sum=0.0f;
        for (Orderitem s:ois
        ) {
            sum+=s.getMoney();
        }



        model.addAttribute("ois",ois);
        model.addAttribute("sum",sum);
        model.addAttribute("page",page);
        model.addAttribute("weekId",weekId2);

        return "week";
    }
    @RequestMapping("last_week_category")
    public String last_week_category(Model model, @RequestParam(value = "start",defaultValue = "0")int start,
                                     @RequestParam(value = "size",defaultValue = "5")int size,
                                     String userName, HttpSession session,int weekId){


        int weekId2=weekId-1;
        System.out.println("啊啊啊 WeekiD"+weekId);



        User usera=(User)session.getAttribute("user");
        System.out.println(usera.getPaasword()+","+usera.getUserName());
        System.out.println("用户名"+userName);
        User user=userService.get(usera.getUserName());

        System.out.println("这是用户名的id啊"+user.getId());

        PageHelper.startPage(start,size,"id desc");
        List<Orderitem> ois=orderItemService.list2(weekId2,user.getId());

        for (Orderitem s:ois
        ) {

            Category category=categoryService.get(s.getCategoryId());
            s.setCateName(category.getName());
            User user2=userService.get(s.getUserId());
            s.setUserName(user2.getUserName());
            Date date=dateService.get(s.getId());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatDate = df.format(date.getDate());
            s.setDate(date.getDate());

            s.setShijian(formatDate);

        }
        PageInfo<Orderitem> page=new PageInfo<>(ois);
        Set<String> categorySet=new HashSet<>();
        for (Orderitem s:ois
        ) {
            categorySet.add(s.getCateName());
        }
        for (String s:categorySet
        ) {
            System.out.println(s);

        }


        Float sum=0.0f;
        for (Orderitem s:ois
        ) {
            sum+=s.getMoney();
        }
        for (Orderitem a:ois
        ) {
            System.out.println("补补"+a.getWeekId());

        }


        model.addAttribute("ois",ois);
        model.addAttribute("sum",sum);
        model.addAttribute("page",page);
        model.addAttribute("weekId",weekId2);

        return "week";
    }
}
