package com.club.banyuan.shengtang.jdbcPractice01.dao;


import com.club.banyuan.shengtang.jdbcPractice01.entity.Product;

import java.util.List;

public interface OrderDao {

    //生成订单
    void order(List<Product> list) throws Exception;

}
