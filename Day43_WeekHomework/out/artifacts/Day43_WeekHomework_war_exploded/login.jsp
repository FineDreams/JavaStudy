<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login.action" method="post">
        <s:fielderror name="loginError"/>
        账号:<input type="text" name="user.username"><br>
        密码:<input type="password" name="user.password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
