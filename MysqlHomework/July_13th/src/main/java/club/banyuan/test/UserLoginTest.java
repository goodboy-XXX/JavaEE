package club.banyuan.test;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.utils.JdbcUtils;
import org.junit.jupiter.api.Test;


public class UserLoginTest {

    @Test
    public void userLoginTest() throws Exception{
        User user = new User();
        UserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
        user.setUserName("hi");
        user.setPwd("111");
        User user1 = userDao.login(user.getUserName(), user.getPwd());
        System.out.println(user1);
    }

}
