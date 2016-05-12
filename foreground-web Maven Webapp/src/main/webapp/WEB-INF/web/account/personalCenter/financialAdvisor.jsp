<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title>理财顾问</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/financialAdvisor.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css"></link>
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<script type="text/javascript" src="js/common/template.js"></script>
   	<script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
   					<!-- 主体部分开始 王延君 2016-04-05 -->
   					<div class="recommendedTalent" onselectstart="return false;">
   						<!-- 公共部分开始 -->
   						<div class="recommendedTalentH">
   							<div>理财顾问</div>
   						</div>
   						<div class="recommendedTalentInfo">
   							<div class="TalentInfoL">
   								<div>推荐成功借款总金额：<span class="moneyFormat">${advisorGenneral.loanTotalAmounts}</span>元</div>
   							</div>
   							<div class="TalentInfoR">
   								<div>推荐成功投资总金额：<span class="moneyFormat">${advisorGenneral.investTotalAmountValids}</span>元</div>
   							</div>
   							<div class="TalentInfoL">
   								<div>推荐成功还本总金额：<span class="moneyFormat">${advisorGenneral.replayPrincipals}</span>元</div>
   							</div>
   							<div class="TalentInfoR">
   								<div>推荐购买VIP总金额：<span class="moneyFormat">${advisorGenneral.totalPayVIPs}</span>元</div>
   							</div>
   							<div class="TalentInfoL">
   								<div>推荐提奖总金额：<span class="moneyFormat">${advisorGenneral.awardTotals}</span>元</div>
   							</div>
   						</div>
   						<!-- 公共部分结束 -->
   						<!-- 提奖统计部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain1">
   							<div class="recommendedTalentMAward">
	   							<div class="search">
	   								<div class="choose">
	   									<label>时间范围:</label><input class="Wdate" id="startDate" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" id="endDate" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseTime">
	   									<span data-time="1">今天</span>
	   									<span data-time="2">最近一周</span>
	   									<span data-time="3">一个月</span>
	   									<span data-time="4">六个月</span>
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" id = "searchAward" onselectstart="return false">搜索</div>
	   								</div>
	   								<div class="btn btnExport" id="financialAwardexcel" onselectstart="return false"><label></label>导出</div>
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
	   								<ul class="awardStatisticsUl" id="awardStatisticsUl">
	   									<li id="financialAwardTop">
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
	   									<%-- <%for(int i=0;i<8;i++){%>
	   									<li>
	   										<div class="ContListMain">
	   											<div class="userName outside">
		   											<div class="inside">
		   												<div>理财师1</div>
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
		   												<div><span class="moneyFormat">1000</span>/<span class="moneyFormat">1100</span></div>
		   											</div>
		   										</div>
		   										<div class="totalAwardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">47</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
	   									<%}%> --%>
	   								</ul>
	   								<!-- 理财顾问提奖统计 -->
   									<script id="financialAwardList" type="text/html">
   										{{each results as infos index}}
   										<li>
	   										<div class="ContListMain">
	   											<div class="userName outside">
		   											<div class="inside">
		   												<div>{{infos.logname}}</div>
		   											</div>
	   											</div>
		   										<div class="trueName outside">
		   											<div class="inside">
		   												<div>{{infos.memberName}}</div>
		   											</div>
		   										</div>
		   										<div class="loanAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.loanTotalAmounts}}</div>
		   											</div>
		   										</div>
		   										<div class="awardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.loanAwards}}</div>
		   											</div>
		   										</div>
		   										<div class="effectiveInvestmentAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.investTotalAmountValids}}</div>
		   											</div>
		   										</div>
		   										<div class="investmentAwardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.investAwards}}</div>
		   											</div>
		   										</div>
		   										<div class="purchaseTimes outside">
		   											<div class="inside">
		   												<div>{{infos.countPayVIP}}/<span class="moneyFormat">{{$toFixed infos.vipAwards}}</span></div>
		   											</div>
		   										</div>
		   										<div class="successfulDebt outside">
		   											<div class="inside">
		   												<div>
		   													<span class="moneyFormat">{{$toFixed infos.replayPrincipals}}</span>/<span class="moneyFormat">{{$toFixed infos.repayAwards}}</span>
		   												</div>
		   											</div>
		   										</div>
		   										<div class="totalAwardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.awardTotals}}</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
   										{{/each}}
										<li class="page"><div id="pager" class="pager-box"></div></li>
									</script>
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
	   										<input class="selectValue" type="hidden" id="monthAward" value="-1" >
										    <input class="selectInput" type="text" lang="" readOnly="true"/>
										    <ul class="select" onselectstart="return false">
										        <li class="selectOption" value="01">1月<li>
										        <li class="selectOption" value="02">2月<li>
										        <li class="selectOption" value="03">3月<li>
										        <li class="selectOption" value="04">4月<li>
										        <li class="selectOption" value="05">5月<li>
										        <li class="selectOption" value="06">6月<li>
										        <li class="selectOption" value="07">7月<li>
										        <li class="selectOption" value="08">8月<li>
										        <li class="selectOption" value="09">9月<li>
										        <li class="selectOption"value="10">10月<li>
										        <li class="selectOption" value="11">11月<li>
										        <li class="selectOption" value="12">12月<li>
										    </ul>
										</div>
	   								</div>
	   								<div class="choose">
	   									<label>时间范围:</label><input class="Wdate" id="startTimehis" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" id="endTimehis" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" id="searchAwardhis" onselectstart="return false">搜索</div>
	   								</div>
	   								<div class="btn btnExport" id="financialAwardHisExcel" onselectstart="return false"><label></label>导出</div>
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
	   								<ul id="historyCashBackUl" class="historyCashBackUl">
	   									<li id="historyCashTop">
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
	   									<%-- <%for(int i=0;i<8;i++){%>
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
	   									<%}%> --%>
	   								</ul>
	   								<script id="historyCashList" type="text/html">
										{{each results as infos index}}
										<li>
											<div class="ContListMain">
	   											<div class="statisticalTimePeriod outside">
		   											<div class="inside">
		   												<div>{{$timeFixed infos.startDate}}<br>{{$timeFixed infos.endDate}}</div>
		   											</div>
	   											</div>
		   										<div class="totalLoanAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.borrowAmounts}}</div>
		   											</div>
		   										</div>
		   										<div class="awardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.borrowAwards}}</div>
		   											</div>
		   										</div>
		   										<div class="totalInvestmentAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.investAmounts}}</div>
		   											</div>
		   										</div>
		   										<div class="investmentAwardAmount outside">
		   											<div class="inside">
		   												<div><span class="moneyFormat">{{$toFixed infos.investAwards}}</span></div>
		   											</div>
		   										</div>
		   										<div class="totalPrincipalAmount outside">
		   											<div class="inside">
		   												<div>{{$toFixed infos.repayAmounts}}/<span class="moneyFormat">{{$toFixed infos.repayAwards}}</span></div>
		   											</div>
		   										</div>
		   										<div class="totalAwardAmount outside">
		   											<div class="inside">
		   												<div>{{$toFixed infos.vipAmounts}}/<span class="moneyFormat">{{$toFixed infos.vipAwards}}</span></div>
		   											</div>
		   										</div>
		   										<div class="totalPrincipalAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.awardAmounts}}</div>
		   											</div>
		   										</div>
		   										<div class="actualAwardAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.realAmounts}}</div>
		   											</div>
		   										</div>
		   										<div class="mentionAwardTime outside">
		   											<div class="inside">
		   												<div>{{infos.payDate}}</div>
		   											</div>
		   										</div>
		   										<div class="releaseStatus outside">
		   											<div class="inside"> 
		   												    {{if infos.payStatu=="-1"}}
		   									                  <div>发放失败 </div>
															{{/if}}
															{{if infos.payStatu=="0"}}
		   														<div>未发放</div>
															{{/if}}
															{{if infos.payStatu=="1"}}
		   														<div>发放中</div>
															{{/if}}
															{{if infos.payStatu=="2"}}
		   														<div>发放成功</div>
															{{/if}}
		   											 </div>
		   										</div>
	   										</div>
	   									</li>
										{{/each}}
	   									<li class="page"><div id="pager1" class="pager-box"></div></li>
									</script>
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
	   										<input class="selectValue" type="hidden" id="isopenThird" value="-1" >
										    <input class="selectInput" type="text" lang="" readOnly="true"/>
										    <ul class="select" onselectstart="return false">
										        <li class="selectOption" value="1">已开户<li>
										        <li class="selectOption" value="2">未开户<li>
										    </ul>
										</div>
	   								</div>
	   								<div class="choose">
	   									<label>时间范围:</label><input class="Wdate" id="startTimeInvit" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" id="endDateInvit" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseName">
	   									<label>会员/用户名:</label><input type="text" id="memberName" lang="请输入会员/用户名" maxlength="20">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" id="searchInvit" onselectstart="return false">搜索</div>
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
	   								<ul id="inviteRecordUl" class="inviteRecordUl">
	   									<li id="financialInvitationTop">
	   										<div class="ContListTitle">
			   									<div class="VIPName">会员名</div>
				   								<div class="userName">用户名</div>
				   								<div class="registerRecord">注册时间<em class="iconDown"></em></div>
				   								<div class="accountStatus">开户状态</div>
	   										</div>
	   									</li>
	   									<%-- <%for(int i=0;i<8;i++){%>
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
	   									<%}%> --%>
	   								</ul>
	   								<script id="financialInvitationList" type="text/html">
										{{each results as infos index}}
										<li>
	   										<div class="ContListMain">
	   											<div class="VIPName outside">
		   											<div class="inside">
		   												<div>{{infos.logname}}</div>
		   											</div>
	   											</div>
		   										<div class="userName outside">
		   											<div class="inside">
		   												<div>{{infos.memberName}}</div>
		   											</div>
		   										</div>
		   										<div class="registerRecord outside">
		   											<div class="inside">
		   												<div>{{infos.regDate}}</div>
		   											</div>
		   										</div>
		   										<div class="accountStatus outside">
		   											<div class="inside">
		   												   {{if infos.isopenThird=="0"}}
		   									                  <div>未开户</div>
															{{/if}}
															{{if infos.isopenThird=="1"}}
		   													   <div>已开户</div>
															{{/if}}
		   											</div>
		   										</div>
	   										</div>
	   									</li>
										{{/each}}
	   									<li class="page"><div id="pager2" class="pager-box"></div></li>
									</script>
	   							</div>
	   						</div>
   						</div>
   						<!-- 邀请记录部分结束-->
   						<!-- 借款明细部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain4">
   							<div class="recommendedTalentMHistory">
	   							<div class="search">
	   								<label>借款名称:</label><input type="text" id="projectTitleBrow" lang="输入借款名称" maxlength="20">
	   								<div class="choose">
	   									<label>放款时间段:</label><input class="Wdate" id="startTimeBorrow" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" id="endTimeBorrow" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseName">
	   									<label>会员/用户名:</label><input type="text" id="memberNameBrow" lang="请输入会员/用户名" maxlength="20">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" id="SearchBorrow" onselectstart="return false">搜索</div>
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
	   								<ul id="LoanDetailsUl" class="LoanDetailsUl">
	   									<li id="financialBorrowingTop">
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
	   									<%-- <%for(int i=0;i<8;i++){%>
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
	   									<%}%> --%>
	   								</ul>
	   								<script id="financialBorrowingList" type="text/html">
										{{each results as infos index}}
					                   	<li>
	   										<div class="ContListMain">
	   											<div class="loanName outside">
		   											<div class="inside">
		   												<div>{{infos.projectTitle}}</div>
		   											</div>
	   											</div>
		   										<div class="loanAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.amounts}}</div>
		   											</div>
		   										</div>
		   										<div class="loanTime outside">
		   											<div class="inside"> 
		   													<div>{{infos.deadline}}{{infos.name1}}</div>   
		   											</div>
		   										</div>
		   										<div class="yearProfit outside">
		   											<div class="inside">
		   												<div>{{infos.yearRates}}%</div>
		   											</div>
		   										</div>
		   										<div class="loanVName outside">
		   											<div class="inside">
		   												<div>{{infos.logname}}</div>
		   											</div>
		   										</div>
		   										<div class="userName outside">
		   											<div class="inside">
		   												<div>{{infos.personalName}}</div>
		   											</div>
		   										</div>
		   										<div class="lendingTime outside">
		   											<div class="inside">
		   												<div>{{infos.holdDate}}</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
										{{/each}}
										<li class="page"><div id="pager3" class="pager-box"></div></li>
   									</script>
	   							</div>
	   						</div>
   						</div>
   						<!-- 借款明细部分结束 -->
   						<!-- 投资明细部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain5">
   							<div class="recommendedTalentMHistory">
	   							<div class="search">
	   								<label>借款名称:</label><input class="loanNameInput" id="projectTitleInvest" type="text" lang="输入借款名称" maxlength="20">
	   								<div class="choose">
	   									<label>预期收入时间段:</label><input class="Wdate" id="startTimeInvest" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" id="endTimeInvest" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseName">
	   									<label>会员/用户名:</label><input type="text" id="memberNameInvest" lang="请输入会员/用户名" maxlength="20">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" id="SearchInvest" onselectstart="return false">搜索</div>
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
	   								<ul id="investDetailsUl" class="investDetailsUl">
	   									<li id="financialInvestTop">
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
	   									<%-- <%for(int i=0;i<8;i++){%>
	   									<li>
	   										<div class="ContListMain">
	   											<div class="loanName outside">
		   											<div class="inside">
		   												<div>借款担保贷</div>
		   											</div>
	   											</div>
		   										<div class="investAmount outside">
		   											<div class="inside">
		   												<div>10,000.00</div>
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
	   									<%}%> --%>
	   								</ul>
	   								<script id="financialInvestList" type="text/html">
										{{each results as infos index}}
					                   	<li>
	   										<div class="ContListMain">
	   											<div class="loanName outside">
		   											<div class="inside">
		   												<div>{{infos.projectTitle}}</div>
		   											</div>
	   											</div>
		   										<div class="investAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.investAmountValids}}</div>
		   											</div>
		   										</div>
		   										<div class="investVName outside">
		   											<div class="inside">
		   												<div>{{infos.logname}}</div>
		   											</div>
		   										</div>
		   										<div class="investuserName outside">
		   											<div class="inside">
		   												<div>{{infos.personalName}}</div>
		   											</div>
		   										</div>
		   										<div class="expectOrigionMoney outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.sdRecvPrincipals}}</div>
		   											</div>
		   										</div>
		   										<div class="expectProfit outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.sdRecvInterests}}</div>
		   											</div>
		   										</div>
		   										<div class="expectProfitTime outside">
		   											<div class="inside">
		   												<div>{{infos.nextReplayDay}}</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
										{{/each}}
										<li class="page"><div id="pager4" class="pager-box"></div></li>
   									</script>
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
		   									<label>借款名称:</label><input type="text" id="projectTitleReplay" lang="输入借款名称" maxlength="20" maxlength="20">
		   								</div>
		   								<div class="choose">
		   									<label>还款时间:</label><input class="Wdate" id="startTimeReplay" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" id="endTimeReplay" onfocus="WdatePicker()" type="text" lang="请选择">
		   								</div>
	   								</div>
	   								<div>
		   								<div class="monthCount">
		   									<label>是否逾期:</label>
		   									<div class="selectArea">
		   										<input class="selectValue" id="isover" value="-1" >
											    <input class="selectInput" type="text" lang="" readOnly="true"/>
											    <ul class="select" onselectstart="return false">
											        <li class="selectOption" value="1">是<li>
											        <li class="selectOption" value="2">否<li>
											    </ul>
											</div>
		   								</div>
		   								<div class="chooseName">
		   									<label>会员/用户名:</label><input type="text" id="memberNameReplay" lang="请输入会员/用户名" maxlength="20">
		   								</div>
		   								<div class="searchBtn">
		   									<div class="btn btnSearch" id="SearchReplay" onselectstart="return false">搜索</div>
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
	   								<ul id="historyPrincipalBackUl" class="historyPrincipalBackUl">
	   									<li id="repaymentfinancialTop">
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
	   									<%-- <%for(int i=0;i<8;i++){%>
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
	   									<%}%> --%>
	   								</ul>
	   								<script id="repaymentfinancialList" type="text/html">
	   									{{each results as infos index}}
					                   	<li>
	   										<div class="ContListMain">
	   											<div class="loanName outside">
		   											<div class="inside">
		   												<div>{{infos.projectTitle}}</div>
		   											</div>
	   											</div>
		   										<div class="loanAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.amounts}}</div>
		   											</div>
		   										</div>
		   										<div class="VIPName outside">
		   											<div class="inside">
		   												<div>{{infos.logname}}</div>
		   											</div>
		   										</div>
		   										<div class="userName outside">
		   											<div class="inside">
		   												<div>{{infos.personalName}}</div>
		   											</div>
		   										</div>
		   										<div class="repaymentPrincipal outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.repayPrincipals}}</div>
		   											</div>
		   										</div>
		   										<div class="InterestRepayment outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.repayInterests}}</div>
		   											</div>
		   										</div>
		   										<div class="repaymentTime outside">
		   											<div class="inside">
		   												<div>{{infos.repayTime}}</div>
		   											</div>
		   										</div>
		   										<div class="expectedRepaymentTime outside">
		   											<div class="inside">
		   												<div>{{infos.repayMaxTime}}</div>
		   											</div>
		   										</div>
		   										<div class="overDue outside">
		   											<div class="inside">
		   									     	{{if infos.isoverque=="1"}}
		   												<div>是</div>
													{{/if}}
													{{if infos.isoverque=="0"}}
		   												<div>否</div>
													{{/if}}
		   											</div>
		   										</div>
	   										</div>
	   									</li>
										{{/each}}
										<li class="page"><div id="pager5" class="pager-box"></div></li>
	   								</script>
	   							</div>
	   						</div>
   						</div>
   						<!-- 还本明细部分结束 -->
   						<!-- VIP购买明细部分开始 -->
   						<div class="recommendedTalentMain recommendedTalentMain7">
   							<div class="recommendedTalentMHistory">
	   							<div class="search">
	   								<div class="choose">
	   									<label>支付时间:</label><input class="Wdate" id="startTimeVIP" onfocus="WdatePicker()" type="text" lang="请选择">-<input class="Wdate" id="startTimeVIP" onfocus="WdatePicker()" type="text" lang="请选择">
	   								</div>
	   								<div class="chooseName">
	   									<label>会员/用户名:</label><input type="text" id="memberNameVIP" lang="请输入会员/用户名" maxlength="20">
	   								</div>
	   								<div class="searchBtn">
	   									<div class="btn btnSearch" id="SearchVIPpay" onselectstart="return false">搜索</div>
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
	   								<ul id="purchaseDetailsUl" class="purchaseDetailsUl">
	   									<li id="financialVipPayTop">
	   										<div class="ContListTitle">
	   											<div class="VIPName">会员名</div>
			   									<div class="userName">用户名</div>
			   									<div class="purchaseEffectiveTime">购买有效时间段</div>
			   									<div class="purchaseAmount">购买金额</div>
			   									<div class="paymentTime">支付时间<em></em></div>
	   										</div>
	   									</li>
	   									<%-- <%for(int i=0;i<8;i++){%>
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
	   									<%}%> --%>
	   								</ul>
	   								
	   								<script id="financialVipPayList" type="text/html">
	   									{{each results as infos index}}
					                   	<li>
	   										<div class="ContListMain">
	   											<div class="VIPName outside">
		   											<div class="inside">
		   												<div>{{infos.logname}}</div>
		   											</div>
		   										</div>
	   											<div class="userName outside">
		   											<div class="inside">
		   												<div>{{infos.personalName}}</div>
		   											</div>
	   											</div>
		   										<div class="purchaseEffectiveTime outside">
		   											<div class="inside">
		   												<div>{{$timeFixed infos.certifySDate}}</div>
		   												<div>--</div>
		   												<div>{{$timeFixed infos.certifyEDate}}</div>
		   											</div>
		   										</div>
		   										<div class="purchaseAmount outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{$toFixed infos.amounts}}</div>
		   											</div>
		   										</div>
		   										<div class="paymentTime outside">
		   											<div class="inside">
		   												<div class="moneyFormat">{{infos.recordDate}}</div>
		   											</div>
		   										</div>
	   										</div>
	   									</li>
										{{/each}}
										<li class="page"><div id="pager6"></div></li>
	   								</script>
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
   	  <form action="financialAdvisorAward/financialAwardRecordexcel.html" method="post" id="financialAwardexcel" name="financialAwardexcel" style="display: none">
		<input  name="startTime" id="startTimeatz" type="hidden">
		<input  name="endTime" id="endTimeatz" type="hidden" >
		<input value="" name="dateStart" id="dateStartatz" type="hidden" > 
	</form>
    <form action="financialHistoryBack/financialHistoryBackExcel.html" method="post" id="financialHistory" name="financialHistory" style="display: none">
		<input  value="" name="startTime" id="startTimeatzh" type="hidden">
		<input  value="" name="endTime" id="endTimeatzh" type="hidden">
		<input value="" name="month" id="monthtzh" type="hidden"> 
	</form>
   	<script type="text/javascript" src="plugs/pager/pager.js"></script>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/financialAdvisor.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
</body>
</html>