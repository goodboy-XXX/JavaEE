package com.club.banyuan.shengtang.jdbcPractice01.dao.impl;

import com.club.banyuan.shengtang.jdbcPractice01.dao.ProductDao;
import com.club.banyuan.shengtang.jdbcPractice01.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {



    public ProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> search(Product product) throws Exception {
        List<Product> list = null;
        String sql = "select * from product where name like ?";
        Object[] params = new Object[]{product.getName()};
        ResultSet resultSet = executeQuery(sql, params);
        list = tableToClass(resultSet);
        return list;
    }

    @Override
    public List<Product> tableToClass(ResultSet rs) throws Exception {
        Product p = new Product();
        List<Product> list = new ArrayList<>();
        while (rs.next()) {
            p.setId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setDescription(rs.getString(3));
            p.setPrice(rs.getInt(4));
            p.setStock(rs.getInt(5));
            p.setCategroyLevel1Id(rs.getInt(6));
            p.setCategroyLevel2Id(rs.getInt(7));
            p.setCategroyLevel3Id(rs.getInt(8));
            p.setFileName(rs.getString(9));
            p.setIsDelete(rs.getInt(10));
            list.add(p);
        }
        return list;
    }


}
