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
	<title>配置中心</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/config.css" />
</head>
<!-- 配置中心--------托管平台管理-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="604" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			
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
										<li><a class="state">展开&nbsp;<span
												class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<div class="form-group">
										<span class="con-item">
											<span>操作类型</span>
										</span>
										<select>
											<option>请选择</option>
											<option>开户</option>
											<option>充值</option>
											<option>转账</option>
											<option>提现</option>
											<option>授权</option>
											<option>审核</option>
											<option>余额查询</option>
											<option>对账</option>
										</select>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									</div>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<!-- <div class="i-fl data_title">数据列表</div> -->
					  		<div class="action_item">
					  			<button class="obtn glyphicon glyphicon-plus obtn-test-inter-add">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-test-inter-modify">修改</button>
							</div> 
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>接口类型</th>
										<th>操作类型</th>
										<th>请求路径</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>双乾</td>
										<td>开户</td>
										<td>http://shuangqing.com</td>
										<td>状态</td>
										<td>
											<a href="javascript:;" class="btn-enable">启用</a>
											<a href="javascript:;" class="btn-disable">停用</a>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
					<!-- 添加接口地址配置 -->
					<div class="w-content test-inter-add">
						<table>
							<tr>
								<td class="tt"><label class="ineed">接口类型：</label></td>
								<td class="con">
									<select class="testinterfaceselect">
										<option>双乾</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label>操作类型：</label></td>
								<td class="con">
									<select class="testinterfaceselect">
										<option>请选择</option>
										<option>开户</option>
										<option>充值</option>
										<option>转账</option>
										<option>提现</option>
										<option>授权</option>
										<option>审核</option>
										<option>余额查询</option>
										<option>对账</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt">请求路径：</td>
								<td class="con" id="requestpath"><input type="text" name="reqeust" class="interfacepath" value="" datatype="strRegex"></td>
							</tr>
						</table>
					</div>
					<!-- 修改接口地址配置 -->
					<div class="w-content test-inter-modify">
						<table>
							<tr>
								<td class="tt"><label class="ineed">接口类型：</label></td>
								<td class="con">
									<select class="testinterfaceselect">
										<option>双乾</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label>操作类型：</label></td>
								<td class="con">
									<select class="testinterfaceselect">
										<option>请选择</option>
										<option>开户</option>
										<option>充值</option>
										<option>转账</option>
										<option>提现</option>
										<option>授权</option>
										<option>审核</option>
										<option>余额查询</option>
										<option>对账</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt">请求路径：</td>
								<td class="con" id="modrequestpath"><input type="text" name="reqeust" class="interfacepath" value="" datatype="strRegex"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- 尾部 -->
			
		</div>
		<!-- 公用js -->
		<jsp:include page="../common/cm-js.jsp"></jsp:include>
		<script type="text/javascript" src="js/config/test-interface.js"></script>
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
				scrollY : 500,
				//paging : false,//分页
				//"searching" : false,
				"info" : false,//左下角信息
				//"ordering": false,//排序
				"aaSorting" : [],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 1,2, 3, 4,5 ]
				} // 制定列不参与排序
				],
				colReorder : false,
				"sScrollX" : "100%",
				"sScrollXInner" : "100%",
				"bScrollCollapse" : true
			});
		});
		$(function(){
			validform5("layui-layer-btn0","requestpath",false,"3");
		});
		$(function(){
			validform5("layui-layer-btn0","modrequestpath",false,"3");
		});
			</script>
		</div>
	</div>
</body>

</html>