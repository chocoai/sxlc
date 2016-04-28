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
	pageContext.forward("login.html");
		return;
	} */
	
	/* 登录人模块权限 */
	/* List<Module> modules = null;
	if(session.getAttribute("modulelist") != null){
		modules = (List<Module>)session.getAttribute("modulelist");
	} */
	/* 登录人操作权限 */
	List<Operation> operations = null;
	if(session.getAttribute("operationList") != null){
		operations = (List<Operation>)session.getAttribute("operationList");

	}
	
	List<Module> moduleList = null;
	if(request.getAttribute("modulelist") != null){
		moduleList = (List<Module>)request.getAttribute("modulelist");
	}
	
	List<Operation> operationList = null;
	if(request.getAttribute("operationList") != null){
		operationList = (List<Operation>)request.getAttribute("operationList");
	}
	List<Module> moduleThree = null;
	if(request.getAttribute("moduleThree") != null){
		moduleThree = (List<Module>)request.getAttribute("moduleThree");
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
<script type="text/javascript">
	var on_off =false; //停用启用权限标记
	<%
		if(operations.size()>0){
			for(int j=0;j<operations.size();j++){
				if(operations.get(j).getOptID()==10504){
	%>
		   		on_off =true;
	<%
				}
			}
		}
	%>
</script>
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
								<span class="con-item"><span>角色编码</span><input type="text" name="roleNo" id="roleNo" class="" placeholder="角色编码" /></span>
								<span class="con-item"><span>角色名称</span><input type="text" name="roleName" id="roleName" class="" placeholder="角色名称" /></span>
								<span class="con-item"><span>生成时间范围</span><input readonly="readonly"  id="start" name="start" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end\')}'})"></span>
								<span class="con-item"><span>至 </span><input readonly="readonly"  id="end" name="end" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'start\')}'})"></span>
								<button class="obtn obtn-query glyphicon glyphicon-search" type="button">查询</button>
							</form>
						</div>
					</div>
				</div>
				
				<!-- 数据显示 -->
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
					<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								if(operations.get(i).getOptID() == 10501){
					%>				
								<button class="obtn glyphicon glyphicon-plus obtn-role-add">添加</button>
					<%      
				      			}
				      			if(operations.get(i).getOptID() == 10502){
					%>				
								<button class="obtn glyphicon glyphicon-pencil obtn-role-mod">修改</button>
					<%      
				      			}
				      			if(operations.get(i).getOptID() == 10503){
					%>				
								<button class="obtn glyphicon glyphicon-trash obtn-role-del">删除</button>
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
						
						<!-- 添加角色 -->
						<div class="w-content role-add">
							<form id="dataForm" method="post" action="javascript:AddOrUpdateRole()">
							<input type ="hidden" name="addOrUpdate" id="addOrUpdate">
							<input type ="hidden" name="roleId" id="roleId">
							<table>
								<tr>
									<td class="tt"><label class="ineed">角色名称:</label></td>
									<td class="con">
										<input type="text" class="" name="roleName1" id="roleName1" datatype="unNormal" placeholder="" />
									</td>
								</tr>
								<tr>
									<td class="tt"><label>角色描述:</label></td>
									<td class="con">
										<input type="text" class="" name="rolediscribe1" datatype="unNormal" maxlength="50" id="rolediscribe1" placeholder="" />
									</td>
								</tr>
								<tr>
									<td class="tt" valign="top"><label>角色权限配置:</label></td>
									<td class="con">
						  				<div style="overflow: auto;">
						  					<ul style="list-style-type: none;padding-left: 0px;padding-right: 10px;">
								  			
								  					<%
						  					if(moduleList.size() > 0){
												Module moduleEntity = new Module();
												for(int i=0;i<moduleList.size();i++){
													moduleEntity = moduleList.get(i);
													if(moduleEntity.getModuleLevel() == 2){
						  				%>
							  					
							  							  <%
													    	if(moduleEntity.getDowmModuleNum()<1){
													  	  %>
													  	<li>
										  					<div style="height: 30px;font-size: 14px;background-color: #f4f4f4">
										  						<table>
										  						  <tr>
									    							<td>
													    	<input type="checkbox" name="moduleCls" id="moduleCls<%=moduleEntity.getModuleId()%>"  value="<%=moduleEntity.getModuleId()%>"/>
													    		</td>
													    		<td>
													    			<font style="line-height: 25px;font-weight: bolder;"><%=moduleEntity.getPreModuleName() %>&nbsp;--&nbsp;<%=moduleEntity.getModuleNamel()%></font>
													    		</td>
													    	</tr>
													    </table>
							  						</div>
							  						<div>
							  							<table border="0">
							  								<%
							  									if(operationList.size() > 0){
																	int num = -1;
							  										for(int x=0;x<operationList.size();x++){
																		Operation operationEntity = new Operation();
							  											operationEntity = operationList.get(x);
							  											if(operationEntity.getModuleID() == moduleEntity.getModuleId()){
							  												num++;
							  												if(num%5 == 0){
							  								%>
							  									<tr>
							  								<%
							  												}
							  								%>
								  									<td><input style="margin-left: 25px;" type="checkbox" name="checkAutoCls" id="checkAutoCls<%=operationEntity.getOptID() %>" value="<%=operationEntity.getOptID() %>"/></td>
														    		<td style="line-height: 18px">
														    			<%=operationEntity.getOptName() %>
														    		</td>
							  								<%
							  												if(num%5 == 4){
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
												</li>   
												    
												  	<%		
			  											}
			  										else 
			  										{
			  											
			  											Module entity = new Module();
			  											
			  											%>
			  											<li>
										  					<div style="height: 30px;font-size: 14px;background-color: #f4f4f4">
										  						<table>
										  						  <tr>
									    							<td>
													    		 <input style="display: none;" type="checkbox" name="moduleCls" id="moduleCls<%=moduleEntity.getModuleId()%>"  value="<%=moduleEntity.getModuleId()%>"/>
													    		</td>
													    		<td>
													    			<font style="line-height: 25px;font-weight: bolder;"><%=moduleEntity.getPreModuleName() %>&nbsp;--&nbsp;<%=moduleEntity.getModuleNamel()%></font>
													    		</td>
													    	</tr>
													    </table>
							  						</div>
			  											
			  											<%	
														for(int j=0;j<moduleThree.size();j++){
														entity = moduleThree.get(j);
															if(moduleEntity.getModuleId().equals(entity.getPrevModuleId())) {
						  									
			  										 %>
								  					
								  					<div style="height: 30px;font-size: 14px;background-color: #f4f4f4">
							  							<table style="margin-left: 25px;">
													    	<tr>
													    		<td ><input type="checkbox" name="moduleCls" id="moduleCls<%=entity.getModuleId()%>"  value="<%=entity.getModuleId()%>"/></td>
													    		<td>
													    			<font style="line-height: 25px;font-weight: bolder;"><%=entity.getModuleNamel()%></font>
													    		</td>
													    	</tr>
													    </table>
							  						</div>
							  						<div>
							  							<table border="0">
							  								<%
							  									if(operationList.size() > 0){
																	int num = -1;
							  										for(int x=0;x<operationList.size();x++){
																		Operation operationEntity = new Operation();
							  											operationEntity = operationList.get(x);
							  											if(operationEntity.getModuleID() == entity.getModuleId()){
							  												num++;
							  												if(num%5 == 0){
							  								%>
							  									<tr>
							  								<%
							  												}
							  								%>
								  									<td><input style="margin-left: 25px;" type="checkbox" name="checkAutoCls" id="checkAutoCls<%=operationEntity.getOptID() %>" value="<%=operationEntity.getOptID() %>"/></td>
														    		<td style="line-height: 18px">
														    			<%=operationEntity.getOptName() %>
														    		</td>
							  								<%
							  												if(num%5 == 4){
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
													    	 <%
													    			}
													    		}
													    	}
													     %>
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
							</form>
						</div>
<!-- 						
						修改角色
						<div class="w-content role-mod">
							<form id="updateForm">
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
							</table>	
							</form>						
						</div>
						
 -->					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/role/role_role-manage.js"></script>

</body>

</html>