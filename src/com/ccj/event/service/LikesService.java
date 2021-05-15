package com.ccj.event.service;

public interface LikesService {
    public Boolean like(String article_id,String user_id);
    public Boolean collect(String article_id,String user_id);
}
