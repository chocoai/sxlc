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
<!-- 项目类型--------查询展示产品类型 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="top_menu_index"/>
				<jsp:param value="项目管理" name="loc3" />
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp"></jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="javascript:;">查询展示产品类型</a>
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
									<span class="con-item"><span>类型名称</span><input type="text" class="" value="测试值" /></span>
									<span class="con-item"><span>状态</span><input type="text" class="" value="测试值" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<!-- <div class="i-fl data_title">数据列表</div> -->
					  		<div class="action_item">
					  			<button id="add_type" class="obtn glyphicon glyphicon-plus">添加</button>
								<button id="modify_type" class="obtn glyphicon glyphicon-pencil">修改</button>
								<button id="modify_state" class="obtn glyphicon glyphicon-ok-circle">停用/启用</button>
							</div> 
						</div>
						<div class="panel-body">
							<table id="table_pro_type" class="display">
								<thead>
									<tr>
										<th></th>
										<th>类型名称</th>
										<th>项目借款额度范围</th>
										<th>最小投资金额</th>
										<th>年化利率范围</th>
										<th>项目期限范围</th>
										<th>状态</th>
										<th>项目类型简介</th>
										<th>产品所需认证项</th>
										<th>产品展示小图标</th>
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
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>信用贷</td>
										<td>20万~40万</td>
										<td>20万</td>
										<td>4%</td>
										<td>20天</td>
										<td class="current_state">已启用</td>
										<td>简介:</td>
										<td>无</td>
										<td>img</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="nav-tabs-con">2</div>
			<div class="nav-tabs-con">3</div>
			<!-- 尾部 -->
			
		</div>
		<!-- 公用js -->
		<jsp:include page="../common/cm-js.jsp"></jsp:include>
		<script type="text/javascript" src="js/project/pro_type.js"></script>
		<!-- 私用js -->
		<script type="text/javascript">
					//默认禁用搜索和排序
					/* $.extend( $.fn.dataTable.defaults, {
					    searching: true,
					    ordering:  false
					} ); */
					// 这样初始化，排序将会打开
					$(function() {
						$('#table_pro_type').DataTable({
							"autoWidth" : false,
							scrollY : 500,
							//paging : false,//分页
							//"searching" : false,
							"info" : false,//左下角信息
							//"ordering": false,//排序
							"aaSorting" : [ [ 2, "desc" ] ],//默认第几个排序
							"aoColumnDefs" : [
							//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
							{
								"orderable" : false,
								"aTargets" : [ 0, 1, 3, 4, 5, 6, 7, 8, 9 ]
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