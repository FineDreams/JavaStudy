<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2017/12/29
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>不语首页</title>
      <link href="../css/home.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
      <style type="text/css">
          body,html{
              width: 1900px;
              height: 956px;
              /*width: 100%;*/
              background-color: antiquewhite;
          }
      </style>
  </head>
  <body>
  <div class="dv1">
      <ul class="ul1">
          <li>
              <img style="height:60px;width:80px" src="../img/log.png">
          </li>
          <li  style="font-size: 34px;font-family:金梅浪漫豆豆字體 ;margin:15px 5px 20px 5px;">不语首页</li>
          <!--<li  style="font-size: 33px;font-family: 楷体;margin:20px 5px 20px 3px">登录</li>-->
      </ul>
      <ul class="ul2">
          <li class="font" style="margin: 30px 20px 30px 5px">退出</li>
          <li style="margin: 30px 10px 30px 10px">|</li>
          <li id="dl" class="font" style="margin: 30px 5px 30px 10px">
              <a href="Login.html" style="text-decoration-line: none">登录/注册</a>
          </li>

          <li id="nickname" class="font" style="margin: 30px 5px 30px 10px;float: right"></li>
      </ul>
  </div>
    <div id="dv2">
        <div id="showTime" onload="" style="font-size: 20px; width: 180px;height: 30px;float: right;margin: 20px 30px 10px 30px">

        </div>
    </div>
    <div id="dv3">

    </div>

  </body>
  <script type="text/javascript">
      function user() {
          $.get("http://localhost:8080/login",function (data) {
              if (data!=null){
                  $('#nickname').text('用户:'+data)
                  $('#dl').slideUp();
              }else {
                  $('#dl').slideDown();
              }
          })

      }
      user();

      function time() {
          var mytime=new Date();
          var toLocaleString = mytime.toLocaleString();
          var show = document.getElementById("showTime");
          show.innerText=toLocaleString;
      }
      time();
      function showTime(){
          setInterval(time,1000)
      }
      showTime();
  </script>
</html>
