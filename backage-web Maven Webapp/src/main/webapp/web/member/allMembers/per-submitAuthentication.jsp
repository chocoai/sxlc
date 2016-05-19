<%@page import="product_p2p.kit.datatrans.IntegerAndString"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	long memberId =IntegerAndString.StringToLong(request.getParameter("content"), 0);
	String index3 = request.getParameter("_index_m3");
	String index2 = request.getParameter("_index_m2");
	
	%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge" />  -->
	<base href="<%=basePath%>">
	<title>借款项目查询</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="css/member/memberDetail.css" type="text/css" >
</head>


<body class="nav-md">
	<!-- 头部 -->
			<jsp:include page="../../common/cm-top.jsp">
				<jsp:param value="2" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../../common/cm-member.jsp">
				<jsp:param value="<%=index2 %>" name="_index_m2"/>
				<jsp:param value="<%=index3 %>" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
	<!-- 地址导航 -->
	<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
	<div class="container body addContainer">
		<div class="main_container">
			<div class="nav-tabs-con active">
				<div class="data_display">
						
						<div class="panel-body">
							<div class="authen">
							</div>
						</div>
						
					</div>
				</div>
			
			</div>
		</div>
	</div>
		<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/verifiedMember.js"></script>
	<script type="text/javascript">
		var memberId = <%=memberId %>;
		selectAuditList(memberId);
	</script>

