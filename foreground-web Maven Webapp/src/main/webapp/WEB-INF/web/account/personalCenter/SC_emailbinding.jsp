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
    <title>邮箱绑定</title>
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
	   					<span>邮箱绑定</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<form id="securityCheck1">
		   				<ul class="contentArea">
		   					<li class="contetnList">
		   						<label>邮箱号码：</label>
		   						<input class="email entryEmail" type="text" lang="请输入您的邮箱号" datatype="email" maxlength="25">
		   					</li>
		   					<li class="contetnList">
		   						<label>验证码：</label>
		   						<div class="phoneCode">
		   							<input class="code imgCode" type="text"  lang="请输入验证码" datatype="imgcode"  maxlength="6">
		   							<img class="codeImg" src="authImage.html?gk=<%=System.currentTimeMillis()%>">
		   						</div>
		   					</li>
		   					<li class="contetnList">
		   						<label>邮箱验证码：</label>
		   						<div class="dynamicValidation">
		   							<input class="code codeGet dynamicCode" type="text" lang="请输入验证码" datatype="Z6" maxlength="6">
		   							<div class="codeBtn disabled">获取验证码</div>
		   						</div>
		   					</li>
		   					<li class="contetnList">
		   						<div class="btn emailBtn email-btn phoneSubmit">立即绑定</div>
		   					</li>
		   				</ul>
	   				</form>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<!--弹出层伍成然2016-4-6  -->
   	<div class="emailChange">
   		邮箱修改成功!
   	</div>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/securityCenter.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/SC_emailbinding.js"></script>
</body>
</html>