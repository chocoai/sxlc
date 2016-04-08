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
	<link rel="stylesheet" href="css/project/myLayer.css">
</head>
<!-- 项目发布--------列表信息查询展示 -->
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
			<div class="right_col i-b2" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="javascript:;">列表信息查询</a>
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
									<span class="con-item"><span>项目名称</span><input type="text" class="" value="项目名称" /></span>
									<span class="con-item"><span>项目审批通过时间范围</span><input type="date" class="" value="项目审批通过时间范围" /></span>
									<span class="con-item"><span>项目申请编号</span><input type="text" class="" value="项目申请编号" /></span>
									<span class="con-item"><span>项目编号</span><input type="text" class="" value="项目编号" /></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="" value="借款人用户名" /></span>
									<span class="con-item"><span>借款人编号</span><input type="text" class="" value="借款人编号" /></span>
									<span class="con-item"><span>借款人名称</span><input type="text" class="" value="借款人名称" /></span>
									<span class="con-item"><span>状态</span><input type="text" class="" value="状态" /></span>
									<span class="con-item"><span>项目发布时间范围</span><input type="date" class="" value="项目发布时间范围" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
									<!-- <form class="form-inline" name="search">
										<div class="form-group">
										    <label for="pro_name">项目名称:</label>
										    <input type="text" class="form-control" id="pro_name" name="pro_name" placeholder="项目名称">
										</div>
										<div class="form-group">
									    	<label for="sure_timeLine">项目审批通过时间范围:</label>
									    	<input type="date" class="form-control" id="sure_time_begin" name="sure_time_begin" placeholder="起始时间">
									    	<input type="date" class="form-control" id="sure_time_end" name="sure_time_end" placeholder="结束时间">
										</div>
										<div class="form-group">
										    <label for="pro_exam_num">项目申请编号:</label>
										    <input type="text" class="form-control" id="pro_exam_num" name="pro_exam_num" placeholder="项目申请编号">
										</div>
										<div class="form-group">
										    <label for="pro_num">项目编号:</label>
										    <input type="text" class="form-control" id="pro_num" name="pro_num" placeholder="项目编号">
										</div>
										<div class="form-group">
										    <label for="loan_name">借款人用户名:</label>
										    <input type="text" class="form-control" id="loan_name" name="loan_name" placeholder="借款人用户名">
										</div>
										<div class="form-group">
										    <label for="loan_num">借款人编号:</label>
										    <input type="text" class="form-control" id="loan_num" name="loan_num" placeholder="借款人编号">
										</div>
										<div class="form-group">
										    <label for="loan_user">借款人名称:</label>
										    <input type="text" class="form-control" id="loan_user" name="loan_user" placeholder="借款人名称">
										</div>
										<div class="form-group">
										    <label for="state">状态:</label>
										    <input type="text" class="form-control" id="state" name="state" placeholder="状态">
										</div>
										<div class="form-group">
									    	<label for="post_timeLine">项目发布时间范围:</label>
									    	<input type="date" class="form-control" id="post_time_begin" name="post_time_begin" placeholder="起始时间">
									    	<input type="date" class="form-control" id="post_time_end" name="post_time_end" placeholder="结束时间">
										</div>
										<button type="button" class="btn btn-default search_btn">查询</button>
									</form> -->
							</div>
						</div>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
					  		<div class="panel-heading">
					  			<div class="action_item">
					  				<button id="post" class="obtn glyphicon glyphicon-plus">发布</button>
									<button id="refuse" class="obtn glyphicon glyphicon-pencil">拒绝</button>
									<button id="post_pro_detail" class="obtn glyphicon glyphicon-trash">项目详情</button>
									<button id="end_time_along" class="obtn glyphicon glyphicon-trash">项目借款结束日期延长</button>
								</div> 		
						  		<!-- <div class="i-fr action_item">
						  			<ul class="list_item list-inline">
										<li id="post">
											<span>发布</span>
										</li>
										<li id="refuse">
											<span>拒绝</span>
										</li>
										<li  id="post_pro_detail">
											<span>项目详情</span>
										</li>
										<li  id="end_time_along">
											<span>项目借款结束日期延长</span>
										</li>
									</ul>
								</div>  -->
							</div>
							<div class="panel-body">
								<table id="table_post_list" class="display">
									<thead>
										<tr>
											<th></th>
											<th>项目名称</th>
											<th>项目审批通过日期</th>
											<th>项目申请编号</th>
											<th>项目编号</th>
											<th>借款人编号</th>
											<th>借款人用户名</th>
											<th>借款人名称</th>
											<th>产品类型</th>
											<th>借款期限</th>
											<th>借款金额</th>
											<th>年化利率</th>
											<th>状态</th>
											<th>项目发布时间</th>
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
		<script src="js/project/post_list.js"></script>
		<!-- 私用js -->
		<script type="text/javascript">
					//默认禁用搜索和排序
					/* $.extend( $.fn.dataTable.defaults, {
					    searching: true,
					    ordering:  false
					} ); */
					// 这样初始化，排序将会打开
					$(function() {
						$('#table_post_list').DataTable({
							"autoWidth" : false,
							scrollY : 500,
							//paging : false,//分页
							//"searching" : false,
							"info" : false,//左下角信息
							//"ordering": false,//排序
							"aaSorting" : [ [ 2, "desc" ],[ 10, "desc" ],[ 13, "desc" ] ],//默认第几个排序
							"aoColumnDefs" : [
							//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
							{
								"orderable" : false,
								"aTargets" : [ 0, 1, 3, 4, 5, 6, 7, 8, 9, 11, 12 ]
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