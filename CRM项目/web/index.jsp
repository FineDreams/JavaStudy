<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/25
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1><s:fielderror fieldName="loginMsg"/> </h1>

    <s:form action="staff_login">
        <s:textfield name="crmStaff.username" label="用户"/>
        <s:textfield name="crmStaff.password" label="密码"/>
        <s:submit value="登录"/>
    </s:form>

  </body>
</html>
