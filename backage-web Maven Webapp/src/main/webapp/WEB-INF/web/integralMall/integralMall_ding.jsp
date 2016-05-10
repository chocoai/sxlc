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
	<title>积分商城</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/promotedCom.css" type="text/css">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="7" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-integralMall.jsp">
				<jsp:param value="703" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<!-- 主体部分 -->
				<div class="nav-tabs-con active">
					<div class="search">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="i-fl search_title">条件查询</div>
								<div class="i-fr action_item">
									<ul class="list_item list-inline">
										<li><a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a></li>
									</ul>
								</div>
							</div>
							<div class="panel-body">
								<form id="" class="" action="">
									<span class="con-item"><span>兑换时间</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>发货时间</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>会员用户名</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>会员姓名</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>联系电话</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>商品编号</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>商品名称</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>状态</span><select><option>已下单</option><option>已发货</option><option>订货失败</option></select></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>兑换时间</th>
											<th>发货时间</th>
											<th>会员用户名</th>
											<th>会员姓名</th>
											<th>联系电话</th>
											<th>商品编号</th>
											<th>商品名称</th>
											<th>兑换数量</th>
											<th>应付积分</th>
											<th>实际使用积分</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>2016.5.9 14：50</td>
											<td>菲利普斯同款泳衣</td>
											<td>流线型设计！</td>
											<td>有效</td>
											<td>泰迪熊2</td>
											<td>泰迪熊2</td>
											<td>泰迪熊2</td>
											<td>泰迪熊2</td>
											<td>泰迪熊2</td>
											<td>泰迪熊2</td>
											<td>泰迪熊2</td>
											<td>
												<input type="button" class="fahuo" value="发货"/>
												<input type="button" class="chexiao" value="撤销订单"/>
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
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/integralMall/integralMall_good.js"></script>
	<script type="text/javascript" src="js/frontconfig/frontconfig.js"></script>
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
						"aaSorting" : [[1,2,8,9,"desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 3, 4, 5 , 6,7,10,11,12]
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