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
    public User login(String username, String password) throws Exception {
        String sql = "select * from user where userName=? and pwd=?";
        Object[] objects = {username, password};
        ResultSet resultSet = executeQuery(sql, objects);
        User user = tableToClass(resultSet);
        return user;
    }

    @Override
    public int add(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?)";
        Object[] objects = {
                null ,
                user.getUserName(),
                user.getPwd(),
                user.getIdentityID(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getPost()
        };
        int i = executeInsert(sql, objects);
        return i;
    }

    @Override
    public User tableToClass(ResultSet rs) throws Exception {
        User user = new User();
        while (rs.next()) {
            user.setUserName(rs.getString(1));
            user.setPwd(rs.getString(2));
            user.setIdentityID(rs.getString(3));
            user.setPhoneNumber(rs.getString(4));
            user.setAddress(rs.getString(5));
            user.setPost(rs.getInt(6));
        }
        return user;
    }
}
