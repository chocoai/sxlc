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
    <title>手机修改</title>
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
	   					<span>修改手机号</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<form id="securityCheck1">
	   					<ul class="contentArea">
		   					<li class="contetnList">
		   						<label>原手机号码：</label>
		   						<input class="email phoneBind" type="text" lang="请输入您的原手机号" datatype="zPhone" maxlength="11">
		   					</li>
		   					<li class="contetnList">
		   						<label>新手机号码：</label>
		   						<input class="email newphone" type="text" lang="请输入您的新手机号" datatype="zPhone" maxlength="11" >
		   					</li>
		   					<li class="contetnList">
		   						<label>验证码：</label>
		   						<div class="phoneCode">
		   							<input class="code imgCode" type="text" lang="请输入验证码" datatype="imgcode" maxlength="6" >
		   							<img class="codeImg" src="authImage.html?gk=<%=System.currentTimeMillis()%>">
		   						</div>
		   					</li>
		   					<li class="contetnList">
		   						<label>手机验证码：</label>
		   						<div class="dynamicValidationPhone">
		   							<input class="code codeGet dynamicCode" type="text" lang="请输入验证码" datatype="Z6" maxlength="6" >
		   							<div class="codeBtn">获取验证码</div>
		   						</div>
		   					</li>
		   					<li class="contetnList">
		   						<div class="btn emailBtn phoneSubmit qwertyu">确定</div>
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
	<script type="text/javascript" src="js/account/personalCenter/SC_phonebinding.js"></script>
</body>
</html>