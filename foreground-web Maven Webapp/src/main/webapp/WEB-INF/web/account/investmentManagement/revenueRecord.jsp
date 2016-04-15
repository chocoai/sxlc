<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>收益记录</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/investmentManagement/myInvestment.css">
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
   				<!-- 主体部分开始 王延君 2016-04-01-->
   				<div class="myInvestment">
   					<div class="revenueRecordContent">
   						<div class="myInvestmentH">
	   						<div class="revenueRecord">已结清的投资-收益记录</div>
	   					</div>
	   					<div class="myInvestmentM">
	   						<ul class="revenueRecordUl">
	   							<li>
	   								<div class="myInvestmentMTitle">
						   				<div class="terms">期数</div>
						   				<div class="receivablePrincipal">应收本金</div>
						   				<div class="interestReceivable">应收利息</div>
						   				<div class="scheduledPaymentDate">预定回款日</div>
						   				<div class="principalInterestPaid">实收本息</div>
						   				<div class="overdueIncome">实收逾期收益</div>
						   				<div class="actualPaymentDate">实际回款日</div>
			   						</div>
	   							</li>
	   							<%for(int i=0;i<5;i++){%>
	   							<li>
	   								<div class="terms divOutside">
			   							<div class="divIntside">
			   								<div>1</div>
			   							</div>
			   						</div>
			   						<div class="receivablePrincipal divOutside">
			   							<div class="divIntside">
			   								<div class="moneyFormat">1000</div>
			   							</div>
			   						</div>
			   						<div class="interestReceivable divOutside">
			   							<div class="divIntside">
			   								<div class="moneyFormat">10</div>
			   							</div>
			   						</div>
			   						<div class="scheduledPaymentDate divOutside">
			   							<div class="divIntside">
			   								<div>2016-04-07<br>12:12:00</div>
			   							</div>
			   						</div>
			   						<div class="principalInterestPaid divOutside">
			   							<div class="divIntside">
			   								<div class="moneyFormat">1000</div>
			   							</div>
			   						</div>
			   						<div class="overdueIncome divOutside">
			   							<div class="divIntside">
			   							<div class="moneyFormat">10</div>
			   							</div>
			   						</div>
			   						<div class="actualPaymentDate divOutside">
			   							<div class="divIntside">
			   								<div>2016-04-07<br>12:12:00</div>
			   							</div>
			   						</div>
	   							</li>
	   							<%}%>
	   						</ul>
	   					</div>
   					</div>
   				</div>
   				<!-- 主体部分结束 王延君 2016-03-04-01 -->
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/investmentManagement/myInvestment.js"></script>
</body>
</html>