package com.lucas.cashbook.mapper;

import com.lucas.cashbook.pojo.Totalitem;
import com.lucas.cashbook.pojo.TotalitemExample;
import java.util.List;

public interface TotalitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Totalitem record);

    int insertSelective(Totalitem record);

    List<Totalitem> selectByExample(TotalitemExample example);

    Totalitem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Totalitem record);

    int updateByPrimaryKey(Totalitem record);
}