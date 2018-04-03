<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../../images/logo.png" alt="logo" class="left"/>
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
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>户主：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${rental.user.realname}" /></div>
                <div class="text_info clearfix"><span>房屋类型：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${rental.type}"/></div>
                <div class="text_info clearfix"><span>出租状态：</span></div>
                <div class="input_info">
                    <select class="readonly" disabled>
                        <c:if test="${rental.state==1}">
                            <option>已出租</option>
                        </c:if>
                        <c:if test="${rental.state==2}">
                            <option>出租</option>
                        </c:if>
                    </select>
                </div>
                <div class="text_info clearfix"><span>地点：</span></div>
                <div class="input_info">
                    <input type="text" class="readonly" readonly value="${rental.place}"  />
                </div>
                <div class="text_info clearfix"><span>出租价格：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value="${rental.price}" />
                    <span>元</span>
                </div>
                <div class="text_info clearfix"><span>房屋面积：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value="${rental.area} " />
                    <span>平方米</span>
                </div>
                <div class="text_info clearfix"><span>发布时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value="<fmt:formatDate value="${rental.lenddate}"/>" /></div>
                <div class="text_info clearfix"><span>联系电话：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value="${rental.user.phone}"/></div>
                <div class="text_info clearfix"><span>房屋简介：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70 readonly" readonly>${rental.info}</textarea>
                </div>                    
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='rental_list.jsp';" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>版权所有(Tianyao)</span>
        </div>
    </body>
</html>
