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
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>

      <button id="btn" style="width: 80px;height: 40px;background-color: cornflowerblue">点击查询</button>
      <table border="1">

      </table>
  </body>
  <script type="text/javascript">
      $('#btn').click(function () {
          $.getJSON("http://localhost:8080/search",
          function (data,status) {
              if (status=="success"){
                  if(data!=null){
                      $('tr').remove();
                      $('table').append(
                          $('<tr>').append(
                              $('<td>').text("昵称")
                          ).append(
                              $('<td>').text("用户名")
                          ).append(
                              $('<td>').text("密码")
                          )
                      )

                      $.each(data,function (index, obj) {
                          $('table').append(
                              $('<tr>').append(
                                  $('<td>').text(obj['nickname'])
                              ).append(
                                  $('<td>').text(obj['uname'])
                              ).append(
                                  $('<td>').text(obj['password'])
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
