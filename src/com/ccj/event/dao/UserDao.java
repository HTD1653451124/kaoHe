package com.ccj.event.dao;

import com.ccj.event.entity.Article;
import com.ccj.event.entity.User;

import java.util.List;

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

    /**
     * 获取某个用户的点赞集合
     * @param userId
     * @return
     */
    public  List<Article> likes(String userId);

    /**
     * 获取某个用户收藏拦
     * @param userId
     * @return
     */
    public List<Article> collection(String userId);
}
