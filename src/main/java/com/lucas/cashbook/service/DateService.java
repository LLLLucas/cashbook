package com.lucas.cashbook.service;

import com.lucas.cashbook.pojo.Date;

public interface DateService {
    void add(Date date);
    Date get(java.util.Date date);
    Date get(int id);
}
