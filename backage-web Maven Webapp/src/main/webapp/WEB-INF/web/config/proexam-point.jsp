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
	<link rel="stylesheet" href="css/config.css" type="text/css"></link>
</head>
<!-- 配置中心--------项目审批活动点配置 -->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="608" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="web/config/proexam-point.jsp">审批活动点配置</a>
					</li>
					<li role="presentation" class=""><a href="web/config/proexam-process.jsp">审批流程配置</a>
					</li>
				</ul>
				<div class="nav-tabs-con active">
					<!-- <div class="search">
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
									<span class="con-item"><span>活动点名称</span><input type="text" class="" value="" /></span>
									<span class="con-item"><span>关联操作权限名称</span><input type="text" class="" value="" /></span>
									<span class="con-item"><span>活动点状态</span><input type="text" class="" value="" /></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						</div>
					</div>  -->
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
						  	<div class="action_item">
					  			<button id="pro_allocation" class="obtn glyphicon glyphicon-plus obtn-proexam-point-add">添加</button>
								<button id="add_information" class="obtn glyphicon glyphicon-pencil obtn-proexam-point-mod">修改</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th></th>
										<th>活动点名称</th>
										<th>审批类型</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox"></td>
										<td>活动点名称</td>
										<td>平台审批</td>
										<td>有效</td>
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
					<!-- 添加审批点配置 -->
					<div class="w-content proexam-point-add">
						<table>
							<tr>
								<td class="tt"><label class="ineed">活动点名称：</label></td>
								<td class="con" id="addactivityname"><input type="text" class="" placeholder="" value="" datatype="enterAddress"/></td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">审批类型：</label></td>
								<td class="con">
									<select class="msginterfaceselect">
										<option>请选择</option>
										<option>平台审批</option>
										<option>担保机构审批</option>
										<option>资产管理方审批</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">状态：</label></td>
								<td class="con">
									<select class="msginterfaceselect">
										<option>有效</option>
										<option>无效</option>
									</select>
								</td>
							</tr>
							<!-- <tr>
								<td class="tt"><label>是否为担保机构审核：</label></td>
								<td class="con">
									<input type="radio" name="state" class="" value="是" /> 是
									<input type="radio" name="state" class="" value="否" /> 否
								</td>
							</tr>
							<tr>
								<td class="tt"><label>是否为资产管理方审核：</label></td>
								<td class="con">
									<input type="radio" name="state" class="" value="是" /> 是
									<input type="radio" name="state" class="" value="否" /> 否
								</td>
							</tr> -->
						</table>
					</div>
					<!-- 修改审批点配置 -->
					<div class="w-content proexam-point-mod">
						<table>
							<tr>
								<td class="tt"><label class="ineed">活动点名称：</label></td>
								<td class="con" id="modactivityname"><input type="text" class="" placeholder="" value="" datatype="enterAddress"/></td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">审批类型：</label></td>
								<td class="con">
									<select class="msginterfaceselect">
										<option>请选择</option>
										<option>平台审批</option>
										<option>担保机构审批</option>
										<option>资产管理方审批</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">状态：</label></td>
								<td class="con">
									<select class="msginterfaceselect">
										<option>有效</option>
										<option>无效</option>
									</select>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
		
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/config/proexam-point.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		//默认禁用搜索和排序
		/* $.extend( $.fn.dataTable.defaults, {
		    searching: true,
		    ordering:  false
		} ); */
		$('#table_id').DataTable({
			"autoWidth" : false,
			//scrollY : 500,
			//paging : false,//分页
			//"searching" : false,
			"info" : false,//左下角信息
			//"ordering": false,//排序
			"aaSorting" : [],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 1, 2, 3, 4 ]
			} // 制定列不参与排序
			],
			colReorder : false,
			"sScrollX" : "100%",
			"sScrollXInner" : "100%",
			"bScrollCollapse" : true
		});
		$(function(){
			validform5("layui-layer-btn0","addactivityname",false,"3");
			validform5("layui-layer-btn0","modactivityname",false,"3");
				});
			</script>
		</div>
	</div>
</body>

</html>