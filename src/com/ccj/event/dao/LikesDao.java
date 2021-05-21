package com.ccj.event.dao;

public interface LikesDao {
    /**
     * 查询是否已经赞过，true为赞过，false为没赞过
     *
     * @param article_id
     * @param user_id
     * @return
     */
    public String isLikes(String article_id, String user_id);

    /**
     * 查询是否已经收藏，true为已收藏，false为未收藏
     *
     * @param article_id
     * @param user_id
     * @return
     */
    public String isCollected(String article_id, String user_id);

    /**
     * 点赞
     *
     * @param article_id
     * @param user_id
     * @return
     */
    public Boolean likes(String article_id, String user_id);

    /**
     * 取消点赞
     * @param article_id
     * @param user_id
     * @return
     */
    public Boolean cancelLikes(String article_id, String user_id);

    /**
     * 收藏
     *
     * @param article_id
     * @param user_id
     * @return
     */
    public Boolean collection(String article_id, String user_id);

    /**
     * 取消收藏
     * @param article_id
     * @param user_id
     * @return
     */
    public Boolean cancelCollect(String article_id, String user_id);



}


