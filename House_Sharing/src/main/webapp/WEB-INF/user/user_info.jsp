﻿<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存成功的提示信息
            function showResult() {
                showResultDiv(true);
                document.modifyUser.submit();
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
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
            <jsp:include page="menu.jsp"/>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，数据并发错误！-->
            <form action="${pageContext.request.contextPath}/user/modifyUser" method="post" class="main_form" name="modifyUser">
                <input type="text" name="uid" value="${sessionScope.user.uid}" hidden>
                <div class="text_info clearfix"><span>账号：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${sessionScope.user.username}" /></div>
                <div class="text_info clearfix"><span>身份：</span></div>
                <div class="input_info">
                    <input type="text" readonly="readonly" class="readonly width400" value="普通会员" />
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" name="realname" value="${sessionScope.user.realname}" />
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">20长度以内的汉字、字母的组合</div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" name="phone" class="width200" value="${sessionScope.user.phone}" />
                    <div class="validate_msg_medium">电话号码格式：手机或固话</div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" name="email" class="width200" value="${sessionScope.user.email}" />
                    <div class="validate_msg_medium">50长度以内，符合 email 格式</div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="<fmt:formatDate value="${sessionScope.user.enrolldat}"/>"></div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" onclick="showResult();" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>版权所有(Tianyao)</p>
        </div>
    </body>
</html>
