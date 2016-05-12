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
	<title>财务管理-佣金发放记录</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/finance/fn-recharge.css" type="text/css"/>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="4" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-finance.jsp">
				<jsp:param value="409" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="search">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li>
										<a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a>
									</li>
								</ul>
							</div>
						</div>
					<div class="panel-body">
						<form id="" class="" action="">
							<div class="cmsRe">
								<span class="con-item textRight3">
									<span>会员编号</span><input id="memberNo" type="text" class="" placeholder="" />
								</span>
								<span class="con-item textRight3">
									<span>姓名</span><input id="personalName" type="text" class="" placeholder="" />
								</span>
								<span class="con-item textRight3">
									<span>联系电话</span><input id="personalPhone" type="text" class="" placeholder="" />
								</span>
								<span class="con-item textRight4">
									<span>发放时间段</span><input type="text" id="startDate" class="dateInput Wdate notspecial" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
								</span>
								<span class="con-item textRight4">
									<span>提奖时间段</span><input type="text" id="tstartDate" class="dateInput Wdate notspecial" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="tendDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
								</span>
								<span class="con-item">
									<span>推广类型</span>
									<select id="types" class="rechargeoption choType">
										<option value="0">理财顾问</option>
										<option value="1">推荐达人</option>
									</select>
								</span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</div>
						</form>
					</div>
				</div>	
			</div>
			<div class="data_display">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="action_item">
							<button class="obtn glyphicon glyphicon-export" onclick="picAdd('导出','web/recommend/re-add/acc-recharge.jsp','1')">导出</button>
							<!-- onclick="accRecharge() -->
						</div>
					</div>
					<div class="panel-body">
						<table id="table_id" class="display">
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
	<script type="text/javascript" src="js/finance/fn-cms-record.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>