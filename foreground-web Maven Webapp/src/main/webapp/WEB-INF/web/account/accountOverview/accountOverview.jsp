<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
    <title>账户总览</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/accountOverview/accountOverview.css">
	<%-- <jsp:include page="myPIChart.jsp"></jsp:include> --%>
	<script src="plugs/dist/echarts.js"></script>
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="/web/account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="/web/account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
   					<!-- 账户总资产部分开始 王延君  -->
   					<div class="accountOverview">
   						<div class="accountTotalAssets">
   							<div class="accountOverviewH">
	   							<div class="noPointer">账户总资产</div>
	   							<span>单位：元</span>
	   						</div>
	   						<div class="accountOverviewM">
	   							<div class="mainTitle">
	   								账户总资产<span class="moneyFormat">0</span>
	   								<label class="tipOrigin tipOrigin1"></label>
	   								<!-- <div class="tipLeft">
	   									<div class="contentLeft">可用余额+冻结金额+待收本金+待收收益-待还总额
	   										<img class="imgLeft" src="resource/img/account/accountOverview/wdzh_tip2.png">
	   									</div>
	   								</div> -->
	   							</div>
	   							<div class="secondaryTitle">
	   								<div class="totalRecharge">累计充值<span class="moneyFormat">1000</span></div>
	   								<div class="totalWithdrawals">累计提现<span class="moneyFormat">0</span></div>
	   								<div class="secondaryTitleOperate">
	   									<div class="btn rechargeBtn" onselectstart="return false" onclick="window.location='recharge.html';">充值</div>
		   								<div class="btn withdrawalsBtn" onselectstart="return false" onclick="window.location='cash.html';">提现</div>
		   								<div class="btn friendTransfer" onselectstart="return false" onclick="window.location='friendManagement.html';">好友转账</div>
	   								</div>
	   								<div class="secondaryTitleInfo">
	   									<span class="secondarySharp"></span>
	   									<div class="secondaryTitleInfoCont">
	   										<div class="secondaryTitleWord">
												<div class="secondaryTitleWordNum moneyFormat">0</div>
													<div>账户总资产</div>
											</div>
	   										<div class="chartBox1" id="chartBox1">
	   										<script type="text/javascript">
												/* var shuju = 200; */
										    	// 路径配置
										        require.config({
										            paths: {
										                echarts: '<%=basePath%>/plugs/dist'
										            }
										        });
										        
										        // 使用
										        require(
										            [
										                'echarts',
										                'echarts/theme/roma',
										                'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
										                'echarts/chart/line'
										            ],
												 function (ec,theme) {
								                // 基于准备好的dom，初始化echarts图表
								                //环形
								                 var myChart1 = ec.init(document.getElementById('chartBox1'),theme);
								                 	var option1 = {
												    series: [
												        {
												            name:'访问来源',
												            type:'pie',
												            radius: ['90%', '100%'],
												            itemStyle : {
											                normal : {
												                    label : {
												                        show : false
												                    },
												                    labelLine : {
												                        show : false
												                    }
												                },
												                emphasis : {
												                    label : {
												                        show : true,
												                        position : 'center',
												                        textStyle : {
												                            fontSize : '30',
												                            fontWeight : 'bold'
												                        }
												                    }
												                }
												            },
												            data:[
												                {value:20,itemStyle:{normal:{color:'#60b0ef'}}},
												                {value:20,itemStyle:{normal:{color:'#f4653b'}}},
												                {value:20,itemStyle:{normal:{color:'#8ac55b'}}},
												                {value:20,itemStyle:{normal:{color:'#c8c8c8'}}},
												                {value:20,itemStyle:{normal:{color:'#ffb43f'}}}
												            ]
												         }
												     ],
												    media: [ // 这里定义了 media query 的逐条规则。
												        {
												            query: {
												            	minWidth: 500,
															    maxHeight: 200,
															    minAspectRatio: 1
															},   // 这里写规则。
												            option: {       // 这里写此规则满足下的option。	
													            series: [                   // 两个饼图左右布局。
													                {
													                    radius: [20, '100%'],
													                    center: ['100%', '60%']
													                }
													            ]
												            }
												        }
												    ]
							                };
							                  //   为echarts对象加载数据 
  												myChart1.setOption(option1);
								                 });
								            </script>
											</div>
											<div class="secondaryTitleInfoMiddle">
												<div>
													<label class="circle blue"></label>可用余额
													<label class="whatever tipOrigin whatever1"></label>
													<span class="highLight moneyFormat">100</span>
												</div>
												<div>
													<label class="circle red"></label>冻结金额
													<label class="whatever tipOrigin whatever2"></label>
													<span class="moneyFormat">50</span>
												</div>
												<div>
													<label class="circle green"></label>待收本金
													<label class="whatever tipOrigin"></label>
													<span class="moneyFormat">20</span>
												</div>
												<div>
													<label class="circle orangeCircle"></label>待收收益
													<label class="whatever tipOrigin"></label>
													<span class="moneyFormat">50</span>
												</div>
												<div>
													<label class="circle grey"></label>待还总额
													<label class="whatever tipOrigin"></label>
													<span class="moneyFormat">10</span>
												</div>
											</div>
											<div class="secondaryTitleInfoRight">
												<div class="InfoRightM">
													<label class="vouchers"></label>代金券<span class="firstSpan">50</span>
												</div>
												<div class="InfoRightM">
													<label class="luckyMoney"></label>红包<span class="secondSpan moneyFormat">2000</span>
												</div>
												<div class="InfoRightM">
													<label class="intAble"></label>可用积分(分)<span class="thirdSpan">1200<a href="mallIndex.html">兑换</a></span>
												</div>
												<div class="InfoRightM">
													<label class="invitated"></label>已邀请好友(位)<span class="fourthSpan">2</span>
												</div>
											</div>
	   									</div>
	   								</div>
	   							</div>
	   						</div>
   						</div>
   						<!-- 账户总资产部分结束 -->
   						<!-- 回还款计划部分开始 -->
   						<div class="plan">
   							<div class="planH">
   								<div class="planHCont">
   									<div class="payment active">回款计划</div><label class="line"></label>
   									<div class="repayment">还款计划</div>
	   								<span class="more">更多></span>
   								</div>
	   						</div>
	   						<!-- 回款计划部分开始 -->
	   						<div class="planM">
	   							<span>单位：元</span>
	   							<div class="planMTitle">
	   								<div class="planMItem">
	   									<div class="planMItemWord">累计投资</div>
	   									<div class="planMItemNum moneyFormat">150</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">累计收益</div>
	   									<div class="planMItemNum highLight moneyFormat">100</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">投标奖励</div>
	   									<div class="planMItemNum moneyFormat">0</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">代金券抵扣</div>
	   									<div class="planMItemNum moneyFormat">0</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">红包抵扣</div>
	   									<div class="planMItemNum moneyFormat">0</div>
	   								</div>
	   							</div>
	   							<div class="planMList">
	   								<div class="chartBox4" id="chartBox4">
	   								<script type="text/javascript">
												/* var shuju = 200; */
										    	// 路径配置
										        require.config({
										            paths: {
										                echarts: '<%=basePath%>/plugs/dist'
										            }
										        });
										        
										        // 使用
										        require(
										            [
										                'echarts',
										                'echarts/theme/roma',
										                'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
										                'echarts/chart/line'
										            ],
												 function (ec,theme) {
								                // 基于准备好的dom，初始化echarts图表
								                //环形
								                 var myChart4 = ec.init(document.getElementById('chartBox4'),theme);
								                 var option4 = {
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
													        data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
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
  												myChart4.setOption(option4);
								                 });
								       </script>
									</div>
									<div class="time">2017年</div>
									<!-- <div class="planMListTip">
										<div class="listTip"><label class="circle grey"></label>有回款</div>
										<div class="listTip"><label class="circle blue"></label>无回款</div>
									</div> -->
	   							</div>
	   						</div>
	   						<!-- 回款计划部分结束 -->
	   						<!-- 还款计划部分开始-->
	   						<div class="planM planMSecond">
	   							<span>单位：元</span>
	   							<div class="planMTitle">
	   								<div class="planMItem">
	   									<div class="planMItemWord">累计借款</div>
	   									<div class="planMItemNum moneyFormat">150</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">待还本金</div>
	   									<div class="planMItemNum highLight moneyFormat">100</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">待还利息</div>
	   									<div class="planMItemNum moneyFormat">0</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">逾期未还</div>
	   									<div class="planMItemNum moneyFormat">150</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">最近应还日期</div>
	   									<div class="planMItemNum planMItemDetail">详情&gt;</div>
	   								</div>
	   							</div>
	   							<div class="planMList">
	   								<div class="chartBox2" id="chartBox2">
										<script type="text/javascript">
												/* var shuju = 200; */
										    	// 路径配置
										        require.config({
										            paths: {
										                echarts: '<%=basePath%>/plugs/dist'
										            }
										        });
										        
										        // 使用
										        require(
										            [
										                'echarts',
										                'echarts/theme/roma',
										                'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
										                'echarts/chart/line'
										            ],
												 function (ec,theme) {
								                // 基于准备好的dom，初始化echarts图表
								                //环形
								                 var myChart2 = ec.init(document.getElementById('chartBox2'),theme);
								                 var option2 = {
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
													        data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
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
													            name:'还款',
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
  												myChart2.setOption(option2);
								                 });
								       </script>
									</div>
									<div class="time">2017年</div>
									<!-- <div class="planMListTip">
										<div class="listTip"><label class="circle grey"></label>无还款</div>
										<div class="listTip"><label class="circle blue"></label>有还款</div>
									</div> -->
	   							</div>
	   						</div>
   						</div>
   						<!-- 还款计划部分结束 -->
   						<!-- 回还款计划部分结束 -->
   						<!-- 资金动态部分开始 -->
   						<div class="capitalDynamics">
   							<div class="capitalDynamicsH">
   								<div class="noPointer">资金动态</div>
   								<span class="more" onclick="window.location='incomeExpenditure.html'">更多&gt;</span>
   							</div>
   							<div class="capitalDynamicsM">
   								<ul>
   									<%for(int i = 0;i<3;i++){ %>
   									<li class="clearfix">
   										<div class="capitalDynamicsML">
   											<div class="DynamicsMLTop">2016-01<label class="circle grey"></label></div>
   											<div class="DynamicsMLBottom">02</div>
   										</div>
   										<div class="capitalDynamicsMR">
   											<label class="triangleTip"></label>
   											<div>充值10,000.00元   实际到账10,000.00元   账户余额20,000.00元   充值10,000.00元</div>
   										</div>
   									</li>
   									<%} %>
   									<li class="clearfix">
   										<div class="capitalDynamicsML">
   											<div class="leftTop"><label class="circle grey"></label></div>
   											<div class="leftBottom"></div>
   										</div>
   									</li>
   								</ul>
   							</div>
   						</div>
   						<!-- 资金动态部分结束 -->
   						<!-- 精品推荐部分开始 -->
   						<div class="recommendBoutique">
   							<div class="recommendBoutiqueH">
   								<div class="noPointer">精品推荐</div>
   							</div>
   							<div class="recommendBoutiqueM">
   								<div class="BoutiqueMContTop">
   									<label></label>
   									<span class="BoutiqueMContTitle">化工企业研发资金借款</span>
   									<span class="BoutiqueMContNum">【NO.20160306121】</span>
   								</div>
   								<div class="BoutiqueMContBottom">
   									<div class="BoutiqueMContBottomItem">
   										<div class="BoutiqueItemNum boutiqueHighLight">14.56%</div>
   										<div class="BoutiqueItemName">年化利率</div>
   									</div>
   									<div class="BoutiqueMContBottomItem">
   										<div class="BoutiqueItemNum"><label class="moneyFormat">220</label><span>万元</span></div>
   										<div class="BoutiqueItemName">项目金额</div>
   									</div>
   									<div class="BoutiqueMContBottomItem">
   										<div class="BoutiqueItemNum leftDistance">12<span>个月</span></div>
   										<div class="BoutiqueItemName">项目期限</div>
   									</div>
   									<div class="BoutiqueMContBottomItem">
   										<div class="BoutiqueItemNum"><label class="moneyFormat">66</label><span>万元</span></div>
   										<div class="BoutiqueItemName">可投金额</div>
   									</div>
   									<div class="BoutiqueMContBottomItem">
   										<div class="btn" onselectstart="return false" onclick="window.location='loan.html';">立即查看</div>
   									</div>
   								</div>
   							</div>
   							<div class="ad">
   								<label></label>
   							</div>
   						</div>
   					<!-- 精品推荐部分结束 -->
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/accountOverview/accountOverview.js"></script>
</body>
</html>