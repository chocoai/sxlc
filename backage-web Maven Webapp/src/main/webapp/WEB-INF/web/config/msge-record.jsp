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
	<title>配置中心--财务配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------消息设置  消息发送历史记录  站内信查看-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<!-- 左侧菜单 -->
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				
			 	<!-- 数据显示 -->
				<div class="config">
					<table id="table-msge-record" class="display">
						<thead>
							<tr>
								<th class="table-checkbox"></th>
								<th>接收人</th>
								<th>接收人邮箱</th>
								<th>发送时间</th>
								<th>邮件内容</th>
								<th>发送类型</th>
								<th>发送操作管理员</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < 15; i++) {
							%>
							<tr>
								<td><input type="checkbox" /></td>
								<td>陈思宇</td>
								<td>874544@qq.com</td>
								<td>2012-04-01</td>
								<td>上开发空间的覅及</td>
								<td>手动发送</td>
								<td>冉尽然</td>
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
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript">
		/* 投资管理费---消息发送历史记录表格 */
		$(function(){
			$('#table-msge-record').DataTable({
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
					"aTargets" : [ 0,1,2,3,4,5,6]
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