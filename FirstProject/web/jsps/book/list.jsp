<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>图书列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script src="<c:url value="/js/jquery-3.2.1.min.js"/> "></script>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        body {
            font-size: 10pt;
        }
        .icon {
            margin:10px;
            border: solid 2px gray;
            width: 160px;
            height: 180px;
            text-align: center;
            float: left;
        }
        a{
            text-decoration-line: none;
        }
        ul{
            padding: 0px;
            margin: 0px;
        }
        ul>li{
            display:block;
            width:30px;
            float:left;
            font-size:20px;
            margin:0px;
            padding:0px;
        }

    </style>
</head>

<body>
<div style="width: 200px;height: 30px;border: solid 1px black">
    <ul></ul>
</div>
<%--<c:forEach var="book" items="${requestScope.books}">--%>
<%--<div class="icon">--%>
<%--<a href="<c:url value='/book?method=load&bid=${book.bid}'/>"><img src="<c:url value='${book.image}'/>" border="0"/></a>--%>
<%--<br/>--%>
<%--<a href="<c:url value='/book?method=load&bid=${book.bid}'/>">${book.bname}</a>--%>
<%--</div>--%>
<%--</c:forEach>--%>
<%--<div class="icon" id="info">--%>


<%--</div>--%>

</body>
<script type="text/javascript">
    $.get("/Yuanying/book?method=searchAllCategory&category=${param.category}&pageCode=${param.pageCode}",function (data, status) {
        if (status=="success"){
            var parseJSON = $.parseJSON(data);
            var books = parseJSON['books'];
            var totalPages = parseJSON['totalPages'];
            if (books!=null){
                $('tr').remove();

                $('div').append($('<a>').attr({"href":"<c:url value='/jsps/book/list.jsp?pageCode=${param.pageCode-1}'/>" +"&category=${param.category}"}).text("上一页"))
                for(var begin=1;begin<=totalPages;begin++){
                    $('ul').append(
                        $('<li>').append($('<a>').attr({"href":"<c:url value='/jsps/book/list.jsp?pageCode='/>" +begin+"&category=${param.category}"}).text('['+begin+']'))
                    )
                }
                $('div').append($('<a>').attr({"href":"<c:url value='/jsps/book/list.jsp?pageCode=${param.pageCode+1}'/>" +"&category=${param.category}"}).text("上一页"))


                $.each(books,function (index,obj) {
                    $('body').append(
                        $('<div>').attr({"class":"icon"}).append(
                            $('<table>').css({"text-align":"center","width":"156px"}).append(
                                $('<tr>').append(
                                    $('<td>').append($('<a>').attr({"href":"/Yuanying/book?method=load&bid="+obj['bid']}).append($('<img>').attr({"src":"/Yuanying"+obj['image']})))
                                )
                            ).append(
                                $('<tr>').append(
                                    $('<td>').append($('<a>').attr({"href":"/Yuanying/book?method=load&bid="+obj['bid']}).text(obj['bname']))
                                )
                            )
                        )
                    )
                })
            }
        }
    })


</script>


</html>

