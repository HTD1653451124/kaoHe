package com.ccj.event.service;

import com.ccj.event.entity.Comment;

import java.util.List;

public interface CommentService {
    public Boolean commentService(String content,String user_id,String article_id ,String vName);
    public List<Comment>  findAllComment(String article_id);
    public Boolean deleteComment(String comment_id);
    public void deleteCommentInArticle(String article_id);
}
