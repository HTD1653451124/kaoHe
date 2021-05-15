package com.ccj.event.util;

import java.sql.*;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        url = "jdbc:mysql://localhost:3306/cathealth";
        user = "root";
        password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*
     * 获取连接
     * @return 连接对象
     * */
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    /*
     * 释放资源
     * @param rs
     * @param st
     * @param conn
     * */
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



    public static void close(PreparedStatement pstmt,Connection conn){
        if (pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
