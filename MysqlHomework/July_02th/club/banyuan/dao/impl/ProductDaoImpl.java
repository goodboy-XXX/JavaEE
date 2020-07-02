package club.banyuan.dao.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Product;
import club.banyuan.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    public ProductDaoImpl(Connection connection) {
    }

    @Override
    public List<Product> search(String goodsName) throws Exception {
        Product p = new Product();
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where name=?";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,goodsName);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        while (resultSet.next()){
            p.setGoodsName(resultSet.getString(1));
            list.add(p);
        }
        return list;
    }
}
