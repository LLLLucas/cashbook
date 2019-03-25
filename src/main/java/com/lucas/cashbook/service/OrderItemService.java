package com.lucas.cashbook.service;

import com.lucas.cashbook.pojo.Orderitem;

import java.util.List;

public interface OrderItemService {
    void add(Orderitem orderitem);
    void delete(int id);
    List<Orderitem> list(int id);
    List<Orderitem> list2(int weekId,int userId);
    Orderitem get(int id);
    void update(Orderitem orderitem);


}
