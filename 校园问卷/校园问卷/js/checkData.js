//控制字体到一定数目进行换行操作
function customizeBr(e) {
    var newStr = " ";
    var start, end;
    var name_len = e.name.length || e.text.length;    　　　　　　　　　　　　   //每个内容名称的长度
    var max_name = 9;    　　　　　　　　　　　　　　　　　　//每行最多显示的字数
    var new_row = Math.ceil(name_len / max_name); 　　　　// 最多能显示几行，向上取整比如2.1就是3行
    if (name_len > max_name) { 　　　　　　　　　　　　　　  //如果长度大于每行最多显示的字数
        for (var i = 0; i < new_row; i++) { 　　　　　　　　　　　   //循环次数就是行数
            var old = '';    　　　　　　　　　　　　　　　　    //每次截取的字符
            start = i * max_name;    　　　　　　　　　　     //截取的起点
            end = start + max_name;    　　　　　　　　　  //截取的终点
            if (i == new_row - 1) {    　　　　　　　　　　　　   //最后一行就不换行了
                old = e.name.substring(start) || e.text.substring(start);
            } else {
                old = e.name.substring(start, end) + "\n" || e.text.substring(start.end) + "\n";
            }
            newStr += old; //拼接字符串
        }
    } else {                                          //如果小于每行最多显示的字数就返回原来的字符串
        newStr = e.name || e.text;
    }
    return newStr;
}
//
function controlWords(str) {
    var str1 = "";
    var str2 = "";
    var arr = [];
    for (var i = 0; i < str.length; i++) {
        if (i < 24) {
            str1 += str[i];
        } else if (i > 24 && i < 45) {
            str2 += str[i];
        } else if (i >= 45) {
            str2 += "...";
            break;
        }
    }
    arr.push(str1);
    arr.push(str2);
    if (arr[1] == "") {
        return str;
    } else {
        return arr.join("\n")
    }
}
//获取value信息
function getValueInfo(arr) {
    var Array = [];
    for (var i = 0; i < arr.length; i++) {
        Array.push(arr[i].value);
    }
    return Array;
}
//获取name信息
function getNameInfo(arr) {
    var Array = [];
    for (var i = 0; i < arr.length; i++) {
        Array.push(arr[i].name);
    }
    return Array;
}
//柱状图的配置项
function multiCurOption(textValue, account, AxisData, seriesData) {
    var option = {
        /*  color: ['#3398DB'],
          title : {
              text: controlWords(textValue),
              subtext: '答题人数' + account,
              x:'center'
          },
          tooltip : {
              trigger: 'axis',
              axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                  type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
              }
          },
          grid: {
              left: '3%',
              right: '4%',
              bottom: '3%',
              containLabel: true
          },
          xAxis : [
              {
                  type : 'category',
                  data : ['身边的亲友/同事告知', '看到电视广告', '看到微信推送的广告', '在网上看到广告', '就是逛商场的时候看到', '其他(请注明)', 'Sun'],
                  axisTick: {
                      alignWithLabel: true
                  }
              }
          ],
          yAxis : [
              {
                  type : 'value'
              }
          ],
          series : [
              {
                  name:'直接访问',
                  type:'bar',
                  barWidth: '30%',
                  data:seriesData
              }
          ]*/
        color: ['#3398DB'],
        title: {
            text: controlWords(textValue),
            subtext: '答题人数' + account,
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            },
            position: function (point, params, dom, rect, size) {
                //其中point为当前鼠标的位置，size中有两个属性：viewSize和contentSize，分别为外层div和tooltip提示框的大小
                var x = point[0];//
                var y = point[1];
                var viewWidth = size.viewSize[0];
                var viewHeight = size.viewSize[1];
                var boxWidth = size.contentSize[0];
                var boxHeight = size.contentSize[1];
                var posX = 0;//x坐标位置
                var posY = 0;//y坐标位置

                if (x < boxWidth) {//左边放不开
                    posX = 5;
                } else {//左边放的下
                    posX = x - boxWidth;
                }

                if (y < boxHeight) {//上边放不开
                    posY = 5;
                } else {//上边放得下
                    posY = y - boxHeight;
                }
                return [posX, posY];
            },
            extraCssText: 'width:auto;overflow: hidden;-ms-text-overflow: ellipsis;text-overflow: ellipsis;white-space: pre-wrap;',
        },
        grid: {
            left: '8%',
            right: '8%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01]
        },
        yAxis: {
            type: 'category',
            data: AxisData,
            axisLabel: {
                interval: 0,//标签设置为全部显示
                formatter: function (params) {
                    //将最终的字符串返回
                    var str1 = "";
                    var str2 = "";
                    var arr = [];
                    for (var i = 0; i < params.length; i++) {
                        if (i < 8) {
                            str1 += params[i];
                        } else if (i > 8 && i < 14) {
                            str2 += params[i];
                        } else if (i >= 14) {
                            str2 += "...";
                            break;
                        }
                    }
                    arr.push(str1);
                    arr.push(str2);
                    if (arr[1] == "") {
                        return params;
                    } else {
                        return arr.join("\n")
                    }
                }
            }
        },
        series: [

            {
                name: '2012年',
                type: 'bar',
                barWidth: '60%',
                data: seriesData,
            },
        ]
    };
    return option;
}
// 指定图表的配置项和数据的函数
function currentOption(textValue, account, seriesData) {
    var option = {
        aria: {
            show: true
        },
        title: {
            text: controlWords(textValue),
            subtext: '答题人数' + account,
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)",
            position: function (point, params, dom, rect, size) {
                //其中point为当前鼠标的位置，size中有两个属性：viewSize和contentSize，分别为外层div和tooltip提示框的大小
                var x = point[0];//
                var y = point[1];
                var viewWidth = size.viewSize[0];
                var viewHeight = size.viewSize[1];
                var boxWidth = size.contentSize[0];
                var boxHeight = size.contentSize[1];
                var posX = 0;//x坐标位置
                var posY = 0;//y坐标位置

                if (x < boxWidth) {//左边放不开
                    posX = 5;
                } else {//左边放的下
                    posX = x - boxWidth;
                }

                if (y < boxHeight) {//上边放不开
                    posY = 5;
                } else {//上边放得下
                    posY = y - boxHeight;
                }
                return [posX, posY];
            },
            extraCssText: 'width:auto;overflow: hidden;-ms-text-overflow: ellipsis;text-overflow: ellipsis;white-space: pre-wrap;',
        },
        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: '60%',
                center: ['50%', '50%'],
                /*data:[
                    {value:6, name:'男'},
                    {value:3, name:'女'}
                ],*/
                label: {
                    normal: {
                        show: true,
                        formatter: customizeBr,
                        textStyle: {
                            align: "left",
                            baseline: "top"
                        },
                    }
                },
                data: seriesData,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    return option;
}
// 基于准备好的dom，初始化echarts实例
function kindDom(selector) {
    return echarts.init(document.getElementById(selector))
}
function wrap(id, data) {
    kindDom(id).setOption(currentOption(data.textValue, data.account, data.seriesData));
}
function axisWrap(id, data) {
    kindDom(id).setOption(multiCurOption(data.textValue, data.account, getNameInfo(data.seriesData), getValueInfo(data.seriesData)));
}
/*监听window中的resize事件,为所有的pie自适应*/
window.addEventListener("resize", function () {
    for (var i = 0; i < $(".panel-body .pie").length; i++) {
        echarts.init(document.querySelectorAll(".pie")[i]).resize();
    }
});
