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
	<link rel="stylesheet" href="css/project/investing.css" type="text/css">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<%-- <jsp:include page="../common/cm-addr.jsp"></jsp:include> --%>
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
									<span class="con-item"><span>投资完成时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>会员用户名</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>会员姓名</span><input type="text" class="notspecial"/></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							</div>
						<div class="panel-body">
						<table id="table_tobe_lending_invest_record" class="display">
							<thead>
								<tr>
									<th>投资完成时间</th>
									<th>会员用户名</th>
									<th>会员姓名</th>
									<th>投资金额</th>
									<th>使用红包抵扣金额</th>
									<th>使用代金券抵扣金额</th>
									<th>是否使用返现券</th>
								</tr>
							</thead>
							<tbody>
							<% 
								for(int i = 0 ; i < 10 ; i++){
							 %>
								<tr>
									<td>01-22</td>
									<td>jiuyang</td>
									<td>九阳股份</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
								</tr>
							<%
								}
							 %>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		
			<!-- 尾部 -->
			
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
				//默认禁用搜索和排序
				/* $.extend( $.fn.dataTable.defaults, {
				    searching: true,
				    ordering:  false
				} ); */
				// 这样初始化，排序将会打开
				$(function() {
					$('#table_tobe_lending_invest_record').DataTable({
						"autoWidth" : true,
						"scrollY": 500,
						//paging : false,//分页
						
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [[ 0, "desc"],[ 3, "desc"],[ 4, "desc"],[ 5, "desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 1, 2, 6]
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
		</div>
	</div>
</body>

</html>