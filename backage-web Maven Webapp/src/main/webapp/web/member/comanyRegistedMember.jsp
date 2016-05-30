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
	<title>会员管理-企业会员-注册会员</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css"></link>
	<link rel="stylesheet" href="css/member/companyMembers.css" type="text/css" >
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
				<jsp:param value="202" name="_index_m2"/>
				<jsp:param value="20203" name="_index_m3"/>
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
									<div>
										<span class="con-item"><span>用户名</span><input type="text" name="user_Name" id="user_Name" class="notspecial" /></span>
										<span class="con-item"><span>营业执照号</span><input type="text" id="id_card" class="notspecial" /></span>
										<span class="con-item"><span>企业名称</span><input type="text" name="member_Name" id="member_Name" class="notspecial" /></span>
									</div>
									<div>
										<span class="con-item"><span>手机号</span><input type="text" name="phone_Num" id="phone_Num" class="notspecial" /></span>
										<span class="con-item"><span>注册时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
										<span class="con-item"><span>注册客户端</span><input type="text" class="notspecial"  id="regClient"/></span>
										<button  type="button"  class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									</div>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon examineRegister" onclick="companyDetailView();">查看会员详情</button>
									
									<button class="obtn glyphicon" onclick="messageSendPer('发送信息','web/member/allMembers/per-messageSend.jsp','2');">发送消息</button>
								</div>
							</div>
							
							<div class="panel-body">
							<input type="hidden" name="memberType" id="memberType" value="1">
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
			</div>
		</div>
	</div>
	
		<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/member.js"></script>
	<script type="text/javascript" src="js/member/companyMembers.js"></script>
	<script type="text/javascript" src="js/member/registermember.js"></script>
</body>