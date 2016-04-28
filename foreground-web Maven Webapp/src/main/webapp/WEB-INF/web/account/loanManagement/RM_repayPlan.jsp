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
    <title>还款计划</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/account/loanManagement/repayManagement.css">
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
   				<!--伍成然2016-3-31  -->
	   				<div class="head">
	   					<div class="title">
	   						<a href="loanManagement/repayManagement.html">还款中的借款</a>——还款计划
	   					</div>		
	   				</div>
	   				<input type="button" class="btn early-repay" value="提前还款">
	   				<div class="remind">剩余未还本金+剩余本金产生的利息+提前还款违约金</div>
	   				<div class="my-loan-group myLoan clearfix"><!--myLoan便于单独设置样式 -->
		   				<ul class="my-loan-table">
		   					<li>
		   						<div class="contentOut2">
									<div class="c-content">
										期数
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										应还本金
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										应还利息
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										预计还款日
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										还款状态
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										是否逾期
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										是否代偿
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										逾期费用
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										实际还款金额
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										实际还款日
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										操作
									</div>
								</div>
		   					</li>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut2">
									<div class="c-content">
										1
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										1,000.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										2016-04-07
										12:12:00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content mark"><!--未还mark  -->
										未还
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										是
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										是
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										--
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										--
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										<div class="repay">还款</div>
									</div>
								</div>
		   					</li>
		   					<%} %>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut2">
									<div class="c-content">
										1
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										1,000.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										2016-04-07
										12:12:00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										已还
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										否
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										否
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										--
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										2016-02-04<br>
										12:12:00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
									</div>
								</div>
		   					</li>
		   					<%} %>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut2">
									<div class="c-content">
										1
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										1,000.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										2016-04-07
										12:12:00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										部分还款
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										否
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										否
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										2016-02-04<br>
										12:12:00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
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
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
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
	<script type="text/javascript" src="js/account/loanManagement/repayManagement.js"></script>
</body>
</html>