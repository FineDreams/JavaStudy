<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/2/5
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<s:form action="user_login" method="post">
    <s:fielderror fieldName="loginError"/>
    用户:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
</s:form>

</body>
</html>
