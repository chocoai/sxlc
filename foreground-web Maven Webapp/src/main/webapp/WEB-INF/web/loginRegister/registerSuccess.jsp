<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
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
    <title>注册成功</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/loginRegister/register.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
    <!-- 在这里加入页面内容 -->
    <!--伍成然2016-3-27  -->
   	<div class="main">
   		<!--注册框  -->
   		<div class="register-box">
   			<div class="successBox">
   				<div class="congratulation">恭喜您注册成功！</div>
   				<div class="toPC">去个人中心</div>
   				<div class="toIND">回到首页</div>
   			</div>
			
			
   		</div>
   		<div class="photo">
			<img src="resource/img/loginRegister/grzc1_01.png" class="image1">
			<img src="resource/img/loginRegister/grzc1_04.png" class=image2>
		</div>
   	</div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" src="js/common/valid.js"></script>
	<script type="text/javascript" src="js/loginRegister/register.js"></script>
	<script type="text/javascript" src="js/loginRegister/md5.js"></script>
</body>
</html>