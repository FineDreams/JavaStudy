<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/2/5
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>二级联动</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
部门:
<select id="depart" onchange="show(this)">
    <option value="-1">---请选择---</option>
    <option value="0">---外部---</option>
    <option value="1">---内部---</option>
</select>
职务:
<select id="post">
    <option value="-1">---请选择---</option>
</select>

</body>
<script type="text/javascript">
    function createXMLHttpRequest() {
        try{
            return new XMLHttpRequest();
        }catch (e){
            try{
                return new ActiveXObject("Msxml2.Http");
            }catch (e){
                try {
                    return new ActiveXObject("Microsoft.Http");
                }catch (e){
                    throw e;
                }
            }
        }
    };
    function show(obj) {
//        var depart=document.getElementById("depart");

        var depart=obj.value;
        console.log(depart);
            var xmlHttp=createXMLHttpRequest();
            xmlHttp.open("POST","/display",true);
            xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xmlHttp.send("depart="+depart);
            xmlHttp.onreadystatechange=function () {
                if (xmlHttp.readyState==4&&xmlHttp.status==200){
                    var department=eval("("+xmlHttp.responseText+")");
                    var postList = department.postList;
                    var post=document.getElementById("post");
                    post.innerHTML="<option value='-1'>---请选择---</option>";
                    for(var i=0;i<postList.length;i++){
                        var postT = postList[i];
                        post.innerHTML+="<option value="+postT.id+">---"+postT.name+"---</option>";
                    }
                }
            };

    }
</script>
</html>

