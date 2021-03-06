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
	<title>项目管理-催收已还账单</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
</head>
<!-- 贷后管理-------项目催收-------催收已还账单 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="306" name="_index_m2"/>
				<jsp:param value="30606" name="_index_m3"/>
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
									<span class="con-item"><span>借款项目编号</span><input type="text" class="notspecial Project_No"/></span>
									<span class="con-item"><span>借款项目名称</span><input type="text" class="notspecial Project_Title"/></span>
									<span class="con-item"><span>借款人</span><input type="text" class="notspecial Personal_Name"/></span>
									<span class="con-item"><span>账单编号</span><input type="text" class="notspecial Merbill_No"/></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-bill-detail">账单详情</button>
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-loan-prodetail">借款项目详情</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_id" class="display">
								</table>
							</div>
						</div>
						<!-- 账单详情 -->
						<div class="w-content bill_detail">
							<table>
								<tr class="col-md-6">
									<td class="tt"><label>借款项目编号：</label></td>
									<td class="con">
										<span id="projectNo"></span>
									</td>
								</tr>
								<tr class="col-md-6">	
									<td class="tt"><label>账单编号：</label></td>
									<td class="con">
										<span id="merbillNo"></span>
									</td>
								</tr>	
								<tr class="col-md-6">
									<td class="tt"><label>借款项目名称：</label></td>
									<td class="con">
										<span id="projectTitle"></span>
									</td>
								</tr>	
								<tr class="col-md-6">	
									<td class="tt"><label>借款人：</label></td>
									<td class="con">
										<span id="memberName"></span>
									</td>
								</tr>	
								<tr class="col-md-6">	
									<td class="tt"><label>账单金额：</label></td>
									<td class="con">
										<span  id="amounts"></span>元
									</td>
								</tr>	
								<tr class="col-md-6">	
									<td class="tt"><label>账单期数：</label></td>
									<td class="con">
										<span  id="indexs"></span>
									</td>
								</tr>
								<tr class="col-md-6">	
									<td class="tt"><label>实际还款时间：</label></td>
									<td class="con">
										<span id="repayTime"></span>
									</td>
								</tr>	
								<tr class="col-md-6">	
									<td class="tt"><label>逾期时长：</label></td>
									<td class="con">
										<span id="overDay"></span>天
									</td>
								</tr>	
								<tr class="col-md-6">	
									<td class="tt"><label>逾期费用：</label></td>
									<td class="con">
										<span  id="overdueAmounts"></span>元
									</td>
								</tr>		
								<tr class="col-md-12">	
									<td class="tt"><label>账单展示：</label></td>
									<td class="con">
										<span  id=""></span>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<!-- 尾部 -->
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/project/collection_has_bill.js"></script>
	<!-- 私用js -->
</body>

</html>