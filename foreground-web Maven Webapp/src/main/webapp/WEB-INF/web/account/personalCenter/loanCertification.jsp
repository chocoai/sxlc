<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>借款认证</title>
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
   				<!-- 借款认证界面      胥福星      20160330 -->
   					<div class="th" onselectstart="return false">
   						<span class="thClick loanAuthen">个人认证</span>
   					</div>
   					<ul class="personalAuthen">
   						<c:forEach items="${list }" var="borr">
							<li class="td">
	   							<span class="tdFirst">${borr.typeName }</span>
	   							<span class="tdSpan">
	   							<c:if test="${borr.status == 0 }">未认证</c:if>
	   							<c:if test="${borr.status == 1 }">审核中</c:if>
	   							<c:if test="${borr.status == 2 }">已认证</c:if>
	   							<c:if test="${borr.status == 3 }">已打回</c:if>
	   							<c:if test="${borr.status == 4 }">已过期</c:if></span>
	   							<span class="link linkCheck"><a href="personalCenter/authInfo/${borr.typeId }.html">查看</a></span>
	   							<span class="link linkAuthen"><a href="personalCenter/authInfo/${borr.typeId }.html">认证</a></span>
	   							<span class="link linkAlert"><a href="personalCenter/authInfo/${borr.typeId }.html">修改</a></span>
   							</li>   						
   						</c:forEach>
   					</ul>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
</body>
</html>