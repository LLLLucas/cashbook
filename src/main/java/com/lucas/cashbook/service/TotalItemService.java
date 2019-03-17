package com.lucas.cashbook.service;

import com.lucas.cashbook.pojo.Totalitem;

public interface TotalItemService {
    void add(Totalitem ti);
    Totalitem get(int userid);
    void update(Totalitem totalitem);
}
