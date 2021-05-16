package com.ccj.event.entity;

public class Article {
    private int articleId;
    private int workerId;
    private int visNum;
    private String contentText;
    private String contentPicture;
    private int likesNum;
    private int collectionNum;
    private String title;
    private int typesId;

    public int getTypesId() {
        return typesId;
    }

    public void setTypesId(int typesId) {
        this.typesId = typesId;
    }

    public Article() {
    }

    public Article(int articleId, int workerId, int visNum, String contentText, String contentPicture, int likes_num, int collection_num, String title) {
        this.articleId = articleId;
        this.workerId = workerId;
        this.visNum = visNum;
        this.contentText = contentText;
        this.contentPicture = contentPicture;
        this.likesNum = likesNum;
        this.collectionNum = collectionNum;
        this.title = title;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getVisNum() {
        return visNum;
    }

    public void setVisNum(int visNum) {
        this.visNum = visNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }

    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collection_num) {
        this.collectionNum = collection_num;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getContentPicture() {
        return contentPicture;
    }

    public void setContentPicture(String contentPicture) {
        this.contentPicture = contentPicture;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + articleId +
                ", worker_id=" + workerId +
                ", visNum=" + visNum +
                ", contentText='" + contentText + '\'' +
                ", contentPicture='" + contentPicture + '\'' +
                ", likes_num=" + likesNum +
                ", collection_num=" + collectionNum +
                ", title='" + title + '\'' +
                '}';
    }
}
