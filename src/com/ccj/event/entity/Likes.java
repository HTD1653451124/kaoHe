package com.ccj.event.entity;

public class Likes {
    private int likes_id;
    private int user_id;
    private int article_id;
    private String isLikes;

    public Likes() {
    }

    public Likes(int likes_id, int user_id, int article_id, String isLikes) {
        this.likes_id = likes_id;
        this.user_id = user_id;
        this.article_id = article_id;
        this.isLikes = isLikes;
    }

    public int getLikes_id() {
        return likes_id;
    }

    public void setLikes_id(int likes_id) {
        this.likes_id = likes_id;
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

    public String getIsLikes() {
        return isLikes;
    }

    public void setIsLikes(String isLikes) {
        this.isLikes = isLikes;
    }

    @Override
    public String toString() {
        return "Likes{" +
                "likes_id=" + likes_id +
                ", user_id=" + user_id +
                ", article_id=" + article_id +
                ", isLikes='" + isLikes + '\'' +
                '}';
    }
}
