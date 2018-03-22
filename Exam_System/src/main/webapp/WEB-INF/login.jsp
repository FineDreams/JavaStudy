<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>登录</title>
	<script src="<%=basePath %>res/easyui/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="<%=basePath %>res/easyui/jquery.easyui.min.js" type="text/javascript"></script>
	<link href="<%=basePath %>res/easyui/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath %>res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
	<script src="<%=basePath %>res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
</head>
<body style="background-image: url('/images/bg.jpg');">
<div id="loginWindow" class="easyui-window" title="网上考试登陆窗口" data-options="iconCls:'icon-vixtel'" style="width:320px;height:180px;padding:5px;background: #fafafa;">
	<br>
	<div border="false" style=" padding-left:50px; border:0px solid #ccc;">
        <form>
            <table>
                <tr>
                    <td>
                    <input class="easyui-textbox" id="stuNumber" style="width:100%;height:30px;padding:12px"
                           data-options="prompt:'登录名',iconCls:'icon-man',iconWidth:38"/>
                    </td>
                </tr>
                <tr>
                    <td>
                    <input class="easyui-textbox" type="password" id="password"
                           style="width:100%;height:30px;padding:12px" data-options="prompt:'登录密码',iconCls:'icon-lock',iconWidth:38"/>
                    </td>
                </tr>
            </table>
        </form>
	</div>
	<div border="false" style="text-align:left;height:30px;line-height:30px; margin-top:6px;">
		<div style="padding-left:60px;">
			<a class="easyui-linkbutton"  style="width:90px;" href="javascript:login()" id="btnLogin">登陆</a>
			<a class="easyui-linkbutton"  style="width:90px;" href="${pageContext.request.contextPath}/student/toRegister" id="regis">注册</a>
		</div>
	</div>
</div>
<script type="text/javascript">
	function login(){
		if($.trim($('#stuNumber').val())==''||$.trim($('#password').val())==''){
			$.messager.alert('错误', '用户名或密码为空');
		}else{
			$.ajax({
				url:'<%=basePath%>/login/ajaxLogin',
				type:'post',
				dataType:'json',
				data:{stuNumber:$.trim($('#stuNumber').val()),password:$.trim($('#password').val())},
				success:function(data){
					if(data.flag == '0'){
						$.messager.alert('错误', '用户不存在!');
					}
					if(data.flag == '1'){
                        $.messager.alert('错误', '密码错误!');
					}
					if(data.flag == '2'){
						 window.location.href = "<%=basePath%>/student/toIndex";
					}
					if(data.flag == '3'){
						 window.location.href = "<%=basePath%>/admin/toIndex";
					}
				}
			})
		}
	}
</script>
</body>
</html>