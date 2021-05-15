package com.ccj.event.controller;

import com.ccj.event.entity.Article;
import com.ccj.event.service.Impl.ArticleServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
@WebServlet("/articleServlet")
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //调用service层代码获取所有文章
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        List<Article> articleAll = articleService.getAll();
        //将数据返回前台
        HttpSession session = req.getSession();
        session.setAttribute("articles",articleAll);
        req.setAttribute("articles",articleAll);
        req.getRequestDispatcher("/tourist.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
