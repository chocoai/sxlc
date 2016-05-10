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
	<title>平台推广-关系年限</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/promotedCom.css" type="text/css">
	<link rel="stylesheet" href="css/promoted/pro-redEnvelope.css" type="text/css">
	
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="10" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-promoted.jsp">
				<jsp:param value="1006" name="_index_m2"/>
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
									<span class="con-item"><span>注册时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>注册时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>注册时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>状态</span><select><option>已通过</option><option>已拒绝</option><option>已踢出</option><option>拒绝后重新申请</option></select></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-dept-add" onclick="addRedE();">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-dept-mod" onclick="alertRedE();">修改</button>
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export">发布</button>
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export" onclick="window.location.href='<%=path %>/web/promoted/pro-receiveDetail.jsp'">领取明细</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>活动添加时间</th>
											<th>活动开始时间</th>
											<th>活动结束时间</th>
											<th>活动名称</th>
											<th>活动红包总个数</th>
											<th>活动红包总金额(元)</th>
											<th>已领取活动红包总金额(元)</th>
											<th>剩余活动红包总金额(元)</th>
											<th>状态</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>活动添加时间</td>
											<td>活动开始时间</td>
											<td>活动结束时间</td>
											<td>活动名称</td>
											<td>活动红包总个数</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">10000</td>
											<td class="moneyFormat">10000</td>
											<td>状态</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
							
						</div>
					</div>
					
					<!-- 添加部分  -->
					<div class="" id="addRedE">
						<form id="addRedEForm">
							<div>
								<span class="tt">活动起止时间：</span>
								<span class="col"><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
							</div>
							<div>
								<span class="tt">活动名称：</span>
								<span class="col"><input class="notspecial" datatype="describeC"></span>
							</div>
							<div>
								<div class="redEContent">
									<span class="tt">红包金额：</span>
									<span class="col"><input datatype="acountM" class="moneyInput">元<input datatype="nNum1" class="moneyInput">个<a class="redEAdd">增加</a></span>
								</div>
							</div>
							<div>
								<span class="tt">活动有效期：</span>
								<span class="col"><input type="text" class="notspecial Wdate" onFocus="WdatePicker()"/></span>
							</div>
							<div class="btnAdd">
								<button class="addBtn">添加</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
					
					
					<!-- 修改部分 -->
					<div class="" id="alertRedE">
						<form id="alertRedEForm">
							<div>
								<span class="tt">活动起止时间时间：</span>
								<span class="col"><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
							</div>
							<div>
								<span class="tt">活动名称：</span>
								<span class="col"><input class="notspecial" datatype="describeC"></span>
							</div>
							<div>
								<div class="redEContent">
									<span class="tt">红包金额：</span>
									<span class="col"><input datatype="acountM" class="moneyInput">元<input datatype="nNum1" class="moneyInput">个<a class="redEAdd">增加</a></span>
								</div>
							</div>
							<div>
								<span class="tt">活动有效期：</span>
								<span class="col"><input type="text" class="notspecial Wdate" onFocus="WdatePicker()"/></span>
							</div>
							<div class="btnAdd">
								<button class="addBtn">添加</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/promoted/pro-redEnvelope.js"></script>
	<script type="text/javascript">
				// 这样初始化，排序将会打开
				$(function() {
					$('#applicationAudit').DataTable({
						"autoWidth" : true,
						"scrollX": true,
						//"scrollY": true,
						//paging : false,//分页
						
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [[ 1,2,3, "desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 4, 5, 6,7,8,9]
						} // 制定列不参与排序
						],
						colReorder : false,
						"scrollX": true,
						"sScrollX" : "100%",
						"sScrollXInner" : "100%",
						"bScrollCollapse" : true
					});
				});
			</script>
</body>

</html>