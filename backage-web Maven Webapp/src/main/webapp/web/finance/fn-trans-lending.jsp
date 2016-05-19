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
	<title>财务管理-债券转让放款管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/finance/fn-pro-lending.css"/>
</head>
<!-- 伍成然2016-05-09 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="4" name="_index_m1"/>
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-finance.jsp">
				<jsp:param value="402" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
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
									<span class="con-item"><span>项目名称</span><input type="text" class="notspecial"></span>
									<span class="con-item"><span>借款会员</span><input type="text" class="notspecial"></span>
									<span class="con-item"><span>转让会员</span><input type="text" class="notspecial"></span>
									<span class="con-item"><span>转让金额</span><input type="text" class="notspecial"></span>
									<span class="con-item"><span>转让价格</span><input type="text" class="notspecial"></span>
									<span class="con-item">
										<span>项目状态</span>
										<select class="w3">
											<option>请选择</option>
											<option>待放款</option>
											<option>已完成</option>
										</select>
									</span>
									<span class="con-item"><span>放款时间</span><input type="text" id="loanStartDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'loanEndDate\')||\'2020-10-01\'}' })">-&nbsp;&nbsp;<input type="text" id="loanEndDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'loanStartDate\')}' ,maxDate:'2020-10-01' })"></span>
									<span class="con-item"><span>流标时间</span><input type="text" id="failStartDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'failEndDate\')||\'2020-10-01\'}' })">-&nbsp;&nbsp;<input type="text" id="failEndDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'failStartDate\')}' ,maxDate:'2020-10-01' })"></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
							  		<button id="loan" class="obtn glyphicon glyphicon-plus obtn-export">放款</button>
						  			<button id="pass" class="obtn glyphicon glyphicon-plus tobe_lending_invest_record">流标</button>
								</div>
								<form id="form1" action="lending/loan.do" type="post">
									<input id="stype" name="stype" type="hidden" value="" />
									<input id="projectId" name="projectId" type="hidden" value="" />
									<input id="auditType" name="auditType" type="hidden" value="" />
								</form>
							</div>
							<div class="panel-body">
								<table id="table_pro_lending" class="display">
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 公用js -->
			<jsp:include page="../common/cm-js.jsp"></jsp:include>
			<!-- 私用js -->
			<script type="text/javascript" src="js/finance/fn-trans-lending.js"></script>
			<script src=""></script>
		</div>
	</div>
</body>			
</html>