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
	<title>前台界面配置-产品介绍</title>
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
				<jsp:param value="5" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-frontconfig.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<!-- <div class="search">
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
									<span>添加时间</span><input type="text" class="" placeholder="" />
								</span>
								<span class="con-item">
									<span>姓名</span><input type="text" class="" placeholder="" />
								</span>
								<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
							</form>
						</div>
					</div>
				</div> -->
			
			
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus obtn-proInfo-add" onclick="proInfoAdd('添加产品介绍','web/frontconfig/invite-add.jsp','1')">添加</button>
								<button class="obtn glyphicon glyphicon-pencil obtn-proInfo-mod" onclick="proInfoMod('修改产品介绍','web/frontconfig/invite-mod.jsp','1','id')">修改</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>添加时间</th>
										<th>产品名称</th>
										<th>借款金额范围</th>
										<th>年化利率范围</th>
										<th>借款时间范围</th>
										<th>产品介绍</th>
										<th>产品展示图片</th>
										<th>最近一次操作员</th>
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
										<td>产品名称</td>
										<td>借款金额范围</td>
										<td>年化利率范围</td>
										<td>借款时间范围</td>
										<td>产品介绍</td>
										<td>产品展示图片</td>
										<td>最近一次操作员</td>
										<td>
											<a href="javascript:;" class="btn-enable" onclick="enable()">启用</a>
											<a href="javascript:;" class="btn-disable"onclick="disable()">停用</a>
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
				
				
				<!-- 添加 -->
				<div class="w-content" id="proInfoAdd">
					<table>
						<tr>
							<td class="tt"><label>产品名称</label></td>
							<td class="con"><input type="text"/></td>
							<td class="tt">借款金额范围</td>
							<td class="con"><input type="text"/></td>
						</tr>
						<tr>
							<td class="tt"><label>年化利率范围</label></td>
							<td class="con"><input type="text"/></td>
							<td class="tt"><label>借款时间范围</label></td>
							<td class="con"><input type="text"/></td>
						</tr>
						<tr>
							<td class="tt"></td>
							<td class="con" colspan="3"></td>
						</tr>
						<tr>
							<td class="tt"></td>
							<td class="con" colspan="3"></td>
						</tr>
					</table>
				</div>
				
				
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	
	
	
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/frontconfig/fc-proIntro.js"></script>
	<script type="text/javascript">
		$('#table_id').DataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,2,3,4,5,6,7]
			} // 制定列不参与排序
			],
		});
	</script>
</body>

</html>