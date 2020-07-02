package club.banyuan.service.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.util.JdbcUtil;


public class UserServiceImpl  implements UserService {
    @Override
    public User login(String username, String password) throws Exception{
        UserDao userDao = new UserDaoImpl(JdbcUtil.getConnection());
        return userDao.getLoginUser(username,password);
    }
}
