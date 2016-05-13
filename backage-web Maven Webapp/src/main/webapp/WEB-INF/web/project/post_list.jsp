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
	<title>项目发布</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/project/post_list.css" type="text/css"></link>
</head>
<!-- 项目发布--------列表信息查询展示 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="304" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<input type="hidden" id="pushIndex" value="${pushIndex}" />
					<c:if test="${fn:length(process) > 0}">
						<c:forEach var="item" items="${process}">
							<c:if test="${item.pushIndex == item.indexs}">
								<li role="presentation" sIndexs="${item.indexs}" class="active showUlLi"><a  href="javascript:void(0);">${item.apName}</a></li>
							</c:if>
							<c:if test="${item.pushIndex != item.indexs}">
								<li role="presentation" sIndexs="${item.indexs}" class="showUlLi"><a href="javascript:void(0);">${item.apName}</a></li>
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
									<span class="con-item"><span>项目名称</span><input type="text" class="notspecial ProjectTitle"/></span>
									<span class="con-item"><span>项目编号</span><input type="text" class="notspecial projectNO"/></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="notspecial Logname"/></span>
									<span class="con-item"><span>借款人编号</span><input type="text" class="notspecial memberNo"/></span>
									<span class="con-item"><span>借款人名称</span><input type="text" class="notspecial name"/></span>
									<span class="con-item">
										<span>状态</span>
										<select class="checkStatu">
											<option value="">选择</option>
											<option value="0">未发布</option>
											<option value="1">已发布</option>
										</select>
									</span>
									<span class="con-item"><span>项目发布时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
							</div>
						</div>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
					  		<div class="panel-heading">
					  			<div class="action_item">
					  				<button id="post" class="obtn glyphicon glyphicon-plus" onclick="proPost()">发布</button></a>
									<button id="refuse" class="obtn glyphicon glyphicon-pencil">拒绝</button>
									<button id="post_pro_detail" class="obtn glyphicon glyphicon-pencil" onclick="view_detail()">项目详情</button>
									<button id="end_time_along" class="obtn glyphicon glyphicon-trash">项目借款结束日期延长</button>
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
		<!-- 延长时期的弹出层 -->
		<div class="extendTime">
			<div class="container add_type_contianer">
    			<form class="form-horizontal">
    				<div class="form-group formGroup">
	    				<label for="modify_endTime" class="col-sm-4 control-label">项目借款结束日期:</label>
    					<div class="col-sm-8">
    						<input type="text"  class="form-control notspecial Wdate formControl" name="modify_endTime" id="modify_endTime" onFocus="WdatePicker()">
    					</div>
	    			</div>
	    			<div class="form-group formGroup">
	    				<div class="formGroup-sub">
	    					<button type="submit" class="btn btn-success">确认延长</button>
	    				</div>
	    			</div>
    			</form>
    		</div>
		</div>
		<!-- 公用js -->
		<jsp:include page="../common/cm-js.jsp"></jsp:include>
		<!-- 私用js -->
		<script src="js/project/post_list.js"></script>
	</div>
</div>
</body>

</html>