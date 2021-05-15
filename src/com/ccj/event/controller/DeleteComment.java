package com.ccj.event.controller;

import com.ccj.event.entity.Comment;
import com.ccj.event.service.Impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteComment")
public class DeleteComment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String comment_id = req.getParameter("comment_id");
        String article_id = req.getParameter("article_id");
        CommentServiceImpl commentService = new CommentServiceImpl();
        Boolean isSuccess = commentService.deleteComment(comment_id);
        HttpSession session = req.getSession();
        List<Comment> allComment = commentService.findAllComment(article_id);
        session.setAttribute("allComment",allComment);
        req.getRequestDispatcher("/worker_visit.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}