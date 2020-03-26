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
/*选择相应的item，并将其信息录入表格的相应栏中*/
function informationEnter(choiceTypeClassName,enterInfoClassName,name_Classname,jobNmuber){   //新添加
    var name;
    var number = 0;
    var id;
    var that = null;
    $(choiceTypeClassName).on("click",function () {
        name = null;//新添加
        that = $(this);
    });
    $(enterInfoClassName).click(function () {/*点击并获取card相关信息*/
        $(this).css("backgroundColor","skyblue").parent().
        siblings().children(enterInfoClassName).css("backgroundColor","transparent");
        name = $(this).find(".name").text();//获取 单项 的名称
        /*如果为班级列表，则获取 工号 和 id号*/
        if(choiceTypeClassName == ".choiceClassTea"){
            number = $(this).find(".number").text();//获取 单项 的工号
            id = $(this).children("input").val();//获取 单项 的id号
        }
        console.log(name);
    });
    $(".modal-footer .sure").on("click",function () {
        if(name != null) {//            新添加
            var currentCell = that.parent().siblings(name_Classname);//获取当前的姓名单元格
            /*同上*/
            if (choiceTypeClassName == ".choiceClassTea") {
                that.parent().siblings(jobNmuber).text(number);//往工号单元格内添加工号
                currentCell.children("input").val(id);//往 隐藏菜单里添加id号
            }
            currentCell.children("span").text(name);//往姓名单元格内插入名字
            $(enterInfoClassName).css("backgroundColor", "transparent");
        }
    });
}
//给card里的工号和name的title赋值
function setTitle(obj){
    for(var i = 0;i<obj.length;i++){
        $(obj[i]).attr("title",$(obj[i]).text());
    }
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
    if(totalPageObj.val() == 1){
        $(".lastPage").addClass("disabled");
        $(".nextPage").addClass("disabled");
    }else{
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

}
/*对删除项进行拼串*/
function delSingleCollectData(sidArr) {
    var singleData = {
        "cids":sidArr
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
        "cids":sidsArr
    };
    return batchData;
}
$(function () {
   $("tbody").append("<tr>\n" +
       "                        <td>\n" +
       "                            <input type=\"checkbox\" value=\"\" name=\"\"/>\n" +
       "                        </td>\n" +
       "                        <td>12</td>\n" +
       "                        <td>网络13班</td>\n" +
       "                        <td class=\"teachName\">\n" +
       "                            <span>李老师</span>\n" +
       "                            <input type=\"hidden\" class=\"idnumber\" value=\"id\">\n" +
       "                        </td>\n" +
       "                        <td class=\"teachJobNumber\">10888438788</td>\n" +
       "                        <td>\n" +
       "                            <button type=\"button\" class=\"choiceClassTea btn btn-sm btn-info\" data-toggle=\"modal\" data-target=\"#myModal\">选择班主任</button> |\n" +
       "                            <button type=\"button\" data-userid=\"001\" class=\"delete btn btn-sm btn-danger\">删除</button>\n" +
       "                        </td>\n" +
       "                    </tr>");
    /*表格全选*/
    tableChoiceAll();
    //给card里的工号和name的title赋值
    setTitle($(".name"));
    setTitle($(".number"));
    /*选择相应的班级项，并把它的信息录入到 表格中的班级栏中*/
    informationEnter(".choiceClassTea",
        ".card",".teachName",".teachJobNumber");
    /*删除当前选项*/
    deleteCurOption();
    /*批量删除所有选中项*/
    batchDeleteOptions();
    /*分页部分函数调用*/
    setPaging($(".totalPage"),$(".currentPage"));
});

