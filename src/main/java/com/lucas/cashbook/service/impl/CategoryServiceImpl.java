package com.lucas.cashbook.service.impl;

import com.lucas.cashbook.mapper.CategoryMapper;
import com.lucas.cashbook.pojo.Category;
import com.lucas.cashbook.pojo.CategoryExample;
import com.lucas.cashbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
        CategoryExample categoryExample=new CategoryExample();
        categoryExample.setOrderByClause("id asc");
        return categoryMapper.selectByExample(categoryExample);
    }

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);


    }

    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}
