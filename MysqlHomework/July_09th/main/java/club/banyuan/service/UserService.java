package club.banyuan.service;

import club.banyuan.entity.User;

import java.sql.SQLException;

public interface UserService {

    //定义登录的方法
    public User getLoginUser(String username,String password) throws SQLException, ClassNotFoundException, Exception;

    public User getRegisterUser(User user) throws SQLException, ClassNotFoundException, Exception;
}
