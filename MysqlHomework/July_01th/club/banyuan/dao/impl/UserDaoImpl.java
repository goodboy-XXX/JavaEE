package club.banyuan.dao.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {


    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void getLoginUser(String loginName, String pwd) throws SQLException {
        String sql = "select * from user where loginName=? and password=?";
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
