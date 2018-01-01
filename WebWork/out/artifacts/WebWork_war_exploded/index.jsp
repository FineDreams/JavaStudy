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
          body{
              width: 1349px;
              height: 956px;
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
          <li class="font" style="margin: 30px 5px 30px 10px">
              <a href="Login.html" style="text-decoration-line: none">登录/注册</a>
          </li>
      </ul>
  </div>
  <div id="dv2">
    <div id="searchAll">全部书籍</div>
    <div id="searchJ" >Java相关书籍</div>
    <div id="searchJ2e">java前端书籍</div>
    <div id="searchP">Python相关书籍</div>
    <div id="searchC">C/C++相关书籍</div>
  </div>
    <div id="dv3">
        <div id="j1">
            <img src="img/java1.jpg"style="width: 371px;height: 348px">
            <div class="dh">
            </div>
        </div>
        <div id="w11">
            <img src="img/web1.jpg"style="width: 371px;height: 348px">
            <div class="dh" ></div>
        </div>
        <div id="w13">
            <img src="img/web3.jpg"style="width: 371px;height: 348px">
            <div class="dh" ></div>
        </div>



        <div id="c21">
            <img src="img/c1.jpg"style="width: 371px;height: 348px">
            <div class="dh">
            </div>
        </div>
        <div id="p32">
            <img src="img/p2.jpg"style="width: 371px;height: 348px">
            <div class="dh" ></div>
        </div>
        <div id="j2">
            <img src="img/java2.jpg"style="width: 371px;height: 348px">
            <div class="dh" ></div>
        </div>

    </div>

  </body>
  <script type="text/javascript">
        $('#searchJ').click(function () {
            $('#c21').slideUp();
            $('#w11').slideUp();
            $('#w13').slideUp();
            $('#p32').slideUp();
            $('#j2').slideDown();
            $('#j1').slideDown();
//            $('#c21')&&$('#c22').slideDown();
        })
      $('#searchAll').click(function () {
          $('#dv3>div').slideDown();
      })
        $('#searchJ2e').click(function () {
            $('#c21').slideUp();
            $('#w11').slideDown();
            $('#w13').slideDown();
            $('#p32').slideUp();
            $('#j2').slideUp();
            $('#j1').slideUp();
        })
        $('#searchP').click(function () {
            $('#c21').slideUp();
            $('#w11').slideUp();
            $('#w13').slideUp();
            $('#p32').slideDown();
            $('#j2').slideUp();
            $('#j1').slideUp();
        })
        $('#searchC').click(function () {
            $('#c21').slideDown();
            $('#w11').slideUp();
            $('#w13').slideUp();
            $('#p32').slideUp();
            $('#j2').slideUp();
            $('#j1').slideUp();
        })
  </script>
</html>
