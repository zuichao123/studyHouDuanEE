<%--
  Created by IntelliJ IDEA.
  User: southwind
  Date: 2019-02-19
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="user">
        ${user.id}---${user.username}---${user.password}---${user.age}<br/>
    </c:forEach>
</body>
</html>
