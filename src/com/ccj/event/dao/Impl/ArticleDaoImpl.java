package com.ccj.event.dao.Impl;

import com.ccj.event.dao.ArticleDao;
import com.ccj.event.entity.Article;
import com.ccj.event.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {
    /**
     * 查询article表，获取所有文章
     * @return
     */
    @Override
    public List<Article> findAll(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Article> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from article";
            ps = conn.prepareStatement(sql);
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
                int typesId = rs.getInt("types_id");
                article.setContentText(context_text);
                article.setTypesId(typesId);
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
     * 查询某个worker的所有文章
     * @param account
     * @return
     */
    public List<Article> findPersonalArticle(String account){
        Connection conn = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        List<Article> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from worker where account = ?";
            String sql1 = "select * from article where worker_id = ?";
            //先查询worker表获取worker的id
            ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            rs1= ps.executeQuery();
            rs1.next();
            String workerId = rs1.getString("worker_id");
            //查询article表获取信息
            ps1 = conn.prepareStatement(sql1);
            ps1.setString(1,workerId);
            rs = ps1.executeQuery();
            while (rs.next()){
                //封装数据,因为是用rs.get获得的数据，所以只能在这里进行封装
                Article article = new Article();
                int worker_id = rs.getInt("worker_id");
                int article_id = rs.getInt("article_id");
                int vis_num = rs.getInt("vis_num");
                int likes_num = rs.getInt("likes_num");
                int collection_num = rs.getInt("collection_num");
                String title = rs.getString("title");
                String content_picture = rs.getString("content_picture");
                String context_text = rs.getString("content_text");
                int typesId = rs.getInt("types_id");
                article.setTypesId(typesId);
                article.setContentText(context_text);
                article.setWorkerId(worker_id);
                article.setArticleId(article_id);
                article.setVisNum(vis_num);
                article.setLikesNum(likes_num);
                article.setCollectionNum(collection_num);
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
     * 添加article记录
     * @param title
     * @param text
     * @param worker_id
     * @param picture
     * @return
     */
    @Override
    public Boolean publish(String title, String text, String worker_id,String picture,String types_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtils.getConnection();

            String sql = "insert into article (article_id ,worker_id,content_text,content_picture,vis_num,likes_num,collection_num,title,types_id) values (null,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setString(1,worker_id);
            ps.setString(2,text);
            ps.setString(3,picture);
            ps.setInt(4,0);
            ps.setInt(5,0);
            ps.setInt(6,0);
            ps.setString(7,title);
            ps.setString(8,types_id);
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
     * 删除指定文章
     * @param article_id
     * @return
     */
    @Override
    public Boolean delete(String article_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "delete from article where article_id = ?";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setString(1,article_id);
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
     * 增加一次浏览量
     * @param article_id
     */
    @Override
    public void incraseVisNum(int article_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "update article set vis_num = vis_num+1 where article_id = ?";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setInt(1,article_id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }

    @Override
    public int findTotalCount() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "select count(*) from article";
            ps = conn.prepareStatement(sql);
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

    /**
     * 分页查询
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List<Article> findByPage(int start, int rows) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Article> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from article limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,rows);
            rs = ps.executeQuery();
            while (rs.next()){
                //封装数据,因为是用rs.get获得的数据，所以只能在这里进行封装
                Article article = new Article();
                int workerId = rs.getInt("worker_id");
                int articleId = rs.getInt("article_id");
                int visNum = rs.getInt("vis_num");
                int likesNum = rs.getInt("likes_num");
                int collectionNum = rs.getInt("collection_num");
                int typesId = rs.getInt("types_id");
                String title = rs.getString("title");
                String content_picture = rs.getString("content_picture");
                String context_text = rs.getString("content_text");
                article.setContentText(context_text);
                article.setTypesId(typesId);
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

}
