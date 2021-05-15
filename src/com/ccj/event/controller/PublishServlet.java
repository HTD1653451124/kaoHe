package com.ccj.event.controller;

import com.ccj.event.entity.Article;
import com.ccj.event.service.Impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/publishServlet")
public class PublishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //发布文章
        String title = req.getParameter("title");
        String textContent = req.getParameter("textContent");
        String worker_id = req.getParameter("worker_id");
        String account = req.getParameter("account");

        String picture = null;
        picture = req.getParameter("picture");
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        Boolean publish = articleService.publish(title, textContent, worker_id, picture);
        HttpSession session = req.getSession();
        if (publish){
            //文章发布成功
            List<Article> personArticle = articleService.getPersonalArticle(account);
            session.setAttribute("msg","发布成功，感谢您的分享");
            session.setAttribute("personArticle",personArticle);
            req.getRequestDispatcher("/worker_home.jsp").forward(req,resp);
        }else {
            session.setAttribute("msg","非常遗憾，文章发布失败");
            req.getRequestDispatcher("/publish.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
