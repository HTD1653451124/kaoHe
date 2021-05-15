package com.ccj.event.entity;

public class Collection {
    private int collection_id;
    private  int user_id;
    private  int article_id;
    private String isCollect;

    public Collection() {
    }

    public Collection(int collection_id, int user_id, int article_id, String isCollect) {
        this.collection_id = collection_id;
        this.user_id = user_id;
        this.article_id = article_id;
        this.isCollect = isCollect;
    }

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
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

    public String getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(String isCollect) {
        this.isCollect = isCollect;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "collection_id=" + collection_id +
                ", user_id=" + user_id +
                ", article_id=" + article_id +
                ", isCollect='" + isCollect + '\'' +
                '}';
    }
}
