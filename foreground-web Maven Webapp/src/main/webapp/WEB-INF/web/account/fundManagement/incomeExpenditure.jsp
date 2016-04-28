<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>收支明细</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/fundManagement/incomeExpenditure.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
	   				<!-- 收支明细 -->
	   				<!-- 李丽梅 -->
	   				<!-- 2016-04-01 -->
	   				<ul class="iEDHead">
						<li class="iEDHeadTab iEDHeadIng">交易记录</li>
						<li class="iEDHeadTab">充值记录</li>
						<li class="iEDHeadTab">提现记录</li>
					</ul>
   					<div class="iEDtabContent  ">
   						<div class="iEDContent iEDcontentActive ">
   							<div class="iEDTrecordType clearfix">
   								<div class="iEDTrecordTypeLeft">
	   								<label class="iEDTrecordTypeLeft">交易类型：</label>
	   								<div class="iEDTrecordTypeLeft clearfix">
	   									<input class="selectValue" value="1" >
	   									<input class="selectInput iEDInputA" type="text" lang="充值" readOnly="true"/>
									    <ul class="select iEDSelect" onselectstart="return false">
									    	<li class="selectOption" value="1">充值</li>
									    	<li class="selectOption" value="2">生活缴费</li>
									    </ul>
	   								</div>
   								</div>
   								<div class="iEDTrecordTypeLeft">
   									<label class="iEDleft">时间范围：</label>
   									<input class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
   									<i></i>
   									<input class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
   								</div>
   								<!-- <div class="iEDTrecordTypeLeft iEDDivCunt"> -->
	   								<div class="iEDTrecordTypeLeft iEDDiv "><em class="active ">今天</em>
	   								<em>最近一周</em>
	   								<em>一个月</em>
	   								<em>六个月</em>
   								</div>
   								<div class="iEDTrecordTypeLeftSpan iEDDiv2"><span class="btn btnHeight" onselectstart="return false">搜索</span></div>
   							</div>
   							<div class="iEDTrecord">
   								<ul>
			   						<li class="awardTableHead">
		  								<div class="awardTableHead1 awardTableRegisterAllJu">序号ID</div>
		  								<div class="awardTableHead2">交易类型</div>
		  								<div class="awardTableHead3">交易金额<em class="btnUp"></em></div>
		  								<div class="awardTableHead4">总金额<em class="btnUp"></em></div>
		  								<div class="awardTableHead5">冻结金额<em class="btnUp"></em></div>
		  								<div class="awardTableHead6">待收本金<em class="btnUp"></em></div>
		  								<div class="awardTableHead7">待收利息<em class="btnUp"></em></div>
		  								<div class="awardTableHead8">可用余额<em class="btnUp"></em></div>
		  								<div class="awardTableHead9">待还本金<em class="btnUp"></em></div>
		  								<div class="awardTableHead10">待还利息<em class="btnUp"></em></div>
		  								<div class="awardTableHead11">待还逾期利息/罚金<em class="btnUp"></em></div>
		  								<div class="awardTableHead12">交易对方</div>
		  								<div class="awardTableHead13">交易时间</div>
			   						</li>
			   						<%for(int i = 0;i<4;i++){ %>
		   							<li class="awardTableRegister">
		   								<div class="awardTabRegister">
		   									<div class="awardTableHead1 "><span>112345</span></div>
		   									<div class="awardTableHead2 "><span>充值</span></div>
		   									<div class="awardTableHead3a "><span class="moneyFormat">100</span></div>
		   									<div class="awardTableHead4 awardDistance "><span class="moneyFormat">100</span></div>
		   									<div class="awardTableHead5a awardDistance "><span class="moneyFormat">0</span></div>
		   									<div class="awardTableHead6 awardDistance "><span class="moneyFormat">100</span></div>
		   									<div class="awardTableHead7 awardDistance "><span class="moneyFormat">100</span></div>
		   									<div class="awardTableHead8 awardDistance "><span class="moneyFormat">1000</span></div>
		   									<div class="awardTableHead9 awardDistance "><span class="moneyFormat">100</span></div>
		   									<div class="awardTableHead10 awardDistance "><span class="moneyFormat">100</span></div>
		   									<div class="awardTableHead11 awardDistance "><span class="moneyFormat">1000/10</span></div> 
		   									<div class=" awardTableHead12-1"><span>平台</span></div>
	   										<div class="awardTableHead13-1 "> 
		   										<div class="contentA">
													2016-08-07
		   											14:12:00
												</div>
		   										
	   										</div>
		   								</div>
		   								<div class="iEDTrecordInfo">
		   									<div class="iEDTrecordInfoDiv">
		   										<span>序号：125456</span>
		   										<span>地区：四川 成都</span>
		   										<span>交易时间：2016-12-11 12:00:12</span>
		   									</div>
		   									<div class="iEDTrecordInfoDiv">
		   										<span>用户名：大力金刚</span>
		   										<span>交易类型：支付充值手续费</span>
		   									</div>
		   									<div class="iEDTrecordInfoDiv2">
		   										<p class="iEDTrecordInfoP1"><span>总金额：</span><i class="moneyFormat">12</i> <span class="iEDTrecordInfofuha">=</span></p> 
		   										<p class="iEDTrecordInfoP2"><span>可用余额：<em class="moneyFormat">12</em></span>
		   										<span class="iEDTrecordInfofuha">+</span><span>冻结金额：<em class="moneyFormat">1</em></span><span>+</span><span >待收本金：<em class="moneyFormat">0</em></span>
		   										<span class="iEDTrecordInfofuha">+</span><span>待收利息：<em  class="moneyFormat">0</em></span><span class="iEDTrecordInfofuha">-</span><span>待还本金：<em class="moneyFormat">0</em></span>
		   										<span class="iEDTrecordInfofuha">-</span><span>待还利息：<em  class="moneyFormat">0</em></span><span class="iEDTrecordInfofuha">-</span><span>待还逾期利息：<em class="moneyFormat">0</em></span>
		   										<span class="iEDTrecordInfofuha">-</span><span>待还逾期罚金：<em  class="moneyFormat">0</em></span></p>
		   									</div>
		   								</div>
		   							</li>
		   								<% } %>
		   						</ul>
   							</div>
 							<!-- 分页标签 -->
 							<div class="pagerCu" id="pager"></div>
   						</div>
   						<div class="iEDContent">
   							<div class="iEDContentHead">
   								<div class="iEDContentHeadTop">
   									<span>●</span><span>充值总手续费：</span><b class="iEDContentHeadTopBa moneyFormat">100</b><span class="iEDContentHeadTopSpan3">元</span>
   								</div>
   								<div class="iEDContentHeadTop">
   									<span>●</span><span>实际到账总金额：</span><b class="iEDContentHeadTopBb moneyFormat">1000</b><span class="iEDContentHeadTopSpan3">元</span>
   								</div>
   								<div class="iEDContentHeadC">
   									<span>充值</span>
   								</div>
   							</div>
   							<div class="iEDTrecordType clearfix">
   								<div class="iEDTrecordTypeLeft">
   									<label class="iEDleft">第三方交易流水号:</label>
   									<input class="iEDInput iEDInputB" type="text" lang="输入交易流水号">
   								</div>
   								
   								<div class="iEDTrecordTypeLeft iEDTrecordTypeLeftJ">
   									<label class="iEDleft">时间范围：</label>
   									<input class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
   									<i></i>
   									<input class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
   								</div>
   								<div class="iEDTrecordTypeLeft">
	   								<label class="iEDTrecordTypeLeft">状态：</label>
	   								<div class="iEDTrecordTypeLeft ">
	   									<input class="selectValue" value="1" >
									  	<input class="selectInput iEDInputA" type="text" lang="成功" readOnly="true"/>
									    <ul class="select iEDSelecta" onselectstart="return false">
									    	<li class="selectOption" value="1">成功</li>
									    	<li class="selectOption" value="2">失败</li>
									    </ul>
	   								</div>
   								</div>
   								<div class="iEDTrecordTypeLeft iEDDiv2"><span class="btn btnHeight" onselectstart="return false">搜索</span></div>
   							</div>
   							<div class="iEDTrecord">
   								<ul>
			   						<li class="awardTableHeada">
		  								<div class="awardTableCu1 ">充值金额<em class="btnUp"></em></div>
		  								<div class="awardTableCu2">充值时间<em class="btnUp"></em></div>
		  								<div class="awardTableCu3">充值手续费</div>
		  								<div class="awardTableCu4">充值方式</div>
		  								<div class="awardTableCu5">实际到账金额<em class="btnUp"></em></div>
		  								<div class="awardTableCu6">第三方交易流水号</div>
		  								<div class="awardTableCu7">状态</div>
			   						</li>
		   							 <li class="awardTableRegister awardTableRegisterH clearfix">
		   								<div class="awardTableCu1 moneyFormat"><span>100</span></div>
		   								<div class="awardTableCu2-1 ">  
	   										<div class="contentB">
												2016-08-07
	   											14:12:00
											</div>
	   									</div>
	   									<div class="awardTableCu3 moneyFormat"><span>10</span></div>
	   									<div class="awardTableCu4"><span>网银充值</span></div>
	   									<div class="awardTableCu5 moneyFormat"><span>100</span></div>
	   									<div class="awardTableCu6"><span>s2574523644</span></div>
	   									<div class="awardTableCu7"><span class="awardTableAllSpan">成功</span></div>
		   							</li>
		   							<li class="awardTableRegister awardTableRegisterH">
		   								<div class="awardTableCu1 moneyFormat"><span>100</span></div>
		   								<div class="awardTableCu2-1 ">  
	   										<div class="contentB">
												2016-08-07
	   											14:12:00
											</div>
	   									</div>
	   									<div class="awardTableCu3 moneyFormat"><span>10</span></div>
	   									<div class="awardTableCu4"><span>快捷支付</span></div>
	   									<div class="awardTableCu5 moneyFormat"><span>100</span></div>
	   									<div class="awardTableCu6"><span>s2574523644</span></div>
	   									<div class="awardTableCu7"><span class="awardTableAllSpan">成功</span></div>
		   						
		   							</li>
		   							<li class="awardTableRegister awardTableRegisterH">
		   								<div class="awardTableCu1 moneyFormat"><span>100</span></div>
   										<div class="awardTableCu2-1 ">  
	   										<div class="contentB">
												2016-08-07
	   											14:12:00
											</div>
	   									</div>
	   									<div class="awardTableCu3 moneyFormat"><span>10</span></div>
	   									<div class="awardTableCu4"><span>企业网银</span></div>
	   									<div class="awardTableCu5 moneyFormat"><span>100</span></div>
	   									<div class="awardTableCu6"><span>s2574523644</span></div>
	   									<div class="awardTableCu7"><span>失败</span></div>
		   								
		   							</li>
		   							<li class="awardTableRegister awardTableRegisterH">
		   								<div class="awardTableCu1 moneyFormat"><span>100</span></div>
   										<div class="awardTableCu2-1 ">  
	   										<div class="contentB">
												2016-08-07
	   											14:12:00
											</div>
	   									</div>
		   								 <div class="awardTableCu3 moneyFormat"><span>10</span></div>
	   									<div class="awardTableCu4"><span>汇款充值</span></div>
	   									<div class="awardTableCu5 moneyFormat"><span>100</span></div>
	   									<div class="awardTableCu6"><span>s2574523644</span></div>
	   									<div class="awardTableCu7"><span>失败</span></div>
		   							</li>
		   						</ul>
   							</div>
   							<!-- 分页标签 -->
   							<!-- <div class="pagerCu" id="pager"></div> -->
   							<div class="pagerCu" id="pager1"></div>
   						</div>
   						<div class="iEDContent">
   							<div class="iEDContentHead">
   								<div class="iEDContentHeadTop">
   									<span>●</span><span>提现总手续费：</span><b class="iEDContentHeadTopBa moneyFormat">100</b><span class="iEDContentHeadTopSpan3">元</span>
   								</div>
   								<div class="iEDContentHeadTop">
   									<span>●</span><span>实际到账总金额：</span><b class="iEDContentHeadTopBb moneyFormat">1000</b><span class="iEDContentHeadTopSpan3">元</span>
   								</div>
   								<div class="iEDContentHeadC">
   									<span>充值</span>
   								</div>
   							</div>
   							<div class="iEDTrecordType clearfix">
   								<div class="iEDTrecordTypeLeft">
   									<label class="iEDleft">时间范围：</label>
   									<input class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
   									<i></i>
   									<input class="iEDInput iEDInputBack Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
   								</div>
   								<div class="iEDTrecordTypeLeft iEDDiv2"><span class="btn btnHeight" onselectstart="return false">搜索</span></div>
   							</div>
   							<div class="iEDTrecord">
   								<ul>
			   						<li class="awardTableHeada1">
		  								<div class="awardTabCuA1 ">提现金额<em class="btnUp"></em></div>
		  								<div class="awardTabCuA2">提现时间<em class="btnUp"></em></div>
		  								<div class="awardTabCuA3">提现手续费</div>
		  								<div class="awardTabCuA4">提现银行</div>
		  								<div class="awardTabCuA5">到账时间</div>
		  								<div class="awardTabCuA6">实际到账金额<em class="btnUp"></em></div>
		  								<div class="awardTabCuA7">第三方交易流水号</div>
		  								<div class="awardTabCuA8">备注</div>
		  								<div class="awardTabCuA9">状态</div>
			   						</li>
		   							<li class="awardTableRegister awardTableRegisterH1">
	   									<div class="awardTabCuA1 moneyFormat"><span>100</span></div>
	   									<div class="awardTabCuA2-1">
											<div class="contentC">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
	   								 	<div class="awardTabCuA3 moneyFormat"><span>10</span></div>
	   									<div class="awardTabCuA4"><span>中国银行</span></div>
   										<div class="awardTabCuA2-1">
											<div class="contentC">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
	   									<div class="awardTabCuA6 moneyFormat"><span>100</span></div>
	   									<div class="awardTabCuA7"><span>s2574523644</span></div> 
	   									<div class="awardTabCuA8"><span>提现理财</span></div>
	   									<div class="awardTabCuA9"><span class="awardTableAllSpan">待审核</span></div>
		   							</li>
		   							<li class="awardTableRegister awardTableRegisterH1">
		   								<div class="awardTabCuA1 moneyFormat"><span>100</span></div>
   										<div class="awardTabCuA2-1">
											<div class="contentC">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
	   									<div class="awardTabCuA3 moneyFormat"><span>10</span></div>
	   									<div class="awardTabCuA4"><span>中国银行</span></div> 
   										<div class="awardTabCuA2-1">
											<div class="contentC">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
	   									<div class="awardTabCuA6 moneyFormat"><span>100</span></div>
	   									<div class="awardTabCuA7"><span>s2574523644</span></div> 
	   							        <div class="awardTabCuA8"><span>提现理财</span></div>
	   									<div class="awardTabCuA9"><span class="awardTableAllSpan">待审核</span></div>
		   							</li>
		   							<li class="awardTableRegister awardTableRegisterH1">
	   									<div class="awardTabCuA1 moneyFormat"><span>100</span></div>
   										<div class="awardTabCuA2-1">
											<div class="contentC">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
	   									<div class="awardTabCuA3 moneyFormat"><span>10</span></div>
	   									<div class="awardTabCuA4"><span>中国银行</span></div>
   										<div class="awardTabCuA2-1">
											<div class="contentC">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
										
	   									<div class="awardTabCuA6 moneyFormat"><span>100</span></div>
	   									<div class="awardTabCuA7"><span>s2574523644</span></div>
	   									<div class="awardTabCuA8"><span>提现理财</span></div>
	   									<div class="awardTabCuA9"><span>提现成功</span></div>
		   							</li>
		   							<li class="awardTableRegister awardTableRegisterH1">
	   									<div class="awardTabCuA1 moneyFormat"><span>100</span></div>
   										<div class="awardTabCuA2-1">
											<div class="contentC">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
	   									<div class="awardTabCuA3 moneyFormat"><span>10</span></div>
	   									<div class="awardTabCuA4"><span>中国银行</span></div>
   										<div class="awardTabCuA2-1">
											<div class="contentC">
											 	2016-08-07
	   											14:12:00
											</div>
										</div>
	   									<div class="awardTabCuA6 moneyFormat"><span>100</span></div>
	   									<div class="awardTabCuA7"><span>s2574523644</span></div>
	   									<div class="awardTabCuA8"><span>提现理财</span></div>
	   									<div class="awardTabCuA9"><span>提现成功</span></div>
		   							</li>
		   						</ul>
   							</div>
   							<!-- 分页标签 -->
   							<div class="pagerCu" id="pager2"></div>
   						</div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
  	 <!-- 分页标签 -->
   <!--  <script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script> -->
   <script type="text/javascript" src="plugs/pager/pager.js"></script>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/fundManagement/incomeExpenditure.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
	
</body>
</html>