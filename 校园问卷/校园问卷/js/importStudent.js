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
$(function () {
    //给name-item设置title值  新添加
    (function () {
        for(var i = 0;i<$(".name-item").length;i++){
            $($(".name-item")[i]).attr("title",$($(".name-item")[i]).text());
        }
    })();
    //接受和获取信息
    (function () {
        var name;
        $(".kindname .name-item").on("click",function () {
            $(this).css("backgroundColor","skyblue").
            parent().siblings().children(".name-item").css("backgroundColor","transparent");
            name = $(this).text();
        });
        $(".sure").on("click",function () {
            $("form .showName").attr("title",name).text(name);   //新添加
        });
    })();
    /*验证表单的格式*/
    formDefine();
});