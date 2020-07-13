package club.banyuan.test;

import club.banyuan.dao.ManagerDao;
import club.banyuan.dao.impl.ManagerDaoImpl;
import club.banyuan.entity.Manager;
import club.banyuan.utils.JdbcUtils;
import org.junit.jupiter.api.Test;


public class ManagerTest {

    @Test
    public void managerTest() throws Exception {

        Manager manager = new Manager();
        manager.setManagerUsername("manager");
        manager.setPassword("123456");

        ManagerDao managerDao = new ManagerDaoImpl(JdbcUtils.getConnection());
        Manager manager1 = managerDao.login(manager.getManagerUsername(), manager.getPassword());
        System.out.println(manager1);
    }

}
