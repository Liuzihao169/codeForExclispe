/*点击发布图标时触发的效果*/
/*
function clickIconfont(iconObj,targetClassName){
    iconObj.on("click",function () {
        var thatobj = $(this);
        /!*阻止跳转*!/
        if($(this).parent().siblings().eq(2).find(".unreleased").is(".show")){//未发布时
            if($(this).is(".edit")){
                fungoManager("newQuestionnaire.html");
            }
            /!*如果点击对象为停止收集，则终止跳转*!/
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
                    ///!*显示 当前状态 即已发布 未发布 停止收集*!/
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
                    content:'已完成发布和收集,请勿重复操作'
                });
                return false;
            }

        }
        /!*若当前对象位编辑，则执行空语句*!/
        if($(this).is(".edit")){

        }else {
            var value = thatobj.parent().siblings().eq(2).find(".show").attr("value");

            layer.confirm('确认' + thatobj.attr("title"), function (index) {
                ///!*显示 当前状态 即已发布 未发布 停止收集*!/
                console.log(value);
                console.log( thatobj.parent().siblings().eq(2).find(targetClassName).addClass("show").attr("value"));
                thatobj.parent().siblings().eq(2).find(targetClassName).addClass("show").siblings().removeClass("show");
                layer.close(index);
            });

        }
    });
}*/
//加载和关闭
/*
layer.load(2, {
    shade: [0.6, '#fff'], content: '加载中...', success: function (layero) {
        layero.find('.layui-layer-loading').css({
            'margin':'0 auto'
        });
        layero.find('.layui-layer-content').css({
            'padding-top': '6px',
            'width': '150px',
            'margin':'0 auto',
            'padding-left':'36px'
        });
        layero.find('.layui-layer-ico16, .layui-layer-loading .layui-layer-loading2').css({
            'width': '150px !important',
            'background-position': '2px 0 !important'
        });
    }
});

layer.closeAll('loading');*/
$(document).on("focusout","[contenteditable*=]")