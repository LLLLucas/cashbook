package com.lucas.cashbook.service;

import com.lucas.cashbook.pojo.User;

public interface UserService {
    User get(String userName, String password);
    User get(String userName);
    User get(int id);
    void add(User user);
}
