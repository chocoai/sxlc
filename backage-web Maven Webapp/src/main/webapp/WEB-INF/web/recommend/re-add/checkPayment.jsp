<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String content = request.getParameter("content");
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>保荐机构管理-担保机构管理</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/guarantee_manage.css"></link>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 代偿回款查询部分开始 -->
			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<div id="checkPayment" class="search">
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
						<input type="hidden" id="guId" value="<%=content %>" />
							<div>
								<span class="con-item textRight2">
									<span>项目编号</span><input id="projectNo" type="text" class="" placeholder="" />
								</span>
								<span class="con-item textRight2">
									<span>项目名称</span><input id="projectTitle" type="text" class="departmentname" placeholder="" />
								</span>
								<span class="con-item textRight2">
									<span>借款人用户名</span><input id="logname" type="text" class="contactname" placeholder="" />
								</span>
							</div>
							<div>
								<span class="con-item textRight2">
									<span>借款人姓名</span><input id="personalName" type="text" class="contactname" placeholder="" />
								</span>
								<span class="con-item textRight2">
									<span>担保机构名称</span><input id="guaranteeName" type="text" class="contactname" placeholder="" />
								</span>
								<span class="con-item textRight2">
									<span>回款时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate2\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate2\')}' ,maxDate:'2020-10-01' })" >
								</span>
							</div>
							<div class="checkstatebtn">
								<span class="">
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</span>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<table id="checkpaymenttable" class="display">
				</table>
			</div>
			<!-- 代偿回款查询部分结束 -->
		</div>
	</div>
</body>
<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="../js/recommend/guarantee-manage.js"></script>
	<script type="text/javascript" src="plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/recommend/checkPayment.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</html>