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
	<title>财务管理-项目放款管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/finance/fn-pro-lending.css"/>
</head>
<!-- 伍成然2016-05-09 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="4" name="_index_m1"/>
			</jsp:include>
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-finance.jsp">
				<jsp:param value="401" name="_index_m2"/>
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
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>项目编号</span><input type="text" class="notspecial"></span>
									<span class="con-item"><span>借款人用户名</span><input type="text" class="notspecial"></span>
									<span class="con-item"><span>借款人姓名</span><input type="text" class="notspecial"></span>
									<span class="con-item"><span>项目发布日期</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })">-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"></span>
									<span class="con-item"><span>借款期限</span><input type="text" class="notspecial w1">
										<select class="w2">
											<option>请选择</option>
											<option>天</option>
											<option>月</option>
										</select>
									</span>
									<span class="con-item"><span>借款金额</span><input type="text" class="notspecial dateInput" />-&nbsp;&nbsp;<input type="text" class="notspecial dateInput"></span>
									<span class="con-item"><span>项目状态</span>
										<select class="w3">
											<option>请选择</option>
											<option>未放款</option>
											<option>已放款</option>
											<option>已流标</option>
										</select>
									</span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
							  		<button id="" class="obtn glyphicon glyphicon-plus obtn-export">放款</button>
						  			<button id="" class="obtn glyphicon glyphicon-plus tobe_lending_invest_record">流标</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_pro_lending" class="display">
									<thead>
										<tr>
											<th></th>
											<th>融资结束时间</th>
											<th>项目编号</th>
											<th>产品类型</th>
											<th>项目名称</th>
											<th>借款人用户名</th>
											<th>借款人姓名</th>
											<th>借款金额</th>
											<th>实际借款金额</th>
											<th>融资进度(%)</th>
											<th>平台直扣金额</th>
											<th>项目保证金</th>
											<th>借款管理费</th>
											<th>实际放款金额</th>
											<th>放款时间</th>
											<th>状态</th>
										</tr>
									</thead>
									<tbody>
										<%
											for(int i=0;i<15;i++){
										 %>
										<tr>
											<td><input type="checkbox"></td>
											<td>2016-05-10</td>
											<td>100001</td>
											<td>产品类型</td>
											<td>项目名称</td>
											<td>用户名</td>
											<td>借款人</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">1200</td>
											<td>50</td>
											<td class="moneyFormat">800</td>
											<td class="moneyFormat">50</td>
											<td class="moneyFormat">50</td>
											<td class="moneyFormat">1500</td>
											<td>2016-05-12</td>
											<td>未放款</td><!-- 未放款、已放款、已流标 -->
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
			</div>
			<!-- 公用js -->
			<jsp:include page="../common/cm-js.jsp"></jsp:include>
			<!-- 私用js -->
			<script src=""></script>
			<script type="text/javascript">
			//默认禁用搜索和排序
			/* $.extend( $.fn.dataTable.defaults, {
			    searching: true,
			    ordering:  false
			} ); */
			// 这样初始化，排序将会打开
			$(function() {
				$('#table_pro_lending').DataTable({
					"autoWidth" : true,
					"scrollX": true,
					//"scrollY": true,
					//paging : false,//分页
					
					//"searching" : false,
					"info" : false,//左下角信息
					//"ordering": false,//排序
					"aaSorting" : [[ 7, "desc"],[ 8, "desc"],[ 14, "desc"]],//默认第几个排序
					"aoColumnDefs" : [
					//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
					{
						"orderable" : false,
						"aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13, 15]
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
		</div>
	</div>
</body>			
