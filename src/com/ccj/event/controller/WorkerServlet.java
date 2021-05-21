package com.ccj.event.controller;

import com.ccj.event.entity.Article;
import com.ccj.event.entity.Comment;
import com.ccj.event.entity.Types;
import com.ccj.event.service.Impl.ArticleServiceImpl;
import com.ccj.event.service.Impl.CommentServiceImpl;
import com.ccj.event.service.Impl.TypesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/workerServlet")
public class WorkerServlet extends BaseServlet {
    public void deleteArticle(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //获取article_id参数
        String articleId = req.getParameter("articleId");
        String account = req.getParameter("account");
        //调用service层方法实现删除文章和该文章的所有评论
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        CommentServiceImpl commentService = new CommentServiceImpl();
        Boolean isSuccess = articleService.deleteArticle(articleId);
        commentService.deleteCommentInArticle(articleId);
        if (isSuccess){
            //成功刷新页面
            List<Article> personalArticle = articleService.getPersonalArticle(account);
            HttpSession session = req.getSession();
            session.setAttribute("personArticle",personalArticle);
            req.getRequestDispatcher("/worker_home.jsp").forward(req,resp);
        }

    }
    public void getAllTypes(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //获取所有文章的种类
        TypesServiceImpl typesService = new TypesServiceImpl();
        List<Types> allTypes = typesService.findAll();
        HttpSession session = req.getSession();
        session.setAttribute("types",allTypes);
        req.getRequestDispatcher("/publish.jsp").forward(req,resp);
    }
    public void publish(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //发布文章
        String title = req.getParameter("title");
        String textContent = req.getParameter("textContent");
        String workerId = req.getParameter("workerId");
        String account = req.getParameter("account");
        String typesId = req.getParameter("types");

        String picture = null;
        picture = req.getParameter("picture");
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        Boolean publish = articleService.publish(title, textContent, workerId, picture,typesId);
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
    public void deleteComment(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String commentId = req.getParameter("commentId");
        String articleId = req.getParameter("articleId");
        CommentServiceImpl commentService = new CommentServiceImpl();
        Boolean isSuccess = commentService.deleteComment(commentId);
        HttpSession session = req.getSession();
        List<Comment> allComment = commentService.findAllComment(articleId);
        session.setAttribute("allComment",allComment);
        req.getRequestDispatcher("/worker_visit.jsp").forward(req,resp);
    }

}
