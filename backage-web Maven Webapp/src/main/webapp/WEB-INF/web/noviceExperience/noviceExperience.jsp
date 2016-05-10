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
	<link rel="stylesheet" href="css/noviceExperience/noviceExperience.css" type="text/css">
	
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="12" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-noviceExperience.jsp">
				<jsp:param value="1201" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="panel-heading">
						<div class="action_item">
							<button class="obtn glyphicon glyphicon-pencil obtn-dept-mod">修改</button>
						</div>
					</div>
					<div class="drawSet">
						<div class="uploadEnclosure" id="alertAudit">
							<form id="formInput">
								<table>
									<tr>
										<td class="tt">是否启用新手体验标：</td>
										<td class="col">
											<select class="openNew">
												<option>否</option>
												<option>是</option>
											</select>
										</td>
									</tr>
									<tr>
										<td class="tt">体验标描述：</td>
										<td class="col"><input class="notspecial" datatype="describeC"></td>
									</tr>
									<tr>
										<td class="tt">体验标标题：</td>
										<td class="col"><input class="notspecial" datatype="roleNameb"></td>
									</tr>
									<tr>
										<td class="tt">体验产品类型：</td>
										<td class="col">
											<select>
												<option>产品1</option>
												<option>产品2</option>
											</select>
										</td>
									</tr>
									<tr>
										<td class="tt">体验产品还款方式：</td>
										<td class="col">
											<select>
												<option>方式1</option>
												<option>方式2</option>
											</select>
										</td>
									</tr>
									<tr>
										<td class="tt">体验产品年化收益率：</td>
										<td class="col"><input class="notspecial" datatype="hundredNum">%</td>
									</tr>
									<tr>
										<td class="tt">体验产品借款期限：</td>
										<td class="col">
											<input class="notspecial dayInput" datatype="days">
											<select class="day">
												<option>天</option>
												<option>月</option>
											</select>
										</td>
									</tr>
									<tr>
										<td class="tt">投资即得代金券面值：</td>
										<td class="col"><input class="notspecial" datatype="acountM">元</td>
									</tr>
									<tr>
										<td class="tt">体验标图片：</td>
										<td class="con">
											<!--dom结构部分-->
											<div id="uploader">
											    <!--用来存放item-->
											    <div id="filePicker">图片选择</div>
											</div>
										</td>
									</tr>
									<tr>
										<td class="tt" valign="top"></td>
										<td class="con" id="fileList"></td>
									</tr>
									<tr>
										<td class="tt"></td>
										<td>
											<button class="addBtn">添加</button>
											<a class="cancelBtn">取消</a>
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		
			<!-- 尾部 -->
			
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/noviceExperience/noviceExperience.js"></script>
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
							"aTargets" : [ 0, 1, 2, 3, 4,5,6,7]
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