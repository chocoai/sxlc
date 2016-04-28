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
	<title>投资会员</title>
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
				<jsp:param value="20107" name="_index_m3"/>
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
									<button class="obtn glyphicon" onclick="loanView();">借款项目查询</button>
									<button class="obtn glyphicon" onclick="investView();">投资项目查询</button>
									<button class="obtn glyphicon" onclick="transactionRecord();">交易记录</button>
									<button class="obtn glyphicon" onclick="recordQuery();">提现记录查询</button>
									<button class="obtn glyphicon" onclick="inviteView();">查看邀请会员列表</button>
									<button class="obtn glyphicon" onclick="messageSendPer();">发送消息</button>
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
											<th>所属地区</th>
											<th>手机号码</th>
											<th>第三方帐户</th>
											<th>帐户余额</th>
											<th>冻结金额</th>
											<th>充值总额</th>
											<th>充值手续费合计(平台)</th>
											<th>充值手续费合计(会员)</th>
											<th>投资总额</th>
											<th>累计收益管理费</th>
											<th>提现总额</th>
											<th>提现手续费合计(平台)</th>
											<th>提现手续费合计(会员)</th>
											<th>借款总额</th>
											<th>累计借款管理费</th>
											<th>在借金额</th>
											<th>已结清金额</th>
											<th>累计逾期未还本金</th>
											<th>累计逾期未还利息</th>
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
											<td>所属地区</td>
											<td>手机号码</td>
											<td>第三方帐户</td>
											<td class="moneyFormat">1200</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">1500</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">15000</td>
											<td class="moneyFormat">50</td>
											<td class="moneyFormat">10</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">12250</td>
											<td class="moneyFormat">1215</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">1000</td>
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
				"aaSorting" : [ [ 7,9,14,19,21,22, "desc" ] ],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [0,1,2,3,4,5,6,8,10,11,12,13,15,16,17,18,20]
				} // 制定列不参与排序
				],
			});
		});
	</script>
</body>