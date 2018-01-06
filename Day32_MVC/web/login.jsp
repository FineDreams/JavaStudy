<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/5
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <c:if test="${requestScope.errorMsg!=null}">
        <h1>${requestScope.errorMsg}</h1>
    </c:if>

    <form action="user" method="post">
        <input type="hidden" name="method" value="login">
        用户:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit" value="登录"><hr>
    </form>
</body>
</html>
