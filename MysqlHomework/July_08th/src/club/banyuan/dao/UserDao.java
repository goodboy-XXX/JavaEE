package club.banyuan.dao;

import club.banyuan.entity.User;

import java.sql.SQLException;

public interface UserDao extends BaseDao{

    public User getLoginUser(String userName,String pws) throws SQLException, Exception;

}
