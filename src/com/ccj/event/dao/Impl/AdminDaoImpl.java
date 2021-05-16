package com.ccj.event.dao.Impl;

import com.ccj.event.dao.AdminDao;
import com.ccj.event.entity.Article;
import com.ccj.event.entity.Types;
import com.ccj.event.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminDaoImpl implements AdminDao {
    @Override
    public List<Types> getTypes() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Types> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from types";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                //封装数据,因为是用rs.get获得的数据，所以只能在这里进行封装
                Types types = new Types();
                types.setTypesId(rs.getInt("types_id"));
                types.setType(rs.getString("type"));
                list.add(types);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return list;
    }

    @Override
    public List<Integer> getCount(List<Types> list) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Integer> result = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            for (int i = 0; i < list.size(); i++) {
                String sql = "select sum(vis_num) from article where types_id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,list.get(i).getTypesId());
                rs = ps.executeQuery();
                while (rs.next()){
                    //封装数据,因为是用rs.get获得的数据，所以只能在这里进行封装
                    int anInt = rs.getInt(1);
                    result.add(anInt);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return result;
    }

    @Override
    public void delete(String typeId) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "delete from types where types_id = ?";
            String sql2 = "delete from article where types_id = ?";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setString(1,typeId);
            ps.executeUpdate();
            ps2 = conn.prepareStatement(sql2);
            ps2.setString(1,typeId);
            ps2.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }


}
