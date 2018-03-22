<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
        <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
        <script language="javascript" type="text/javascript">
            //排序按钮的点击事件
            function sort(btnObj) {
                var value = btnObj.value;
                if (value === "基费"){value = "base_cost"}else {value = "base_duration"}
                if (btnObj.className === "sort_desc"){
                    btnObj.className = "sort_asc";
                } else{
                    btnObj.className = "sort_desc";
                }
                window.location.href = "${pageContext.request.contextPath}/feeList?nowPageIndex=${pageBean.nowPageIndex}&sort="+btnObj.className+"&group="+value;
            }

            //启用
            function startFee(id) {
                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
                location.href='/cost/modifyStatus?id='+id;
                document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteFee(id) {
                var r = window.confirm("确定要删除此资费吗？");
                location.href='/cost/delete?id='+id;
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
                <%--<li><a href="${pageContext.request.contextPath}/roleList" class="role_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/admin/toAdmin" class="admin_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_on"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/accountList?nowPageIndex=1" class="account_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/serviceList" class="service_off"></a></li>--%>
                <%--<li><a href="../../bill/bill_list.html" class="bill_off"></a></li>--%>
                <%--<li><a href="../../report/report_list.html" class="report_off"></a></li>--%>
                <%--<li><a href="../../user/user_info.html" class="information_off"></a></li>--%>
                <%--<li><a href="../../user/user_modi_pwd.html" class="password_off"></a></li>--%>
            <%--</ul>            --%>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                        <input type="button" value="基费" class="<c:choose><c:when test="${pageBean.group == 'base_cost'}">${pageBean.sort}</c:when><c:otherwise>sort_asc</c:otherwise></c:choose>" onclick="sort(this);" />
                        <input type="button" value="时长" class="<c:choose><c:when test="${pageBean.group == 'base_duration'}">${pageBean.sort}</c:when><c:otherwise>sort_asc</c:otherwise></c:choose>" onclick="sort(this);" />
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/cost/toAdd';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>
                        <c:forEach items="${pageBean.list}" var="cost">
                            <tr>
                                <td>${cost.id}</td>
                                <td><a href="${pageContext.request.contextPath}/cost/costDetail?id=${cost.id}">${cost.name}</a></td>
                                <c:if test="${cost.base_duration!=null}">
                                    <td>${cost.base_duration}小时</td>
                                </c:if>
                                <c:if test="${cost.base_duration==null}">
                                    <td></td>
                                </c:if>
                                <c:if test="${cost.base_cost!=null}">
                                    <td>${cost.base_cost}元</td>
                                </c:if>
                                <c:if test="${cost.base_cost==null}">
                                    <td></td>
                                </c:if>
                                <td>${cost.unit_cost} 元/小时</td>
                                <td><fmt:formatDate value="${cost.creatime}"/></td>
                                <td><fmt:formatDate value="${cost.startime}"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${cost.status==0}">
                                            暂停
                                        </c:when>
                                        <c:otherwise>
                                            开通
                                        </c:otherwise>
                                    </c:choose>
                                </td>

                                <td>
                                    <c:if test="${cost.status=='0'}">
                                        <input type="button" value="启用" class="btn_pause" onclick="startFee(${cost.id});" />
                                        <input type="button" value="修改" class="btn_modify" onclick="location.href='/cost/modifyDetail?id=${cost.id}';" />
                                        <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${cost.id});" />
                                    </c:if>
                                    <c:if test="${cost.status=='1'}">
                                        <input type="button" value="暂停" class="btn_start" onclick="startFee(${cost.id});" />
                                        <input type="button" value="修改" class="btn_modify" onclick="location.href='/cost/modifyDetail?id=${cost.id}';" />
                                        <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${cost.id});" />
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div id="pages">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${pageBean.pageCount}"/>

                    <c:if test="${pageBean.nowPageIndex>1}">
                        <a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=${pageBean.nowPageIndex-1}&sort=${pageBean.sort}&group=${pageBean.group}">上一页</a>
                    </c:if>
                    <c:forEach begin="${begin}" end="${end}" var="np">
                            <c:if test="${pageBean.nowPageIndex==np}">
                                <a href="#" class="current_page">${np}</a>
                            </c:if>
                            <c:if test="${pageBean.nowPageIndex!=np}">
                                <a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=${np}&sort=${pageBean.sort}&group=${pageBean.group}">${np}</a>
                            </c:if>
                        </a>
                    </c:forEach>
                    <c:if test="${pageBean.nowPageIndex<pageBean.pageCount}">
                        <a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=${pageBean.nowPageIndex+1}&sort=${pageBean.sort}&group=${pageBean.group}">下一页</a>
                    </c:if>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)云科技有限公司</p>
        </div>
    </body>
</html>
