<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
    </head>
    <body class="index">
    <jsp:include page="../include/header.jsp"/>
        <!--导航区域开始-->
        <div id="index_navi">
            <jsp:include page="menu.jsp"/>
            <%--<ul id="menu">--%>
                <%--<li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_on"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/role/roleList" class="role_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/admin/toAdmin" class="admin_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/account/accountList" class="account_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/service/serviceList" class="service_off"></a></li>--%>
                <%--<li><a href="../bill/bill_list.html" class="bill_off"></a></li>--%>
                <%--<li><a href="../report/report_list.html" class="report_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/user/toInfo" class="information_off"></a></li>--%>
                <%--<li><a href="../user/user_modi_pwd.jsp" class="password_off"></a></li>--%>
            <%--</ul>--%>
        </div>
    </body>
</html>
