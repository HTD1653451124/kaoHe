package com.ccj.event.controller;

import com.ccj.event.bean.ResultInfo;

import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet {
    public HttpSession session = null;   //创建一个session对象，让BaseServlet的子类可以直接拿来用
    public String rootPath = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        rootPath = req.getContextPath();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        ResultInfo resultInfo = new ResultInfo();
        String methodName = req.getParameter("method");
        Class<? extends BaseServlet> clazz = this.getClass();


        if (methodName==null){
            //发生错误，返回提示
            resultInfo.setMsg("错误，未携带方法名");
            session.setAttribute("Msg",resultInfo);
            session.setAttribute("target","login.jsp");
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
        Method method = null;
        try {
            method = clazz.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
//            System.out.println(method);
//            resultInfo.setMsg("错误，未找到该方法");
//            session.setAttribute("Msg",resultInfo);
//            session.setAttribute("target","login.jsp");
//            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
        try {
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    //    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        session = req.getSession();
//        rootPath = req.getContextPath();
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("application/json;charset=utf-8");
//
//        ResultInfo resultInfo = new ResultInfo();
//        String methodName = req.getParameter("method");
//        Class<? extends BaseServlet> clazz = this.getClass();
//        System.out.println(methodName);
//        if (methodName==null){
//            //发生错误，返回提示
//            resultInfo.setMsg("错误，未携带方法名");
//            session.setAttribute("Msg",resultInfo);
//            session.setAttribute("target","login.jsp");
//            req.getRequestDispatcher("/error.jsp").forward(req,resp);
//        }
//        Method method = null;
//        try {
//            method = clazz.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
////            System.out.println(method);
////            resultInfo.setMsg("错误，未找到该方法");
////            session.setAttribute("Msg",resultInfo);
////            session.setAttribute("target","login.jsp");
////            req.getRequestDispatcher("/error.jsp").forward(req,resp);
//        }
//        try {
//            method.invoke(this,req,resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
