package com.yangsen.listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class ListenerServlet implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //创建session的监听器
        System.out.println("创建session了："+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //销毁session的监听器
        System.out.println("销毁session了："+se.getSession().getId());
    }
}
