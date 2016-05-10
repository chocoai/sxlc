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
	<title>保荐机构管理-代偿</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/compensatory.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="9" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-recommend.jsp">
				<jsp:param value="904" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus" onclick="compenFunction()">代偿</button>
								<button class="obtn glyphicon glyphicon-pencil" onclick="compenExport()">导出</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="table_id" class="display">
							</table>
						</div>
						
					</div>
				</div>
				<!-- 代偿部分开始 -->
				<div class="w-content" id="compenfunction">
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>项目编号：</span>
							<span>项目编号</span>
						</div>
						<div class="form-group">
							<span>项目名称：</span>
							<span>项目名称</span>
						</div>
					</form>
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>借款人姓名：</span>
							<span>借款人姓名</span>
						</div>
						<div class="form-group">
							<span>借款人用户名：</span>
							<span>借款人用户名</span>
						</div>
					</form>
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>期数：</span>
							<span>期数</span>
						</div>
						<div class="form-group">
							<span>本次代偿本金：</span>
							<span><label class="moneyFormat">1000</label><samp>元</samp></span>
						</div>
					</form>
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>本次代偿利息：</span>
							<span><label class="moneyFormat">1000</label><samp>元</samp></span>
						</div>
						<div class="form-group">
							<span>本次代偿逾期利息：</span>
							<span><label class="moneyFormat">1000</label><samp>元</samp></span>
						</div>
					</form>
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>本次代偿逾期罚金：</span>
							<span><label class="moneyFormat">1000</label><samp>元</samp></span>
						</div>
					</form>
				<!-- 代偿部分结束 -->   
			</div>
			<!-- 尾部 -->
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/compensatory.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>