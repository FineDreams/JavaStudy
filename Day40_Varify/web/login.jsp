<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/16
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="">
    username: <input><br>
    password: <input><br>
    验证码: <input name="code" size="4"><img src="${pageContext.request.contextPath}/codeImg.action"><input type="submit" value=" 看不清，换一个 ">
</form>

</body>
</html>
