// pure JS
var elem = document.getElementById('mySwipe');
window.mySwipe = Swipe(elem, {
    // startSlide: 4,
    auto: 3000,
    continuous: true,
    // disableScroll: true,
    // stopPropagation: true,
    callback: function(index, element) {
        //alert(index);
    }
    // transitionEnd: function(index, element) {}
});

// with jQuery
// window.mySwipe = $('#mySwipe').Swipe().data('Swipe');
$(document).ready(function () {
    $("#spanone").html(sessionStorage.getItem("username")+",&nbsp;&nbsp;")
    test();
    console.log(sessionStorage.phone);
})
function test() {
    $.get("http://localhost:8080/selectAllArticle",function (data) {
        console.log(data);
        $.each(data,function (index,item) {
            console.log("++++++"+item.goodsId)
            $(".pro_list:first").append(
                "<li data-id='"+item.goodsId+"'>"+
                "<a href='#'>"+
                "<div class='pro_pic'>"+
                "<img src='"+item.fileId+"'/>"+
                "<p class='pro_title'>"+item.goodsName+"</p>"+
                "</div>"+
                "<div class='pro_info'>"+
                "<span class='xj'>￥"+item.price+"" +
                "<span class='yj'>￥"+item.discount+"</span>"+
                "</span>"+
                "<span class='sczg'></span>"+
                "</div>"+"</a>"+"</li>"
            );
            $(".fl_list li").each(function () {
                $(this).click(function () {
                    console.log(this.dataset.type);
                    sessionStorage.setItem("type",this.dataset.type);
                    window.location="pro_list.html"
                })
            })
            $(".pro_list:first li").on("click",function () {
                console.log("dddddd"+sessionStorage.goodsId);
                sessionStorage.goodsId=this.dataset.id;
                window.location="/toDetail";
            })


        })
    })
    $(".nav_dd a").click(function () {
        if (sessionStorage.getItem("username")==null){
            alert("请先登录");

        }else {
            window.location="wddd.html"
        }
    })


}