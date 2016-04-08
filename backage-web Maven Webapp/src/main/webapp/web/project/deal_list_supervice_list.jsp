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
<!-- 贷后管理---------成交项目列表-------贷后监管-------列表展示 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="web/project/deal_pro_list.jsp">列表展示信息</a>
					</li>
				</ul>
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
									<span class="con-item"><span>添加时间范围</span><input type="text" class="" value="添加时间范围" /></span>
									<span class="con-item"><span>产生时间范围</span><input type="text" class="" value="产生时间范围" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="supervice_list_add_msg" class="obtn glyphicon glyphicon-plus">添加</button>
						  			<button id="supervice_list_see_msg" class="obtn glyphicon glyphicon-plus">查看</button>
						  			<button id="supervice_list_del_msg" class="obtn glyphicon glyphicon-plus">删除</button>
								</div>
							</div>
						<div class="panel-body">
						<table id="table_deal_list" class="display">
							<thead>
								<tr>
									<th></th>
									<th>添加时间</th>
									<th>摘要</th>
									<th>详细描述</th>
									<th>产生时间</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
								</tr>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
								</tr>
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
	<script src="js/project/deal_list_supervice_list.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
				//默认禁用搜索和排序
				/* $.extend( $.fn.dataTable.defaults, {
				    searching: true,
				    ordering:  false
				} ); */
				// 这样初始化，排序将会打开
				$(function() {
					$('#table_deal_list').DataTable({
						"autoWidth" : false,
						"scrollY": 500,
						//paging : false,//分页
						
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [[ 1, "desc"],[ 4, "desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 2, 3]
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