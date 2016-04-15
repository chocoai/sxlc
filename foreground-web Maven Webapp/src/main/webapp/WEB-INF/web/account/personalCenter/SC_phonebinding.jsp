<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>手机绑定</title>
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
	   					<span>修改手机号</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<ul class="contentArea">
	   					<li class="contetnList">
	   						<label>原手机号码：</label>
	   						<input class="email phoneBind numberReg" type="text" lang="请输入您的原手机号" maxlength="11">
	   					</li>
	   					<li class="contetnList">
	   						<label>新手机号码：</label>
	   						<input class="email newphone numberReg" type="text" lang="请输入您的新手机号" maxlength="11" >
	   					</li>
	   					<li class="contetnList">
	   						<label>验证码：</label>
	   						<div class="phoneCode">
	   							<input class="code" type="text" lang="请输入验证码" maxlength="6" >
	   							<img class="codeImg" src="resource/img/account/personalCenter/grzx_47.png">
	   						</div>
	   					</li>
	   					<li class="contetnList">
	   						<label>邮箱验证码：</label>
	   						<div class="dynamicValidationPhone">
	   							<input class="code codeGet" type="text" lang="请输入验证码" maxlength="6" >
	   							<div class="codeBtn">获取验证码</div>
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