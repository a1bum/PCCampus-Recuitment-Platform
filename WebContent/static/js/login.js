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
				if(data.msg=="success"){
					window.location.href ="admin/toIndex";
				}else{
				    alert("用户名或密码错误，请重试！");
				}
			},
			fail:function(res){
				console.log("请求接口失败" + res);
			}
		});
	});
})
