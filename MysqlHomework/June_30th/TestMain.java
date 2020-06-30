package com.club.banyuan.shengtang.jdbcPractice01;

import com.club.banyuan.shengtang.jdbcPractice01.dao.OrderDao;
import com.club.banyuan.shengtang.jdbcPractice01.dao.impl.OrderDaoImpl;
import com.club.banyuan.shengtang.jdbcPractice01.dao.impl.ProductDaoImpl;
import com.club.banyuan.shengtang.jdbcPractice01.entity.Product;
import com.club.banyuan.shengtang.jdbcPractice01.util.JdbcUtil;

import java.sql.Connection;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws Exception {

        Connection connection = JdbcUtil.getConnection();
        Product p = new Product();
        ProductDaoImpl productDao = new ProductDaoImpl(connection);
        List<Product> list = productDao.search(p);
        OrderDao orderDao = new OrderDaoImpl(connection);
        orderDao.order(list);

    }
}
