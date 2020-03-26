$(function () {
   $("#submit").on("click",function () {
       if($("#username").val().length == 0){
           $("#username").siblings(".tip").css("color","red").text("用户名不能为空");
           return false;
       }
       if($("#password").val().length == 0){
           $("#password").siblings(".tip").css("color","red").text("密码不能为空");
           return  false;
       }
   });
    $("input").on("keyup",function () {
        if($(this).val().length != 0){
            $(this).siblings(".tip").css("color","rgba(204, 204, 204, 0.78)").text($(this).attr("prompt"))
        }
    })
});