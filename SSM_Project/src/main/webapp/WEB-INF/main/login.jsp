<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/styles/global_color.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    </head>
    <body class="index">
    <form action="" method="post" id="myform">
        <div class="login_box">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input id="admin_code" name="adminCode" type="text" class="width150" /></td>
                    <td class="login_error_info"><span class="required" id="admin_code_msg"></span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input id="password" name="password" type="password" class="width150" /></td>
                    <td><span class="required" id="password_msg"></span></td>
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input name="code" type="text" class="width70" id="code" onfocus="set_msg()"/></td>
                    <td><img src="${pageContext.request.contextPath}/login/createImage" alt="验证码" title="点击更换" id="code_image" onclick="change();"/></td>
                    <td><span class="required" id="code_msg"></span></td>
                </tr>            
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a href="javascript:check_login();"><img src="${pageContext.request.contextPath}/images/login_btn.png" /></a>
                    </td>    
                    <td><span class="required"></span></td>
                </tr>
            </table>
        </div>
    </form>
    </body>
<script type="text/javascript">
    function check_login() {
        var admin_code = $("#admin_code").val();
        console.log(admin_code);
        if (admin_code == "") {
            $("#admin_code_msg").text("请输入账号.");
            return;
        }
        var password = $("#password").val();
        console.log(password);
        if (password == "") {
            $("#password_msg").text("请输入密码.");
            return;
        }
        var code=$("#code").val();
        console.log(code);
        if (code == ""){
            $("#code_msg").text("请输入验证码.");
            return;
        }
        console.log("我走到这里来了");
        $.post("${pageContext.request.contextPath}/login/ajaxLogin",
            $("#myform").serialize(),
            function (data) {
                console.log("进啦么？");
                if (data.flag == 1) {
                $("#admin_code_msg").text("账号密码.");
            } else if (data.flag == 2) {
                $("#password_msg").text("密码错误.");
            }else if(data.flag==3){
                $("#code_msg").text("验证码错误.");
                change();
            } else {
                location.href = "${pageContext.request.contextPath}/login/toIndex";
            }
        });
    }
    //            设置提示信息
    function set_msg(id, msg) {
        $("#"+id).text(msg);
    }
    //            刷新验证码
    function change() {
        $("#code_image").attr("src","${pageContext.request.contextPath}/login/createImage?date="+new Date().getTime());
    }
</script>
</html>
