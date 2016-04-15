<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>还款计划</title>
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
	   						<a href="LR_repay.html">还款中的借款</a>——还款计划
	   					</div>		
	   				</div>
	   				<input type="button" class="btn early-repay" value="提前还款">
	   				<div class="remind">剩余未还本金+剩余本金产生的利息+提前还款违约金</div>
	   				<div class="my-loan-group myLoan clearfix"><!--myLoan便于单独设置样式 -->
		   				<ul class="my-loan-table">
		   					<li>
		   						<div class="contentOut1">
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
								<div class="contentOut3">
									<div class="content">
										预计还款日
									</div>
								</div>
								<div class="contentOut3">
									<div class="content">
										还款状态
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										应还逾期利息/罚金
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										是否代偿
									</div>
								</div>
								<div class="contentOut3">
									<div class="content">
										已还本金/利息
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										已还逾期利息/罚金
									</div>
								</div>
								<div class="contentOut1">
									<div class="content">
										操作
									</div>
								</div>
		   					</li>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut1">
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
								<div class="contentOut3">
									<div class="content">
										2016-04-07<br>
										12:12:00
									</div>
								</div>
								<div class="contentOut3">
									<div class="content mark"><!--未还mark  -->
										未还
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										1,000.00/100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										是
									</div>
								</div>
								<div class="contentOut3">
									<div class="content">
										--
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										--
									</div>
								</div>
								<div class="contentOut1">
									<div class="content">
										<div class="repay">还款</div>
									</div>
								</div>
		   					</li>
		   					<%} %>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut1">
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
								<div class="contentOut3">
									<div class="content">
										2016-04-07<br>
										12:12:00
									</div>
								</div>
								<div class="contentOut3">
									<div class="content">
										已还
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										--
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										否
									</div>
								</div>
								<div class="contentOut3">
									<div class="content">
										1,000.00/100.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										100.00/10.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="content">
									</div>
								</div>
		   					</li>
		   					<%} %>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut1">
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
								<div class="contentOut3">
									<div class="content">
										2016-04-07<br>
										12:12:00
									</div>
								</div>
								<div class="contentOut3">
									<div class="content">
										部分还款
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										1,000.00/100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="content">
										否
									</div>
								</div>
								<div class="contentOut3">
									<div class="content">
										1,000.00/100.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="content">
										100.00/10.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="content">
										<div class="repay">还款</div>
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
   	<!--弹出层  -->
   	<div class="repay-content">
   		<div class="repay-top clearfix">
   			<div class="info">
   				<div class="leftTitle">应还本金:</div>
   				<label>100.00元</label>
   			</div>
   			<div class="info">
   				<div class="leftTitle">应还利息:</div>
   				<label>10.00元</label>
   			</div>
   			<div class="info">
   				<div class="leftTitle">应还逾期罚金:</div>
   				<label>0.00元</label>
   			</div>
   			<div class="info">
   				<div class="leftTitle">应还逾期利息:</div>
   				<label>0.00元</label>
   			</div>
   			<div class="info">
   				<div class="leftTitle">应还总额:</div>
   				<label>110.00元</label>
   			</div>
   		</div>
   		<div class="repay-bottom">
   			<div class="info">
   				<div class="leftTitle">账户可用余额:</div>
   				<div class="money">10.000元</div>
   			</div>
   			<div class="info">
   				<div class="leftTitle">实还本金:</div>
   				<input type="text" lang="请输入实还本金">
				<span>元</span>
   			</div>
   			<div class="info">
   				<div class="leftTitle">实还利息:</div>
   				<input type="text" lang="请输入实还利息">
				<span>元</span>
   			</div>
   			<div class="info">
   				<div class="leftTitle">实还逾期罚金:</div>
   				<input type="text" lang="请输入实还逾期罚金">
				<span>元</span>
   			</div>
   			<div class="info">
   				<div class="leftTitle">实还逾期利息:</div>
   				<input type="text" lang="请输入实还逾期利息">
				<span>元</span>
   			</div>
   			<div class="info clearfix">
   				<div class="leftTitle">实还总额:</div>
   				<div class="money">110.00元</div>
   			</div>
   		</div>	
   		<div class="input-btn">
   			<input type="button" class="repay-confirm btn" value="确定" onclick="layer.closeAll()">
   		</div>
   	</div>
   	<div class="early-repay-content">
   		<ul>
   			<li>
   				<div class="left">提前还款本金</div>
   				<div class="right">10,000.00元</div>
   			</li>
   			<li>
   				<div class="left">提前还款利息</div>
   				<div class="right">100.00元</div>
   			</li>
   			<li>
   				<div class="left">提前还款违约金</div>
   				<div class="right">0.00元</div>
   			</li>
   			<li>
   				<div class="left">提前还款总款</div>
   				<div class="right orange">10,100.00元</div>
   			</li>
   		</ul>
   		<input type="button" class="early-repay-confirm btn" value="确定" onclick="layer.closeAll()">
   	</div>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/loanManagement/myLoan.js"></script>
</body>
</html>