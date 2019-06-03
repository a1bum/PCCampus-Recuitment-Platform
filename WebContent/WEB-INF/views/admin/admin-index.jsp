<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CRI--后台管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet"
	href="/WXMiniProgram/static/lib/layui/css/layui.css">
<link rel="stylesheet" href="/WXMiniProgram/static/css/admin.css"">
</head>
<body class="layui-layout-body">

	<div id="LAY_app">
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<!-- 头部区域 -->
				<ul class="layui-nav layui-layout-left">
					<li class="layui-nav-item layadmin-flexible" lay-unselect><a
						href="javascript:;" layadmin-event="flexible" title="侧边伸缩"> <i
							class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="https://a1bum.top/" target="_blank" title="前台"> <i
							class="layui-icon layui-icon-website"></i>
					</a></li>
					<li class="layui-nav-item" lay-unselect><a href="javascript:;"
						layadmin-event="refresh" title="刷新"> <i
							class="layui-icon layui-icon-refresh-3"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><input
						type="text" placeholder="搜索..." autocomplete="off"
						class="layui-input layui-input-search" layadmin-event="serach"
						lay-action="template/search.html?keywords="></li>
				</ul>
				<ul class="layui-nav layui-layout-right"
					lay-filter="layadmin-layout-right">

					<li class="layui-nav-item" lay-unselect><a
						lay-href="app/message/index.html" layadmin-event="message"
						lay-text="消息中心"> <i class="layui-icon layui-icon-notice"></i>

							<!-- 如果有新消息，则显示小圆点 --> <span class="layui-badge-dot"></span>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="note"> <i
							class="layui-icon layui-icon-note"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="fullscreen"> <i
							class="layui-icon layui-icon-screen-full"></i>
					</a></li>
					<li class="layui-nav-item" lay-unselect><a href="javascript:;">
							<cite>root</cite>
					</a>
						<dl class="layui-nav-child">
							<dd>
								<a lay-href="set/user/info.html">基本资料</a>
							</dd>
							<dd>
								<a lay-href="set/user/password.html">修改密码</a>
							</dd>
							<hr>
							<dd layadmin-event="logout" style="text-align: center;">
								<a>退出</a>
							</dd>
						</dl></li>

					<li class="layui-nav-item layui-hide-xs" lay-unselect><a
						href="javascript:;" layadmin-event="about"><i
							class="layui-icon layui-icon-more-vertical"></i></a></li>
					<li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm"
						lay-unselect><a href="javascript:;" layadmin-event="more"><i
							class="layui-icon layui-icon-more-vertical"></i></a></li>
				</ul>
			</div>

			<!-- 侧边菜单 -->
			<div class="layui-side layui-side-menu">
				<div class="layui-side-scroll">
					<div class="layui-logo">
						<span><a
							href="https://github.com/a1bum/PCCampus-Recuitment-Platform/blob/master/README.MD">CRI-Campus</a></span>
					</div>

					<ul class="layui-nav layui-nav-tree" lay-shrink="all"
						id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
						<li data-name="console" class="layui-nav-item layui-this"><a
							href="javascript:;" lay-tips="校招信息" lay-direction="2"> <i
								class="layui-icon layui-icon-console"></i> <cite>控制台</cite>
						</a></li>
						<li data-name="home" class="layui-nav-item"><a
							href="javascript:;" lay-tips="校招信息" lay-direction="2"> <i
								class="layui-icon layui-icon-home"></i> <cite>校招信息</cite>
						</a>
							<dl class="layui-nav-child">
								<dd>
									<a id="isHolds"
										onclick="tabAdd('已举行','/WXMiniProgram/info/cri_list_limit?isExpired=0','isHolds')">已举行</a>
								</dd>
								<dd>
									<a
										onclick="tabAdd('未举行','/WXMiniProgram/info/cri_list_limit?isExpired=1', 'isNHolds')">未举行</a>
								</dd>
							</dl></li>
						<li data-name="component" class="layui-nav-item"><a
							href="javascript:;" lay-tips="组件" lay-direction="2"> <i
								class="layui-icon layui-icon-component"></i> <cite>公司信息</cite>
						</a>
							<dl class="layui-nav-child">
								<dd>
									<a
										onclick="tabAdd('资质审核','/WXMiniProgram/company/toIndex', 'company-list')">资质审核</a>
								</dd>
								<dd>
									<a
										onclick="tabAdd('宣讲会申请','/WXMiniProgram/company/toIndex', 'company-list')">宣讲会申请</a>
								</dd>
								<dd>
									<a
										onclick="tabAdd('合作伙伴','/WXMiniProgram/company/toIndex', 'company-list')">合作伙伴</a>
								</dd>
							</dl>
							</dl></li>
						<li data-name="template" class="layui-nav-item"><a
							href="javascript:;" lay-tips="页面" lay-direction="2"> <i
								class="layui-icon layui-icon-chart-screen"
								onclick="tabAdd('Kibana监控','/WXMiniProgram/nginx/monitor', 'kibana')"></i>
								<cite>监控面板</cite>
						</a></li>
						<li data-name="user" class="layui-nav-item"><a
							href="javascript:;" lay-tips="用户" lay-direction="2"> <i
								class="layui-icon layui-icon-user"></i> <cite>用户信息</cite>
						</a>
							<dl class="layui-nav-child">
								<dd>
									<a lay-href="user/user/list.html">网站用户</a>
								</dd>
								<dd>
									<a lay-href="user/administrators/list.html">后台管理员</a>
								</dd>
								<dd>
									<a lay-href="user/administrators/role.html">角色管理</a>
								</dd>
							</dl></li>
						<li data-name="get" class="layui-nav-item"><a
							href="https://github.com/a1bum/WXCampus-Recruitment-Platform/blob/master/README.md"><i
								class="layui-icon layui-icon-auz"></i> <cite>小程序</cite></a>
							</a></li>
						<li data-name="set" class="layui-nav-item"><a
							href="javascript:;" lay-tips="设置" lay-direction="2"> <i
								class="layui-icon layui-icon-set"></i> <cite>设置</cite>
						</a>
							<dl class="layui-nav-child">
								<dd class="layui-nav-itemed">
									<a href="javascript:;">系统设置</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="set/system/website.html">网站设置</a>
										</dd>
										<dd>
											<a lay-href="set/system/email.html">邮件服务</a>
										</dd>
									</dl>
								</dd>
								<dd class="layui-nav-itemed">
									<a href="javascript:;">我的设置</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="set/user/info.html">基本资料</a>
										</dd>
										<dd>
											<a
												onclick="tabAdd('Kibana监控','/WXMiniProgram/admin/reset_pass', 'reset')">修改密码</a>
										</dd>
									</dl>
								</dd>
							</dl></li>
					</ul>
				</div>
			</div>

			<!-- 页面标签 -->
			<div class="layadmin-pagetabs" id="LAY_app_tabs">
				<div class="layui-icon layadmin-tabs-control layui-icon-prev"
					layadmin-event="leftPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-next"
					layadmin-event="rightPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-down">
					<ul class="layui-nav layadmin-tabs-select"
						lay-filter="layadmin-pagetabs-nav">
						<li class="layui-nav-item" lay-unselect><a
							href="javascript:;"></a>
							<dl class="layui-nav-child layui-anim-fadein">
								<dd>
									<a href="javascript:;" onclick="closeThisTabs()">关闭当前标签页</a>
								</dd>
								<dd>
									<a href="javascript:;" onclick="closeOtherTabs()">关闭其它标签页</a>
								</dd>
								<dd>
									<a href="javascript:;" onclick="closeAllTabs()">关闭全部标签页</a>
								</dd>
							</dl></li>
					</ul>
				</div>
				<div class="layui-tab" lay-unauto lay-allowClose="true"
					lay-filter="tabs">
					<ul class="layui-tab-title" id="LAY_app_tabsheader">
						<li lay-id="console" onClick="switchToConsole()"
							class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
					</ul>
				</div>
			</div>


			<!-- 主体内容 -->
			<div class="layui-body" id="LAY_app_body">
				<div class="layui-tab-item layui-show console">
					<iframe src="/WXMiniProgram/admin/toConsole" frameborder="0"
						class="layadmin-iframe"></iframe>
				</div>
			</div>
			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
	</div>
	<script src="/WXMiniProgram/static/lib/layui/layui.js"></script>
	<script src="/WXMiniProgram/static/js/xadmin.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
	<script>
		layui.use('element', function() {
			var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
			//监听导航点击
			element.on('nav(layadmin-system-side-menu)', function(elem) {
			});
		});
		function tabAdd(title, url, id) {
			layui.use('element',function() {
				var element = layui.element;
				if ($(".layui-tab-title li[lay-id=" + id + "]").length == 0) {
					content = '<iframe tab-id="'+id+'" frameborder="0" src="'+url+'" scrolling="yes" class="layadmin-iframe"></iframe>';
					//新增一个Tab项
					element.tabAdd('tabs',{
						title : '<i class="layui-icon layui-icon-note"></i>&ensp;'+ title,
						content : content,
						id : id
					})
					// 切换tab
					element.tabChange('tabs', id);
					// 模拟切换iframe
					$(".layui-show").addClass("old");
					$(".layui-show").after('<div class="layadmin-tabsbody-item layui-show">'
											+ content + '</div>');
					$(".old").removeClass("layui-show");
				}
			});
		};
		function switchToConsole() {
			$(".layui-show").addClass("old");
			$(".old").removeClass("layui-show");
			$(".console").addClass("layui-show");
		}
	</script>
</body>
</html>