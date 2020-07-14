package club.banyuan.dao;

import club.banyuan.entity.Product;

import java.util.List;

public interface ManagerProductDao extends BaseDao {

    //查询所有商品信息
    public List<Product> getAllProduct() throws Exception;

}
