package com.lucas.cashbook.service.impl;

import com.lucas.cashbook.mapper.UserMapper;
import com.lucas.cashbook.pojo.User;
import com.lucas.cashbook.pojo.UserExample;
import com.lucas.cashbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User get(String userName, String password) {
        UserExample example=new UserExample();
        example.createCriteria().andUserNameEqualTo(userName).andPaaswordEqualTo(password);
        List<User> userList=userMapper.selectByExample(example);
        if(userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }

    @Override
    public User get(String userName) {
        UserExample example=new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<User> userList=userMapper.selectByExample(example);
        if(userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }

    @Override
    public User get(int id) {

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
