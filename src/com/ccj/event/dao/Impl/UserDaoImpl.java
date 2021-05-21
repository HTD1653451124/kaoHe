package com.ccj.event.dao.Impl;

import com.ccj.event.dao.UserDao;
import com.ccj.event.entity.Article;
import com.ccj.event.entity.User;
import com.ccj.event.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 检查用户名是否重复
     * @param account
     * @return
     */
    @Override
    public Boolean checkUser(String account,Boolean flag){
           Connection conn = null;
           ResultSet rs = null;
           Boolean isExist = false;
           PreparedStatement ps = null;
           try{
               conn = JDBCUtils.getConnection();
               String sql = "select * from user where account = ?";
               String sql2 = "select * from worker where account = ?";
               if (flag){
                   //flag=true则为user
                   ps = conn.prepareStatement(sql);
               }else {
                   //反之则为worker
                   ps = conn.prepareStatement(sql2);
               }

               ps.setString(1,account);
               rs = ps.executeQuery();
               while (rs.next()){
                   if (account.equals(rs.getString("account"))){
                       isExist = true;//存在为true
                   }
               }
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }finally {
               JDBCUtils.close(rs,ps,conn);
           }
           return isExist;
       }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public Boolean registUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "insert into user (user_id ,account,password,vir_name,gender) values (null,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setString(1,user.getAccount());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getVirName());
            ps.setString(4,user.getGender());
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
     * 用户登录
     * @param account
     * @param password
     * @return
     */
    @Override
    public Boolean login(String account,String password) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where account = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,password);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return false;
    }

    /**
     * 根据账号获取user的所有信息
     * @param account
     * @return
     */
    @Override
    public User getAll(String account) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        User user = new User();
        try{
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where account = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            rs = ps.executeQuery();
            if (rs.next()){
                int user_id = rs.getInt("user_id");
                String account1 = rs.getString("account");
                String password = rs.getString("password");
                String vir_name = rs.getString("vir_name");
                String gender = rs.getString("gender");
                user.setUserId(user_id);
                user.setPassword(password);
                user.setAccount(account1);
                user.setGender(gender);
                user.setVirName(vir_name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return user;

    }

    /**
     * 获取某个用户的点赞集合
     * @param userId
     * @return
     */
    @Override
    public List<Article> likes(String userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        List<Article> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql1 = "select * from likes where user_id = ?";
            String sql2 = "select * from article where article_id = ?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1,userId);
            rs = ps.executeQuery();
            while (rs.next()){
                Article article = new Article();
                int articleId = rs.getInt("article_id");
                ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1,articleId);
                rs2 = ps2.executeQuery();
                if (rs2.next()){
                    String title = rs2.getString("title");
                    article.setArticleId(articleId);
                    article.setTitle(title);
                    article.setVisNum(rs2.getInt("vis_num"));
                    article.setContentText(rs2.getString("content_text"));
                    article.setContentPicture(rs2.getString("content_picture"));
                    article.setLikesNum(rs2.getInt("likes_num"));
                    article.setCollectionNum(rs2.getInt("collection_num"));
                    article.setWorkerId(rs2.getInt("worker_id"));
                    article.setTypesId(rs2.getInt("types_id"));
                    list.add(article);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    /**
     * 获取某个用户收藏拦
     * @param userId
     * @return
     */
     public List<Article> collection(String userId){
         Connection conn = null;
         PreparedStatement ps = null;
         PreparedStatement ps2 = null;
         ResultSet rs = null;
         ResultSet rs2 = null;
         List<Article> list = new ArrayList<>();
         try {
             conn = JDBCUtils.getConnection();
             String sql1 = "select * from collection where user_id = ?";
             String sql2 = "select * from article where article_id = ?";
             ps = conn.prepareStatement(sql1);
             ps.setString(1,userId);
             rs = ps.executeQuery();
             while (rs.next()){
                 Article article = new Article();
                 int articleId = rs.getInt("article_id");
                 ps2 = conn.prepareStatement(sql2);
                 ps2.setInt(1,articleId);
                 rs2 = ps2.executeQuery();
                 if (rs2.next()){
                     String title = rs2.getString("title");
                     article.setArticleId(articleId);
                     article.setTitle(title);
                     article.setVisNum(rs2.getInt("vis_num"));
                     article.setContentText(rs2.getString("content_text"));
                     article.setContentPicture(rs2.getString("content_picture"));
                     article.setLikesNum(rs2.getInt("likes_num"));
                     article.setCollectionNum(rs2.getInt("collection_num"));
                     article.setWorkerId(rs2.getInt("worker_id"));
                     article.setTypesId(rs2.getInt("types_id"));
                     list.add(article);
                 }
             }
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         return list;
     }
}
