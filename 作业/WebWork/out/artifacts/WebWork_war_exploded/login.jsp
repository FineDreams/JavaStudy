<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link href="css/work.css" rel="stylesheet">
    <style type="text/css">
        body{
            width: 1920px;
        }
    </style>
</head>
<body>
<div class="top" style="height: 90px;width: 100%">
    <ul class="ul1">
        <li>
            <img style="height:60px;width:80px" src="img/log.png">
        </li>
        <li  style="font-size: 34px;font-family: 金梅浪漫豆豆字體;margin:15px 5px 20px 5px">不语</li>
        <li  style="font-size: 33px;font-family: 楷体;margin:20px 5px 20px 3px">登录</li>
    </ul>
    <ul class="ul2">
        <li class="font" style="margin: 30px 20px 30px 5px">帮助文档</li>
        <li style="margin: 30px 10px 30px 10px">|</li>
        <li class="font" style="margin: 30px 5px 30px 10px">
            <a href="index.jsp" style="text-decoration-line: none">不语首页</a>
        </li>
    </ul>
</div>
<div  style="width: 180px;height: 30px;float: right;margin: 20px 30px 10px 30px">
    <span id="showTime" onload=""></span>
</div>
<img style="width:626px;height: 428px;margin:200px 30px 100px 300px "  src="img/bord.jpg">
<div class="top"style="height: 580px;width: 610px;float: right;margin: 100px 50px 100px 20px">
    <div class="font2">不语登录</div>
    <img src="img/user.png" style="width: 40px;height: 40px;position: absolute;top: 284px;left: 1055px">
    <form action="/login" method="post">

    <input name="uname" type="text" class="in" style="font-size: 20px;padding-left: 50px"
           placeholder="不语账号/邮箱账号"
           onfocus="inputFocus(this)";
           onblur="inputBlur(this)";
           value=<%=application.getAttribute("uname")%>
    >
    <img src="img/lock.png" style="width: 40px;height: 40px;position: absolute;top: 376px;left: 1055px">
    <input name="password" type="text" class="in" style="font-size: 20px;padding-left: 50px"
           placeholder="请输入登录密码"
           onfocus="inputDF(this)";
           onblur="inputDB(this)";
    >
    <div class="indiv">
        <div style="float: left">
            <input type="checkbox"id="t1">
            <label for="t1">同意并遵守<span style="color: rgb(72,102,202)">《服务条款》</span></label>
        </div>
        <div style="float: right">
            <input type="checkbox"id="t2">
            <label for="t2">15天免登陆</label>
        </div>
    </div>
        <input type="submit"  class="inb" style="color: white;cursor: pointer"value="登录" >
    </form>
    <div class="indiv2">
        <div class="font4 ">还没有账号?<span style="color: rgb(72,102,202)"><a href="register.html">免费注册</a></span></div>
        <div class="font3 ">忘记密码?</div>
    </div>
</div>
</body>
<script type="text/javascript">
    function inputFocus(el) {
        el.placeholder="";
        el.style.borderColor="red";
        el.style.color="red";
        el.style.fontSize="40px";
    }
    function inputBlur(el) {
        el.placeholder="不语账号/邮箱账号";
        el.style.borderColor="";
        el.style.color="black";
        el.style.fontSize="20px";
    }
    function inputDF(el) {
        el.placeholder="";
        el.style.borderColor="red";
        el.style.color="red";
        el.style.fontSize="40px";
    }
    function inputDB(el) {
        el.placeholder="请输入登录密码";
        el.style.borderColor="";
        el.style.color="black";
        el.style.fontSize="20px";
    }
    function time() {
        var mytime=new Date();
        var toLocaleString = mytime.toLocaleString();
        var show = document.getElementById("showTime");
        show.innerText=toLocaleString;
    }
    //        window.onload = time;
    time();
    function showTime(){
        setInterval(time,1000)
    }
    showTime();
</script>
</html>