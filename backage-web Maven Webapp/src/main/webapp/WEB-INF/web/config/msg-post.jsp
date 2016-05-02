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
	<title>配置中心--短信设置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------短信设置  消息发送历史-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="603" name="_index_m2" />
				<jsp:param value="60303" name="_index_m3" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	
			 	<!-- 消息发送历史-->
			 	<div class="award-rule-set">
			 		<!-- 数据显示 -->
			 		<ul class="nav nav-tabs msgalerttab">
						<li role="presentation" class="active"><a>查看站内信历史记录</a></li>
						<li role="presentation" class=""><a>查看短信发送历史记录</a></li>
						<li role="presentation" class=""><a>查看邮件发送历史记录</a></li>
					</ul>
					<!-- 站内信开始 -->
					<div class="nav-tabs-con active">
						<div class="search">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="i-fl search_title">条件查询</div>
									<div class="i-fr action_item">
										<ul class="list_item list-inline">
											<li><a class="state">展开&nbsp;<span
													class="glyphicon glyphicon-chevron-down"></span> </a>
											</li>
										</ul>
									</div>
								</div>
								<div class="panel-body">
									<form id="" class="" action="">
										<span class="con-item">
											<span>会员编号</span><input type="text" class="" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员手机号</span><input type="text" class="departmentname" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员登录名</span><input type="text" class="licencenum" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员名称</span><input type="text" class="contactname" placeholder="" />
										</span>
										<span class="">
											<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</span>
									</form>
								</div>
							</div>
						</div>
						<div class="data_display">
							<div class="panel panel-success">
								<div class="panel-body">
									<table id="stationlettertable" class="display">
										<thead>
											<tr>
												<th class="table-checkbox"></th>
												<th>站内信内容</th>
												<th>接收人</th>
												<th>接收人用户名</th>
												<th>发送时间</th>
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
												<td>站内信内容</td>
												<td>接收人</td>
												<td>接收人用户名</td>
												<td>发送时间</td>
												<td>手动发送</td>
												<td>发送操作管理员</td>
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
					<!-- 短信开始  -->
					<div class="nav-tabs-con">
						<div class="search">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="i-fl search_title">条件查询</div>
									<div class="i-fr action_item">
										<ul class="list_item list-inline">
											<li><a class="state">展开&nbsp;<span
													class="glyphicon glyphicon-chevron-down"></span> </a>
											</li>
										</ul>
									</div>
								</div>
								<div class="panel-body">
									<form id="" class="" action="">
										<span class="con-item">
											<span>会员编号</span><input type="text" class="" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员手机号</span><input type="text" class="departmentname" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员登录名</span><input type="text" class="licencenum" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员名称</span><input type="text" class="contactname" placeholder="" />
										</span>
										<span class="">
											<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</span>
									</form>
								</div>
							</div>
						</div>
						<div class="data_display">
							<div class="panel panel-success">
								<div class="panel-body">
									<table id="msgtable" class="display">
										<thead>
											<tr>
												<th class="table-checkbox"></th>
												<th>短信内容</th>
												<th>接收人</th>
												<th>接收人手机号</th>
												<th>发送时间</th>
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
												<td>短信内容</td>
												<td>接收人</td>
												<td>接收人手机号</td>
												<td>发送时间</td>
												<td>手动发送</td>
												<td>发送操作管理员</td>
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
					<!-- 短信结束  -->
					<!-- 邮件开始 -->
					<div class="nav-tabs-con">
						<div class="search">
							<div class="panel panel-success">
								<div class="panel-heading">
									<div class="i-fl search_title">条件查询</div>
									<div class="i-fr action_item">
										<ul class="list_item list-inline">
											<li><a class="state">展开&nbsp;<span
													class="glyphicon glyphicon-chevron-down"></span> </a>
											</li>
										</ul>
									</div>
								</div>
								<div class="panel-body">
									<form id="" class="" action="">
										<span class="con-item">
											<span>会员编号</span><input type="text" class="" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员手机号</span><input type="text" class="departmentname" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员登录名</span><input type="text" class="licencenum" placeholder="" />
										</span>
										<span class="con-item">
											<span>会员名称</span><input type="text" class="contactname" placeholder="" />
										</span>
										<span class="">
											<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
										</span>
									</form>
								</div>
							</div>
						</div>
						<div class="data_display">
							<div class="panel panel-success">
								<div class="panel-body">
									<table id="emailtable" class="display">
										<thead>
											<tr>
												<th class="table-checkbox"></th>
												<th>邮件内容</th>
												<th>接收人</th>
												<th>接收人邮箱</th>
												<th>发送时间</th>
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
												<td>站内信内容</td>
												<td>接收人</td>
												<td>接收人邮箱</td>
												<td>发送时间</td>
												<td>手动发送</td>
												<td>发送操作管理员</td>
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
					<!-- 邮件结束 -->
				</div>
			</div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js//config/config.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		 /* 站内信 */
		$('#stationlettertable').DataTable({
			"aaSorting" : [],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5,6]
			} // 制定列不参与排序
			],
		});
		/* 短信 */
		$('#msgtable').DataTable({
				"aaSorting" : [],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5,6]
			} // 制定列不参与排序
			],
		}); 
		/* 短信 */
		/* 邮件 */
		$('#emailtable').DataTable({
				"aaSorting" : [],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5,6]
			} // 制定列不参与排序
			]
		}); 
		/* 邮件 */
	</script>
</body>

</html>