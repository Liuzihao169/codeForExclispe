/*表格全选*/
function tableChoiceAll(){
    $(".choiceAll").click(function () {//选所有
        $(".batchDelete").removeAttr("disabled");
        $(".tb_choice input").prop("checked",$(".choiceAll").prop("checked"));
    });
    $(".tb_choice [type*=checkbox]").click(function () {
        $(".batchDelete").removeAttr("disabled").attr("title","删除所有选中项");
        if($(".tb_choice [type*=checkbox]:checked").length == $(".tb_choice [type*=checkbox]").length){
            $(".choiceAll").prop("checked",true);
        }else{
            $(".choiceAll").prop("checked",false);
        }
    });
}
/*删除当前选项*/
function deleteCurOption(){
    $("table .delete").on("click",function () {
        var that = $(this);
        layer.confirm("确认删除",function (index) {
            delSingleCollectData(that.attr("data-userid"));
            console.log( delSingleCollectData(that.attr("data-userid")));
            that.parent().parent().remove();
            layer.close(index);
        });
        /*delSingleCollectData($(this).attr("data-userid"));
        // console.log( delSingleCollectData($(this).attr("data-userid")));
        $(this).parent().parent().remove();
        return $(this).attr("data-userid");*/
    });
}
/*批量删除所有选中项*/
function batchDeleteOptions(){
    $(".batchDelete").on("click",function () {
        if($(".tb_choice [type*=checkbox]:checked").length == 0){//未选中时禁用按钮
            $(this).attr("title","请先选中选项").prop("disabled","true");
        }else{
            layer.confirm('确认批量删除', function(index){
                var delObjs = $(".tb_choice input:checked").parent().parent().find(".delete");
                batchDelCollectData(getBatchDelData(delObjs));
                console.log(batchDelCollectData(getBatchDelData(delObjs)));
                $(".tb_choice input:checked").parent().parent().remove();
                layer.close(index);
            });
        }
    });
}
/*分页部分*/
function setPaging(totalPageObj,currentPageObj) {
    var count = 1;
    var lastObj = $(".lastPage");
    var nextObj = null;
    $(".lastPage").on("click",function () {
        lastObj = $(this);
        if(nextObj!=null){
            nextObj.removeClass("disabled");
        }
        count--;
        console.log(count);//
        if(count == 1){
            $(this).addClass("disabled");
        }
        if(count < 1){
            count = 1;
        }
        currentPageObj.val(count);
        console.log(currentPageObj.val());//
    });
    $(".nextPage").on("click",function () {
        nextObj = $(this);
        if(lastObj != null){
            lastObj.removeClass("disabled");
        }
        count++;
        console.log(count);//
        if(count == totalPageObj.val()){
            $(this).addClass("disabled");
        }
        if(count > totalPageObj.val()){
            count = totalPageObj.val();
        }
        currentPageObj.val(count);
        console.log(currentPageObj.val());
    })
}
/*对删除项进行拼串*/
function delSingleCollectData(sidArr) {
    var singleData = {
        "tids":sidArr
    };
    return singleData;
}
/*收集数据*/
function getBatchDelData(delObj) {
    var str = [];
    for(var i = 0;i < delObj.length;i++){
        str.push($(delObj[i]).attr("data-userid"));
    }
    return str;
}
/*对删除项进行拼串*/
function batchDelCollectData(sidsArr) {
    var batchData = {
        "tids":sidsArr
    };
    return batchData;
}
/*复选框部分*/
$(function () {
    $("tbody").append($("<tr>\n" +
        "                    <td>\n" +
        "                        <input type=\"checkbox\" value=\"\"/>\n" +
        "                    </td>\n" +
        "                    <td>12</td>\n" +
        "                    <td>小明</td>\n" +
        "                    <td>1609205043</td>\n" +
        "                    <td>\n" +
        "                        <button type=\"button\" data-userid=\"001\" class=\"delete glyphicon glyphicon-trash\"></button>\n" +
        "                        <input type=\"hidden\" value=\"\">\n" +
        "                    </td>\n" +
        "                </tr>"));

    /*表格全选*/
    tableChoiceAll();
    /*删除当前选项*/
    deleteCurOption();
    /*批量删除所有选中项*/
    batchDeleteOptions();
    /*分页部分函数调用*/
    setPaging($(".totalPage"),$(".currentPage"));
});