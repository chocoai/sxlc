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
	<title>配置中心--财务配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------财务设置  投资管理费 年标-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="config-0" name="config-index" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<ul class="nav nav-tabs">
					<li role="presentation" class=""><a href="web/config/imfee-day.jsp">天标</a>
					</li>
					<li role="presentation" class=""><a href="web/config/imfee-month.jsp">月标</a>
					</li>
					<li role="presentation" class="active"><a href="web/config/imfee-year.jsp">年标</a>
					</li>
				</ul>
			 	<!-- 投资管理费 -->
			 	<!-- 数据显示 -->
			 	<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-mode-year-add">添加</button>
									<button class="obtn glyphicon glyphicon-trash obtn-mode-year-del">删除</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table-mode-year" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>最小期限</th>
											<th>最大期限</th>
											<th>手续费率</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>5天</td>
											<td>10天</td>
											<td>0.5%</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
							
							<!-- 添加   天标 -->
							<div class="w-content mode-year-add">
								<table>
									<tr>
										<td class="tt"><label class="ineed">最小期限：</label></td>
										<td class="con">
											<input type="text" class="" placeholder="" value="1" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label>最大期限：</label></td>
										<td class="con">
											<input type="text" class="" placeholder="" />
										</td>
									</tr>
									<tr>
										<td class="tt"><label>手续费率：</label></td>
										<td class="con">
											<input type="text" class="" placeholder="" />
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/config/config.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		/* 投资管理费----方式2-月标表格 */
		$(function(){
			$('#table-mode-year').DataTable({
				"autoWidth" : false,
				scrollY : 500,
				//paging : false,//分页
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [[1,"asc"]],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0,2,3]
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