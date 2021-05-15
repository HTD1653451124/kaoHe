package com.ccj.event.dao;

import com.ccj.event.entity.Comment;

import java.util.List;

public interface CommentDao {
    public Boolean comment(String content,String user_id,String article_id,String vName);

    /**
     * 获取某篇文章的所以评论
     * @param article_id
     * @return
     */
    public List<Comment> getAll(String article_id);

    public Boolean delete(String comment_id);

    public void deleteCommentArticle(String article_id);
}
