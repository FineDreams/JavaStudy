<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>云科技</title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //删除
            function deleteAccount(accountId) {
                var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
                document.getElementById("operate_result_info").style.display = "block";
                location.href='${pageContext.request.contextPath}/account/deleteAccount?accountId='+accountId;
            }
            //开通或暂停
            function setState(accountId) {
                var r = window.confirm("确定要开通此账务账号吗？");
                document.getElementById("operate_result_info").style.display = "block";
                location.href='${pageContext.request.contextPath}/account/changeStatus?accountId='+accountId;
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="${pageContext.request.contextPath}/images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <jsp:include page="../main/menu.jsp"/>
            <%--<ul id="menu">--%>
                <%--<li><a href="../../index.html" class="index_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/roleList" class="role_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/admin/toAdmin" class="admin_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/accountList?nowPageIndex=1" class="account_on"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/serviceList" class="service_off"></a></li>--%>
                <%--<li><a href="../bill/bill_list.html" class="bill_off"></a></li>--%>
                <%--<li><a href="../report/report_list.html" class="report_off"></a></li>--%>
                <%--<li><a href="../user/user_info.html" class="information_off"></a></li>--%>
                <%--<li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>--%>
            <%--</ul>            --%>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="${pageContext.request.contextPath}/account/accountList?nowPageIndex=1" method="post" name="search">
                <!--查询-->
                <div class="search_add">                        
                    <div>身份证：<input type="text" value="${accountPageBean.idcardNo}" class="text_search" name="idcardNo" /></div>
                    <div>姓名：<input type="text" class="width70 text_search" value="${accountPageBean.realName}" name="realName" /></div>
                    <div>登录名：<input type="text"  value="${accountPageBean.loginName}" class="text_search" name="loginName"/></div>
                    <div>
                        状态：
                        <select class="select_search" name="status">
                            <option value="">全部</option>
                            <option value="1" <c:if test="${accountPageBean.status=='1'}">selected="selected"</c:if>>开通</option>
                            <option value="2" <c:if test="${accountPageBean.status=='2'}">selected="selected"</c:if>>暂停</option>
                            <option value="3" <c:if test="${accountPageBean.status=='3'}">selected="selected"</c:if>>删除</option>
                        </select>
                    </div>
                    <div><input type="submit" value="搜索" class="btn_search"/></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/toAddAccount';" />
                </div>  
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath}/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功，且已删除其下属的业务账号！
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th>账号ID</th>
                        <th>姓名</th>
                        <th class="width150">身份证</th>
                        <th>登录名</th>
                        <th>状态</th>
                        <th class="width100">创建日期</th>
                        <th class="width150">上次登录时间</th>                                                        
                        <th class="width200"></th>
                    </tr>
                        <c:forEach items="${accountPageBean.list}" var="account">
                            <tr>
                                <td>${account.accountId}</td>
                                <td><a href="${pageContext.request.contextPath}/accountDetail?accountId=${account.accountId}">${account.realName}</a></td>
                                <td>${account.idcardNo}</td>
                                <td>${account.loginName}</td>
                                <c:if test="${account.status==1}">
                                    <td>开通</td>
                                </c:if>
                                <c:if test="${account.status==2}">
                                    <td>暂停</td>
                                </c:if>
                                <c:if test="${account.status==3}">
                                    <td>已删除</td>
                                </c:if>
                                <td><fmt:formatDate value="${account.createDate}"/></td>
                                <td><fmt:formatDate value="${account.pauseDate}"/></td>
                                <td class="td_modi">
                                    <c:if test="${account.status==1}">
                                        <input type="button" value="暂停" class="btn_pause" onclick="setState(${account.accountId});" />
                                        <input type="button" value="修改" class="btn_modify" onclick="location.href='/account/toModify?accountId=${account.accountId}';" />
                                        <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${account.accountId});" />
                                    </c:if>
                                    <c:if test="${account.status==2}">
                                        <input type="button" value="开通" class="btn_start" onclick="setState(${account.accountId});" />
                                        <input type="button" value="修改" class="btn_modify" onclick="location.href='/account/toModify?accountId=${account.accountId}';" />
                                        <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${account.accountId});" />
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>


                </table>
                <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
                </div>                   
                <!--分页-->
                <div id="pages">
                    <a href="${pageContext.request.contextPath}/account/accountList?nowPageIndex=${accountPageBean.startPageIndex}&idcardNo=${accountPageBean.idcardNo}&realName=${accountPageBean.realName}&loginName=${accountPageBean.loginName}&status=${accountPageBean.status}">首页</a>
        	        <c:if test="${accountPageBean.nowPageIndex>1}">
                        <a href="${pageContext.request.contextPath}/account/accountList?nowPageIndex=${accountPageBean.nowPageIndex-1}&idcardNo=${accountPageBean.idcardNo}&realName=${accountPageBean.realName}&loginName=${accountPageBean.loginName}&status=${accountPageBean.status}">上一页</a>
                    </c:if>
                    <c:forEach begin="${accountPageBean.startPageIndex}" end="${accountPageBean.pageCount}" var="page">
                        <c:if test="${accountPageBean.nowPageIndex==page}">
                            <a href="#" class="current_page">${page}</a>
                        </c:if>
                        <c:if test="${accountPageBean.nowPageIndex!=page}">
                            <a href="${pageContext.request.contextPath}/account/accountList?nowPageIndex=${page}&idcardNo=${accountPageBean.idcardNo}&realName=${accountPageBean.realName}&loginName=${accountPageBean.loginName}&status=${accountPageBean.status}">${page}</a>
                        </c:if>
                    </c:forEach>
                    <c:if test="${accountPageBean.nowPageIndex<accountPageBean.pageCount}">
                        <a href="${pageContext.request.contextPath}/account/accountList?nowPageIndex=${accountPageBean.nowPageIndex+1}&idcardNo=${accountPageBean.idcardNo}&realName=${accountPageBean.realName}&loginName=${accountPageBean.loginName}&status=${accountPageBean.status}">下一页</a>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/account/accountList?nowPageIndex=${accountPageBean.pageCount}&idcardNo=${accountPageBean.idcardNo}&realName=${accountPageBean.realName}&loginName=${accountPageBean.loginName}&status=${accountPageBean.status}">末页</a>
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
