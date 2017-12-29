<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2017/12/28
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户信息</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
    <form action="insert" method="post">
        <label for="uname">用户名</label>
        <input id="uname" type="text" name="uname">
        <label for="age">年龄</label>
        <input type="text" id="age" name="age">
        <label for="loc">城市</label>
        <input type="text" id="loc" name="loc">
        <input type="submit">
    </form>


      <button id="btn" style="width: 90px;height: 30px;background-color: burlywood">点击查询</button>
      <table border="1" >

      </table>
  </body>
  <script type="text/javascript">
      $('#btn').click(function () {
          $.getJSON("http://localhost:8080/json",
          function (data, status) {
              if (status=="success"){
                  console.log(data);
//                  var jsonData=$.parseJSON(data);
                  if (data!=null){
                      $('tr').remove();
                      $('table').append(
                          $('<tr>').append(
                              $('<td>').text("Uid")
                          ).append(
                              $('<td>').text('用户名')
                          ).append(
                              $('<td>').text('年龄')
                          ).append(
                              $('<td>').text('城市')
                          )
                      )

                      $.each(data,function (index, obj) {

                          $('table').append(
                              $('<tr>').append(
                                  $('<td>').text(obj['uid'])
                              ).append(
                                  $('<td>').text(obj['uname'])
                              ).append(
                                  $('<td>').text(obj['age'])
                              ).append(
                                  $('<td>').text(obj['loc'])
                              )
                          )
                      })
                  }

              }
          }
          )
      })
  </script>
</html>
