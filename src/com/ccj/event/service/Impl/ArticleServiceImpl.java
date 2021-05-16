package com.ccj.event.service.Impl;

import com.ccj.event.bean.PageBean;
import com.ccj.event.dao.Impl.ArticleDaoImpl;
import com.ccj.event.entity.Article;
import com.ccj.event.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    /**
     * 获取所有文章
     * @return
     */
    @Override
    public List<Article> getAll() {
        ArticleDaoImpl articleDao = new ArticleDaoImpl();
        List<Article> all = articleDao.findAll();
        return all;
    }

    /**
     * worker登录后要看到他自己发布的所有文章信息，用该方法获取
     * @param account
     * @return
     */
    public List<Article> getPersonalArticle(String account){
        ArticleDaoImpl articleDao = new ArticleDaoImpl();
        List<Article> personalArticle = articleDao.findPersonalArticle(account);
        return personalArticle;

    }

    /**
     * 发布文章
     * @param title
     * @param text
     * @param worker_id
     * @param picture
     * @return
     */
    @Override
    public Boolean publish(String title, String text, String worker_id, String picture,String types_id) {
        ArticleDaoImpl articleDao = new ArticleDaoImpl();
        Boolean publish = articleDao.publish(title, text, worker_id, picture,types_id);
        return publish;

    }

    /**
     * worker自己删除指定文章
     * @param article_id
     * @return
     */
    @Override
    public Boolean deleteArticle(String article_id) {
        ArticleDaoImpl articleDao = new ArticleDaoImpl();
        Boolean delete = articleDao.delete(article_id);
        return delete;
    }

    /**
     * 增加一次浏览量
     * @param article_id
     */
    @Override
    public void addVisNum(int article_id) {
        ArticleDaoImpl articleDao = new ArticleDaoImpl();
        articleDao.incraseVisNum(article_id);
    }

    @Override
    public PageBean<Article> findArticleByPage(String _currentPage, String _rows) {
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
        ArticleDaoImpl articleDao = new ArticleDaoImpl();
        int totalCount = articleDao.findTotalCount();
        pb.setTotalCount(totalCount);

        int totalPage = totalCount % rows == 0 ? totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        int start = (currentPage-1)*rows;
        List<Article> list = articleDao.findByPage(start,rows);
        pb.setList(list);

        return pb;

    }

}
