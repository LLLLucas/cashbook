package com.lucas.cashbook.service.impl;

import com.lucas.cashbook.mapper.OrderitemMapper;
import com.lucas.cashbook.pojo.Orderitem;
import com.lucas.cashbook.pojo.OrderitemExample;
import com.lucas.cashbook.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderitemMapper orderitemMapper;
    @Override
    public void add(Orderitem orderitem) {
        orderitemMapper.insert(orderitem);

    }

    @Override
    public void delete(int id) {
        orderitemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Orderitem> list(int userid) {
        OrderitemExample example=new OrderitemExample();
        example.setOrderByClause("id asc");
        example.createCriteria().andUserIdEqualTo(userid);
        return orderitemMapper.selectByExample(example);
    }

    @Override
    public List<Orderitem> list2(int weekId, int userId) {
        OrderitemExample example=new OrderitemExample();

        example.setOrderByClause("id asc");
        example.createCriteria().andWeekIdEqualTo(weekId).andUserIdEqualTo(userId);
        return orderitemMapper.selectByExample(example);
    }



    @Override
    public Orderitem get(int id) {

        return orderitemMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Orderitem orderitem) {
        orderitemMapper.updateByPrimaryKeySelective(orderitem);
    }
}
