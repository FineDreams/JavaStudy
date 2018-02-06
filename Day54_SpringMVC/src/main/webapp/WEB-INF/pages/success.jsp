<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/2/5
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    <h1>成功了！</h1>

<form action="" method="post">
    <input type="text" name="username" value="${user.username}">
    <input type="password" name="password" value="${user.password}">
</form>

</body>
</html>
