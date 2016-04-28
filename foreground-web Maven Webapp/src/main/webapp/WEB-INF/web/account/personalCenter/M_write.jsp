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
    <title>写信息</title>
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
   					<div class="authenHeader">
	   					<span>写信息</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<form id="receiveDetail">
		   				<div class="writeDetail">
		   					<div class="resiveDiv">
		   						<label>收件人：</label>
		   						<input class="resiver" type="text" datatype="email" lang="请输入收件人邮箱" maxlength="30">
		   					</div>
		   					<div class="resiveDiv">
		   						<label>标题：</label>
		   						<input class="resiverTitle" datatype="titleRemarks" type="text" lang="标题限定长度为1到40个字" maxlength="40">
		   						<span class="float">40/40</span>
		   					</div>
		   					<div class="resiveDiv">
		   						<label>正文：</label>
		   						<div id="resiverText" maxlength="200"></div>
		   						<span class="float">200/200</span>
		   					</div>
		   					<div class="resiveDiv codeDiv">
		   						<label>验证码：</label>
		   						<div class="phoneCode">
		   							<input class="resiverCode code" datatype="imgcode" type="text">
		   							<img class="codeImg" src="resource/img/account/personalCenter/grzx_47.png" >
		   						</div>
		   					</div>
		   					<div class="btn sentSubmit">发送</div>
		   				</div>
		   			</form>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/mail.js"></script>
	
	
	
	<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		$(function(){
		//编辑器实例化
			var ue1 = UE.getEditor('resiverText');
		});
	</script>
</body>
</html>