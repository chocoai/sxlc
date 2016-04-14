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
	<link rel="stylesheet" href="css/project/myLayer.css" />
</head>

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
					<li role="presentation" class="active"><a href="javascript:;">债权转让列表</a>
					</li>
				</ul>
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
									<span class="con-item"><span>债权转让申请编号</span><input type="text" class="" value="债权转让申请编号" /></span>
									<span class="con-item"><span>债权转让项目编号</span><input type="text" class="" value="债权转让项目编号" /></span>
									<span class="con-item"><span>转让会员</span><input type="text" class="" value="转让会员" /></span>
									<span class="con-item"><span>转让金额</span><input type="text" class="" value="转让金额" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
							</div>
						</div>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
					  		<div class="panel-heading">
					  			<div class="action_item">
					  				<button id="credit_assignment_exam" class="obtn glyphicon glyphicon-plus">审核</button>
									<button id="credit_assignment_end_timealong" class="obtn glyphicon glyphicon-pencil">投标结束时间延长</button>
								</div> 		
							</div>
							<div class="panel-body">
								<table id="table_credit_assignment_list" class="display">
									<thead>
										<tr>
											<th></th>
											<th>债权转让申请编号</th>
											<th>债权转让申请时间</th>
											<th>债权转让项目编号</th>
											<th>项目名称</th>
											<th>借款会员</th>
											<th>转让会员</th>
											<th>转让金额</th>
											<th>转让价格</th>
											<th>转让折扣</th>
											<th>融资进度</th>
											<th>投标结束时间</th>
											<th>转让状态</th>
										</tr>
									</thead>
								<tbody>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
										<td>未审核</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
										<td>已拒绝</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
										<td>已启用</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
										<td>已启用</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
										<td>已启用</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
										<td>已启用</td>
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
		<script src="js/project/credit_assignment_list.js"></script>
		<!-- 私用js -->
		<script type="text/javascript">
					//默认禁用搜索和排序
					/* $.extend( $.fn.dataTable.defaults, {
					    searching: true,
					    ordering:  false
					} ); */
					// 这样初始化，排序将会打开
					$(function() {
						$('#table_credit_assignment_list').DataTable({
							"autoWidth" : false,
							scrollY : 500,
							//paging : false,//分页
							//"searching" : false,
							"info" : false,//左下角信息
							//"ordering": false,//排序
							"aaSorting" : [ [ 1, "desc" ],[ 6, "desc" ],[ 7, "desc" ] ],//默认第几个排序
							"aoColumnDefs" : [
							//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
							{
								"orderable" : false,
								"aTargets" : [ 0, 2, 3, 4, 5, 8, 9, 10, 11, 12]
							} // 制定列不参与排序
							],
							colReorder : false,
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