<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="cn.springmvc.model.Operation"%>
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
	<title>前台界面配置-平台安全</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
	<!-- 私用css -->	
	<link rel="stylesheet" href="css/frontconfig/fc-platformSecurity.css" type="text/css"/>	
</head>
<body class="nav-md">
	<div class="container body">
		<!-- 头部 -->
		<jsp:include page="../common/cm-top.jsp">
			<jsp:param value="5" name="top_menu_index"/>
		</jsp:include>
		
		<!-- 左侧菜单 -->
		<jsp:include page="../common/cm-frontconfig.jsp"></jsp:include>
		<!-- 主要内容 -->
		<div class="right_col" role="main">	
			<!-- 地址导航 -->
			<jsp:include page="../common/cm-addr.jsp"></jsp:include>
			<div class="panel-body">
				<table>
					<tr>			
						<td class="con">							
					  		<script id="applyguide" type="text/plain" style="height:260px;width:100%;"></script>					  		
						</td>
					</tr>																	
				</table>
				<div class="psAdd">
					<%
						if(operations.size()>0){
							for(int i = 0;i < operations.size(); i++){
								if(operations.get(i).getOptID() == 51201){
					%>				
								<button type="submit" class="btn"  onclick="savaOrUpdate()">提交</button>
					<%      
				      			}
					  		 }
						 }
				     %>	
				</div>
			</div>		
		</div>
	</div>
	<!-- 公用js -->
	<ul><li><br></li></ul>
	
	
	
	
		
	
</body>
</html>