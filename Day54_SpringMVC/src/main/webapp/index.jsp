<%@page isELIgnored="false" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%--默认为忽视EL表达式，这里设置为不忽视--%>
<html>
<body>
<h2>Hello World!</h2>
<h1>login</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label>
        用户:<input type="text" name="username">
    </label><br/>
    <label>
        密码:<input type="password" name="password">
    </label><br/>
    <input type="submit" value="登录">

</form>

<h1>login2</h1>
<form action="${pageContext.request.contextPath}/login2" method="post">
    <%--
        name属性的值为username
        而不是user.username
        会自动找到对应控制器方法参数列表中
        User user这个user参数的username
        通过set方法给这个属性赋值
    --%>
    <label>
        用户:<input type="text" name="username">
    </label><br/>
    <label>
        密码:<input type="password" name="password">
    </label><br/>
        学号:
        老师:<input type="checkbox" name="ids" value="1">
        学生:<input type="checkbox" name="ids" value="2">
        游客:<input type="checkbox" name="ids" value="3">

    <input type="submit" value="登录">

</form>

<h1>login3</h1>
<form action="${pageContext.request.contextPath}/login3" method="post">
    <input type="text" name="user.username"><br>
    <input type="text" name="user.password"><br>
    <input type="text" name="code"><br>
    <input type="text" name="message"><br>
    <input type="text" name="user.list[0]"><br>
    <input type="text" name="user.list[1]"><br>
    <input type="text" name="user.list[2]"><br>
    <input type="text" name="user.map['o1']"><br>
    <input type="text" name="user.map['o2'].user.username"><br>
    <input type="submit" value="注册">
</form>

<h1>login4:回显</h1>
<form action="${pageContext.request.contextPath}/login4" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" name="注册">
<a href="${pageContext.request.contextPath}/updateById/2">点我</a>
</form>

<h1>注册</h1>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="username"><br>
        <input type="password" name="password"><br>
        <input type="number" name="id"><br>
        <input type="submit" value="注册">
    </form>

</body>
</html>
