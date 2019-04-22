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
		温馨提醒：<br> &emsp;1. 应该尽可能的通过公司申请审核；<br> &emsp;2.
		应该尽可能的避免直接进行添加；<br> &emsp;3. 数据修改应该是紧急状况，需要<a href=""
			style="color: blue">发布公告</a>。
	</blockquote>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>单条记录手动添加模式</legend>
	</fieldset>
	<form class="layui-form layui-form-pane">
		<div class="layui-form-item">
			<label class="layui-form-label">风险</label>
			<div class="layui-input-block">
				<input type="checkbox" title="我已阅读温馨提示并确认直接添加信息风险" id="agree">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">公司名称</label>
			<div class="layui-input-block">
				<input type="text" name="company_name" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input" id="company_name">
			</div>
		</div>
		<div class="grid-demo grid-demo-bg2">
			<div class="layui-form-item ">
				<div class="layui-inline">
					<label class="layui-form-label">举办日期</label>
					<div class="layui-input-inline">
						<input class="layui-input" placeholder="举办日期" name="hold_time" id="hold_date">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">举办时间</label>
					<div class="layui-input-inline">
						<input class="layui-input" placeholder="举办时间" name="start_time"
							id="start_time">
					</div>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">具体地址</label>
			<div class="layui-input-block">
				<input type="text" name="locations" autocomplete="off" placeholder="请输入"
					class="layui-input" id="locations">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">附件</label>&ensp;
			<button type="button" class="layui-btn layui-bg-blue" id="upload">
				<i class="layui-icon"></i>上传附件
			</button>
			<input class="layui-upload-file" type="file" accept="undefined"
				name="file" id="upload">
			<div class="layui-inline layui-word-aux">仅支持doc/docx/pdf文档类型，大小限制2M</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">&emsp;招聘详情</label>
			<div class="layui-input-block">
				<textarea placeholder="   请输入内容" class="layui-textarea" id="detail"></textarea>
			</div>
		</div>

		<br>
		<div style="text-align: center">
			<button class="layui-btn" style="width: 45%"  onclick="submit">提交</button>
			<button class="layui-btn layui-btn-danger" type="reset"
				style="width: 45%" id="reset">重置</button>
		</div>
	</form>
	<script src="/WXMiniProgram/static/lib/layui/layui.js" charset="utf-8"></script>
	<script src="/WXMiniProgram/static/js/xadmin.js" charset="utf-8"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		// 上传功能
		layui.use('upload', function() {
			var upload = layui.upload;
			//指定允许上传的文件类型
			  upload.render({
			    elem: '#upload'
			    ,url: '/WXMiniProgram/info/upload'
			    ,accept: 'file' //普通文件
			    ,acceptMime: '.doc,.docx,.pdf'
			    ,exts: 'doc|docx|pdf'
			    ,size: 2048
			    ,done: function(res){
			      console.log(res)
			    }
			  });
		});
		// 重新渲染form，解决checkbox组件不显示情况，还有人眼能看到没有css样式修饰的情况
		layui.use('form',function(){
			var form = layui.form;
			form.render();
		});
	</script>
</body>
</html>