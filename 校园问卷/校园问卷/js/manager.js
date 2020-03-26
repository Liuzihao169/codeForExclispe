/*全局函数，为图标的变化的时间*/
function fun(obj,direction,value){
    setTimeout(function () {
        obj.children().eq(0).attr("class","glyphicon glyphicon-triangle-"
            + direction).css("top",value + "px");
    }, 350);
}
$(function () {
    /*------------------侧边导航栏部分--------------*/
    /*切换下拉菜单的 显隐状态 */
   $(".nav-link").on("click",function () {
       if($(this).siblings(".dropMenu").css("display") === "none") {//切换为显示
           $(this).siblings(".dropMenu").show(400);
           /*更换及其样式*/
           fun($(this),"bottom","16.5");
       }else{//切换为隐藏
           $(this).siblings(".dropMenu").hide(400);
           fun($(this),"top","19.5");
       }
   });
    // 鼠标的点击，移入，移除操作
    var flag = false;//设置默认为未曾点击的状态
    var activeObj = null;//存储当前点击的对象
  /* 当前对象为drop menu中的li*/
        $(".dropMenu").children().mouseenter(function () {
            $(this).children().eq(0).css("color", "#ffffff");
        }).mouseleave(function () {
            console.log(flag);
            /*1.并上flag ==false是为了在没有点击过的情况下，能进行移出的样式设置
            * 2.在点击后，当当前对象！= activeobj时即鼠标不在点击过的li上时，设置样式*/
            if(this != activeObj || flag == false){
                $(this).children().eq(0).css("color","#9d9d9d")
            }
        }).click(function () {
            /*将当前对象赋给 activeobj*/
            activeObj = this;
            flag = true;
            /*先让所有的子li的bgcolor变为原色 及 a的color为原色*/
            $(".dropMenu").children().css("backgroundColor", "#282833").children().css("color", "#9d9d9d");
            /*让当前被点击的子li的bgcolor变为浅绿色*/
            $(this).css("backgroundColor", "#009688").children().css("color", "#ffffff");
        })

})