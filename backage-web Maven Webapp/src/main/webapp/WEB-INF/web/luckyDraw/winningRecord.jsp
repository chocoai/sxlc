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
	<link rel="stylesheet" href="css/luckyDraw/luckyDrawCom.css" type="text/css">
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
				<jsp:param value="1102" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
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
									<span class="con-item"><span>抽奖期数</span><select><option>1期</option><option>2期</option><option>3期</option></select></span>
									<span class="con-item"><span>获奖等级</span><select><option>一等</option><option>二等</option><option>三等</option><option>四等</option><option>五等</option><option>六等</option></select></span>
									<span class="con-item"><span>奖品类型</span><select><option>红包</option><option>代金券</option><option>实物</option><option>积分</option></select></span>
									<span class="con-item"><span>奖品名称</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>中奖时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<span class="con-item"><span>中奖会员编号</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>中奖会员用户名</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>中奖会员手机号</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>抽奖活动开始时间</span><input type="text" id="startDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })"/>-&nbsp;&nbsp;<input type="text" id="endDate" class="notspecial Wdate dateInput" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })"/></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button id="" class="obtn glyphicon glyphicon-plus obtn-export">导出</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="applicationAudit" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>抽奖期数</th>
											<th>抽奖活动开始时间</th>
											<th>消耗积分</th>
											<th>获奖等级</th>
											<th>奖品类型</th>
											<th>奖品名称</th>
											<th>奖品价值(元)</th>
											<th>中奖时间</th>
											<th>中奖会员编号</th>
											<th>中奖会员用户名</th>
											<th>中奖会员手机号</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>抽奖期数</td>
											<td>抽奖活动开始时间</td>
											<td>消耗积分</td>
											<td>获奖等级</td>
											<td>奖品类型</td>
											<td>奖品名称</td>
											<td class="moneyFormat">1000</td>
											<td>中奖时间</td>
											<td>中奖会员编号</td>
											<td>中奖会员用户名</td>
											<td>中奖会员手机号</td>
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
						"aaSorting" : [[ 2,8, "desc"]],//默认第几个排序
						"aoColumnDefs" : [
						//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
						{
							"orderable" : false,
							"aTargets" : [ 0, 1, 3, 4,5,6,7,9,10,11]
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