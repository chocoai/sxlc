<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>我的VIP</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/myVIP.css">
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
   				<!--伍成然2016-4-1  -->
   					<div class="head">
	   					<div class="title">
	   						我的VIP
	   					</div>
	   					<div class="buy-VIP">
	   						购买VIP
	   					</div>		
	   				</div>
	   				<div class="my-VIP-content">
		   				<ul class="my-VIP-table">
		   					<li>
		   						<div class="contentOut">
									<div class="content">
										有效时间段
									</div>
								</div>
								<div class="contentOut">
									<div class="content">
										VIP类型
									</div>
								</div>
								<div class="contentOut">
									<div class="content">
										记录时间
									</div>
								</div>
								<div class="contentOut">
									<div class="content">
										使用金额
									</div>
								</div>
		   					</li>
		   					<% for(int j = 0; j<2;j++){ %>
		   					<li>
		   						<div class="contentOut">
									<div class="content">
										2015-10-20至2015-11-24
									</div>
								</div>
								<div class="contentOut">
									<div class="content">
										自动升级
									</div>
								</div>
								<div class="contentOut">
									<div class="content">
										2016-09-07&nbsp;14:12:06
									</div>
								</div>
								<div class="contentOut">
									<div class="content">
										1,000.00
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
   	<!-- 弹出层 -->
   	<div class="buyVip">
   		<div class="buy-top">
   			<div class="buy-input">
   				<div class="left-title">开始时间:</div>
   				<input type="text" class="input-time select-time Wdate" onfocus="WdatePicker()" lang="请选择开始时间">
   			</div>
   			<div class="buy-input">
   				<div class="left-title">年数:</div>
   				<input type="text" class="input-time numberReg" lang="请输入购买年份" maxlength="2">
   				<span>年</span>
   			</div>
   			<div class="buy-input">
   				<div class="left-title">应付金额:</div>
   				<div class="orange info">1,000.00元</div>
   			</div>
   			<div class="buy-input">
   				<div class="left-title">预计时间段:</div>
   				<div class="info">2015-12-14至2016-03-08</div>
   			</div>
   		</div>
   		<div class="buy-bottom">
   			<input type="button" class="buy-now btn" value="立即购买" onclick="layer.closeAll()">
   		</div>
   	</div>
	<script type="text/javascript" src="plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/myVIP.js"></script>
</body>
</html>