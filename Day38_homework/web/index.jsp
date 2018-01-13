<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/12
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>分页显示</title>
  </head>
  <body>
      <form action="/show" method="get">
        姓名:<input type="text" name="uname"><br>
        性别:<input type="text" name="gender"><br>
        分数:<input type="text" name="score"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" name="search" value="查询"><br>
      </form>
    <c:if test="${requestScope.pageBean!=null}">
      <table border="1px">
        <tr>
          <th>姓名</th>
          <th>性别</th>
          <th>分数</th>
          <th>年龄</th>
        </tr>


        <c:forEach var="user" items="${requestScope.pageBean.users}">
          <tr>
            <td>${user.uname}</td>
            <td>${user.gender}</td>
            <td>${user.score}</td>
            <td>${user.age}</td>
          </tr>

        </c:forEach>

      </table>

      <c:set var="totalPages" value="${requestScope.pageBean.totalPages}"/>
      <c:set var="begin" value="1"/>

      <c:if test="${requestScope.pageBean.pageCode-5>=1}">
        <c:set var="begin" value="${requestScope.pageBean.pageCode-5}"/>
      </c:if>

      <c:set var="end" value="${totalPages}"/>
      <c:if test="${requestScope.pageBean.pageCode+4<=totalPages}">
        <c:set var="end" value="${requestScope.pageBean.pageCode+4}"/>
      </c:if>
      <c:if test="${end<=totalPages}">
        <c:set var="end" value="${totalPages}"/>
      </c:if>

      <c:if test="${begin>=end-totalPages+1}">
        <c:set var="begin" value="${end-totalPages+1}"/>
      </c:if>
<%--上一页--%>
      <c:if test="${requestScope.pageBean.pageCode>1}">
        <a href="show?pc=${requestScope.pageBean.pageCode-1}&${requestScope.pageBean.params}">上一页</a>
      </c:if>

      <%--页面页码--%>
      <c:forEach var="value" begin="${begin}" end="${end}">
        <a href="<c:url value="show?pc=${value}&${requestScope.pageBean.params}"/> ">
        <c:if test="${requestScope.pageBean.pageCode==value}">
          ${value}
        </c:if>
          <c:if test="${requestScope.pageBean.pageCode!=value}">
            [${value}]
          </c:if>
        </a>
      </c:forEach>
      <%--下一页--%>
      <c:if test="${requestScope.pageBean.pageCode<totalPages}">
        <a href="show?pc=${requestScope.pageBean.pageCode+1}&${requestScope.pageBean.params}">下一页</a>

      </c:if>

    </c:if>


  </body>
</html>
