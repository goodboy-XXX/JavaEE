package club.banyuan.dao.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

    public ProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> getAll() throws Exception {
        String sql = "select * from product";
        Object[] objects = {};
        ResultSet resultSet = executeQuery(sql, objects);
        List<Product> list = tableToClass(resultSet);
        return list;
    }

    @Override
    public List<Product> tableToClass(ResultSet rs) throws Exception {
        List<Product> list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setProductName(rs.getString(2));
            product.setDescription(rs.getString(3));
            product.setStartTime(rs.getString(4));
            product.setEndTime(rs.getString(5));
            product.setStartPrice(rs.getInt(6));
            product.setOperate(rs.getString(7));
            list.add(product);
        }
        return list;
    }
}
