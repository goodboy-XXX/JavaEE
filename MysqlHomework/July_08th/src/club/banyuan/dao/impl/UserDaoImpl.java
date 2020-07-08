package club.banyuan.dao.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User getLoginUser(String userName, String pwd) throws Exception {
        String sql = "select * from user where userName=? pwd=?";
        Object[] objects = {userName, pwd};
        ResultSet resultSet = executeQuery(sql, objects);
        User user = null;
        if (resultSet.next()) {
            user = tableToClass(resultSet);
        }

        return user;
    }

    @Override
    public User tableToClass(ResultSet rs) throws Exception {
        User user = new User();
        while (rs.next()) {
            user.setId(rs.getInt(1));
            user.setUserName(rs.getString(2));
            user.setPwd(rs.getString(3));
            user.setIdentityID(rs.getInt(4));
            user.setPhoneNumber(rs.getInt(5));
            user.setAddress(rs.getString(6));
            user.setPost(rs.getInt(7));
        }
        return user;
    }
}
