package com.yangsen.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class DownloadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取文件位置
        String filepath = this.getServletContext().getRealPath("/WEB-INF/classes/fengjing.jpeg");
        //2 获取文件名字
        String filename = filepath.substring(filepath.lastIndexOf("/") + 1);
        //3 设置浏览器支持文件下载 为了应对文件名是中文 增加了URLEncoder.encode(filename,"utf-8"))
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename,"utf-8"));
        //4 获取下载文件的输入流 从文件输入
        FileInputStream fis = new FileInputStream(filepath);
        //5 设置buffer
        int len = 0;
        byte[] buffer = new byte[1024];
        //6 获取response输出流对象
        ServletOutputStream out = resp.getOutputStream();
        //7 读取文件流中的数据写入到response输出流
        while ((len = fis.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        //8 关闭流
        fis.close();
        out.close();
    }
}
