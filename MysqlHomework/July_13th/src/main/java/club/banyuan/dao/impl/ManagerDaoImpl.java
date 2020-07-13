package club.banyuan.dao.impl;

import club.banyuan.dao.ManagerDao;
import club.banyuan.entity.Manager;

import java.sql.Connection;
import java.sql.ResultSet;

public class ManagerDaoImpl extends BaseDaoImpl implements ManagerDao {

    public ManagerDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Manager login(String managerUsername, String password) throws Exception {
        String sql = "select * from administrator where manageName=? and password=?";
        Object[] objects = {managerUsername, password};
        ResultSet resultSet = executeQuery(sql, objects);
        if (resultSet != null) {
            Manager manager = tableToClass(resultSet);
            return manager;
        } else {
            return null;
        }
    }

    @Override
    public Manager tableToClass(ResultSet rs) throws Exception {
        if (rs.next()){
        Manager manager = new Manager();
            manager.setManagerUsername(rs.getString(1));
            manager.setPassword(rs.getString(2));
        return manager;
        }else{
            return null;
        }
    }
}
