package com.lucas.cashbook.service.impl;

import com.lucas.cashbook.mapper.ImgMapper;
import com.lucas.cashbook.pojo.Img;
import com.lucas.cashbook.pojo.ImgExample;
import com.lucas.cashbook.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    ImgMapper imgMapper;
    @Override
    public List<Img> list() {
        ImgExample imgExample=new ImgExample();
        imgExample.setOrderByClause("id asc");
        return imgMapper.selectByExample(imgExample);
    }
}
