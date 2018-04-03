<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存结果的提示
            function showResult() {
                showResultDiv(true);
                document.add.submit();
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function resultCancel() {
                window.location.href='${pageContext.request.contextPath}/user/queryRentals';
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }

        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
            <a href="${pageContext.request.contextPath}/login/quit">[退出]</a>
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <jsp:include page="../main/menu.jsp"/>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_fail">保存失败，资费名称重复！</div>
            <form action="${pageContext.request.contextPath}/user/addRental" method="post" class="main_form" name="add">
                <input type="text" name="uid" value="${sessionScope.user.uid}" hidden>
                <div class="text_info clearfix"><span>户型：</span></div>
                <div class="input_info">
                    <input type="text" class="width300" value="" name="type"/>
                </div>
                <div class="text_info clearfix"><span>地点：</span></div>
                <div class="input_info">
                    <input type="text" value="" class="width100" name="place" />
                </div>
                <div class="text_info clearfix"><span>面积：</span></div>
                <div class="input_info">
                    <input type="text" value="" class="width100" name="area" />
                    <span class="info">平方米</span>
                </div>
                <div class="text_info clearfix"><span>价格：</span></div>
                <div class="input_info">
                    <input type="text" value="" class="width100" name="price" />
                    <span class="info">元/月</span>
                </div>
                <div class="text_info clearfix"><span>房屋简介：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70" name="info"></textarea>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="发布信息" class="btn_save"  onclick="showResult();" />
                    <input type="button" value="取消" class="btn_save" onclick="resultCancel()"/>
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           <span>版权所有(Tianyao)</span>
        </div>
    </body>
</html>
