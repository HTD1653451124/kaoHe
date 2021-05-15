package com.ccj.event.controller;

import com.ccj.event.bean.ResultInfo;
import com.ccj.event.bean.UserBean;
import com.ccj.event.entity.User;
import com.ccj.event.entity.Worker;
import com.ccj.event.service.Impl.UserServiceImpl;
import com.ccj.event.service.Impl.WorkerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/regisUser")
public class RegisUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
