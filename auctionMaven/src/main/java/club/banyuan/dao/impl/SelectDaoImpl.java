package club.banyuan.dao.impl;

import club.banyuan.dao.SelectDao;
import club.banyuan.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectDaoImpl extends BaseDaoImpl implements SelectDao {


    public SelectDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> select(String inputName, String description, String startTime, String endTime, int startPrice) throws Exception {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where productName=? and description=? and startTime=? " +
                "and endTime=? and startPrice=?";
        Object[] objects = {inputName, description, startTime, endTime, startPrice};
        ResultSet resultSet = executeQuery(sql, objects);
        Product product = tableToClass(resultSet);
        list.add(product);
        return list;
    }

    @Override
    public Product tableToClass(ResultSet rs) throws Exception {
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setProductName(rs.getString(2));
            product.setDescription(rs.getString(3));
            product.setStartTime(rs.getString(4));
            product.setEndTime(rs.getString(5));
            product.setStartPrice(rs.getInt(6));
            product.setOperate(rs.getString(7));
            return product;
        }
        return null;
    }
}
