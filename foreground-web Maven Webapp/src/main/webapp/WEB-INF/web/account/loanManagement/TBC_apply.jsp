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
    <title>待确认借款申请</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" href="plugs/laypage/skin/laypage.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/account/loanManagement/myLoan.css">
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
	   				<ul class="my-loan-record">
	   					<li><a href="loanManagement/LR_financing.html">借款记录</a></li>
	   					<li><a href="loanManagement/applyRecord.html">借款申请记录</a></li>
	   					<li class="loan-record-ing">待确认借款申请</li>
	   				</ul>
	   				<div class="my-loan-group clearfix">
		   				<ul class="my-loan-table">
		   					<li>
		   						<div class="contentOut4">
									<div class="c-content">
										项目申请编号
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										项目名称
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										产品类型
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										借款期限
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										借款金额
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										最低借款金额
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										年化利率
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										状态
									</div>
								</div>								
		   					</li>
		   					<%-- <% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut4">
									<div class="c-content">
										00000001
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										借款信用贷<br>
										买房急需钱
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										抵押贷
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										2个月
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										1,000.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										8.00%
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content toConfirm submitToConfirm">
										提交审核待确认
									</div>
								</div>
		   					</li>
		   					<%} %>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut4">
									<div class="c-content">
										00000001
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										借款信用贷<br>
										买房急需钱
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										抵押贷
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										2个月
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										1,000.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										8.00%
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content toConfirm publishToConfirm">
										发布待确认
									</div>
								</div>
		   					</li>
		   					<%} %>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut4">
									<div class="c-content">
										00000001
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										借款信用贷<br>
										买房急需钱
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										抵押贷
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										2个月
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										1,000.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										100.00
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content">
										8.00%
									</div>
								</div>
								<div class="contentOut4">
									<div class="c-content viewDetails">
										查看详情
									</div>
								</div>
		   					</li>
		   					<%} %> --%>
		   				</ul>
		   				<div id="pager" class="pager-box"></div>	   				
	   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<!--弹出层  -->
   	<div class="view-details">
   		<ul>
   			<li>
   				<div class="leftTitle">产品类型：</div>
   				<label>担保贷</label>
   			</li>
   			<li>
   				<div class="leftTitle">项目标题：</div>
   				<label>买房需用钱借款担保贷</label>
   			</li>
   			<li>
   				<div class="leftTitle">借款金额：</div>
   				<label>1,000.00元</label>
   			</li>
   			<li>
   				<div class="leftTitle">借款期限：</div>
   				<label>2个月</label>
   			</li>
   			<li>
   				<div class="leftTitle">还款方式：</div>
   				<label>先息后本</label>
   			</li>
   			<li>
   				<div class="leftTitle">项目描述：</div>
   				<label>借款担保贷</label>
   			</li>
   			<li>
   				<div class="leftTitle">借款用途：</div>
   				<label>买房首付</label>
   			</li>
   			<li>
   				<div class="leftTitle">还款来源：</div>
   				<label>每月工资还款</label>
   			</li>
   		</ul>
   	</div>
   	<div class="to-confirm">
   		<ul>
   			<li>
   				<div class="leftTitle">产品类型：</div>
   				<label>担保贷</label>
   			</li>
   			<li>
   				<div class="leftTitle">项目标题：</div>
   				<label>买房需用钱借款担保贷</label>
   			</li>
   			<li>
   				<div class="leftTitle">借款金额：</div>
   				<label>1,000.00元</label>
   			</li>
   			<li>
   				<div class="leftTitle">借款期限：</div>
   				<label>2个月</label>
   			</li>
   			<li>
   				<div class="leftTitle">还款方式：</div>
   				<label>先息后本</label>
   			</li>
   			<li>
   				<div class="leftTitle">项目描述：</div>
   				<label>借款担保贷</label>
   			</li>
   			<li>
   				<div class="leftTitle">借款用途：</div>
   				<label>买房首付</label>
   			</li>
   			<li>
   				<div class="leftTitle">还款来源：</div>
   				<label>每月工资还款</label>
   			</li>
   		</ul>
   		<div class="btn-group">
   			<input type="button" class="agree btn" value="同意" onclick="layer.closeAll()"><!--onclick关闭弹出层  -->
   			<input type="button" class="refuse" value="拒绝" onclick="layer.closeAll()">
   		</div>
   	</div>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/laypage/laypage.js"></script>
	<script type="text/javascript" src="js/account/loanManagement/myLoan.js"></script>
	<script type="text/javascript">
		getApply();
	</script>
</body>
</html>