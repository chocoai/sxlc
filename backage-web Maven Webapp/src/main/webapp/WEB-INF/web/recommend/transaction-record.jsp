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
	<title>保荐机构管理-交易记录</title>
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
			<jsp:param value="9" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-recommend.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="search">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li>
										<a class="state">展开&nbsp;<spanclass="glyphicon glyphicon-chevron-down"></span> </a>
									</li>
								</ul>
							</div>
						</div>
					<div class="panel-body">
						<form id="" class="" action="">
							<span class="con-item col-md-3 col-sm-4 col-xs-6">
								<span>交易时间段</span><input type="text" class="" placeholder="" />
							</span>
							<span class="con-item col-md-3 col-sm-4 col-xs-6">
								<span>账户类型</span><input type="text" class="departmentname" placeholder="" />
							</span>
							<span class="con-item col-md-3 col-sm-4 col-xs-6">
								<span>交易类型</span><input type="text" class="licencenum" placeholder="" />
							</span>						
							<span class="col-md-6 col-sm-12 col-xs-12">
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</span>
						</form>
					</div>
				</div>	
			</div>
			<div class="data_display">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="action_item">
							<button class="obtn glyphicon glyphicon-plus">导出</button>
							<!-- onclick="accRecharge() -->
						</div>
					</div>
					<div class="panel-body">
						<table id="table_id" class="display">
							<thead>
								<tr>
									<th class="table-checkbox"></th>
									<th>交易时间</th>
									<th>交易金额</th>
									<th>交易类型</th>
									<th>账户类型</th>
									<th>摘要</th>									
								</tr>
							</thead>
							<tbody>
								<%for (int i = 0; i < 15; i++) {%>
								<tr>
									<td class="table-checkbox"><input type="checkbox" /></td>
									<td>交易时间</td>
									<td>交易金额</td>
									<td>交易类型</td>
									<td>账户类型</td>
									<td>摘要</td>										
								</tr>
								<%}%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/recharge-record.js"></script>	
	<script type="text/javascript">
		$('#table_id').DataTable({
			scrollX:true,
			autoWidth : false,
			"aaSorting" : [ [1,2] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,3,4,5]
			} // 制定列不参与排序
			],
		});
	</script>		
</body>
</html>
