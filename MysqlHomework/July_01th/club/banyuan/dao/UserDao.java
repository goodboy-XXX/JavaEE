package club.banyuan.dao;



import club.banyuan.entity.User;

import java.sql.SQLException;

public interface UserDao {
    //用户登陆
    void  getLoginUser(String loginName, String pwd) throws SQLException;
    //注册用户
    int add(User user);
}
