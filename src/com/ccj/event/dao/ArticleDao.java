package com.ccj.event.dao;

import com.ccj.event.entity.Article;

import java.util.List;

public interface ArticleDao {
    /**
     * 查询article表，获取所有文章
     * @return
     */
    public List<Article> findAll();

    /**
     * 查询某个worker的所有文章
     * @param account
     * @return
     */
    public List<Article> findPersonalArticle(String account);


    public Boolean publish(String title ,String text ,String worker_id,String picture,String types_id);

    /**
     * 删除指定文章
     * @param article_id
     * @return
     */
    public Boolean delete(String article_id);

    /**
     * 增加一次浏览量
     * @param article_id
     */
    public void incraseVisNum(int article_id);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 分页查询
     * @param start
     * @param rows
     * @return
     */
    List<Article> findByPage(int start, int rows);
}
