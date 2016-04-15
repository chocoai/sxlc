<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>我的借款-已结清</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/account/loanManagement/myLoan.css">
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
   				   	<!--伍成然2016-3-31  -->
	   				<ul class="my-loan-record">
	   					<li class="loan-record-ing">借款记录</li>
	   					<li><a href="applyRecord.html">借款申请记录</a></li>
	   					<li><a href="TBC_apply.html">待确认借款申请</a></li>
	   				</ul>
	   				<div class="my-loan-group clearfix">
		   				<ul class="my-loan-state">
		   					<li><a href="LR_financing.html">融资中</a></li>
		   					<li><a href="LR_financed.html">融资结束</a></li>
		   					<li><a href="LR_repay.html">还款中</a></li>
		   					<li><a href="LR_failure.html">已流标</a></li>
		   					<li class="LR-ing">已结清</li>
		   				</ul>
		   				<div class="my-loan-content clearfix">
			   				<ul class="my-loan-table">
			   					<li>
			   						<div class="contentOut0">
										<div class="content">
											项目编号
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											项目名称
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											借款金额
										</div>
									</div>
									<div class="contentOut2">
										<div class="content">
											实际借款金额
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											年化利率
										</div>
									</div>
									<div class="contentOut2">
										<div class="content">
											放款时间
										</div>
									</div>
									<div class="contentOut2">
										<div class="content">
											结清时间
										</div>
									</div>
									<div class="contentOut3">
										<div class="content">
											已还本金/利息
										</div>
									</div>
									<div class="contentOut3">
										<div class="content">
											逾期利息/罚金
										</div>
									</div>
									<div class="contentOut3">
										<div class="content">
											提前还款违约金
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											结清方式
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											操作
										</div>
									</div>
			   					</li>
			   					<% for(int j = 0; j<2;j++){ %>
			   					<li>
			   						<div class="contentOut0">
										<div class="content">
											XMBH-00000001
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											借款信用贷<br>
											买房急需钱
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											1,000.00
										</div>
									</div>
									<div class="contentOut2">
										<div class="content">
											1,000.00
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											8.00%
										</div>
									</div>
									<div class="contentOut2">
										<div class="content">
											2016-04-07<br>
											12:12:00
										</div>
									</div>
									<div class="contentOut2">
										<div class="content">
											2016-04-07<br>
											12:12:00
										</div>
									</div>
									<div class="contentOut3">
										<div class="content">
											1,000.00/10.00
										</div>
									</div>
									<div class="contentOut3">
										<div class="content">
											100.00/10.00
										</div>
									</div>
									<div class="contentOut3">
										<div class="content">
											10.00							
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											正常结清						
										</div>
									</div>
									<div class="contentOut0">
										<div class="content">
											<a href="repayRecord.html">还款记录</a><br>
											<a href="" class="loan-agreement">借款协议</a><!--跳转未知  -->
										</div>
									</div>
			   					</li>
			   					<%} %>
			   				</ul>
			   				<div id="pager"></div>
		   				</div>
		   			</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/loanManagement/myLoan.js"></script>
</body>
</html>