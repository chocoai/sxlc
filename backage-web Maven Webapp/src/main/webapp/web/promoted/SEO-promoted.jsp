<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>平台推广管理-SEO设置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/SEO-promoted.css" type="text/css">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="10" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-promoted.jsp">
				<jsp:param value="1005" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-dept-add" onclick="addSEO();">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-dept-mod" onclick="alertSEO();">修改</button>
									<button class="obtn glyphicon glyphicon-trash obtn-dept-del">删除</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
								</table>
							</div>
							
						</div>
					</div>
				
				
					<!-- 添加部分  -->
					<div class="" id="addSEO">
						<form id="addSEOForm" action="javascript:addSeo()" type="post">
							<div>
								<span class="tt">title设置：</span>
								<span class="col"><input id="seoTitle" class="notspecial" datatype="describeC"></span>
							</div>
							<div>
								<span class="tt">Description描述设置：</span>
								<span class="col"><input id="seoDescription" class="notspecial" datatype="describeC"></span>
							</div>
							<div>
								<span class="tt">Keyword关键词设置：</span>
								<span class="col"><input id="seoKeyword" class="notspecial" datatype="describeC"></span>
							</div>
							<div>
								<span class="tt">设置类型：</span>
								<span class="col">
									<select id="seoTypeName">
									</select>
								</span>
							</div>
							<div class="btnAdd">
								<button id="insertSEO" class="addBtn">添加</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
					<!-- 修改SEO设置   -->
					<div class="" id="alertSEO">
						<form id="alertSEOForm" action="javascript:modseo()" type="post">
							<div>
								<span class="tt">title设置：</span>
								<span class="col"><input id="mseoTitle" class="notspecial" datatype="describeC"></span>
							</div>
							<div>
								<span class="tt">Description描述设置：</span>
								<span class="col"><input id="mseoDescription" class="notspecial" datatype="describeC"></span>
							</div>
							<div>
								<span class="tt">Keyword关键词设置：</span>
								<span class="col"><input id="mseoKeyword" class="notspecial" datatype="describeC"></span>
							</div>
							<div>
								<span class="tt">设置类型：</span>
								<span class="col">
									<select id="mseoTypeName">
									</select>
								</span>
							</div>
							<div class="btnAdd">
								<button id="alterSEO" class="alertBtn">修改</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/promoted/SEO-promoted.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>