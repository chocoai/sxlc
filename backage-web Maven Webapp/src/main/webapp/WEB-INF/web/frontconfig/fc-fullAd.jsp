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
	<title>前台界面配置-首页弹出公告</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>
<body class="nav-md">
	<div class="container body">
		<!-- 头部 -->
		<jsp:include page="../common/cm-top.jsp">
			<jsp:param value="5" name="_index_m1"/>
		</jsp:include>		
		<!-- 左侧菜单 -->
		<jsp:include page="../common/cm-frontconfig.jsp">
			<jsp:param value="518" name="_index_m2"/>
			<jsp:param value="" name="_index_m3"/>
		</jsp:include>
		<!-- 主要内容 -->
		<div class="right_col" role="main">	
			<!-- 地址导航 -->
			<jsp:include page="../common/cm-addr.jsp"></jsp:include>
			<div class="data_display">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="action_item">
							<button class="obtn glyphicon glyphicon-plus obtn-fullAd-add" onclick="picAdd('添加首页全屏弹出公告','web/frontconfig/fc-add/fullAd-add.jsp','1')" type="button">添加</button>
							<button class="obtn glyphicon glyphicon-pencil obtn-fullAd-mod" onclick="picAdd('修改首页全屏弹出公告','web/frontconfig/fc-add/fullAd-mod.jsp','1')" type="button">修改</button>							
						</div>
					</div>
					<div class="panel-body">
						<table id="partnerTb" class="display">
							<thead>
								<tr>
									<th class="table-checkbox"></th>
									<th>添加时间</th>
									<th>公告图片</th>
									<th>公告链接</th>
									<th>弹出总次数</th>
									<th>开始日期</th>
									<th>截止日期</th>
									<th>最近一次操作管理员</th>	
									<th>操作</th>																
								</tr>
							</thead>
							<tbody>
							<%for (int i=0;i<5;i++){ %>
								<tr>
									<td><input type="checkbox" /></td>
									<td>添加时间</td>
									<td>公告图片</td>
									<td>公告链接</td>
									<td>弹出总次数</td>
									<td>开始日期</td>
									<td>截止日期</td>																
									<td>最近一次操作管理员</td>
									<td>
										<a href="javascript:;" class="btn-enable">启用</a>
										<a href="javascript:;" class="btn-disable">停用</a>
									</td>	
								</tr>
								<%}%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 弹出层修改页 -->
	<!-- 弹出层添加页 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="js/frontconfig/fc-fullAd.js"></script>
</body>
</html>