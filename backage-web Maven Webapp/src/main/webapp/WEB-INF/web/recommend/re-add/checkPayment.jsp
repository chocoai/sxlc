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
	<title>保荐机构管理-担保机构管理</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/guarantee_manage.css"></link>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 代偿回款查询部分开始 -->
			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<div id="checkPayment" class="search">
				<div class="panel panel-success">
					<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a>
										</li>
									</ul>
								</div>
							</div>
					<div class="panel-body">
						<form id="" class="" action="">
							<span class="con-item col-md-3 col-sm-4 col-xs-6">
								<span>项目编号</span><input type="text" class="" placeholder="" />
							</span>
							<span class="con-item col-md-3 col-sm-4 col-xs-6">
								<span>项目名称</span><input type="text" class="departmentname" placeholder="" />
							</span>
							<span class="con-item col-md-3 col-sm-4 col-xs-6">
								<span>借款人用户名</span><input type="text" class="contactname" placeholder="" />
							</span>
							<span class="con-item col-md-3 col-sm-4 col-xs-6">
								<span>借款人姓名</span><input type="text" class="contactname" placeholder="" />
							</span>
							<span class="con-item col-md-3 col-sm-4 col-xs-6">
								<span>回款时间</span><input type="text" class="contactname" placeholder="" />
							</span>
							<span class="con-item col-md-3 col-sm-4 col-xs-6">
								<span>担保机构名称</span><input type="text" class="contactname" placeholder="" />
							</span>
							<span class="col-md-6 col-sm-12 col-xs-12">
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</span>
						</form>
					</div>
				</div>
				<table id="checkpaymenttable" class="display">
					<thead>
						<tr>
							<th class="table-checkbox"></th>
							<th>项目编号</th>
							<th>项目名称</th>
							<th>回款项目期数</th>
							<th>借款人用户名</th>
							<th>借款人姓名</th>
							<th>担保机构名称</th>
							<th>回款金额</th>
							<th>回款时间</th>
						</tr>
					</thead>
					<tbody>
						<%for(int m=0;m<5;m++){ %>
						<tr>
							<td><input type="checkbox" /></td>
							<td>项目编号</td>
							<td>项目名称</td>
							<td>回款项目期数</td>
							<td>借款人用户名</td>
							<td>借款人姓名</td>
							<td>担保机构名称</td>
							<td>回款金额</td>
							<td>回款时间</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<!-- 代偿回款查询部分结束 -->
		</div>
	</div>
</body>
<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="../js/recommend/guarantee-manage.js"></script>
	<script type="text/javascript">
		$('#checkpaymenttable').DataTable({
			"aaSorting" : [ [ 6,7, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5]
			} // 制定列不参与排序
			],
		});
	</script>
</html>