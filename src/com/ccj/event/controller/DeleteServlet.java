package com.ccj.event.controller;

import com.ccj.event.entity.Article;
import com.ccj.event.service.Impl.ArticleServiceImpl;
import com.ccj.event.service.Impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据id删除文章,并将评论也删除了
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取article_id参数
        String article_id = req.getParameter("article_id");
        String account = req.getParameter("account");
        //调用service层方法实现删除文章和该文章的所有评论
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        CommentServiceImpl commentService = new CommentServiceImpl();
        Boolean isSuccess = articleService.deleteArticle(article_id);
        commentService.deleteCommentInArticle(article_id);
        if (isSuccess){
            //成功刷新页面
            List<Article> personalArticle = articleService.getPersonalArticle(account);
            HttpSession session = req.getSession();
            session.setAttribute("personArticle",personalArticle);
            req.getRequestDispatcher("/worker_home.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
