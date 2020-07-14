package club.banyuan.test;

import club.banyuan.dao.ManagerProductDao;
import club.banyuan.dao.impl.ManagerProductDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ManagerProductTest {

    @Test
    public void managerProductTest() throws Exception {
        ManagerProductDao managerProductDao = new ManagerProductDaoImpl(JdbcUtils.getConnection());
        List<Product> list = managerProductDao.getAllProduct();
        for (Product product : list) {
            System.out.println(product);
        }
    }

}
