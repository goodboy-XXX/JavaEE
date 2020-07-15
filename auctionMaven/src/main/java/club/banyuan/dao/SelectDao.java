package club.banyuan.dao;

import club.banyuan.entity.Product;

import java.util.Date;
import java.util.List;

public interface SelectDao extends BaseDao {

    //查询商品
    public List<Product> select(Object...objects) throws Exception;

}
