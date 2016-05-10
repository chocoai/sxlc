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
    <title>还款管理</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" href="plugs/laypage/skin/laypage.css" type="text/css">
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
   					<!--标签切换  -->
	   				<ul class="my-repay-tab">
	   					<li class="tab-li tab-ing" onclick="getStayStillPlans();">待还计划</li>
	   					<li class="tab-li" onclick="getRepayManagementin();">还款中的借款</li>	   					
	   				</ul>
	   				<!--标签切换结束-->
	   				<!--待还计划开始  -->
	   				<div class="tab-content">
	   				<div class="my-repay-content active clearfix">
		   				<ul class="my-loan-table stayStillPlans">
		   					<li>
		   						<div class="contentOut0">
									<div class="c-content">
										期数
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										应还本金
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										应还利息
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										预计还款日
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										还款状态
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										未还逾期利息/罚金
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										是否代偿
									</div>
								</div>
								<div class="contentOut3">
									<div class="c-content">
										已还本金/利息
									</div>
								</div>	
								<div class="contentOut4">
									<div class="c-content">
										已还逾期利息/罚金
									</div>
								</div>	
								<div class="contentOut1">
									<div class="c-content">
										项目名称
									</div>
								</div>	
								<div class="contentOut1">
									<div class="c-content">
										操作
									</div>
								</div>								
		   					</li>
		   					<%-- <% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut0">
									<div class="c-content">
										1
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										1,000.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										2016-04-07<br>
										12:12:00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content mark"><!--未还时mark  -->
										未还
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content mark"><!--红色  -->
										100.00/10.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										是
									</div>
								</div>
								<div class="contentOut3">
									<div class="c-content">
										100.00/10.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										1,000.00/100.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										借款信用贷
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										<div class="repay">还款</div>
									</div>
								</div>
		   					</li>
		   					<%} %>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut0">
									<div class="c-content">
										1
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										1,000.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										2016-04-07<br>
										12:12:00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										部分还款
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content mark"><!--红色  -->
										100.00/10.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										是
									</div>
								</div>
								<div class="contentOut3">
									<div class="c-content">
										100.00/10.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										1,000.00/100.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										借款信用贷
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										<div class="repay">还款</div>
									</div>
								</div>
		   					</li>
		   					<%} %> --%>
		   				</ul>
		   				<div id="pager-stayStillPlans" class="pager-box"></div>   				
	   				</div>
	   				<!--待还计划结束-->
	   				
	   				<!--还款中的借款-->
	   				<div class="my-repay-content clearfix">
		   				<ul class="my-loan-table repayManagementin">
		   					<li>
		   						<div class="contentOut1">
									<div class="c-content">
										项目编号
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										项目名称
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										放款时间
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										本金
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										年化利率
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										融资期限
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										还款方式
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										已还本息
									</div>
								</div>	
								<div class="contentOut1">
									<div class="c-content">
										未还本息
									</div>
								</div>	
								<div class="contentOut2">
									<div class="c-content">
										下一还款日
									</div>
								</div>	
								<div class="contentOut1">
									<div class="c-content">
										还款金额
									</div>
								</div>	
								<div class="contentOut1">
									<div class="c-content">
										操作
									</div>
								</div>								
		   					</li>
		   					<%-- <% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut1">
									<div class="c-content">
										XMBH-00000001
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										借款信用贷<br>
										买房急需钱
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										2016-04-07<br>
										12:12:00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										9.00%
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										2个月
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										到期还本息
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										2016-04-07<br>
										12:12:00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut1">
									<div class="c-content">
										<a href="loanManagement/RM_repayPlan.html">还款计划</a><br>
										<a href="" class="loan-agreement">协议</a><!--跳转未知  -->
									</div>
								</div>
		   					</li>
		   					<%} %> --%>
		   				</ul>
		   				<div id="pager-repayManagementin" class="pager-box"></div>	   				
	   				</div>
	   				<!--还款中的借款结束-->	   				
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
   				<input class="format" type="text" lang="请输入实还本金" maxlength="10">
				<span>元</span>
   			</div>
   			<div class="info">
   				<div class="leftTitle">实还利息:</div>
   				<input class="format" type="text" lang="请输入实还利息" maxlength="10">
				<span>元</span>
   			</div>
   			<div class="info">
   				<div class="leftTitle">实还逾期罚金:</div>
   				<input class="format" type="text" lang="请输入实还逾期罚金" maxlength="10">
				<span>元</span>
   			</div>
   			<div class="info">
   				<div class="leftTitle">实还逾期利息:</div>
   				<input class="format" type="text" lang="请输入实还逾期利息" maxlength="10">
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
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/laypage/laypage.js"></script>
	<script type="text/javascript" src="js/account/loanManagement/repayManagement.js"></script>
	<script type="text/javascript">
		getStayStillPlans();
	</script>
</body>
</html>