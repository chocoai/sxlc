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
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>
<!-- 贷后管理---------成交项目列表-------贷后监管-------列表展示 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 主要内容 -->
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
									<span class="con-item"><span>添加时间范围</span><input type="text" id="startDate" class="notspecial Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>产生时间范围</span><input type="text" id="startDate1" class="notspecial Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate1\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate1" class="notspecial Wdate" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate1\')}' ,maxDate:'2020-10-01' })"/></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
							  	<div class="action_item">
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-addmsg">添加贷后信息</button>
						  			<button id="" class="obtn glyphicon glyphicon-plus obtn-searchmsg">贷后信息查询</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_id" class="display">
									<thead>
										<tr>
											<th></th>
											<th>添加时间</th>
											<th>摘要</th>
											<th>详细描述</th>
											<th>产生时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<%
											for(int i=0;i<15;i++){
										 %>
										<tr>
											<td><input type="checkbox"></td>
											<td>0000001</td>
											<td>交电费</td>
											<td>jiuyang</td>
											<td>王书记</td>
											<td>
												<a href="javascript:;" class="btn-del">删除</a>
											</td>
										</tr>
										<%
											}
										 %>
									</tbody>
								</table>
							</div>
						</div>
						<!-- 添加贷后信息 -->
						<div class="w-content addmsg">
							<table>
								<tr>
									<td class="tt"><label>摘要：</label></td>
									<td class="con">
										<textarea cols="20" rows="5"></textarea>
										<input type="checkbox" name="" value="" /> 同步到前台
									</td>
								</tr>
								<tr>
									<td class="tt"><label>详细描述：</label></td>
									<td class="con">
										<textarea cols="20" rows="5"></textarea>
									</td>
								</tr>
								<tr>
									<td class="tt"><label>附件类型：</label></td>
									<td class="con">
										<input type="radio" name="doctype" value="" /> 图片
										<input type="radio" name="doctype" value="" /> 影音
									</td>
								</tr>
								<tr>
									<td class="tt"><label class="ineed">上传附件信息：</label></td>
									<td class="con">
										<div id="logo">
										    <!--用来存放item-->
										    <div id="filePicker">选择附件内容</div>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<!-- 贷后信息查询 -->
						<div class="w-content searchmsg">
							<table id="table_searchmsg" class="display">
								<thead>
									<tr>
										<th>添加时间</th>
										<th>摘要</th>
										<th>详细描述</th>
										<th>产生时间</th>
									</tr>
								</thead>
								<tbody>
									<%
										for(int i=0;i<15;i++){
									 %>
									<tr>
										<td>交电费</td>
										<td>jiuyang</td>
										<td>王书记</td>
										<td>
											<a href="javascript:;" class="btn-del">删除</a>
										</td>
									</tr>
									<%
										}
									 %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- 尾部 -->
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/project/deal_list_supervice_list.js"></script>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/project/supervice-upload.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		//默认禁用搜索和排序
		/* $.extend( $.fn.dataTable.defaults, {
		    searching: true,
		    ordering:  false
		} ); */
		// 这样初始化，排序将会打开
		$(function() {
			$('#table_id').DataTable({
				"autoWidth" : false,
				//"scrollY": 500,
				//paging : false,//分页
				
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [[ 1, "desc"],[ 4, "desc"]],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 2, 3, 5]
				} // 制定列不参与排序
				],
				colReorder : false,
				"scrollX": true,
				"sScrollX" : "100%",
				"sScrollXInner" : "100%",
				"bScrollCollapse" : true
			});
		});
		/* 贷后信息查询 */
		$(function(){
			$('#table_searchmsg').DataTable({
				"autoWidth" : false,
				//"scrollY": 500,
				//paging : false,//分页
				
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [0,1,2,3]
				} // 制定列不参与排序
				],
				colReorder : false,
				"bScrollCollapse" : true
			});
		});
	</script>
</body>

</html>