package com.ccj.event.dao;

import com.ccj.event.entity.Comment;

import java.util.List;

public interface CommentDao {
    /**
     * 发表评论
     * @param content
     * @param user_id
     * @param article_id
     * @param vName
     * @return
     */
    public Boolean comment(String content,String user_id,String article_id,String vName);

    /**
     * 获取某篇文章的所以评论
     * @param article_id
     * @return
     */
    public List<Comment> getAll(String article_id);


    /**
     * worker根据id删除评论
     * @param comment_id
     * @return
     */
    public Boolean delete(String comment_id);


    /**
     * 删除某篇文章的全部评论
     * @param article_id
     */
    public void deleteCommentArticle(String article_id);
}
