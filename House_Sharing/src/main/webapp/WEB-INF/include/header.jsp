<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Date: 2018/2/27
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div id="header">
    <c:if test="${power==null}">
        <a href="${pageContext.request.contextPath}/login/toLogin" style="font-size: 20px;margin-right: 25px;color: brown">立即登录</a>
    </c:if>
    <c:if test="${power == '2'}">
        <a style="font-size: 20px;margin-right: 25px;color: red">身份:管理员</a>

        <a href="#" style="font-size: 20px;margin-right: 25px">用户名:${admin.adminCode}</a>

    </c:if>
    <c:if test="${power == '1'}">
        <a style="font-size: 20px;margin-right: 25px">身份:会员</a>

        <a href="${pageContext.request.contextPath}/user/toInfo" style="font-size: 20px;margin-right: 25px">用户名:${user.username}</a>
    </c:if>

    <img src="../images/logo.png" alt="logo" class="left"/>
    <a href="${pageContext.request.contextPath}/login/quit" style="font-size: 20px;margin-right: 15px">[退出]</a>
</div>
