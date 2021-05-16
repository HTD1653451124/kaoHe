package com.ccj.event.controller;

import com.ccj.event.bean.AdminBean;
import com.ccj.event.entity.Types;
import com.ccj.event.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/deleteType")
public class DeleteType extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数
        String typeId = req.getParameter("typeId");
        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.deleteTypes(typeId);
        //删除后重新查询
        AdminBean info = adminService.getInfo();
        Map<Integer, Integer> infoResult = info.getResult();
        List<Types> typesList = info.getTypes();
        HttpSession session = req.getSession();
        session.setAttribute("types",typesList);
        session.setAttribute("sum",infoResult);
        req.getRequestDispatcher("/admin_home.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
