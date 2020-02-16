package com.sunjian.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置为下载模式
        resp.setContentType("application/x-msdownload");

        // 获取文件的存放路径
        String path = req.getServletContext().getRealPath("files");
        // 获取文件名 --------
        String fileName = req.getParameter("fileName");
        // 设置文件名，并处理中文
        resp.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        // 判断文件是否存在
        File file = new File(path + "/" + fileName);
        if(!file.exists()){
            String message = "文件不存在！";
            System.out.println(message);
            HttpSession session = req.getSession();
            session.setAttribute("message", message);
            resp.sendRedirect("download.jsp");
            return;
        }

        // 字节输入流
        InputStream inputStream = new FileInputStream(file);
        // 获取响应输出流
        OutputStream outputStream = resp.getOutputStream();
        int temp = 0;
        while ((temp = inputStream.read()) != -1){
            outputStream.write(temp);
        }
        // 关流
        outputStream.close();
        inputStream.close();

        System.out.println("下载successful");
    }
}
