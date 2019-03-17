package com.lucas.cashbook.service.impl;

import com.lucas.cashbook.mapper.DateMapper;
import com.lucas.cashbook.pojo.Date;
import com.lucas.cashbook.pojo.DateExample;
import com.lucas.cashbook.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateServiceImpl implements DateService {
    @Autowired
    DateMapper dateMapper;
    @Override
    public void add(Date date) {
        dateMapper.insert(date);

    }

    @Override
    public Date get(java.util.Date date) {
        DateExample example=new DateExample();
        example.createCriteria().andDateEqualTo(date);
        return dateMapper.selectByExample(example).get(0);
    }

    @Override
    public Date get(int id) {
        return dateMapper.selectByPrimaryKey(id);
    }
}
