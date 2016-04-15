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
<!-- 配置中心--------会员信用等级配置-->
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
					  			<button class="obtn glyphicon glyphicon-plus obtn-loanitem-add">添加</button>
					  			<button class="obtn glyphicon glyphicon-plus obtn-loanitem-mod">修改</button>
							</div> 
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>认证项名称</th>
										<th>附件格式</th>
										<th>默认最高信用分数</th>
										<th>状态</th>
										<th>操作时间</th>
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
										<td>身份证</td>
										<td>img</td>
										<td>2930</td>
										<td>已启用</td>
										<td>20160411</td>
										<td>无名</td>
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
					<!-- 添加 个人借款认证项-->
					<div class="w-content loanitem-add">
						<table>
							<tr>
								<td class="tt"><label class="ineed">认证项名称：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="认证项名称" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">附件格式：</label></td>
								<td class="con">
									<input type="checkbox" name="img" value="图片"/> 图片
									<input type="checkbox" name="file" value="文件"/> 文件
									<input type="checkbox" name="audio" value="音频"/> 音频
									<input type="checkbox" name="vidio" value="视频"/> 视频
								</td>
							</tr>
							<tr>
								<td class="tt"><label>默认最高信用分数：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="默认最高信用分数" value="" />
								</td>
							</tr>
						</table>
					</div>
					<!-- 修改个人借款认证项-->
					<div class="w-content loanitem-mod">
						<table>
							<tr>
								<td class="tt"><label class="ineed">认证项名称：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="认证项名称" value="" />
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">附件格式：</label></td>
								<td class="con">
									<input type="checkbox" name="img" value="图片"/> 图片
									<input type="checkbox" name="file" value="文件"/> 文件
									<input type="checkbox" name="audio" value="音频"/> 音频
									<input type="checkbox" name="vidio" value="视频"/> 视频
								</td>
							</tr>
							<tr>
								<td class="tt"><label>默认最高信用分数：</label></td>
								<td class="con">
									<input type="text" class="" placeholder="默认最高信用分数" value="" />
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
		<script type="text/javascript" src="js/config/loan-items.js"></script>
		<!-- 私用js -->
		<script type="text/javascript">
				// 这样初始化，排序将会打开
				$(function() {
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
							"aTargets" : [ 0, 1, 2, 3, 4, 5, 6, 7]
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