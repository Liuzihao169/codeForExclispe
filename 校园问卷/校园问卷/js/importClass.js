/*验证导入文件格式*/
function formDefine(){
    $(".file").change(function () {
        var path = $(this).val();//得到该文件的路径
        var suffix = path.substr(path.lastIndexOf(".")).toUpperCase();//后缀名变成大写
        if(".XLS" == suffix || ".XLSX" == suffix) {
            // layer.alert("文件正确");
            return true
        }else if(path == ""){
            layer.alert("未选择");
            return false;
        }else{
            layer.alert("文件格式错误,请重新选择");
            return false;
        }
    })
}
//给card里的工号和name的title赋值
function setTitle(obj){     //新添加
    for(var i = 0;i<obj.length;i++){
        $(obj[i]).attr("title",$(obj[i]).text());
    }
}
$(function () {
    //给name设置title值     新添加
    setTitle($(".name"));
    setTitle($(".number"));
    /*modal中的效果设置 及 把内容添加到showname中取*/
    var name,number;
    $(".kindname .card").click(function () {
        $(this).css("backgroundColor","skyblue").parent().
        siblings().children(".card").css("backgroundColor","transparent");
        name = $(this).find(".name").text();
        number = $(this).find(".number").text();
    });
    $(document).on("dblclick",".card",function () {
        $(this).css("backgroundColor","skyblue").parent().
        siblings().children(".card").css("backgroundColor","transparent");
        name = $(this).find(".name").text();
        number = $(this).find(".number").text();
        $(".panel-body .showName").text(name);
        $(".panel-body .collectNumber").val(number);
        $("#myModal").modal('hide');
    });
    $(".modal-footer .sure").on("click",function () {
        $(".panel-body .showName").text(name);
        $(".panel-body .collectNumber").val(number);
    });
   //验证导入文件格式
   formDefine();
});