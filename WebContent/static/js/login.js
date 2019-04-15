layui.config({
	base : "js/"
}).use(['form','layer'],function(){
	var form = layui.form;
		layer = parent.layer === undefined ? layui.layer : parent.layer;
		$ = layui.jquery;
	
	//登录按钮事件
	form.on("submit(login)",function(){
		$.ajax({
			url  : "admin/login",
			type : "post",
			async: true, 
			data : $("#login_form").serialize(),
			success : function(data) {
				if(data.msg == "fail"){
					console.log("用户名或密码错误");
				}else{
					window.location.href="admin/toIndex";
				}
			},
			fail:function(res){
				console.log("请求接口失败" + res);
			}
		});
	});
})
