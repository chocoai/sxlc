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
    <title>收件箱查看详情</title>
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
   						<span onclick="window.location.href='personalCenter/mail.html'" class="thClick">收件箱</span>
   						<span onclick="window.location.href='personalCenter/M_sent.html'">发件箱</span>
   						<a class="write" href="personalCenter/M_write.html">写信息</a>
   					</div>
   					<div class="inboxDetail">
   						<form id="receiveDetail">
   							<div class="sendDetail">
	   							<div class="send"><samp>发件人：</samp>${mail.membername }</div>
	   							<div class="date">
	   								<samp>时间：</samp>${mail.sendDate }
	   								<a class="backBtn" href="javascript:history.back();">返回</a>
	   								<a class="replayBtn">回复</a>
	   							</div>
	   							<div class="messageDetail">
	   								${mail.detail }
	   							</div>
	   							<div class="replayDetail">
	   								<div id="writeContent"></div>
	   								<div class="btn">发送</div>
	   							</div>
	   						</div>
   						</form>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/mail.js"></script>
	
	
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		$(function(){
		//编辑器实例化
			var ue1 = UE.getEditor('writeContent');
		});
	</script>
	
</body>
</html>