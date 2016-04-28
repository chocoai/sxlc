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
			<!-- 担保项目查询部分开始 -->
			<jsp:include page="../../common/cm-addr.jsp"></jsp:include>
			<div id="checkProject" class="search">
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
							<div>
								<span class="con-item textRight3"><span>项目编号</span><input type="text" class="notspecial" ></span>
								<span class="con-item textRight3"><span>担保登记时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
							</div>
							<div>
								<span class="con-item textRight3"><span>项目名称</span><input type="text" class="notspecial" ></span>
								<span class="con-item textRight3"><span>最近代偿时间</span><input type="text" id="startDate1" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate1\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate1" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate1\')}' ,maxDate:'2020-10-01' })" ></span>
							</div>
							<div>
								<span class="con-item textRight3"><span>担保机构名称</span><input type="text" class="notspecial" ></span>
								<span class="con-item "><span>是否代偿</span>
									<select class="stateSelect">
										<option>请选择</option>
										<option>是</option>
										<option>否</option>
									</select>
								</span>
								<span class="statebtn">
									<button class="obtn obtn-query glyphicon glyphicon-search inquiryBtn">查询</button>
								</span>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="panel-body">
					<table id="checkProjectTable" class="display">
						<thead>
							<tr>
								<th class="table-checkbox"></th>
								<th>项目编号</th>
								<th>项目名称</th>
								<th>借款金额</th>
								<th>项目保证金</th>
								<th>担保机构名称</th>
								<th>担保登记时间</th>
								<th>是否代偿</th>
								<th>代偿金额</th>
								<th>最近代偿时间</th>
							</tr>
						</thead>
						<tbody>
							<%for(int k=0;k<5;k++){ %>
							<tr>
								<td><input type="checkbox" /></td>
								<td>项目编号</td>
								<td>项目名称</td>
								<td>借款金额</td>
								<td>项目保证金</td>
								<td>担保机构名称</td>
								<td>担保登记时间</td>
								<td>是否代偿</td>
								<td>代偿金额</td>
								<td>最近代偿时间</td>
							</tr>
							<%} %>
						</tbody>
				</table>
			</div>
			<!-- 担保项目查询部分结束 -->
</body>
<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="../js/recommend/guarantee-manage.js"></script>
	<script type="text/javascript" src="plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$('#checkProjectTable').DataTable({
			//"scrollY":400,
			"scrollX":true,
			"aaSorting" : [ [ 3,5,8, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,4,6,7]
			} // 制定列不参与排序
			],
		});
	</script>
</html>