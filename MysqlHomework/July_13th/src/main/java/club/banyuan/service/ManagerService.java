package club.banyuan.service;

import club.banyuan.entity.Manager;

import java.sql.SQLException;

public interface ManagerService {

    //管理员登陆方法
    public Manager getManager(String managerUsername,String password) throws SQLException, ClassNotFoundException, Exception;

}
