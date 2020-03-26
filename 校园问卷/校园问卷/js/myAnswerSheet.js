/*设置输入框中的字数*/
/*限制div中的字数*/
function wordsLimit(classname,words){
    var content = document.querySelector(classname);
//注册中文的输入事件，
    var isCN = false;
    content.addEventListener('compositionstart',function(event){
        isCN = true;
        //撤销预输入内容，必须否则会替代末尾字符
        if(this.textContent.length >= words){
            event.preventDefault();
        }
    });
    content.addEventListener('compositionend',function(){
        isCN = false;
    });
//注册文本输入事件，获取光标的起止偏移数据,如果是非中文以及超出长度的输入，则撤销本次操作
    var txtAnchorOffset, txtFocusOffset;
    content.addEventListener("textInput",function(event){
        var _sel = document.getSelection();
        txtAnchorOffset = _sel.anchorOffset;
        txtFocusOffset = _sel.focusOffset;
        //必须加上isCN的判断，否则获取不到正确的光标数据
        if(!isCN && this.textContent.length >= words){
            event.preventDefault();
        }
    });
//注册粘贴事件，获取粘贴数据的长度
    var pastedLength;
    content.addEventListener("paste",function(event){
        if(!event.clipboardData) return;
        pastedLength = event.clipboardData.getData('Text').length;
    });
//注册输入事件，对输入的数据进行
    content.addEventListener("input",function(event){
        setTimeout(function(){
            if(!isCN){
                var _this = content;
                if(_this.textContent.length > words){
                    var data = _this.textContent;
                    if(pastedLength > 1){
                        oldDate = data.slice(0, txtAnchorOffset) + data.slice(txtFocusOffset+pastedLength, data.length);
                        //粘贴字符串长度置为0，以免影响到下一次判断。
                        pastedLength = 0;
                    } else {
                        oldDate = data.slice(0, txtAnchorOffset) + data.slice(txtFocusOffset, data.length);
                    }
                    //再次截取最大长度字符串，防止溢出
                    _this.textContent = oldDate.slice(0,words);
                    //光标移动到起始偏移位置
                    document.getSelection().collapse(_this.firstChild, txtAnchorOffset);            }
            }
        }, 0);
    });
}
/*获取相应单选对象的属性值的集合*/
function kindArray(obj) {
    var str = [];
    for(var i = 0;i<obj.length;i++){
        var questionId = $(obj[i]).parent().siblings("div").attr("data-questionsId") ||
        $(obj[i]).siblings(".fillBlanksTitle").attr("data-questionsId") ||
            $(obj[i]).siblings(".satisfyTitle").attr("data-questionsId");
        var content = $(obj[i]).children(".qitaWord").text() || $(obj[i]).text();
        var optionId = $(obj[i]).attr("data-optionId");
        var level = $(obj[i]).attr("data-level");
        if($(obj[0]).is(".qita")){
            str.push(qitaObj(questionId,content,optionId));
        }else if($(obj[0]).is(".fillContent")){
            str.push(fillObj(questionId,content));
        }else if($(obj[0]).is(".assess")){
            str.push(satisfyObj(questionId,level));
        }else{
            str.push($(obj[i]).find(".word").attr("data-contentId"));
        }
    }
    return str;
}
/*通过不同的对象获取相应的属性值*/
function qitaObj(q,c,o) {
    var qObj = {
        questionId:q,
        content:c,
        optionId:o
    };
    return qObj;
}
function fillObj(q,c) {
    var fObj = {
        questionId:q,
        content:c,
    };
    return fObj;
}
function satisfyObj(q,l) {
    var sObj = {
        questionId:q,
        level:l,
    };
    return sObj;
}
/*拼串*/
function stringTogether(singleOptionArr,multiOptionArr,otherOptionArr,fillBlanksArr,satisfactionArr){
    var json = {
        "singleOptions":singleOptionArr,
        "multiOptions":multiOptionArr,
        "otherOptions":otherOptionArr,
        "fillBlanks":fillBlanksArr,
        "satisfaction":satisfactionArr
    };
    return json;
}
/*消除其他选项中的空格     新添加*/
function limitBlank(clName){
    var st = null;
    $(document).on("focusout",clName,function () {
        st = $(this).text().replace(/\s/g,"");
        $(this).text(st);
        console.log($(this).text());
    });
}
$(function () {
   /*----单选选项中的点击效果----*/
    /*默认为未点击状态*/
    $(".select .options li .icon_select").on("click", function () {
            /*对当前选中的选项做类名标记*/
            if($(this).parent().is(".qita")){
                $(this).parent().addClass("checkedQita").siblings().removeClass("checkedSelect");
            }else{
                $(this).parent().addClass("checkedSelect").siblings().removeClass("checkedSelect checkedQita");
            }
            /*队选中项进行赋色*/
            $(this).children().css("color", "dodgerblue");
            $(this).parent().siblings().find(".iconfont").css("color","white");
            $(this).parent().parent().parent().attr("currentState","true");
        });
    /*多选选项中的点击效果*/
    $(" .icon_multiSelect").click(function () {
        if ($(this).attr("state") == "false") {//未选中时点击
            // 对当前选中的选项做类名标记
            if($(this).parent().is(".qita")){
                $(this).parent().addClass("checkedQita");
            }else{
                $(this).parent().addClass("checkedMultiSelect");
            }
            /*队选中项进行赋色*/
            $(this).attr("state","true").children().css("color", "dodgerblue");
        } else {//选中状态下点击
            // 对当前选中的选项做类名标记
            if($(this).parent().is(".qita")){
                $(this).parent().removeClass("checkedQita");
            }else{
                $(this).parent().removeClass("checkedMultiSelect");
            }
            /*队选中项进行赋色*/
            $(this).attr("state", "false").children().css("color", "white");
        }
        //如果存在state= true的选项，则让currentState = true
        if($(this).parent().parent().find("[state*= true]").length > 0){
            $(this).parent().parent().parent().attr("currentState","true");
        }else{
            $(this).parent().parent().parent().attr("currentState","false");
        }
    });
    /*单选，多选中其他选项是否填写的判定*/
    (function () {
        var str = null;
        $(".qitaWord").keyup(function () {
            str = $(this).text();
            str = str.replace(/\s/g,"");
            // console.log(str);
            if(str.length > 0){
                $(this).removeClass("noText");
            }else{
                $(this).addClass("noText");
            }
        });
    })();
    //消除其他选项中的空格     新添加
    limitBlank(".qitaWord");
    //消除 填空 中的空格       新添加
    limitBlank(".fillContent");
    //限制  其他选项中的div的回车     新添加
    $(document).on('keydown',".qitaWord",function(event){
      //获取keyCode
        var keyCode = event.keyCode || event.charCode;
        if(keyCode===13){
            event.preventDefault();
        }
    });
    /*若字数超过范围，则弹提示框*/
    $(document).on("keyup","[contenteditable*=true]",function () {
        alert(1);
        if($(this).text().length > 300){    //--------------------------------------
            alert("字数已超过300");
            return false;
        }
    });
    /*fillblanks*/
    $(".fillContent").keyup(function () {
        if($(this).text().length > 0){
            $(this).addClass("filled").parent().attr("currentState","true");
        }else{
            $(this).removeClass("filled").parent().attr("currentState","false");
        }
        console.log($(this).parent().prop("currentState"));
    });
    /*字数限制*/
    wordsLimit(".select .qitaWord",300);
    wordsLimit(".multiSelect .qitaWord",300);
    wordsLimit(".fillBlanks .fillContent",300);
    /*五角星评分*/
    $(".bodyWrap").on("click",".assess li",function () {
        var that = $(this);
        $(this).text("★").css("color","#f3c14d").prevAll().text("★").css("color","#f3c14d").
        end().nextAll().text("☆").css("color","#828282");
        $(this).parent().attr("data-level",that.index()+1);
        $(this).parent().addClass("evaluated").parent().attr("currentState","true");
        console.log($(this).parent().parent().attr("currentState"));
    });
    /*提交部分*/
    $(".submit").on("click",function () {

        if($(".bodyWrap .checkedQita").find(".qitaWord").is(".noText")){//在其他选项中，选项点击了，未填写文本
               layer.alert("您第 "+$(".checkedQita .noText").parent().parent().parent().index()+" 题中的”其他选项“未填写");
        }else if($(".bodyWrap > div").is("[currentState = false]")){//选项未点击 没完成
               layer.alert("您第 "+$(".bodyWrap").children("[currentState = false]").index()+" 题还没完成");
        }else{
           //其他选项 和 填空中的字数限制
            for (let i = 0; i < $(".checkedQita").length; i++) {
                if ($($(".checkedQita")[i]).find(".qitaWord").text().length > 300 ){
                    layer.alert("您第 "+$($(".checkedQita")[i]).parent().parent().index()+" 题字数超过300个字");
                    return;
                }
            }

            for (let i = 0; i < $(".qita [state*=true]").length; i++) {
                if ($($(".qita [state*=true]")[i]).siblings(".qitaWord").text().length > 300 ){
                    layer.alert("您第 "+$($(".qita [state*=true]")[i]).parent().parent().parent().index()+" 题字数超过300个字");
                    return;
                }
            }

            for (let i = 0; i < $(".fillContent").length; i++) {
                if($($(".fillContent")[i]).text().length > 300 ){
                    layer.alert("您第 "+$($(".fillContent")[i]).parent().index()+" 题字数超过300个字");
                    return;
                }
            }



             var data = stringTogether(kindArray($("[class*=checkedSelect]")),kindArray($("[class*=checkedMultiSelect]")),
                kindArray($("[class*=checkedQita]")),kindArray($("[class*=filled]")),kindArray($("[class*=evaluated]")));
            /*console.log(kindArray($("[class*=checkedSelect]")));
            console.log(kindArray($("[class*=checkedMultiSelect]")));
            console.log(kindArray($("[class*=checkedQita]")));
            console.log(kindArray($("[class*=filled]")));
            console.log(kindArray($("[class*=evaluated]")));*/
            layer.alert("您已完成");
            // console.log(data);
            console.log(data.fillBlanks[0].content);
        }
    });

});
