package com.ccj.event.service;

import com.ccj.event.entity.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    public boolean regist(User user);

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
    public User findAll(String account);
}
