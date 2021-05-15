package com.ccj.event.dao;

import com.ccj.event.entity.User;

public interface UserDao {
    /**
     * 检查用户名是否重复
     * @param account
     * @return
     */
    public Boolean checkUser(String account,Boolean flag);

    /**
     * 注册用户
     * @param user
     * @return
     */
    public Boolean registUser(User user);

    /**
     * 用户登录
     * @param account
     * @param password
     * @return
     */
    public Boolean login(String account, String password);

    /**
     * 根据账号获取user的所有信息
     * @param account
     * @return
     */
    public User getAll(String account);
}
