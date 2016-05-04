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
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/guarantee_manage.css"></link>
	<link rel="stylesheet" href="css/recommend/compensatory-payment-records.css"/></link>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="9" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-recommend.jsp"></jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="nav-tabs-con active">
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
									<div>
										<span class="con-item textRight2">
											<span>项目编号</span><input type="text" class="notspecial" />
										</span>
										<span class="con-item textRight2">
											<span>项目名称</span><input type="text" class="notspecial" />
										</span>
										<span class="con-item textRight2">
											<span>借款人用户名</span><input type="text" class="notspecial" />
										</span>
									</div>
									<div>
										<span class="con-item textRight2">
											<span>借款人姓名</span><input type="text" class="notspecial" />
										</span>
										<span class="con-item textRight4">
											<span>回款时间</span><input type="text" id="startDate" class="dateInput Wdate notspecial" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
										</span>
										<button class="obtn obtn-query glyphicon glyphicon-search compayrecbtn">查询</button>
									</div>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel-heading">
							<div class="action_item">
								<button id class="obtn glyphicon glyphicon-plus obtn-export">导出</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>项目编号</th>
										<th>项目名称</th>
										<th>回款项目期数</th>
										<th>借款人用户名</th>
										<th>借款人姓名</th>
										<th>回款金额</th>
										<th>回款时间</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox"></td>
										<td>项目编号</td>
										<td>项目名称</td>
										<td>回款项目期数</td>
										<td>借款人用户名</td>
										<td>借款人姓名</td>
										<td><span class="moneyFormat">1000</span>元</td>
										<td>回款时间</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- 尾部 -->
			<div class="all"></div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript">
		$('#table_id').DataTable({
			//"scrollY":400,
			"scrollX":true,
			//"autoWidth" : false,
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
</body>

</html>
