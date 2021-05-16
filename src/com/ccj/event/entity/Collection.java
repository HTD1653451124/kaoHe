package com.ccj.event.entity;

public class Collection {
    private int collectionId;
    private  int userId;
    private  int articleId;
    private String isCollect;

    public Collection() {
    }

    public Collection(int collectionId, int userId, int articleId, String isCollect) {
        this.collectionId = collectionId;
        this.userId = userId;
        this.articleId = articleId;
        this.isCollect = isCollect;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
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

    public String getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(String isCollect) {
        this.isCollect = isCollect;
    }


}
