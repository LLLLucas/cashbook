package com.lucas.cashbook.mapper;

import com.lucas.cashbook.pojo.Date;
import com.lucas.cashbook.pojo.DateExample;
import java.util.List;

public interface DateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Date record);

    int insertSelective(Date record);

    List<Date> selectByExample(DateExample example);

    Date selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Date record);

    int updateByPrimaryKey(Date record);
}