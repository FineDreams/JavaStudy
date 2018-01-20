<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
    <s:form action="add">
        <s:textfield name="employee.name" label="姓名"/>
        <s:textfield name="employee.age" label="年龄"/>
        <s:textfield name="employee.department" label="部门"/>
        <s:textfield name="employee.date" label="入职时间"/>
        <s:textfield name="employee.address" label="家庭住址"/>
        <s:textfield name="employee.phone" label="电话号码"/>
        <s:submit value="添加"/>
    </s:form>
</body>
</html>
