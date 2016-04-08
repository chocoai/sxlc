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
<title>角色管理-部门管理</title>
<!-- 公用meta -->
<jsp:include page="../common/top-meta.jsp"></jsp:include>
<!-- 公用css -->
<jsp:include page="../common/cm-css.jsp"></jsp:include>
<!-- 私用css -->
<link rel="stylesheet" href="css/role.css" />
<link rel="stylesheet" href="plugs/zTree/v3/css/zTreeStyle/zTreeStyle.css" />
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
				<jsp:param value="role-0" name="role-index" />
			</jsp:include>
			<!-- 头部导航 -->

			<!-- 主要内容 -->
			<div class="right_col role-content">
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<table class="tree-table">
					<tr>
						<td class="ztree v-top w4">
							<div class="zTree-box">
								<ul id="treeDemo" class="ztree"></ul>
							</div>
						</td>
						<td class="v-top">
							<div class="search">
								<div class="panel panel-success">
									<div class="panel-heading">
										<div class="i-fl search_title">条件查询</div>
										<div class="i-fr action_item">
											<ul class="list_item list-inline">
												<li><a class="state">展开&nbsp;<span
														class="glyphicon glyphicon-chevron-down"></span> </a>
												</li>
											</ul>
										</div>
									</div>
									<div class="panel-body">
										<form id="" class="" action="">
											<span class="con-item">
												<span>部门编号</span><input type="text" class="" placeholder="部门编号" />
											</span>
											<span class="con-item">
												<span>部门名称</span><input type="text" class="" placeholder="部门名称" />
											</span>
											<span class="con-item">
												<span>部门负责人</span><input type="text" class="" placeholder="部门负责人" />
											</span>
											<span class="con-item">
												<span>部门负责人电话</span><input type="text" class="" placeholder="部门负责人电话" />
											</span>
											<span class="con-item">
												<span>状态</span>
												<select class="">
													<option>全部</option>
												</select>
											</span>
											<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</form>
									</div>
								</div>
							</div>
			
							<div class="data_display">
								<div class="panel panel-success">
									<div class="panel-heading">
										<div class="action_item">
											<button class="obtn glyphicon glyphicon-plus obtn-dept-add">添加</button>
											<button class="obtn glyphicon glyphicon-pencil obtn-dept-mod">修改</button>
											<button class="obtn glyphicon glyphicon-trash obtn-dept-del">删除</button>
										</div>
									</div>
									<div class="panel-body">
										<table id="table_id" class="display">
										</table>
									</div>
			
									<div class="w-content dept-add">
										<form id="saveDept" action="javascript:addDept()" method="post" >
											<table>
												<tr>
													<td class="tt"><label class="ineed">部门名称：</label></td>
													<td class="con">
														<input type="text" name="deptName" datatype="entername" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>部门负责人：</label></td>
													<td class="con">
														<input type="text" name="principalName" datatype="enterperson" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>负责人电话：</label></td>
													<td class="con">
														<input type="text" name="principalPhone" datatype="zPhone" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>上级部门ID：</label></td>
													<td class="con">
														<input type="text" name="preDeptId" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>部门描述：</label></td>
													<td class="con">
														<input type="text" name="deptRemark" datatype="reMarks" class="" placeholder="" />
													</td>
												</tr>
											</table>
										</form>
									</div>
									
									<div class="w-content dept-mod">
										<form id="updateDept" action="javascript:updateDept()" method="post" >
											<table>
												<tr>
													<td class="tt"><label class="ineed">部门名称：</label></td>
													<td class="con">
														<input id="dId" type="hidden" name="deptId" class="" placeholder="" />
														<input id="dName" type="text" name="deptName" datatype="entername" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>部门负责人：</label></td>
													<td class="con">
														<input id="dpName" type="text" name="principalName" datatype="enterperson" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>负责人电话：</label></td>
													<td class="con">
														<input id="dpPhone" type="text" name="principalPhone" datatype="zPhone" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label>部门描述：</label></td>
													<td class="con">
														<input id="dRemark" type="text" name="deptRemark" datatype="reMarks" class="" placeholder="" />
													</td>
												</tr>
											</table>
										</form>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript" src="js/role/role-dept.js"></script>
	<script type="text/javascript" src="plugs/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		var setting = {
			view: {
				showIcon: showIconForTree
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};

		var zNodes =[
			{ id:1, pId:0, name:"父节点1 - 展开", open:true},
			{ id:11, pId:1, name:"父节点11 - 折叠"},
			{ id:111, pId:11, name:"叶子节点111"},
			{ id:112, pId:11, name:"叶子节点112"},
			{ id:113, pId:11, name:"叶子节点113"},
			{ id:114, pId:11, name:"叶子节点114"},
			{ id:12, pId:1, name:"父节点12 - 折叠"},
			{ id:121, pId:12, name:"叶子节点121"},
			{ id:122, pId:12, name:"叶子节点122"},
			{ id:123, pId:12, name:"叶子节点123"},
			{ id:124, pId:12, name:"叶子节点124"},
			{ id:13, pId:1, name:"父节点13 - 没有子节点", isParent:true},
			{ id:2, pId:0, name:"父节点2 - 折叠"},
			{ id:21, pId:2, name:"父节点21 - 展开", open:true},
			{ id:211, pId:21, name:"叶子节点211"},
			{ id:212, pId:21, name:"叶子节点212"},
			{ id:213, pId:21, name:"叶子节点213"},
			{ id:214, pId:21, name:"叶子节点214"},
			{ id:22, pId:2, name:"父节点22 - 折叠"},
			{ id:221, pId:22, name:"叶子节点221"},
			{ id:222, pId:22, name:"叶子节点222"},
			{ id:223, pId:22, name:"叶子节点223"},
			{ id:224, pId:22, name:"叶子节点224"},
			{ id:23, pId:2, name:"父节点23 - 折叠"},
			{ id:231, pId:23, name:"叶子节点231"},
			{ id:232, pId:23, name:"叶子节点232"},
			{ id:233, pId:23, name:"叶子节点233"},
			{ id:234, pId:23, name:"叶子节点234"},
			{ id:3, pId:0, name:"父节点3 - 没有子节点", isParent:true}
		];

		function showIconForTree(treeId, treeNode) {
			return !treeNode.isParent;
		};

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
	</script>
</body>

</html>