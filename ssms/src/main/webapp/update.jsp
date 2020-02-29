<%--
  Created by IntelliJ IDEA.
  User: southwind
  Date: 2019-02-20
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=path %>/layui/css/layui.css"  media="all">
</head>
<body>
<div class="layui-container" style="width: 700px;height: 600px;margin-top: 0px;padding-top: 60px;">
    <form class="layui-form" action="/user/update" method="post">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">用户编号：</label>
                <div class="layui-input-inline">
                    <input type="tel" name="id" value="${requestScope.user.id}" readonly lay-verify="required|phone" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">用户名：</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" value="${requestScope.user.username}" lay-verify="email" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">密码：</label>
                <div class="layui-input-inline">
                    <input type="text" name="password" value="${requestScope.user.password}" lay-verify="email" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">年龄：</label>
                <div class="layui-input-inline">
                    <input type="text" name="age" value="${requestScope.user.age}" lay-verify="email" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="demo2">跳转式提交</button>
        </div>
    </form>
</div>
</body>
</html>
