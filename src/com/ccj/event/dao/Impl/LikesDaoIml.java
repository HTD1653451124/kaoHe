package com.ccj.event.dao.Impl;

import com.ccj.event.dao.LikesDao;
import com.ccj.event.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikesDaoIml implements LikesDao {
    @Override
    public String isLikes(String article_id, String user_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String isLikes = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from likes where user_id = ? and article_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user_id);
            ps.setString(2,article_id);
            rs = ps.executeQuery();
            if (rs.next()){
                isLikes = rs.getString("isLikes");
                return isLikes;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return null;
    }

    @Override
    public String isCollected(String article_id, String user_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String isCollect = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from collection where user_id = ? and article_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user_id);
            ps.setString(2,article_id);
            rs = ps.executeQuery();
            if (rs.next()){
                isCollect = rs.getString("isCollect");
                return isCollect;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return null;
    }

    /**
     * 点赞
     * @param article_id
     * @param user_id
     * @return
     */
    @Override
    public Boolean likes(String article_id, String user_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "insert into likes (likes_id ,user_id,article_id ,isLikes) values (null,?,?,true)";
            String sql2 = "update article set likes_num = likes_num+1 where article_id = ?";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setString(1,user_id);
            ps.setString(2,article_id);
            ps.executeUpdate();
            ps2 = conn.prepareStatement(sql2);
            ps2.setString(1,article_id);
            ps2.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            JDBCUtils.close(ps,conn);
            JDBCUtils.close(ps2,conn);
        }

        return true;

    }

    @Override
    public Boolean cancelLikes(String article_id, String user_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "delete from collection where user_id = ? and article_id = ?";
            String sql2 = "update article set likes_num = likes_num-1 where article_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user_id);
            ps.setString(2,article_id);
            ps.executeUpdate();
            ps2 = conn.prepareStatement(sql2);
            ps2.setString(1,article_id);
            ps2.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            JDBCUtils.close(ps,conn);
            JDBCUtils.close(ps2,conn);
        }
        return true;
    }

    @Override
    public Boolean collection(String article_id, String user_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "insert into collection (collection_id ,user_id,article_id,isCollect) values (null,?,?,true)";
            String sql2 = "update  article set collection_num = collection_num +1 where article_id = ?";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setString(1,user_id);
            ps.setString(2,article_id);
            ps.executeUpdate();
            ps2 = conn.prepareStatement(sql2);
            ps2.setString(1,article_id);
            ps2.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            JDBCUtils.close(ps,conn);
        }

        return true;
    }

    @Override
    public Boolean cancelCollect(String article_id, String user_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "delete from collection where user_id = ? and article_id = ?";
            String sql2 = "update article set collection_num = collection_num-1 where article_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user_id);
            ps.setString(2,article_id);
            ps.executeUpdate();
            ps2 = conn.prepareStatement(sql2);
            ps2.setString(1,article_id);
            ps2.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            JDBCUtils.close(ps,conn);
            JDBCUtils.close(ps2,conn);
        }

        return true;
    }


}
