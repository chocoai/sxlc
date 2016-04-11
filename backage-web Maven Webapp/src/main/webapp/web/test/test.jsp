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
	<title>财务管理</title>
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
				<jsp:param value="11" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp"></jsp:include>
			<!-- 地址导航 -->
			<jsp:include page="../common/cm-addr.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col i-b2" role="main">
				<div class="search">
					<div class="panel panel-success">
					  <div class="panel-heading">
							<div class="i-fl search_title">查询内容</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li>
										<span class="glyphicon glyphicon-search"></span>
										<span>查询</span>
									</li>
									<li>
										<span class="glyphicon glyphicon-search"></span>
										<span>导入</span>
									</li>
									<li>
										<span class="glyphicon glyphicon-search"></span>
										<span>导出</span>
									</li>
									<a class="state">
										<span class="glyphicon glyphicon-chevron-down"></span>
									</a>
								</ul>
							</div>
					  </div>
					  <div class="panel-body">
				
					  </div>
					</div>
				</div>
				<div class="data_display">
					<div class="panel panel-success">
					  <div class="panel-heading">
							<div class="i-fl data_title">数据列表</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li>
										<span class="glyphicon glyphicon-plus"></span>
										<span>添加</span>
									</li>
									<li>
										<span class="glyphicon glyphicon-pencil"></span>
										<span>修改</span>
									</li>
									<li>
										<span class="glyphicon glyphicon-search"></span>
										<span>查询</span>
									</li>
									<li>
										<span class="glyphicon glyphicon-trash"></span>
										<span>删除</span>
									</li>
								</ul>
							</div>
					  </div>
					  <div class="panel-body">
				
					  </div>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
</body>

</html>