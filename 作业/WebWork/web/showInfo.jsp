<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/3
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍简介</title>
    <script src="js/jquery-3.2.1.min.js">

    </script>
</head>
<body>
    <h1 id="bk"></h1>
    <h1 id="auth"></h1>
    <h1 id="info"></h1>

</body>
    <script type="text/javascript">
        $.get("showBook",{"bid":<%=request.getParameter("bid")%>},
            function (data) {
            var jsonData = JSON.parse(data);
                    if (jsonData!=null){
                        var bkname=jsonData['bkname'];
                        var author=jsonData['author'];
                        var info=jsonData['info'];
                        console.log(info);
                        $('#bk').text("书名:"+bkname)
                        $('#auth').text("作者:"+author)
                        $('#info').text("简介:"+info)
                    }
            })

    </script>
</html>
