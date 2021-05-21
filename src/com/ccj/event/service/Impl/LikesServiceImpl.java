package com.ccj.event.service.Impl;

import com.ccj.event.dao.Impl.LikesDaoIml;
import com.ccj.event.service.LikesService;

public class LikesServiceImpl implements LikesService {
    public String getIsLikes(String article_id, String user_id){
        LikesDaoIml likesDaoIml = new LikesDaoIml();
        String likes = likesDaoIml.isLikes(article_id, user_id);
        return likes;
    }
    public String getCollection(String article_id, String user_id){
        LikesDaoIml likesDaoIml = new LikesDaoIml();
        String collected = likesDaoIml.isCollected(article_id, user_id);
        return  collected;
    }
    @Override
    public Boolean like(String article_id, String user_id) {
        LikesDaoIml likesDaoIml = new LikesDaoIml();
        String isLikes = likesDaoIml.isLikes(article_id, user_id);
        if ("1".equals(isLikes)){
            //删除该点赞记录
            Boolean aBoolean = likesDaoIml.cancelLikes(article_id, user_id);
            return aBoolean;
        }else {
            //该用户未点赞该文章从，可以点赞
            Boolean aBoolean = likesDaoIml.likes(article_id, user_id);
            return aBoolean;
        }

    }


    @Override
    public Boolean collect(String article_id, String user_id) {
        LikesDaoIml likesDaoIml = new LikesDaoIml();
        String collected = likesDaoIml.isCollected(article_id, user_id);
        if ("1".equals(collected)){
            Boolean isCancel = likesDaoIml.cancelCollect(article_id, user_id);
            return isCancel;
        }else {
            Boolean isSuccess = likesDaoIml.collection(article_id, user_id);
            return isSuccess;
        }

    }
}
