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
    <link href="../css/info.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
    </style>
</head>
<body>
    <div id="info"></div>

</body>
    <script type="text/javascript">
        $.get("showBook",{"bid":<%=request.getParameter("bid")%>},
            function (data) {
            var jsonData = JSON.parse(data);
                    if (jsonData!=null){
                        $('<tr>').remove();
                         $('#info').append(
                             $('<table>').attr({"border":1}).append(
                                 $('<tr>').append(
                                     $('<td>').append($('<img>').attr({"src":jsonData['src']}))
                                 ).append(
                                     $('<td>').text(jsonData['info'])
                                 ).append(
                                     $('<td>').append(
                                         $('<input>').attr({"type":"submit","value":"加入购物车"}).attr({"class":"inpt"})
                                     ).append(
                                         $('<input>').attr({"type":"submit","value":"立即购买"}).attr({"class":"inpt"})
                                     )
                                 )
                             )
                         )
                    }
            })

    </script>
</html>
