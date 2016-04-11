<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<base href="<%=basePath%>">
<title>角色管理-理财顾问管理</title>
<!-- 公用meta -->
<jsp:include page="../common/top-meta.jsp"></jsp:include>
<!-- 公用css -->
<jsp:include page="../common/cm-css.jsp"></jsp:include>
<!-- 私用css -->
<link rel="stylesheet" href="css/role.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="1" name="top_menu_index" />
				<jsp:param value="角色管理" name="loc1" />
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-left-menu.jsp">
				<jsp:param value="role-3" name="role-index" />
			</jsp:include>
			<!-- 头部导航 -->

			<!-- 主要内容 -->
			<div class="right_col role-content">
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>

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
								<span class="con-item"><span>员工名称</span><input type="text" class="" placeholder="员工名称" /></span>
								<span class="con-item"><span>前台会员编号</span><input type="text" class="" placeholder="前台会员编号" /></span>
								<span class="con-item"><span>前台会员名称</span><input type="text" class="" placeholder="前台会员名称" /></span>
								<span class="con-item"><span>前台会员用户名</span><input type="text" class="" placeholder="前台会员用户名" /></span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
						</div>
					</div>
				</div>

				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-adviser-add">添加</button>
								<button class="obtn glyphicon glyphicon-trash obtn-adviser-del">移除</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>员工名称</th>
										<th>成为理财顾问时间</th>
										<th>前台会员编号</th>
										<th>前台会员用户名</th>
										<th>前台会员类型</th>
										<th>前台会员名称</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>员工名称1</td>
										<td>成为理财顾问时间1</td>
										<td>前台会员编号1</td>
										<td>前台会员用户名1</td>
										<td>前台会员类型1</td>
										<td>前台会员名称1</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>

						<div class="w-content adviser-add">
							测试
						</div>
					</div>
				</div>

			</div>
			<!-- 公用js -->
			<jsp:include page="../common/cm-js.jsp"></jsp:include>
			<script type="text/javascript" src="js/role.js"></script>
			<!-- 私用js -->
			<script type="text/javascript">
				$(function() {
					$('#table_id').DataTable({
						"autoWidth" : false,
						scrollY : 500,
						//paging : false,//分页
						//"searching" : false,
						//"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [ [ 2, "desc" ] ],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [0,1,3,4,5,6]
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