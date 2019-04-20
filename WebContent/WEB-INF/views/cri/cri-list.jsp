<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>校招信息列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="/WXMiniProgram/static/css/font.css">
<link rel="stylesheet" href="/WXMiniProgram/static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="/WXMiniProgram/static/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/WXMiniProgram/static/js/xadmin.js"></script>
<script type="text/javascript" src="/WXMiniProgram/static/js/cookie.js"></script>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" scope="page" />
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a
			href="/WXMiniProgram/admin/toIndex">首页</a> <a> <cite>${isHolded}</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">&#xe669;</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so" id="search_form" action="/WXMiniProgram/info/searchPC">
			<input name="isExpired" hidden="true" value="${info.isExpired}"/>
			<input name="admin_university" hidden="true" value="${info.university_name}"/>
				<input class="layui-input" placeholder="举办日期" name="start"
					id="start"> <i class="iconfont">&#xe6bf;</i> <input
					type="text" name="key" placeholder="关键字" autocomplete="off"
					class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach"
					onclick="search">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn"
			onclick="x_admin_show('添加信息','/WXMiniProgram/info/cri_add')">
			<i class="layui-icon"></i>添加
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：${pageInfo.total}
			条</span> </xblock>
		<table class="layui-table x-admin" style="text-align:center;">
			<thead>
				<tr>
					<th style="text-align:center;">
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th style="text-align:center;">宣讲编号</th>
					<th style="text-align:center;">公司名称</th>
					<th style="text-align:center;">举办时间</th>
					<th style="text-align:center;">学校简称</th>
					<th style="text-align:center;">所在学校</th>
					<th style="text-align:center;">学校logo</th>
					<th style="text-align:center;">具体地址</th>
					<th style="text-align:center;">当前点击量</th>
					<th style="text-align:center;">编辑</th>
					<th style="text-align:center;">删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageInfo.list}" var="info">
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" data-id='2'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td>${info.id}</td>
						<td>${info.company_name}</td>
						<td>${info.hold_date}&emsp;${info.start_time}</td>
						<td>${info.university_short_name}</td>
						<td>${info.university_name}</td>
						<td>${info.logo_url}</td>
						<td>${info.locations}</td>
						<td>${info.hot}</td>
						<td>
							<button class="layui-btn">
								<a title="编辑" onclick="x_admin_show('编辑','order-view.html')">
									<i class="layui-icon" style="color: white">&#xe642;</i>
								</a>
							</button>
						</td>
						<td class="td-manage">
							<button class="layui-btn layui-btn-danger">
								<a title="删除" onclick="member_del(this,'要删除的id')"> <i
									class="iconfont" style="color: white">&#xe69d;</i>
								</a>
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<div class="page">
			<div>
				<c:if test="${pageInfo.hasPreviousPage  == true}">
					<a class="prev"
						href="/WXMiniProgram/info/cri_list_limit?p=${pageInfo.pageNum-1}&admin_university=${adminUniversity}&isExpired=${isExpired}">&lt;&lt;</a>
				</c:if>
				<a class="current" href="">${pageInfo.pageNum}</a>
				<c:if test="${pageInfo.hasNextPage == true}">
					<a class="next"
						href="/WXMiniProgram/info/cri_list_limit?p=${pageInfo.pageNum+1}&admin_university=${adminUniversity}&isExpired=${isExpired}">&gt;&gt;</a>
				</c:if>
			</div>
		</div>

	</div>
	<script>
	
		// 搜索事件
		function search(){
			$.ajax({
				url: "/WXMiniProgram/info/searchPC",
				data:{
					admin_university: param,
					keyword: $("#key").val(),
					date: $("#start").val()
				},
				success:function(res){
					console.log("返回数据" + res);
				},
				fail:function(res){
					console.log("请求接口失败 " +res);
				}
			});
		};
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});
		});
		// 单个删除功能
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});
		};
		// 批量删除功能
		function delAll(argument) {

			var data = tableCheck.getData();

			layer.confirm('确认要删除吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			});
		};
	</script>
</body>
</html>