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
    <title>营业执照认证</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/loanCertification.css">
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
	   					<span>营业执照认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
   					<div class="authenContent">
	   					<div class="authen">
			   				<ul class="inputArea">
			   					<li class="inputList">
			   						<div class="mustLabel"><span>营业执照号码：</span></div>
			   						<div class="introduceContent">1234567891</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>注册地址：</span></div>
			   						<div class="introduceContent">成都市郫县犀浦镇国林东路13-1</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>注册法人：</span></div>
			   						<div class="introduceContent">李四</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>注册资金：</span></div>
			   						<div class="introduceContent">1000万</div>
			   					</li>
			   					
			   					<li class="inputList">
			   						<div class="mustLabel"><span>经营范围：</span></div>
			   						<div class="introduceContent">e联贷网站</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>公司类型：</span></div>
			   						<div class="introduceContent">IT</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>注册时间：</span></div>
			   						<div class="introduceContent">2015-01-04</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>有效期：</span></div>
			   						<div class="introduceContent">2018-01-04</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>附件：</span></div>
			   						<div class="previewPicture"></div>
			   					</li>
			   				</ul>
	   					</div>
	   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
</body>
</html>