package com.ccj.event.controller;

import com.ccj.event.entity.Article;
import com.ccj.event.entity.User;
import com.ccj.event.service.Impl.ArticleServiceImpl;
import com.ccj.event.service.Impl.LikesServiceImpl;
import com.ccj.event.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/likes")
public class Likes extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String user_id = req.getParameter("user_id");
        String article_id = req.getParameter("article_id");
        String account = req.getParameter("account");

        LikesServiceImpl likesService = new LikesServiceImpl();
        Boolean like = likesService.like(article_id, user_id);
        String islikes = likesService.getIsLikes(article_id, user_id);
        String isCollection = likesService.getCollection(article_id, user_id);
        if ("1".equals(islikes)){}else { islikes = "0";}
        if ("1".equals(isCollection)){}else { isCollection = "0";}
        //Boolean collect = likesService.collect(article_id, user_id);
        HttpSession session = req.getSession();
        session.setAttribute("islikes",islikes);
        session.setAttribute("isCollection",isCollection);
        if (like){
            ArticleServiceImpl articleService = new ArticleServiceImpl();
            UserServiceImpl userService = new UserServiceImpl();
            List<Article> articles = articleService.getAll();
            User allInfo = userService.findAll(account);
            session.setAttribute("articles",articles);
            session.setAttribute("user_id",allInfo.getUser_id());
            req.getRequestDispatcher("/visitArticleContent.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}