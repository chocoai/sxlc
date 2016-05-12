<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>常见问题</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/commonProblem.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="problem">
    	<div class="problemH">
    		<span class="problem_title">常见问题</span>
    	</div>
	   	<div class="problem_content">
	   	   		<%-- <%for(int i = 0;i<8;i++){ %>
	   	   		<div class="problem_plat">
	   	   			<h5><em class="problem_platT">四象金融平台优势</em><span class="problem_plat_btn"></span></h5>
		   	   		<div class="problem_plat_cont">
		   	   			<p>1. 我们的借款人都是各商协会、专业市场管理方推荐的，有相应的企业和个人做担保或有足额的抵押物；<br>
			   	   			2. 借款人须购买借款期间所借总额的人身意外险，第一受益人是我公司，以保证极端情况下您投资的安全。<br>
			   	   			3. 若借款人出现逾期，平台会用风险保证金账户赔付。<br>
			   	   			4. 目前您投资的充值、提现费全部由我公司支付，收益佣金亦全免。也就是说，目前在平台参与投资没有任何费用。<br>
			   	   			5. 现在推出优惠活动有：推荐有奖、红包奖励、代金券、转盘抽奖。
		   	   			</p>
		   	   		</div>
	   	   		</div>
	   	   		<%} %> --%>
   	   	</div>
   	</div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/commonProblem.js"></script>
</body>
</html>