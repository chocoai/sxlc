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
				<jsp:param value="1004" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
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
											<th>序号</th>
											<th>会员编号</th>
											<th>会员用户名</th>
											<th>姓名</th>
											<th>所在地</th>
											<th>手机号</th>
											<th>是否开通第三方</th>
											<th>注册时间</th>
											<th>累计成功投资</th>
											<th>累计成功借款</th>
											<th>推荐达人编号</th>
											<th>推荐达人</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>1</td>
											<td>1</td>
											<td>会员用户名</td>
											<td>姓名</td>
											<td>所在地</td>
											<td>手机号</td>
											<td>是否开通第三方</td>
											<td>注册时间</td>
											<td>累计成功投资</td>
											<td>累计成功借款</td>
											<td>推荐达人编号</td>
											<td>推荐达人</td>
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
	<!-- 私用js -->
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
				"aaSorting" : [],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 1, 2, 3, 4,5, 6,7,8,9,10,11,12]
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