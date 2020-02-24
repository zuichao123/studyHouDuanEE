<%--
  Created by IntelliJ IDEA.
  User: southwind
  Date: 2018/12/3
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="upload.do" method="post" enctype="multipart/form-data">
        <c:if test="${sessionScope.message != null}">
            ${sessionScope.message}<br/>
        </c:if>
        <input type="text" name="desc"/>
        <input type="file" name="file"/><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
