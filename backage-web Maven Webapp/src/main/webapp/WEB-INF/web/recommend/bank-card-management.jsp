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
	<title>保荐机构管理-担保机构管理</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/recommend/guarantee_manage.css"></link>
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
			<div class="right_col role-content" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel-heading">
							<div class="action_item">
								<button id class="obtn glyphicon glyphicon-plus obtn-dept-add" onclick="bankManagementAdd('添加银行卡','web/recommend/re-add/bank-card-management-add.jsp','1')">添加</button>
								<button id class="obtn glyphicon glyphicon-pencil obtn-dept-mod" onclick="bankManagementMod('修改银行卡','web/recommend/re-add/bank-card-management-add.jsp','1')">修改</button>
								<button id class="obtn glyphicon glyphicon-trash obtn-dept-del">删除</button>
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
								<thead>
									<tr>
										<th class="table-checkbox"></th>
										<th>银行卡类型</th>
										<th>开户银行</th>
										<th>开户行城市</th>
										<th>开户行支行</th>
										<th>银行卡卡号</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 15; i++) {
									%>
									<tr>
										<td><input type="checkbox"></td>
										<td>借记卡</td>
										<td>中国银行</td>
										<td>成都</td>
										<td>中国银行</td>
										<td>62214785478544775</td>
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
			<!-- 尾部 -->
			<div class="all"></div>
		</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/recommend/bank-card-management.js"></script>
	<script type="text/javascript">
		$('#table_id').DataTable({
			scrollX:true,
			//scrollY:400,
			autoWidth : false,
			"aaSorting" : [  ],//默认第几个排序
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [0,1,2,3,4,5]
			} // 制定列不参与排序
			],
		});
	</script>
</body>

</html>
