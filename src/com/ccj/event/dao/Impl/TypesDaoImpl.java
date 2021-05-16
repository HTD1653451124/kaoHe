package com.ccj.event.dao.Impl;

import com.ccj.event.dao.TypesDao;
import com.ccj.event.entity.Article;
import com.ccj.event.entity.Types;
import com.ccj.event.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypesDaoImpl implements TypesDao {
    /**
     * 获取所有文章的种类
     * @return
     */
    @Override
    public List<Types> getAll() {
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

    /**
     * 添加一个种类
     * @param text
     */
    @Override
    public void addTy(String text) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtils.getConnection();

            String sql = "insert into types (types_id ,type) values (null,?)";
            ps = conn.prepareStatement(sql);
            //设置插入值
            ps.setString(1,text);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }
}
