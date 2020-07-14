package club.banyuan.dao;

import club.banyuan.entity.Product;

import java.util.List;

public interface ProductDao extends BaseDao{

    //查询所有商品
    public List<Product> getAll() throws Exception;

}
