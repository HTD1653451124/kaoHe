package com.ccj.event.controller;

import com.ccj.event.entity.Article;
import com.ccj.event.entity.User;
import com.ccj.event.entity.Worker;
import com.ccj.event.service.Impl.ArticleServiceImpl;
import com.ccj.event.service.Impl.UserServiceImpl;
import com.ccj.event.service.Impl.WorkerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/loginUser")
public class LoginUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        //获取用户输入数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String lg_type = req.getParameter("lg_type");
        String s = "user";
        Boolean isSuccess ;
        if (s.equals(lg_type)){
            //普通用户登录
            //调用service层的注册方法
            UserServiceImpl userService = new UserServiceImpl();
            ArticleServiceImpl articleService = new ArticleServiceImpl();
            isSuccess = userService.login(account, password);
            //返回提示
            if (isSuccess){
                List<Article> articleAll = articleService.getAll();
                User allInfo = userService.findAll(account);
                //将数据返回前台
                HttpSession session = req.getSession();
                session.setAttribute("articles",articleAll);
                session.setAttribute("user",allInfo);
                req.getRequestDispatcher("/home.jsp").forward(req,resp);
            }else {
                req.setAttribute("login_msg","登陆失败");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else {
            //worker登录
            //调用service层的登录方法
            WorkerServiceImpl workerService = new WorkerServiceImpl();
            isSuccess = workerService.login(account, password);
            //返回提示
            if (isSuccess){
                //成功则查询该worker的信息然后跳转页面
                //调用service中的方法
                Worker workerMsg = workerService.getWorkerMsg(account);
                ArticleServiceImpl articleService = new ArticleServiceImpl();
                List<Article> personalArticle = articleService.getPersonalArticle(account);
                HttpSession session = req.getSession();
                session.setAttribute("workerMsg",workerMsg);
                session.setAttribute("personArticle",personalArticle);
                req.getRequestDispatcher("/worker_home.jsp").forward(req,resp);
            }else {
                req.setAttribute("login_msg","登陆失败");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
