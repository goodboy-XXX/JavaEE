package club.banyuan.service;

import club.banyuan.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface SelectService {

    //通过输入查询
    public List<Product> selectByInput(Object...objects) throws SQLException, ClassNotFoundException, Exception;

}
