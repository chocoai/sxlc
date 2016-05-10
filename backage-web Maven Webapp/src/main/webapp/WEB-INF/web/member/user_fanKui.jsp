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
	<title>客户意见反馈</title>
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
				<jsp:param value="203" name="_index_m2"/>
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
									<div>
										<span class="con-item textRight"><span>会员编号</span><input type="text" class="notspecial" /></span>
										<span class="con-item textRight"><span>会员用户名</span><input type="text" class="notspecial" /></span>
										<span class="con-item textRight"><span>会员姓名</span><input type="text" class="notspecial" /></span>
									</div>
									<div>
										<span class="con-item textRight"><span>反馈时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
										<span class="con-item textRight"><span>处理操作管理员</span><input type="text" class="notspecial" /></span>
									</div>
									<div>
										<span class="con-item textRight"><span>处理时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
										<span class="con-item textRight"><span>是否处理</span><select><option>已处理</option><option>未处理</option></select></span>
										<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									</div>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon examine" onclick="">标注处理</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="table_id" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>反馈意见时间</th>
											<th>会员编号</th>
											<th>会员用户名</th>
											<th>会员姓名</th>
											<th>意见内容</th>
											<th>是否处理</th>
											<th>处理备注</th>
											<th>处理操作管理员</th>
											<th>处理时间</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 14; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>2015-05-01 12:00</td>
											<td>1001</td>
											<td>小豆豆</td>
											<td>吴晗</td>
											<td>钱多多...</td>
											<td>已处理</td>
											<td>已处理</td>
											<td>程序员</td>
											<td>2015-05-01 13:00</td>
										</tr>
										<%
											}
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>2015-05-01 12:00</td>
											<td>1001</td>
											<td>小涵涵</td>
											<td>吴晗</td>
											<td>钱多多...</td>
											<td>已处理</td>
											<td>已处理</td>
											<td>程序员</td>
											<td>2015-05-01 13:00</td>
										</tr>
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
	<script type="text/javascript">
		$(function(){
			$('#table_id').DataTable({
				"scrollX":true,
				"aaSorting" : [ [1,9, "desc"]],
				"aoColumnDefs" : [
				{
					"orderable" : false,
					"aTargets" : [0,2,3,4,5,6,7,8]
				} 
				],
			});
		});
	</script>
</body>