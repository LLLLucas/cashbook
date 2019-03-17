package com.lucas.cashbook.pojo;

public class Img {
    private Integer id;

    private String load;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load == null ? null : load.trim();
    }
}