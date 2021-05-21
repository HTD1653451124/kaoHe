package com.ccj.event.service;

import com.ccj.event.entity.Article;
import com.ccj.event.entity.User;

import java.util.List;

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

    /**
     * 获取用户的点赞集
     * @param userId
     * @return
     */
    public List<Article> getLikes(String userId);

    public List<Article> getCollection(String userId);
}
