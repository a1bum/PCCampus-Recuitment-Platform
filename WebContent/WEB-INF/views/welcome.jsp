<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="/WXMiniProgram/static/css/font.css">
<link rel="stylesheet" href="/WXMiniProgram/static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="/WXMiniProgram/static/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/WXMiniProgram/static/js/xadmin.js"></script>
<script type="text/javascript" src="/WXMiniProgram/static/js/cookie.js"></script>
</head>
<body>
	<div class="x-body">
		<fieldset class="layui-elem-field">
			<legend>数据统计</legend>
			<div class="layui-field-box">
				<div class="layui-col-md12">
					<div class="layui-card">
						<div class="layui-card-body">
							<div class="layui-carousel x-admin-carousel x-admin-backlog"
								lay-anim="" lay-indicator="inside" lay-arrow="none"
								style="width: 100%; height: 90px;">
								<div carousel-item="">
									<ul class="layui-row layui-col-space10 layui-this"
										style="text-align: center;">
										<li class="layui-col-xs2"><a
											onclick="x_admin_show('新增管理员','/WXMiniProgram/admin/admin_add',800,600)"
											class="x-admin-backlog-body">
												<p>
													<cite style="color: red;">${adminTotals}</cite>
												</p>
												<h3>待审核</h3>
										</a></li>
										<li class="layui-col-xs2"><a
											onclick="x_admin_show('个人信息','/WXMiniProgram/admin/admin_info',600,500)"
											class="x-admin-backlog-body">
												<p>
													<cite>${adminTotals}</cite>
												</p>
												<h3>管理员数量</h3>
										</a></li>
										<li class="layui-col-xs2"><a href=""
											class="x-admin-backlog-body">
												<p>
													<cite class="criHolds"></cite>
												</p>
												<h3>已举办数量</h3>
										</a></li>
										<li class="layui-col-xs2"><a
											href="../info/cri_list_limit?admin_university=${adminUniversity}&isExpired=1"
											class="x-admin-backlog-body">
												<p>
													<cite class="criNHolds"></cite>
												</p>
												<h3>未举办数量</h3>
										</a></li>
										<li class="layui-col-xs2"><a href="javascript:;"
											class="x-admin-backlog-body">
												<p>
													<cite class="criTotals"></cite>
												</p>
												<h3>已有数据量</h3>
										</a></li>
										<li class="layui-col-xs2"><a
											onclick="x_admin_show('个人信息','/WXMiniProgram/admin/admin_info',600,500)"
											class="x-admin-backlog-body">
												<p>
													<cite>${feedbacks}</cite>
												</p>
												<h3>反馈</h3>
										</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend>系统信息</legend>
			<div class="layui-field-box">
				<table class="layui-table">
					<tbody>
						<tr>
							<th>xxx版本</th>
							<td>1.0.180420</td>
						</tr>
						<tr>
							<th>服务器地址</th>
							<td>x.xuebingsi.com</td>
						</tr>
						<tr>
							<th>操作系统</th>
							<td>WINNT</td>
						</tr>
						<tr>
							<th>运行环境</th>
							<td>Apache/2.4.23 (Win32) OpenSSL/1.0.2j mod_fcgid/2.3.9</td>
						</tr>
						<tr>
							<th>MYSQL版本</th>
							<td>5.5.53</td>
						</tr>
						<tr>
							<th>ThinkPHP</th>
							<td>5.0.18</td>
						</tr>
						<tr>
							<th>上传附件限制</th>
							<td>2M</td>
						</tr>
						<tr>
							<th>执行时间限制</th>
							<td>30s</td>
						</tr>
						<tr>
							<th>剩余空间</th>
							<td>86015.2M</td>
						</tr>
					</tbody>
				</table>
			</div>
		</fieldset>
	</div>
	<script type="text/javascript">
		// 数据可视化中赋值
		$.ajax({
			url : "/WXMiniProgram/info/criTotals",
			success : function(res) {
				$(".criHolds").text(res.criHolds);
				$(".criNHolds").text(res.criNHolds);
			},
			fail : function(res) {
				console.log("调用接口失败")
			},
		});
	</script>
</body>
</html>