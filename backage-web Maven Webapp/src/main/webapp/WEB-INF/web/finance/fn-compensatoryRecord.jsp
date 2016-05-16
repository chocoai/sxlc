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
	<title>财务管理-代偿回款记录</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/finance/fn-compensatoryRecord.css"/></link>
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
				<jsp:param value="412" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="data_display">
					<div class="panel panel-success">
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
												<span>产品类型</span>
												<select id="projectName">
												</select>
											</span>
											<span class="con-item textRight2">
												<span>项目名称</span><input id="projectTitle" type="text" class="notspecial" />
											</span>
											<span class="con-item textRight2">
												<span>借款人用户名</span><input id="logname" type="text" class="notspecial" />
											</span>
											<span class="con-item textRight2">
												<span>借款人姓名</span><input id="personName" type="text" class="notspecial" />
											</span>
											<span class="con-item textRight2">
												<span>借款人手机号</span><input id="personalPhone" type="text" class="notspecial" />
											</span>
											<span class="con-item textRight4">
												<span>回款时间</span><input type="text" id="bstartDate" class="dateInput Wdate notspecial" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="bendDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
											</span>
											<span class="con-item textRight4">
												<span>代偿时间</span><input type="text" id="startDate" class="dateInput Wdate notspecial" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
											</span>
											<button type="button" class="obtn obtn-query glyphicon glyphicon-search compayrecbtn">查询</button>
									</form>
							  	</div>
							 </div>
						</div> 
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-pencil">导出</button>
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
						<label class="compensation" for="compensation"><input type="radio" name="compensation" id="compensation">代偿选择平台代偿</label>
						<label class="compensation" for="compensation1"><input type="radio" name="compensation" id="compensation1">风险保证金代偿</label>
					</form>
				<!-- 代偿部分结束 -->   
			</div>
			<!-- 尾部 -->
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/finance/fn-compensatoryRecord.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
	</div>
</body>

</html>