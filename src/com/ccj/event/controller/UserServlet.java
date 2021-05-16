package com.ccj.event.controller;

import com.ccj.event.bean.AdminBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.ccj.event.bean.PageBean;
import com.ccj.event.bean.UserBean;
import com.ccj.event.dao.Impl.UserDaoImpl;
import com.ccj.event.entity.Article;
import com.ccj.event.entity.Comment;
import com.ccj.event.entity.Types;
import com.ccj.event.entity.User;
import com.ccj.event.entity.Worker;
import com.ccj.event.service.Impl.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    public void login(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //获取用户输入数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String lg_type = req.getParameter("lg_type");
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        String method = req.getParameter("method");
        //调用service层代码
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        PageBean<Article> pb =  articleService.findArticleByPage(currentPage,rows);
        String s = "user";
        Boolean isSuccess ;
        HttpSession session = req.getSession();
        if ("1".equals(account) && "1".equals(password)){
            //管理员登录
            AdminServiceImpl adminService = new AdminServiceImpl();
            AdminBean info = adminService.getInfo();
            Map<Integer, Integer> infoResult = info.getResult();
            List<Types> typesList = info.getTypes();
            session.setAttribute("types",typesList);
            session.setAttribute("sum",infoResult);
            req.getRequestDispatcher("/admin_home.jsp").forward(req,resp);
        }else {
            if (s.equals(lg_type)){
                //普通用户登录
                //调用service层的注册方法
                UserServiceImpl userService = new UserServiceImpl();
                isSuccess = userService.login(account, password);
                //返回提示
                if (isSuccess){
                    User allInfo = userService.findAll(account);
                    //将数据返回前台

                    session.setAttribute("user",allInfo);
                    //用于判断是哪个查询返回的pb
                    session.setAttribute("method","login");
                    if ("search".equals(method)){
                        req.getRequestDispatcher("/search").forward(req,resp);
                        return;
                    }
                    session.setAttribute("pb",pb);
                    req.getRequestDispatcher("/home.jsp").forward(req,resp);
                }else {
                    req.setAttribute("login_msg","登陆失败");
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                }
            }else {
                //worker登录
                //调用service层的登录方法
                WorkerServiceImpl workerService = new WorkerServiceImpl();
                isSuccess = workerService.login(account, password);
                //返回提示
                if (isSuccess){
                    //成功则查询该worker的信息然后跳转页面
                    //调用service中的方法
                    Worker workerMsg = workerService.getWorkerMsg(account);
                    List<Article> personalArticle = articleService.getPersonalArticle(account);
                    session.setAttribute("workerMsg",workerMsg);
                    session.setAttribute("personArticle",personalArticle);
                    req.getRequestDispatcher("/worker_home.jsp").forward(req,resp);
                }else {
                    req.setAttribute("login_msg","登陆失败");
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                }
            }
        }


    }
    public void search(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
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
    public void visitArticle(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //获取文章完整信息
        int articleId;
        int workerId;
        int visNum;
        int likesNum;
        int collectionNum;
        if (req.getParameter("articleId")!=null){
            articleId = Integer.valueOf(req.getParameter("articleId")).intValue();
        }else {
            articleId =-1;
        }
        if (req.getParameter("workerId")!=null){
            workerId = Integer.valueOf(req.getParameter("workerId")).intValue();
        }else {
            workerId = -1;
        }
        if (req.getParameter("visNum")!=null){
            visNum = Integer.valueOf(req.getParameter("visNum")).intValue();
        }else {
            visNum = 0;
        }
        if (req.getParameter("likesNum")!=null){
            likesNum = Integer.valueOf(req.getParameter("likesNum")).intValue();
        }else {
            likesNum = 0;
        }
        if (req.getParameter("collectionNum")!=null){
            collectionNum = Integer.valueOf(req.getParameter("collectionNum")).intValue();
        }else {
            collectionNum = 0;
        }

        String picture = req.getParameter("picture");
        String text = req.getParameter("text");
        String title = req.getParameter("title");
        String userId = req.getParameter("userId");
        String type = req.getParameter("type");
        //封装数据
        Article article = new Article();
        article.setArticleId(articleId);
        article.setTitle(title);
        article.setContentPicture(picture);
        article.setCollectionNum(collectionNum);
        article.setVisNum(visNum);
        article.setLikesNum(likesNum);
        article.setContentText(text);
        article.setWorkerId(workerId);

        //用户每点击一次文章，都增加一次浏览量，即本方法每调用一次都执行一次增加
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        articleService.addVisNum( article.getArticleId());


        String articleId1 = req.getParameter("articleId");
        //调用service层方法
        LikesServiceImpl likesService = new LikesServiceImpl();
        CommentServiceImpl commentService = new CommentServiceImpl();

        String islikes = likesService.getIsLikes(articleId1, userId);
        String isCollection = likesService.getCollection(articleId1, userId);
        List<Comment> allComment = commentService.findAllComment(articleId1);
        //取消完点赞或收藏后，表中的相关行直接没有了，故查询结果其实是null，在返回前端时会发生错误，所以手动转换为"0"
        if ("1".equals(islikes)){}else { islikes = "0";}
        if ("1".equals(isCollection)){}else { isCollection = "0";}
        //返回前端
        HttpSession session = req.getSession();
        session.setAttribute("islikes",islikes);
        session.setAttribute("isCollection",isCollection);
        session.setAttribute("article",article);
        session.setAttribute("userId",userId);
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
    public void regisUser(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        Map<String, String[]> map = req.getParameterMap();
        String type = "user";
        boolean isSuccess= false;
        if (type.equals(req.getParameter("reg_type"))){
            //注册user
            //封装user对象
            UserBean userBean = new UserBean();
            User user = userBean.regisUser(map);
            //user已经有值了
            //调用service层的注册方法
            UserServiceImpl userServiceImpl = new UserServiceImpl();
            isSuccess = userServiceImpl.regist(user);
        }else {
            //注册worker
            //封装worker对象
            UserBean userBean = new UserBean();
            Worker worker = userBean.regisWorker(map);
            //worker已经有值了
            //调用service层的注册方法
            WorkerServiceImpl workerService = new WorkerServiceImpl();
            isSuccess = workerService.regis(worker);
        }
        //返回给前端的map
        if (isSuccess){
            //注册成功,跳转登录页面
            req.setAttribute("reg_msg","注册成功");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }else {
            //注册失败
            req.setAttribute("reg_msg","注册失败");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }
    }
    public void findUserAccount(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String account = req.getParameter("account");
        UserDaoImpl checkAccount = new UserDaoImpl();
        Boolean isExist = checkAccount.checkUser(account,true);

        Map<String,Object> map = new HashMap<String,Object>();

        if (isExist){
            //用户名存在
            map.put("userExist",true);
            map.put("msg","用户名存在");
        }else {
            //用户名不存在
            map.put("userExist",false);
            map.put("msg","用户名不存在");
        }

        //将数据传到客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),map);
    }
    public void likes(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String userId = req.getParameter("userId");
        String articleId = req.getParameter("articleId");
        String account = req.getParameter("account");

        LikesServiceImpl likesService = new LikesServiceImpl();
        Boolean like = likesService.like(articleId, userId);
        String islikes = likesService.getIsLikes(articleId, userId);
        String isCollection = likesService.getCollection(articleId, userId);
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
            session.setAttribute("user_id",allInfo.getUserId());
            req.getRequestDispatcher("/visitArticleContent.jsp").forward(req,resp);
        }
    }
    public void collection(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String articleId = req.getParameter("articleId");
        String account = req.getParameter("account");
        String userId = req.getParameter("userId");

        LikesServiceImpl likesService = new LikesServiceImpl();
        String isCollection = likesService.getCollection(articleId, userId);
        String islikes = likesService.getIsLikes(articleId, userId);
        if ("1".equals(islikes)){}else { islikes = "0";}
        if ("1".equals(isCollection)){}else { isCollection = "0";}
        Boolean collect = likesService.collect(articleId, userId);

        HttpSession session = req.getSession();
        session.setAttribute("isCollection",isCollection);
        session.setAttribute("islikes",islikes);
        if (collect){
            ArticleServiceImpl articleService = new ArticleServiceImpl();
            UserServiceImpl userService = new UserServiceImpl();
            List<Article> articles = articleService.getAll();
            User allInfo = userService.findAll(account);
            session.setAttribute("articles",articles);
            session.setAttribute("user_id",allInfo.getUserId());
            req.getRequestDispatcher("/visitArticleContent.jsp").forward(req,resp);
        }
    }
    public void comment(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String content = req.getParameter("content");
        String userId = req.getParameter("userId");
        String articleId = req.getParameter("articleId");
        String vName = req.getParameter("vName");
        CommentServiceImpl commentService = new CommentServiceImpl();
        Boolean isSuccess = commentService.commentService(content, userId, articleId,vName);
        HttpSession session = req.getSession();
        if (isSuccess){
            session.setAttribute("Msg","评论成功");
        }else {
            session.setAttribute("Msg","评论失败");
        }
        req.getRequestDispatcher("/visitArticleContent.jsp").forward(req,resp);

    }
}
