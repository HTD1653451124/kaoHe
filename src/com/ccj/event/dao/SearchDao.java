package com.ccj.event.dao;

import com.ccj.event.entity.Article;

import java.util.List;

public interface SearchDao {
    public List<Article> SearchTitle(String keyWord);

    /**
     * 分页模糊查询
     * @param tips
     * @param rows
     * @return
     */
    public List<Article> findByPage(String tips, int start, int rows);

    /**
     * 分页模糊查询获取总页数
     * @param tips
     * @return
     */
    public int findTotalCount(String tips);
}
