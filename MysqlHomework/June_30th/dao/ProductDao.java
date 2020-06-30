package com.club.banyuan.shengtang.jdbcPractice01.dao;


import com.club.banyuan.shengtang.jdbcPractice01.entity.Product;

import java.util.List;

public interface ProductDao {
    //查询商品
    public List<Product> search(Product product) throws Exception;
}