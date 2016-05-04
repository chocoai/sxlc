<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge" />  -->
	<base href="<%=basePath%>">
	<title>企业会员管理全部会员</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/companyMembers.css" type="text/css" >
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
				<jsp:param value="202" name="_index_m2"/>
				<jsp:param value="20201" name="_index_m3"/>
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
									<span class="con-item"><span>企业名称</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>用户名</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>联系人手机号</span><input type="text" class="notspecial" /></span>
									<span class="con-item"><span>开启自动投标</span><select><option>是</option><option>否</option></select></span>
									<span class="con-item"><span>开启自动还款</span><select><option>是</option><option>否</option></select></span>
									<button class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</form>
						  	</div>
						 </div>
					</div> 
					<div class="data_display">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="action_item">
									<button class="obtn glyphicon examine" onclick="companyDetailView();">查看会员详情</button>
									<button class="obtn glyphicon" onclick="loanView();">借款项目查询</button>
									<button class="obtn glyphicon" onclick="investView();">投资项目查询</button>
									<button class="obtn glyphicon" onclick="transactionRecord();">交易记录</button>
									<button class="obtn glyphicon" onclick="cardView()">银行卡查询</button>
									<button class="obtn glyphicon" onclick="inviteView();">查看邀请会员列表</button>
									<button class="obtn glyphicon defriend">拉黑</button>
									<button class="obtn glyphicon" onclick="resetPWDRecord();">会员密码重置记录</button>
									<button class="obtn glyphicon" onclick="resetPWD('重置密码','web/member/allMembers/resetPWDC.jsp','2')">会员密码重置</button>
									<button class="obtn glyphicon" onclick="inviteVip();">修改邀请会员</button>
									<button class="obtn glyphicon" onclick="messageSendPer('发送信息','web/member/allMembers/per-messageSend.jsp','2');">发送消息</button>
								</div>
							</div>
							
							<div class="panel-body">
								<table id="table_id" class="display">
									<thead>
										<tr>
											<th class="table-checkbox"></th>
											<th>会员编号</th>
											<th>企业名称</th>
											<th>用户名</th>
											<th>联系人手机号码</th>
											<th>所属地区</th>
											<th>会员等级</th>
											<th>信用等级</th>
											<th>第三方帐户</th>
											<th>可用帐户余额(元)</th>
											<th>冻结金额(元)</th>
											<th>充值总额(元)</th>
											<th>投资总额(元)</th>
											<th>借款总额(元)</th>
											<th>提现总额(元)</th>
											<th>收益总额(元)</th>
											<th>可用积分</th>
											<th>赠送红包总额(元)</th>
											<th>使用红包总额(元)</th>
											<th>已过期红包总额(元)</th>
											<th>剩余可用红包总额(元)</th>
											<th>是否开启自动投标</th>
											<th>是否开启自动还款</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < 15; i++) {
										%>
										<tr>
											<td><input type="checkbox" /></td>
											<td>1</td>
											<td>企业名称</td>
											<td>用户名</td>
											<td>15225545878</td>
											<td>所属地区</td>
											<td>会员等级</td>
											<td>信用等级</td>
											<td>第三方帐户</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">1000</td>
											<td>可用积分</td>
											<td class="moneyFormat">1000</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">100</td>
											<td class="moneyFormat">100</td>
											<td>是</td>
											<td>否</td>
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
	<script type="text/javascript" src="plugs/My97DatePicker/WdatePicker.js"></script>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/companyMembers.js"></script>
	<script type="text/javascript" src="js/member/member.js"></script>
	<script type="text/javascript" src="js/member/memberPwd.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#table_id').DataTable({
				"scrollX":true,
				//"scrollY":true,
				"aaSorting" : [ [ 6,7,9,10,11,12,13,14,15, "desc" ] ],//默认第几个排序
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [0,1,2,3,4,5,8,16,17,18,19,20,21,22]
				} // 制定列不参与排序
				],
			});
		});
	</script>
</body>