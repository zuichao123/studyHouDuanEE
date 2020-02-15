package com.sunjian.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        uploadFiles(req, resp);

//        uploadFilesForUtilsCharacterStream(req, resp);
        uploadFilesForUtilsByteStream(req, resp);
    }

    /**
     * 字符流上传
     * @param req
     * @param resp
     */
    private void uploadFilesForUtilsCharacterStream(HttpServletRequest req, HttpServletResponse resp) {
        InputStream inputStream = null;
        BufferedReader bufr = null;
        OutputStream outputStream = null;
        BufferedWriter bufw = null;

        // 1、创建DiskFileItemFactory
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2、创建文件解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 2.5、设置文件大小限制（1bytes*1024=1KB * 1024=1MB * 1024=1GB * 1024=1TB）
        int size = 5;
        upload.setSizeMax(1024 * 1024 * size);
        try {
            // 3、获取List<FileItem>
            List<FileItem> list = upload.parseRequest(req);
            // 4、判断FileItem的类型，是否为表单域（文本输入）
            for (FileItem fileItem : list) {
                // 如果是表单域，表示该值是一段文本，打印输出
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();// 标签名
                    String value = fileItem.getString("utf-8"); // 处理中文乱码
                    System.out.println(name + ":" + value);
                } else {
                    // 如果不是表单域，表示该值是一个文件，通过IO完成上传
                    inputStream = fileItem.getInputStream();
                    bufr = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

                    outputStream = new FileOutputStream(req.getServletContext().getRealPath("files") + "/" + fileItem.getName());
                    bufw = new BufferedWriter(new OutputStreamWriter(outputStream));

                    String data = null;
                    while ((data = bufr.readLine()) != null) {
                        System.out.println(data);
                        bufw.write(data + "\n");
                    }
                }
            }
        } catch (FileUploadException e) {
            String message = "文件大小不能超过"+size+"M，请重新选择上传！";
            req.getSession().setAttribute("message", message);
            try {
                System.out.println(message);
                resp.sendRedirect("index.jsp");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关流
            try {
                bufw.close();
                outputStream.close();
                bufr.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 字节流上传
     * @param req
     * @param resp
     */
    private void uploadFilesForUtilsByteStream(HttpServletRequest req, HttpServletResponse resp) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        
        // 1、创建DiskFileItemFactory
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2、创建文件解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 2.5、设置文件大小限制（1bytes*1024=1KB * 1024=1MB * 1024=1GB * 1024=1TB）
        int size = 5;
        upload.setSizeMax(1024 * 1024 * size);
        // 3、获取List<FileItem>
        try {
            List<FileItem> list = upload.parseRequest(req);
            // 4、判断FileItem的类型，是否为表单域（文本输入）
            for (FileItem fileItem : list) {
                // 如果是表单域，表示该值是一段文本，打印输出
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();// 标签名
                    String value = fileItem.getString("utf-8");
                    System.out.println(name + ":" + value);
                } else {
                    inputStream = fileItem.getInputStream();
                    outputStream = new FileOutputStream(req.getServletContext().getRealPath("files") + "/" + fileItem.getName());
                    int temp = 0;
                    while ((temp = inputStream.read()) != -1) {
                        System.out.println(temp);
                        outputStream.write(temp);
                    }                    
                }
            }
        } catch (FileUploadException e) {
            String message = "文件大小不能超过"+size+"M，请重新选择上传！";
            req.getSession().setAttribute("message", message);
            try {
                System.out.println(message);
                resp.sendRedirect("index.jsp");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private void uploadFiles(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取输入流
        InputStream inputStream = req.getInputStream();
        // 转成缓冲字符流，并指定编码格式
        BufferedReader bufr = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

        /** 将读取的上传文件输出到指定文件**/

        // 定义输出流，并指定输出路径文件
        OutputStream outputStream = new FileOutputStream(req.getServletContext().getRealPath("files" + "/" + "copy.txt"));
        // 定义缓冲输出流
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(outputStream));
        String data = null;
        while ((data = bufr.readLine()) != null) {
            System.out.println(data);
            bufw.write(data);
        }

        // 关流
        bufw.close();
        outputStream.close();
        bufr.close();
        inputStream.close();
    }
}