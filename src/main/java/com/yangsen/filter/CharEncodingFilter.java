package com.yangsen.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CharEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //服务器启动时执行
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤测试");
        //tomcat 10 jakarta.servlet 默认就是utf-8。其实不需要设置下面2行的
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //必须
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //服务器关闭时执行
        System.out.println("销毁");
    }
}
