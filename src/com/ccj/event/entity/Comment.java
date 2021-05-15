package com.ccj.event.entity;

public class Comment {
    private int comment_id;
    private String content;
    private int user_id;
    private int article_id;
    private String user_virName;
    public Comment() {
    }

    public Comment(int comment_id, String content, int user_id, int article_id, String user_virName) {
        this.comment_id = comment_id;
        this.content = content;
        this.user_id = user_id;
        this.article_id = article_id;
        this.user_virName = user_virName;
    }

    public int getComment_id() {
        return comment_id;
    }

    public String getUser_virName() {
        return user_virName;
    }

    public void setUser_virName(String user_virName) {
        this.user_virName = user_virName;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", content='" + content + '\'' +
                ", user_id=" + user_id +
                ", article_id=" + article_id +
                ", user_virName='" + user_virName + '\'' +
                '}';
    }
}
