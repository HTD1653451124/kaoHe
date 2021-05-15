package com.ccj.event.service.Impl;

import com.ccj.event.dao.Impl.SearchDaoImpl;
import com.ccj.event.entity.Article;
import com.ccj.event.service.SearchService;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    /**
     * 模糊查询
     * @param tips
     * @return
     */
    @Override
    public List<Article> getSearchResult(String tips) {
        SearchDaoImpl searchDao = new SearchDaoImpl();
        List<Article> list = searchDao.SearchTitle(tips);
        return list;
    }
}
