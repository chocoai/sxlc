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
    <title>消息提醒</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/messageAlert.css">
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
   					<div class="messageAlert" onselectstart="return false;">
   						<div class="messageAlertH">
   							<div>消息提醒设置</div>
   						</div>
   						<div class="messageAlertM">
   							<ul>
   								<li>
   									<div class="messageAlertMTitle">
   										<div class="settingContent">设置内容</div>
	   									<div class="shortMessage">短信提醒</div>
	   									<div class="websiteMessage">站内信提醒</div>
	   									<div class="e-mail">邮件提醒</div>
   									</div>
   								</li>
   								<%for(int i=0;i<7;i++){ %>
   								<li>
   									<div class="messageAlertMCont">
   										<div class="settingContent">增加充值结果提醒</div>
	   									<div class="shortMessage">
	   										<label class="labelUnSelect"></label>
	   									</div>
	   									<div class="websiteMessage">
	   										<label class="labelSelect"></label>
	   									</div>
	   									<div class="e-mail">
	   										<label class="labelSelect"></label>
	   									</div>
   									</div>
   								</li>
   								<%} %>
   							</ul>
   						</div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/messageAlert.js"></script>
</body>
</html>