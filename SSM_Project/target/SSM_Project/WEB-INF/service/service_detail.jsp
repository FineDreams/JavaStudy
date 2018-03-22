<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/styles/global_color.css" />
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
                <%--<li><a href="${pageContext.request.contextPath}/feeList?nowPageIndex=1" class="fee_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/accountList?nowPageIndex=1" class="account_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/serviceList" class="service_on"></a></li>--%>
                <%--<li><a href="../bill/bill_list.html" class="bill_off"></a></li>--%>
                <%--<li><a href="../report/report_list.html" class="report_off"></a></li>--%>
                <%--<li><a href="../user/user_info.html" class="information_off"></a></li>--%>
                <%--<li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>--%>
            <%--</ul>--%>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <form action="" method="" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>业务账号ID：</span></div>
                <div class="input_info"><input type="text" value="${service.serviceId}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>账务账号ID：</span></div>
                <div class="input_info"><input type="text" value="${service.accountId}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>客户姓名：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${service.account.realName}" /></div>
                <div class="text_info clearfix"><span>身份证号码：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${service.account.idcardNo}" /></div>
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info"><input type="text" value="${service.unixHost}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>OS 账号：</span></div>
                <div class="input_info"><input type="text" value="${service.osUsername}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>状态：</span></div>
                <div class="input_info">
                    <select disabled name="status">
                        <option value="1" <c:if test="${service.status=='1'}">selected="selected"</c:if>>开通</option>
                        <option value="2" <c:if test="${service.status=='2'}">selected="selected"</c:if>>暂停</option>
                        <option value="3" <c:if test="${service.status=='3'}">selected="selected"</c:if>>删除</option>
                    </select>                        
                </div>
                <div class="text_info clearfix"><span>开通时间：</span></div>
                <div class="input_info"><input readonly value="<fmt:formatDate value="${service.createDate}"/>" type="text" class="readonly"/></div>
                <div class="text_info clearfix"><span>资费 ID：</span></div>
                <div class="input_info"><input type="text" value="${service.cost.id}" class="readonly" readonly /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info"><input type="text" value="${service.cost.name}" readonly class="width200 readonly" /></div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70 readonly" readonly>${service.cost.descr}</textarea>
                </div>  
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/service/serviceList';" />
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
             <span>版权所有(C)云科技有限公司 </span>
        </div>
    </body>
</html>
