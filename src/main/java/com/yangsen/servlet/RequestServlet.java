package com.yangsen.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String name = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String[] ids = req.getParameterValues("ids");
        resp.setContentType("text/html");
        resp.getWriter().write(name + " " + pwd + " " + String.join(",", ids));

        //请求转发 307
        //前端路径不变
        req.getRequestDispatcher("/success.jsp").forward(req,resp);

    }
}
