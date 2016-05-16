<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
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
	<link rel="stylesheet" href="css/project/loan_pro_exam.css" type="text/css">
</head>
<!-- 借款审核--------列表详情展示 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="303" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
						<input type="hidden" id="pushIndex" value="${pushIndex}" />
						<input type="hidden" id="sIndexs" value="${sIndexs}" />
						<c:if test="${fn:length(process) > 0}">
							<c:forEach var="item" items="${process}">
								<c:if test="${sIndexs == item.indexs}">
									<li role="presentation" sIndexs="${item.indexs}" class="active showUlLi"><a>${item.apName}</a></li>
								</c:if>
								<c:if test="${sIndexs != item.indexs}">
									<li role="presentation" sIndexs="${item.indexs}" class="showUlLi"><a>${item.apName}</a></li>
								</c:if>
							</c:forEach>
						</c:if>		
						<c:if test="${fn:length(process) == 0}">
							<li role="presentation" class="active">无审批流程数据</li>
						</c:if>		
				</ul>
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>项目名称</span><input type="text" class="ProjectTitle"></span>
									<span class="con-item"><span>借款人申请时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="Logname"></span>
									<span class="con-item"><span>借款人姓名</span><input type="text" class="name"></span>
									<span class="con-item">
										<span>项目状态</span>
										<select id="statu">
											<option value="">选择</option>
											<option value="-1">未通过</option>
											<option value="1">通过</option>
										</select>
									</span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
					  				<button id="loan_pro_exam" class="obtn glyphicon glyphicon-plus" onclick="proAudit()">项目审核</button>
									<button id="loan_pro_detail" class="obtn glyphicon glyphicon-pencil" onclick="view_detail()">项目详情</button>
									<button id="history_exam_record" class="obtn glyphicon glyphicon-ok-circle">历史审批记录</button>
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
	<script src="js/project/loan_exam.js"></script>
	<!-- 私用js -->
		</div>
	</div>
</body>

</html>