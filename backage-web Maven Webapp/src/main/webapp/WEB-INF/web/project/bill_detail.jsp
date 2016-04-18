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
<!-- 项目管理---------催收已还账单-----账单详情 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
						</div>
						<div class="panel-body">
							<table id="table_id" class="display ">
								<thead>
									<tr>
										<th>借款项目编号</th>
										<th>账单编号</th>
										<th>借款项目名称</th>
										<th>借款人</th>
										<th>账单金额</th>
										<th>账单期数</th>
										<th>实际还款时间</th>
										<th>逾期时长</th>
										<th>逾期费用</th>
										<th>账单展示</th>
									</tr>
								</thead>
								<tbody>
									<%
										for(int i=0;i<6;i++){
									 %>
									<tr>
										<td>0000001</td>
										<td>交电费</td>
										<td>jiuyang</td>
										<td>王书记</td>
										<td>1234455415</td>
										<td>200000</td>
										<td>12-01</td>
										<td>200000</td>
										<td>12-01</td>
										<td>账单展示</td>
									</tr>
									<%
										}
									 %>
								</tbody>
							</table>
						</div>
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
		/* 账单详情 */
		$(function() {
			$('#table_id').DataTable({
				"autoWidth" : true,
				//"scrollY": 500,
				//paging : false,//分页
				
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
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