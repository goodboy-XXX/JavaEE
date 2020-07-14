package club.banyuan.service.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.utils.JdbcUtils;

public class UserServiceImpl implements UserService {
    @Override
    public User getLoginUser(String username, String password) throws Exception {
        UserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
        User user = userDao.login(username, password);
        return user;
    }

    @Override
    public User getRegisterUser(User user) throws Exception {
        UserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
        int add = userDao.add(user);
        if (add > 0) {
            return user;
        } else {
            return null;
        }
    }
}
