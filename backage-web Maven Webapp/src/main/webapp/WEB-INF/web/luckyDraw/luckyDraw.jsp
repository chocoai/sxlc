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
	<link rel="stylesheet" href="css/luckyDraw/luckyDraw.css" type="text/css">
	
	<link rel="stylesheet" href="plugs/webuploader/0.1.5/webuploader.css" />
	<link rel="stylesheet" href="css/upload.css" />
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="11" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-luckyDraw.jsp">
				<jsp:param value="1101" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="drawSet">
						<span><label>单次抽奖所需积分：</label><input type="text" class="notspecial"></span>
						<span>
							<label>是否开启本期抽奖：</label>
							<select>
								<option>是</option>
								<option>否</option>
							</select>
						</span>
						<span><label>开始结束时间范围：</label><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
						
						<span class="periodes"><label>抽奖期数：</label>2期</span>
					</div>
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon glyphicon-pencil obtn-dept-mod">修改</button>
									<button class="obtn glyphicon glyphicon-plus obtn-dept-add" onclick="addLuckyDraw();">添加</button>
									<button class="obtn glyphicon glyphicon-trash obtn-dept-del">删除</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>奖品等级</th>
											<th>奖品类型</th>
											<th>奖品名称</th>
											<th>奖品价值(元)</th>
											<th>奖品剩余数量</th>
											<th>中奖概率基数</th>
											<th>奖品图片</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>奖品等级</td>
											<td>奖品类型</td>
											<td>奖品名称</td>
											<td class="moneyFormat">1000</td>
											<td>奖品剩余数量</td>
											<td>中奖概率基数</td>
											<td><img class="scaleImg" src="resources/img/loginUser.jpg"></td>
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
					<div class="" id="addluckyDraw">
						<form id="addluckyInfo">
							<table>
								<tr class="con-item">
									<td class="tt">奖品等级：</td>
									<td class="col">
										<select>
											<option>一等</option>
											<option>二等</option>
											<option>三等</option>
											<option>四等</option>
											<option>五等</option>
											<option>六等</option>
										</select>				
									</td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品类型：</td>
									<td class="col">
										<select>
											<option>红包</option>
											<option>代金券</option>
											<option>实物</option>
											<option>积分</option>
										</select>	
									</td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品名称：</td>
									<td class="col"><input ignore="ignore" datatype="roleNameb" class="moneyInput"></td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品价值：</td>
									<td class="col"><input datatype="acountM" class="moneyInput">元</td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品数量：</td>
									<td class="col"><input datatype="nNum1" class="moneyInput"></td>
								</tr>
								<tr class="con-item">
									<td class="tt">中奖概率基数：</td>
									<td class="col"><input datatype="hundredNum" class="moneyInput"></td>
								</tr>
								<tr class="con-item">
									<td class="tt">奖品图片：</td>
									<td class="col">
										<!--dom结构部分-->
										<div id="uploader">
										    <!--用来存放item-->
										    <div id="filePicker">图片选择</div>
										</div>
									</td>
								</tr>
								<tr class="con-item">
									<td class="tt" valign="top">图片预览：</td>
									<td class="col" id="fileList"></td>
								</tr>
							</table>
							
							<div class="btnAdd">
								<button class="addBtn">添加</button>
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
	<script type="text/javascript" src="plugs/webuploader/0.1.5/webuploader.js"></script>
	<!-- 私用js -->
	<script type="text/javascript" src="js/luckyDraw/luckyDraw.js"></script>
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