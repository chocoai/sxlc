<%@page import="cn.springmvc.model.Operation"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

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
	<title>配置中心-托管平台管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" />
	<script type="text/javascript">
	var on_off =false; //停用启用权限标记
	<%
		if(operations.size()>0){
			for(int j=0;j<operations.size();j++){
				if(operations.get(j).getOptID()==60403){
	%>
		   		on_off =true;
	<%
				}
			}
		}
	%>
	</script>
</head>
<!-- 配置中心--------托管平台管理-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="604" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
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
									<div class="form-group">
										<span class="con-item">
											<span>操作类型</span>
										</span>
										<select class="typeO" id="typeO">
										</select>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									</div>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<!-- <div class="i-fl data_title">数据列表</div> -->
					  		<div class="action_item">
					<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								
				      			if(operations.get(i).getOptID() == 60401){
					%>				
									<button class="obtn glyphicon glyphicon-plus obtn-test-inter-add">添加</button>
					<%      
				      			}
				     			 if(operations.get(i).getOptID() == 60402){
					%>				
								<button class="obtn glyphicon glyphicon-pencil obtn-test-inter-modify">修改</button>
					<%      
				      			}
					  		 }
						 }
				     %>	
							
							
							</div> 
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
					<!-- 添加接口地址配置 -->
					<div class="w-content test-inter-add">
						<form action="javascript:addThird()" method="post" id="dataForm">
							<table>
							<tr>
								<td class="tt"><label class="ineed">接口类型：</label></td>
								<td class="con">
									<select class="testinterfaceselect" id="escrowID">
										<option value="-1">请选择</option>
										<option value="1">双乾</option>
										<option value="2">环迅</option>
										<option value="3">中信</option>
										<option value="4">汇付</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label>操作类型：</label></td>
								<td class="con">
									<select class="testinterfaceselect" id="interfaceID">
									
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt">请求路径：</td>
								<td class="con" id="requestpath"><input type="text" name="interfaceUrl" id="interfaceUrl" class="interfacepath" value="" datatype="strRegex"></td>
							</tr>
						</table>
						</form>
					</div>
					<!-- 修改接口地址配置 -->
					<div class="w-content test-inter-modify">
						<form action="javascript:updateThird()"  id="dataForms">
						<table>
							<tr>
								<td class="tt"><label class="ineed">接口类型：</label></td>
								<td class="con">
									<select class="testinterfaceselect" id="typeInterface">
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label>操作类型：</label></td>
								<td class="con">
									<select class="testinterfaceselect" id="typeSure">
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt">请求路径：</td>
								<td class="con" id="modrequestpath"><input type="text" name="reqeust" class="interfacepath" id="requestUrl" value="" datatype="strRegex"></td>
							</tr>
						</table>
						</form>
					</div>
				</div>
			</div>
			<!-- 尾部 -->
			
		</div>
		<!-- 公用js -->
		<jsp:include page="../common/cm-js.jsp"></jsp:include>
		<!-- 私用js -->
		<script type="text/javascript" src="js/config/test-interface.js"></script>
		</div>
	</div>
</body>

</html>