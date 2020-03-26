function setCaret() {
    var el = document.getElementById("editable");
    var range = document.createRange();
    var sel = window.getSelection();
    range.setStart(el.childNodes[2], 5);
    range.collapse(true);
    sel.removeAllRanges();
    sel.addRange(range);
    el.focus();

}
/*当点击 left right 等div时使bodywrap中的各个模块的点击样式失效*/
function bodyWarpClick(obj, targetObj) {
    obj.click(function () {
        targetObj.css("borderColor", "white").children(".add").css("color", "#bbbbbb");
        $("[contenteditable*=true]").css("backgroundColor", "#ffffff");
    })
}
/*封装body wrap中各个模块的点击效果函数*/
function modelObj(objClassName) {
    var thisobj = null;
    $(".bodyWrap").on("click", objClassName, function () {
        thisobj = $(this);
        $(this).css("borderColor", "dodgerblue").children(".add").css("color", "rgba(30, 144, 255, 0.76)");
        $(this).siblings().css("borderColor", "white").children(".add").css("color", "#bbbbbb");
        // return false;
        bodyWarpClick($(".left"), thisobj);
        bodyWarpClick($(".right"), thisobj);
        bodyWarpClick($(".editTitleWrap"), thisobj);
        bodyWarpClick($(".footer_finish"), thisobj);
    });
}
/*封装添加模块函数 点击的节点  要添加的类的类名（不带标点），要添加的类,加入的节点的类名*/
function addDom(obj, targetClassName, targetDom, joinClassName) {
    obj.click(function () {
        //判断是否有题目，如有则隐藏空白区域，反之亦然
        if ($(".bodyWrap > div").length == 2) {
            console.log($(".bodyWrap > div").length);
            $(".unedited").removeClass("show");
        }
        // 添加相应的题型
        if ($(joinClassName).children().hasClass(targetClassName)) {
            $(targetDom).insertAfter($(".bodyWrap").children("." + targetClassName).last());
        } else {
            if ($(".bodyWrap > div").length == 2) {
                $(".unedited").css("display", "none");
            }
            $(targetDom).appendTo(joinClassName);
        }
        $(".bodyWrap").children("." + targetClassName).last().css("borderColor", "dodgerblue").siblings().css("borderColor", "white");
        // $(window).scrollTop(200);
        /*让新建的模块到达屏幕中间位置*/
        //获取当前新建的li距离bodywrap顶端的值
        var currentTop = $(".bodyWrap").children("." + targetClassName).last().offset().top;
        /*获取窗口中 盒子居中的参考值即目标值*/
        var targetTop = ($(window).height() - $(".bodyWrap").children("." + targetClassName).eq(0).height()) / 2;
        /*两者的差值*/
        var distance = currentTop - targetTop;
        console.log(distance);
        /*body和两倍window的差值*/
        var differValue = $(".bodyWrap").height() - 2 * $(window).height();
        /*body和一倍window的差值*/
        var bodydifferWindow = $(".bodyWrap").height() - $(window).height();
        /*判断向那边移动多少距离*/
        if (differValue > 0) {
            $(window).scrollTop(distance);
        } else if (differValue <= 0) {
            if ($(window).scrollTop() > 0) {
                $(window).scrollTop($(window).scrollTop());
            } else {
                $(window).scrollTop(bodydifferWindow);
            }
        }

        //实时限制所有可编辑的字数
        setWords();
    });
}
/*添加单选的单个选项的封装函数*/
function addSelect(obj) {
    if ($(obj).parent().siblings(".options").children("li").is(".commonlyLi")) {
        $("<li class=\"commonlyLi\">\n" +
            "                    <!--选项图标-->\n" +
            "                    <div class=\"icon_select\"></div>\n" +
            "                    <div class=\"word commonSign\" data-item=\"01\" contenteditable=\"true\">选项1</div>\n" +
            "                    <div class=\"singleDeletion iconfont iconreduce-circle\"></div>\n" +
            "                </li>").insertAfter($(obj).parent().siblings(".options").children(".commonlyLi").last());
        //实时限制所有可编辑的字数
        setWords();
    } else {
        $("<li class=\"commonlyLi\">\n" +
            "                    <!--选项图标-->\n" +
            "                    <div class=\"icon_select\"></div>\n" +
            "                    <div class=\"word commonSign\" data-item=\"01\" contenteditable=\"true\">选项1</div>\n" +
            "                    <div class=\"singleDeletion iconfont iconreduce-circle\"></div>\n" +
            "                </li>").prependTo($(obj).parent().parent().children(".options"));
        //实时限制所有可编辑的字数
        setWords();
    }

}
/*添加多选的封装函数*/
function addMultiSelect(obj) {
    if ($(obj).parent().siblings(".options").children("li").is(".commonlyLi")) {
        $(" <li class=\"commonlyLi\">\n" +
            "                    <div class=\"icon_multiSelect\"></div>\n" +
            "                    <div class=\"word commonSign\" data-item=\"001\" contenteditable=\"true\">选项1</div>\n" +
            "                    <div class=\"singleDeletion iconfont iconreduce-circle\"></div>\n" +
            "                </li>").insertAfter($(obj).parent().siblings(".options").children(".commonlyLi").last());
        //实时限制所有可编辑的字数
        setWords();
    } else {
        $(" <li class=\"commonlyLi\">\n" +
            "                    <div class=\"icon_multiSelect\"></div>\n" +
            "                    <div class=\"word commonSign\" data-item=\"001\" contenteditable=\"true\">选项1</div>\n" +
            "                    <div class=\"singleDeletion iconfont iconreduce-circle\"></div>\n" +
            "                </li>").prependTo($(obj).parent().parent().children(".options"));
        //实时限制所有可编辑的字数
        setWords();
    }

}
/*添加单选的其他选项*/
function addQitaSelect(obj) {
    console.log(obj);
    if ($(obj).parent().siblings(".options").children(".qita").length == 0) {
        $(" <li class=\"qita\">\n" +
            "                    <div class=\"icon_select\"></div>\n" +
            "                    <div class=\"explain\">其他</div>\n" +
            "                    <div class=\"qitaWord commonSign\" data-item=\"01\" contenteditable=\"false\"></div>\n" +
            "                    <div class=\"singleDeletion iconfont iconreduce-circle\"></div>\n" +
            "                </li>").appendTo($(obj).parent().parent().children(".options"));
        //实时限制所有可编辑的字数
        // setWords();
    }
}
/*添加多选中其他选项的封装函数*/
function addQitaMultiSelect(obj) {
    if ($(obj).parent().siblings(".options").children(".qita").length == 0) {
        $("<li class=\"qita\">\n" +
            "                    <div class=\"icon_multiSelect\"></div>\n" +
            "                    <div class=\"explain\">其他</div>\n" +
            "                    <div class=\"qitaWord commonSign\" data-item=\"001\" contenteditable=\"false\"></div>\n" +
            "                    <div class=\"singleDeletion iconfont iconreduce-circle\"></div>\n" +
            "                </li>").appendTo($(obj).parent().parent().children(".options"));
        //实时限制所有可编辑的字数
        // setWords();
    }
}
/*iframe 函数*/
function functionGo(obj) {
    $("iframe").attr("src", obj);
}
/*限制div中的字数*/
function wordsLimit(targetObj, words) {
    var content = targetObj;
    //注册中文的输入事件，
    var isCN = false;
    content.addEventListener('compositionstart', function (event) {
        isCN = true;
        //撤销预输入内容，必须否则会替代末尾字符
        if (this.textContent.length >= words) {
            event.preventDefault();
        }
    });
    content.addEventListener('compositionend', function () {
        isCN = false;
    });
    //注册文本输入事件，获取光标的起止偏移数据,如果是非中文以及超出长度的输入，则撤销本次操作
    var txtAnchorOffset, txtFocusOffset;
    content.addEventListener("textInput", function (event) {
        var _sel = document.getSelection();
        txtAnchorOffset = _sel.anchorOffset;
        txtFocusOffset = _sel.focusOffset;
        //必须加上isCN的判断，否则获取不到正确的光标数据
        if (!isCN && this.textContent.length >= words) {
            event.preventDefault();
        }
    });
    //注册粘贴事件，获取粘贴数据的长度
    var pastedLength;
    content.addEventListener("paste", function (event) {
        if (!event.clipboardData) return;
        pastedLength = event.clipboardData.getData('Text').length;
    });
    //注册输入事件，对输入的数据进行
    content.addEventListener("input", function (event) {
        setTimeout(function () {
            if (!isCN) {
                var _this = content;
                if (_this.textContent.length > words) {
                    var data = _this.textContent;
                    if (pastedLength > 1) {
                        oldDate = data.slice(0, txtAnchorOffset) + data.slice(txtFocusOffset + pastedLength, data.length);
                        //粘贴字符串长度置为0，以免影响到下一次判断。
                        pastedLength = 0;
                    } else {
                        oldDate = data.slice(0, txtAnchorOffset) + data.slice(txtFocusOffset, data.length);
                    }
                    //再次截取最大长度字符串，防止溢出
                    _this.textContent = oldDate.slice(0, words);
                    //光标移动到起始偏移位置
                    document.getSelection().collapse(_this.firstChild, txtAnchorOffset);
                }
            }
        }, 0);
    });
}
/*为所有的可编辑框设置字数限制*/
function setWords() {
    /*----------------------------------限制所有可编辑div中的字数-----------------*/
    // wordsLimit("[contenteditable*=true]",30);
    var obj = $("[contenteditable*=true]");
    for (var i = 0; i < obj.length; i++) {
        wordsLimit(obj[i], 300);
    }
}
//收集选中班级的数据
function cidData(arr) {
    var data = {
        "cids": arr
    };
    return data;
}
$(function () {
    /*  ----------------------------left 和 right 左右侧边栏部分------------------*/
    //实时限制所有可编辑的字数
    setWords();
    /*topWrap部分*/
    $(".topWrap .slider > div").on("click", function () {
        if ($(this).is(".stuArea")) {
            console.log(this);
            // $(this).attr("id");
            $(".right .AnsClass").removeClass("hidden").siblings("ul").addClass("hidden");
        } else if ($(this).is(".teaArea")) {
            console.log(this);
            $(".right .allTeacher").removeClass("hidden").siblings("ul").addClass("hidden");
            $(".right .AnsClass li:not(.answerClass)").remove();
        } else {
            console.log(this);
            $(".right .allTeaAndStu").removeClass("hidden").siblings("ul").addClass("hidden");
            $(".right .AnsClass li:not(.answerClass)").remove();
        }
        $(this).addClass("current").siblings().removeClass("current");
    });
    /*侧边菜单 点击时随着浏览,器的窗口大小变化 发生显隐移动切换*/
    $(window).resize(function () {
        if ($(this).width() <= 992) {
            $(".main").css("margin", "0");
            $(".left > ul").css("display", "none");
            $(".right > ul").css("display", "none");
            /*左右方向箭头*/
            $(".left > div").css("display", "block");
            $(".right > div").css("display", "block");
        } else {
            $(".main").css("margin", "0 170px");
            $(".left > ul").css("display", "block");
            $(".right > ul").css("display", "block");
            $(".left > div").css("display", "none");
            $(".right > div").css("display", "none");
            $(".blackBg").css("display", "none");
        }
    });
    /*当点击时 切换侧边栏缩放*/
    $(".left > div").on("click", function () {
        $(".left > ul").slideDown(500);
        $(this).fadeOut(800);
        $(".blackBg").css("display", "block");
    });
    $(".right > div").on("click", function () {
        $(".right > ul").slideDown(500);
        $(this).fadeOut(800);
        $(".blackBg").css("display", "block");
    });
    $(".blackBg").on("click", function () {
        $(".left > ul").slideUp(100);
        $(".left > div").fadeIn(800);
        $(".right > ul").slideUp(100);
        $(".right > div").fadeIn(800);
        $(this).css("display", "none");
    });
    /*----------model部分------------------*/
    //给name-item设置title值     有更新
    (function () {
        for (var i = 0; i < $(".name-item").length; i++) {
            $($(".name-item")[i]).attr("title", $($(".name-item")[i]).text());
        }
    })();
    /*当点击答题班级这个li时， 变为 false状态*/
    $(".right > ul .answerClass").on("click", function () {
        $(".modal-body .name-item").css("backgroundColor", "transparent").attr("state", "false");
    });
    /*model中的点击效果及点击后保存到指定班级里*/
    $(".modal-body .kindname").on("click", ".name-item", function () {
        if ($(this).attr("state") == "false") {
            $(this).css("backgroundColor", "skyblue").attr("state", "true");
        } else {
            $(this).css("backgroundColor", "transparent").attr("state", "false");
        }
    });
    //保存点击确定获取接受的班级
    $(".selectBtn").on("click", function () {
        /*在往ul中添加相应的班级li前，先删除原先存在于ul中的班级li*/
        $(".right .AnsClass li:not(.answerClass)").remove();
        /*将创建的li添加到右边侧栏的ul中*/
        var nameItemLength = $("[state*=true]").length;
        var arr = [];
        for (var i = 0; i < nameItemLength; i++) {
            /*获取当前选中的班级里的值*/
            var value = $("[state*=true]")[i].innerText;
            var cid = $($("[state*=true]")[i]).attr("data-cid"); //获取classid
            arr.push(cid); //把每个选取的班级压入数组中
            $("<li></li>").css("backgroundColor", "#eeeeee").text(value).appendTo($(".right .AnsClass"));
        }
        console.log(cidData(arr)); //收集cids
    });
    /*----------------------------------我的问卷 .main部分----------------------------*/
    /*当点击问卷中的各个模块时，模块边框变蓝，添加栏颜色变浅蓝*/
    modelObj(".select");
    modelObj(".multiSelect");
    modelObj(".fillBlanks");
    modelObj(".satisfyDegree");
    /*拖动各个模块 和 子选项*/
    $(".bodyWrap").sortable({
        handle: ".drag",
        opacity: 0.7
    });
    /*当鼠标移入到单个选项上时 单项删除为显示状态，否则为隐藏状态*/
    $(".bodyWrap").on("mouseenter", ".options li", function () {
        $(this).children(".singleDeletion").css({
            "display": "block"
        })
    }).on("mouseleave", ".options li", function () {
        $(this).children(".singleDeletion").css({
            "display": "none"
        })
    });
    /*对所有可编辑的block 点击时进行颜色设置*/
    $(".bodyWrap").on("click", "[contenteditable*=true]", function () {
        $("[contenteditable*=true]").css("backgroundColor", "#ffffff");
        $(this).css("backgroundColor", "#eeeeee")
    });

    /*点击五角星评分*/
    $(".bodyWrap").on("click", ".assess li", function () {
        $(this).text("★").css("color", "#f3c14d").prevAll().text("★").css("color", "#f3c14d").end().nextAll().text("☆").css("color", "#828282");
    });
    /*添加相应的模板*/
    addDom($(".left li").eq(0), "select", "<div class=\"select\">\n" +
        "            <div class=\"selectTitle\">\n" +
        "                <span class=\"optionOrder\">1</span>\n" +
        "                <div class=\"titleContent\" data-questionsId=\"01\" contenteditable=\"true\">请选择一个选项</div>\n" +
        "                <span class=\"delete iconfont pull-right\">&#xe68e; </span>\n" +
        "                <span class=\"drag iconfont\" title=\"长按可拖动\">&#xe62f;</span>\n" +
        "            </div>\n" +
        "            <ul class=\"options\">\n" +
        "            </ul>\n" +
        "            <div class=\"add\">\n" +
        "                <span class=\"first iconfont iconhao2 pull-left\" onclick=addSelect(this);> 添加单个选项</span>\n" +
        "                <span class=\"second iconfont icontianjiaqitaxiang\" onclick=addQitaSelect(this);> 添加[其他]项 </span>\n" +
        "            </div>\n" +
        "        </div>", ".bodyWrap");
    addDom($(".left li").eq(1), "multiSelect", " <div class=\"multiSelect\">\n" +
        "            <!--标题-->\n" +
        "            <div class=\"multiSelectTitle\" >\n" +
        "                <span class=\"optionOrder\">1</span>\n" +
        "                <div class=\"titleContent\"  data-questionsId=\"001\" contenteditable=\"true\">请选择多个选项</div>\n" +
        "                <span class=\"delete iconfont pull-right\">&#xe68e; </span>\n" +
        "                <span class=\"drag iconfont\" title=\"长按可拖动\">&#xe62f;</span>\n" +
        "            </div>\n" +
        "            <!--选项-->\n" +
        "            <ul class=\"options\">\n" +
        "                <!--其他选项部分-->\n" +
        "            </ul>\n" +
        "            <div class=\"add\">\n" +
        "                <span class=\"first iconfont iconhao2 pull-left\"  onclick=addMultiSelect(this);> 添加单个选项</span>\n" +
        "                <span class=\"second iconfont icontianjiaqitaxiang\" onclick=addQitaMultiSelect(this);> 添加[其他]项 </span>\n" +
        "            </div>\n" +
        "        </div>", ".bodyWrap");
    addDom($(".left li").eq(2), "fillBlanks", "<div class=\"fillBlanks\">\n" +
        "            <div class=\"fillBlanksTitle\">\n" +
        "                <span class=\"optionOrder\">1</span>\n" +
        "                <div class=\"titleContent\" data-questionsId=\"0001\" contenteditable=\"true\">请填写本项内</div>\n" +
        "                <span class=\"delete iconfont pull-right\">&#xe68e; </span>\n" +
        "                <span class=\"drag iconfont\" title=\"长按可拖动\">&#xe62f;</span>\n" +
        "            </div>\n" +
        "            <div class=\"fillContent\" contenteditable=\"true\"></div>\n" +
        "        </div>", ".bodyWrap");
    addDom($(".left li").eq(3), "satisfyDegree", "<div class=\"satisfyDegree\">\n" +
        "            <div class=\"satisfyTitle\">\n" +
        "                <span class=\"optionOrder\">1</span>\n" +
        "                <div class=\"titleContent\" data-questionsId=\"00001\" contenteditable=\"true\">请您对我们的服务进行评价</div>\n" +
        "                <span class=\"delete iconfont pull-right\">&#xe68e; </span>\n" +
        "                <span class=\"drag iconfont\" title=\"长按可拖动\">&#xe62f;</span>\n" +
        "            </div>\n" +
        "            <ul class=\"assess\">\n" +
        "                <li>☆</li>\n" +
        "                <li>☆</li>\n" +
        "                <li>☆</li>\n" +
        "                <li>☆</li>\n" +
        "                <li>☆</li>\n" +
        "            </ul>\n" +
        "        </div>", ".bodyWrap");
    /*删除单个模板的功能的实现*/
    $(".bodyWrap").on("click", ".delete", function () {
        var that = $(this);
        // alert("确认删除");
        layer.confirm('确认删除', function (index) {
            // that.parent().parent().remove();
            that.fadeTo("normal.css", 0.1, function () { //fade
                $(this).parent().parent().remove(); //then remove from the DOM
                /*判断如果存在。delete则 空白区域不显示，否则显示*/
                if ($(".bodyWrap > div").length == 2) {
                    console.log($(".bodyWrap > div").length);
                    $(".unedited").addClass("show");
                }
                //实时限制所有可编辑的字数
                setWords();
            });
            layer.close(index);
        });
    });
    /*单项删除功能实现，当点击singledelete时，删除相应的li*/
    $(".bodyWrap").on("click", ".singleDeletion", function () {
        $(this).parent().remove();
        //实时限制所有可编辑的字数
        setWords();
    });
    $(".bodyWrap").on("mouseenter", ".singleDeletion", function () {
        $(this).css("cursor", "pointer")
    }).on("mouseleave", ".singleDeletion", function () {
        $(this).css("cursor", "auto");
    });
    /*---预览部分----*/
    /*将对应文件放入预览的模态框中*/
    $(".preview").on("click", function () {
        $(".main .bodyWrap").clone(false).appendTo($("#preModal .modal-body"));
        if ($("#preModal .modal-body .bodyWrap").length == 2) {
            $("#preModal .modal-body .bodyWrap").eq(0).remove();
        }
        $("#preModal .modal-body .bodyWrap > div").css({
            "borderColor": "white",
            "boxShadow": "none"
        }).find(".add").remove();
        $("#preModal .modal-body .bodyWrap [contenteditable*=true]").css("backgroundColor", "#ffffff");
    });

    // 题目名部分     有更新
    $(document).on("focusout", ".titleContent", function () {
        var titleContent = $(this).text().replace(/\s/g, "");
        $(this).text(titleContent);
        if ($(this).text().length > 300) {
            layer.alert("字数超过300个字");
        }
        var id = $(this).attr("data-questionsId");
        console.log(titleContent + "----" + id);
    });
    //选项部分     有更新
    $(document).on("focusout", ".commonSign", function () {
        var optionContent = $(this).text().replace(/\s/g, "");
        $(this).text(optionContent);
        if ($(this).text().length > 300) {
            layer.alert("字数超过300个字");
        }
        var optionId = $(this).attr("data-item");
        console.log(optionId + "-----" + optionContent);
    });
    //问卷标题和欢迎语   有更新
    $(".editTitleWrap [contenteditable*=true]").on("focusout", function () {
        var Content = $(this).text().replace(/\s/g, "");
        $(this).text(Content);
        if ($(this).text().length > 298) {
            layer.alert("字数超过限制，将发生覆盖");
            return;
        }
        console.log(Content);
    })
});