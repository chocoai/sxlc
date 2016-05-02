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
</head>
<!-- 贷后管理-------项目催收-------逾期催收 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="306" name="_index_m2"/>
				<jsp:param value="30605" name="_index_m3"/>
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
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>借款项目编号</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>借款项目名称</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>借款人</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>还款时间</span><input type="text" class="notspecial"/></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-callback">电话回访</button>
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-generate-bill">生成账单</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_overdue_collection" class="display">
									<thead>
										<tr>
											<th></th>
											<th>借款项目编号</th>
											<th>借款项目名称</th>
											<th>借款人</th>
											<th>账单金额</th>
											<th>账单期数</th>
											<th>还款时间</th>
											<th>逾期时长</th>
											<th>逾期费用</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<%
											for(int i=0;i<15;i++){
										 %>
										<tr>
											<td><input type="checkbox"></td>
											<td>0000001</td>
											<td>交电费</td>
											<td>jiuyang</td>
											<td>王书记</td>
											<td>1234455415</td>
											<td>200000</td>
											<td>12-01</td>
											<td>200000</td>
											<td>12-01</td>
										</tr>
										<%
											}
										 %>
									</tbody>
								</table>
							</div>
						</div>
						<!-- 电话回访 -->
						<!-- 生成订单 -->
					</div>
				</div>
				<!-- 尾部 -->
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
		// 这样初始化，排序将会打开
		$(function() {
			$('#table_overdue_collection').DataTable({
				"autoWidth" : true,
				//"scrollY": 500,
				//paging : false,//分页
				
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [[ 6, "desc"],[ 7, "desc"]],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 1, 2, 3, 4, 5, 8, 9]
				} // 制定列不参与排序
				],
				colReorder : false,
				"scrollX": true,
				"sScrollX" : "100%",
				"sScrollXInner" : "100%",
				"bScrollCollapse" : true
			});
		});
	</script>
</body>

</html>