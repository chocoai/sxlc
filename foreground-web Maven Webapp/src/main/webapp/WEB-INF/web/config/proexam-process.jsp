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
	<title>配置中心</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" type="text/css"></link>
</head>
<!-- 配置中心--------审批流程配置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class=""><a href="web/config/proexam-point.jsp">审批活动点配置</a>
					</li>
					<li role="presentation" class="active"><a href="web/config/proexam-process.jsp">审批流程配置</a>
					</li>
				</ul>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<div class="action_item">
					  			<button id="pro_allocation" class="obtn glyphicon glyphicon-plus" onclick="proexamproceAdd('添加','web/config/config-add/proexam-process-add.jsp','2')">添加</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th></th>
										<th>活动点名称</th>
										<th>审批类型</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox"></td>
										<td>活动点名称</td>
										<td>平台审批</td>
										<td>
											<a href="javascript:;" class="btn-up">上移</a>
											<a href="javascript:;" class="btn-down">下移</a>
											<a href="javascript:;" class="btn-del">移除</a>
										</td>
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
	<script type="text/javascript" src="js/config/proexam-process.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		//默认禁用搜索和排序
		/* $.extend( $.fn.dataTable.defaults, {
		    searching: true,
		    ordering:  false
		} ); */
		$('#table_id').DataTable({
			"scrollX":true,
			"autoWidth" : false,
			//scrollY : 500,
			//paging : false,//分页
			//"searching" : false,
			"info" : false,//左下角信息
			//"ordering": false,//排序
			"aaSorting" : [],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 1, 2, 3 ]
			} // 制定列不参与排序
			],
			colReorder : false,
			"sScrollX" : "100%",
			"sScrollXInner" : "100%",
			"bScrollCollapse" : true
		});
			</script>
		</div>
	</div>
</body>

</html>