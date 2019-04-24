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
