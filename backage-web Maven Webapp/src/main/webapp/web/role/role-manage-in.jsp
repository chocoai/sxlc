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
<title>角色管理-管理员管理</title>
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
				<jsp:param value="role-4" name="role-index" />
			</jsp:include>
			<!-- 头部导航 -->

			<!-- 主要内容 -->
			<div class="right_col role-content">
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<!-- tab切换 -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="web/role/role-manage-in.jsp">内部管理员</a></li>
					<li><a href="web/role/role-manage-out.jsp">外部管理员</a></li>
				</ul>
				
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
								<span class="con-item"><span>管理员编码</span><input type="text" class="" placeholder="" /></span>
								<span class="con-item"><span>用户名称</span><input type="text" class="" placeholder="" /></span>
								<span class="con-item"><span>生成日期范围</span><input type="text" class="" placeholder="" /></span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
						</div>
					</div>
				</div>
				
				<!-- 数据显示 -->
				<!-- 内部管理员 -->
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-manage-det" onclick="manageDet('管理员详细信息')">管理员详细信息</button>
								<button class="obtn glyphicon glyphicon-plus obtn-manage-add" onclick="manageAdd('添加内部管理员','0')">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-manage-mod" onclick="manageMod('修改内部管理员','0')">修改</button>
								<button class="obtn glyphicon glyphicon-trash obtn-manage-del" onclick="manageDel()">删除</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="tb-manage-in" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>管理员编码</th>
										<th>用户名称</th>
										<th>生成日期</th>
										<th>用户角色</th>
										<th>用户所有权限</th>
										<th>停用原因</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>管理员编码</td>
										<td>用户名称</td>
										<td>生成日期</td>
										<td><a href="javascript:;" class="btn-det">用户角色</a></td>
										<td><a href="javascript:;" class="btn-det">用户所有权限</a></td>
										<td>停用原因</td>
										<td>已启用</td>
										<td>
											<a href="javascript:;" class="btn-enable">启用</a>
											<a href="javascript:;" class="btn-disable">停用</a>
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
				
				<!-- 详情 -->
				<div class="w-content" id="manage-det">
					<table>
						<tr>
							<td class="tt"><label>用户名:</label></td>
							<td class="con">
								<input type="text" class="" value="测试数据" />
							</td>
							<td class="tt"><label>每日登录时间范围:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>姓名:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>性别:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>身份证号:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>出生日期:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>民族:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>职务:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>联系电话:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>QQ:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>Email:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>户籍:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>现居住地:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>学历:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>毕业时间:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>紧急联系人姓名:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>紧急联系人电话:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>所属部门:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>所拥有权限:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>上次登录时间:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
					</table>
				</div>
				
				<!-- 添加管理员 -->
				<div class="w-content" id="manage-add">
					<table>
						<tr>
							<td class="tt"><label class="ineed">用户名:</label></td>
							<td class="con">
								<input type="text" class="" value="测试数据" />
							</td>
							<td class="tt"><label>密码:</label></td>
							<td class="con">
								<input type="password" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>每日登录时间范围:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>姓名:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>性别:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>身份证号:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>出生日期:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>民族:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>职务:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>联系电话:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>QQ:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>Email:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>户籍:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>现居住地:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>学历:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>毕业时间:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>紧急联系人姓名:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>紧急联系人电话:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
						<tr>
							<td class="tt"><label>所属部门:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
							<td class="tt"><label>角色选择配置:</label></td>
							<td class="con">
								<input type="text" class="" value="" />
							</td>
						</tr>
					</table>
				</div>
				
				<!-- 修改管理员 -->
				<div class="w-content" id="manage-mod">
												
				</div>
				
				

			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/role/role-manage.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		$(function() {
			$("#tb-manage-in").DataTable({
				"autoWidth" : false,
				scrollY : 500,
				//paging : false,//分页
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [ [ 3, "desc" ] ],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0,1,2,4,5,6,7,8]
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