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

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- tab切换 -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="javascript:;">短信接口地址</a></li>
					<li><a href="javascript:;">邮件接口地址</a></li>
				</ul>
				
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-msgp-add">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-msgp-modify">修改</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="table_id" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>添加时间</th>
											<th>短信接口地址</th>
											<th>序列号</th>
											<th>密码</th>
											<th>状态</th>
											<th>最近一次操作管理员</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>添加时间</td>
											<td>短信接口地址</td>
											<td>序列号展示</td>
											<td>452221</td>
											<td>已禁用</td>
											<td>最近一次操作管理员</td>
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
					</div>
					<!-- 短信接口地址添加 -->
					<div class="w-content msgp-add">
						<table>
							<tr>
								<td class="tt"><label class="ineed">短信接口地址：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>序列号：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>密码：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="" />
								</td>
							</tr>
						</table>
					</div>
					<!-- 短信接口地址添加 -->
					<div class="w-content msgp-modify">
						<table>
							<tr>
								<td class="tt"><label class="ineed">短信接口地址：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>序列号：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label>密码：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="" />
								</td>
							</tr>
						</table>
					</div>
				</div>
				<!-- 邮件接口地址 -->
				<div class="nav-tabs-con">
					<div class="config">
				 		<fieldset>
				 			<legend>邮件接口地址配置</legend>
				 			<form class="form-horizontal" role="form" name="" action="" id="">
				 				<div class="form-group">
				 					<label for="firstname" class="i-fl control-label col3">SMTP服务器：</label>
				 					<div class="i-fl">
				 						<input type="text" class="form-control" id="firstname" placeholder="请输入名字">
				 					</div>
				 					<div class="input-alert">
				 						<span>错误提示</span>
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">端口号：</label>
				 					<div class="i-fl">
				 						<input type="text" class="form-control" id="lastname" placeholder="请输入姓">
				 					</div>
				 					<div class="input-alert">
				 						<span>错误提示</span>
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<label for="firstname" class="i-fl control-label col3">邮箱地址：</label>
				 					<div class="i-fl">
				 						<input type="text" class="form-control" id="firstname" placeholder="请输入名字">
				 					</div>
				 					<div class="input-alert">
				 						<span>错误提示</span>
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<label for="lastname" class="i-fl control-label col3">邮箱密码：</label>
				 					<div class="i-fl">
				 						<input type="text" class="form-control" id="lastname" placeholder="请输入姓">
				 					</div>
				 					<div class="input-alert">
				 						<span>错误提示</span>
				 					</div>
				 				</div>
				 				<div class="form-group">
				 					<div class="offset-col3">
				 						<button type="submit" class="btn btn-default">保存</button>
				 					</div>
				 				</div>
				 			</form>		
				 		</fieldset>
				 	</div>	
				</div>
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/config/msg-interface.js"></script>
	<!-- 私用js -->
	<script type="text/javascript">
		$('#table_id').DataTable({
			"aaSorting" : [],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5,6,7]
			} // 制定列不参与排序
			],
		});
	</script>
</body>

</html>