package club.banyuan.service.impl;

import club.banyuan.dao.SelectDao;
import club.banyuan.dao.impl.SelectDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.service.SelectService;
import club.banyuan.utils.JdbcUtils;

import java.util.List;

public class SelectServiceImpl implements SelectService {
    @Override
    public List<Product> selectByInput(String inputName, String description, String startTime, String endTime, int startPrice) throws Exception {
        SelectDao selectDao = new SelectDaoImpl(JdbcUtils.getConnection());
        List<Product> list = selectDao.select(inputName, description, startTime, endTime, startPrice);
        return list;
    }
}
