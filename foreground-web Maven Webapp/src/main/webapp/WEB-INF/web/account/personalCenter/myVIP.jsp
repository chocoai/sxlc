<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>我的VIP</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/myVIP.css">
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    	var basePath = '<%=basePath%>';
    </script>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
   				<!--伍成然2016-4-1  -->
   					<div class="head">
	   					<div class="title">我的VIP</div>
	   					<div class="buy-VIP">购买VIP</div>
	   					<input type="hidden" id="tol" value="${tol }">
	   					<input type="hidden" id="cpage" value="${cpage }">
	   					<input type="hidden" id="pageSize" value="${pageSize }">
	   				</div>
	   				<div class="my-VIP-content">
		   				<ul class="my-VIP-table">
		   					<li>
		   						<div class="contentOut"><div class="c-content">有效时间段</div></div>
								<div class="contentOut"><div class="c-content">VIP类型</div></div>
								<div class="contentOut"><div class="c-content">记录时间</div></div>
								<div class="contentOut"><div class="c-content">使用金额</div></div>
		   					</li>
		   					<c:forEach items="${list }" var="vip">
		   						<li>
			   						<div class="contentOut"><div class="c-content">${vip.statrTime }至${vip.endTime }</div></div>
									<div class="contentOut"><div class="c-content">${vip.vipTypeName }</div></div>
									<div class="contentOut"><div class="c-content">${vip.addTime }</div></div>
									<div class="contentOut"><div class="c-content">${vip.sAmount }</div></div>					
			   					</li>
		   					</c:forEach>
		   				</ul>
		   				<div id="pager"></div>
	   				</div>	   				
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<!-- 弹出层 -->
   	<div class="buyVip">
   	<form id="buyBox">
   		<div class="buy-top">
   			<div class="buy-input">
   				<div class="left-title">开始时间：</div>
   				<input type="text" class="select-time Wdate" id="startYear"  onfocus="WdatePicker({minDate: '%y-%M-%d' })" lang="请选择开始时间">
   			</div>
   			<div class="buy-input">
   				<div class="left-title">年数：</div>
   				<input type="text" id="sellYear" class="input-time numberReg" lang="请输入购买年份" maxlength="2">
   				<span>年</span>
   			</div>
   			<div class="buy-input">
   				<div class="left-title">应付金额：</div>
   				<div class="orange info"><span id="needMoney"><span>元</div>
   			</div>
   			<div class="buy-input">
   				<div class="left-title">预计时间段：</div>
   				<div class="info"><span class="beginT">1990-01-01</span>至<span class="endT"></span></div>
   			</div>
   		</div>
   		<div class="buy-bottom">
   			<input type="button" class="buy-now btn" value="立即购买">
   		</div>   		   	
   	</form>
   	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/myVIP.js"></script>
</body>
</html>