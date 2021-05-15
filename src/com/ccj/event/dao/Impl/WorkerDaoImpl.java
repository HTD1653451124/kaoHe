package com.ccj.event.dao.Impl;

import com.ccj.event.dao.WorkerDao;
import com.ccj.event.entity.Article;
import com.ccj.event.entity.Worker;
import com.ccj.event.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerDaoImpl implements WorkerDao {

    /**
     * 注册服务工作者
     * @param worker
     * @return
     */
    @Override
    public Boolean registerWorker(Worker worker) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "insert into worker (worker_id ,account,password,vir_name,gender) values (null,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setString(1,worker.getAccount());
            ps.setString(2,worker.getPassword());
            ps.setString(3,worker.getVirName());
            ps.setString(4,worker.getGender());
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
     * 服务工作者登录
     * @param account
     * @param password
     * @return
     */
    @Override
    public Boolean login(String account, String password) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "select * from worker where account = ? and password = ?";
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
     * 获取worker的信息
     * @param account
     * @return
     */
    @Override
    public Worker getWorkerInfo(String account) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Worker worker = new Worker();
        try{
            conn = JDBCUtils.getConnection();
            String sql = "select * from worker where account = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            rs = ps.executeQuery();
            if (rs.next()){
                worker.setWorker_id(rs.getInt("worker_id"));
                worker.setAccount(rs.getString("account"));
                worker.setPassword(rs.getString("password"));
                worker.setGender(rs.getString("gender"));
                worker.setVirName(rs.getString("vir_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return worker;

    }

    /**
     * 发布文章
     * @param article
     * @return
     */
    @Override
    public Boolean publish(Article article) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "insert into article (article_id,worker_id ,content_text,content_picture,vis_num,likes_num,collection_num,title) values (null,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setInt(1,article.getWorker_id());
            ps.setString(2,article.getContentText());
            ps.setString(3,article.getContentPicture());
            ps.setInt(4,article.getVisNum());
            ps.setInt(5,article.getLikes_num());
            ps.setInt(6,article.getCollection_num());
            ps.setString(7,article.getTitle());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            JDBCUtils.close(ps,conn);
        }
        return true;
    }
}
