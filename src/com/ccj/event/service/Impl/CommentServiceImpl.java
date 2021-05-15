package com.ccj.event.service.Impl;

import com.ccj.event.dao.Impl.CommentDaoImpl;
import com.ccj.event.entity.Comment;
import com.ccj.event.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    /**
     * 添加评论
     * @param content
     * @param user_id
     * @param article_id
     * @return
     */
    @Override
    public Boolean commentService(String content, String user_id, String article_id,String vName) {
        CommentDaoImpl commentDao = new CommentDaoImpl();
        Boolean comment = commentDao.comment(content, user_id, article_id,vName);
        return comment;
    }

    @Override
    public List<Comment> findAllComment(String article_id) {
        CommentDaoImpl commentDao = new CommentDaoImpl();
        List<Comment> all = commentDao.getAll(article_id);
        return all;
    }

    /**
     * worker根据id删除评论
     * @param comment_id
     * @return
     */
    @Override
    public Boolean deleteComment(String comment_id) {
        CommentDaoImpl commentDao = new CommentDaoImpl();
        Boolean delete = commentDao.delete(comment_id);
        return delete;
    }

    /**
     * 删除某篇文章的所有评论，worker删除文章时调用
     * @param article_id
     */
    @Override
    public void deleteCommentInArticle(String article_id) {
        CommentDaoImpl commentDao = new CommentDaoImpl();
        commentDao.deleteCommentArticle(article_id);
    }
}
