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
	src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script type="text/javascript"
	src="/WXMiniProgram/static/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/WXMiniProgram/static/js/xadmin.js"></script>
</head>
<body>
	<div class="x-body">
		<table class="layui-table x-admin" lay-filter="info_table"
			id="info_table">
		</table>
		<script type="text/html" id="toolbarTable">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-danger layui-icon" lay-event="getCheckData" style="font-size:12px">批量删除 &#xe640;</button>
    <button class="layui-btn layui-icon" lay-event="getCheckLength" style="font-size:12px">添加 &#xe608;</button>
  </div>
	</script>
		<script type="text/html" id="toolbarRow">
  <a class="layui-btn layui-icon" lay-event="edit">编辑 &#xe642;</a>
  <a class="layui-btn layui-btn-danger layui-icon" lay-event="del">删除 &#xe640;</a>
	</script>
	</div>
	<script>
	layui.use('table', function() {
		var table = layui.table;
		var isExpired = '<%=request.getAttribute("isExpired")%>';
		table.render({
			elem : '#info_table',
			url : '/WXMiniProgram/info/cri_list_expired?isExpired=' + isExpired,
			page : true,
			limit : 15,
			limits : [ 15, 30, 50, 100 ],
			toolbar : '#toolbarTable',//表级工具栏
			// 写解析接口
			parseData : function(res) {
				return {
					"code" : res.code,
					"count" : res.data.total,
					"data" : res.data.list
				};
			},
			// 写表头
			cols : [ [ {
				type : 'checkbox',
				align : 'center',
				fixed : 'left'
			}, {
				field : 'id',
				align : 'center',
				width : 100,
				title : '宣讲编号'
			}, {
				field : 'company_name',
				align : 'center',
				title : '公司名称'
			}, {
				field : 'hold_date',
				align : 'center',
				width : 100,
				title : '举办日期',
			}, {
				field : 'start_time',
				align : 'center',
				width : 100,
				title : '开始时间'
			}, {
				field : 'university_short_name',
				align : 'center',
				width : 100,
				title : '学校简称'
			}, {
				field : 'university_name',
				align : 'center',
				title : '学校名称'
			}, {
				field : 'logo_url',
				align : 'center',
				title : '学校logo'
			}, {
				field : 'locations',
				align : 'center',
				title : '具体地址'
			}, {
				field : 'hot',
				align : 'center',
				width : 80,
				title : '点击量',
			}, {
				title : '行级工具栏',
				fixed : 'right',
				align : 'center',
				toolbar : '#toolbarRow'
			} ] ]
		})
		//列工具栏事件
		table.on('toolbar(info_table)', function(obj) {
			var checkStatus = table.checkStatus(obj.config.id);
			switch (obj.event) {
			case 'getCheckData':
				var datas = checkStatus.data;
				var list = [];
				for(var data of datas){
					list.push(data.id);
				}
				layer.confirm('真的删除编号为 ' + list + ' 的数据吗', function() {
					del(list);
					layer.close(index);
				});
				break;
			case 'getCheckLength':
				x_admin_show("添加",'/WXMiniProgram/info/cri_add', 700,820);
				break;
			};
		});
		//监听行工具事件
		table.on('tool(info_table)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
			var data = obj.data //获得当前行数据
			, layEvent = obj.event; //获得 lay-event 对应的值
			if (layEvent === 'del') {
				var list = [];
				list.push(data.id);
				layer.confirm('真的删除编号为 ' + data.id + ' 的数据吗', function(index) {
					//向服务端发送删除指令
					del(list);
					layer.close(index);
				});
			} else if (layEvent === 'edit') {
				var url = '/WXMiniProgram/info/cri_edit?id=' + data.id;
				x_admin_show("编辑", url, 650, 750);
			}
		});
	});
	function del(list){
		$.ajax({
			url : '/WXMiniProgram/info/delete',
				data : {id: list},
				success : function(res) {
					var msg = (res.msg == "true" ? "删除成功"
							: "删除失败");
					var icon = (res.msg == "true" ? 1 : 0);
					layer.msg(msg, {
						icon : icon,
						time : 1000
					});
					setTimeout(function(){parent.location.reload()}, 1000);
				},
				fail : function(res) {
					layer.msg("请求接口失败", {
						icon : 0,
						time : 1000
					});
				},
			});
	}
	</script>
</body>
</html>