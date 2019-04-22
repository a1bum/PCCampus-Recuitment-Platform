/*
 * 遮罩式弹窗 title 标题 url 请求的url w 窗口宽度 h 窗口高度
 */
function x_admin_show(title,url,w,h,full=false){
	layui.use('layer',function(){
	layer = layui.layer;
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=($(window).width()*0.9);
    };
    if (h == null || h == '') {
        h=($(window).height() - 50);
    };
    var index = layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, 
        maxmin: true,
        shadeClose: true,
        shade:0.4,
        title: title,
        content: url
    });
    if(full){
       layer.full(index); 
    }
});
}
/* 窗口关闭函数 */
function x_admin_close(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}
// 重新渲染父窗口
function x_admin_father_reload(){
    parent.location.reload();
}
// 单个删除功能
function member_del(obj, id) {
	layer.confirm('确认要删除吗？', function(index) {
		$.ajax({
			url: "/WXMiniProgram/info/delete",
			data: {id:id},
			success:function(res){
				if(res.msg == "删除成功"){
					layer.msg('已删除!', {
						icon : 1,
						time : 1000
					});
				}else{
					layer.msg('未删除!', {
						icon : 0,
						time : 1000
					});
				}
			},
			fail:function(res){
				layer.msg('请求接口失败', {
					icon : 0,
					time : 1000
				});
			}
		})
		// 发异步删除数据
		$(obj).parents("tr").remove();
		
	});
};
// 批量删除功能
function delAll(argument) {
	var data = tableCheck.getData();
	layer.confirm('确认要删除吗？' + data, function(index) {
		// 捉到所有被选中的，发异步进行删除
		layer.msg('删除成功', {
			icon : 1
		});
		$(".layui-form-checked").not('.header').parents('tr').remove();
	});
};
// 加载laydate模块
layui.use('laydate', function() {
	var laydate = layui.laydate;
	// 渲染日期选择框为layui形式
	laydate.render({
		elem : '#hold_date',
		type : 'date'
	});
	laydate.render({
		elem : '#start_time',
		type : 'time'
	});

});