<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存成功的提示消息
            function showResult() {
                showResultDiv(true);
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
                <%--<li><a href="${pageContext.request.contextPath}/admin/toAdmin" class="admin_on"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/cost/feeList?nowPageIndex=1" class="fee_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/accountList?nowPageIndex=1" class="account_off"></a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/serviceList" class="service_off"></a></li>--%>
                <%--<li><a href="../bill/bill_list.html" class="bill_off"></a></li>--%>
                <%--<li><a href="../report/report_list.html" class="report_off"></a></li>--%>
                <%--<li><a href="../user/user_info.html" class="information_off"></a></li>--%>
                <%--<li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>--%>
            <%--</ul>--%>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="${pageContext.request.contextPath}/admin/modifyAdmin" method="post" class="main_form">
                <input name="adminId" value="${admin.adminId}" hidden>
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="name" value="${admin.name}" />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">20长度以内的汉字、字母、数字的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info"><input type="text" readonly="readonly" class="readonly" name="adminCode" value="${admin.adminCode}"  /></div>
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" name="telephone" value="${admin.telephone}"  />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">正确的电话号码格式：手机或固话</div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" name="email" value="${admin.email}"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">50长度以内，正确的 email 格式</div>
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul>
                                <c:forEach items="${roleList}" var="role">
                                    <li><input type="checkbox" name="roleIds" value="${role.roleId}" <c:forEach items="${admin.roles}" var="rol"><c:if test="${rol.roleId==role.roleId}">checked</c:if></c:forEach>/>${role.name}</li>
                                </c:forEach>
                                <%--<li><input type="checkbox" />账务账号管理员</li>--%>
                                <%--<li><input type="checkbox" />业务账号管理员</li>--%>
                                <%--<li><input type="checkbox" />账务账号管理员</li>--%>
                                <%--<li><input type="checkbox" />业务账号管理员</li>--%>
                                <%--<li><input type="checkbox" />账务账号管理员</li>--%>
                                <%--<li><input type="checkbox" />业务账号管理员</li>--%>
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <div class="validate_msg_tiny error_msg">至少选择一个</div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="submit" value="保存" class="btn_save" onclick="showResult();" />
                        <input type="button" value="取消" class="btn_save" onclick="location.href='/admin/toAdmin'" />
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
