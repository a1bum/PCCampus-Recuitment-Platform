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
<body>
	<blockquote class="layui-elem-quote layui-text">
		温馨提醒：<br> &emsp;1. 应该尽可能的避免对数据进行修改；<br> &emsp;2.
		数据修改应该是紧急状况，需要<a href="" style="color: blue">发布公告</a>。
	</blockquote>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>单条记录编辑模式</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">编号</label>
			<div class="layui-input-inline">
				<input type="text" name="username" lay-verify="required"
					placeholder="请输入" autocomplete="off" class="layui-input"
					value="${cri.id}">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">举办日期</label>
				<div class="layui-input-inline">
					<input class="layui-input" placeholder="举办日期" name="hold_time"
						value="${cri.hold_date}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">举办时间</label>
				<div class="layui-input-inline">
					<input class="layui-input" placeholder="举办日期" name="hold_time"
						value="${cri.start_time}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">具体地址</label>
			<div class="layui-input-block">
				<input type="text" name="title" autocomplete="off" placeholder="请输入"
					class="layui-input" value="${cri.locations}">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">&emsp;招聘详情</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" class="layui-textarea"
					value="${cri.detail}"></textarea>
			</div>
		</div>
		<div style="text-align: center">
			<button class="layui-btn" style="width: 80%">提交</button>
			<br>
			<br>
			<button class="layui-btn layui-btn-danger" type="reset"
				style="width: 80%">重置</button>
		</div>
	</form>
	<script src="/WXMiniProgram/lib/layui/layui.js" charset="utf-8"></script>
</body>
</html>