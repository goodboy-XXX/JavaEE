package club.banyuan.test;

import club.banyuan.dao.SelectDao;
import club.banyuan.dao.impl.SelectDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SelectTest {

    @Test
    public void selectTest() throws Exception {

        Product product = new Product();
//        product.setId(10);
        product.setProductName("图书");
        product.setDescription("收藏");
        product.setStartTime("2010-01-01");
        product.setEndTime("2020-01-01");
        product.setStartPrice(1000);
        product.setOperate("竞拍");

        SelectDao selectDao = new SelectDaoImpl(JdbcUtils.getConnection());
        List<Product> list = selectDao.select(product.getProductName(), product.getDescription(), product.getStartTime(), product.getEndTime(), product.getStartPrice());
        for (Product product1 : list) {
            System.out.println(product1);
        }

    }

}
