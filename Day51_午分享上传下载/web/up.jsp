<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/31
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
</head>
<body>
    <form action="up?method=upFile" method="post" enctype="multipart/form-data">
        <input name="name" type="file">
        <input type="submit" value="提交">
    </form>
</body>
</html>
