package com.ccj.event.dao.Impl;

import com.ccj.event.dao.CommentDao;
import com.ccj.event.entity.Comment;
import com.ccj.event.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    /**
     * 发表评论
     * @param content
     * @param user_id
     * @param article_id
     * @param vName
     * @return
     */
    @Override
    public Boolean comment(String content, String user_id, String article_id,String vName) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into comment (comment_id,user_id,content,article_id,user_virName) values (null,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user_id);
            ps.setString(2,content);
            ps.setString(3,article_id);
            ps.setString(4,vName);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            JDBCUtils.close(ps,conn);
        }
        return true;

    }

    /**
     * 获取某篇文章的所以评论
     * @param article_id
     * @return
     */
    @Override
    public List<Comment> getAll(String article_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comment> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from comment where article_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,article_id);
            rs = ps.executeQuery();
            while (rs.next()){
                Comment comment = new Comment();
                int comment_id = rs.getInt("comment_id");
                int user_id = rs.getInt("user_id");
                String content = rs.getString("content");
                int article_id1 = rs.getInt("article_id");
                String user_virName = rs.getString("user_virName");
                comment.setCommentId(comment_id);
                comment.setArticleId(article_id1);
                comment.setContent(content);
                comment.setUserId(user_id);
                comment.setUserVirName(user_virName);
                list.add(comment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return list;
    }

    /**
     * worker根据id删除评论
     * @param comment_id
     * @return
     */
    @Override
    public Boolean delete(String comment_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from comment where comment_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,comment_id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            JDBCUtils.close(ps,conn);
        }
        return true;
    }

    /**
     * 删除某篇文章的全部评论
     * @param article_id
     */
    @Override
    public void deleteCommentArticle(String article_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from comment where article_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,article_id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }
}
