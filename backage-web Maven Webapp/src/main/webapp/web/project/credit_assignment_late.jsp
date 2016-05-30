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
	<link rel="stylesheet" href="css/project/credit_assignment_exam.css" />
</head>
<!-- 债权转让延期 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="308" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<form id="" class="" action="">
									<span class="con-item"><span>债权转让申请编号</span><input type="text" class="notspecial billNo" /></span>
									<span class="con-item"><span>债权转让项目编号</span><input type="text" class="notspecial projectNo" /></span>
									<span class="con-item"><span>转让会员</span><input type="text" class="notspecial name"  /></span>
									<span class="con-item"><span>转让金额</span><input type="text" class="notspecial TransPrincipal" /></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
							</div>
						</div>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
					  		<div class="panel-heading">
					  			<div class="action_item">
									<button id="credit_assignment_late" class="obtn glyphicon glyphicon-pencil">投标结束时间延长</button>
								</div> 		
							</div>
							<div class="panel-body">
								<table id="table_id" class="display">
							</table>
						</div>
					</div>
				</div>
				<!-- 债权转让时间延长 -->
				<div class="w-content assignment_late">
					<table style="">
						<tr>
							<td class="tt"><label class="ineed">债权转让时间延长：</label></td>
							<td class="con">
								<input type="text" class="Wdate"  id="transMaxTime" value=""  onFocus="WdatePicker({})"/>
							</td>
						</tr>
					</table>
				</div>
			</div>
		
			<!-- 尾部 -->
		</div>
		<!-- 公用js -->
		<jsp:include page="../common/cm-js.jsp"></jsp:include>
		<script src="js/project/credit_assignment.js"></script>
		<!-- 私用js -->
	</div>
</div>
</body>

</html>