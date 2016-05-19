<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>债权详情</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/invest/debtDetail.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<script type="text/javascript" src="js/common/template.js"></script>
   	<script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    	var ctId	  = '${creditorTransferListEntity.ctaId}';
    	var applyId   = '${creditorTransferListEntity.applyId}';
    </script>
    <!-- 此处加入代码 -->
    <!--伍成然2016-3-30  -->
    <div class="main">
    	<div class="link-area">
			<div class="link-parents">
				您当前的位置&gt;
				<a href="index.html">首页</a>&gt;
				<a href="invest/debtCession.html" class="dq">债权转让</a>&gt;
			</div>
			<div class="page-link">
				<a class="current-page on">项目详情</a>
				<a class="current-page">风控措施</a>
				<a class="current-page">还款计划</a>
				<a class="current-page">投资列表</a>
				<a class="current-page">项目历程</a>		
			</div>
		</div>
		<!--inv-box  -->
		<div class="inv-box clearfix">
			<div class="inv-top-box">
				<div class="inv-head clearfix">
					<img src="${creditorTransferListEntity.picIcon }">
					<label>${creditorTransferListEntity.projectTitle }</label>
					<span>${creditorTransferListEntity.projectNo }</span>
				</div>
				<div class="inv-info clearfix">
					<div class="inv-rate">
						<p>预期年化利率</p>
						<h1>${creditorTransferListEntity.expectYearrates }<span>%</span>
						<c:if test="${creditorTransferListEntity.rateAddRate > 0}">
							<span class="increase">+${creditorTransferListEntity.rateAddRates }%</span>
						</c:if></h1>					
					</div>
					<div class="inv-item-amount">
						<p>转让金额</P>					
						<h1 class="moneyFormat">${creditorTransferListEntity.transPrincipals }</h1><span>元</span>
						<c:if test="${creditorTransferListEntity.rewardRate > 0}">
							<span class="reward">
						   	投资本金
							<b>${creditorTransferListEntity.rewardRates }%</b>
							</span>
						</c:if>
					</div>
					<div class="inv-time">
						<p>剩余期限</p>					
						<h1>${creditorTransferListEntity.surplusTime }
							<span>
							<c:if test="${creditorTransferListEntity.surplusTimeType == 0}">天</c:if>
							<c:if test="${creditorTransferListEntity.surplusTimeType == 1}">个月</c:if>
							<c:if test="${creditorTransferListEntity.surplusTimeType == 2}">年</c:if>
							</span>
						</h1>
						<!-- 解析第二级时间 -->
						<c:if test="${creditorTransferListEntity.surplusTimeSub > 0 && creditorTransferListEntity.surplusTimeType == 1}">
							<h1>${creditorTransferListEntity.surplusTimeSub}
								<span>天</span>
							</h1>
						</c:if>
						<c:if test="${creditorTransferListEntity.surplusTimeSub > 0 && creditorTransferListEntity.surplusTimeType == 2}">
							<h1>${creditorTransferListEntity.surplusTimeSub}
								<span>个月</span>
							</h1>
						</c:if>
					</div>
					<div class="inv-available-amount">
						<p>转让折扣</p>					
						<h1>${creditorTransferListEntity.transDiscounts }<span>%</span></h1>
					</div>
				</div>
				<div class="inv-info-bottom">
					<!--进度条  -->
					<div class="progress">
						<div class="pro-title">投资进度：</div>
						<div class="barbox"> 
							<div class="barline"></div> 
						</div>
						<span class="progress_totle">${creditorTransferListEntity.ctaInvestRates }%</span>
					</div>
					
					<c:if test="${investmentStatus == 0 }">
						<div class="info-label">
							<div class="left-title">剩余时间：</div>
								<div 	class="J_CountDown time-ico" 
										data-config="{'startTime':'${sysTime }','endTime':'${endTime }'}"></div>
						</div>
					</c:if>
					<div class="info-label">
						<div class="left-title">还款方式：</div>
						<label>${creditorTransferListEntity.repalyways }</label>	
					</div>
					<div class="info-label">
						<div class="left-title">信用等级：</div>
						<label>${creditorTransferListEntity.levelMark }</label>
					</div>	
					<div class="info-label">
						<div class="left-title">查看协议：</div>
						<a href="#">协议</a>
					</div>																
				</div>
			</div><!--top-box结束  -->
			<!-- 投标中 -->
			<c:if test="${investmentStatus == 0}">
				<c:if test="${loginUser == null }">
					<form id="notLoginBox">
						<div class="inv-deal-box not-logined">
							<div class="login-remind">
								<a href="login.html">登录</a>&nbsp;&nbsp;后可查看可用余额
							</div>
							<div class="input-group">
							    <input type="text" class="charge-input" datatype="acountM" value="50元起投且金额为整数" 
								onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
								onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
								style="color:#bfbfbf">
							    <div class="charge-addon1">元</div>
							 </div>
							 <input type="button" class="login-now"  onclick="window.location='<%=path%>/login.html'" value="立即登录">
						</div>
					</form>
				</c:if>
				<c:if test="${loginUser != null }">
					<form id="loginedBox">
					<div class="inv-deal-box logined">
						<div class="inv-available">本次可投金额<div class="right"><span>${sSumAount}</span>元</div></div>
						<div class="amount-available">可用余额<div class="right"><span>${userBalances }</span>元</div></div>
						<div class="input-group" style="height:50px;">
						    <input type="text" class="charge-input" datatype="acountM" maxlength="10" value="50元起投且金额为整数" 
						   	id="investMoney"
							onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
							onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
							style="color:#bfbfbf">
						    <div class="charge-addon">元</div>
						    <input class="charge-btn" type="button" onclick="window.location='<%=path%>/fundManagement/recharge.html'" value="充值">
						</div><!-- /input-group -->
						<div class="expected-return">预期收益：<span id="pageProfit">0.00</span>元</div>
						<input type="button" class="inv-now" id="inv-now" value="立即投资">
						<div class="remain-vouchers">剩余代金券&nbsp;${sVouchers }元<div class="right">剩余红包&nbsp;${redPackCount }个</div></div>
					</div>
					</form>
				</c:if>
			</c:if>
							
			<!-- 流标 -->
			<c:if test="${investmentStatus == 1 }">
				<div class="inv-deal-box">
					<div class="count-down-title">成功交易时间:</div>
					<div class="count-down">2016-03-09&nbsp;16:00:58</div>
					<img src="resource/img/invest/ylb.png">				
				</div>			
			</c:if>
			
			<!--  投标完成  -->
			<c:if test="${investmentStatus == 2 }" >
				<div class="inv-deal-box">
					<div class="count-down-title">成功交易时间:</div>
					<div class="count-down">2016-03-09&nbsp;16:00:58</div>
					<img src="resource/img/invest/tbwc.png"/>				
				</div>	
			</c:if>
			
			<!-- 还款中 -->
			<c:if test="${investmentStatus == 3 }">
				<div class="inv-deal-box">
					<div class="count-down-title">成功交易时间:</div>
					<div class="count-down">2016-03-09&nbsp;16:00:58</div>
					<img src="resource/img/invest/wytzhkz.png">				
				</div>	
			</c:if>
			
			<!-- 已结清 -->
			<c:if test="${investmentStatus == 4 }">
				<div class="inv-deal-box">
					<div class="count-down-title">成功交易时间:</div>
					<div class="count-down">2016-03-09&nbsp;16:00:58</div>
					<img src="resource/img/invest/wytzyjq.png">				
				</div>	
			</c:if>
			
			
			
			<!--inv-bottom-box部分  -->
			<div class="inv-bottom-box">
				<ul class="tab-head">
					<li class="tab-li tab-ing">项目详情</li>
					<li class="tab-li">风控措施</li>
					<li class="tab-li">还款计划</li>
					<li class="tab-li">投资列表</li>
					<li class="tab-li">项目历程</li>
				</ul>
				<div class="tab-content clearfix">
					<div class="c-content content-active">
						<jsp:include page="projectDetail.jsp"></jsp:include>
					</div>
					<div class="c-content">
						<jsp:include page="riskControl.jsp"></jsp:include>
					</div>
					<div class="c-content contentList">
						<jsp:include page="repaymentPlan.jsp"></jsp:include>
					</div>
					<div class="c-content contentList">
						<jsp:include page="investmentList.jsp"></jsp:include>
					</div>
					<div class="c-content">
						<jsp:include page="projectCourse.jsp"></jsp:include>
					</div>
				</div>		
			</div>
		</div>	
    </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/invest/debtDetail.js"></script>
	<!--弹出层  -->
	<div class="red-packets">
		<div class="red-packets-top clearfix" id="red-packets-top">
			
		</div>
