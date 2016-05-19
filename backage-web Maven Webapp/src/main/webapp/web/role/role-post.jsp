<%@page import="cn.springmvc.model.Operation"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	/* 登录人操作权限 */
	List<Operation> operations = null;
	if(session.getAttribute("operationList") != null){
		operations = (List<Operation>)session.getAttribute("operationList");

	}
	
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<base href="<%=basePath%>">
<title>角色管理-职务管理</title>
<!-- 公用meta -->
<jsp:include page="../common/top-meta.jsp"></jsp:include>
<!-- 公用css -->
<jsp:include page="../common/cm-css.jsp"></jsp:include>

<!-- 私用css -->
<link rel="stylesheet" href="css/role.css" />
<link rel="stylesheet" href="plugs/zTree/v3/css/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript">
	var on_off =false; //停用启用权限标记
	<%
		if(operations.size()>0){
			for(int j=0;j<operations.size();j++){
				if(operations.get(j).getOptID()==10204){
	%>
		   		on_off =true;
	<%
				}
			}
		}
	%>
</script>

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
				<jsp:param value="role-1" name="role-index" />
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
														class="glyphicon glyphicon-chevron-down"></span> </a></li>
											</ul>
										</div>
									</div>
									<div class="panel-body">
										<form id="" class="" action="">
											<span class="con-item"><span>所属部门</span><input type="text" name ="deptName" id="deptName"  class="" placeholder="所属部门" /></span>
											<span class="con-item"><span>职务名称</span><input type="text" name="postName" id="postName" class="" placeholder="职务名称" /></span>
											<span class="con-item"><span>添加时间</span><input readonly="readonly"  id="start" name="start" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end\')}'})"></span>
								<span class="con-item"><span>至 </span><input readonly="readonly"  id="end" name="end" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'start\')}'})"></span>
											<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</form>
									</div>
								</div>
							</div>
			
							<div class="data_display">
								<div class="panel panel-success">
									<div class="panel-heading">
										<div class="action_item">
								<%
									if(operations.size()>0){
										for(int i = 0;i < operations.size(); i++){
											if(operations.get(i).getOptID() == 10201){
								%>				
											<button class="obtn glyphicon glyphicon-plus obtn-post-add" onclick="postAdd()">添加</button>
								<%      
							      			}
							      			if(operations.get(i).getOptID() == 10202){
								%>				
											<button class="obtn glyphicon glyphicon-pencil obtn-post-mod" onclick="expMod()">修改</button>
								<%      
							      			}
							      			if(operations.get(i).getOptID() == 10203){
								%>				
											<button class="obtn glyphicon glyphicon-trash obtn-post-del">删除</button>
								<%      
							      			}
								  		 }
									 }
							     %>	
										</div>
									</div>
									<div class="panel-body">
										<table id="post_id" class="display">
										</table>
									</div>
			
									<div class="w-content pic-add">
									<form action="javascript:savePost()" id="dataForm" method="post" >
										<table>
											<tr>
												<td class="tt"><label class="ineed">职务名称：</label></td>
												<td class="con">
												<input type="hidden"  name ="deptIds" id="deptIds"/>
													<input type="text" class="" placeholder="职务名称"  datatype="z2_8"  id="postName_one"/>
												</td>
											</tr>
											<tr>
												<td class="tt"><label>选择所属部门：</label></td>
												<td class="con">
												<select name="deptId" class="" id="deptId" style="width:165px;height:30px">
													<option  value="-1">请选择</option>
													<c:forEach var="dept" items="${deptList}">
														<option  value="${dept.id}">${dept.deptName}</option>
													</c:forEach>
										         </select>
											</td>
											</tr>
											<tr>
												<td class="tt"><label>职务描述：</label></td>
												<td class="con">
													<input type="text" class="" name="postRemark" datatype="unNormal" maxlength="30" id="postRemark" placeholder="职务描述" />
												</td>
											</tr>
										</table>
										</form>
									</div>
									
									<div class="w-content pic-mod">
									<form action="javascript:test()" id="dataFor" method="post">
											<table>
												<tr>
													<td class="tt"><label class="ineed">职务名称：</label></td>
													<td class="con">
														<input type="text" class="" placeholder="" id ="postName_two" datatype="z2_8"/>
													</td>
												</tr>
												<tr>
												<td class="tt"><label>选择所属部门：</label></td>
												<td class="con">
												<select name="deptId1" class="" id="deptId1" style="width:165px;height:30px">
													<option  value="-1">请选择</option>
													<c:forEach var="dept" items="${deptList}">
														<option  value="${dept.id}">${dept.deptName}</option>
													</c:forEach>
										         </select>
											</td>
											</tr>
											<tr>
												<td class="tt"><label>职务描述：</label></td>
												<td class="con">
													<input type="text" class="" name="postRemark1" datatype="unNormal" maxlength="30" id="postRemark1" placeholder="职务描述" />
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
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
	<script type="text/javascript" src="js/role/myZtree.js"></script>
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
								if(data != null){
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
	<script type="text/javascript" src="js/role/role-post.js"></script>	
</body>

</html>