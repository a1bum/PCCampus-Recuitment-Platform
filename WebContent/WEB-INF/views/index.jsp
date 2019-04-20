<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>后台登录-CRI-Campus</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="/WXMiniProgram/static/css/font.css">
<link rel="stylesheet" href="/WXMiniProgram/static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>
<script src="/WXMiniProgram/static/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/WXMiniProgram/static/js/xadmin.js"></script>
<script type="text/javascript" src="/WXMiniProgram/static/js/cookie.js"></script>
</head>
<body>
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="">CRI-Campus</a>
		</div>
		<div class="left_open">
			<i title="展开左侧栏" class="iconfont">&#xe699;</i>
		</div>
		<ul class="layui-nav left fast-add" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">新增<i
					class="layui-icon">&#xe654;</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a
							onclick="x_admin_show('新增管理员','/WXMiniProgram/admin/admin_add',800,600)"><i
							class="iconfont">&#xe6b8;</i>管理员</a>
					</dd>
					<dd>
						<a onclick="x_admin_show('新增校招信息','/WXMiniProgram/info/cri_add')"><i
							class="iconfont">&#xe6a8;</i>校招信息</a>
					</dd>
					<dd>
						<a onclick="x_admin_show('新增企业信息','https://www.baidu.com')"><i
							class="iconfont">&#xe6a2;</i>企业信息</a>
					</dd>
				</dl></li>
		</ul>
		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item">${adminUniversity}</li>
			<li class="layui-nav-item"><a href="javascript:;">${adminAccount}</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a
							onclick="x_admin_show('个人信息','/WXMiniProgram/admin/admin_info',550,500)">个人信息</a>
					</dd>
					<dd>
						<a href="/WXMiniProgram/login.html">切换帐号</a>
					</dd>
					<dd>
						<a href="/WXMiniProgram/index.html">退出</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item to-index"><a href="">前台首页</a></li>
		</ul>

	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
						<cite>管理员管理</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a _href="admin-list.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>管理员列表</cite>
						</a></li>
						<li><a _href="admin-role.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>角色管理</cite>
						</a></li>
						<li><a _href="admin-cate.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>权限分类</cite>
						</a></li>
						<li><a _href="admin-rule.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>权限管理</cite>
						</a></li>
					</ul></li>
					<li><a href="javascript:;"> <i class="iconfont">&#xe6ba;</i>
						<cite>合作公司</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a
							_href="../info/cri_list_limit?admin_university=${adminUniversity}&isExpired=1">
								<i class="iconfont">&#xe6a7;</i> <cite>现有伙伴</cite>
						</a></li>
					</ul></li>
				<li><a href="javascript:;"> <i class="iconfont">&#xe73f;</i>
						<cite>校招管理</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a
							_href="../info/cri_list_limit?admin_university=${adminUniversity}&isExpired=1">
								<i class="iconfont">&#xe6a7;</i> <cite>未举行</cite>
						</a></li>
						<li><a
							_href="../info/cri_list_limit?admin_university=${adminUniversity}&isExpired=0">
								<i class="iconfont">&#xe6a7;</i> <cite>已过期</cite>
						</a></li>
					</ul></li>
				<li><a href="javascript:;"> <i class="iconfont">&#xe6ce;</i>
						<cite>系统统计</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a _href="echarts1.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>拆线图</cite>
						</a></li>
						<li><a _href="echarts2.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>柱状图</cite>
						</a></li>
						<li><a _href="echarts3.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>地图</cite>
						</a></li>
						<li><a _href="echarts4.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>饼图</cite>
						</a></li>
						<li><a _href="echarts5.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>雷达图</cite>
						</a></li>
						<li><a _href="echarts6.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>k线图</cite>
						</a></li>
						<li><a _href="echarts7.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>热力图</cite>
						</a></li>
						<li><a _href="echarts8.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>仪表图</cite>
						</a></li>
					</ul></li>
				<li><a href="javascript:;"> <i class="iconfont">&#xe82a;</i>
						<cite>资质审核</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a
							_href="">
								<i class="iconfont">&#xe6a7;</i> <cite>公司审核</cite>
						</a></li>
						<li><a
							_href="">
								<i class="iconfont">&#xe6a7;</i> <cite>校招审核</cite>
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-unselect layui-form-select layui-form-selected"
				id="tab_right">
				<dl>
					<dd data-type="this">关闭当前</dd>
					<dd data-type="other">关闭其它</dd>
					<dd data-type="all">关闭全部</dd>
				</dl>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='toConsole' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
			<div id="tab_show"></div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="copyright" style="text-align:center;">CopyRight @2019 a1bum.top</div>
	</div>
</body>
</html>