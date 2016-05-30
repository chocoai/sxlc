<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>配置中心-短信设置-短信内容配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="603" name="_index_m2"/>
				<jsp:param value="60301" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus" onclick="addOrUpdate(1)">添加</button>
									<button class="obtn glyphicon glyphicon-pencil" onclick="addOrUpdate(2)">修改</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="table_id" class="display">
								</table>
							</div>
						</div>
					</div>
					<!-- 短信接口地址添加 -->
					<div class="w-content" id="msgadd">
					 <form action="" id="dataForm" method="post">
						<table>
							<tr>
								<td class="tt"><label class="ineed">短信类型：</label></td>
								<td class="con" id="addmsginterface">
									<select  class="msginterfaceselect" >
										<c:forEach var="msg" items="${msgs}">
											<option value="${msg.typeID}">${msg.typeName}</option>
										</c:forEach>
				                    </select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">短信内容：</label></td>
								<td class="con" id="">
									<textarea rows="3" cols="40" class="msgtextarea"></textarea>
								</td>
							</tr>
						</table>
						</form>
						<div class="masgtip"><span>提示：【】内内容不能修改</span></div>
					</div>
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/config/msg-content.js"></script>
</body>

</html>