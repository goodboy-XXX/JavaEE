package club.banyuan.dao;

import club.banyuan.entity.Product;

public interface ChangeProduct extends BaseDao {

    //修改商品信息
    public Product change(Product product);

}
