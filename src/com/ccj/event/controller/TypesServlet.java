package com.ccj.event.controller;

import com.ccj.event.entity.Types;
import com.ccj.event.service.Impl.TypesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/typesServlet")
public class TypesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TypesServiceImpl typesService = new TypesServiceImpl();
        List<Types> allTypes = typesService.findAll();
        HttpSession session = req.getSession();
        session.setAttribute("types",allTypes);
        req.getRequestDispatcher("/publish.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
