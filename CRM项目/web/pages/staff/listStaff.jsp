<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/core.js"></script>

</head>


<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<%--<a href="${pageContext.request.contextPath}/pages/staff/addStaff.jsp">--%>
	  		<%--<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />--%>
	  	<%--</a>--%>
		<s:url action="staff_getList" var="get"></s:url>
		<s:a href="%{#get}">
			<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
		</s:a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<s:form id="conditionFormId" action="staff_queryGroup" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
	    	<%--<select name="crmPost.crmDepartment.depId" onchange="showPost(this)">--%>
			    <%--<option value="">--请选择部门--</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000001">教学部</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000002">咨询部</option>--%>
			<%--</select>--%>
				<s:select list="allInfoCrmStaffList" name="crmPost.crmDepartment.depId"
						  listKey="depId" listValue="depName"
						  onchange="changePost(this)"
						  headerKey="" headerValue="----请--选--择----"/>

	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	    	
	    	<%--<select name="crmPost.postId" id="postSelectId">--%>
			    <%--<option value="">--请选择职务--</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000003">总监</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000004">讲师</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000005">主管</option>--%>
			<%--</select>--%>
				<s:select list="crmPost !=null ?crmPost.crmDepartment.crmPosts : {}"
						  name="crmPost.postId"
						  listKey="postId" listValue="postName" id="postSelectId"
						  headerKey="" headerValue="----请--选--择----"/>

	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><input type="text" name="staffName" size="12" /></td>
	    <td ></td>
	  </tr>
	</table>
</s:form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

 <s:if test="#crmStaffList!=null">

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>
  
    <%--<s:iterator value="allInfoCrmStaffList" var="crmDepartment">--%>
    <s:iterator value="#crmStaffList" var="crmStaff">

		<%--<s:iterator value="#crmDepartment.crmPosts" var="crmPost">--%>

		<%--<s:iterator value="#crmPost.crmStaffs" var="crmStaff">--%>
	  <tr class="tabtd1">
	    <td align="center"><s:property value="%{#crmStaff.staffName}" /></td>
	    <td align="center"><s:property value="%{#crmStaff.gender}" /></td>
	    <td align="center"><s:property value="%{#crmStaff.onDutyDate}" /></td>
	    <td align="center"><s:property value="%{#crmStaff.crmPost.crmDepartment.depName}" /></td>
	    <td align="center"><s:property value="%{#crmStaff.crmPost.postName}" /></td>
	  	<td width="7%" align="center">
	  		<a href="<s:url value="staff_queryInfoByStaffId.action"><s:param name="staffId" value="%{#crmStaff.staffId}"/> </s:url> "><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
	  	</td>
	  </tr>
			</s:iterator>
		<%--</s:iterator>--%>
	<%--</s:iterator>--%>
</table>
 </s:if>
</body>

</html>
