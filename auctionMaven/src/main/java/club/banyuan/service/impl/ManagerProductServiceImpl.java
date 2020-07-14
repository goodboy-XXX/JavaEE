package club.banyuan.service.impl;

import club.banyuan.dao.ManagerProductDao;
import club.banyuan.dao.impl.ManagerProductDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.service.ManagerProductService;
import club.banyuan.utils.JdbcUtils;

import java.util.List;

public class ManagerProductServiceImpl implements ManagerProductService {
    @Override
    public List<Product> getAllProducts() throws Exception {
        ManagerProductDao managerProductDao = new ManagerProductDaoImpl(JdbcUtils.getConnection());
        List<Product> list = managerProductDao.getAllProduct();
        return list;
    }
}
