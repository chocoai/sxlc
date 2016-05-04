<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>投资详情</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/invest/investmentDetail.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<script type="text/javascript" src="js/common/template.js"></script>
    <!-- 此处加入代码 -->
    <!--伍成然2016-3-28  -->
    <div class="main">
    	<div class="link-area">
			<div class="link-parents">
				您当前的位置&gt;
				<a href="index.html">首页</a>&gt;
				<a href="invest/investmentZone.html" class="dq">投资专区</a>&gt;
			</div>
			<div class="page-link">
				<a class="current-page on">项目详情</a>
				<a class="current-page">风控措施</a>
				<a class="current-page">还款计划</a>
				<a class="current-page">投资列表</a>
				<a class="current-page">项目历程</a>
				<a class="current-page">贷后监管</a>
			</div>
		</div>
		<!--inv-box  -->
		<div class="inv-box clearfix">
			<div class="inv-top-box">
				<div class="inv-head clearfix">
					<img src="${appRecordEntity.picIcon}">
					<label>${appRecordEntity.projectBaseInfoentity.projectTitle }</label>
					<span>【${appRecordEntity.projectNo }】</span>
				</div>
				<div class="inv-info clearfix">
					<div class="inv-rate">
						<p>年化利率</p>
						<h1>${appRecordEntity.projectBaseInfoentity.yearRates }<span>%</span><span class="increase">+${appRecordEntity.rateAddRate }%</span></h1>					
					</div>
					<div class="inv-item-amount">
						<p>项目金额</P>
						<h1 class="moneyFormat">${appRecordEntity.projectBaseInfoentity.amounts }</h1><span>元</span>
						<span class="reward">					
						   	投资本金
							<b>${appRecordEntity.rewardRates }%</b>
						</span>
					</div>
					<div class="inv-time">
						<p>项目期限</p>					
						<h1>${appRecordEntity.projectBaseInfoentity.deadline }<span><c:if test="${appRecordEntity.projectBaseInfoentity.deadlineType == 0}">天</c:if><c:if test="${appRecordEntity.projectBaseInfoentity.deadlineType == 1}">个月</c:if><c:if test="${appRecordEntity.projectBaseInfoentity.deadlineType == 2}">年</c:if></span></h1>
					</div>
					<div class="inv-available-amount">
						<p>可投金额</p>					
						<h1 class="moneyFormat">${appRecordEntity.availableaAmounts}</h1><span>元</span>
					</div>
				</div>
				<div class="inv-info-bottom">
					<!--进度条  -->
					<div class="progress">
						<div class="pro-title">投资进度：</div>
						<div class="barbox"> 
							<div class="barline"></div> 
						</div>
						<span class="progress_totle">${appRecordEntity.investRate }%</span>
					</div>
					<div class="info-label">
						<div class="left-title">剩余时间：</div>
						<div class="time-ico">1天8小时17分41秒</div>
					</div>
					<div class="info-label">
						<div class="left-title">还款方式：</div>
						<label>
						<%-- <c:if test="${appRecordEntity.projectBaseInfoentity.repayWay == 0}">等额本息</c:if>
						<c:if test="${appRecordEntity.projectBaseInfoentity.repayWay == 1}">每月还息</c:if>
						<c:if test="${appRecordEntity.projectBaseInfoentity.repayWay == 2}">等额本息</c:if>
						<c:if test="${appRecordEntity.projectBaseInfoentity.repayWay == 3}">到期还息本</c:if> --%>
						${appRecordEntity.projectBaseInfoentity.replayWays}
						</label>	
					</div>
					<div class="info-label">
						<div class="left-title">信用等级：</div>
						<label>${appRecordEntity.levelMark }</label>
					</div>	
					<div class="info-label">
						<div class="left-title">查看协议：</div>
						<a href="#">协议</a>
					</div>																
				</div>
			</div><!--top-box结束  -->
			<c:if test="${appRecordEntity.investStatu == 3}">
				<!--inv-deal-box还款中状态  -->
				<div class="inv-deal-box repaying">
					<div class="count-down-title">
						成功交易时间:
					</div>
					<div class="count-down">
						2016-03-09&nbsp;16:00:58
					</div>
					<img src="resource/img/invest/wytzhkz.png"><!-- 已结清wytzyjq.png -->				
				</div>
				<!--inv-deal-box还款中状态结束  -->
			</c:if>
			<c:if test="${appRecordEntity.investStatu != 3}">
				<c:if test="${loginUser == null }">
					<!--inv-deal-box未登录状态  -->
					<form id="notLoginBox">
						<div class="inv-deal-box not-logined">
							<div class="login-remind">
								<a href="login.html">登录</a>&nbsp;&nbsp;后可查看可用余额
							</div>
							<div class="input-group">
							    <input type="text" class="charge-input" datatype="acountM" maxlength="10" value="50元起投且金额为整数" 
								onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
								onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
								style="color:#bfbfbf">
							    <div class="charge-addon1">元</div>
							 </div>
							 <input type="button" class="login-now" value="立即登录">
						</div>
					</form>
					<!--inv-deal-box未登录状态结束  -->
				</c:if>
				<c:if test="${loginUser != null }">
					<!--inv-deal-box已登录状态  -->
					<form id="loginedBox">
					<div class="inv-deal-box logined">
						<div class="inv-available">本次可投金额<div class="right"><span>${sSumAount }</span>元</div></div>
						<div class="amount-available">可用余额<div class="right"><span>${authInfoEntity.memberThirdInfoEntity.userBalances }</span>元</div></div>
						<div class="input-group" style="height:50px;">
						    <input type="text" class="charge-input" datatype="acountM" maxlength="10" value="50元起投且金额为整数" 
							onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
							onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
							style="color:#bfbfbf">
						    <div class="charge-addon">元</div>
						    <input class="charge-btn" type="button" value="充值">
						</div><!-- /input-group -->
						<div class="expected-return">预期收益：<span>0.00</span>元</div>
						<input type="button" class="inv-now" value="立即投资">
						<div class="remain-vouchers">剩余代金券&nbsp;${sVouchers }元<div class="right">剩余红包&nbsp;${redPackCount }个</div></div>
					</div>
					</form>
					<!--deal-box已登录状态结束  -->
				</c:if>
			</c:if>
			<!--inv-bottom-box部分  -->
			<div class="inv-bottom-box">
				<ul class="tab-head">
					<li class="tab-li tab-ing">项目详情</li>
					<li class="tab-li">风控措施</li>
					<li class="tab-li">还款计划</li>
					<li class="tab-li">投资列表</li>
					<li class="tab-li">项目历程</li>
					<li class="tab-li after-inv-li">贷后监管</li><!--投资后显现  -->
				</ul>
				<div class="tab-content clearfix">
					<div class="c-content content-active">
						<jsp:include page="projectDetail.jsp"></jsp:include>
					</div>
					<div class="c-content" id="getRiskControl">
						<jsp:include page="riskControl.jsp"></jsp:include>
					</div>
					<div class="c-content contentList" id="getRepaymentPlan">
						<jsp:include page="repaymentPlan.jsp"></jsp:include>
					</div>
					<div class="c-content contentList" id="getInvestmentList">
						<jsp:include page="investmentList.jsp"></jsp:include>
					</div>
					<div class="c-content" id="getProjectCourse">
						<jsp:include page="projectCourse.jsp"></jsp:include>
					</div>
					<div class="c-content after-inv" id="getpostLoanSupervision"><!--投资后显现  -->
						<jsp:include page="postLoanSupervision.jsp"></jsp:include>
					</div>
				</div>		
			</div>
		</div>	
    </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<!--弹出层  -->
	<div class="red-packets">
		<div class="red-packets-top">
			<div class="info">
				<div class="leftTitle">本次可投金额:</div>
				<label><span>${sSumAount }</span>元</label>
			</div>
			<div class="info">
				<div class="leftTitle">本次投资总金额:</div>
				<label><span class="orange"></span>元</label>
				<label>(预期收益：<span class="orange">100.00</span>元)</label>
			</div>
			<div class="info">
				<div class="leftTitle" style="display:block">使用代金券:</div><!--代金券为0时display:none  -->
				<input type="text" class="inputDJJ format" maxlength="6">
				<span class="djj">元&nbsp;&nbsp;剩余代金券：${sVouchers }元</span>
			</div>
			<div class="info" style="display:none"><!--代金券为0时display:block  -->
				<div class="leftTitle">剩余代金券:</div>
				<label>0.00元</label>
			</div>
			<div class="info select">
				<div class="leftTitle">剩余红包:</div>
				<c:forEach items="${redPackList }" var="redPack">
					<label class="active input1"><input type="radio" name="tag" value="${redPack.lId }">${redPack.sUnUsedAmount }元</label>
				</c:forEach>
			</div>
		</div>
		<div class="red-packets-bottom clearfix">
			<div class="label">本次投资总金额：1,000.00元</div>
			<div class="label">使用代金券：100.00元</div>
			<div class="label">使用红包：200.00元</div>
			<div class="label">使用账户余额：8880.00元</div>
		</div>
		<div class="btn-group">
			<input type="button" class="confirm" value="确定" onclick="layer.closeAll()">
			<input type="button" class="cancel" value="取消" onclick="layer.closeAll()">
		</div>	
	</div>	
	<script type="text/javascript" src="js/invest/investmentDetail.js"></script>
</body>
</html>