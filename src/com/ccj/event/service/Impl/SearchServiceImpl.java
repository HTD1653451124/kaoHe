package com.ccj.event.service.Impl;

import com.ccj.event.bean.PageBean;
import com.ccj.event.dao.Impl.ArticleDaoImpl;
import com.ccj.event.dao.Impl.SearchDaoImpl;
import com.ccj.event.entity.Article;
import com.ccj.event.service.SearchService;

import java.util.*;

public class SearchServiceImpl implements SearchService {

    @Override
    public List<Article> getSearchResult(String tips) {
        List<Article> L = new ArrayList<>();
        return L;
    }

    /**
     * 模糊查询
     * @param tips
     * @return
     */
    @Override
    public PageBean<Article> getSearchResult(String tips,String _currentPage,String _rows) {
        PageBean<Article> pb = new PageBean<>();
        if (_currentPage==null||"".equals(_currentPage)){
            _currentPage = "1";
        }
        if (_rows==null||"".equals(_rows)){
            _rows = "5";
        }
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        SearchDaoImpl searchDao = new SearchDaoImpl();
        int totalCount = searchDao.findTotalCount(tips);
        pb.setTotalCount(totalCount);


        int totalPage = totalCount % rows == 0 ? totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        int start = (currentPage-1)*rows;
        List<Article> list = searchDao.findByPage(tips,start,rows);
        pb.setList(list);

        return pb;
    }
}
