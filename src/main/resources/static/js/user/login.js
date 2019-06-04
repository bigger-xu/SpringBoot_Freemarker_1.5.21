function toLogin(){
    var userName = $("#userName").val();
    var password = $("#password").val();
    if(userName == null || userName == ''){
        layer.msg("请输入用户名");
        return;
    }
    if(password == null || password == ''){
        layer.msg("请输入密码");
        return;
    }
    layer.load(1, {shade: [0.5,'#000']});
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: "/user/login",
        data: {"userName": userName,"password":password},
        success: function (result) {
            if (result.code == 0) {
                setTimeout(function(){
                    layer.closeAll('loading');
                    window.location.href="/user";
                },1000)
            } else {
                layer.closeAll('loading');
                layer.msg(result.msg);
            }
        }
    })
}