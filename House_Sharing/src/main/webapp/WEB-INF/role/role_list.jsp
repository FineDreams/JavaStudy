<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            function deleteRole() {
                var r = window.confirm("确定要删除此角色吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../../images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <jsp:include page="../main/menu.jsp"/>
            <%--<ul id="menu">--%>
                <%--<li><a href="${pageContext.request.contextPath}/login/toIndex" class="index_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/roleList" class="role_on"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/admin/toAdmin" class="admin_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/accountList?nowPageIndex=1" class="account_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/serviceList" class="service_off"></a></li>--%>
                <%--<li><a href="../bill/bill_list.html" class="bill_off"></a></li>--%>
                <%--<li><a href="../report/report_list.html" class="report_off"></a></li>--%>
                <%--<li><a href="../user/user_info.html" class="information_off"></a></li>--%>
                <%--<li><a href="../user/user_modi_pwd.jsp" class="password_off"></a></li>--%>
            <%--</ul>            --%>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='/role/toAddRole';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>                      
                            <c:forEach items="${rolePageBean.list}" var="role">
                        <tr>
                            <td>${role.roleId}</td>
                            <td>${role.name}</td>
                            <td>
                                ${role.group_info}
                            </td>
                            <td>
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='/role/toModifyRole?roleId=${role.roleId}';"/>
                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole();" />
                            </td>
                        </tr>
                            </c:forEach>
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">
                    <c:if test="${rolePageBean.nowPageIndex>1}">
                        <a href="${pageContext.request.contextPath}/role/roleList?nowPageIndex=${rolePageBean.nowPageIndex-1}">上一页</a>
                    </c:if>
                    <c:forEach begin="${rolePageBean.startPageIndex}" end="${rolePageBean.pageCount}" var="page">
                        <c:if test="${rolePageBean.nowPageIndex==page}">
                            <a href="#" class="current_page">${page}</a>
                        </c:if>
                        <c:if test="${rolePageBean.nowPageIndex!=page}">
                            <a href="${pageContext.request.contextPath}/role/roleList?nowPageIndex=${page}">${page}</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${rolePageBean.nowPageIndex<rolePageBean.pageCount}">
                        <a href="${pageContext.request.contextPath}/role/roleList?nowPageIndex=${rolePageBean.nowPageIndex+1}">下一页</a>
                    </c:if>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)云科技有限公司 </p>
        </div>
    </body>
</html>
