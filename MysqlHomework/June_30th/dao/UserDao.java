package com.club.banyuan.shengtang.jdbcPractice01.dao;


import com.club.banyuan.shengtang.jdbcPractice01.entity.User;

import java.sql.SQLException;

public interface UserDao {
    //用户登陆
    void  getLoginUser(String loginName, String pwd) throws SQLException;
    //注册用户
    int add(User user);
}
