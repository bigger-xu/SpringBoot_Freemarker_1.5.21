/**
 * @description
 * @author Zhang Yongwei
 * @date 2019-06-06 12:08:40
 * @version 1.0
 */
$(function () {
    loadPage();
});
// 选择每页显示多少条
$("#pageCount").change(function(){
    $("#pageCountParam").val($(this).val());
    loadPage();
})
function loadPage(page) {
    layer.load(1, {shade: [0.5, '#000']});
    $("#itemsPanel").skillAjax({
        url: "/cms/adminUser/page",//提交连接
        model: $("#skillModel"),
        pageModel:$("#pageModel"),
        data: {"pageCount":$("#pageCount").val()},
        pageNum: page,
        callback: function (result) {
            layer.closeAll('loading');
            var num = result.page.startIndex;
            if (result != null && result.page != null && result.page.rows.length > 0) {
                $("#itemsPanel tr").each(function () {
                    //为序号赋值
                    $(this).find("[key=num]").append(num);
                    num ++ ;
                });
            } else {
                $("#itemsPanel").html("<tr><td style='text-align: center' colspan='8'>暂无数据</td>></tr>")
            }
        }//回调方法
    });
}

//进入修改页面
$(document).on("click", ".update", function () {
    var id = $(this).parent().find("#id").val();
    window.location.href = "/adminUser/edit?id=" + id;
});
//删除
$(document).on("click", ".delete", function () {
    var id = $(this).parent().find("#id").val();
    layer.confirm('您确定要删除吗？', {
        btn: ['确定', '关闭'],//按钮
        title: false,
        closeBtn: false
    }, function () {
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: "/adminUser/delete",
            data: {"id": id},
            success: function (result) {
                if (result.flag == 1) {
                    $("#closeBtnLab").click();
                    layer.msg("操作成功");
                    loadPage();
                } else {
                    layer.msg("操作失败");
                }
            }
        })
    })
});
