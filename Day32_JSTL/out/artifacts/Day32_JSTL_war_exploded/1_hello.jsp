<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/5
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="yy" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Core</title>
</head>
<body>
    <%--
        创建变量
        在request域中，创建一个属性名为name
        值为张三的域属性
    --%>
    <yy:set var="name" value="张三" scope="request"/>
    <%--
        如果要修改域属性中的javaBean
        target：javaBean在域属性中的属性名
        property：要修改的javaBean的属性
        value：要修改成什么值
    --%>
    ${requestScope.name}
    <yy:set target="${user}" property="name" value="李四"/>
    <br>
    ${requestScope.user.gender}
</body>
</html>
