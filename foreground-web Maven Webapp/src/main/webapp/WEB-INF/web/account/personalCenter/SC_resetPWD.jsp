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
    <title>登录密码重置</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/securityCenter.css">
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
   					<div class="authenHeader">
	   					<span>重置密码</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<form id="securityCheck1">
		   				<ul class="contentArea">
		   					<li class="contetnList">
		   						<label>原密码：</label>
		   						<div class="spanSamP">
		   							<input class="email password" type="password" datatype="regpass" maxlength="16">
		   							<span class="hint3 hint1">请输入您的原密码</span>
		   						</div>
		   					</li>
		   					<li class="contetnList">
		   						<label>新密码：</label>
		   						<div class="spanSamP">
		   							<input class="email newPassword" type="password" name="resetPassword" datatype="regpass" maxlength="16">
		   							<span class="hint3 hint2">请输入您的新密码</span>
		   						</div>
		   					</li>
		   					<li class="contetnList">
		   						<label>确认密码：</label>
		   						<div class="spanSamP">
		   							<input class="email okPassword" type="password" recheck="resetPassword" datatype="regpass" maxlength="16">
		   							<span class="hint3 hint4">请确认您的新密码</span>
		   						</div>
		   					</li>
		   					<li class="contetnList">
		   						<label>验证码：</label>
		   						<div class="phoneCode">
		   							<input class="code imgCode" type="text" lang="请输入验证码" datatype="imgcode" maxlength="6">
		   							<img class="codeImg" src="authImage.html?gk=<%=System.currentTimeMillis()%>">
		   						</div>
		   					</li>
		   					<li class="contetnList">
		   						<div class="btn emailBtn phoneSubmit">确定</div>
		   					</li>
		   				</ul>
	   				</form>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/securityCenter.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/SC_resetPWD.js"></script>
</body>
</html>