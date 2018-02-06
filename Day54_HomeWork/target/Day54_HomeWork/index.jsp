<%@ taglib prefix="S" uri="/struts-tags" %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<h1>欢迎用户:<S:property value="%{#user.username}"/> </h1>
<a href="pages/register.jsp"><span>没有账号快去注册吧!</span></a>
</body>

</html>
