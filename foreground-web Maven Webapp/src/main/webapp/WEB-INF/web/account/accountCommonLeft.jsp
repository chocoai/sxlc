<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="accountCommonTop">
	早上好，欢迎<span>王大先生</span>！今天你理财了吗？
</div>
<div class="accountCommonLeft">
	<div class="accountLeftTop">
		<div class="ALT1">
			<div class="userFace">
				<img class="userFaceBottom" src="resource/img/account/common/wdzh_16.png">
				<img class="userFaceTop" src="resource/img/account/common/userface.png">
			</div>
			<div class="userInfo">
				<label>王大先生</label>
				<p>称号:<span>小二</span></p>
				<p>信用等级:<span>高</span></p>
			</div>
		</div>
		<div class="ALT2">
			<div class="integral">
				<span>4000积分</span>
			</div>
			<div class="sign">
				<label></label>
				<span class="tosign">签到</span><!--弹出层链接伍成然2016-4-7  -->
			</div>
		</div>
		<div class="ALT3"><!-- 在这里加入m1 m2 m3 m4 m5分别点亮下面的图标 -->
			<div class="mark1"></div>
			<div class="mark2"></div>
			<div class="mark3"></div>
			<div class="mark4"></div>
			<div class="mark5"></div>
		</div>
		<div class="ALT4">
			<label></label>
			第三方账号：<span>1258745</span>
		</div>
	</div>
	<div class="accountLeftBottom" onselectstart="return false">
		<ul class="clearfix">
			<li class="TA" onclick="window.location='accountOverview.html'">
				<div class="level1Tip">
					<label class="icon1"></label>
					<span>账户总览</span>
				</div>
			</li>
			<li class="TB">
				<div class="level1Tip">
					<label class="icon2"></label>
					<span>个人中心</span>
					<label class="icon0"></label>
				</div>
				<ul class="clearfix">
					<li class="TB1" onclick="window.location='baseInformationForPerson.html'">基本信息</li>
					<li class="TB2" onclick="window.location='securityCenter.html'">安全中心</li>
					<li class="TB3" onclick="window.location='bankCard.html'">银行卡</li>
					<li class="TB4" onclick="window.location='myVIP.html'">我的VIP</li>
					<li class="TB5" onclick="window.location='integralManagement.html'">积分管理</li>
					<li class="TB6" onclick="window.location='friendManagement.html'">好友管理</li>
					<li class="TB7" onclick="window.location='loanCertification.html'">借款认证</li>
					<li class="TB8" onclick="window.location='mail.html'">站内信</li>
					<li class="TB9" onclick="window.location='stationMessage.html'">站内信息</li>
					<li class="TB10" onclick="window.location='messageAlert.html'">消息提醒</li>
					<li class="TB11" onclick="window.location='recommendedTalent.html'">推荐达人</li>
					<li class="TB12" onclick="window.location='financialAdvisor.html'">理财顾问</li>
				</ul>
			</li>
			<li class="TC">
				<div class="level1Tip">
					<label class="icon3"></label>
					<span>资金管理</span>
					<label class="icon0"></label>
				</div>
				<ul class="clearfix">
					<li class="TC1" onclick="window.location='recharge.html'">我要充值</li>
					<li class="TC2" onclick="window.location='cash.html'">我要提现</li>
					<li class="TC3" onclick="window.location='incomeExpenditure.html'">收支明细</li>
					<li class="TC4" onclick="window.location='award.html'">赠送奖励</li>
				</ul>
			</li>
			<li class="TD">
				<div class="level1Tip">
					<label class="icon4"></label>
					<span>投资管理</span>
					<label class="icon0"></label>
				</div>
				<ul class="clearfix">
					<li class="TD1" onclick="window.location='myInvestment.html'">我的投资</li>
					<li class="TD2" onclick="window.location='investmentZone.html'">我要投资</li>
					<li class="TD3" onclick="window.location='autoBid.html'">自动投标</li>
					<li class="TD4" onclick="window.location='debtAttorn.html'">债权转让</li>
				</ul>
			</li>
			<li class="TE">
				<div class="level1Tip">
					<label class="icon5"></label>
					<span>借款管理</span>
					<label class="icon0"></label>
				</div>
				<ul class="clearfix">
					<li class="TE1" onclick="window.location='LR_financing.html'">我的借款</li>
					<li class="TE2" onclick="window.location='loan.html'">我要借款</li>
					<li class="TE3" onclick="window.location='repayManagement.html'">还款管理</li>
					<li class="TE4" onclick="window.location='autoRepay.html'">自动还款</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
<div class="sign-success">
	<img src="resource/img/account/qdcg2_03.jpg">
	<p>您已经签到<a>3</a>次</p>
	<div class="btn" onclick="layer.closeAll()">确定</div>
</div>