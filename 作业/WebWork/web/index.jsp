<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2017/12/29
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
          <li id="exit" class="font" style="margin: 30px 20px 30px 5px"><a href="/loginOut">退出</a></li>
          <li style="margin: 30px 10px 30px 10px">|</li>
          <li id="dl" class="font" style="margin: 30px 5px 30px 10px">
              <a href="login.jsp" style="text-decoration-line: none">登录/注册</a>
          </li>
          <li id="nickname" class="font" style="margin: 30px 5px 30px 10px;float: right"></li>
      </ul>
  </div>
    <div id="dv2">
        <div id="showTime" onload="" style="font-size: 20px; width: 180px;height: 30px;float: right;padding: 0px; margin: 9px -193px 10px 30px">

        </div>
    </div>
    <div id="dv3">
        <div style="width: 183px;height: 70%;background-color: darksalmon;border: solid 1px black;float: left">
            <button onclick="btnClick(this)">全部图书分类</button>
            <button onclick="btnClick(this)">小说</button>
            <button onclick="btnClick(this)">经济管理</button>
            <button onclick="btnClick(this)">成功励志</button>
            <button onclick="btnClick(this)">历史传记</button>
            <button onclick="btnClick(this)">计算机</button>
            <button onclick="btnClick(this)">文学艺术</button>
            <button onclick="btnClick(this)">社会科学</button>
            <button onclick="btnClick(this)">外文</button>
            <button onclick="btnClick(this)">其他分类</button>
        </div>
        <input style="margin: 0px 5px 6px 11px;width: 224px;height: 32px;font-size: 24px" id="search" bookType="text">
        <input style="width: 70px;height: 30px" type="submit" value="查找书籍">
        <%
            if (session.getAttribute("uname")!=null){
        %>
        <table id="all" style="font-size: 30px;width: 1140px;height: 100px">

        </table>
        <%
        }else {
        %>
        <h1 style="font-size: 25px;margin: -444px -143px 10px 10px;float: right"><a href="login.jsp">请先登录</a></h1>
        <%
            }
        %>
        <%--<c:if test="${session.getAttribute('uname')!=null}">--%>
            <%--<table id="all" style="font-size: 30px;width: 1140px;height: 100px">--%>

            <%--</table>--%>
        <%--</c:if>--%>

        <%--<c:if test="${session.getAttribute('uname')==null}">--%>
            <%--<h1 style="font-size: 25px;margin: -444px -143px 10px 10px;float: right"><a href="login.jsp">请先登录</a></h1>--%>
        <%--</c:if>--%>
        <div id="tb" style="width: 1143px;height: 916px;border: solid 1px black;float: right">
        </div>
    </div>

  </body>
  <script type="text/javascript">

      function btnClick(ele) {
          var text = $(ele).text();
          if (text === "全部图书分类"){
              $('table').css({"display":"table"})
          }else {
              $('table').css({"display":"none"})
              $('table[name='+text+']').css({"display":"block"})
          }
      }
      function book() {
          $.getJSON("http://localhost:8080/bookInfo",function (data, status) {
              if (status=="success"){
//                  var jsonData=$.parseJSON(data);
                  if (data!=null){
                      $('tr').remove();
//                      $('table').append(
//                          $('<tr>').append(
//                              $('<td>').text('bid')
//                          ).append(
//                              $('<td>').text('书名')
//                          ).append(
//                              $('<td>').text('作者')
//                          ).append(
//                              $('<td>').text('价格')
//                          )
//
//                      )
                      $.each(data,function (index, obj) {
                          $('#tb').append(
                              $('<table>').attr({"border":1,"name":obj['bookType']}).append(
                                  $('<tr>').append(
                                      $('<td>').css({"overflow":"hidden","box-shadow":"rgb(176,176,176) 0px 5px 5px","border-radius":"10px"}).append($('<a>').attr({"href":"http://localhost:8080/showInfo.jsp?bid="+obj['bid']}).append($('<img>').attr({"src":obj['src']})))
                                  )
                              ).append(
                                  $('<tr>').append(
                                      $('<td>').text('书号:'+obj['bid'])
                                  )
                              ).append(
                                  $('<tr>').append(
                                      $('<td>').text('书名:'+'《'+obj['bkname']+'》')
                                  )
                              ).append(
                                  $('<tr>').append(
                                      $('<td>').text('作者:'+obj['author'])
                                  )
                              ).append(
                                  $('<tr>').append(
                                      $('<td>').css({"color":"red"}).text('价格:'+'￥'+obj['price'])
                                  )
                              )
//                                  .append(
//                                  $('<tr>').append(
//                                      $('<td>').append(
//                                          $('<input>').attr({"class":"inpt"}).attr({"bookType":"submit","value":"加入购物车"})).append(
//                                              $('<input>').attr({"class":"inpt"}).attr({"bookType":"submit","value":"立即购买"}))
//                                  )
//                              )
                          )
                      })
//                      $.each(data,function (index, obj) {
//                         $('table').append(
//                              $('<tr>').append(
//                                  $('<td>').text(obj['bid'])
//                              ).append(
//                                  $('<td>').append($('<a>').attr({"href":"http://localhost:8080/showInfo.jsp?bid="+obj['bid']}).text(obj['bkname']))
//                              ).append(
//                                  $('<td>').text(obj['author'])
//                              ).append(
//                                  $('<td>').text(obj['price'])
//                              )
//                          )
//                      })
                  }
              }
          })
      }
      book();
      $('#btn').click(book);

      $('#exit').click(function () {
          $('#nickname').slideUp();
          $('#dl').slideDown();
      })

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
