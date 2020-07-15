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
    public List<Product> select(Object...objects) throws Exception {
        List<Product> list = new ArrayList<>();
        String sql;
        String inputName;
        String description;
        String startTime;
        String endTime;
        int startPrice;
        int len = objects.length;
        switch (len){
            case 0 :
                sql = "select * from product";
                ResultSet resultSet = executeQuery(sql, objects);
                Product product = tableToClass(resultSet);
                list.add(product);
                break;
            case 1:
                sql = "select * from product where productName=?";
                inputName = (String) objects[0];
                Object[] object1 = {inputName};
                ResultSet resultSet1 = executeQuery(sql, object1);
                Product product1 = tableToClass(resultSet1);
                list.add(product1);
                break;
            case 2:
                sql = "select * from product where productName=? and description=?";
                inputName = (String) objects[0];
                description = (String) objects[1];
                Object[] object2 = {inputName,description};
                ResultSet resultSet2 = executeQuery(sql, object2);
                Product product2 = tableToClass(resultSet2);
                list.add(product2);
                break;
            case 3:
                sql = "select * from product where productName=? and description=? and startTime=?";
                inputName = (String) objects[0];
                description = (String) objects[1];
                startTime = (String) objects[2];
                Object[] object3 = {inputName,description,startTime};
                ResultSet resultSet3 = executeQuery(sql, object3);
                Product product3 = tableToClass(resultSet3);
                list.add(product3);
                break;
            case 4:
                sql = "select * from product where productName=? and description=? and startTime=? and endTime=?";
                inputName = (String) objects[0];
                description = (String) objects[1];
                startTime = (String) objects[2];
                endTime = (String) objects[3];
                Object[] object4 = {inputName,description,startTime,endTime};
                ResultSet resultSet4 = executeQuery(sql, object4);
                Product product4 = tableToClass(resultSet4);
                list.add(product4);
                break;
            case 5:
                sql = "select * from product where productName=? and description=? and startTime=? and endTime=? and startPrice=?";
                inputName = (String) objects[0];
                description = (String) objects[1];
                startTime = (String) objects[2];
                endTime = (String) objects[3];
                startPrice = (int) objects[4];
                Object[] object5 = {inputName,description,startTime,endTime,startPrice};
                ResultSet resultSet5 = executeQuery(sql, object5);
                Product product5 = tableToClass(resultSet5);
                list.add(product5);
                break;
        }
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
