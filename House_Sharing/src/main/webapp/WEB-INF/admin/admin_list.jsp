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
            //重置密码
            function resetPwd() {
                alert("请至少选择一条数据！");
                //document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteAdmin(adminId) {
                var r = window.confirm("确定要删除此管理员吗？");
                document.getElementById("operate_result_info").style.display = "block";
                location.href='/admin/deleteAdmin?adminId='+adminId;
            }
            //全选
            function selectAdmins(inputObj) {
                var inputArray = document.getElementById("datalist").getElementsByTagName("input");
                for (var i = 1; i < inputArray.length; i++) {
                    if (inputArray[i].type == "checkbox") {
                        inputArray[i].checked = inputObj.checked;
                    }
                }
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
                <%--<li><a href="${pageContext.request.contextPath}/roleList" class="role_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/admin/toAdmin" class="admin_on"></a></li>--%>
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
            <form action="${pageContext.request.contextPath}/admin/toAdmin" method="post">
                <!--查询-->
                <div class="search_add">
                    <div>
                        模块：
                        <select id="selModules" class="select_search" name="moduleId">
                            <option value="">全部</option>
                            <c:forEach items="${modules}" var="module">
                                <option value="${module.moduleId}"<c:if test="${module.moduleId==AdminPageBean.moduleId}">selected</c:if>>${module.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>角色：<input type="text" name="roleName" value="${AdminPageBean.roleName}" class="text_search width200" /></div>
                    <div><input type="submit" value="搜索" class="btn_search"/></div>
                    <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();" />
                    <input type="button" value="增加" class="btn_add" onclick="location.href='/admin/toAddAdmin';" />
                </div>
                <!--删除和密码重置的操作提示-->
                <div id="operate_result_info" class="operate_fail">
                    <img src="../../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
                </div> 
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="th_select_all">
                                <input type="checkbox" onclick="selectAdmins(this);" />
                                <span>全选</span>
                            </th>
                            <th>管理员ID</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th class="width100">拥有角色</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${AdminPageBean.list}" var="admin">
                            <tr>
                                <td><input type="checkbox" /></td>
                                <td>${admin.adminId}</td>
                                <td>${admin.name}</td>
                                <td>${admin.adminCode}</td>
                                <td>${admin.telephone}</td>
                                <td>${admin.email}</td>
                                <td><fmt:formatDate value="${admin.enrolldate}"/></td>
                                <td>
                                    <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${admin.roles[0].name}</a>
                                    <!--浮动的详细信息-->
                                    <div class="detail_info">
                                        <c:forEach items="${admin.roles}" var="role" varStatus="status">
                                            ${role.name}
                                            <c:if test="${!status.last}">、</c:if>
                                        </c:forEach>
                                    </div>
                                </td>
                                <td class="td_modi">
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='/admin/toModifyAdmin?adminId=${admin.adminId}';" />
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin(${admin.adminId});" />
                                </td>
                            </tr>
                        </c:forEach>


                    </table>
                </div>
                <!--分页-->
                <div id="pages">
                    <c:if test="${AdminPageBean.nowPageIndex>1}">
                        <a href="${pageContext.request.contextPath}/admin/toAdmin?nowPageIndex=${AdminPageBean.nowPageIndex-1}&moduleId=${AdminPageBean.moduleId}&roleName=${AdminPageBean.roleName}">上一页</a>
                    </c:if>
                    <c:forEach begin="${AdminPageBean.startPageIndex}" end="${AdminPageBean.pageCount}" var="page">
                        <c:if test="${AdminPageBean.nowPageIndex==page}">
                            <a href="#" class="current_page">${page}</a>
                        </c:if>
                        <c:if test="${AdminPageBean.nowPageIndex!=page}">
                            <a href="${pageContext.request.contextPath}/admin/toAdmin?nowPageIndex=${page}&moduleId=${AdminPageBean.moduleId}&roleName=${AdminPageBean.roleName}">${page}</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${AdminPageBean.nowPageIndex<AdminPageBean.pageCount}">
                        <a href="${pageContext.request.contextPath}/admin/toAdmin?nowPageIndex=${AdminPageBean.nowPageIndex+1}&moduleId=${AdminPageBean.moduleId}&roleName=${AdminPageBean.roleName}">下一页</a>
                    </c:if>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <span>版权所有(C)云科技有限公司 </span>
        </div>
    </body>
</html>
