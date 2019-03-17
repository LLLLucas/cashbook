package com.lucas.cashbook.service.impl;

import com.lucas.cashbook.mapper.TotalitemMapper;
import com.lucas.cashbook.pojo.Totalitem;
import com.lucas.cashbook.pojo.TotalitemExample;
import com.lucas.cashbook.service.TotalItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalItemServiceImpl implements TotalItemService {
    @Autowired
    TotalitemMapper totalitemMapper;
    @Override
    public void add(Totalitem ti) {
        totalitemMapper.insert(ti);
    }

    @Override
    public Totalitem get(int userid) {
        TotalitemExample example=new TotalitemExample();
        example.createCriteria().andUserIdEqualTo(userid);
        totalitemMapper.selectByExample(example);
        return totalitemMapper.selectByExample(example).get(0);
    }

    @Override
    public void update(Totalitem totalitem) {
        totalitemMapper.updateByPrimaryKeySelective(totalitem);
    }
}
