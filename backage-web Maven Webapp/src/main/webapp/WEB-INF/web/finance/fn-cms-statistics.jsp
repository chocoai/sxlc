<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//LoanTransferEntity loanTransferEntity=(LoanTransferEntity)request.getAttribute("loanTransferEntity");
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>财务管理-佣金发放</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/finance/fn-recharge.css" type="text/css"/>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="4" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-finance.jsp">
				<jsp:param value="408" name="_index_m2"/>
				<jsp:param value="" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="search">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="i-fl search_title">条件查询</div>
							<div class="i-fr action_item">
								<ul class="list_item list-inline">
									<li>
										<a class="state">展开&nbsp;<span class="glyphicon glyphicon-chevron-down"></span> </a>
									</li>
								</ul>
							</div>
						</div>
						<div class="panel-body">
							<form id="" class="" action="">
								<div class="cms-st">
									<span class="con-item">
										<span>会员编号</span><input id="memberNo" type="text" class="" placeholder="" />
									</span>
									<span class="con-item">
										<span>姓名</span><input id="personalName" type="text" class="" placeholder="" />
									</span>
									<span class="con-item">
										<span>联系电话</span><input id="personalPhone" type="text" class="" placeholder="" />
									</span>
									<span class="con-item">
										<span>月份</span><input type="text" id="startDate" class="dateInput Wdate notspecial" onFocus="WdatePicker({dateFmt: 'yyyy-MM', maxDate: '#F{$dp.$D(\'endDate\')||\'%y-%M-%d\'}' })" ><span class="line"></span><input type="text" id="endDate" class="dateInput Wdate"  onFocus="WdatePicker({dateFmt: 'yyyy-MM', minDate: '#F{$dp.$D(\'startDate\')}' ,maxDate:'%y-%M-%d' })" >
									</span>
									<span class="con-item">
										<span>发放状态</span>
										<select id="payStatu" class="rechargeoption">
											<option value="2">已发放</option>
											<option value="0">未发放</option>
										</select>
									</span>
									<span class="con-item">
										<span>推广类型</span>
										<select id="types" class="rechargeoption choType">
											<option value="0">理财顾问</option>
											<option value="1">推荐达人</option>
										</select>
									</span>
									<button type="button" class="obtn obtn-query glyphicon glyphicon-search">查询</button>
								</div>
							</form>
						</div>
					</div>	
				</div>
				<div class="data_display">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="action_item">
								<button class="obtn glyphicon glyphicon-export">导出</button>
								<button class="obtn glyphicon glyphicon-credit-card" onclick="sendCms()">发放</button>
								<button class="obtn glyphicon glyphicon-cog" onclick="borrowRecord()">推荐借款明细</button>
								<button class="obtn glyphicon glyphicon-cog" onclick="invRecord()">推荐投资明细</button>
								<button class="obtn glyphicon glyphicon-cog" onclick="vipRecord()">推荐购买VIP明细</button>
								<button class="obtn glyphicon glyphicon-cog" onclick="debtRecord()">推荐还本明细</button>
								<!-- onclick="accRecharge() -->
							</div>
						</div>
						<div class="panel-body">
							<table id="table_id" class="display">
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="sendCms">
		<div class="sc-cont">
		<form id="rechargeform" class="accrechargeform" action="commission/sendcommission.do" type="post">
			<p><label>推荐借款提奖金额：</label><span id="borrowAward">1000</span>元</p>
			<p><label>推荐投资提奖金额：</label><span id="investAward">1000</span>元</p>
			<p><label>推荐购买VIP提奖金额：</label><span id="vipAward">1000</span>元</p>
			<p><label>推荐还本金额：</label><span id="repayAward">1000</span>元</p>
			<p><label>推荐提奖总额：</label><span id="allmonay">1000</span>元</p>
			<div><label>实发金额：</label><input id="realMoney" name="realMoney" type="text" class="rechargeinput" placeholder="" datatype="amcountM"><span>元</span></div>
			<input id="memberId" type="hidden" name="memberId" value="" />
			<input id="type" type="hidden" name="type" value="" />
			<input id="startTime" type="hidden" name="startTime" value="" />
			<input id="endTime" type="hidden" name="endTime" value="" />
		</form>
			<div class="cmbtncontainer accrechargecon">
				<a class="commonbtn0">确定</a>
				<a class="commonbtn1">取消</a>
			</div>
		</div>
	</div>
	<div id="setAlert">
		<div class="sc-cont">
			发放成功后通知方式：
			<label><input type="checkbox" />发送短信</label>
			<label><input type="checkbox" />站内信提醒</label>
			<div class="cmbtncontainer accrechargecon">
				<a class="commonbtn0">确定</a>
				<a class="commonbtn1">取消</a>
			</div>
		</div>
	</div>
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript" src="js/finance/fn-cms-statistics.js"></script>
	<script type="text/javascript" src="js/finance/commissingDetail.js"></script>
	<script type="text/javascript">
		var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>	
</body>
</html>