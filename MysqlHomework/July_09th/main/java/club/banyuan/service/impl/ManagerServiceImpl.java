package club.banyuan.service.impl;

import club.banyuan.dao.ManagerDao;
import club.banyuan.dao.impl.ManagerDaoImpl;
import club.banyuan.entity.Manager;
import club.banyuan.service.ManagerService;
import club.banyuan.utils.JdbcUtils;

import java.sql.SQLException;

public class ManagerServiceImpl implements ManagerService {
    @Override
    public Manager getManager(String managerUsername, String password) throws Exception {
        ManagerDao managerDao = new ManagerDaoImpl(JdbcUtils.getConnection());
        Manager manager = managerDao.login(managerUsername, password);
        return manager;
    }
}
