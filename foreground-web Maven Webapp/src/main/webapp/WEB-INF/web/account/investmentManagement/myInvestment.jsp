<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>我的投资</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/investmentManagement/myInvestment.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
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
   				<!-- 主体部分开始 王延君 2016-04-01 -->
   				<div class="myInvestment">
   					<div class="myInvestmentH">
   						<div class="recycle">回收中</div>
   						<div class="settled">已结清</div>
   						<div class="biding">投标中</div>
   						<div class="bidMissed">已流标</div>
   						<div class="bidEnd">投标结束</div>
   					</div>
   					<div class="myInvestmentM">
   						<ul class="recycleUl">
   							<li>
   								<div class="myInvestmentMTitle">
					   				<div class="productNum">项目编号</div>
					   				<div class="productName">项目名称</div>
					   				<div class="lender">借款人</div>
					   				<div class="investNum">投资金额</div>
					   				<div class="remainingNum">剩余期数<em class="iconDown"></em></div>
					   				<div class="remainingMoney">剩余本金</div>
					   				<div class="remainingInterest">剩余利息</div>
					   				<div class="nextPaymentT">下期回款时间<em class="iconDown"></em></div>
					   				<div class="nextPaymentM">下期回款本金</div>
					   				<div class="nextPaymentI">下期回款利息</div>
					   				<div class="opreations">操作</div>
		   						</div>
   							</li>
   							<%for(int i=0;i<5;i++){%>
   							<li>
   								<div class="productNum divOutside">
		   							<div class="divIntside">
		   								<div> XMBH-<br>00000001</div>
		   							</div>
		   						</div>
		   						<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div>借款信用贷</div>
		   								<div>买房急需钱</div>
		   							</div>
		   						</div>
		   						<div class="lender divOutside">
		   							<div class="divIntside">
		   								<div>刘***5</div>
		   							</div>
		   						</div>
		   						<div class="investNum divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">200</div>
		   							</div>
		   						</div>
		   						<div class="remainingNum divOutside">
		   							<div class="divIntside">
		   								<div>2个月</div>
		   							</div>
		   						</div>
		   						<div class="remainingMoney divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">100</div>
		   							</div>
		   						</div>
		   						<div class="remainingInterest divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">10</div>
		   							</div>
		   						</div>
		   						<div class="nextPaymentT divOutside">
		   							<div class="divIntside">
		   								<div>2016-04-07<br>12:12:00</div>
		   							</div>
		   						</div>
		   						<div class="nextPaymentM divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">1000</div>
		   							</div>
		   						</div>
		   						<div class="nextPaymentI divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">100</div>
		   							</div>
		   						</div>
   								<div class="opreations divOutside">
		   							<div class="divIntside">
		   								<div class="profitPlan"><a href="investmentManagement/revenuePlan.html">收益计划</a></div>
		   								<div class="agreement"><a href="#">协议</a></div>
		   								<div class="supervise"><span></span><a href="#">贷后监管</a></div>
		   							</div>
		   						</div>
   							</li>
   							<%}%>
   							<li class="page"><div id="pager"></div></li>
   						</ul>
   						<ul class="settledUl">
   							<li>
   								<div class="myInvestmentMTitle">
					   				<div class="productNum">项目编号</div>
					   				<div class="productName">项目名称</div>
					   				<div class="lender">借款人</div>
					   				<div class="investNum">投资金额<em class="iconDown"></em></div>
					   				<div class="annualInterestRate">年利率化</div>
					   				<div class="totalRevenue">收益总额<em class="iconDown"></em></div>
					   				<div class="lendingTime">放款时间<em class="iconDown"></em></div>
					   				<div class="closingTime">结清时间<em class="iconDown"></em></div>
					   				<div class="opreations">操作</div>
		   						</div>
   							</li>
   							<%for(int i=0;i<5;i++){%>
   							<li>
   								<div class="productNum divOutside">
		   							<div class="divIntside">
		   								<div> XMBH-<br>00000001</div>
		   							</div>
		   						</div>
		   						<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div>借款信用贷</div>
		   								<div>买房急需钱</div>
		   							</div>
		   						</div>
		   						<div class="lender divOutside">
		   							<div class="divIntside">
		   								<div>刘***5</div>
		   							</div>
		   						</div>
		   						<div class="investNum divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">2200</div>
		   							</div>
		   						</div>
		   						<div class="annualInterestRate divOutside">
		   							<div class="divIntside">
		   								<div>8.00%</div>
		   							</div>
		   						</div>
		   						<div class="totalRevenue divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">2200</div>
		   							</div>
		   						</div>
		   						<div class="lendingTime divOutside">
		   							<div class="divIntside">
		   								<div>2016-04-07<br>12:12:00</div>
		   							</div>
		   						</div>
		   						<div class="closingTime divOutside">
		   							<div class="divIntside">
		   								<div>2016-04-07<br>12:12:00</div>
		   							</div>
		   						</div>
   								<div class="opreations divOutside">
		   							<div class="divIntside">
		   								<div class="profitPlan"><a href="investmentManagement/revenueRecord.html">收益计划</a></div>
		   								<div class="agreement"><a href="#">协议</a></div>
		   							</div>
		   						</div>
   							</li>
   							<%}%>
   							<li class="page"><div id="pager1"></div></li>
   						</ul>
   						<ul class="bidingUl">
   							<li>
   								<div class="myInvestmentMTitle">
					   				<div class="productNum">项目编号</div>
					   				<div class="productName">项目名称</div>
					   				<div class="lender">借款人</div>
					   				<div class="investNum">投资金额<em class="iconDown"></em></div>
					   				<div class="annualInterestRate">年化利率</div>
					   				<div class="investmentProgress">投资进度<em class="iconDown"></em></div>
					   				<div class="bidTerm">期限</div>
					   				<div class="repaymentMethod">还款方式<em class="iconDown"></em></div>
					   				<div class="biddingTime">投标时间</div>
		   						</div>
   							</li>
   							<%for(int i=0;i<5;i++){%>
   							<li>
   								<div class="productNum divOutside">
		   							<div class="divIntside">
		   								<div> XMBH-<br>00000001</div>
		   							</div>
		   						</div>
		   						<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div>借款信用贷</div>
		   								<div>买房急需钱</div>
		   							</div>
		   						</div>
		   						<div class="lender divOutside">
		   							<div class="divIntside">
		   								<div>刘***5</div>
		   							</div>
		   						</div>
		   						<div class="investNum divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">1000</div>
		   							</div>
		   						</div>
		   						<div class="annualInterestRate divOutside">
		   							<div class="divIntside">
		   								<div>8%</div>
		   							</div>
		   						</div>
		   						<div class="investmentProgress divOutside">
		   							<div class="divIntside">
		   								<div>50%</div>
		   							</div>
		   						</div>
		   						<div class="bidTerm divOutside">
		   							<div class="divIntside">
		   								<div>2个月</div>
		   							</div>
		   						</div>
		   						<div class="repaymentMethod divOutside">
		   							<div class="divIntside">
		   								<div>到期还本息</div>
		   							</div>
		   						</div>
		   						<div class="biddingTime divOutside">
		   							<div class="divIntside">
		   								<div>2016-04-07<br>12:12:00</div>
		   							</div>
		   						</div>
   							</li>
   							<%}%>
   							<li class="page"><div id="pager2"></div></li>
   						</ul>
   						<ul class="bidMissedUl">
   							<li>
   								<div class="myInvestmentMTitle">
					   				<div class="productNum">项目编号</div>
					   				<div class="productName">项目名称</div>
					   				<div class="lender">借款人</div>
					   				<div class="investNum">投资金额<em class="iconDown"></em></div>
					   				<div class="annualInterestRate">年利率化</div>
					   				<div class="bidTerm">期限</div>
					   				<div class="biddingTime">投标时间<em class="iconDown"></em></div>
					   				<div class="bidMissedTime">流标时间<em class="iconDown"></em></div>
		   						</div>
   							</li>
   							<%for(int i=0;i<5;i++){%>
   							<li>
   								<div class="productNum divOutside">
		   							<div class="divIntside">
		   								<div> XMBH-<br>00000001</div>
		   							</div>
		   						</div>
		   						<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div>借款信用贷</div>
		   								<div>买房急需钱</div>
		   							</div>
		   						</div>
		   						<div class="lender divOutside">
		   							<div class="divIntside">
		   								<div>刘***5</div>
		   							</div>
		   						</div>
		   						<div class="investNum divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">1000</div>
		   							</div>
		   						</div>
		   						<div class="annualInterestRate divOutside">
		   							<div class="divIntside">
		   								<div>8.00%</div>
		   							</div>
		   						</div>
		   						<div class="bidTerm divOutside">
		   							<div class="divIntside">
		   							<div>2个月</div>
		   							</div>
		   						</div>
		   						<div class="biddingTime divOutside">
		   							<div class="divIntside">
		   								<div>2016-04-07<br>12:12:00</div>
		   							</div>
		   						</div>
		   						<div class="bidMissedTime divOutside">
		   							<div class="divIntside">
		   								<div>2016-04-07<br>12:12:00</div>
		   							</div>
		   						</div>
   							</li>
   							<%}%>
   							<li class="page"><div id="pager3"></div></li>
   						</ul>
   						<ul class="bidEndUl">
   							<li>
   								<div class="myInvestmentMTitle">
					   				<div class="productNum">项目编号</div>
					   				<div class="productName">项目名称</div>
					   				<div class="lender">借款人</div>
					   				<div class="investNum">投资金额<em class="iconDown"></em></div>
					   				<div class="annualInterestRate">年利率化</div>
					   				<div class="bidTerm">期限</div>
					   				<div class="repaymentMethod">还款方式</div>
					   				<div class="biddingTime">投标时间<em class="iconDown"></em></div>
					   				<div class="biddingEndTime">投标结束时间<em class="iconDown"></em></div>
		   						</div>
   							</li>
   							<%for(int i=0;i<5;i++){%>
   							<li>
   								<div class="productNum divOutside">
		   							<div class="divIntside">
		   								<div> XMBH-<br>00000001</div>
		   							</div>
		   						</div>
		   						<div class="productName divOutside">
		   							<div class="divIntside">
		   								<div>借款信用贷</div>
		   								<div>买房急需钱</div>
		   							</div>
		   						</div>
		   						<div class="lender divOutside">
		   							<div class="divIntside">
		   								<div>刘***5</div>
		   							</div>
		   						</div>
		   						<div class="investNum divOutside">
		   							<div class="divIntside">
		   								<div class="moneyFormat">1000</div>
		   							</div>
		   						</div>
		   						<div class="annualInterestRate divOutside">
		   							<div class="divIntside">
		   								<div>8.00%</div>
		   							</div>
		   						</div>
		   						<div class="bidTerm divOutside">
		   							<div class="divIntside">
		   								<div>2个月</div>
		   							</div>
		   						</div>
		   						<div class="repaymentMethod divOutside">
		   							<div class="divIntside">
		   								<div>到期还本息</div>
		   							</div>
		   						</div>
		   						<div class="biddingTime divOutside">
		   							<div class="divIntside">
		   								<div>2016-04-07<br>12:12:00</div>
		   							</div>
		   						</div>
		   						<div class="biddingEndTime divOutside">
		   							<div class="divIntside">
		   								<div>2016-04-07<br>12:12:00</div>
		   							</div>
		   						</div>
   							</li>
   							<%}%>
   							<li class="page"><div id="pager4"></div></li>
   						</ul>
   					</div>
   					<div id="pager"></div>
   				</div>
   				<!-- 主体部分结束 王延君 2016-04-01 -->
   				</div>
   			</div>
   		</div>
   	</div>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/investmentManagement/myInvestment.js"></script>
</body>
</html>