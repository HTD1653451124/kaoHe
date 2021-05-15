package com.ccj.event.controller;

import com.ccj.event.service.Impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/comment")
public class Comment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String content = req.getParameter("content");
        String user_id = req.getParameter("user_id");
        String article_id = req.getParameter("article_id");
        String vName = req.getParameter("vName");
        CommentServiceImpl commentService = new CommentServiceImpl();
        Boolean isSuccess = commentService.commentService(content, user_id, article_id,vName);
        HttpSession session = req.getSession();
        if (isSuccess){
            session.setAttribute("Msg","评论成功");
        }else {
            session.setAttribute("Msg","评论失败");
        }
        req.getRequestDispatcher("/visitArticleContent.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
