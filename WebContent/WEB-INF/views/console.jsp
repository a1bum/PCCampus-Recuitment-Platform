﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8">
<title>layuiAdmin 控制台主页一</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chromFe=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet"
	href="/WXMiniProgram/static/lib/layui/css/layui.css"">
<link rel="stylesheet" href="/WXMiniProgram/static/css/admin.css"">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
</head>
<body onload="getSysInfo()">
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md8">
				<div class="layui-row layui-col-space15">
					<div class="layui-col-md6">
						<div class="layui-card">
							<div class="layui-card-header">快捷方式</div>
							<div class="layui-card-body">
								<div class="layui-carousel layadmin-carousel layadmin-shortcut">
									<div>
										<ul class="layui-row layui-col-space10">
											<li class="layui-col-xs3"><a
												lay-href="home/homepage1.html"> <i
													class="layui-icon layui-icon-add-circle-fine"></i> <cite>添加</cite>
											</a></li>
											<li class="layui-col-xs3"><a
												lay-href="home/homepage2.html"> 
												<i class="layui-icon layui-icon-chart"></i> <cite>统计图表</cite>
											</a></li>
											<li class="layui-col-xs3"><a
												lay-href="component/layer/list.html"> <i
													class="layui-icon layui-icon-template-1"></i> <cite>公司</cite>
											</a></li>
											<li class="layui-col-xs3"><a layadmin-event="im"> <i
													class="layui-icon layui-icon-set"></i> <cite>设置</cite>
											</a></li>
											<li class="layui-col-xs3"><a
												lay-href="component/progress/index.html"> <i
													class="layui-icon layui-icon-find-fill"></i> <cite>流量查看</cite>
											</a></li>
											<li class="layui-col-xs3"><a
												lay-href="app/workorder/list.html"> <i
													class="layui-icon layui-icon-survey"></i> <cite>工单</cite>
											</a></li>
											<li class="layui-col-xs3"><a
												lay-href="user/user/list.html"> <i
													class="layui-icon layui-icon-user"></i> <cite>用户</cite>
											</a></li>
											<li class="layui-col-xs3"><a
												lay-href="set/system/website.html"> <i
													class="layui-icon layui-icon-set"></i> <cite>个人中心</cite>
											</a></li>
										</ul>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="layui-col-md6">
						<div class="layui-card">
							<div class="layui-card-header">待办事项</div>
							<div class="layui-card-body">
								<div class="layui-carousel layadmin-carousel layadmin-backlog">
									<div>
										<ul class="layui-row layui-col-space10">
											<li class="layui-col-xs6"><a
												lay-href="app/content/comment.html"
												class="layadmin-backlog-body">
													<h3>宣讲待审</h3>
													<p>
														<cite id="review" style="color:#FF5722"></cite>
													</p>
											</a></li>
											<li class="layui-col-xs6"><a
												lay-href="app/forum/list.html" class="layadmin-backlog-body">
													<h3>总数</h3>
													<p>
														<cite id="total" style="color:#5FB878">12</cite>
													</p>
											</a></li>
											<li class="layui-col-xs6"><a
												lay-href="template/goodslist.html"
												class="layadmin-backlog-body">
													<h3>已举行</h3>
													<p>
														<cite id="isHolds" style="color:#01AAED">99</cite>
													</p>
											</a></li>
											<li class="layui-col-xs6"><a href="javascript:;"
												class="layadmin-backlog-body">
													<h3>未举行</h3>
													<p>
														<cite id="isNHolds" style="color:#FFB800">20</cite>
													</p>
											</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-col-md12">
						<div class="layui-card">
							<div class="layui-card-header">数据概览</div>
							<div class="layui-card-body">
								<div class="layui-carousel layadmin-carousel layadmin-dataview"
									data-anim="fade" lay-filter="LAY-index-dataview">
									<div carousel-item id="LAY-index-dataview">
										<div>
											<i class="layui-icon layui-icon-loading1 layadmin-loading"></i>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="layui-col-md4">
				<div class="layui-card">
					<div class="layui-card-header">版本信息</div>
					<div class="layui-card-body layui-text">
						<table class="layui-table">
							<colgroup>
								<col width="100">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<td>OS</td>
									<td>${versionInfo}</td>
								</tr>
								<tr>
									<td>Server</td>
									<td><%=application.getServerInfo()%></td>
								</tr>
								<tr>
									<td>MySQL</td>
									<td>${mysqlInfo}</td>
								</tr>
								<tr>
									<td>layui 授权</td>
									<td style="padding-bottom: 0;">
										<div class="layui-btn-container">
											<a href="http://www.layui.com/admin/" target="_blank"
												class="layui-btn layui-btn-danger">获取授权</a> <a
												href="http://fly.layui.com/download/layuiAdmin/"
												target="_blank" class="layui-btn">立即下载</a>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="layui-card">
					<div class="layui-card-header">实时监控</div>
					<div class="layui-card-body layadmin-takerates">
						<div class="layui-progress" lay-showPercent="yes">
							<h3>CPU使用率</h3>
							<div class="layui-progress-bar cpuInfo">
								<span class="layui-progress-text cpuInfoText"></span>
							</div>

						</div>
						<div class="layui-progress" lay-showPercent="yes">
							<h3>内存占用率</h3>
							<div class="layui-progress-bar memInfo" lay-percent="">
								<span class="layui-progress-text memInfoText"></span>
							</div>
						</div>
					</div>
				</div>

				<div class="layui-card">
					<div class="layui-card-header">
						申请动态 <i class="layui-icon layui-icon-tips" lay-offset="5"></i>
					</div>
					<div class="layui-card-body">
						<div class="layui-carousel layadmin-carousel layadmin-news"
							data-autoplay="true" data-anim="fade" lay-filter="news">
							<div carousel-item>
								<div>
									<a href="http://fly.layui.com/docs/2/" target="_blank"
										class="layui-bg-red">layuiAdmin 快速上手文档</a>
								</div>
								<div>
									<a href="http://fly.layui.com/vipclub/list/layuiadmin/"
										target="_blank" class="layui-bg-green">layuiAdmin 会员讨论专区</a>
								</div>
								<div>
									<a href="http://www.layui.com/admin/#get" target="_blank"
										class="layui-bg-blue">获得 layui 官方后台模板系统</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<script>
		function getSysInfo() {
			// 请求数据刷新页面
			$.ajax({
				url : "/WXMiniProgram/admin/sysinfo",
				success : function(res) {
					$(".cpuInfo").attr("style", "width: " + res.cpuInfo + "%");
					$(".memInfo").attr("style", "width: " + res.memInfo + "%");
					$(".cpuInfoText").text(res.cpuInfo + "%");
					$(".memInfoText").text(res.memInfo + "%");
					// 设置特效颜色，cpu  的
					if (res.cpuInfo >= 60) {
						$(".cpuInfo").addClass("layui-bg-orange");
					} else if (res.cpuInfo >= 90) {
						$(".cpuInfo").addClass("layui-bg-red");
					} else {
						$(".cpuInfo").removeClass("layui-bg-orange");
						$(".cpuInfo").removeClass("layui-bg-red");
					}
					// 设置特效颜色，mem 的
					if (res.memInfo >= 60) {
						$(".memInfo").addClass("layui-bg-orange");
					} else if (res.memInfo >= 90) {
						$(".cpuInfo").addClass("layui-bg-red");
					} else {
						$(".cpuInfo").removeClass("layui-bg-orange");
						$(".cpuInfo").removeClass("layui-bg-red");
					}
				}
			});
			// 设置延迟
			setTimeout(getSysInfo, 1000);
		}
		// 由于info和admin两个controller不能互相访问service，所以
		$.ajax({
			url: '/WXMiniProgram/info/statistic',
			success:function(res){
				$("#total").text(res.total);
				$("#isHolds").text(res.isHolds);
				$("#isNHolds").text(res.isNHolds);
				$("#review").text(res.review);
			},
		})
	</script>
</body>
</html>

