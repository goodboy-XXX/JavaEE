package club.banyuan.dao;

import club.banyuan.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public List<Product> search(String goodsName) throws SQLException, Exception;
}
