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
	<title>平台推广-关系年限</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/promoted/promotedCom.css" type="text/css">
	<link rel="stylesheet" href="css/promoted/pro-envelopeConfiguration.css" type="text/css">
	
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="10" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-promoted.jsp">
				<jsp:param value="1007" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<div class="panel panel-success">
							<form id="conForm">
								<div class="conInput">
									<span class="conInputList"><label>注册开户：</label><input datatype="logName" type="text"></span>
									<span class="conInputList"><label>首次充值：</label><input datatype="acountM" type="text"></span>
									<div class="btnSubmit">
										<button class="okBtn">确定</button>
										<a class="cancelBtn">取消</a>
									</div>
								</div>
							</form>
							
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-plus obtn-dept-add" onclick="addEnv();">添加</button>
									<button class="obtn glyphicon glyphicon-pencil obtn-dept-mod" onclick="alertEnv();">修改</button>
								</div>
							</div>
							<div class="panel-body">
								<table id="applicationAudit" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>投资金额(元)</th>
											<th>红包比例(%)</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td class="moneyFormat">1000</td>
											<td>10</td>
											<td>删除</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
							
						</div>
					</div>
					
					<!-- 添加部分  -->
					<div class="" id="addEnv">
						<form id="addRedEForm">
							<div>
								<span class="tt">投资金额：</span>
								<span class="col"><input datatype="acountM">元</span>
							</div>
							<div>
								<span class="tt">红包比例：</span>
								<span class="col"><input datatype="hundrednum"></span>
							</div>
							<div class="btnAdd">
								<button class="addBtn">添加</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
					
					
					<!-- 修改部分 -->
					<div class="" id="alertEnv">
						<form id="alertRedEForm">
							<div>
								<span class="tt">投资金额：</span>
								<span class="col"><input datatype="acountM">元</span>
							</div>
							<div>
								<span class="tt">红包比例：</span>
								<span class="col"><input datatype="hundrednum"></span>
							</div>
							<div class="btnAdd">
								<button class="alertBtn">修改</button>
								<a class="cancelBtn">取消</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/promoted/pro-envelopeConfiguration.js"></script>
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
						"aaSorting" : [],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0,1,2,3]
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