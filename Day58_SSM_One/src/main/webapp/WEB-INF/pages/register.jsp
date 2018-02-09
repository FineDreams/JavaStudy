<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/2/8
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/register" method="post">
        账号:<input type="text" name="username"><br>
        密码:<input type="text" name="password"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
