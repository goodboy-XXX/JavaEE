package com.club.banyuan.shengtang.jdbcPractice01.dao.impl;

import com.club.banyuan.shengtang.jdbcPractice01.dao.OrderDao;
import com.club.banyuan.shengtang.jdbcPractice01.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {
    public OrderDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void order(List<Product> list) throws Exception {
        for (Product product : list) {
            System.out.println(product.getId() + product.getName());
        }
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }

}
