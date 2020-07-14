package club.banyuan.service.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.utils.JdbcUtils;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAllProducts() throws Exception {
        ProductDao productDao = new ProductDaoImpl(JdbcUtils.getConnection());
        List<Product> list = productDao.getAll();
        return list;
    }
}
