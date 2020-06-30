package com.club.banyuan.shengtang.jdbcPractice01.dao;

import com.club.banyuan.shengtang.jdbcPractice01.entity.Product;

import java.sql.ResultSet;
import java.util.List;

public interface BaseDao {
    public ResultSet executeQuery(String sql, Object[] params);
    public int executeUpdate(String sql, Object[] params);
    public int executeInsert(String sql, Object[] params);
    public boolean closeResource();
    public boolean closeResource(ResultSet reSet);
    public Object tableToClass(ResultSet rs) throws Exception;
}