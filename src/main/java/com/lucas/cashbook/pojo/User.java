package com.lucas.cashbook.pojo;

public class User {
    private Integer id;

    private String userName;

    private String paasword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPaasword() {
        return paasword;
    }

    public void setPaasword(String paasword) {
        this.paasword = paasword == null ? null : paasword.trim();
    }
}