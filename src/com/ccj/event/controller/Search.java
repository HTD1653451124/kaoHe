package com.ccj.event.controller;

import com.ccj.event.bean.PageBean;
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
        if (text==null){
            text = req.getParameter("text");
        }
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        String type = req.getParameter("type");
        String method = req.getParameter("method");
        SearchServiceImpl searchService = new SearchServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        HttpSession session = req.getSession();

        if ("tourist".equals(type)){
            //游客
            req.getRequestDispatcher("/tourist.jsp").forward(req,resp);
        }else {
            //普通用户
            String account = req.getParameter("account");
            User user = userService.findAll(account);
            session.setAttribute("user",user);
            session.setAttribute("method","search");
            session.setAttribute("text",text);
            PageBean<Article> searchResult = searchService.getSearchResult(text,currentPage,rows);
            session.setAttribute("pb",searchResult);
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
