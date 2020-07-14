package club.banyuan.service;

import club.banyuan.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ManagerProductService {

    //查询所有商品
    public List<Product> getAllProducts() throws SQLException, ClassNotFoundException, Exception;

}