<%-- 		<c:if test="${appRecordEntity.isDirect == 1 }">
			<div class="info clearfix" id="codeContent">
				<div class="leftTitle">定向标密码:</div>
				<input type="text" id="directionalCode" class="inputDJJ1">
			</div>
		</c:if> --%>
		<div class="red-packets-bottom clearfix">
			<div class="label">本次投资总金额：<label  id="nowInvestNum">1,000.00</label>元</div>
			<div class="label">使用代金券：<label  id="nowVoucher">100.00</label>元</div>
			<div class="label">使用红包：<label  id="nowBag">200.00</label>元</div>
			<div class="label">使用账户余额：<label  id="nowAccountBalance">8880.00</label>元</div>
		</div>
		<div class="btn-group" >
			<form action="invest/debtInvestment.html" id="form1" method="post" name="form1">
			 	<input type="hidden" name="projectId" value="">
			 	<input type="hidden" name="lCreditorTransAppId" value="">
			 	<input type="hidden" name="lVouchers" value="">
			 	<input type="hidden" name="lAmount" value="">
			 	<input type="hidden" name="sRedPacketsInfo" value="">
<%-- 			 	<c:if test="${appRecordEntity.isDirect == 1 }">
			 		<input type="hidden" name="sDirectPwd" value="">
			 	</c:if> --%>
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
				<label>(预期收益：<span class="orange">{{$toFixed profit}}</span>元)</label>
			</div>
			{{if sVouchers!="0.00"}}
			<div class="info">
				<div class="leftTitle" style="display:block">使用代金券:</div>
				<input type="text" id="useVouchers" class="inputDJJ format" maxlength="6">
				<span class="djj">元&nbsp;&nbsp;剩余代金券：{{sVouchers}}元</span>
			</div>
			{{/if}}
			<div class="info1 select clearfix">
				<div class="leftTitle">剩余红包:</div>
					<div style="width:325px;float:right" id="red_list">
						{{each redPackList as value index}}
							<label class="input1"><input  type="checkbox" value={{value.lId}}>{{$toFixed value.sUnUsedAmount}}元</label>
						{{/each}}
					</div>
			</div>
		</script>
	<script type="text/javascript" src="js/common/countdown.js"></script>
</body>
</html>