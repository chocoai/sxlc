<%@page import="cn.springmvc.model.Operation"%>
<%@page import="cn.springmvc.model.Module"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
/* 	if(session.getAttribute("LoginPerson")==null){
	//	pageContext.forward("login.html");
		return;
	} */
	
	List<Module> moduleList = null;
	if(request.getAttribute("modulelist") != null){
		moduleList = (List<Module>)request.getAttribute("modulelist");
		System.out.print(moduleList.size());
	}
	
	List<Operation> operationList = null;
	if(request.getAttribute("operationList") != null){
		operationList = (List<Operation>)request.getAttribute("operationList");
	}
	
 %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<base href="<%=basePath%>">
<title>角色管理</title>
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
								<span class="con-item"><span>角色编码</span><input type="text" class="" placeholder="角色编码" /></span>
								<span class="con-item"><span>角色名称</span><input type="text" class="" placeholder="角色名称" /></span>
								<span class="con-item"><span>生成日期范围</span><input type="text" class="" placeholder="生成日期范围" /></span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
						</div>
					</div>
				</div>
				
				<!-- 数据显示 -->
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-role-add">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-role-mod">修改</button>
								<button class="obtn glyphicon glyphicon-trash obtn-role-del">删除</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<!-- <tr>
										<th class="table-checkbox"></th>
										<th>角色编码</th>
										<th>角色名称</th>
										<th>生成日期</th>
										<th>描述</th>
										<th>角色权限</th>
										<th>操作</th>
									</tr> -->
								</thead>
								<tbody>
									<%-- <%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>R001</td>
										<td>管理员</td>
										<td>2016年3月10日</td>
										<td>管理地区事务</td>
										<td><a href="javascript:;" class="btn-det">查看</a></td>
										<td>
											<a href="javascript:;" class="btn-enable">启用</a>
											<a href="javascript:;" class="btn-disable">停用</a>
										</td>
									</tr>
									<%
										}
									%> --%>
									<%-- <c:forEach items="${roleList}" var="list">
								    	<tr align="center">
								    		<td><input type="checkbox" /></td>
								  			<td>${list.id}</td>
								  			<td>${list.name}</td>
								  			<td>${list.bigsort}</td>
								    		<td><a href="javascript:;" class="btn-det">查看</a></td>
											<td>
											<a href="javascript:;" class="btn-enable">启用</a>
											<a href="javascript:;" class="btn-disable">停用</a>
										</td>
								    	
								    	</tr>
		   
		 						   </c:forEach> --%>
								</tbody>
							</table>
						</div>
						
						<!-- 添加角色 -->
						<div class="w-content role-add">
							<table>
								<tr>
									<td class="tt"><label class="ineed">角色名称:</label></td>
									<td class="con">
										<input type="text" class="" name="roleName" id="roleName" placeholder="" />
									</td>
								</tr>
								<tr>
									<td class="tt"><label>角色描述:</label></td>
									<td class="con">
										<input type="text" class="" name="rolediscribe" id="rolediscribe" placeholder="" />
									</td>
								</tr>
								<tr>
									<td class="tt" valign="top"><label>角色权限配置:</label></td>
									<td class="con">
										<div style="height: 100%; width:100%;overflow: auto;">
									  			<ul style="list-style-type: none;padding-left: 0px;padding-right: 10px;">
									  				<%
									  					if(moduleList.size() > 0){
									  						Module moduleEntity = new Module();
													  		for(int i=0;i<moduleList.size();i++){
													  			moduleEntity = moduleList.get(i);													  			if(moduleEntity.getModuleLevel() != 1){
									  				%>
									  				<li>
									  					<div>
									  						<div style="height: 30px;font-size: 14px;background-color: #f4f4f4">
									  							<table>
															    	<tr>
															    		<td><input type="checkbox" name="moduleCls" value="<%=moduleEntity.getModuleId() %>"/></td>
															    		<td>
															    			<font style="line-height: 25px;"><%=moduleEntity.getModuleNamel()%></font>
															    		</td>
															    	</tr>
															    </table>
									  						</div>
									  						
									  						<div>
									  							<table>
													<%
									  						if(operationList.size() > 0){
									  							int num = -1;
									  							for(int x=0;x<operationList.size();x++){
									  								Operation operationEntity = new Operation();
									  								operationEntity = operationList.get(x);
									  								if(operationEntity.getModuleID() == moduleEntity.getModuleId()){
									  								  	num++;
									  								  	if(num%6 == 0){
									  				%>
									  									<tr style="height: 30px;">
									  				<%
									  									}
									  				%>
										  									<td><input type="checkbox" name="checkAutoCls" value="<%=operationEntity.getOptID() %>"/></td>
																    		<td>
																    			<%=operationEntity.getOptName() %>
																    		</td>
									  				<%
									  									if(num%6 == 5){
									  				%>
									  									</tr>
									  				<%
									  									}
									  								}
									  							}
									  						}
									  				%>
															    </table>
									  						</div>
									  					</div>
									  				</li>
									  				<%
									  							}
									  						}
									  					}
									  				%>
									  			</ul>
										</div>
									</td>
								</tr>
							</table>
						</div>
						
						<!-- 修改角色 -->
						<div class="w-content role-mod">
							<table>
								<tr>
									<td class="tt"><label class="ineed">角色名称:</label></td>
									<td class="con">
										<input type="text" class="roleName" name="modify_roleName" placeholder="" />
									</td>
								</tr>
								<tr>
									<td class="tt"><label>角色描述:</label></td>
									<td class="con">
										<input type="text" class="roleName" name="modify_roledis" placeholder="" />
									</td>
								</tr>
								<tr>
									<td class="tt"><label>角色权限配置:</label></td>
									<td class="con">
											<ul style="list-style-type: none;padding-left: 0px;padding-right: 10px;">
									  				<%
									  					if(moduleList.size() > 0){
									  						Module moduleEntity = new Module();
													  		for(int i=0;i<moduleList.size();i++){
													  			moduleEntity = moduleList.get(i);													  			if(moduleEntity.getModuleLevel() != 1){
									  				%>
									  				<li>
									  					<div>
									  						<div style="height: 30px;font-size: 14px;background-color: #f4f4f4">
									  							<table>
															    	<tr>
															    		<td><input type="checkbox" name="moduleCls1" id="moduleCls<%=moduleEntity.getModuleId()%>"  value="<%=moduleEntity.getModuleId() %>"/></td>
															    		<td>
															    			<font style="line-height: 25px;"><%=moduleEntity.getModuleNamel()%></font>
															    		</td>
															    	</tr>
															    </table>
									  						</div>
									  						
									  						<div>
									  							<table>
													<%
									  						if(operationList.size() > 0){
									  							int num = -1;
									  							for(int x=0;x<operationList.size();x++){
									  								Operation operationEntity = new Operation();
									  								operationEntity = operationList.get(x);
									  								if(operationEntity.getModuleID() == moduleEntity.getModuleId()){
									  								  	num++;
									  								  	if(num%6 == 0){
									  				%>
									  									<tr style="height: 30px;">
									  				<%
									  									}
									  				%>
										  									<td><input type="checkbox" name="checkAutoCls1" id="checkAutoCls<%=operationEntity.getOptID() %>" value="<%=operationEntity.getOptID() %>"/></td>
																    		<td>
																    			<%=operationEntity.getOptName() %>
																    		</td>
									  				<%
									  									if(num%6 == 5){
									  				%>
									  									</tr>
									  				<%
									  									}
									  								}
									  							}
									  						}
									  				%>
															    </table>
									  						</div>
									  					</div>
									  				</li>
									  				<%
									  							}
									  						}
									  					}
									  				%>
									  			</ul>
									</td>
								</tr>
							</table>							
						</div>
						
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/valid.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/role/role_role-manage.js"></script>
</body>

</html>