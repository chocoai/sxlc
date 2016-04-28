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
	<title>会员黑名单</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css"></link>
	<link rel="stylesheet" href="css/member/memberDetail.css" type="text/css" >
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="2" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-member.jsp">
				<jsp:param value="201" name="_index_m2"/>
				<jsp:param value="20108" name="_index_m3"/>
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
									<span class="con-item"><span>用户名</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>姓名</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>手机号</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>拉黑时间</span><input type="text" id="startDate" class="dateInput Wdate" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')||\'2020-10-01\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'2020-10-01' })" ></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon examine" onclick="detailView();">查看会员详情</button>
									<button class="obtn glyphicon" onclick="memeberBlackRecord();">拉黑记录查看</button>
									<button class="obtn glyphicon" onclick="cancelBlackList();">取消拉黑</button>
									<button class="obtn glyphicon" onclick="prohibitedItem();">黑名单会员受限设置</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="table_id" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>会员编号</th>
											<th>姓名</th>
											<th>用户名</th>
											<th>注册时间</th>
											<th>手机号码</th>
											<th>身份证号</th>
											<th>最近一次拉黑时间</th>
											<th>拉黑次数</th>
											<th>电子邮箱</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>会员编号</td>
											<td>姓名</td>
											<td>用户名</td>
											<td>注册时间</td>
											<td>手机号码</td>
											<td>身份证号</td>
											<td>最近一次拉黑时间</td>
											<td>拉黑次数</td>
											<td>电子邮箱</td>
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
		</div>
		<div class="w-content" id="cancelBlackList">
			<label>取消拉黑原因</label><textarea class="cancelCause"></textarea>
		</div>
		<div class="w-content" id="prohibitedItem">
			<span><input type="checkbox" ><label>禁止借款</label></span>
			<span><input type="checkbox" ><label>禁止投资</label></span>
			<input type="checkbox" ><label>禁止提现</label></span>
			<span><input type="checkbox" ><label>禁止积分兑换</label></span>
			<span><input type="checkbox" ><label>禁止抽奖</label></span>
			<span><input type="checkbox" ><label>禁止抢红包</label></span>
		</div>
	</div>
	
		<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/member.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#table_id').DataTable({
				"scrollX":true,
				//"scrollY":true,
				"aaSorting" : [ [ 4,7,8, "desc" ] ],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [0,1,2,3,5,6,9]
				} // 制定列不参与排序
				],
			});
		});
	</script>
</body>