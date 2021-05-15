package com.ccj.event.dao.Impl;

import com.ccj.event.dao.SearchDao;
import com.ccj.event.entity.Article;
import com.ccj.event.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDaoImpl implements SearchDao {

    /**
     * 根据关键词查询article表中的title，返回模糊查询的结果集合
     * @param keyWord
     * @return
     */
    @Override
    public List<Article> SearchTitle(String keyWord) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String key = "%"+keyWord+"%";
        List<Article> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from article where title like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,key);
            rs = ps.executeQuery();
            while (rs.next()){
                Article article = new Article();
                article.setTitle(rs.getString("title"));
                article.setArticle_id(rs.getInt("article_id"));
                article.setWorker_id(rs.getInt("worker_id"));
                article.setContentText(rs.getString("content_text"));
                article.setLikes_num(rs.getInt("likes_num"));
                article.setVisNum(rs.getInt("vis_num"));
                article.setCollection_num(rs.getInt("collection_num"));
                article.setContentPicture(rs.getString("content_picture"));
                list.add(article);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return list;
    }
}
