<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/25
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册</title>
  </head>
  <body>
    <s:form action="staff_register">
      <s:textfield name="crmStaff.username" label="账号"/>
      <s:textfield name="crmStaff.password" label="密码"/>
      <s:submit label="注册"/>

    </s:form>
  </body>
</html>
