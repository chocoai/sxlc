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
    <title>还款记录</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
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
	   				<div class="head">
	   					<div class="title">
	   						<a href="loanManagement/LR_clearing.html">已结清的借款</a>——还款记录
	   					</div>		
	   				</div>
	   				<div class="my-loan-group clearfix">
		   				<ul id="loanRepayendUl" class="my-loan-table">
		   					<li id="loanRepayendTop">
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
										应还逾期利息
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										应还逾期罚金
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										已还本金
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										已还利息
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										已还逾期罚金
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										已还逾期利息
									</div>
								</div>
								<div class="contentOut2">
									<div class="c-content">
										结清方式
									</div>
								</div>
		   					</li>
		   					<%-- <% for(int j = 0; j<2;j++){ %>
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
										2016-04-07<br>
										12:12:00
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
										正常结清
									</div>
								</div>
		   					</li>
		   					<%} %> --%>		   					
		   				</ul>
		   				<script id="loanRepayendList" type="text/html">
		   					{{each results as infos index}}
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
											2016-04-07<br>
											12:12:00
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
											正常结清
										</div>
									</div>
			   					</li>
		   					{{/each}}
		   					<div id="pager" class="pager-box"></div>						   				
		   				</script>
	   				</div>   				
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript">
		var publickey = '<%=session.getAttribute("publicKey")%>';
	</script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/loanManagement/myLoan.js"></script>
	<script type="text/javascript">
		//根据id查询还款记录
		getRepayRecord();
	</script>
</body>
</html>