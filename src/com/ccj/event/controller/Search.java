package com.ccj.event.controller;

import com.ccj.event.entity.Article;
import com.ccj.event.entity.User;
import com.ccj.event.service.Impl.SearchServiceImpl;
import com.ccj.event.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class Search extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String text = req.getParameter("search");

        String type = req.getParameter("type");
        SearchServiceImpl searchService = new SearchServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        List<Article> searchResult = searchService.getSearchResult(text);
        HttpSession session = req.getSession();
        session.setAttribute("articles",searchResult);
        if ("tourist".equals(type)){
            //游客
            req.getRequestDispatcher("/tourist.jsp").forward(req,resp);
        }else {
            //普通用户
            String account = req.getParameter("account");
            User user = userService.findAll(account);
            session.setAttribute("user",user);
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
