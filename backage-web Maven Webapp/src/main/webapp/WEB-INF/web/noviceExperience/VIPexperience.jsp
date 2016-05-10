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
	<link rel="stylesheet" href="css/noviceExperience/noviceExperienceCom.css" type="text/css">
	
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="12" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-noviceExperience.jsp">
				<jsp:param value="1202" name="_index_m2"/>
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
									<span class="con-item"><span>会员编号</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>会员用户名</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>会员名称</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>是否发放</span><select><option>是</option><option>否</option></select></span>
									<span class="con-item"><span>开户时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>投资体验标时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export">导出</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>会员编号</th>
											<th>会员用户名</th>
											<th>会员名称</th>
											<th>开户时间</th>
											<th>投资体验标时间</th>
											<th>代金券面值(元)</th>
											<th>总收益金额(元)</th>
											<th>是否成功发放</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>会员编号</td>
											<td>会员用户名</td>
											<td>会员名称</td>
											<td>开户时间</td>
											<td>投资体验标时间</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">1000</td>
											<td>是否成功发放</td>
											<td>操作</td>
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
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/luckyDraw/luckyDraw.js"></script>
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
						"aaSorting" : [[4,5,7,"desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 1, 2, 3,6,8,9]
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