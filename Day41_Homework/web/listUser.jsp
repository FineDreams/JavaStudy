<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/17
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list存放表单数据</title>
</head>
<body>
    <form action="list.action" method="post">
        姓名:<input type="text" name="list[0].name"><br>
        密码:<input type="text" name="list[0].password"><br>
        性别:<input type="text" name="list[0].gender"><br>
        年龄:<input type="text" name="list[0].age"><br>
        <input type="submit" value="提交">
    </form>

    <%--<s:form action="list" method="POST">--%>
        <%--<s:textfield name="list[0].name"--%>

    <%--</s:form>--%>
</body>
</html>
