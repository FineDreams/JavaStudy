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
        function deleteAccount(serviceId) {
            var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
            document.getElementById("operate_result_info").style.display = "block";
            location.href='/service/deleteService?serviceId='+serviceId;
        }
        //开通或暂停
        function setState(rid) {
            var r = window.confirm("确定要租房吗？");
            document.getElementById("operate_result_info").style.display = "block";
            location.href='${pageContext.request.contextPath}/user/changeState?rid='+rid;
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
                    <th class="width50">户型</th>
                    <th class="width70">户主</th>
                    <th class="width100">地点</th>
                    <th class="width70">面积/平方米</th>
                    <th>价格</th>
                    <th class="width100">联系电话</th>
                    <th class="width100">日期</th>
                    <th class="width100">状态</th>
                    <th class="width100">简介</th>
                    <th class="width150"></th>
                </tr>
                <c:forEach items="${pageBean.list}" var="rental">
                    <tr>

                        <td><a href="${pageContext.request.contextPath}/user/toRentalDetail?rid=${rental.rid}" title="查看明细">${rental.type}</a></td>
                        <td>${rental.user.username}</td>
                        <td>${rental.place}</td>
                        <td>${rental.area}</td>
                        <td>${rental.price}</td>
                        <td>${rental.user.phone}</td>
                        <td><fmt:formatDate value="${rental.lenddate}"/></td>
                        <td>
                            <c:if test="${rental.state=='1'}">
                                已出租
                            </c:if>
                            <c:if test="${rental.state=='2'}">
                                出租
                            </c:if>
                        </td>
                            <%--<td>${service.unixHost}</td>--%>
                        <td>
                            <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${rental.info}</a>
                            <!--浮动的详细信息-->
                            <div class="detail_info">
                                    ${rental.info}
                            </div>
                        </td>
                        <td class="td_modi">
                            <input type="button" value="删除" class="btn_delete" onclick="location.href='${pageContext.request.contextPath}/admin/deleteRental?rid=${rental.rid}';" />
                            <input type="button" value="查看" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/user/toRentalDetail?rid=${rental.rid}';" />

                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="${pageContext.request.contextPath}/admin/queryAllRentals?nowPageIndex=${pageBean.startPageIndex}">首页</a>
            <c:if test="${pageBean.nowPageIndex>1}">
                <a href="${pageContext.request.contextPath}/admin/queryAllRentals?nowPageIndex=${pageBean.nowPageIndex-1}">上一页</a>
            </c:if>

            <c:forEach begin="${pageBean.startPageIndex}" end="${pageBean.endPageIndex}" var="page">
                <c:if test="${pageBean.nowPageIndex==page}">
                    <a href="#" class="current_page">${page}</a>
                </c:if>
                <c:if test="${pageBean.nowPageIndex!=page}">
                    <a href="${pageContext.request.contextPath}/admin/queryAllRentals?nowPageIndex=${page}">${page}</a>
                </c:if>
            </c:forEach>

            <c:if test="${pageBean.nowPageIndex<pageBean.pageCount}">
                <a href="${pageContext.request.contextPath}/admin/queryAllRentals?nowPageIndex=${pageBean.nowPageIndex+1}">下一页</a>
            </c:if>
            <a href="${pageContext.request.contextPath}/admin/queryAllRentals?nowPageIndex=${pageBean.pageCount}">末页</a>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>版权所有(Tianyao) </p>
</div>
</body>
</html>
