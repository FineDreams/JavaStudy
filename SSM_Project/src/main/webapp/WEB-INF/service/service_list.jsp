<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            function setState(serviceId) {
                var r = window.confirm("确定要开通此业务账号吗？");
                document.getElementById("operate_result_info").style.display = "block";
                location.href='/service/changServiceStatus?serviceId='+serviceId;
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <jsp:include page="../main/menu.jsp"/>
            <%--<ul id="menu">--%>
                <%--<li><a href="../index.html" class="index_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/roleList" class="role_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/admin/toAdmin" class="admin_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/feeList?nowPageIndex=1" class="fee_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/accountList?nowPageIndex=1" class="account_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/serviceList" class="service_on"></a></li>--%>
                <%--<li><a href="../bill/bill_list.html" class="bill_off"></a></li>--%>
                <%--<li><a href="../report/report_list.html" class="report_off"></a></li>--%>
                <%--<li><a href="../user/user_info.html" class="information_off"></a></li>--%>
                <%--<li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>--%>
            <%--</ul>            --%>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="/service/serviceList" method="post">
                <!--查询-->
                <div class="search_add">                        
                    <div>OS 账号：<input type="text" name="osUsername" value="${ServicePageBean.osUsername}" class="width100 text_search" /></div>
                    <div>服务器 IP：<input type="text" name="unixHost" value="${ServicePageBean.unixHost}" class="width100 text_search" /></div>
                    <div>身份证：<input type="text" name="idcardNo" value="${ServicePageBean.idcardNo}" class="text_search" /></div>
                    <div>状态：
                        <select class="select_search" name="status">
                            <option value="">全部</option>
                            <option value="1" <c:if test="${ServicePageBean.status=='1'}">selected="selected"</c:if>>开通</option>
                            <option value="2" <c:if test="${ServicePageBean.status=='2'}">selected="selected"</c:if>>暂停</option>
                            <option value="3" <c:if test="${ServicePageBean.status=='3'}">selected="selected"</c:if>>删除</option>
                        </select>
                    </div>
                    <div><input type="submit" value="搜索" class="btn_search" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='/toAddService';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">业务ID</th>
                        <th class="width70">账务账号ID</th>
                        <th class="width150">身份证</th>
                        <th class="width70">姓名</th>
                        <th>OS 账号</th>
                        <th class="width50">状态</th>
                        <th class="width100">服务器 IP</th>
                        <th class="width100">资费</th>                                                        
                        <th class="width200"></th>
                    </tr>
                        <c:forEach items="${ServicePageBean.list}" var="service">
                    <tr>

                            <td><a href="${pageContext.request.contextPath}/service/serviceDetail?serviceId=${service.serviceId}" title="查看明细">${service.serviceId}</a></td>
                            <td>${service.accountId}</td>
                            <td>${service.account.idcardNo}</td>
                            <td>${service.account.realName}</td>
                            <td>${service.osUsername}</td>
                            <td>
                            <c:if test="${service.status=='1'}">
                                开通
                            </c:if>
                            <c:if test="${service.status=='2'}">
                                暂停
                            </c:if>
                            <c:if test="${service.status=='3'}">
                                已删除
                            </c:if>
                        </td>
                            <td>${service.unixHost}</td>
                            <td>
                                <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${service.cost.name}</a>
                                <!--浮动的详细信息-->
                                <div class="detail_info">
                                    ${service.cost.descr}
                                </div>
                            </td>
                            <td class="td_modi">
                                <c:if test="${service.status=='1'}">
                                    <input type="button" value="暂停" class="btn_start" onclick="setState(${service.serviceId});" />
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/service/toServiceModify?serviceId=${service.serviceId}';" />
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${service.serviceId});" />
                                </c:if>
                                <c:if test="${service.status=='2'}">
                                    <input type="button" value="开通" class="btn_pause" onclick="setState(${service.serviceId});" />
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/service/toServiceModify?serviceId=${service.serviceId}';" />
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${service.serviceId});" />
                                </c:if>
                            </td>

                    </tr>
                        </c:forEach>
                </table>                
                <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
                </div>                    
                <!--分页-->
                <div id="pages">
                    <a href="${pageContext.request.contextPath}/service/serviceList?nowPageIndex=${ServicePageBean.startPageIndex}&idcardNo=${ServicePageBean.idcardNo}&osUsername=${ServicePageBean.osUsername}&unixHost=${ServicePageBean.unixHost}&status=${ServicePageBean.status}">首页</a>
        	        <c:if test="${ServicePageBean.nowPageIndex>1}">
                        <a href="${pageContext.request.contextPath}/service/serviceList?nowPageIndex=${ServicePageBean.nowPageIndex-1}&idcardNo=${ServicePageBean.idcardNo}&osUsername=${ServicePageBean.osUsername}&unixHost=${ServicePageBean.unixHost}&status=${ServicePageBean.status}">上一页</a>
                    </c:if>

                    <c:forEach begin="${ServicePageBean.startPageIndex}" end="${ServicePageBean.pageCount}" var="page">
                        <c:if test="${ServicePageBean.nowPageIndex==page}">
                            <a href="#" class="current_page">${page}</a>
                        </c:if>
                        <c:if test="${ServicePageBean.nowPageIndex!=page}">
                            <a href="${pageContext.request.contextPath}/service/serviceList?nowPageIndex=${page}&idcardNo=${ServicePageBean.idcardNo}&osUsername=${ServicePageBean.osUsername}&unixHost=${ServicePageBean.unixHost}&status=${ServicePageBean.status}">${page}</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${ServicePageBean.nowPageIndex<ServicePageBean.pageCount}">
                        <a href="${pageContext.request.contextPath}/service/serviceList?nowPageIndex=${ServicePageBean.nowPageIndex+1}&idcardNo=${ServicePageBean.idcardNo}&osUsername=${ServicePageBean.osUsername}&unixHost=${ServicePageBean.unixHost}&status=${ServicePageBean.status}">下一页</a>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/service/serviceList?nowPageIndex=${ServicePageBean.pageCount}&idcardNo=${ServicePageBean.idcardNo}&osUsername=${ServicePageBean.osUsername}&unixHost=${ServicePageBean.unixHost}&status=${ServicePageBean.status}">末页</a>
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
