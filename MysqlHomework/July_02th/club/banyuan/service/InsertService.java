package club.banyuan.service;

import club.banyuan.entity.User;

import java.sql.SQLException;

public interface InsertService {
    public int  add(User user) throws SQLException, ClassNotFoundException;
}
