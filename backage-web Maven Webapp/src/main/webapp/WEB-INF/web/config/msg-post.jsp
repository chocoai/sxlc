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
<!-- 配置中心-------------------消息设置  消息发送历史记录-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="config-0" name="config-index" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- 数据显示 -->
			 	<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-msgc-record">查看站内信历史记录</button>
									<button class="obtn glyphicon glyphicon-trash obtn-msgp-record">查看短信发送历史记录</button>
									<button class="obtn glyphicon glyphicon-trash obtn-msge-record">查看邮件发送历史记录</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table-msg-post" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>会员编号</th>
											<th>会员用户名</th>
											<th>会员名称</th>
											<th>会员类型</th>
											<th>手机号码</th>
											<th>邮箱</th>
											<th>是否开通第三方</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>00012</td>
											<td>siyu</td>
											<td>欧尼</td>
											<td>个人会员</td>
											<td>1234565855</td>
											<td>8392743@qq.com</td>
											<td>否</td>
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
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script src="js/config/msg-post.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		/* 投资管理费---消息发送历史记录表格 */
		$(function(){
			$('#table-msg-post').DataTable({
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
					"aTargets" : [ 0,1,2,3,4,5,6,7]
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