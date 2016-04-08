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
<!-- 贷后管理-------项目催收-------催收已还账单 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class=""><a href="web/project/soon_due_bill.jsp">即将到期账单</a>
					</li>
					<li role="presentation" class=""><a href="web/project/overdue_collection.jsp">逾期催收</a>
					</li>
					<li role="presentation" class="active"><a href="web/project/collection_has_bill.jsp">催收已还账单</a>
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
									<span class="con-item"><span>借款项目编号</span><input type="text" class="" value="借款项目编号" /></span>
									<span class="con-item"><span>借款项目名称</span><input type="text" class="" value="借款项目名称" /></span>
									<span class="con-item"><span>借款人</span><input type="text" class="" value="借款人" /></span>
									<span class="con-item"><span>账单编号</span><input type="text" class="" value="账单编号" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="collection_has_bill_detail" class="obtn glyphicon glyphicon-plus">账单详情</button>
						  			<button id="collection_has_bill_prodetail" class="obtn glyphicon glyphicon-plus">借款项目详情</button>
								</div>
							</div>
						<div class="panel-body">
						<table id="table_collection_has_bill" class="display">
							<thead>
								<tr>
									<th></th>
									<th>借款项目编号</th>
									<th>借款项目名称</th>
									<th>借款人</th>
									<th>账单编号</th>
									<th>账单金额</th>
									<th>账单期数</th>
									<th>还款时间</th>
									<th>实际还款时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
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
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>交电费</td>
									<td>jiuyang</td>
									<td>王书记</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>200000</td>
									<td>12-01</td>
									<td>12-01</td>
								</tr>
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
	<script src="js/project/loan_intention_2.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
				//默认禁用搜索和排序
				/* $.extend( $.fn.dataTable.defaults, {
				    searching: true,
				    ordering:  false
				} ); */
				// 这样初始化，排序将会打开
				$(function() {
					$('#table_collection_has_bill').DataTable({
						"autoWidth" : true,
						"scrollY": 500,
						//paging : false,//分页
						
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [[ 5, "desc"],[ 7, "desc"],[ 8, "desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 1, 2, 3, 4, 6, 9]
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