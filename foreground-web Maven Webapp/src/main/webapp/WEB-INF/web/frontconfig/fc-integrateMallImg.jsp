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
	<title>前台界面配置——积分商城轮播图管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/frontconfig/frontconfig.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="5" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-frontconfig.jsp">
				<jsp:param value="502" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
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
										<li>
											<a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a>
										</li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item">
										<span>添加时间</span><input type="text" class="Wdate" onFocus="WdatePicker()">
									</span>
									<span class="con-item">
										<span>图片标题</span><input type="text" class=""/>
									</span>
									<span class="con-item">
										<span>状态</span>
										<select class="w3">
											<option value="0">请选择</option>
											<option value="1">已启用</option>
											<option value="2">已停用</option>
										</select>
									</span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
							</div>
						</div>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-pic-add">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-pic-mod">修改</button>
									<button class="obtn glyphicon glyphicon-trash obtn-pic-del">删除</button>
									<button class="obtn glyphicon glyphicon-arrow-up obtn-pic-up">上移</button>
									<button class="obtn glyphicon glyphicon-arrow-down obtn-pic-down">下移</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="table_frontconfig" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>添加时间</th>
											<th>图片标题</th>
											<th>图片展示</th>
											<th>图片点击跳转路径</th>
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
											<td>2016-05-11</td>
											<td>图片标题</td>
											<td>img</td>
											<td>图片点击跳转路径</td>
											<td>已启用</td>
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
				</div>
			</div>
			<!-- 尾部 -->
			<!-- 公用js -->
			<jsp:include page="../common/cm-js.jsp"></jsp:include>
			<!-- 私用js -->
			<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
			<script type="text/javascript" src="js/frontconfig/fc-integrateMallImg.js"></script>
		</div>
	</div>
</body>

</html>