<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<base href="<%=basePath%>">
<title>产品后台首页——运营相关</title>
<!-- 公用meta -->
<jsp:include page="../common/top-meta.jsp"></jsp:include>
<!-- 私用meta -->
<!-- 公用css -->
<jsp:include page="../common/cm-css.jsp"></jsp:include>
<script src="plugs/dist/echarts.js"></script>
<!-- 私用css -->
<link rel="stylesheet" href="css/index.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="0" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-index.jsp">
				<jsp:param value="002" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="container add_type_contianer">
					<div class="w-content ishow">
						<fieldset class="operateStatistics">
							<legend>运营数据统计</legend>
							<div class="registerMemberNum"><!-- 最近30天注册会员个数 -->
   								<div class="chartBox1" id="chartBox1">
   								<script type="text/javascript">
							    	// 路径配置
							        require.config({
							            paths: {
							                echarts: '<%=basePath%>plugs/dist'
							            }
							        });
							        
							        // 使用
							        require(
							            [
							                'echarts',
							                //'echarts/theme/roma',
							                //'echarts/chart/pie', //饼图
							                //'echarts/chart/line',//走势图
							                'echarts/chart/bar'
							            ],
									 function (ec,theme) {
					                // 基于准备好的dom，初始化echarts图表
					                 var myChart1 = ec.init(document.getElementById('chartBox1'),theme);
					                 var option1 = {
										    tooltip : {
										        trigger: 'axis'
										    },
										    grid:{
					 					    	x:50,
					 					    	y:20,
					 					    	x2:20,
					 					    	y2:40,
					 					    },
										    toolbox: {
										        show : true,
										        feature : {
										            dataZoom: {},
					 					            dataView: {readOnly: false},
					 					            magicType: {type: ['line', 'bar']},
										            restore: {},
										            saveAsImage: {}
										        }
										    },
										    calculable : true,
										    xAxis:  {
					 					        type: 'category',
					 					        axisLine:{lineStyle:{
					 					            			color:'#dedede',
										            			width:1,
					 					            		}},
					 					        axisLabel:{
					 					        	textStyle:{color:'#787878'},
					 					        },
										        boundaryGap: false,
										        data: ['5-1','5-2','5-3','5-4','5-5','5-6','5-7','5-8','5-9','5-10','5-11','5-12',
										        	   '5-13','5-14','5-15','5-16','5-17','5-18','5-19','5-20','5-21','5-22','5-23','5-24','5-25',
										        	   '5-26','5-27','5-28','5-29','5-30',
										        	  ]
										    },
										    yAxis: {
										        type: 'value',
										        axisLine:{lineStyle:{
					 					            			color:'#dedede',
										            			width:1,
					 					            		}},
					 					        axisLabel: {
					 					            formatter: '{value}元',
					 					        	textStyle:{color:'#787878'},
					 					        },
									  		},
										    series : [
										        {
										            name:'回款',
										            type:'line',
										            symbol:'emptyCircle',
										            itemStyle: {
										                normal: {
										                    lineStyle: {            // 系列级个性化折线样式，横向渐变描边
										                        width: 1,
										                        color:'#30adff',
										                        shadowColor : 'rgba(0,0,0,0.5)',
										                        shadowBlur: 10,
										                        shadowOffsetX: 8,
										                        shadowOffsetY: 8
										                    }
										                },
										                emphasis : {
										                    label : {show: true}
										                }
										            },
										            data:[
										                620, 732, 791, 
										                890, 930, 820,
										                620, 732, 791, 
										                890, 930, 820,
										            ]
										        }
										    ]
										};
				                  	//   为echarts对象加载数据 
											myChart1.setOption(option1);
					                 });
							       </script>
								</div>
   							</div>
						</fieldset>
					</div>
				</div>
			</div>

			<!-- 尾部 -->
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>