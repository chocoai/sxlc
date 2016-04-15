<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>收件箱查看详情</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/mail.css">
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
   					<!-- 收件箱详情信息 -->
   					<div class="th" onselectstart="return false">
   						<span class="thClick">收件箱</span>
   						<span onclick="window.location.href='mail.html'">发件箱</span>
   						<a class="write" href="M_write.html">写信息</a>
   					</div>
   					<div class="inboxDetail">
   						<div class="sendDetail">
   							<div class="send"><samp>发件人：</samp>理财达人小张</div>
   							<div class="date">
   								<samp>时间：</samp>2015-12-12 20:12:20
   								<a class="backBtn" href="javascript:history.back();">返回</a>
   								<a class="replayBtn">回复</a>
   							</div>
   							<div class="messageDetail">
   								<p class="bold">Hi,xxx：</p>
   								<p>不会理财？你还敢称土豪！上四象金融，秒变土豪不是梦！</p>
   							</div>
   							<div class="replayDetail">
   								<div class="writeContent"></div>
   								<div class="btn">发送</div>
   							</div>
   						</div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/mail.js"></script>
</body>
</html>