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
	<title>配置中心-项目审批活动点配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" type="text/css"></link>
	<script type="text/javascript">
	var on_off =false; //停用启用权限标记
	<%
		if(operations.size()>0){
			for(int j=0;j<operations.size();j++){
				if(operations.get(j).getOptID()==60803){
	%>
		   		on_off =true;
	<%
				}
			}
		}
	%>
	</script>
</head>
<!-- 配置中心--------项目审批活动点配置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="608" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="web/config/proexam-point.jsp">审批活动点配置</a>
					</li>
					<li role="presentation" class=""><a href="web/config/proexam-process.jsp">审批流程配置</a>
					</li>
				</ul>
				<div class="nav-tabs-con active">
					<!-- <div class="search">
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
									<span class="con-item"><span>活动点名称</span><input type="text" class="" value="" /></span>
									<span class="con-item"><span>关联操作权限名称</span><input type="text" class="" value="" /></span>
									<span class="con-item"><span>活动点状态</span><input type="text" class="" value="" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div>  -->
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<div class="action_item">
						<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								
				      			if(operations.get(i).getOptID() == 60801){
					%>				
									<button class="obtn glyphicon glyphicon-plus obtn-proexam-point-add">添加</button>
					<%      
				      			}
				     			 if(operations.get(i).getOptID() == 60802){
					%>				
								<button class="obtn glyphicon glyphicon-pencil obtn-proexam-point-mod">修改</button>
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
					<!-- 添加审批点配置 -->
					<div class="w-content proexam-point-add">
						<form action="javascript:addActivity()" method="post" id="dataForm">
						<input type="hidden" id="activityId">
						<table>
							<tr>
								<td class="tt"><label class="ineed">活动点名称：</label></td>
								<td class="con" id="addactivityname"><input type="text" style="width: 170px" id="aName" class="" placeholder="" value="" datatype="entername"/></td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">审批类型：</label></td>
								<td class="con">
									<select class="msginterfaceselect" style="width: 170px" id="aType">
										<option value="-1">请选择</option>
										<option value="0">平台审批</option>
										<option value="1">担保机构审批</option>
										<option value="2">资产管理方审批</option>
									</select>
								</td>
							</tr>
							<!-- <tr>
								<td class="tt"><label class="ineed">状态：</label></td>
								<td class="con">
									<select class="msginterfaceselect"  id="statu">
										<option value="1">有效</option>
										<option value="1">无效</option>
									</select>
								</td>
							</tr> -->
						</table>
						</form>
					</div>
					<!-- 修改审批点配置 -->
					<div class="w-content proexam-point-mod">
						<form action="javascript:updateActivity()" method="post" id="dataForms">
						<table>
							<tr>
								<td class="tt"><label class="ineed">活动点名称：</label></td>
								<td class="con" id="modactivityname" ><input type="text"  style="width: 170px" id="apName" class="" placeholder="" value="" datatype="entername"/></td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">审批类型：</label></td>
								<td class="con">
									<select class="msginterfaceselect" style="width: 170px" id="apType">
									</select>
								</td>
							</tr>
						<!-- 	<tr>
								<td class="tt"><label class="ineed" >状态：</label></td>
								<td class="con">
									<select class="msginterfaceselect" id="status">
										<option value="1">有效</option>
										<option value="0">无效</option>
									</select>
								</td>
							</tr> -->
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
	<script src="js/config/proexam-point.js"></script>
		</div>
	</div>
</body>

</html>