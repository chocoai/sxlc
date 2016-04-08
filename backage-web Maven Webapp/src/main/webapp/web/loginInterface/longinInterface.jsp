<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>后台登陆界面</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" type="text/css" href="css/longinInterface.css">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="longinTop">
			<div class="loginTopContent">
				<div class="longinTopFont longinTopImage eXingLogo i-fl">
					<span class="">e兴金融后台管理系统</span>
				</div>
				<div class="loginTopR i-fl">
					<div class="longinTopStyle longinTopImage productLogo">
						<h2>四象金融系统</h2>
						<span>-中国最安全的互联网金融系统服务商-</span>
					</div>
				</div>
			</div>
		</div>
		<div class="longinContent">
			<div class="administratorLoginCunt">
				<div class="loginW">
					<div class="administratorLogin">管理员登录</div>
					<form action="">
						<div class="admUser">
							<i class="loginIcon user"></i>
							<input type="text" placeholder="用户名或者手机号">
						</div>
						<div class="admPasword">
							<i class="loginIcon pwd"></i>
							<input type="text" placeholder="密码">
						</div>
						<div class="admPhoneCode">
							<i class="loginIcon phone"></i>
							<input type="text" placeholder="手机验证码">
							<span>获取验证码</span>
						</div>
						<div class="admForgetPassword">
							<a href="javascript:;">忘记密码？</a>
						</div>
						<div class="admRest">
							<button type="button" class="admRestL btn">登录</button>
							<button type="button" class="admRestT btn">重置</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="longinBottom">
			<p>Copyright(c)蜀ICP备10201230号-1 成都四象联创科技有限公司  .All rights reserved.</p>
			<p>技术支持 ：成都四象联创客户有限公司</p>
		</div>
	</div>
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/loginInterface.js"></script>
</body>