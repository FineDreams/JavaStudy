<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <%--</ul>--%>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${cost.id}" /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="包 ${cost.base_duration} 小时"/></div>
                <div class="text_info clearfix"><span>资费状态：</span></div>
                <div class="input_info">
                    <select class="readonly" disabled>
                        <c:if test="${cost.status==0}">
                            <option>暂停</option>
                        </c:if>
                        <c:if test="${cost.status==1}">
                            <option>开通</option>
                        </c:if>
                    </select>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                        <input type="radio" name="cost_type" <c:if test="${cost.cost_type=='1'}">checked="checked"</c:if> value="1" id="monthly" disabled="disabled" />
                        <label for="monthly">包月</label>
                        <input type="radio" name="cost_type" <c:if test="${cost.cost_type=='2'}">checked="checked"</c:if> value="2" id="package" disabled="disabled" />
                        <label for="package">套餐</label>
                        <input type="radio" name="cost_type" <c:if test="${cost.cost_type=='3'}">checked="checked"</c:if> value="3" id="timeBased" disabled="disabled" />
                        <label for="timeBased">计时</label>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <input type="text" class="readonly" readonly value="${cost.base_duration}"  />
                    <span>小时</span>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value="${cost.base_cost}" />
                    <span>元</span>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value="${cost.unit_cost} " />
                    <span>元/小时</span>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value="<fmt:formatDate value="${cost.creatime}"/>" /></div>
                <div class="text_info clearfix"><span>启动时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value="<fmt:formatDate value="${cost.startime}"/>" /></div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70 readonly" readonly>${cost.descr}</textarea>
                </div>                    
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='fee_list.jsp';" />
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
