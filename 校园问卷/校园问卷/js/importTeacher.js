function formDefine() {
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
formDefine();