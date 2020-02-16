package com.sunjian.controller;

import com.sunjian.entity.Student;
import com.sunjian.entity.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        User user = new User();
        user.setName("sunjian");
        user.setAge(32);

        Student student = new Student();
        student.setName("孙健");
        student.setAge(33);
        student.setNum(100);
        student.setAddress("北京市昌平区百善镇孟祖村365号");

        // 将对象转成json格式
        JSONObject jsonObject = JSONObject.fromObject(user);
        resp.getWriter().print(jsonObject); // 响应到JSP
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
