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
	<link rel="stylesheet" href="css/project/apply-failed.css" type="text/css"></link>
</head>
<!-- 借款管理----------申请失败 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="3" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-project.jsp">
				<jsp:param value="305" name="_index_m2"/>
				<jsp:param value="30501" name="_index_m3"/>
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
									<span class="con-item conItem"><span>项目编号</span><input type="text" class="notspecial"/></span>
									<span class="con-item conItem1"><span>借款金额范围</span><input type="text" class="notspecial" />-&nbsp;&nbsp;<input type="text" class="notspecial"/></span>
									<span class="con-item conItem"><span>借款人姓名</span><input type="text" class="notspecial"  /></span>
									<span class="con-item conItem1"><span>提交申请时间范围</span><input type="text" id="startDate" class="notspecial Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item conItem"><span>借款人用户名</span><input type="text" class="notspecial"/></span>
									<span class="con-item conItem1"><span>申请失败时间范围</span><input type="text" id="startDate1" class="notspecial Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate1\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate1" class="notspecial Wdate" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate1\')}' ,maxDate:'2020-10-01' })"/></span>
									<button class="obtn obtn-query glyphicon glyphicon-search loanInquiry">查询</button>
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
						<table id="table_apply_failed" class="display">
							<thead>
								<tr>
									<th></th>
									<th>项目编号</th>
									<th>项目名称</th>
									<th>借款人用户名</th>
									<th>借款人姓名</th>
									<th>产品类型</th>
									<th>借款期限</th>
									<th>借款金额</th>
									<th>年化利率</th>
									<th>提交申请时间</th>
									<th>申请失败时间</th>
									<th>失败原因</th>
								</tr>
							</thead>
							<tbody>
								<%
									for(int i=0;i<15;i++){
								 %>
								<tr>
									<td><input type="checkbox"></td>
									<td>0000001</td>
									<td>jiuyang</td>
									<td>九阳股份</td>
									<td>1234455415</td>
									<td>200000</td>
									<td>12-01</td>
									<td>方式</td>
									<td>用途</td>
									<td>来源</td>
									<td>描述</td>
									<td>类型</td>
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
			
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
				//默认禁用搜索和排序
				/* $.extend( $.fn.dataTable.defaults, {
				    searching: true,
				    ordering:  false
				} ); */
				// 这样初始化，排序将会打开
				$(function() {
					$('#table_apply_failed').DataTable({
						"autoWidth" : true,
						"scrollY": 500,
						//paging : false,//分页
						
						//"searching" : false,
						"info" : false,//左下角信息
						//"ordering": false,//排序
						"aaSorting" : [[ 7, "desc"],[ 9, "desc"],[ 10, "desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11 ]
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

</html>