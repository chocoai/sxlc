<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>推荐达人</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/recommendedTalent.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css"></link>
</head>
<body> 
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="/web/account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="/web/account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
   				<!-- 主体部分开始 王延君 2016-04-05 -->
   					<div class="recommendedTalent" onselectstart="return false;">
   						<!-- 公共部分开始 -->
   						<div class="recommendedTalentH">
   							<div>推荐达人</div>
   							<span class="apply">申请成为推荐达人</span>
   						</div>
   						<div class="recommendedTalentInfo">
   							<div class="TalentInfoL">
   								<div>推荐成功投资总金额：<span class="moneyFormat">4000</span>元</div>
   							</div>
   							<div class="TalentInfoR">
   								<div>推荐成功借款总金额：<span class="moneyFormat">4000</span>元</div>
   							</div>
   							<div class="TalentInfoL">
   								<div>推荐购买VIP总金额：<span class="moneyFormat">4000</span>元</div>
   							</div>
   							<div class="TalentInfoR">
   								<div>推荐成功还本总金额：<span class="moneyFormat">4000</span>元</div>
   							</div>
   							<div class="TalentInfoL">
   								<div>推荐提奖总金额：<span class="moneyFormat">140</span>元</div>
   							</div>
   						</div>
   						<!-- 公共部分结束 -->
   						<!-- 提奖统计部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain1">
   							<div class="recommendedTalentMAward">
	   							<div class="search">
	   								<div class="choose">
	   									<label>时间范围:</label><input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseTime">
	   									<span>今天</span>
	   									<span>最近一周</span>
	   									<span>一个月</span>
	   									<span>六个月</span>
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" onselectstart="return false">搜索</div>
	   								</div>
	   								<div class="btn btnExport" onselectstart="return false"><label></label>导出</div>
	   							</div>
   							</div>
   							<div class="recommendedTalentMCont">
	   							<div class="ContHeader">
	   								<div class="awardStatistics">提奖统计</div>
	   								<div class="historyCashBack">历史返现</div>
	   								<div class="inviteRecord">邀请记录</div>
	   								<div class="LoanDetails">借款明细</div>
	   								<div class="investDetails">投资明细</div>
	   								<div class="historyPrincipalBack">还本明细</div>
	   								<div class="purchaseDetails">VIP购买明细</div>
	   							</div>
	   							<div class="ContList">
	   								<ul class="awardStatisticsUl">
	   									<li>
	   										<div class="ContListTitle">
			   									<div class="userName">用户名</div>
			   									<div class="trueName">姓名</div>
			   									<div class="loanAmount">借款金额</div>
			   									<div class="awardAmount">借款提奖金额</div>
			   									<div class="effectiveInvestmentAmount">有效投资金额</div>
			   									<div class="investmentAwardAmount">投资提奖金额</div>
			   									<div class="purchaseTimes">购买VIP次数/提奖金额</div>
			   									<div class="successfulDebt">成功还本/提奖总金额</div>
			   									<div class="totalAwardAmount">提奖总金额</div>
	   										</div>
	   									</li>
	   									<%for(int i=0;i<8;i++){%>
	   									<li>
	   										<div class="ContListMain">
	   											<div class="userName outside">
		   											<div class="inside">
		   												<div>理财师01</div>
		   											</div>
	   											</div>
		   										<div class="trueName outside">
		   											<div class="inside">
		   												<div>张三</div>
		   											</div>
		   										</div>
		   										<div class="loanAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">45145256</div>
		   											</div>
		   										</div>
		   										<div class="awardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">520</div>
		   											</div>
		   										</div>
		   										<div class="effectiveInvestmentAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10256142</div>
		   											</div>
		   										</div>
		   										<div class="investmentAwardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">32</div>
		   											</div>
		   										</div>
		   										<div class="purchaseTimes outside">
		   											<div class="inside">
		   												<div>25/<span class="moneyFormat">200</span></div>
		   											</div>
		   										</div>
		   										<div class="successfulDebt outside">
		   											<div class="inside">
		   												<div>
		   													<span class="moneyFormat">1000</span>/<span class="moneyFormat">1100</span>
		   												</div>
		   											</div>
		   										</div>
		   										<div class="totalAwardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">47</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
	   									<%}%>
	   									<li class="page"><div id="pager"></div></li>
	   								</ul>
	   							</div>
	   						</div>
   						</div>
   						<!-- 提奖统计部分结束 -->
   						<!-- 历史返现部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain2">
   							<div class="recommendedTalentMAward">
	   							<div class="search">
	   								<div class="monthCount">
	   									<label>提奖统计月份:</label>
	   									<div class="selectArea">
	   										<input class="selectValue" value="1" >
										    <input class="selectInput" type="text" lang="" readOnly="true"/>
										    <ul class="select" onselectstart="return false">
										        <li class="selectOption" value="1">2月<li>
										        <li class="selectOption" value="2">3月<li>
										        <li class="selectOption" value="3">4月<li>
										        <li class="selectOption" value="4">5月<li>
										    </ul>
										</div>
	   								</div>
	   								<div class="choose">
	   									<label>时间范围:</label><input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" onselectstart="return false">搜索</div>
	   								</div>
	   								<div class="btn btnExport" onselectstart="return false"><label></label>导出</div>
	   							</div>
   							</div>
   							<div class="recommendedTalentMCont">
	   							<div class="ContHeader">
	   								<div class="awardStatistics">提奖统计</div>
	   								<div class="historyCashBack">历史返现</div>
	   								<div class="inviteRecord">邀请记录</div>
	   								<div class="LoanDetails">借款明细</div>
	   								<div class="investDetails">投资明细</div>
	   								<div class="historyPrincipalBack">还本明细</div>
	   								<div class="purchaseDetails">VIP购买明细</div>
	   							</div>
	   							<div class="ContList">
	   								<ul class="historyCashBackUl">
	   									<li>
	   										<div class="ContListTitle">
			   									<div class="statisticalTimePeriod outside">
			   										<div class="inside insideFontColor">统计时间段</div>
			   									</div>
			   									<div class="totalLoanAmount outside">
			   										<div class="inside insideFontColor">借款总金额</div>
			   									</div>
			   									<div class="awardAmount outside">
			   										<div class="inside insideFontColor">借款提奖金额</div>
			   									</div>
			   									<div class="totalInvestmentAmount outside">
			   										<div class="inside insideFontColor">投资总金额</div>
			   									</div>
			   									<div class="investmentAwardAmount outside">
			   										<div class="inside insideFontColor">投资提奖金额</div>
			   									</div>
			   									<div class="totalPrincipalAmount outside">
			   										<div class="inside insideFontColor">还本总金额/<br>还本提奖金额</div>
			   									</div>
			   									<div class="totalAmountPurchasedVIP outside">
			   										<div class="inside insideFontColor">购买VIP总金额/<br>VIP提奖金额</div>
			   									</div>
			   									<div class="totalAwardAmount outside">
			   										<div class="inside insideFontColor">提奖总金额</div>
			   									</div>
			   									<div class="actualAwardAmount outside">
			   										<div class="inside insideFontColor">实际提奖金额</div>
			   									</div>
			   									<div class="mentionAwardTime outside">
			   										<div class="inside insideFontColor">提奖发放时间</div>
			   									</div>
			   									<div class="releaseStatus outside">
			   										<div class="inside insideFontColor">发放状态</div>
			   									</div>
	   										</div>
	   									</li>
	   									<%for(int i=0;i<8;i++){%>
	   									<li>
	   										<div class="ContListMain">
	   											<div class="statisticalTimePeriod outside">
		   											<div class="inside">
		   												<div>2016-04-07<br>12:12:00</div>
		   											</div>
	   											</div>
		   										<div class="totalLoanAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">145256</div>
		   											</div>
		   										</div>
		   										<div class="awardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">520</div>
		   											</div>
		   										</div>
		   										<div class="totalInvestmentAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10256142</div>
		   											</div>
		   										</div>
		   										<div class="investmentAwardAmount outside">
		   											<div class="inside">
		   												<div>25/<span class="moneyFormat">200</span></div>
		   											</div>
		   										</div>
		   										<div class="totalPrincipalAmount outside">
		   											<div class="inside">
		   												<div>25/<span class="moneyFormat">200</span></div>
		   											</div>
		   										</div>
		   										<div class="totalAwardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">1000</div>
		   											</div>
		   										</div>
		   										<div class="totalPrincipalAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">1000</div>
		   											</div>
		   										</div>
		   										<div class="actualAwardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">47</div>
		   											</div>
		   										</div>
		   										<div class="mentionAwardTime outside">
		   											<div class="inside">
		   												<div>2016-04-07<br>12:12:00</div>
		   											</div>
		   										</div>
		   										<div class="releaseStatus outside">
		   											<div class="inside">
		   												<div>已发</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
	   									<%}%>
	   									<li class="page"><div id="pager1"></div></li>
	   								</ul>
	   							</div>
	   						</div>
   						</div>
   						<!-- 历史返现部分结束 -->
   						<!-- 邀请记录部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain3">
   							<div class="recommendedTalentMHistory">
	   							<div class="search">
	   								<div class="monthCount">
	   									<label>开户状态:</label>
	   									<div class="selectArea">
	   										<input class="selectValue" value="1" >
										    <input class="selectInput" type="text" lang="" readOnly="true"/>
										    <ul class="select" onselectstart="return false">
										        <li class="selectOption" value="1">已开户<li>
										        <li class="selectOption" value="2">未开户<li>
										    </ul>
										</div>
	   								</div>
	   								<div class="choose">
	   									<label>时间范围:</label><input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseName">
	   									<label>会员/用户名:</label><input type="text" lang="请输入会员/用户名" maxlength="20">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" onselectstart="return false">搜索</div>
	   								</div>
	   							</div>
   							</div>
   							<div class="recommendedTalentMCont">
	   							<div class="ContHeader">
	   								<div class="awardStatistics">提奖统计</div>
	   								<div class="historyCashBack">历史返现</div>
	   								<div class="inviteRecord">邀请记录</div>
	   								<div class="LoanDetails">借款明细</div>
	   								<div class="investDetails">投资明细</div>
	   								<div class="historyPrincipalBack">还本明细</div>
	   								<div class="purchaseDetails">VIP购买明细</div>
	   							</div>
	   							<div class="ContList">
	   								<ul class="inviteRecordUl">
	   									<li>
	   										<div class="ContListTitle">
			   									<div class="VIPName">会员名</div>
				   								<div class="userName">用户名</div>
				   								<div class="registerRecord">注册时间<em class="iconDown"></em></div>
				   								<div class="accountStatus">开户状态</div>
	   										</div>
	   									</li>
	   									<%for(int i=0;i<8;i++){%>
	   									<li>
	   										<div class="ContListMain">
	   											<div class="VIPName outside">
		   											<div class="inside">
		   												<div>刘先生</div>
		   											</div>
	   											</div>
		   										<div class="userName outside">
		   											<div class="inside">
		   												<div>大大大刘</div>
		   											</div>
		   										</div>
		   										<div class="registerRecord outside">
		   											<div class="inside">
		   												<div>2016-02-02<br>12:12:00</div>
		   											</div>
		   										</div>
		   										<div class="accountStatus outside">
		   											<div class="inside">
		   												<div>已开户</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
	   									<%}%>
	   									<li class="page"><div id="pager2"></div></li>
	   								</ul>
	   							</div>
	   						</div>
   						</div>
   						<!-- 邀请记录部分结束-->
   						<!-- 借款明细部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain4">
   							<div class="recommendedTalentMHistory">
	   							<div class="search">
	   								<label>借款名称:</label><input type="text" lang="输入借款名称" maxlength="20">
	   								<div class="choose">
	   									<label>放款时间段:</label><input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseName">
	   									<label>会员/用户名:</label><input type="text" lang="请输入会员/用户名" maxlength="20">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" onselectstart="return false">搜索</div>
	   								</div>
	   							</div>
   							</div>
   							<div class="recommendedTalentMCont">
	   							<div class="ContHeader">
	   								<div class="awardStatistics">提奖统计</div>
	   								<div class="historyCashBack">历史返现</div>
	   								<div class="inviteRecord">邀请记录</div>
	   								<div class="LoanDetails">借款明细</div>
	   								<div class="investDetails">投资明细</div>
	   								<div class="historyPrincipalBack">还本明细</div>
	   								<div class="purchaseDetails">VIP购买明细</div>
	   							</div>
	   							<div class="ContList">
	   								<ul class="LoanDetailsUl">
	   									<li>
	   										<div class="ContListTitle">
			   									<div class="loanName">借款名称</div>
				   								<div class="loanAmount">借款金额</div>
				   								<div class="loanTime">借款期限</div>
				   								<div class="yearProfit">年化利率</div>
				   								<div class="loanVName">会员名</div>
				   								<div class="userName">用户名</div>
				   								<div class="lendingTime">放款时间<em class="iconDown"></em></div>
	   										</div>
	   									</li>
	   									<%for(int i=0;i<8;i++){%>
	   									<li>
	   										<div class="ContListMain">
	   											<div class="loanName outside">
		   											<div class="inside">
		   												<div>借款担保贷</div>
		   											</div>
	   											</div>
		   										<div class="loanAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10000</div>
		   											</div>
		   										</div>
		   										<div class="loanTime outside">
		   											<div class="inside">
		   												<div>2个月</div>
		   											</div>
		   										</div>
		   										<div class="yearProfit outside">
		   											<div class="inside">
		   												<div>9.00%</div>
		   											</div>
		   										</div>
		   										<div class="loanVName outside">
		   											<div class="inside">
		   												<div>刘先生</div>
		   											</div>
		   										</div>
		   										<div class="userName outside">
		   											<div class="inside">
		   												<div>大大大刘</div>
		   											</div>
		   										</div>
		   										<div class="lendingTime outside">
		   											<div class="inside">
		   												<div>2016-02-02<br>12:12:00</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
	   									<%}%>
	   									<li class="page"><div id="pager3"></div></li>
	   								</ul>
	   							</div>
	   						</div>
   						</div>
   						<!-- 借款明细部分结束 -->
   						<!-- 投资明细部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain5">
   							<div class="recommendedTalentMHistory">
	   							<div class="search">
	   								<label>借款名称:</label><input type="text" lang="输入借款名称" maxlength="20">
	   								<div class="choose">
	   									<label>预期收入时间段:</label><input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseName">
	   									<label>会员/用户名:</label><input type="text" lang="请输入会员/用户名" maxlength="20">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" onselectstart="return false">搜索</div>
	   								</div>
	   							</div>
   							</div>
   							<div class="recommendedTalentMCont">
	   							<div class="ContHeader">
	   								<div class="awardStatistics">提奖统计</div>
	   								<div class="historyCashBack">历史返现</div>
	   								<div class="inviteRecord">邀请记录</div>
	   								<div class="LoanDetails">借款明细</div>
	   								<div class="investDetails">投资明细</div>
	   								<div class="historyPrincipalBack">还本明细</div>
	   								<div class="purchaseDetails">VIP购买明细</div>
	   							</div>
	   							<div class="ContList">
	   								<ul class="investDetailsUl">
	   									<li>
	   										<div class="ContListTitle">
			   									<div class="loanName">借款名称</div>
				   								<div class="investAmount">投资金额</div>
				   								<div class="investVName">会员名</div>
				   								<div class="investuserName">用户名</div>
				   								<div class="expectOrigionMoney">预期本金</div>
				   								<div class="expectProfit">预期收益</div>
				   								<div class="expectProfitTime">预期收益时间<em class="iconDown"></em></div>
	   										</div>
	   									</li>
	   									<%for(int i=0;i<8;i++){%>
	   									<li>
	   										<div class="ContListMain">
	   											<div class="loanName outside">
		   											<div class="inside">
		   												<div>借款担保贷</div>
		   											</div>
	   											</div>
		   										<div class="investAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10000</div>
		   											</div>
		   										</div>
		   										<div class="investVName outside">
		   											<div class="inside">
		   												<div>刘先生</div>
		   											</div>
		   										</div>
		   										<div class="investuserName outside">
		   											<div class="inside">
		   												<div>大大大刘</div>
		   											</div>
		   										</div>
		   										<div class="expectOrigionMoney outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10000</div>
		   											</div>
		   										</div>
		   										<div class="expectProfit outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10000</div>
		   											</div>
		   										</div>
		   										<div class="expectProfitTime outside">
		   											<div class="inside">
		   												<div>2016-02-02<br>12:12:00</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
	   									<%}%>
	   									<li class="page"><div id="pager4"></div></li>
	   								</ul>
	   							</div>
	   						</div>
   						</div>
   						<!-- 投资明细部分结束 -->
   						<!-- 还本明细部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain6">
   							<div class="recommendedTalentMHistory">
	   							<div class="search">
	   								<div>
		   								<div class="chooseLoanName">
		   									<label>借款名称:</label><input type="text" lang="输入借款名称" maxlength="20">
		   								</div>
		   								<div class="choose">
		   									<label>还款时间:</label><input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
		   								</div>
	   								</div>
	   								<div>
		   								<div class="monthCount">
		   									<label>是否逾期:</label>
		   									<div class="selectArea">
		   										<input class="selectValue" value="1" >
											    <input class="selectInput" type="text" lang="" readOnly="true"/>
											    <ul class="select" onselectstart="return false">
											        <li class="selectOption" value="1">是<li>
											        <li class="selectOption" value="2">否<li>
											    </ul>
											</div>
		   								</div>
		   								<div class="chooseName">
		   									<label>会员/用户名:</label><input type="text" lang="请输入会员/用户名" maxlength="20">
		   								</div>
		   								<div class="searchBtn">
		   									<div class="btn btnSearch" onselectstart="return false">搜索</div>
		   								</div>
	   								</div>
	   							</div>
   							</div>
   							<div class="recommendedTalentMCont">
	   							<div class="ContHeader">
	   								<div class="awardStatistics">提奖统计</div>
	   								<div class="historyCashBack">历史返现</div>
	   								<div class="inviteRecord">邀请记录</div>
	   								<div class="LoanDetails">借款明细</div>
	   								<div class="investDetails">投资明细</div>
	   								<div class="historyPrincipalBack">还本明细</div>
	   								<div class="purchaseDetails">VIP购买明细</div>
	   							</div>
	   							<div class="ContList">
	   								<ul class="historyPrincipalBackUl">
	   									<li>
	   										<div class="ContListTitle">
			   									<div class="loanName">借款名称</div>
			   									<div class="loanAmount">借款金额</div>
			   									<div class="VIPName">会员名</div>
			   									<div class="userName">用户名</div>
			   									<div class="repaymentPrincipal">本次还款本金</div>
			   									<div class="InterestRepayment">本次还款利息</div>
			   									<div class="repaymentTime">还款时间<em class="iconDown"></em></div>
			   									<div class="expectedRepaymentTime">预期还款时间</div>
			   									<div class="overDue">是否逾期</div>
	   										</div>
	   									</li>
	   									<%for(int i=0;i<8;i++){%>
	   									<li>
	   										<div class="ContListMain">
	   											<div class="loanName outside">
		   											<div class="inside">
		   												<div>借款担保贷</div>
		   											</div>
	   											</div>
		   										<div class="loanAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10000</div>
		   											</div>
		   										</div>
		   										<div class="VIPName outside">
		   											<div class="inside">
		   												<div>刘先生</div>
		   											</div>
		   										</div>
		   										<div class="userName outside">
		   											<div class="inside">
		   												<div>大大大刘</div>
		   											</div>
		   										</div>
		   										<div class="repaymentPrincipal outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10000</div>
		   											</div>
		   										</div>
		   										<div class="InterestRepayment outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10000</div>
		   											</div>
		   										</div>
		   										<div class="repaymentTime outside">
		   											<div class="inside">
		   												<div>2016-02-12<br>12:12:00</div>
		   											</div>
		   										</div>
		   										<div class="expectedRepaymentTime outside">
		   											<div class="inside">
		   												<div>2016-02-12<br>12:12:00</div>
		   											</div>
		   										</div>
		   										<div class="overDue outside">
		   											<div class="inside">
		   												<div>否</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
	   									<%}%>
	   									<li class="page"><div id="pager5"></div></li>
	   								</ul>
	   							</div>
	   						</div>
   						</div>
   						<!-- 还本明细部分结束 -->
   						<!-- VIP购买明细部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain7">
   							<div class="recommendedTalentMHistory">
	   							<div class="search">
	   								<div class="choose">
	   									<label>支付时间:</label><input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseName">
	   									<label>会员/用户名:</label><input type="text" lang="请输入会员/用户名" maxlength="20">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" onselectstart="return false">搜索</div>
	   								</div>
	   							</div>
   							</div>
   							<div class="recommendedTalentMCont">
	   							<div class="ContHeader">
	   								<div class="awardStatistics">提奖统计</div>
	   								<div class="historyCashBack">历史返现</div>
	   								<div class="inviteRecord">邀请记录</div>
	   								<div class="LoanDetails">借款明细</div>
	   								<div class="investDetails">投资明细</div>
	   								<div class="historyPrincipalBack">还本明细</div>
	   								<div class="purchaseDetails">VIP购买明细</div>
	   							</div>
	   							<div class="ContList">
	   								<ul class="purchaseDetailsUl">
	   									<li>
	   										<div class="ContListTitle">
	   											<div class="VIPName">会员名</div>
			   									<div class="userName">用户名</div>
			   									<div class="purchaseEffectiveTime">购买有效时间段</div>
			   									<div class="purchaseAmount">购买金额</div>
			   									<div class="paymentTime">支付时间<em></em></div>
	   										</div>
	   									</li>
	   									<%for(int i=0;i<8;i++){%>
	   									<li>
	   										<div class="ContListMain">
	   											<div class="VIPName outside">
		   											<div class="inside">
		   												<div>刘先生</div>
		   											</div>
		   										</div>
	   											<div class="userName outside">
		   											<div class="inside">
		   												<div>大大大刘</div>
		   											</div>
	   											</div>
		   										<div class="purchaseEffectiveTime outside">
		   											<div class="inside">
		   												<div>2016-04-07</div>
		   												<div>--</div>
		   												<div>2016-04-12</div>
		   											</div>
		   										</div>
		   										<div class="purchaseAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10000</div>
		   											</div>
		   										</div>
		   										<div class="paymentTime outside">
		   											<div class="inside">
		   												<div class="moneyFormat">10256142</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
	   									<%}%>
	   									<li class="page"><div id="pager6"></div></li>
	   								</ul>
	   							</div>
	   						</div>
   						</div>
   						<!-- VIP购买明细部分结束 -->
   					</div>
   					<!-- 主体部分结束 王延君 2016-04-05 -->
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
   	<!--弹出层2016-4-6伍成然  -->
   	<div class="applyTalent">
   		<div class="apply-top">
   			你的申请已经发送成功!我们将很快进行审核
   		</div>
   		<div class="apply-bottom">
   			<input type="button" class="btn" value="确定" onclick="layer.closeAll()">
   		</div>
   	</div>
   	<script type="text/javascript" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/recommendedTalent.js"></script>
	<script type="text/javascript" src="plugs/My97DatePicker/WdatePicker.js"></script>
</body>
</html>