package com.ccj.event.controller;

import com.ccj.event.dao.Impl.UserDaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserAccount")
public class FindUserAccount extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);

    }
}
