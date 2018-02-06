<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/2/5
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
        选择文件:
        <input type="file" name="item">
        <input type="submit" value="上传">
    </form>
</body>
</html>
