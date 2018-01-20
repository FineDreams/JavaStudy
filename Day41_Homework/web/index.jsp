<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/17
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>show展示</title>
  </head>
  <body>
  <h1>list集合展示</h1>
    <table border="1px">
      <tr>
        <th>成员</th>
        <th>姓名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
      </tr>

      <s:iterator value="list" var="user" status="number">
      <tr>
        <td>${number.index+1}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
        <td>${user.gender}</td>
        <td>${user.age}</td>
      </tr>
      </s:iterator>
    </table>



  <h1>map集合展示</h1>
    <table border="1px">
      <tr>
        <th>成员</th>
        <th>姓名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
      </tr>

      <s:iterator value="map" var="user" status="number">
        <tr>
          <%--<td>${number.index+1}</td>--%>
          <%--<td>${user.value.name}</td>--%>
          <%--<td>${user.value.password}</td>--%>
          <%--<td>${user.value.gender}</td>--%>
          <%--<td>${user.value.age}</td>--%>

          <td><s:property value="number.index+1"/> </td>
          <td><s:property value="#map.value.name"/></td>
          <td><s:property value="#map.value.password"/></td>
          <td><s:property value="#map.value.gender"/></td>
          <td><s:property value="#map.value.age"/></td>
        </tr>
      </s:iterator>


    </table>
  </body>
</html>
