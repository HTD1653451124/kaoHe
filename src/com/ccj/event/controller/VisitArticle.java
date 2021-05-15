package com.ccj.event.controller;

import com.ccj.event.entity.Article;
import com.ccj.event.entity.Comment;
import com.ccj.event.service.Impl.ArticleServiceImpl;
import com.ccj.event.service.Impl.CommentServiceImpl;
import com.ccj.event.service.Impl.LikesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/visitArticle")
public class VisitArticle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取文章完整信息
        int article_id;
        int worker_id;
        int visNum;
        int likes_num;
        int collection_num;
        if (req.getParameter("article_id")!=null){
            article_id = Integer.valueOf(req.getParameter("article_id")).intValue();
        }else {
            article_id =-1;
        }
        if (req.getParameter("worker_id")!=null){
            worker_id = Integer.valueOf(req.getParameter("worker_id")).intValue();
        }else {
            worker_id = -1;
        }
        if (req.getParameter("visNum")!=null){
            visNum = Integer.valueOf(req.getParameter("visNum")).intValue();
        }else {
            visNum = 0;
        }
        if (req.getParameter("likes_num")!=null){
            likes_num = Integer.valueOf(req.getParameter("likes_num")).intValue();
        }else {
            likes_num = 0;
        }
        if (req.getParameter("collection_num")!=null){
            collection_num = Integer.valueOf(req.getParameter("collection_num")).intValue();
        }else {
            collection_num = 0;
        }

        String picture = req.getParameter("picture");
        String text = req.getParameter("text");
        String title = req.getParameter("title");
        String user_id = req.getParameter("user_id");
        String type = req.getParameter("type");
        //封装数据
        Article article = new Article();
        article.setArticle_id(article_id);
        article.setTitle(title);
        article.setContentPicture(picture);
        article.setCollection_num(collection_num);
        article.setVisNum(visNum);
        article.setLikes_num(likes_num);
        article.setContentText(text);
        article.setWorker_id(worker_id);

        //用户每点击一次文章，都增加一次浏览量，即本方法每调用一次都执行一次增加
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        articleService.addVisNum( article.getArticle_id());


        String articleId = req.getParameter("article_id");
        //调用service层方法
        LikesServiceImpl likesService = new LikesServiceImpl();
        CommentServiceImpl commentService = new CommentServiceImpl();

        String islikes = likesService.getIsLikes(articleId, user_id);
        String isCollection = likesService.getCollection(articleId, user_id);
        List<Comment> allComment = commentService.findAllComment(articleId);
        //取消完点赞或收藏后，表中的相关行直接没有了，故查询结果其实是null，在返回前端时会发生错误，所以手动转换为"0"
        if ("1".equals(islikes)){}else { islikes = "0";}
        if ("1".equals(isCollection)){}else { isCollection = "0";}
        //返回前端
        HttpSession session = req.getSession();
        session.setAttribute("islikes",islikes);
        session.setAttribute("isCollection",isCollection);
        session.setAttribute("article",article);
        session.setAttribute("user_id",user_id);
        session.setAttribute("allComment",allComment);
        if ("worker".equals(type)){
            //worker页面
            req.getRequestDispatcher("/worker_visit.jsp").forward(req,resp);
        }else if ("tourist".equals(type)){
            //游客页面
            req.getRequestDispatcher("/tourist_visit.jsp").forward(req,resp);
        }else {
            //普通用户页面
            req.getRequestDispatcher("/visitArticleContent.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}