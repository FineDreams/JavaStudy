<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台管理页面</title>
   <script src="<%=basePath %>res/easyui/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="<%=basePath %>res/easyui/jquery.easyui.min.js" type="text/javascript"></script>
	<link href="<%=basePath %>res/easyui/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath %>res/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
	<script src="<%=basePath %>res/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
</head>
  
  <body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:100px;background-color: ">
    	<span style="font-size: 70px;padding-top: 15px;padding-left: 400px">网 上 考 试 系 统</span>
    	<span style="font-size: 25px;color: red;padding-top: 15px;padding-left: 50px">欢迎用户:<a href="#" style="text-decoration: none">admin</a> </span>
    	<span style="font-size: 25px;color:red;padding-top: 15px;padding-left: 30px">身份:管理员</span>
    </div>
    <div data-options="region:'west',split:true" style="width:200px;">
    	<ul id="tt"></ul>
    </div>   
    <div id="mainPanle" data-options="region:'center'," style="padding:5px;background:#eee;">
    	<div id="tabs"  class="easyui-tabs" fit="true" border="false"></div>
    </div>   
</body>  
<script type="text/javascript">
	$(function(){
		$('#tt').tree({
			onClick: function (node) { 
				if(node.text == '退出系统'){
					window.location.href = "/login/toLogin";
				}
		        if (!node.children && node.text != '退出系统'){
		            addTab(node.text,node.url);
		        }
		    },
			data: [{
				text: '题库后台管理',
				state: 'open',
				children: [{
					"iconCls":"icon-edit",    
					text: '题库管理',
					url:'<%=basePath%>/admin/toQuestions'
				},{
					"iconCls":"icon-edit",    
					text: '试卷管理',
					url:'<%=basePath%>/admin/toTestPaper'
				},{
					"iconCls":"icon-edit",
					text: '批阅试卷',
					url:'<%=basePath%>/admin.do?method=enterStudentScorePage'
				}
				
				
				
				]
			},{
				text: '系统维护',
				state: 'open',
				children: [{
					"iconCls":"icon-edit",    
					text: '账号维护',
					url:'<%=basePath%>/admin/toModifyAccount'
				},{
					"iconCls":"icon-edit",    
					text: '退出系统',
                    url:'<%=basePath%>/login/toLogin'
				}]
			}]
		});
		
	})
	
	function addTab(subtitle,url){
		 if (!$('#tabs').tabs('exists', subtitle)) {
		        $('#tabs').tabs('add', {
		            title: subtitle,
		            content: createFrame(url),
		            closable: true,
		            width: $('#mainPanle').width() - 10,
		            height: $('#mainPanle').height() - 26
		        });
		    } else {
		        $('#tabs').tabs('select', subtitle);
		    }
	}
	function closeTab(title){
		if(title == '新增试卷'){
			$.messager.alert('提示','新增试卷成功')
		}
		if(title == '新增题目'){
			$.messager.alert('提示', '已成功保存');
		}
		 $('#tabs').tabs('close',title);
	}
	function createFrame(url) {
	    var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
	    return s;
	}
</script>
</html>
