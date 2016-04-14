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
			<title>产品后台首页</title>
			<!-- 公用meta -->
			<jsp:include page="../common/top-meta.jsp"></jsp:include>
			<!-- 私用meta -->
			<!-- 公用css -->
			<jsp:include page="../common/cm-css.jsp"></jsp:include>
			<!-- 私用css -->
		</head>

		<body class="nav-md">
			<div class="container body">
				<div class="main_container">
					<!-- 头部 -->
					<jsp:include page="../common/cm-top.jsp">
						<jsp:param value="2" name="top_menu_index" />
					</jsp:include>
					<!-- 左侧菜单 -->
					<jsp:include page="../common/cm-left-menu.jsp"></jsp:include>
					<!-- 头部导航 -->
					<jsp:include page="../common/cm-addr.jsp"></jsp:include>

					<!-- 主要内容 -->
					<div class="right_col" role="main">
						<div class="row tile_count right_index_department">
							<div class="search_section">
								测试页
							</div>		
						</div>
					</div>
				</div>
			</div>
			<!-- 公用js -->
			<jsp:include page="../common/cm-js.jsp"></jsp:include>
			<!-- 私用js -->
		</body>

		</html>