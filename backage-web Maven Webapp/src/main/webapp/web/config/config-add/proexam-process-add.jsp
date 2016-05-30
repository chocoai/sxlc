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
	<title>配置中心</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" type="text/css"></link>
</head>
<!-- 配置中心--------审批流程配置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../../common/cm-config.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
			<!-- 地址导航 -->
			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
						
			</div>
		 </div>
	</div>
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/config/proexam-process-add.js"></script>
