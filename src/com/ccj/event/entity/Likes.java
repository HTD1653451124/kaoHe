package com.ccj.event.entity;

public class Likes {
    private int likesId;
    private int userId;
    private int articleId;
    private String isLikes;

    public Likes() {
    }

    public Likes(int likesId, int userId, int articleId, String isLikes) {
        this.likesId = likesId;
        this.userId = userId;
        this.articleId = articleId;
        this.isLikes = isLikes;
    }

    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
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

    public String getIsLikes() {
        return isLikes;
    }

    public void setIsLikes(String isLikes) {
        this.isLikes = isLikes;
    }


}
