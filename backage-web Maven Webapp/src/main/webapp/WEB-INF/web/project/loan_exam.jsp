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
					<li role="presentation" class="active"><a href="javascript:;">一审</a></li>
					<li role="presentation"><a href="javascript:;">二审</a></li>
					<li role="presentation"><a href="javascript:;">三审</a></li>
					<li role="presentation"><a href="web/project/post_list.jsp">项目发布</a></li>
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
									<span class="con-item col-md-2"><span>类型名称</span><input type="text" class=""></span>
									<span class="con-item"><span>借款人申请时间</span><input type="text" class=""></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class=""></span>
									<span class="con-item"><span>借款人姓名</span><input type="text" class=""></span>
									<span class="con-item"><span>项目状态</span><input type="text" class=""></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
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
								<table id="table_loan_detail_list" class="display">
									<thead>
										<tr>
											<th></th>
							                <th>借款人申请日期</th>
							                <th>借款申请项目编号</th>
							                <th>借款人用户名</th>
							                <th>借款人姓名</th>
							                <th>借款项目名称</th>
							                <th>借款产品类型</th>
							                <th>借款期限</th>
							                <th>借款金额</th>
							                <th>年化利率</th>
							                <th>还款方式</th>
							                <th>状态</th>
							            </tr>
							        </thead>
							        <tbody>
							        <%for (int i = 0; i < 15; i++) {%>
							        	<tr>
							        		<td><input type="checkbox"></td>
							        		<td>20160427</td>
							                <td>000001</td>
							                <td>用户名</td>
							                <td>姓名</td>
							                <td>项目名称</td>
							                <td>产品类型</td>
							                <td>20天</td>
							                <td>30万</td>
							                <td>2%~15%</td>
							                <td>还款方式</td>
							                <td>审核中</td>
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
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/project/loan_exam.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
	$('#table_loan_detail_list').DataTable({
		scrollX:true,
		autoWidth : false,
		"aaSorting" : [ ],//默认第几个排序
		"aoColumnDefs" : [
		//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
		{
			"orderable" : false,
			"aTargets" : [0,1,2,3,4,5,6,7,8,9,10,11]
		} // 制定列不参与排序
		],
	});
	</script>
		</div>
	</div>
</body>

</html>