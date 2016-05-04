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
	<title>保荐机构管理-代偿</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/compensatory.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="9" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-recommend.jsp"></jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-plus" onclick="compenFunction()">代偿</button>
								<button class="obtn glyphicon glyphicon-pencil" onclick="compenExport()">导出</button>
							</div>
						</div>
						
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>项目编号</th>
										<th>产品类型</th>
										<th>项目名称</th>
										<th>期数</th>
										<th>借款人姓名</th>
										<th>借款人用户名</th>
										<th>借款人手机号</th>
										<th>担保机构名称</th>
										<th>实际借款金额</th>
										<th>当期合约还款时间</th>
										<th>应代偿金额</th>
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
										<td>项目编号</td>
										<td>产品类型</td>
										<td>项目名称</td>
										<td>期数</td>
										<td>借款人姓名</td>
										<td>借款人用户名</td>
										<td>借款人手机号</td>
										<td>担保机构名称</td>
										<td>实际借款金额</td>
										<td>当期合约还款时间</td>
										<td>本金</td>
										<td>已代偿</td>
										<td>代偿</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
				<!-- 代偿部分开始 -->
				<div class="w-content" id="compenfunction">
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>项目编号：</span>
							<span>项目编号</span>
						</div>
						<div class="form-group">
							<span>项目名称：</span>
							<span>项目名称</span>
						</div>
					</form>
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>借款人姓名：</span>
							<span>借款人姓名</span>
						</div>
						<div class="form-group">
							<span>借款人用户名：</span>
							<span>借款人用户名</span>
						</div>
					</form>
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>期数：</span>
							<span>期数</span>
						</div>
						<div class="form-group">
							<span>本次代偿本金：</span>
							<span><label class="moneyFormat">1000</label><samp>元</samp></span>
						</div>
					</form>
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>本次代偿利息：</span>
							<span><label class="moneyFormat">1000</label><samp>元</samp></span>
						</div>
						<div class="form-group">
							<span>本次代偿逾期利息：</span>
							<span><label class="moneyFormat">1000</label><samp>元</samp></span>
						</div>
					</form>
					<form action="" class="form-inline" role="form">
						<div class="form-group">
							<span>本次代偿逾期罚金：</span>
							<span><label class="moneyFormat">1000</label><samp>元</samp></span>
						</div>
					</form>
				<!-- 代偿部分结束 -->   
			</div>
			<!-- 尾部 -->
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/compensatory.js"></script>
	<script type="text/javascript">
		$('#table_id').DataTable({
			//"autoWidth" : false,
			//"scrollY":400,
			"scrollX":true,
			"aaSorting" : [ ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5,6,7,8,9,10,11,12,13]
			} // 制定列不参与排序
			],
		});
	</script>
</body>

</html>