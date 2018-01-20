<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑页面</title>
</head>
<body>
    <s:if test="#employee !=null">
        <s:form action="modify" method="POST">
            <s:textfield name="employee.id" value="%{#employee.id}" label="id"/>
            <s:textfield name="employee.name" value="%{#employee.name}" label="姓名"/>
            <s:textfield name="employee.age" value="%{#employee.age}" label="年龄"/>
            <s:textfield name="employee.department" value="%{#employee.department}" label="部门"/>
            <s:textfield name="employee.date" value="%{#employee.date}" label="入职时间"/>
            <s:textfield name="employee.address" value="%{#employee.address}" label="家庭住址"/>
            <s:textfield name="employee.phone" value="%{#employee.phone}" label="电话号码"/>
            <s:submit value="修改"/>
        </s:form>
    </s:if>
</body>
</html>
