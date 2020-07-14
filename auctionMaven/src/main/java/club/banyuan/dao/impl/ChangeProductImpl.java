package club.banyuan.dao.impl;

import club.banyuan.dao.ChangeProduct;
import club.banyuan.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;

public class ChangeProductImpl extends BaseDaoImpl implements ChangeProduct {
    public ChangeProductImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Product change(Product product) {
        String sql = "update product set ";
        return null;
    }

    @Override
    public Product tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
