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
    <title>借款记录-融资结束</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<!-- <link rel="stylesheet" href="plugs/laypage/skin/laypage.css" type="text/css"> -->
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
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
	   					<li class="loan-record-ing">借款记录</li>
	   					<li><a href="loanManagement/applyRecord.html">借款申请记录</a></li>
	   					<li><a href="loanManagement/TBC_apply.html">待确认借款申请</a></li>
	   				</ul>
	   				<div class="my-loan-group clearfix">
		   				<ul class="my-loan-state">
		   					<li><a href="loanManagement/LR_financing.html">融资中</a></li>
		   					<li class="LR-ing">融资结束</li>
		   					<li><a href="loanManagement/LR_repay.html">还款中</a></li>
		   					<li><a href="loanManagement/LR_failure.html">已流标</a></li>
		   					<li><a href="loanManagement/LR_clearing.html">已结清</a></li>
		   				</ul>
		   				<div class="my-loan-content clearfix">
			   				<ul class="my-loan-table">
			   					<li>
			   						<div class="contentOut2">
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
											产品类型
										</div>
									</div>
									<div class="contentOut2">
										<div class="c-content">
											借款期限
										</div>
									</div>
									<div class="contentOut2">
										<div class="c-content">
											借款金额<!--加效果  -->
										</div>
									</div>
									<div class="contentOut3">
										<div class="c-content">
											年化利率
										</div>
									</div>
									<div class="contentOut4">
										<div class="c-content">
											项目发布日期
										</div>
									</div>
									<div class="contentOut4">
										<div class="c-content">
											标开始结束日期
										</div>
									</div>
									<div class="contentOut3">
										<div class="c-content">
											投资进度
										</div>
									</div>
									<div class="contentOut3">
										<div class="c-content">
											结束时间
										</div>
									</div>
			   					</li>
			   					<%-- <% for(int j = 0; j<2;j++){ %>
			   					<li>
			   						<div class="contentOut2">
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
											抵押贷
										</div>
									</div>
									<div class="contentOut2">
										<div class="c-content">
											2个月
										</div>
									</div>
									<div class="contentOut2">
										<div class="c-content">
											1,000.00
										</div>
									</div>
									<div class="contentOut3">
										<div class="c-content">
											8.00%
										</div>
									</div>
									<div class="contentOut4">
										<div class="c-content">
											2016-04-07 12:12:00
										</div>
									</div>
									<div class="contentOut4">
										<div class="c-content">
											2016-04-07<br>
											--<br>
											2016-04-07
										</div>
									</div>
									<div class="contentOut3">
										<div class="c-content">
											50%<br>
											<span class="invRecord">投资记录</span>
										</div>
									</div>
									<div class="contentOut3">
										<div class="c-content">
											2016-04-07<br>
											12:12:00
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
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<!--弹出层  -->
   	<div class="inv-record">
		<ul class="inv-record-info">
			<li>
				<div class="contentOut5">
					<div class="c-content">
						投资完成时间
					</div>
				</div>
				<div class="contentOut5">
					<div class="c-content">
						会员用户名
					</div>
				</div>
				<div class="contentOut5">
					<div class="c-content">
						会员姓名
					</div>
				</div>
				<div class="contentOut5">
					<div class="c-content">
						投资金额(元)
					</div>
				</div>		
			</li>
			<%-- <% for(int j = 0; j<2;j++){ %>
			<li>
				<div class="contentOut5">
					<div class="c-content">
						2016-04-07<br>
						12:12:00
					</div>
				</div>
				<div class="contentOut5">
					<div class="c-content">
						爱***7
					</div>
				</div>
				<div class="contentOut5">
					<div class="c-content">
						张女士
					</div>
				</div>
				<div class="contentOut5">
					<div class="c-content">
						1,000.00
					</div>
				</div>		
			</li>
			<%} %> --%>
		</ul>
		<script id="investRecordList" type="text/html">
			{{each results as infos index}}
				<li>
					<div class="contentOut5">
						<div class="c-content">
							{{infos.investDate}}
						</div>
					</div>
					<div class="contentOut5">
						<div class="c-content">
							{{infos.userName}}
						</div>
					</div>
					<div class="contentOut5">
						<div class="c-content">
							{{infos.memberName}}
						</div>
					</div>
					<div class="contentOut5">
						<div class="c-content">
							{{infos.sInvestmentAmount}}
						</div>
					</div>		
				</li>
			{{/each}}
			<li><div id="pager1" class="pager-box"></div></li>
		</script>
   	</div>
   	<script type="text/javascript" src="js/common/template.js"></script>
   	<!-- <script type="text/javascript" charset="utf-8" src="plugs/laypage/laypage.js"></script> -->
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/loanManagement/myLoan.js"></script>
	<script type="text/javascript">
		getFinanced();
	</script>
</body>
</html>