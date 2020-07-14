package club.banyuan.dao;

import club.banyuan.entity.User;

public interface UserDao extends BaseDao{

    //用户登录的方法
    public User login(String username,String password) throws Exception;
    public int add(User user);
}
