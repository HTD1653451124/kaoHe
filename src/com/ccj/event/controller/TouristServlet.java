package com.ccj.event.controller;

import com.ccj.event.entity.Article;
import com.ccj.event.service.Impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/touristServlet")
public class TouristServlet extends BaseServlet{
    public void getTourArticle(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //调用service层代码获取所有文章
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        List<Article> articleAll = articleService.getAll();
        //将数据返回前台
        HttpSession session = req.getSession();
        session.setAttribute("articles",articleAll);
        req.setAttribute("articles",articleAll);
        req.getRequestDispatcher("/tourist.jsp").forward(req,resp);
    }
}
