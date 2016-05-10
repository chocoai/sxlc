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
				<jsp:param value="702" name="_index_m2"/>
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
									<div>
									<span class="con-item"><span>商品名称</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>商品编码</span><input type="text" class="notspecial" /></span></div>
									<div>
									<span class="con-item"><span>商品种类</span><select><option>实物</option><option>电子礼券</option></select></span>
									<span class="con-item"><span>状态</span><select><option>待上架</option><option>兑换中</option><option>已下架</option></select></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
									</div>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export" onclick="window.location='web/integralMall/good_add.jsp'">添加商品</button>
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export" onclick="window.location='web/integralMall/good_xdd.jsp'">修改商品</button>
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export3" >推荐到商城首页</button>
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export" onclick="bankManagementRdd('查看入库记录','web/integralMall/good_rdd.jsp','1')">查看入库记录</button>
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export" onclick="bankManagementKdd('入库','web/integralMall/good_kdd.jsp','1')">入库</button>
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export" onclick="bankManagementVdd('设置VIP折扣','web/integralMall/good_vdd.jsp','1')">设置VIP折扣</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>添加时间</th>
											<th>商品编号</th>
											<th>商品名称</th>
											<th>商品类别</th>
											<th>商品种类</th>
											<th>商品单价</th>
											<th>是否为VIP共享</th>
											<th>已兑换</th>
											<th>待发货</th>
											<th>操作</th>
											<th>状态</th>
											<th>设置折扣</th>
											<th>是否为活动商品</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>2016.5.9 14：00</td>
											<td>300015</td>
											<td>小黄人玩具</td>
											<td>实物</td>
											<td></td>
											<td>￥50.00</td>
											<td>是</td>
											<td>是</td>
											<td>兑换中</td>
											<td>
												<button id="" class="obtn  obtn-export1" >上架</button>
												<button id="" class="obtn  obtn-export2" >下架</button>
											</td>
											<td>物流</td>
											<td></td>
											<td>是</td>
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
	<script type="text/javascript" src="js/integralMall/integralMall_good.js"></script>
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
						"aaSorting" : [[1,8,9,"desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 2, 3, 4, 5 , 6,7,10,11,12]
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