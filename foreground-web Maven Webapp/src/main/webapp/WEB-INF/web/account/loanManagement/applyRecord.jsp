<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>借款申请记录</title>
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
	   					<li><a href="LR_financing.html">借款记录</a></li>
	   					<li class="loan-record-ing">借款申请记录</li>
	   					<li><a href="TBC_apply.html">待确认借款申请</a></li>
	   				</ul>
	   				<div class="my-loan-group clearfix">
		   				<ul class="my-loan-table">
		   					<li>
		   						<div class="contentOut4">
									<div class="content">
										项目申请编号
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										项目名称
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										产品类型
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										借款期限
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										借款金额
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										最低借款金额
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										年化利率
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										状态
									</div>
								</div>					
		   					</li>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut4">
									<div class="content">
										00000001
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										借款信用贷<br>
										买房急需钱
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										抵押贷
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										2个月
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										1,000.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										100.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										8.00%
									</div>
								</div>
								<div class="contentOut4">
									<div class="content checking"><!--审核中(单独样式)，已拒绝，审核未通过，未发布，已发布  -->
										审核中
									</div>
								</div>
		   					</li>
		   					<%} %>
							<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut4">
									<div class="content">
										00000001
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										借款信用贷<br>
										买房急需钱
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										抵押贷
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										2个月
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										1,000.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										100.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										8.00%
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										已拒绝
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
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/loanManagement/myLoan.js"></script>
</body>
</html>