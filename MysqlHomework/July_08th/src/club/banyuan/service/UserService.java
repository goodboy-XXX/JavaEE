package club.banyuan.service;

import club.banyuan.entity.User;

import java.sql.SQLException;

public interface UserService {

    public User login(String userName,String pwd) throws SQLException, ClassNotFoundException, Exception;

}
