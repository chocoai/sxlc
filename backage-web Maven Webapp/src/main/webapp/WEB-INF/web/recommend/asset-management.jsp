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
	<title>保荐机构管理-资产管理方管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/asset-management.css"/>
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
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
				<jsp:param value="902" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- tab切换 -->
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a>
										</li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<div>
										<span class="con-item  textRight2">
											<span>编号</span><input id="managementNO" type="text" class="notspecial" placeholder="" />
										</span>
										<span class="con-item textRight2">
											<span>资产管理方名称</span><input id="managementName" type="text" class="notspecial" placeholder="" />
										</span>
										<span class="con-item textRight2">
											<span>营业执照号</span><input id="companyeBLN" type="text" class="notspecial" placeholder="" />
										</span>
									</div>
									<div>
										<span class="con-item textRight2">
											<span>联系人姓名</span><input id="contactName" type="text" class="notspecial" placeholder="" />
										</span>
										<span class="con-item textRight2">
											<span>联系人手机号</span><input id="contactPhone" type="text" class="notspecial" placeholder="" />
										</span>
										<span class="con-item textRight4">
											<span>状态</span>
											<select id="recordStatus" class="stateSelect">
												<option value="1">请选择</option>
												<option value="1">有效</option>
												<option value="0">无效 </option>
											</select>
										</span>
										<span class="stateassetbtn">
											<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</span>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus" onclick="assetAdd()">添加</button>
									<button class="obtn glyphicon glyphicon-pencil" onclick="assetMod()">修改</button>
									<button class="obtn" onclick="assetDetail()">查看详情</button>
									<button class="obtn" onclick="assetAdmainManager()">管理员管理</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="assettable" class="display">
								</table>
							</div>
							
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/asset-management.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
</body>

</html>