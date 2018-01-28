<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/23
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  </body>
  <script type="text/javascript">
    function show() {
        var jsonTest=new XMLHttpRequest();
        jsonTest.open("get","show.action",true);
        jsonTest.send(null);
        jsonTest.onreadystatechange=function () {
            if (this.readyState==4&&this.status==200){
                var responseText = jsonTest.responseText;
              document.write(responseText);
            }
        }
    }
    window.onload=function () {
        show();
    }
  </script>
</html>
