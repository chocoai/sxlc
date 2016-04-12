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
<!-- 配置中心--------会员等级配置-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
				<jsp:param value="配置中心" name="loc6" />
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp"></jsp:include>
			
			<!-- 主要内容 -->
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
						  <div class="panel-heading">
					  		<div class="action_item">
					  			<button class="obtn glyphicon glyphicon-plus obtn-memgrade-add">添加</button>
							</div> 
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>会员等级</th>
										<th>对应开始积分</th>
										<th>对应结束积分</th>
										<th>等级描述</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>****</td>
										<td>828</td>
										<td>2832</td>
										<td>快捷的回复</td>
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
					<!-- 添加会员等级配置 -->
					<div class="w-content memgrade-add">
						<table>
							<tr>
								<td class="tt"><label class="ineed">对应开始积分：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="对应开始积分" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>对应结束积分：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="对应结束积分" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>积分描述：</label></td>
								<td class="con">
									<textarea col="30" row="5" placeholder="积分描述"></textarea>
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
		<script type="text/javascript" src="js/config/member-grade.js"></script>
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
								"aTargets" : [ 0, 1, 3, 4, 5 ]
							} // 制定列不参与排序
							],
							colReorder : false,
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