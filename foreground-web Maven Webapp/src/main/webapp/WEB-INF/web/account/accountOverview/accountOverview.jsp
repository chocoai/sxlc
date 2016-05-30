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
	<base href="<%=basePath%>">
    <title>账户总览</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/accountOverview/accountOverview.css">
	<%-- <jsp:include page="myPIChart.jsp"></jsp:include> --%>
	<script src="plugs/dist/echarts.js"></script>
</head>
<body>
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
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
	   								账户总资产<span class="moneyFormat totalAmount">0</span>
	   								<label class="tipOrigin tipOrigin1"></label>
	   								<!-- <div class="tipLeft">
	   									<div class="contentLeft">可用余额+冻结金额+待收本金+待收收益-待还总额
	   										<img class="imgLeft" src="resource/img/account/accountOverview/wdzh_tip2.png">
	   									</div>
	   								</div> -->
	   							</div>
	   							<div class="secondaryTitle">
	   								<div class="totalRecharge">累计充值<span class="moneyFormat">0</span></div>
	   								<div class="totalWithdrawals">累计提现<span class="moneyFormat">0</span></div>
	   								<div class="secondaryTitleOperate">
	   									<div class="btn rechargeBtn" onselectstart="return false">充值</div>
		   								<div class="btn withdrawalsBtn" onselectstart="return false">提现</div>
		   								<div class="btn friendTransfer" onselectstart="return false">好友转账</div>
	   								</div>
	   								<div class="secondaryTitleInfo">
	   									<span class="secondarySharp"></span>
	   									<div class="secondaryTitleInfoCont">
	   										<div class="secondaryTitleWord">
												<div class="secondaryTitleWordNum moneyFormat totalAmount">0</div>
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
								            </script>
											</div>
											<div class="secondaryTitleInfoMiddle">
												<div>
													<label class="circle blue"></label>可用余额
													<label class="whatever tipOrigin whatever1"></label>
													<span class="highLight moneyFormat userBalances">0</span>
												</div>
												<div>
													<label class="circle red"></label>冻结金额
													<label class="whatever tipOrigin whatever2"></label>
													<span class="moneyFormat frozen">0</span>
												</div>
												<div>
													<label class="circle green"></label>待收本金
													<label class="whatever tipOrigin whatever3"></label>
													<span class="moneyFormat willRecPrincipal">0</span>
												</div>
												<div>
													<label class="circle orangeCircle"></label>待收收益
													<label class="whatever tipOrigin whatever4"></label>
													<span class="moneyFormat willRecInterest">0</span>
												</div>
												<div>
													<label class="circle grey"></label>待还总额
													<label class="whatever tipOrigin whatever5"></label>
													<span class="moneyFormat repayAmount">0</span>
												</div>
											</div>
											<div class="secondaryTitleInfoRight">
												<div class="InfoRightM">
													<label class="vouchers"></label>代金券<span class="fl_r_mr_40 moneyFormat giftUserBalances">0</span>
												</div>
												<div class="InfoRightM">
													<label class="luckyMoney"></label>红包<span class="fl_r_mr_40 moneyFormat giftAmount">0</span>
												</div>
												<div class="InfoRightM">
													<label class="intAble"></label>可用积分(分)<span class="fl_r_mr_40 integralResidue"></span>
												</div>
												<div class="InfoRightM">
													<label class="invitated"></label>已邀请好友(位)<span class="fl_r_mr_40 friends">0</span>
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
	   									<div class="planMItemNum moneyFormat investAmountValid">150</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">累计收益</div>
	   									<div class="planMItemNum highLight moneyFormat realAmount">100</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">投标奖励</div>
	   									<div class="planMItemNum moneyFormat backAmount">0</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">代金券抵扣</div>
	   									<div class="planMItemNum moneyFormat investVouchersAmount">0</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">红包抵扣</div>
	   									<div class="planMItemNum moneyFormat investGiftAmount">0</div>
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
										        
										        
								       </script>
									</div>
									<div class="time">2016年</div>
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
	   									<div class="planMItemNum moneyFormat amount">150</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">待还本金</div>
	   									<div class="planMItemNum highLight moneyFormat willRepayPrincipal">100</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">待还利息</div>
	   									<div class="planMItemNum moneyFormat willRepayInterest">0</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">逾期未还</div>
	   									<div class="planMItemNum moneyFormat overdue">150</div>
	   								</div>
	   								<div class="planMItem">
	   									<div class="planMItemWord">最近应还日期</div>
	   									<div class="planMItemNum planMItemDetail"><div class="lastDate"></div>详情&gt;</div>
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
										        
										        
								       </script>
									</div>
									<div class="time">2016年</div>
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
   								<span class="more" onclick="window.location='fundManagement/incomeExpenditure.html'">更多&gt;</span>
   							</div>
   							<div class="capitalDynamicsM">
   								<ul class="repayRecordUL">
   									<%-- <%for(int i = 0;i<3;i++){ %>
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
   									<%} %>  --%>
   									<li class="clearfix footli">
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
   										<div class="btn" onselectstart="return false" onclick="window.location='loan/loan.html';">立即查看</div>
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
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/accountOverview/accountOverview.js"></script>
</body>
</html>