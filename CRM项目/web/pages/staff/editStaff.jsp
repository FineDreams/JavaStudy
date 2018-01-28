<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:if test="#crmStaff != null">
<form action="staff_editAll.action" method="post">
	
	<input type="hidden" name="crmStaff.staffId" value="<s:property value="%{#crmStaff.staffId}"/> "/>
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="crmStaff.loginName" value="<s:property value="%{#crmStaff.loginName}"/> " /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="crmStaff.loginPwd" value="<s:property value="%{#crmStaff.loginPwd}"/>" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="crmStaff.staffName" value="<s:property value="%{#crmStaff.staffName}"/>" /> </td>
	    <td>性别：</td>
	    <td>
	    	<input type="radio" name="crmStaff.gender" checked="checked" value="男"/>男
	    	<input type="radio" name="crmStaff.gender" value="女"/>女
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<select name="crmStaff.crmPost.crmDepartment.depId"  onchange="changePost(this)">
			    <option value="">----请--选--择----</option>
			    <option value="ee050687bd1a4455a153d7bbb7000001" selected="selected">教育部</option>
			    <option value="ee050687bd1a4455a153d7bbb7000002">咨询部</option>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select name="crmStaff.crmPost.postId" id="postSelectId">
			    <option value="">----请--选--择----</option>
			    <option value="ee050687bd1a4455a153d7bbb7000003">总监</option>
			    <option value="ee050687bd1a4455a153d7bbb7000004" selected="selected">讲师</option>
			    <option value="ee050687bd1a4455a153d7bbb7000005" selected="selected">主管</option>
			</select>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="crmStaff.onDutyDate" value="<s:property value="%{#crmStaff.onDutyDate}"/>" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>
</s:if>
</body>
</html>
