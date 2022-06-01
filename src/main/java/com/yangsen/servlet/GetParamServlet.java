package com.yangsen.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GetParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        resp.setContentType("text/html");
        resp.getWriter().write("MySQL数据库连接的URL：" + dbUrl);
    }
}
