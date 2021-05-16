package com.ccj.event.entity;

public class Comment {
    private int commentId;
    private String content;
    private int userId;
    private int articleId;
    private String userVirName;
    public Comment() {
    }

    public Comment(int comment_id, String content, int user_id, int article_id, String user_virName) {
        this.commentId = comment_id;
        this.content = content;
        this.userId = user_id;
        this.articleId = article_id;
        this.userVirName = user_virName;
    }

    public int getCommentId() {
        return commentId;
    }

    public String getUserVirName() {
        return userVirName;
    }

    public void setUserVirName(String user_virName) {
        this.userVirName = user_virName;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }


}
