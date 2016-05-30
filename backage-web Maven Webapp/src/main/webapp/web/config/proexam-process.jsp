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
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" type="text/css"></link>
</head>
<!-- 配置中心--------审批流程配置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="608" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class=""><a href="web/config/proexam-point.jsp">审批活动点配置</a>
					</li>
					<li role="presentation" class="active"><a href="web/config/proexam-process.jsp">审批流程配置</a>
					</li>
				</ul>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<div class="action_item">
					  			<button id="pro_allocation" class="obtn glyphicon glyphicon-plus obtn-proexam-point-add" type="button">添加</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
					
				</div>
			</div>
			<!-- 尾部 -->
	</div>
		<!-- 添加审批点配置 -->
	<div class="w-content ishow proexam-point-add">
		<!-- <div class="search">
			<div class="panel panel-success">
				<div class="panel-heading">
					<div class="i-fl search_title">条件查询</div>
					<div class="i-fr action_item">
						<ul class="list_item list-inline">
							<li><a class="state">展开&nbsp;<span
									class="glyphicon glyphicon-chevron-down"></span> </a>
							</li>
						</ul>
					</div>
				</div>
				<div class="panel-body">
					<form id="" class="" action="">
						<span class="con-item">
							<span>活动点名称</span><input type="text" class="" id="auth" placeholder=""/>
						</span>
						<span class="">
							<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
						</span>
					</form>
				</div>
			</div>
		</div> -->
		<div class="panel-body">
			<table id="addproexamexam" class="display">
				<thead>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/config/proexam-process.js"></script>
		</div>
	</div>
</body>

</html>