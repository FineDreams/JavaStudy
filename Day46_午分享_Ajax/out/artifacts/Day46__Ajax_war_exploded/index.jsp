<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/24
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js">

    </script>
  </head>
  <body>
     <input id="input" type="text" oninput="show()">

  </body>
<script type="text/javascript">
    function show() {
        var val = $("#input").val();

        $.ajax({
            url:"/show",
            //从输入框中得到的数据
            data:{"input":val},
            type:"GET",
            //数据的类型
            dataType:"json",
            //异步：默认值为true
            async:true,
            success:success,
            beforeSend:send,
            complete:final
        })

    }
    function success(allData) {
        $("#input~div").remove();

        $(allData).each(function (index, data) {
            $("#input").after($("<div>").text(data))
        })
    }
    function send() {
        $("#input").after($("<h1>").text("正在加载"))
    }
    function final() {
        $("#input~h1").remove();
    }
</script>
</html>
