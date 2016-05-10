<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link rel="stylesheet" href="css/project/add_borrow.css" type="text/css">
</head>
<!-- 借款申请管理--直接意向借款 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="302" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation"><a href="project/toLoanApplyList">借款意向列表查询</a>
					</li>
					<li role="presentation" class="active"><a href="project/toLoanApplyPg">直接意向借款</a>
					</li>
				</ul>
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
									<span class="con-item"><span>会员编号</span><input id="memberNo" type="text" class="notspecial"></span>
									<span class="con-item"><span>会员用户名</span><input id="logname" type="text" class="notspecial"></span>
									<button  type="button"  class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="add_intention_loan" class="obtn glyphicon glyphicon-plus" onclick="addBorrow()">添加意向借款</button>
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
		<!-- 添加意向借款弹出层 -->	
		<div class="borrowingCull" id="con-account">
		  <form action="javascript:addData();" id="dataForm" method="post">
			<table >
				<tr>
					<td class="tt"><label>借款类型：</label></td>
					<td class="con">
						<select id="projectID" class="con-repayment">
							<c:forEach var="item" items="${proTypes}">
								<option value="${item.id}">${item.projectName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款人：</label></td>
					<td class="con">
						<input type="hidden" id="memberType" class="inputWidtn" maxlength="12">
						<input type="text" disabled="disabled" id="memberID" class="inputWidtn" maxlength="12">
						<button type="button"  class="obtn obtn-query" onclick="findBorrower()">查询</button>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款金额：</label></td>
					<td class="con">
						<input type="text" id="amount" class="inputWidtn" datatype="nNum" maxlength="8" >
						<span>元</span>
					</td>
				</tr>
				<tr>
					<td class="tt">项目期限：</td>
					<td class="con">
						<input id="deadline" type="text" class="inputWidtn" datatype="nNum" maxlength="4" >
						<select id="deadlineType" class="con-trim">
							<option value="2">年</option>
							<option value="1">月</option>
							<option value="0" selected = "selected">天</option>
						</select>
					</td>					
				</tr>
				<tr>
					<td class="tt"><label>年化利率：</label></td>
					<td class="con">
						<input id="yearRate" type="text" class="inputWidtn" datatype="hundredNum" maxlength="6">
						<span>%</span>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>还款方式：</label></td>
					<td class="con">
						<select id="repayWay" class="con-repayment">
							<option value="3">等额本金</option>
							<option value="0">等额本息</option>
							<option value="1">先息后本</option>
							<option value="2">到期还本息</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款用途：</label></td>
					<td class="con">
						<textarea id="uses" datatype="rolemarkC"></textarea>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>还款来源：</label></td>
					<td class="con">
						<textarea id="repaySource" datatype="rolemarkC"></textarea>
					</td>
				</tr>
				<tr>
					<td class="tt"><label>借款描述：</label></td>
					<td class="con" >
						<textarea id="projectDescript" datatype="rolemarkC"></textarea>
					</td>
				</tr>
			</table>
			</form>
		</div>
		<!-- 添加意向借款弹出层 -->
		<div class="borrower" style="display:none">
			<div class="panel-body">
				<form id="" class="" action="">
					<span class="con-item"><span>会员编号</span><input id="memberNo" type="text" class="notspecial"></span>
					<span class="con-item"><span>会员用户名</span><input id="memberName" type="text" class="notspecial"></span>
					<span class="con-item"><span>手机号</span><input id="personalPhone" type="text" class="notspecial"></span>
					<button  type="button" id="memberQuery" class="obtn obtn-query glyphicon glyphicon-search" >查询</button>
				</form>
		  	</div>
			<div class="data_display">
				<div class="panel panel-success">
					<div class="panel-body">
						<table id="table_borrow" class="display">
				    	</table>
				    </div>
				</div>
			</div>
		</div>	
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/project/loan_intention_2.js"></script>
	<!-- 私用js -->
		</div>
	</div>
</body>

</html>