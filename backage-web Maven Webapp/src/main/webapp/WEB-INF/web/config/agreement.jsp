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
<!-- 配置中心--------协议配置-->
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
					  			<button class="obtn glyphicon glyphicon-plus obtn-agreement-add">添加</button>
					  			<button class="obtn glyphicon glyphicon-plus obtn-agreement-mod">修改</button>
							</div> 
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>协议名称</th>
										<th>协议内容</th>
										<th>关联操作</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox" /></td>
										<td>http://</td>
										<td>上看到回复考虑的回复我地方第三方</td>
										<td>注册</td>
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
					<!-- 添加协议配置-->
					<div class="w-content agreement-add">
						<table>
							<tr>
								<td class="tt"><label>关联操作：</label></td>
								<td class="con">
									<select>
										<option>请选择</option>
										<option>注册</option>
										<option>投资</option>
										<option>借款</option>
										<option>债权转让</option>
										<option>债权转让投资</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label class="ineed">协议编辑：</label></td>
								<td class="con">
									<script id="agreementadd" type="text/plain" style="height:260px;width:98%;"></script>
								</td>
							</tr>
						</table>
					</div>
					<!-- 修改协议配置-->
					<div class="w-content agreement-mod">
						<table>
							<tr>
								<td class="tt"><label class="ineed">关联操作：</label></td>
								<td class="con">
									<select>
										<option>请选择</option>
										<option>注册</option>
										<option>投资</option>
										<option>借款</option>
										<option>债权转让</option>
										<option>债权转让投资</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="tt"><label>协议编辑：</label></td>
								<td class="con">
									<script id="agreementmod" type="text/plain" style="height:260px;width:98%;"></script>
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
		<script type="text/javascript" src="js/config/agreement.js"></script>
		<script type="text/javascript" src="plugs/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" src="plugs/ueditor/ueditor.all.min.js"></script>
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
							"aTargets" : [ 0, 1, 2, 3, 4 ]
						} // 制定列不参与排序
						],
						colReorder : false,
						"sScrollX" : "100%",
						"sScrollXInner" : "100%",
						"bScrollCollapse" : true
					});
				});
				/* 自行编辑协议配置 */
				var aa = UE.getEditor('agreementadd');
				var am = UE.getEditor('agreementmod');
			</script>
		</div>
	</div>
</body>

</html>