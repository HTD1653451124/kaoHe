package com.ccj.event.entity;

public class Types {
    private int types_id;
    private String type;
    private int article_id;

    public Types() {
    }

    @Override
    public String toString() {
        return "Types{" +
                "types_id=" + types_id +
                ", type='" + type + '\'' +
                ", article_id=" + article_id +
                '}';
    }

    public int getTypes_id() {
        return types_id;
    }

    public void setTypes_id(int types_id) {
        this.types_id = types_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public Types(int types_id, String type, int article_id) {
        this.types_id = types_id;
        this.type = type;
        this.article_id = article_id;
    }
}
