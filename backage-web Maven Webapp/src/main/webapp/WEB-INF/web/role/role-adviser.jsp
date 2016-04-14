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
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>

						<div class="w-content adviser-add">
							<table id="staffListTb" class="display">
								<thead>
									<tr>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						
						
						<!-- 添加管理员 -->
				
				<div class="w-content" id="manage-add-staff">
					<table id="staffListTb" class="display">
						<thead>
							<tr>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				
				<div class="w-content" id="add-adviser" >
					<form id="form-admin"  method="post" action="javascript:sumitAddAdviser()">
						<table>
							<tr>
								<td class="tt"><label class="ineed">员工姓名:</label></td>
								<td class="con">
									<input type="hidden" class="" name="staffId" id="staffId" readonly="readonly"   value="" />
									<input type="text" class="" name="staffName" id="staffName" readonly="readonly"   value="" />
								</td>
								
							</tr>
							<tr>
								<td class="tt"><label class="ineed">管理员名称:</label></td>
								<td class="con">
									<input type="text" class="" name="adminName" id="adminName" datatype="logname" placeholder="登录名" />
								</td>
								<td class="tt"><label>密码:</label></td>
								<td class="con"> 
									<input type="password" class="" name="adminPwd"  title="newpass" datatype="regpass" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>再次输入密码:</label></td>
								<td class="con"> 
									<input type="password" class="" name="adminPwd1" datatype="repass" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>备注:</label></td>
								<td class="con"> 
									<textarea style="width:182px;height: 70px;" id="adminRemark" name="adminRemark" ></textarea>
								</td>
							</tr>
					    </table>
					</form>
				</div>

			</div>
			<!-- 公用js -->
			<jsp:include page="../common/cm-js.jsp"></jsp:include>
			<script type="text/javascript" src="js/role.js"></script>
			<script type="text/javascript" src="js/role/role-financial.js"></script>
		</div>
	</div>
</body>

</html>