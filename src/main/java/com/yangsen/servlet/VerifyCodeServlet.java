package com.yangsen.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一个图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        //设置图片的背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, 80, 20);
        //给图片写数据
        graphics.setColor(Color.pink);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        graphics.drawString(makeCode(), 0, 20);

        //浏览器定时刷新
        resp.setHeader("refresh", "3");
        resp.setContentType("image/jpeg");
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        ImageIO.write(image, "jpeg", resp.getOutputStream());

    }

    private String makeCode() {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(999999) + "";
    }
}
