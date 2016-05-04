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
	<title>财务管理-平台自有账户管理-提现</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/finance/fn-withdraw.css"/>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="4" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-finance.jsp">
				<jsp:param value="" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="search">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li>
										<a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a>
									</li>
								</ul>
							</div>
						</div>
					<div class="panel-body">
						<form id="" class="" action="">
							<div>
								<span class="con-item textRight3">
									<span>平台交易编号</span><input type="text" class="departmentname notspecial" placeholder="" />
								</span>
								<span class="con-item textRight3">
									<span>第三方交易流水号</span><input type="text" class="licencenum notspecial" placeholder="" />
								</span>
							</div>
							<div>
								<span class="con-item textRight2">
									<span>状态</span>
									<select class="rechargeoption">
										<option>请选择</option>
										<option>成功</option>
										<option>失败</option>
									</select>
								</span>
								<span class="con-item textRight4">
									<span>交易时间</span><input type="text" id="startDate" class="dateInput Wdate notspecial" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" >
								</span>
								<span class="">
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</span>
							</div>
						</form>
					</div>
				</div>	
			</div>
			<div class="data_display">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="action_item">
							<button class="obtn glyphicon glyphicon-plus" onclick="pAdd()">提现</button>
							<!-- onclick="accRecharge() -->
						</div>
					</div>
					<div class="panel-body">
						<table id="table_id" class="display">
							<thead>
								<tr>
									<th class="table-checkbox"></th>
									<th>交易时间</th>
									<th>平台交易编号</th>
									<th>第三方交易流水号</th>
									<th>提现金额</th>
									<th>提现手续费</th>
									<th>实际到账金额</th>
									<th>状态</th>
								</tr>
							</thead>
							<tbody>
								<%for (int i = 0; i < 15; i++) {%>
								<tr>
									<td class="table-checkbox"><input type="checkbox" /></td>
									<td>交易时间</td>
									<td>平台交易编号</td>
									<td>第三方交易流水号</td>
									<td>提现金额</td>
									<td>提现手续费</td>
									<td><span class="moneyFormat">1000</span>元</td>
									<td>成功</td>
								</tr>
								<%}%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/recharge-record.js"></script>	
	<script type="text/javascript">
		$('#table_id').DataTable({
			scrollX:true,
			autoWidth : false,
			"aaSorting" : [ [ 4,5,6] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,7]
			} // 制定列不参与排序
			],
		});
	</script>
</body>

</html>