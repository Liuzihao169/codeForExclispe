/*在当前页面的显示页面*/
function fungoManager(obj) {
    window.location.href=obj;
}
/*给模态框中的iframe传输里传值，并赋予页面*/
function changeIframe(current,obj) {
    var value = current.attr("data-id");
    alert(value);
    $("iframe").attr("src",obj +"/"+value);
}
/*在模态框中运用iframe插入页面*/
/*function functionGo(obj) {
    $("iframe").attr("src",obj);
}*/
/*点击发布图标时触发的效果*/
function clickIconfont(iconObj,targetClassName){
    iconObj.on("click",function () {
        console.log(targetClassName);
        var thatobj = $(this);
        /*阻止跳转*/
        if($(this).parent().siblings().eq(2).find(".unreleased").is(".show")){//未发布时
            if($(this).is(".edit")){
                fungoManager("newQuestionnaire.html");
            }
          /*如果点击对象为停止收集，则终止跳转*/
            if($(this).is(".stop")){
                layer.open({
                    type:0,
                    offset: '200px',
                    title:'温馨提示！',
                    content:'请先发布'
                });
                return false;
            }
        }else if($(this).parent().siblings().eq(2).find(".released").is(".show")){//已发布时
            if($(this).is(".publish")){
                layer.open({
                    type:0,
                    offset: '200px',
                    title:'温馨提示！',
                    content:'已发布，请勿重复操作'
                });
                return false;
            }
            if($(this).is(".edit")){
                layer.open({
                    type:0,
                    offset: '200px',
                    title:'温馨提示！',
                    content:'已发布，无法编辑'
                });
                return false;
            }
        }else{//停止收集时
            //如果此时位编辑，则为已停止收集，无法编辑，否则为。。。
            if($(this).is(".edit")){
                layer.open({
                    type:0,
                    offset: '200px',
                    title:'温馨提示！',
                    content:'已停止收集，无法编辑'
                });
            }else if($(this).is(".publish")){
                var value = thatobj.parent().siblings().eq(2).find(".show").attr("value");
                layer.confirm("是否继续收集", function (index) {
                    ///*显示 当前状态 即已发布 未发布 停止收集*/
                    console.log(value);
                    thatobj.parent().siblings().eq(2).find(targetClassName).addClass("show").siblings().removeClass("show");
                    console.log( thatobj.parent().siblings().eq(2).find(targetClassName).addClass("show").attr("value"));
                    layer.close(index);
                });
                return ;
            } else{
                layer.open({
                    type:0,
                    offset: '200px',
                    title:'温馨提示！',
                    content:'已完成收集,请勿重复操作'
                });
                return false;
            }
        }
        /*若当前对象位编辑，则执行空语句*/
        if($(this).is(".edit")){

        }else {
            var value = thatobj.parent().siblings().eq(2).find(".show").attr("value");
                layer.confirm('确认' + thatobj.attr("title"), function (index) {
                    ///*显示 当前状态 即已发布 未发布 停止收集*/
                    console.log(value);
                    console.log( thatobj.parent().siblings().eq(2).find(targetClassName).addClass("show").attr("value"));
                    thatobj.parent().siblings().eq(2).find(targetClassName).addClass("show").siblings().removeClass("show");
                    layer.close(index);
                });
        }
    });
}
/*验证导入文件格式*/
function formDefine(){
    $(".file").change(function () {
        var path = $(this).val();//得到该文件的路径
        var suffix = path.substr(path.lastIndexOf(".")).toUpperCase();//后缀名变成大写
        if(".XLS" == suffix || ".XLSX" == suffix) {
            layer.alert("文件正确");
            return true;
        }else if(path == ""){
            layer.alert("未选择");
            return false;
        }else{
            layer.alert("文件格式错误,请重新选择");
            return false;
        }
    })
}
/*实现部分*/
$(function () {
    /*导入--验证表单的格式*/
    formDefine();
    //点击预览时，在模态框中显示 页面
    $(".preview").on("click",function () {
        changeIframe($(this),"myAnswerSheet.html")
    });
    /*鼠标移入和移出的效果*/
   $(".example").on("mouseenter",function () {
         $(this).children(".functionIcon").stop(true,true).show(500);
         $(this).children(".delete").stop(true,true).show(500);
         $(this).children().eq(0).attr("title",$(this).children().eq(0).text());
   }).on("mouseleave",function () {
       $(this).children(".functionIcon").stop(true,true).hide();
       $(this).children(".delete").stop(true,true).hide();
   });
   /*点击删除单个选项*/
    $(".example .delete").on("click",function () {
        var that = $(this);
        //删除单个节点
        layer.confirm('确认删除?', function(index){
            //do something
            that.parent().parent().remove();
            layer.close(index);
        });
    });
    /*点击发布时，显示已发布*/
    clickIconfont($(".example .publish"),".released");
    /*点击发布时，显示已发布*/
    clickIconfont($(".example .stop"),".stopCollect");
    /*点击编辑时*/
    clickIconfont($(".example .edit"));
   /*分页处理*/
    setPaging($(".totalPage"),$(".currentPage"));

    $(window).resize(function () {
        $(".modal-body").height($(document.body).height()*0.9);
    });
});