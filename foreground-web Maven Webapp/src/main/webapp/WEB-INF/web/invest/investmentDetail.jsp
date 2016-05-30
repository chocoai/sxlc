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
   	<script type="text/javascript">
    	var publickey 		= '<%=session.getAttribute("publicKey")%>';
    	var minStarts 		= '${appRecordEntity.minStarts}';//起投金额

    	var increaseRanges 	= '${appRecordEntity.increaseRanges}';//加价幅度

  		var imgProfix = '${imgProfix}';
    </script>
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
					<img src="${imgProfix}${appRecordEntity.picIcon}"  style="width:20px;height:20px">
					<label>${appRecordEntity.projectBaseInfoentity.projectTitle }</label>
					<span>【${appRecordEntity.projectNo }】</span>
				</div>
				<div class="inv-info clearfix">
					<div class="inv-rate">
						<p>年化利率</p>
						<h1>${appRecordEntity.projectBaseInfoentity.yearRates }<span>%</span>
							<c:if test="${appRecordEntity.rateAddRate != 0}">
							<span class="increase">+${appRecordEntity.rateAddRate }%</span>
							</c:if>
						</h1>					
					</div>
					<div class="inv-item-amount">
						<p>项目金额 </P>
						<h1 class="moneyFormat">${appRecordEntity.projectBaseInfoentity.amounts }</h1><span>元</span>
						<c:if test = "${appRecordEntity.rewardRates != 0.0000}">
						<span class="reward">					
						   	投资本金
							<b>${appRecordEntity.rewardRates }%</b>
						</span>
						</c:if>
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
						<span class="progress_totle">${appRecordEntity.investRates }%</span>
					</div>
					<c:if test="${investmentStatus == 1}">   <%-- 预热中 --%>
					<div class="info-label">
						<div class="left-title">剩余时间：</div>
						<div class="J_CountDown time-ico" data-config="{
											'startTime':'${sysTime }',
    										'endTime':'${endTime }'
										}"></div>
					</div>
					</c:if>
					<c:if test="${investmentStatus == 2}">	<%-- 投标中 --%>
					<div class="info-label">
						<div class="left-title">剩余时间：</div>
						<div class="J_CountDown time-ico" data-config="{
											'startTime':'${sysTime }',
    										'endTime':'${endTime }'
										}"></div>
					</div>
					</c:if>
					<div class="info-label">
						<div class="left-title">还款方式：</div>
						<label>
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
 			<!-- 还款中 -->
			<c:if test="${investmentStatus == 3}">
				<div class="inv-deal-box repaying">
					<div class="count-down-title">成功交易时间:</div>
					<div class="count-down">${endTime }</div>
					<img src="resource/img/invest/wytzhkz.png">	
				</div>
			</c:if>
			
			<!-- 投标完成 -->
			<c:if test="${investmentStatus == 5}">
				<div class="inv-deal-box repaying">
					<div class="count-down-title">成功交易时间:</div>
					<div class="count-down">${endTime }</div>
					<img src="resource/img/invest/tbwc.png">		
				</div>
			</c:if>
		
			<!-- 预热中 -->
			<c:if test="${investmentStatus == 1}">
				<div class="inv-deal-box repaying">
					<div class="count-down-title">投标开始时间:</div>
					<div class="count-down">${endTime }</div>
					<img src="resource/img/invest/yrz.png">		
				</div>
			</c:if>
			
			<!-- 已流标-->
			<c:if test="${investmentStatus == 6}">
				<div class="inv-deal-box repaying">
					<div class="count-down-title">成功交易时间:</div>
					<div class="count-down">${endTime }</div>
					<img src="resource/img/invest/ylb.png">				
				</div>
			</c:if>
			
			<!-- 已结清 -->
			<c:if test="${investmentStatus == 4}">
				<div class="inv-deal-box repaying">
					<div class="count-down-title">成功交易时间:</div>
					<div class="count-down">${endTime }</div>
					<img src="resource/img/invest/wytzyjq.png">		
				</div>
			</c:if> 
			<!-- 投标中 -->
			<c:if test="${investmentStatus == 2}"> 
				<!-- 未登录 -->
				<c:if test="${loginUser == null }">
					<form id="notLoginBox">
						<div class="inv-deal-box not-logined">
							<div class="login-remind"><a href="login.html">登录</a>&nbsp;&nbsp;后可查看可用余额</div>
							<div class="input-group">
							    <input type="text" class="charge-input" datatype="acountM" maxlength="10"
								style="color:#bfbfbf">
							    <div class="charge-addon1">元</div>
							    <!-- onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
								onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}"  -->
							 </div>
							 <input type="button" class="login-now" onclick="window.location='<%=path%>/login.html'" value="立即登录">
						</div>
					</form>
				</c:if>
				
				<!-- 已登录 -->
				<c:if test="${loginUser != null }"> 
					<form id="loginedBox">
					<div class="inv-deal-box logined">
						<div class="inv-available">本次可投金额<div class="right"><span>${sSumAount }</span>元</div></div>
						<div class="amount-available">可用余额<div class="right"><span>${userBalances }</span>元</div></div>
						<div class="input-group" style="height:50px;">
						    <input type="text" class="charge-input" datatype="acountM" maxlength="10" 
						   	id="investMoney"
							style="color:#bfbfbf">
						    <div class="charge-addon">元</div>
						    <input class="charge-btn" type="button"  onclick="window.location='<%=path%>/fundManagement/recharge.html'" value="充值">
						</div><!-- /input-group -->
						<div class="expected-return">预期收益：<span id="pageProfit">0.00</span>元</div>
						<input type="button" class="inv-now" id="inv-now" value="立即投资">
						<div class="remain-vouchers">剩余代金券&nbsp;${sVouchers }元<div class="right">剩余红包&nbsp;${redPackCount }个</div></div>
					</div>
					</form>
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
		<div class="red-packets-top clearfix" id="red-packets-top">
			
		</div>
		<c:if test="${appRecordEntity.isDirect == 1 }">
			<div class="info clearfix" id="codeContent">
				<div class="leftTitle" style="width:130px">定向标密码:</div>
				<input type="text" id="directionalCode" class="inputDJJ1">
			</div>
		</c:if>
		<div class="red-packets-bottom clearfix">
			<div class="label">本次投资总金额：<label  id="nowInvestNum">1,000.00</label>元</div>
			<div class="label">使用代金券：<label  id="nowVoucher">100.00</label>元</div>
			<div class="label">使用红包：<label  id="nowBag">200.00</label>元</div>
			<div class="label">使用账户余额：<label  id="nowAccountBalance">8880.00</label>元</div>
		</div>
		<div class="btn-group" >
			<form action="invest/memberInvestment.html" id="form1" method="post" name="form1">
			 	<input type="hidden" name="projectId" value="">
			 	<input type="hidden" name="slVouchers" value="">
			 	<input type="hidden" name="lAmount" value="">
			 	<input type="hidden" name="redPacks" value="">
			 	<c:if test="${appRecordEntity.isDirect == 1 }">
			 		<input type="hidden" name="sDirectPwd" value="">
			 	</c:if>
			 	<input type="hidden" name="sign" value="">
			</form>
			<input type="button" class="confirm" value="确定" id="confirmSubmit">
			<input type="button" class="cancel" value="取消" onclick="layer.closeAll()">
		</div>	
	</div>	
	<script type="text/html" id="confirmInfo">
			<div class="info">
				<div class="leftTitle">本次可投金额:</div>
				<label><span>{{sSumAount}}</span>元</label>
			</div>
			<div class="info">
				<div class="leftTitle">本次投资总金额:</div>
				<label><span class="orange" id="orangeNum">{{num}}</span>元</label>
				<label>(预期收益：<span class="orange">{{profit}}</span>元)</label>
			</div>
			{{if sVouchers!=='0'&&sVouchers!=='0.00'&&sVouchers!=='0.0000'}}
			<div class="info">
				<div class="leftTitle" style="display:block">使用代金券:</div>
				<input type="text" id="useVouchers" class="inputDJJ format" maxlength="6">
				<span class="djj">元&nbsp;&nbsp;剩余代金券：{{sVouchers}}元</span>
			</div>
			{{/if}}
			{{if redPackList.length>0}}
			<div class="info1 select clearfix">
				<div class="leftTitle">剩余红包:</div>
				<div style="width:325px;float:right" id="red_list">
					{{each redPackList as value index}}
						<label class="input1" data-userNum={{value.sUnUsedAmount}}><input  type="checkbox" value={{value.lId}}>{{$toFixed value.sUnUsedAmount}}元</label>
					{{/each}}
				</div>
			</div>
			{{/if}}
	</script>
	<script type="text/javascript" src="js/invest/investmentDetail.js"></script>
	<script type="text/javascript" src="js/common/countdown.js"></script>
</body>
</html>