<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>登录密码重置</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/securityCenter.css">
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
   					<div class="authenHeader">
	   					<span>重置密码</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<ul class="contentArea">
	   					<li class="contetnList">
	   						<label>原密码：</label>
	   						<div class="spanSamP">
	   							<input class="email password" type="password" maxlength="16">
	   							<span class="hint3 hint1">请输入您的原密码</span>
	   						</div>
	   					</li>
	   					<li class="contetnList">
	   						<label>新密码：</label>
	   						<div class="spanSamP">
	   							<input class="email newPassword" type="password" maxlength="16">
	   							<span class="hint3 hint2">请输入您的新密码</span>
	   						</div>
	   					</li>
	   					<li class="contetnList">
	   						<label>确认密码：</label>
	   						<div class="spanSamP">
	   							<input class="email okPassword" type="password" maxlength="16">
	   							<span class="hint3 hint4">请输入您的新密码</span>
	   						</div>
	   					</li>
	   					<li class="contetnList">
	   						<label>验证码：</label>
	   						<div class="phoneCode">
	   							<input class="code" type="text" lang="请输入验证码" maxlength="6">
	   							<img class="codeImg" src="resource/img/account/personalCenter/grzx_47.png">
	   						</div>
	   					</li>
	   					<li class="contetnList">
	   						<div class="btn emailBtn">确定</div>
	   					</li>
	   				</ul>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/securityCenter.js"></script>
</body>
</html>