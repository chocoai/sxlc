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
<title>产品后台首页</title>
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
				<jsp:param value="001" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="container add_type_contianer">
					<div class="w-content ishow">
						<fieldset class="operateStatistics">
							<legend>运营项目统计</legend>
							<table class="infoStatistics">
								<tr class="col-md-6">
									<td class="tt"><label>未处理意向借款申请：</label></td>
									<td class="con">
										<span id="notDeal"></span>笔
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>审核中借款：</label></td>
									<td class="con">
										<span id="checking"></span>笔
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>融资中借款：</label></td>
									<td class="con">
										<span id="investing"></span>笔
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>待放款借款：</label></td>
									<td class="con">
										<span id="willhold"></span>笔
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>还款中借款项目：</label></td>
									<td class="con">
										<span id="replaying"></span>笔
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>逾期未还借款：</label></td>
									<td class="con">
										<span id="overReplay"></span>笔
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>已结清借款：</label></td>
									<td class="con">
										<span id="Settled"></span>笔
									</td>
								</tr>
							</table>
						</fieldset>
						<fieldset class="operateStatistics">
							<legend>运营数据统计</legend>
							<div class="registerMemberNum"><!-- 最近30天注册会员个数 -->
								<div class="midTitle">最近30天注册会员数量</div>
   								<div class="chartBox" id="chartBox1">
   									<script type="text/javascript">
   									var dateListOfNum = [];
   									var countMemberList = [];
							    	// 路径配置
							        require.config({
							            paths: {
							                echarts: '<%=basePath%>plugs/dist'
							            }
							        });
							        
							    	//
							        var VIPListOfNum = [1, 3, 5, 0,	9,
										                21, 23, 25, 27,	29,	
										                41, 43, 45, 0,	49,	
										                 67,	69,
										             	81, 83, 85, 87,	89,
										             	101, 103, 105, 107,	109];
									$(function (){
										$.ajax({
											type : 'post',
											url : appPath + "/index/vip.do",
											success : function (msg) {
												$.each(msg, function(i, item) {
													dateListOfNum[i] = ""+num2DateMD(item.timeStempD)+"";
													countMemberList[i] = ""+item.countMember+"";
												});
												require(
											            [
											                'echarts',
											                //'echarts/theme/roma',
											                //'echarts/chart/pie', //饼图
											                'echarts/chart/line',//走势图
											                'echarts/chart/bar'//柱状图
											            ],
													function (ec,theme) {
									                // 基于准备好的dom，初始化echarts图表
									                 var myChart1 = ec.init(document.getElementById('chartBox1'),theme);
									                 var option1 = {
														    tooltip : {
														        trigger: 'axis',
														    },
														    grid:{//重定位
									 					    	x:50,
									 					    	y:30,
									 					    	x2:20,
									 					    	y2:40,
									 					    },
														    toolbox: {/* 保存之类的小工具 */
														        show : true,
														        feature : {
														            restore : {show: true},/* 恢复 */
														            saveAsImage : {show: true}/* 保存 */
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
														        data: dateListOfNum
														    },
														    yAxis: {
														        type: 'value',
														        axisLine:{lineStyle:{
									 					            			color:'#dedede',
														            			width:1,
									 					            		}},
									 					        axisLabel: {
									 					            formatter: '{value}人',
									 					        	textStyle:{color:'#787878'},
									 					        },
													  		},
														    series : [
														        {
														            name:'注册会员个数',
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
														            data:countMemberList
														        }
														    ]
														}
								                  	//   为echarts对象加载数据 
															myChart1.setOption(option1);
									                 });
											}
										});
									});
							    	
									// 日起格式：06-02
									function num2DateMD(time) {
										var date = new Date(time);
										M = (date.getMonth() + 1 < 10 ? + (date.getMonth() + 1) : date
												.getMonth() + 1)
												+ '-';
										D = (date.getDate() < 10 ? + (date.getDate()) : date.getDate());
										return (M + D);
									}
							         
							        /* var dateListOfNum = ['5-1','5-2','5-3','5-4','5-5',
											        	   '5-6','5-7','5-8','5-9','5-10',
											        	   '5-11','5-12','5-13','5-14','5-15',
											        	   '5-16','5-17','5-18','5-19','5-20',
											        	   '5-24','5-25',
											        	   '5-26','5-27','5-28','5-29','5-30']; */
							        // 使用
							        
							       </script>
								</div>
   							</div>
   						</fieldset>
   						<fieldset>	
   							<legend></legend>
   							<div class="newMember"><!-- 新增会员 -->
								<div class="midTitle">新增会员</div>
   								<div class="chartBox" id="chartBox2">
	   								<script type="text/javascript">
	   									var dayList = [];
	   									var weekList = [];
	   									var monthList = [];
	   									// 路径配置
								        require.config({
								            paths: {
								                echarts: '<%=basePath%>plugs/dist'
								            }
								        });
								        
	   									$(function () {
	   										$.ajax({
	   											type : 'post',
	   											url : appPath + "/index/day.do",
	   											success : function (msg) {
	   												dayList[0] = msg.countMember;
	   												dayList[1] = msg.countInvestMember;
	   												dayList[2] = msg.countLoanMember;
	   												
	   											}
	   										});
	   										
	   										$.ajax({
	   											type : 'post',
	   											url : appPath + "/index/week.do",
	   											success : function (msg) {
	   												weekList[0] = msg.countMember;
	   												weekList[1] = msg.countInvestMember;
	   												weekList[2] = msg.countLoanMember;
	   												
	   											}
	   										});
	   										
	   										$.ajax({
	   											type : 'post',
	   											url : appPath + "/index/month.do",
	   											success : function (msg) {
	   												monthList[0] = msg.countMember;
	   												monthList[1] = msg.countInvestMember;
	   												monthList[2] = msg.countLoanMember;
	   												
	   											}
	   										});
	   									 // 使用
									        require(
									            [
									                'echarts',
									                //'echarts/theme/roma',
									                //'echarts/chart/pie', //饼图
									                'echarts/chart/line',//走势图
									                'echarts/chart/bar'//柱状图
									            ],
											 function (ec,theme) {	
											 var myChart2 = ec.init(document.getElementById('chartBox2'),theme);
											 var option2 = {
											    tooltip : {
											        trigger: 'axis'
											    },
											    legend: {
											        data:['今日','本周','本月']
											    },
											    calculable : true,
											    xAxis : [
											        {
											            type : 'category',
											            data : ['新增会员','新增投资会员','新增借款会员']
											        }
											    ],
											    yAxis : [
											        {
											            type : 'value'
											        }
											    ],
											    series : [
											        {
											            name:'今日',
											            type:'bar',
											            data:dayList,
											        },
											        {
											            name:'本周',
											            type:'bar',
											            data:weekList,
											        },
											        {
											            name:'本月',
											            type:'bar',
											            data:monthList,
											        }
											    ]
											};
											 //   为echarts对象加载数据 
													myChart2.setOption(option2);
							                 });
	   									});
								       
	   								</script>
   								</div>
   							</div>
   						</fieldset>
   						<fieldset>	
   							<legend></legend>
   							<div class="midTitle">累计交易</div>
   							<table>
								<tr class="col-md-6">
									<td class="tt"><label>累计成交总额：</label></td>
									<td class="con">
										<span id="cumulative">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>累计成功借款项目数：</label></td>
									<td class="con">
										<span id="successLoan">222</span>笔
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>累计待还本金：</label></td>
									<td class="con">
										<span id="notRepayPrincipals">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>累计待还总额：</label></td>
									<td class="con">
										<span id="notRepayTotals">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>累计成功还款（结清）项目数：</label></td>
									<td class="con">
										<span id="successRepay">222</span>笔
									</td>
								</tr>
							</table>
						</fieldset>
						<fieldset>	
   							<legend></legend>
   							<div class="midTitle">新增投资</div>
   							<table>
								<tr class="col-md-6">
									<td class="tt"><label>本日新增投资：</label></td>
									<td class="con">
										<span id="sumInvestDs">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>本周新增投资：</label></td>
									<td class="con">
										<span id="sumInvestWs">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>本月新增投资：</label></td>
									<td class="con">
										<span id="sumInvestMs">222</span>元
									</td>
								</tr>
							</table>
						</fieldset>	
						<fieldset>
							<legend></legend>
							<div class="registerMemberNum"><!-- 最近30前台访问量 -->
								<div class="midTitle">最近30天前台访问量</div>
   								<div class="chartBox" id="chartBox3">
   									<script type="text/javascript">
   									var dataList = [];
   									var visitList = [];
   									// 日起格式：06-02
									function num2DateMD(time) {
										var date = new Date(time);
										M = (date.getMonth() + 1 < 10 ? + (date.getMonth() + 1) : date
												.getMonth() + 1)
												+ '-';
										D = (date.getDate() < 10 ? + (date.getDate()) : date.getDate());
										return (M + D);
									}
							    	// 路径配置
							        require.config({
							            paths: {
							                echarts: '<%=basePath%>plugs/dist'
							            }
							        });
							        
							    	$(function () {
							    		$.ajax({
							    			type : 'post',
							    			url : appPath + "/index/visit.do",
							    			success : function (msg) {
							    				$.each(msg, function(i, item) {
													dataList[i] = ""+num2DateMD(item.timeStempD)+"";
													visitList[i] = ""+item.countMember+"";
												});
							    				// 使用
										        require(
										            [
										                'echarts',
										                //'echarts/theme/roma',
										                //'echarts/chart/pie', //饼图
										                'echarts/chart/line',//走势图
										                'echarts/chart/bar'//柱状图
										            ],
												 function (ec,theme) {
								                // 基于准备好的dom，初始化echarts图表
								                 var myChart3 = ec.init(document.getElementById('chartBox3'),theme);
								                 var option3 = {
													    tooltip : {
													        trigger: 'axis'
													    },
													    grid:{//重定位
								 					    	x:50,
								 					    	y:30,
								 					    	x2:20,
								 					    	y2:40,
								 					    },
													    toolbox: {/* 保存之类的小工具 */
													        show : true,
													        feature : {
													            restore : {show: true},/* 恢复 */
													            saveAsImage : {show: true}/* 保存 */
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
													        data: dataList
													    },
													    yAxis: {
													        type: 'value',
													        axisLine:{lineStyle:{
								 					            			color:'#dedede',
													            			width:1,
								 					            		}},
								 					        axisLabel: {
								 					            formatter: '{value}次',
								 					        	textStyle:{color:'#787878'},
								 					        },
												  		},
													    series : [
													        {
													            name:'当日访问量',
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
													            data:visitList
													        }
													    ]
													};
							                  	//   为echarts对象加载数据 
														myChart3.setOption(option3);
								                 });
							    			}
							    		});
							    	});
							        
							       </script>
								</div>
   							</div>
						</fieldset>
						<fieldset>
							<legend>平台收益统计</legend>
							<table>
								<tr class="col-md-6">
									<td class="tt"><label>收取借款管理费总额：</label></td>
									<td class="con">
										<span id="rMngFeeAmounts">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>收取投资管理费总额：</label></td>
									<td class="con">
										<span id="investMngFeeAmounts">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>收取风险保证金总额：</label></td>
									<td class="con">
										<span id="rRiskMarginFees">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>退还风险保证金总额：</label></td>
									<td class="con">
										<span id="oRiskMarginFees">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>扣除风险保证金总额：</label></td>
									<td class="con">
										<span id="rRiskMarginFees">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>会员支付充值费用总额：</label></td>
									<td class="con">
										<span id="rechargeFees">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>平台代付充值费用总额：</label></td>
									<td class="con">
										<span id="pRechargeFees">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>会员支付提现手续费总额：</label></td>
									<td class="con">
										<span id="withdrawalFees">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>平台代付提现费用总额：</label></td>
									<td class="con">
										<span id="pwidthdrawFees">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>平台收取提现手续费总额：</label></td>
									<td class="con">
										<span id="pgetwidthdrawFees">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>平台收取债权转让手续费总额：</label></td>
									<td class="con">
										<span id="rTransFeeAmounts">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>收取逾期罚金总额：</label></td>
									<td class="con">
										<span id="roverFeeAmounts">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>平台代偿总金额：</label></td>
									<td class="con">
										<span id="rcompenAmounts">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>平台代偿回款总金额：</label></td>
									<td class="con">
										<span id="rcompenRepayAmounts">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>理财顾问提奖总额：</label></td>
									<td class="con">
										<span id="financialAdvisorAwards">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>推荐达人提奖总额：</label></td>
									<td class="con">
										<span id="inviteMasterAwards">222</span>元
									</td>
								</tr>
							</table>
						</fieldset>
						<fieldset>
							<legend>财务统计</legend>
							<div class="midTitle">充值统计</div>
							<div class="chartBox" id="chartBox4">
   								<script type="text/javascript">
   								var rechargeList = [];
   								var spRechargeFeeList = [];
						    	// 路径配置
						        require.config({
						            paths: {
						                echarts: '<%=basePath%>plugs/dist'
						            }
						        });
						        $(function() {
						        	$.ajax({
						        		type : 'post',
						        		url : appPath + "/index/recharge.do",
						        		success : function (msg) {
						        			$.each(msg, function(i, item) {
						        				rechargeList[i] = ""+num2DateMD(item.timeStempD)+"";
						        				spRechargeFeeList[i] = ""+item.pRechargeFee+"";
											});
						        			
						        			// 使用
									        require(
									            [
									                'echarts',
									                //'echarts/theme/roma',
									                //'echarts/chart/pie', //饼图
									                'echarts/chart/line',//走势图
									                'echarts/chart/bar'//柱状图
									            ],
											 function (ec,theme) {
							                // 基于准备好的dom，初始化echarts图表
							                 var myChart4 = ec.init(document.getElementById('chartBox4'),theme);
							                 var option4 = {
												    tooltip : {
												        trigger: 'axis'
												    },
												    grid:{//重定位
							 					    	x:50,
							 					    	y:30,
							 					    	x2:20,
							 					    	y2:40,
								 					},
												    toolbox: {/* 保存之类的小工具 */
												        show : true,
												        feature : {
												            restore : {show: true},/* 恢复 */
												            saveAsImage : {show: true}/* 保存 */
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
												        data: rechargeList
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
												            name:'充值数额',
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
												            data:spRechargeFeeList
												        }
												    ]
												};
						                  	//   为echarts对象加载数据 
													myChart4.setOption(option4);
							                 });
						        		}
						        	});
						        });
						        
						       </script>
							</div>
						</fieldset>
						<fieldset>	
							<legend></legend>
							<div class="midTitle">提现统计</div>
							<div class="chartBox" id="chartBox5">
   								<script type="text/javascript">
   								var	withdrawList = [];
   								var pwidthdrawFeeList = [];
						    	// 路径配置
						        require.config({
						            paths: {
						                echarts: '<%=basePath%>plugs/dist'
						            }
						        });
						    	
						    	$(function () {
						    		$.ajax({
						    			type : 'post',
						    			url : appPath + "/index/withdrawal.do",
						    			success : function (msg) {
						    				$.each(msg, function(i, item) {
						    					withdrawList[i] = ""+num2DateMD(item.timeStempD)+"";
						    					pwidthdrawFeeList[i] = ""+item.pwidthdrawFee+"";
											});
						    				// 使用
									        require(
									            [
									                'echarts',
									                //'echarts/theme/roma',
									                //'echarts/chart/pie', //饼图
									                'echarts/chart/line',//走势图
									                'echarts/chart/bar'//柱状图
									            ],
											 function (ec,theme) {
							                // 基于准备好的dom，初始化echarts图表
							                 var myChart5 = ec.init(document.getElementById('chartBox5'),theme);
							                 var option5 = {
												    tooltip : {
												        trigger: 'axis'
												    },
												    grid:{//重定位
							 					    	x:50,
							 					    	y:30,
							 					    	x2:20,
							 					    	y2:40,
								 					},
												    toolbox: {/* 保存之类的小工具 */
												        show : true,
												        feature : {
												            restore : {show: true},/* 恢复 */
												            saveAsImage : {show: true}/* 保存 */
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
												        data: withdrawList
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
												            name:'提现数额',
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
												            data:pwidthdrawFeeList
												        }
												    ]
												};
						                  	//   为echarts对象加载数据 
													myChart5.setOption(option5);
							                 });
						    			}
						    		});
						    	});
						        
						        
						       </script>
							</div>
						</fieldset>
						<fieldset>	
							<legend></legend>
							<div class="midTitle">平台收支</div>
							<table>
								<tr class="col-md-6">
									<td class="tt"><label>红包发放总额：</label></td>
									<td class="con">
										<span id="stotalRedpackets">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>活动红包总额：</label></td>
									<td class="con">
										<span id="saffairAccount">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>红包领取总额：</label></td>
									<td class="con">
										<span id="sgetTotalRedpackets">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>红包使用总额：</label></td>
									<td class="con">
										<span id="suseRedpackets">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>红包未使用总额：</label></td>
									<td class="con">
										<span id="snotuseRedpackets">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>红包已过期总额：</label></td>
									<td class="con">
										<span id="soverRedpackets">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>代金券兑换总额：</label></td>
									<td class="con">
										<span id="stotalVouchers">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>代金券使用总额：</label></td>
									<td class="con">
										<span id="suseVouchers">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>代金券未使用总额：</label></td>
									<td class="con">
										<span id="stotalVouchers">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>累计返现总额：</label></td>
									<td class="con">
										<span id="spayWithdrawal">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>奖励标总数：</label></td>
									<td class="con">
										<span>222</span>个
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>累计奖励总额：</label></td>
									<td class="con">
										<span id="spayAward">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>平台代偿总金额：</label></td>
									<td class="con">
										<span id="">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>平台代偿回款总金额：</label></td>
									<td class="con">
										<span id="srcompenRepayAmount">222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>理财顾问提奖总额：</label></td>
									<td class="con">
										<span>222</span>元
									</td>
								</tr>
								<tr class="col-md-6">
									<td class="tt"><label>推荐达人提奖总额：</label></td>
									<td class="con">
										<span id="sfinancialAdvisorAward">222</span>元
									</td>
								</tr>
							</table>
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
	<script type="text/javascript" src="js/index/index.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>