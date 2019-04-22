<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="/WXMiniProgram/static/lib/layui/css/layui.css" media="all">
<link rel="stylesheet" href="/WXMiniProgram/static/css/font.css"
	media="all" />
</head>
<body style="margin: 25px 50px 25px;">
	<blockquote class="layui-elem-quote layui-text">
		温馨提醒：<br> &emsp;1. 应该尽可能的避免对数据进行修改；<br> &emsp;2.
		数据修改应该是紧急状况，需要<a href="" style="color: blue">发布公告</a>。
	</blockquote>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>单条记录编辑模式</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" id="edit_form">
	<div class="layui-input-block" hidden="true">
				<input type="text" name="id" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input"
					value="${cri.id}" id="id">
			</div>
		<div class="layui-form-item">
			<label class="layui-form-label">公司名称</label>
			<div class="layui-input-block">
				<input type="text" name="company_name" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input"
					value="${cri.company_name}" id="company_name">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">举办日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" placeholder="举办日期"
						name="hold_date" value="${cri.hold_date}" id="hold_date">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">举办时间</label>
				<div class="layui-input-inline">
					<input class="layui-input" placeholder="举办时间" name="start_time"
						value="${cri.start_time}" id="start_time">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">具体地址</label>
			<div class="layui-input-block">
				<input type="text" name="locations" autocomplete="off"
					placeholder="请输入" class="layui-input" value="${cri.locations}" id="locations">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">&emsp;招聘详情</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" class="layui-textarea"
					value="${cri.detail}" id="detail" name="detail"></textarea>
			</div>
		</div>

		<br>
		<div style="text-align: center">
		<button class="layui-btn" style="width: 45%" type="button" onclick="modify()">修改</button>
			<button class="layui-btn layui-btn-danger" type="reset"
				style="width: 45%">恢复</button>
		</div>
	</form>
	<script src="/WXMiniProgram/static/lib/layui/layui.js" charset="utf-8"></script>
	<script src="/WXMiniProgram/static/js/xadmin.js" charset="utf-8"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		function modify(){
			// 判断
			var cri = '<%=request.getAttribute("cri")%>';
			var isMCompany = $("#company_name").val() == "${cri.company_name}";
			var isMHoldDate = $("#hold_date").val() == "${cri.hold_date}";
			var isMStartTime = $("#start_time").val() == "${cri.start_time}";
			var isMLocations = $("#locations").val() == "${cri.locations}";
			var isMdetails = $("#detail").val() == "${cri.detail}";
			// 获取当前弹出层窗口id
			var layuiWindow = parent.layer.getFrameIndex(window.name);
			if(isMCompany && isMHoldDate && isMStartTime && isMLocations && isMdetails){
				console.log("there")
				layui.use('layer',function(){
					layer = layui.layer;
					layer.msg("没有进行任何修改", {
						icon : 0,
						time : 1000
					});
				});	
			}else{
				console.log("here")
				layui.use('layer',function(){
					layer = layui.layer;
					index = layer.load(0);
					$.ajax({
						url: "/WXMiniProgram/info/modify",
						data: $("#edit_form").serialize(),
						success:function(res){
							msg = (res.msg == "true"?"修改成功":"修改失败");
							icon = (res.msg == "true"?1:0);
							layer.msg(msg,{icon:icon,time:1000});
							// 关闭当前窗口并刷新父窗口
							setTimeout(function(){parent.layer.close(index)}, 1000);
							setTimeout(function(){parent.location.reload()}, 1000);
						},
						fail:function(res){
							layer.msg("请求接口失败")
						},
						// 接口回调
						complete:function(res){
							layer.close(index);
						}
					})
				});
			}
		}
	</script>
</body>
</html>