package club.banyuan.test;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.utils.JdbcUtils;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

public class RegisterTest {

    @Test
    public void registerTest() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setUserName("good1");
        user.setPwd("123");
        user.setIdentityID("32123");
        user.setPhoneNumber("238126372379612731");
        user.setAddress("shanghai");
        user.setPost(123123);

        UserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
        int add = userDao.add(user);
        System.out.println(add);
    }

}
