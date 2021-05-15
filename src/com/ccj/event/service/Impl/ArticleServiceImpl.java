package com.ccj.event.service.Impl;

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
    public Boolean publish(String title, String text, String worker_id, String picture) {
        ArticleDaoImpl articleDao = new ArticleDaoImpl();
        Boolean publish = articleDao.publish(title, text, worker_id, picture);
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

}
