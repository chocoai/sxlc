<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>还款记录</title>
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
	   				<div class="head">
	   					<div class="title">
	   						<a href="LR_clearing.html">已结清的借款</a>——还款记录
	   					</div>		
	   				</div>
	   				<div class="my-loan-group clearfix">
		   				<ul class="my-loan-table">
		   					<li>
		   						<div class="contentOut2">
									<div class="content">
										期数
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										应还本金
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										应还利息
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										预计还款日
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										应还逾期利息
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										应还逾期罚金
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										已还本金
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										已还利息
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										已还逾期罚金
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										已还逾期利息
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										结清方式
									</div>
								</div>
		   					</li>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut2">
									<div class="content">
										1
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										1,000.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										100.00
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
										1,000.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										1,000.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										正常结清
									</div>
								</div>
		   					</li>
		   					<%} %>		   					
		   				</ul>
		   				<div id="pager1"></div>						   				
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