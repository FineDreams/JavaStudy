<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>显示界面</title>
  </head>
  <body>
      <s:a action="show">显示所有员工</s:a><br>

      <s:if test="#session.username !=null">
        <s:a href="addEmployee.jsp">增加员工</s:a>
      </s:if>
      <s:elseif test="#session.username==null">
        <s:a href="login.jsp">立即登录</s:a>
      </s:elseif>

      <s:if test="#employeeList !=null">
        <table border="1px">
          <tr>
            <th>id</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>日期</th>
            <th>部门</th>
            <th>住址</th>
            <th>电话号码</th>
            <th>修改</th>
          </tr>
          <s:iterator value="#employeeList" var="employee">
            <tr>
              <td><s:property value="%{#employee.id}"/> </td>
              <td><s:property value="%{#employee.name}"/> </td>
              <td><s:property value="%{#employee.age}"/> </td>
              <td><s:property value="%{#employee.date}"/> </td>
              <td><s:property value="%{#employee.department}"/> </td>
              <td><s:property value="%{#employee.address}"/> </td>
              <td><s:property value="%{#employee.phone}"/> </td>
              <td><s:a action="search">
                编辑
                <s:param name="id" value="%{#employee.id}"/>
              </s:a> </td>
            </tr>

          </s:iterator>
        </table>


      </s:if>
  </body>
</html>
