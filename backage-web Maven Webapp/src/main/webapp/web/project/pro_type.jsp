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
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" >
	<link rel="stylesheet" href="css/upload.css" >
	<link rel="stylesheet" href="css/project/pro_type.css" type="text/css">
	<link rel="stylesheet" href="plugs/My97DatePicker/skin/WdatePicker.css" type="text/css">
</head>
<!-------- 项目类型------- -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="top_menu_index"/>
				<jsp:param value="项目管理" name="loc3" />
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp"></jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span></a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>类型名称</span><input type="text" class="notspecial"/></span>
									<span class="con-item">
										<span>状态</span>
										<select id="statu">
											<option value="">全部</option>
											<option value="1">启用</option>
											<option value="0">停用</option>
										</select>
									</span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<!-- <div class="i-fl data_title">数据列表</div> -->
					  		<div class="action_item">
					  			<button class="obtn glyphicon glyphicon-plus" onclick="addProType()">添加</button>
								<button class="obtn glyphicon glyphicon-pencil" onclick="modProType()">修改</button>
							</div> 
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		</div>
		</div>
		<!-- 公用js -->
		<jsp:include page="../common/cm-js.jsp"></jsp:include>
		<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
		<script type="text/javascript" src="plugs/ueditor/lang/zh-cn/zh-cn.js"></script>	
		<script type="text/javascript" src="js/valid.js"></script>	
		<script type="text/javascript" src="plugs/My97DatePicker/WdatePicker.js"></script>
		<!-- 私用js -->
		<script type="text/javascript" src="js/project/pro_type.js"></script>
</body>

</html>