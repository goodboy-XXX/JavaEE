package club.banyuan.service.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.InsertService;
import club.banyuan.util.JdbcUtil;

import java.sql.SQLException;

public class InsertServiceImpl implements InsertService {
    @Override
    public int add(User user) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDaoImpl(JdbcUtil.getConnection());
        return userDao.add(user);
    }
}
