<%@page import="product_p2p.kit.datatrans.IntegerAndString"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

int content = IntegerAndString.StringToInt(request.getParameter("content"),0);
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>车产认证</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="css/member/companyMembers.css" type="text/css" >
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="2" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-member.jsp">
				<jsp:param value="202" name="_index_m2"/>
				<jsp:param value="20209" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<!-- tab切换 -->
						<jsp:include page="../common/mc-companyTable.jsp"></jsp:include>
						<div class="search">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="i-fl search_title">条件查询</div>
									<div class="i-fr action_item">
										<ul class="list_item list-inline">
											<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
										</ul>
									</div>
								</div>
								<div class="panel-body">
									<form id="" class="" action="">
										<span class="con-item"><span>会员登录名</span><input type="text" class="notspecial" id="logName" ></span>
										<span class="con-item"><span>企业名称</span><input type="text" class="notspecial" id="companyName" ></span>
										<span class="con-item"><span>状态</span><select class="auditState" id="statu"><option value="1">待审核</option ><option value="2">通过</option><option value="3">驳回</option></select></span>
										<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									</form>
							  	</div>
							 </div>
						</div> 		
						<div class="buttonCombination" style="display:inline-block">
							<button class="cerfiedBtn" onclick="jump(<%=content %>,1,'web/member/companyVitureResualt.jsp')">认证</button>
							<button class="checkBtn" onclick="jump(<%=content %>,2,'web/member/companyVitureResualt.jsp')">查看</button>
						</div>
						<div id="panel-body" class="panel-body">
							<table id="table_id" class="display">
								<thead>
								</thead>
								<tbody>
							    </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	
		<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/companyMembers.js"></script>
	<script type="text/javascript" src="js/member/companyIdentyList/carHolderList.js"></script>
	<script type="text/javascript">
		  var attestTypeId= <%=content%>;
		  IdentyList(attestTypeId);//认证列表
	</script>
</body>