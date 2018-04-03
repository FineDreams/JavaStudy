<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
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
            <ul id="menu">
                <jsp:include page="menu.jsp"/>
            </ul>
        </div>
        <!--导航区域结束-->
        <div id="main">      
            <!--保存操作后的提示信息：成功或者失败-->      
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，旧密码错误！-->
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                    <input type="password" id="password" class="width200"  /><span class="required">*</span>
                    <div style="display: none" id="oldInfo" class="validate_msg_medium">原密码错误,请重新输入!</div>
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input type="password" id="newpassword" name="newPassword" class="width200" /><span class="required">*</span>
                    <div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input type="password" id="repeat" class="width200"/><span class="required">*</span>
                    <div id="info" style="display: none" class="validate_msg_medium">两次新密码必须相同</div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" onclick="changePassword()" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>版权所有(Tianyao) </p>
        </div>
    <script type="text/javascript">
        function changePassword() {
            var newpassword=document.getElementById("newpassword").value;
            var repeat=document.getElementById("repeat").value;
            var passWord=document.getElementById("password").value;
            var infoResult=document.getElementById("info")
            if (newpassword!=repeat){
                infoResult.style.display = "block";
            }else {
                infoResult.style.display = "none";
                $.ajax({
                    url:'${pageContext.request.contextPath}/user/modifyPassword',
                    type:'post',
                    dataType:'json',
                    data:{uid:${sessionScope.user.uid},password:passWord,newPassword:newpassword},
                    success:function (data) {
                        if (data.flag=='1'){
                            document.getElementById("oldInfo").style.display="block";
                        }
                        if (data.flag=='2'){
                            document.getElementById("oldInfo").style.display="none";
                            window.location.href='${pageContext.request.contextPath}/login/toLogin';
                        }
                    }

                })
            }
        }
    </script>
    </body>
</html>
