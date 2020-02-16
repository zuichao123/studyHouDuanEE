<%--
  Created by IntelliJ IDEA.
  User: sunjian
  Date: 2020/2/15
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>%
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <c:if test="${sessionScope.message != null}">
       ${sessionScope.message}
    </c:if>
    <div>
        <a href="download.do?fileName=文件下载.txt">文件下载</a>
    </div>
</form>
</body>
</html>
