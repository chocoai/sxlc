<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="accountCommonTop">
	早上好，欢迎<span class="left_name"></span>！今天你理财了吗？
</div>
<div class="accountCommonLeft">
	<div class="accountLeftTop">
		<div class="ALT1">
			<div class="userFace">
				<img class="userFaceBottom" src="resource/img/account/common/wdzh_16.png">
				<img class="userFaceTop" src="resource/img/account/common/userface.png">
			</div>
			<div class="userInfo">
				<label class="left_name"></label>
				<p>称号:<span class="integralLevelName"></span></p>
				<p>信用等级:<span class="creditLevelName"></span></p>
			</div>
		</div>
		<div class="ALT2">
			<div class="integral">
				<span class="integral_score"></span>
			</div>
			<div class="sign">
				<label></label>
				<span class="tosign">签到</span><!--弹出层链接伍成然2016-4-7  -->
			</div>
		</div>
		<div class="ALT3"><!-- 在这里加入m1 m2 m3 m4 m5分别点亮下面的图标 -->
			<div class="mark1"><img src="resource/img/account/common/wdzh_7.png"></div>
			<div class="mark2"><img src="resource/img/account/common/wdzh_9.png"></div>
			<div class="mark3"><img src="resource/img/account/common/wdzh_11.png"></div>
			<!-- <div class="mark4"><img src="resource/img/account/common/wdzh_13.png"></div> -->
			<div class="mark5" openThird="1"><img src="resource/img/account/common/wdzh_15.png"></div>
		</div>
		<div class="ALT4">
			<label></label>
			第三方账号：<span class="thirdPartyAccount"></span>
		</div>
	</div>
	<div class="accountLeftBottom" onselectstart="return false">
		<ul class="clearfix">
			<li class="TA" onclick="window.location='<%=path%>/accountOverview/accountOverview.html'">
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
					<li class="TB1" onclick="window.location='<%=path%>/personalCenter/baseInformationForPerson.html'">基本信息</li>
					<li class="TB2" onclick="window.location='<%=path%>/personalCenter/securityCenter.html'">安全中心</li>
					<li class="TB3" onclick="window.location='<%=path%>/personalCenter/bankCard.html'">银行卡</li>
					<li class="TB4" onclick="window.location='<%=path%>/personalCenter/myVIP/1.html'">我的VIP</li>
					<li class="TB5" onclick="window.location='<%=path%>/personalCenter/integralManagement/1/1.html'">积分管理</li>
					<li class="TB6" onclick="window.location='<%=path%>/personalCenter/friendManagement.html'">好友管理</li>
					<li class="TB7" onclick="window.location='<%=path%>/personalCenter/loanCertification.html'">借款认证</li>
					<li class="TB8" onclick="window.location='<%=path%>/personalCenter/mail.html'">站内信</li>
					<li class="TB9" onclick="window.location='<%=path%>/personalCenter/stationMessage.html'">站内信息</li>
					<li class="TB10" onclick="window.location='<%=path%>/personalCenter/messageAlert.html'">消息提醒</li>
					<li class="TB11" onclick="window.location='<%=path%>/personalCenter/recommendedTalent.html'">推荐达人</li>
					<li class="TB12" onclick="window.location='<%=path%>/personalCenter/financialAdvisor.html'">理财顾问</li>
				</ul>
			</li>
			<li class="TC">
				<div class="level1Tip">
					<label class="icon3"></label>
					<span>资金管理</span>
					<label class="icon0"></label>
				</div>
				<ul class="clearfix">
					<li class="TC1" onclick="window.location='<%=path%>/fundManagement/recharge.html'">我要充值</li>
					<li class="TC2" onclick="window.location='<%=path%>/fundManagement/cash.html'">我要提现</li>
					<li class="TC3" onclick="window.location='<%=path%>/fundManagement/incomeExpenditure.html'">收支明细</li>
					<li class="TC4" onclick="window.location='<%=path%>/fundManagement/award.html'">赠送奖励</li>
				</ul>
			</li>
			<li class="TD">
				<div class="level1Tip">
					<label class="icon4"></label>
					<span>投资管理</span>
					<label class="icon0"></label>
				</div>
				<ul class="clearfix">
					<li class="TD1" onclick="window.location='<%=path%>/investmentManagement/myInvestment.html'">我的投资</li>
					<li class="TD2" onclick="window.location='<%=path%>/invest/investmentZone.html'">我要投资</li>
					<li class="TD3" onclick="window.location='<%=path%>/investmentManagement/autoBid.html'">自动投标</li>
					<li class="TD4" onclick="window.location='<%=path%>/investmentManagement/debtAttorn.html'">债权转让</li>
				</ul>
			</li>
			<li class="TE">
				<div class="level1Tip">
					<label class="icon5"></label>
					<span>借款管理</span>
					<label class="icon0"></label>
				</div>
				<ul class="clearfix">
					<li class="TE1" onclick="window.location='<%=path%>/loanManagement/LR_financing.html'">我的借款</li>
					<li class="TE2" onclick="window.location='<%=path%>/loan/loan.html'">我要借款</li>
					<li class="TE3" onclick="window.location='<%=path%>/loanManagement/repayManagement.html'">还款管理</li>
					<li class="TE4" onclick="window.location='<%=path%>/loanManagement/autoRepay.html'">自动还款</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
<div class="sign-success">
	<img src="resource/img/account/qdcg2_03.jpg">
	<p>您已经签到<a class="recordNum">3</a>次</p>
	<div class="btn" onclick="layer.closeAll()">确定</div>
</div>
<script type="text/javascript" src="js/account/accountCommonLeft.js"></script>