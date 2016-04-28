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
    <title>找回密码成功</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/loginRegister/forgetPWD.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
    <!-- 在这里加入页面内容 -->
    <!--伍成然2016-3-27  -->
    <div class="main">
   		<div class="forgetPWD-box clearfix">
   		<div class="box-head">找回密码</div>
   		<div class="input-info input-group1 on">
   			<div class="successCC">
		   		<div class="register-box">
		   			<div class="successBox">
		   				<div class="congratulation">密码修改成功!</div>
		   				<div class="tiss">祝您在四象金融愉快！请<a href="login.html">重新登录</a>  </div>
		   			</div>
		   		</div>
		   	</div>
   		</div>
    </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/loginRegister/forgetPWD.js"></script>
</body>
</html>