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
									<span class="con-item"><span>项目名称</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>项目审批通过时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<span class="con-item"><span>项目申请编号</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>项目编号</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>借款人编号</span><input type="text" class="notspecial"/></span>
									<span class="con-item"><span>借款人名称</span><input type="text" class="notspecial"/></span>
									<span class="con-item">
										<span>状态</span>
										<select>
											<option>未通过</option>
											<option>通过</option>
										</select>
									</span>
									<span class="con-item"><span>项目发布时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
							</div>
						</div>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
					  		<div class="panel-heading">
					  			<div class="action_item">
					  				<a href="web/project/pro-add/loan_pro_post.jsp"><button id="post" class="obtn glyphicon glyphicon-plus">发布</button></a>
									<button id="refuse" class="obtn glyphicon glyphicon-pencil">拒绝</button>
									<button id="post_pro_detail" class="obtn glyphicon glyphicon-pencil" onclick="view_detail()">项目详情</button>
									<button id="end_time_along" class="obtn glyphicon glyphicon-trash">项目借款结束日期延长</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_post_list" class="display">
									<thead>
										<tr>
											<th></th>
											<th>项目名称</th>
											<th>项目审批通过日期</th>
											<th>项目申请编号</th>
											<th>项目编号</th>
											<th>借款人编号</th>
											<th>借款人用户名</th>
											<th>借款人名称</th>
											<th>产品类型</th>
											<th>借款期限</th>
											<th>借款金额</th>
											<th>年化利率</th>
											<th>状态</th>
											<th>项目发布时间</th>
										</tr>
									</thead>
								<tbody>
								<%for (int i = 0; i < 15; i++) {%>
									<tr>
										<td><input type="checkbox"></td>
										<td>项目名称</td>
										<td>2016-5-4</td>
										<td>000001</td>
										<td>001</td>
										<td>123</td>
										<td>用户名</td>
										<td>名称</td>
										<td>产品类型</td>
										<td>2016-5-4</td>
										<td>20万</td>
										<td>4%</td>
										<td>状态</td>
										<td>2016-5-1</td>
									</tr>
								<%}%>
								</tbody>
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