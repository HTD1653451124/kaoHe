package com.ccj.event.service;

import com.ccj.event.entity.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 获取所有文章
     * @return
     */
    public List<Article> getAll();

    /**
     * worker登录后要看到他自己发布的所有文章信息，用该方法获取
     * @param account
     * @return
     */
    public List<Article> getPersonalArticle(String account);

    /**
     * 发布文章
     * @param title
     * @param text
     * @param worker_id
     * @param picture
     * @return
     */
    public Boolean publish(String title ,String text ,String worker_id,String picture);

    /**
     * worker自己删除指定文章
     * @param article_id
     * @return
     */
    public Boolean deleteArticle(String article_id);

    /**
     * 增加一次浏览量
     * @param article_id
     */
    public void addVisNum(int article_id);
}
