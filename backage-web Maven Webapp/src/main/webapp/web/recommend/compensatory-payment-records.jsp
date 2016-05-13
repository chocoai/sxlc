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
	<title>保荐机构管理-担保机构管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/guarantee_manage.css"></link>
	<link rel="stylesheet" href="css/recommend/compensatory-payment-records.css"/></link>
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
				<jsp:param value="906" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span></a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
										<span class="con-item textRight2">
											<span>项目编号</span><input id="projectNo" type="text" class="notspecial" />
										</span>
										<span class="con-item textRight2">
											<span>项目名称</span><input  id="projectTitle" type="text" class="notspecial" />
										</span>
										<span class="con-item textRight2">
											<span>借款人用户名</span><input id="logname" type="text" class="notspecial" />
										</span>
										<span class="con-item textRight2">
											<span>借款人姓名</span><input id="personalName" type="text" class="notspecial" />
										</span>
										<span class="con-item textRight4">
											<span>回款时间</span><input type="text" id="startDate" class="dateInput Wdate notspecial" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
										</span>
										<button class="obtn obtn-query glyphicon glyphicon-search compayrecbtn">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel-heading">
							<div class="action_item">
								<button id class="obtn glyphicon glyphicon-plus obtn-export">导出</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- 尾部 -->
			<div class="all"></div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/recommend/compensatory-payment-records.js"></script>
	
	<!-- 私用js -->
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>
