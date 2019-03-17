package com.lucas.cashbook.pojo;

import java.util.Date;

public class Orderitem {
    private Integer id;

    private Float money;

    private Integer userId;

    private Integer categoryId;

    private Integer dateId;
    private String userName;
    private String cateName;
    private Date date;

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    private String date2;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Orderitem{" +
                "id=" + id +
                ", money=" + money +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                ", dateId=" + dateId +
                ", userName='" + userName + '\'' +
                ", cateName='" + cateName + '\'' +
                ", date=" + date +
                '}';
    }
}