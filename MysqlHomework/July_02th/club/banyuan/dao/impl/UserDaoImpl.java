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
    public User getLoginUser(String loginName, String pwd) throws Exception {
        String sql = "select * from user where loginName=? and password=?";
        Object[] params = new Object[]{loginName,pwd};
        ResultSet resultSet = executeQuery(sql, params);
        User user = null;
        if (resultSet.next()){
            user =  tableToClass(resultSet);
        }
        return user;
    }

    @Override
    public int add(User user) {
        String sql = "insert into user(null,loginName,userName,password,sex,identityCode,email,mobile,type) values(null,?,?,?,?,?,?,?,?)";
        Object[] params = new Object[]{user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getType()};
        int i = executeInsert(sql, params);
        return i;
    }

    @Override
    public User tableToClass(ResultSet rs) throws Exception {
        User user = new User(rs.getInt(1)
                ,rs.getString(2)
        ,rs.getString(3)
        ,rs.getString(4)
        ,rs.getInt(5)
        ,rs.getLong(6)
        ,rs.getString(7),
                rs.getLong(8)
        ,rs.getInt(9));
        return user;
    }
}
