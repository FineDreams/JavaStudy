<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/16
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="/user/register.action" method="post">
    用户名: <input type="text" name="user.username"><br>
        <s:fielderror fieldName="usernameMsg"/>
    密码: <input type="password" name="user.password"><br>
        <s:fielderror fieldName="passwordMsg"/>
    确认密码: <input type="password" name="user.sureword"><br>
        <s:fielderror fieldName="surewordMsg"/>
    电话号码: <input type="text" name="user.phone"><br>
        <s:fielderror fieldName="phoneMsg"/>
    邮箱: <input type="text" name="user.email"><br>
        <s:fielderror fieldName="emailMsg"/>
    验证码: <input name="user.code" size="4"><img src="${pageContext.request.contextPath}/codeImg.action"><br>
        <s:fielderror fieldName="codeMsg"/>
        <input type="submit" value="注册">
</form>

</body>
</html>
