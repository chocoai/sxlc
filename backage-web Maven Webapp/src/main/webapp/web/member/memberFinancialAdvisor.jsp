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
	<title>会员分配理财顾问</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css"></link>
	<link rel="stylesheet" href="css/member/memberDetail.css" type="text/css" >
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="2" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-member.jsp">
				<jsp:param value="201" name="_index_m2"/>
				<jsp:param value="20110" name="_index_m3"/>
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
									<span class="con-item"><span>会员编号</span><input type="text" class="notspecial" id="memberNo" /></span>
									<span class="con-item"><span>会员用户名</span><input type="text" class="notspecial"  id="logName"/></span>
									<span class="con-item"><span>会员姓名</span><input type="text" class="notspecial" id="personalName" /></span>
									<span class="con-item"><span>注册时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<button type="button"  class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon examine">分配理财顾问</button>
								</div>
							</div>
							
							<div class="panel-body">
							<input type="hidden" id="memberType" >
								<table id="table_id" class="display">
									<thead>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
							
						</div>
					</div>
					
					<div class="w-content planer-poster">
						<div class="data_display">
							<div class="selectMember">
								<span><samp>选择会员：</samp><label id="memberLogName"></label></span>
								<span><samp>姓名：</samp><label id="memberName"></label></span>
							</div>
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
											<span class="con-item"><span>姓名</span><input type="text" class="notspecial"  id="realName"/></span>
											<span class="con-item"><span>编号</span><input type="text" class="notspecial"  id="memberNop" /></span>
											<span class="con-item"><span>手机号</span><input type="text" class="notspecial" id="phone" /></span>
											<button type="button"  class="obtn obtn-query glyphicon glyphicon-search1">查询</button>
										</form>
								  	</div>
							 	</div>
							 </div>
							<div class="panel-body">
							<input type="hidden" id="memberType" value="0">
								<table id="table_planer" class="display">
									<thead>
									</thead>
									<tbody>
									</tbody>
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
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/member.js"></script>
	<script type="text/javascript" src="js/member/adviserFinancial/adviserMember.js"></script>
</body>