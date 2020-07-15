package club.banyuan.service.impl;

import club.banyuan.dao.SelectDao;
import club.banyuan.dao.impl.SelectDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.service.SelectService;
import club.banyuan.utils.JdbcUtils;

import java.util.List;

public class SelectServiceImpl implements SelectService {
    @Override
    public List<Product> selectByInput(Object...objects) throws Exception {
        SelectDao selectDao = new SelectDaoImpl(JdbcUtils.getConnection());
        List<Product> list = selectDao.select(objects);
        return list;
    }
}
