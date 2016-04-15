<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>投资详情</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/invest/investmentDetail.css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
    <!-- 此处加入代码 -->
    <!--伍成然2016-3-28  -->
    <div class="main">
    	<div class="link-area">
			<div class="link-parents">
				您当前的位置&gt;
				<a href="index.html">首页</a>&gt;
				<a href="investmentZone.html" class="dq">投资专区</a>&gt;
			</div>
			<div class="page-link">
				<a href="#" class="current-page on">项目详情</a>
				<a href="#" class="current-page">风控措施</a>
				<a href="#" class="current-page">还款计划</a>
				<a href="#" class="current-page">投资列表</a>
				<a href="#" class="current-page">项目历程</a>
				<a href="#" class="current-page">贷后监管</a>
			</div>
		</div>
		<!--inv-box  -->
		<div class="inv-box clearfix">
			<div class="inv-top-box">
				<div class="inv-head clearfix">
					<img src="resource/img/invest/dan.png">
					<label>化工企业研发资金借款</label>
					<span>【NO.20160306121】</span>
				</div>
				<div class="inv-info clearfix">
					<div class="inv-rate">
						<p>年化利率</p>
						<h1>16.20<span>%</span><span class="increase">+1.30%</span></h1>					
					</div>
					<div class="inv-item-amount">
						<p>项目金额</P>	
						<h1 class="moneyFormat">5000.12</h1><span>元</span>
						<span class="reward">					
						   	投资本金
							<b>0.01%</b>
						</span>
					</div>
					<div class="inv-time">
						<p>项目期限</p>					
						<h1>6<span>个月</span></h1>
					</div>
					<div class="inv-available-amount">
						<p>可投金额</p>					
						<h1 class="moneyFormat">3000</h1><span>元</span>
					</div>
				</div>
				<div class="inv-info-bottom">
					<!--进度条  -->
					<div class="progress">
						<div class="pro-title">投资进度：</div>
						<div class="barbox"> 
							<div class="barline"></div> 
						</div>
						<span class="progress_totle">60%</span>
					</div>
					<div class="info-label">
						<div class="left-title">剩余时间：</div>
						<div class="time-ico">1天8小时17分41秒</div>
					</div>
					<div class="info-label">
						<div class="left-title">还款方式：</div>
						<label>等额本息</label>	
					</div>
					<div class="info-label">
						<div class="left-title">信用等级：</div>
						<label>高</label>
					</div>	
					<div class="info-label">
						<div class="left-title">查看协议：</div>
						<a href="#">协议</a>
					</div>																
				</div>
			</div><!--top-box结束  -->
			<!--inv-deal-box未登录状态  -->
			<div class="inv-deal-box not-logined">
				<div class="login-remind">
					<a href="login.html">登录</a>后可查看可用余额
				</div>
				<div class="input-group">
				    <input type="text" class="charge-input format" maxlength="10" value="50元起投且金额为整数" 
					onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
					onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
					style="color:#bfbfbf">
				    <div class="charge-addon1">元</div>
				 </div>
				 <input type="button" class="login-now" value="立即登录">
			</div>
			<!--inv-deal-box未登录状态结束  -->
			<!--inv-deal-box已登录状态  -->
			<div class="inv-deal-box logined">
				<div class="inv-available">本次可投金额<div class="right"><span>1600</span>元</div></div>
				<div class="amount-available">可用余额<div class="right"><span>220.00</span>元</div></div>
				<div class="input-group">
				    <input type="text" class="charge-input format" maxlength="10" value="50元起投且金额为整数" 
					onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
					onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
					style="color:#bfbfbf">
				    <div class="charge-addon">元</div>
				    <input class="charge-btn" type="button" value="充值">
				</div><!-- /input-group -->
				<div class="expected-return">预期收益：<span>0.00</span>元</div>
				<input type="button" class="inv-now" value="立即投资">
				<div class="remain-vouchers">剩余代金券&nbsp;500.00元<div class="right">剩余红包&nbsp;3个</div></div>
			</div>
			<!--deal-box已登录状态结束  -->
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
					<div class="content content-active">
						<jsp:include page="projectDetail.jsp"></jsp:include>
					</div>
					<div class="content">
						<jsp:include page="riskControl.jsp"></jsp:include>
					</div>
					<div class="content contentList">
						<jsp:include page="repaymentPlan.jsp"></jsp:include>
					</div>
					<div class="content contentList">
						<jsp:include page="investmentList.jsp"></jsp:include>
					</div>
					<div class="content">
						<jsp:include page="projectCourse.jsp"></jsp:include>
					</div>
					<div class="content after-inv"><!--投资后显现  -->
						<jsp:include page="postLoanSupervision.jsp"></jsp:include>
					</div>
				</div>		
			</div>
		</div>	
    </div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<!--弹出层  -->
	<div class="red-packets">
		<div class="red-packets-top">
			<div class="info">
				<div class="leftTitle">本次可投金额:</div>
				<label><span>1600.00</span>元</label>
			</div>
			<div class="info">
				<div class="leftTitle">本次投资总金额:</div>
				<label><span class="orange">1000.00</span>元</label>
				<label>(预期收益：<span class="orange">100.00</span>元)</label>
			</div>
			<div class="info">
				<div class="leftTitle" style="display:block">使用代金券:</div><!--代金券为0时display:none  -->
				<input type="text" class="inputDJJ format" maxlength="6">
				<span class="djj">元&nbsp;&nbsp;剩余代金券：500.00元</span>
			</div>
			<div class="info" style="display:none"><!--代金券为0时display:block  -->
				<div class="leftTitle">剩余代金券:</div>
				<label>0.00元</label>
			</div>
			<div class="info select">
				<div class="leftTitle">剩余红包:</div>
				<label class="active input1"><input type="radio" name="tag" value="10">10元</label>
				<label class="input1"><input type="radio" name="tag" value="50">50元</label>
				<label class="input1"><input type="radio" name="tag" value="100">100元</label>
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