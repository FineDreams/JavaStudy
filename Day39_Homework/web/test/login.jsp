<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/16
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/user/login.action" method="post">
    用户名: <input type="text" name="username"><br>
    <s:fielderror fieldName="loginFailed"/>
    密码: <input type="password" name="password"><br>
    <s:fielderror fieldName="passwordError"/>
    验证码: <input name="code" size="4"><img src="${pageContext.request.contextPath}/codeImg.action"><br>
    <s:fielderror fieldName="codeFailed"/>
    <input type="submit" value="登录">
</form>

</body>
</html>
