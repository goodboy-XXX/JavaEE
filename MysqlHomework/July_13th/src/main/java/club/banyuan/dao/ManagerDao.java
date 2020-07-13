package club.banyuan.dao;

import club.banyuan.entity.Manager;

public interface ManagerDao {

    //管理员登陆方法
    public Manager login(String managerUsername,String password) throws Exception;

}
