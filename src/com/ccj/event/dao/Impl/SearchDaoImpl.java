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
                article.setArticleId(rs.getInt("article_id"));
                article.setWorkerId(rs.getInt("worker_id"));
                article.setContentText(rs.getString("content_text"));
                article.setLikesNum(rs.getInt("likes_num"));
                article.setVisNum(rs.getInt("vis_num"));
                article.setCollectionNum(rs.getInt("collection_num"));
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

    /**
     * 分页查询
     * @param tips
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List<Article> findByPage(String tips,int start, int rows) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Article> list = new ArrayList<>();
        String key = "%"+tips+"%";
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from article where title like ?  limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,key);
            ps.setInt(2,start);
            ps.setInt(3,rows);
            rs = ps.executeQuery();
            while (rs.next()){
                //封装数据,因为是用rs.get获得的数据，所以只能在这里进行封装
                Article article = new Article();
                int workerId = rs.getInt("worker_id");
                int articleId = rs.getInt("article_id");
                int visNum = rs.getInt("vis_num");
                int likesNum = rs.getInt("likes_num");
                int collectionNum = rs.getInt("collection_num");
                String title = rs.getString("title");
                String content_picture = rs.getString("content_picture");
                String context_text = rs.getString("content_text");
                article.setContentText(context_text);
                article.setWorkerId(workerId);
                article.setArticleId(articleId);
                article.setVisNum(visNum);
                article.setLikesNum(likesNum);
                article.setCollectionNum(collectionNum);
                article.setContentPicture(content_picture);
                article.setTitle(title);
                list.add(article);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return list;
    }

    /**
     * 获取模糊查询的总记录数
     * @param tips
     * @return
     */
    @Override
    public int findTotalCount(String tips) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String key = "%"+tips+"%";
        int count = 0;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "select count(*) from article where title like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,key);
            //设置插入值
            rs = ps.executeQuery();
            if (rs.next()){
                count = rs.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return count;
    }
}
