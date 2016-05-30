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
				<jsp:param value="1" name="_index_m1" />
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-role.jsp">
				<jsp:param value="101" name="_index_m2" />
				<jsp:param value="" name="_index_m3" />
			</jsp:include>
			<!-- 头部导航 -->

			<!-- 主要内容 -->
			<div class="right_col role-content">
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<table class="tree-table">
					<tr>
						<td class="ztree v-top w4">
							<div class="zTree-box">
								<ul id="dleft_tab1" class="ztree"></ul>
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
												<span>部门编号</span><input id="deptNo" name="deptNo" type="text" class="" placeholder="部门编号" />
											</span>
											<span class="con-item">
												<span>部门名称</span><input id="deptName" name="deptName" type="text" class="" placeholder="部门名称" />
											</span>
											<span class="con-item">
												<span>部门负责人</span><input id="deptPerson" name="principalName" type="text" class="" placeholder="部门负责人" />
											</span>
											<span class="con-item">
												<span>部门负责人电话</span><input id="deptPhone" name="principalPhone" type="text" class="" placeholder="部门负责人电话" />
											</span>
											<span class="con-item">
												<span>状态</span>
												<select class="" style="width:140px">
													<option value="-1">请选择</option>
													<option value="1">有效</option>
													<option value="0">无效</option>
												</select>
											</span>
											<button class="obtn obtn-query glyphicon glyphicon-search" type="button">查询</button>
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
														<input type="text" id="sdeptName" name="deptName" datatype="entername" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label class="ineed">部门负责人：</label></td>
													<td class="con">
														<input type="text" id="sprincipalName" name="principalName" datatype="enterperson" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label class="ineed">负责人电话：</label></td>
													<td class="con">
														<input type="text" id="sprincipalPhone" maxlength="11"  name="principalPhone" datatype="zPhone" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label >上级部门：</label></td>
													<td class="con">
														<select id="spreDeptId" class="" style="width:170px;height:30px">
														</select>
														<input type="hidden" id="deptIds">
													</td>
												</tr>
												<tr>
													<td class="tt"><label class="ineed">部门描述：</label></td>
													<td class="con">
														<textarea id="sdeptRemark" name="sdeptRemark" datatype="reMarks"  ></textarea>
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
													<td class="tt"><label class="ineed">部门负责人：</label></td>
													<td class="con">
														<input id="dpName" type="text" name="principalName" datatype="enterperson" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label class="ineed">负责人电话：</label></td>
													<td class="con">
														<input id="dpPhone" type="text" name="principalPhone" datatype="zPhone" class="" placeholder="" />
													</td>
												</tr>
												<tr>
													<td class="tt"><label class="ineed">备注：</label></td>
													<td class="con">
														<textarea id="dRemark" name="deptRemark" datatype="reMarks"  ></textarea>
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
	<script type="text/javascript" src="plugs/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript" src="js/role/myZtree.js"></script>
	<!-- 私用js -->
	<!-- 私用js -->
	 <script type="text/javascript">
		 var depId =1;
			$(document).ready(function(){
				$(document).ajaxStart(onStart).ajaxSuccess(onStop);
				loadMenu("dleft_tab1");
			});
			function loadMenu(treeObj){
					$.ajax({
						type:"POST",
						async : false,
						cache:false,
						url: "<%=basePath%>/PostController/finddapt.do",
						dataType:"json",
						success:function(data){
							// 如果返回数据不为空，加载"业务模块"目录
							if(data != null && data.length>0){
								// 将返回的数据赋给zTree
							 	$.fn.zTree.init($("#"+treeObj), setting, data);
							 	zTree = $.fn.zTree.getZTreeObj(treeObj);
								//点击事件
								var node = zTree.getNodeByParam('parentID',0);//获取id为1的点   设置默认点击第几级
						         zTree.selectNode(node);//选择点  
						         zTree.setting.callback.onClick(null,zTree.setting.treeId,node);//调用事件  
											
				                if( zTree ){
									// 默认展开所有节点
									zTree.expandAll(true);
								}
							}
						}
					});
				}
		</script>
	<script type="text/javascript" src="js/role/role-dept.js"></script>
</body>

</html>