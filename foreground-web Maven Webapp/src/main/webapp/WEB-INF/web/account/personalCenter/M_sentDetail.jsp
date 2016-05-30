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
    <title>发件箱查看详情</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/mail.css">
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
   					<!-- 收件箱详情信息 -->
   					<div class="th" onselectstart="return false">
   						<span onclick="window.location.href='personalCenter/mail.html'">收件箱</span>
   						<span onclick="window.location.href='personalCenter/M_sent.html'" class="thClick">发件箱</span>
   						<a class="write" href="personalCenter/M_write.html">写信息</a>
   					</div>
   					<div class="inboxDetail">
   						<div class="sendDetail">
   							<div class="send"><samp>发件人：</samp>${mail.membername }</div>
   							<div class="date">
   								<samp>时间：</samp>${mail.sendDate }
   							</div>
   							<div class="titleTip">
   								<samp>标题：</samp>${mail.title }
   								<a class="backBtn" href="javascript:history.back();">返回</a>
   							</div>
   							<div class="messageDetail">
   								${mail.detail }
   							</div>
   						</div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
</body>
</html>