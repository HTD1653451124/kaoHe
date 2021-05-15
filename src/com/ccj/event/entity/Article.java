package com.ccj.event.entity;

public class Article {
    private int article_id;
    private int worker_id;
    private int visNum;
    private String contentText;
    private String contentPicture;
    private int likes_num;
    private int collection_num;
    private String title;

    public Article() {
    }

    public Article(int article_id, int worker_id, int visNum, String contentText, String contentPicture, int likes_num, int collection_num, String title) {
        this.article_id = article_id;
        this.worker_id = worker_id;
        this.visNum = visNum;
        this.contentText = contentText;
        this.contentPicture = contentPicture;
        this.likes_num = likes_num;
        this.collection_num = collection_num;
        this.title = title;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
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

    public int getLikes_num() {
        return likes_num;
    }

    public void setLikes_num(int likes_num) {
        this.likes_num = likes_num;
    }

    public int getCollection_num() {
        return collection_num;
    }

    public void setCollection_num(int collection_num) {
        this.collection_num = collection_num;
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
                "article_id=" + article_id +
                ", worker_id=" + worker_id +
                ", visNum=" + visNum +
                ", contentText='" + contentText + '\'' +
                ", contentPicture='" + contentPicture + '\'' +
                ", likes_num=" + likes_num +
                ", collection_num=" + collection_num +
                ", title='" + title + '\'' +
                '}';
    }
}
