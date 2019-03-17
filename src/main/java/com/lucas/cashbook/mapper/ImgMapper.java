package com.lucas.cashbook.mapper;

import com.lucas.cashbook.pojo.Img;
import com.lucas.cashbook.pojo.ImgExample;
import java.util.List;

public interface ImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Img record);

    int insertSelective(Img record);

    List<Img> selectByExample(ImgExample example);

    Img selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}