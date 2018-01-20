<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/17
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>map</title>
</head>
<body>
<form action="map.action" method="post">
    姓名:<input type="text" name="map[0].name"><br>
    密码:<input type="text" name="map[0].password"><br>
    性别:<input type="text" name="map[0].gender"><br>
    年龄:<input type="text" name="map[0].age"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
