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
<!-- 	贷后管理---------成交项目列表-----------还款详情 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<%-- <jsp:include page="../common/cm-addr.jsp"></jsp:include> --%>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							</div>
						<div class="panel-body">
						<table id="table_deal_list_pay_detail" class="display">
							<thead>
								<tr>
									<th>期数</th>
									<th>计划还款日</th>
									<th>应还本金</th>
									<th>应还利息</th>
									<th>应还罚息</th>
									<th>应还小计</th>
									<th>实际还款日</th>
									<th>实还本金</th>
									<th>实还利息</th>
									<th>实还罚息</th>
									<th>未还本金</th>
									<th>未还利息</th>
									<th>未还罚息</th>
								</tr>
							</thead>
							<tbody>
							<%
								for(int i = 0 ; i <10 ; i++){
							 %>
								<tr>
									<td>01-22</td>
									<td>jiuyang</td>
									<td>九阳股份</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
									<td>12万</td>
									<td>已还</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
									<td>12万</td>
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
					$('#table_deal_list_pay_detail').DataTable({
						"autoWidth" : true,
						"scrollY": 500,
						//paging : false,//分页
						
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
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