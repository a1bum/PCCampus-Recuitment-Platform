layui.extend({
	echartsTheme : '/WXMiniProgram/static/js/extend/echartsTheme',
	echarts : '/WXMiniProgram/static/js/extend/echarts'
});
layui.use(['echarts', 'carousel'], function() {
	carousel = layui.carousel, device = layui.device, echarts = layui.echarts;
	// 浏览器统计图初始化变量
	var top1 = "Chrome", top1Value = 9052;
	var top2 = "Firefox", top2Value = 1610;
	var top3 = "IE 11.0", top3Value = 3200;
	var top4 = "Safari", top4Value = 535;
	var others = "其它浏览器", othersValue = 1700;
	// 尝试获取最新数据
	$.ajax({
		url : '/WXMiniProgram/login/broswer',
		async : false,
		success : function(res) {
			top1 = res.top1, top1Value = res.top1Value;
			top2 = res.top2, top2Value = res.top2Value;
			top3 = res.top3, top3Value = res.top3Value;
			top4 = res.top4, top4Value = res.top4Value;
			othersValue = res.othersValue;
		}
	});
	// 初始化变量
	var valueArr1 = [111, 222, 333, 444, 555, 666, 3333, 33333, 55555, 66666,
		33333, 3333, 6666, 11888, 26666, 38888, 56666, 42222,
		39999, 28888, 17777, 9666, 6555, 5555, 3333, 2222, 3111,
		6999, 5888, 2777, 1666, 999, 888, 777];
	var valueArr2 = [11, 22, 33, 44, 55, 66, 333, 3333, 5555, 12666, 3333, 333,
		666, 1188, 2666, 3888, 6666, 4222, 3999, 2888, 1777, 966,
		655, 555, 333, 222, 311, 699, 588, 277, 166, 99, 88, 77];
	var timeArr = ["06:00", "06:30", "07:00", "07:30", "08:00", "08:30",
		"09:00", "09:30", "10:00", "11:30", "12:00", "12:30",
		"13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
		"16:00", "16:30", "17:00", "17:30", "18:00", "18:30",
		"19:00", "19:30", "20:00", "20:30", "21:00", "21:30",
		"22:00", "22:30", "23:00", "23:30"];
	// 尝试获取流量统计情况 
	$.ajax({
		url: '/WXMiniProgram/login/traffic',
		async: false,
		success: function(res){
			timeArr=res.timeArr;
			valueArr1=res.valueArr1;
			valueArr2=res.valueArr2
		}
	})
	// 渲染轮播图
	$('.layadmin-carousel').each(function() {
		var othis = $(this);
		carousel.render({
					elem : this,
					width : '100%',
					arrow : 'none',
					interval : othis.data('interval'),
					autoplay : othis.data('autoplay') === true,
					trigger : (device.ios || device.android)
							? 'click'
							: 'hover',
					anim : othis.data('anim')
				});
	});
	// charts统计图表
	var echartsApp = [], options = [{
		title : {
			text : "近24小时平台流量变化（单位：kB）",
			x : "center",
			textStyle : {
				fontSize : 14
			}
		},
		tooltip : {
			trigger : "axis"
		},
		legend : {
			data : ["", ""]
		},
		xAxis : [{
			type : "category",
			boundaryGap : !1,
			data : timeArr
		}],
		yAxis : [{
					type : "value"
				}],
		series : [{
			name : "out",
			type : "line",
			smooth : !0,
			itemStyle : {
				normal : {
					areaStyle : {
						type : "default"
					}
				}
			},
			data : valueArr1
		}, {
			name : "in",
			type : "line",
			smooth : !0,
			itemStyle : {
				normal : {
					areaStyle : {
						type : "default"
					}
				}
			},
			data : valueArr2
		}]
	}, {
		title : {
			text : "访客浏览器分布（非微信小程序）",
			x : "center",
			textStyle : {
				fontSize : 14
			}
		},
		tooltip : {
			trigger : "item",
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			orient : "vertical",
			x : "left",
			data : [top1, top2, top3, top4, others]
		},
		series : [{
					name : "访问来源",
					type : "pie",
					radius : "55%",
					center : ["50%", "50%"],
					data : [{
								value : top1Value,
								name : top1
							}, {
								value : top2Value,
								name : top2
							}, {
								value : top3Value,
								name : top3
							}, {
								value : top4Value,
								name : top4
							}, {
								value : othersValue,
								name : others
							}]
				}]
	}, {
		title : {
			text : "最近一周新增的用户量",
			x : "center",
			textStyle : {
				fontSize : 14
			}
		},
		tooltip : {
			trigger : "axis",
			formatter : "{b}<br>新增用户：{c}"
		},
		xAxis : [{
			type : "category",
			data : ["11-07", "11-08", "11-09", "11-10", "11-11", "11-12",
					"11-13"]
		}],
		yAxis : [{
					type : "value"
				}],
		series : [{
					type : "line",
					data : [200, 300, 400, 610, 150, 270, 380]
				}]
	}], EelemDataView = $('#LAY-allanalysis-dataview').children('div'), renderDataView = function(
			index) {
		echartsApp[index] = echarts.init(EelemDataView[index],
				layui.echartsTheme);
		echartsApp[index].setOption(options[index]);
		window.onresize = echartsApp[index].resize;
	};
	renderDataView(0);// 渲染第一个div
	// 监听数据概览轮播
	var carouselIndex = 0;
	carousel.on('change(LAY-allanalysis-dataview)', function(obj) {
				renderDataView(carouselIndex = obj.index);
			});

});