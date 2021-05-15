package com.ccj.event.dao;

import com.ccj.event.entity.Article;

import java.util.List;

public interface SearchDao {
    public List<Article> SearchTitle(String keyWord);
}
