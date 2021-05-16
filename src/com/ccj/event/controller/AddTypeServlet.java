package com.ccj.event.controller;

import com.ccj.event.bean.AdminBean;
import com.ccj.event.bean.ResultInfo;
import com.ccj.event.entity.Types;
import com.ccj.event.service.Impl.AdminServiceImpl;
import com.ccj.event.service.Impl.TypesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/addTypeServlet")
public class AddTypeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String text = req.getParameter("text");
        HttpSession session = req.getSession();

        ResultInfo resultInfo = new ResultInfo();
        if("".equals(text)||text==null){
            resultInfo.setMsg("错误，输入为空");
            resultInfo.setReg(false);
            String tar = "addType.jsp";
            session.setAttribute("Msg",resultInfo);
            session.setAttribute("target",tar);
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }else {
            TypesServiceImpl typesService = new TypesServiceImpl();
            typesService.addType(text);
            resultInfo.setReg(true);
            resultInfo.setMsg("插入成功");
            //重新查询types表
            AdminServiceImpl adminService = new AdminServiceImpl();
            AdminBean info = adminService.getInfo();
            Map<Integer, Integer> infoResult = info.getResult();
            List<Types> typesList = info.getTypes();
            session.setAttribute("types",typesList);
            session.setAttribute("sum",infoResult);
            req.getRequestDispatcher("/admin_home.jsp").forward(req,resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
