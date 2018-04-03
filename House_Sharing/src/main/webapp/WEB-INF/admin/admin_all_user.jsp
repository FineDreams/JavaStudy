<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        //显示角色详细信息
        function showDetail(flag, a) {
            var detailDiv = a.parentNode.getElementsByTagName("div")[0];
            if (flag) {
                detailDiv.style.display = "block";
            }
            else
                detailDiv.style.display = "none";
        }
        //删除
        function deleteAccount(uid) {
            var r = window.confirm("确定要删除此账号吗？删除后将不能恢复。");
            document.getElementById("operate_result_info").style.display = "block";
            location.href='${pageContext.request.contextPath}/admin/deleteUser?uid='+uid;
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="../images/logo.png" alt="logo" class="left"/>
    <a href="${pageContext.request.contextPath}/login/quit">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <jsp:include page="../main/menu.jsp"/>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="${pageContext.request.contextPath}/user/queryRentals" method="post">
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
            删除成功！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th class="width50">用户账号</th>
                    <th class="width70">真实姓名</th>
                    <th class="width70">邮箱</th>
                    <th class="width100">联系电话</th>
                    <th class="width100">日期</th>
                    <th class="width100">状态</th>
                    <th class="width150"></th>
                </tr>
                <c:forEach items="${pageBean.list}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.realname}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td><fmt:formatDate value="${user.enrolldat}"/></td>
                        <td>
                            <c:if test="${user.power=='1'}">
                                学生
                            </c:if>
                            <c:if test="${user.power=='2'}">
                                管理员
                            </c:if>
                        </td>
                        <td class="td_modi">
                                    <input type="button" value="删除" class="btn_start" onclick="deleteAccount(${user.uid});" />
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="${pageContext.request.contextPath}/admin/queryAllUser?nowPageIndex=${pageBean.startPageIndex}">首页</a>
            <c:if test="${pageBean.nowPageIndex>1}">
                <a href="${pageContext.request.contextPath}/admin/queryAllUser?nowPageIndex=${pageBean.nowPageIndex-1}">上一页</a>
            </c:if>

            <c:forEach begin="${pageBean.startPageIndex}" end="${pageBean.endPageIndex}" var="page">
                <c:if test="${pageBean.nowPageIndex==page}">
                    <a href="#" class="current_page">${page}</a>
                </c:if>
                <c:if test="${pageBean.nowPageIndex!=page}">
                    <a href="${pageContext.request.contextPath}/admin/queryAllUser?nowPageIndex=${page}">${page}</a>
                </c:if>
            </c:forEach>

            <c:if test="${pageBean.nowPageIndex<pageBean.pageCount}">
                <a href="${pageContext.request.contextPath}/admin/queryAllUser?nowPageIndex=${pageBean.nowPageIndex+1}">下一页</a>
            </c:if>
            <a href="${pageContext.request.contextPath}/admin/queryAllUser?nowPageIndex=${pageBean.pageCount}">末页</a>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>版权所有(Tianyao) </p>
</div>
</body>
</html>
