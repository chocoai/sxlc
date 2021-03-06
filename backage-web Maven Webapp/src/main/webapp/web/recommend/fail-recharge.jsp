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
	<title>充值失败</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/jumpPage.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="9" name="_index_m1"/>
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-finance.jsp">
				<jsp:param value="908" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<div class="failBox">
					<div class="failNotice">
						充值失败！<br/>
						原因：<%-- ${auditReturnEntity.message} --%>
					</div>
				</div>
			</div>
			<!-- 公用js -->
			<jsp:include page="../common/cm-js.jsp"></jsp:include>
			<!-- 私用js -->
		</div>
	</div>
</body>
</html>