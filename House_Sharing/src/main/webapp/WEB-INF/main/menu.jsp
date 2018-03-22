<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/3/5
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>menu</title>
</head>
<body>
    <ul id="menu">
        <%--<h1>${currentModule}</h1>--%>
            <c:choose>
                <c:when test="${currentModule=='0'||sessionScope.power==null}">
                    <li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_on"></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_off"></a></li>
                </c:otherwise>
            </c:choose>

            <c:if test="${sessionScope.power==null}">
                <li><a href="${pageContext.request.contextPath}/service/serviceList" class="service_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_off"></a></li>
            </c:if>

            <c:if test="${sessionScope.power=='1'}">
                <c:choose>
                    <c:when test="${currentModule=='1'}">
                        <li><a href="${pageContext.request.contextPath}/service/serviceList" class="service_on"></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/service/serviceList" class="service_off"></a></li>
                    </c:otherwise>
                </c:choose>
                <%--<li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_on"></a></li>--%>
                <li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_off"></a></li>

                <c:choose>
                    <c:when test="${currentModule==2}">
                        <li><a href="${pageContext.request.contextPath}/user/toInfo" class="information_on"></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/user/toInfo" class="information_off"></a></li>
                    </c:otherwise>
                </c:choose>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </c:if>
            <c:if test="${sessionScope.power=='2'}">
                <%--<li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_on"></a></li>--%>
                <li><a href="${pageContext.request.contextPath}/role/roleList" class="role_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/account/accountList" class="account_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/user/toInfo" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </c:if>
        <%--<c:choose>--%>
            <%--<c:when test="${sessionScope.power==null}">--%>
                <%--<li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_on"></a></li>--%>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
                <%--<li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_off"></a></li>--%>
            <%--</c:otherwise>--%>
            <%----%>
        <%--</c:choose>--%>

        <%--<c:forEach items="${allModules}" var="module">--%>
            <%--<c:if test="${module.moduleId==1}">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${currentModule==1}">--%>
                        <%--<li><a href="${pageContext.request.contextPath}/role/roleList" class="role_on"></a></li>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<li><a href="${pageContext.request.contextPath}/role/roleList" class="role_off"></a></li>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</c:if>--%>
            <%--<c:if test="${module.moduleId==2}">--%>
                <%--<c:choose>--%>
                <%--<c:when test="${currentModule==2}">--%>
                    <%--<li><a href="${pageContext.request.contextPath}/admin/toAdmin" class="admin_on"></a></li>--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<li><a href="${pageContext.request.contextPath}/admin/toAdmin" class="admin_off"></a></li>--%>
                <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</c:if>--%>
            <%--<c:if test="${module.moduleId==3}">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${currentModule==3}">--%>
                        <%--<li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_on"></a></li>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_off"></a></li>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</c:if>--%>
            <%--<c:if test="${module.moduleId==4}">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${currentModule==4}">--%>
                        <%--<li><a href="${pageContext.request.contextPath}/account/accountList" class="account_on"></a></li>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<li><a href="${pageContext.request.contextPath}/account/accountList" class="account_off"></a></li>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</c:if>--%>
            <%--<c:if test="${module.moduleId==5}">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${currentModule==5}">--%>
                        <%--<li><a href="${pageContext.request.contextPath}/service/serviceList" class="service_on"></a></li>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<li><a href="${pageContext.request.contextPath}/service/serviceList" class="service_off"></a></li>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</c:if>--%>
        <%--</c:forEach>--%>
    </ul>
</body>
</html>
