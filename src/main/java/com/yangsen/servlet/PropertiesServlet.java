package com.yangsen.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");

        //使用properties加载属性文件，配置文件
        var props = new Properties();
        props.load(is);
        var driver = props.getProperty("driver");
        var url = props.getProperty("url");
        var user = props.getProperty("user");
        var pass = props.getProperty("pass");

        resp.setContentType("text/html");
        resp.getWriter().write("读取到的数据："+driver + url + user + pass);
    }
}
