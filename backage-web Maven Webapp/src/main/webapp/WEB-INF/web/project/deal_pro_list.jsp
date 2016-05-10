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
	<title>项目管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
</head>
<!-- 贷后管理---------成交项目列表 -->
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
				<jsp:param value="30601" name="_index_m3"/>
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
									<span class="con-item"><span>项目编号</span><input type="text" class="notspecial Project_No"/></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="notspecial Logname" /></span>
									<span class="con-item"><span>借款人姓名</span><input type="text" class="notspecial Personal_Name" /></span>
									<span class="con-item"><span>借款期限</span><input type="text" class="notspecial w1 Deadline"/><select class="w2 Deadline_Type"><option value="">请选择</option><option value="0">天</option><option value="1">月</option><option value="2">年</option></select></span>
									
									<span class="con-item"><span>实际借款金额</span><input type="text" class="notspecial dateInput Real_Amount_Min" />-&nbsp;&nbsp;<input type="text" class="notspecial dateInput Real_Amount_Max"  /></span>
									<span class="con-item"><span>还款方式</span><input type="text" class="notspecial Repay_Way"/></span>
									<span class="con-item"><span>合同约定下一个还款日</span><input type="text" class="notspecial Wdate" onFocus="WdatePicker()"/></span>
									<span class="con-item"><span>还款状态</span>
										<select id="statu">
											<option value="">请选择</option>
											<option value="0">未还款</option>
											<option value="1">还款中</option>
											<option value="2">已还清</option>
										</select>
									</span>
									<button  type ="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="deal_list_pro_detail" class="obtn glyphicon glyphicon-plus">项目详情</button>
						  			<button id="deal_list_pay_detail" class="obtn glyphicon glyphicon-plus">还款详情</button>
						  			<button id="deal_list_suppervision" class="obtn glyphicon glyphicon-plus">贷后监管</button>
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
			
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/project/deal_pro_list.js"></script>
	<!-- 私用js -->
		</div>
	</div>
</body>

</html>