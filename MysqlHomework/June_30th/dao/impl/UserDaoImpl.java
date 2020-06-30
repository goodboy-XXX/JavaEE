package com.club.banyuan.shengtang.jdbcPractice01.dao.impl;


import com.club.banyuan.shengtang.jdbcPractice01.dao.UserDao;
import com.club.banyuan.shengtang.jdbcPractice01.entity.Product;
import com.club.banyuan.shengtang.jdbcPractice01.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    Product p;

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void getLoginUser(String loginName, String pwd) throws SQLException {
        p = new Product();
        String sql = "select * from user where loginName=? password=?";
        Object[] params = new Object[]{loginName,pwd};
        ResultSet resultSet = executeQuery(sql, params);
        if (resultSet.next()){
            System.out.println("success");
        }else{
            System.out.println("faile");
        }
    }

    @Override
    public int add(User user) {
        String sql = "insert into user(null,loginName,userName,password,sex,identityCode,email,mobile,type) values(null,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[]{user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getType()};
        int i = executeInsert(sql, params);
        return i;
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
