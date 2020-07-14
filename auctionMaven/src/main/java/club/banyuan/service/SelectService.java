package club.banyuan.service;

import club.banyuan.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface SelectService {

    //通过输入查询
    public List<Product> selectByInput(String inputName,String description,String startTime,String endTime,int startPrice) throws SQLException, ClassNotFoundException, Exception;

}
