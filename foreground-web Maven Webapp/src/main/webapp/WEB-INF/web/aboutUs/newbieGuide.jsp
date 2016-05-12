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
    <title>新手指南</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/newbieGuide.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="../aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="newbieGuide">
    	<div class="guideContent">
    		<!-- <div class="principle">
    			<div class="guideContentT">
    				<img src="resource/img/aboutUs/line_03.jpg">
    				四象金融借款原理
    				<img src="resource/img/aboutUs/line_05.jpg">
    			</div>
    			<div class="principleMain">
    				<div class="principleMainL">
    					<p>四象金融是中国首家注册资本一亿元的股份制网贷平台， 依托高效的互联网信息发布渠道，以专业高效的金融服务，为数千家小 微企业解决了资金需求，同时为网贷投资人搭建了一个便捷、高效、安 全的p2p投资理财平台。</p>
    					<p>借款人在线提交借款申请，四象金融对借款企业进行实地取信、审核及评 估，同时引入第三方担保机构为借款方提供融资担保，最终通过并发布 借款信息。投资人可在四象金融上搜索并挑选适合自己的投资项目，并通 过四象金融设立的资金托管账户进行投标认购。整个借贷过程中，四象金融 主要承担了信用审核、担保机构引入、信息发布等角色。</p>
    				</div>
    				<div class="principleMainR">
    					<img src="resource/img/aboutUs/image_icon.jpg">
    				</div>
    			</div>
    		</div>
    		<div class="reason">
    			<div class="guideContentT">
    				<img src="resource/img/aboutUs/line_03.jpg">
    				选择我们的理由
    				<img src="resource/img/aboutUs/line_05.jpg">
    			</div>
    			<div class="reasonMain">
    				<div class="feature">
						<ul>
							<li>
								<div><img src="resource/img/index/aqkk.png"></div>
								<div class="featureWord">
									<p class="featureTitle">安全可靠</p>
									<p>银行资金存管</p>
									<p>资金安全无忧</p>
								</div>
							</li>
							<li>
								<div><img src="resource/img/index/fxgx.png"></div>
								<div class="featureWord">
									<p class="featureTitle">风险更小</p>
									<p>第三方总体担保</p>
									<p>加强抗风险能力</p>
								</div>
							</li>
							<li>
								<div><img src="resource/img/index/jdkj.png"></div>
								<div class="featureWord">
									<p class="featureTitle">简单快捷</p>
									<p>投资周期更短</p>
									<p>快速收回本息</p>
								</div>
							</li>
							<li>
								<div><img src="resource/img/index/yuny.png"></div>
								<div class="featureWord">
									<p class="featureTitle">运营优异</p>
									<p>成立4年，运营稳健</p>
									<p>贷款70%以上资产抵押</p>
								</div>
							</li>
						</ul>
					</div>
    			</div>
    		</div>
    		<div class="achievement">
    			<div class="guideContentT">
    				<img src="resource/img/aboutUs/line_03.jpg">
    				四象金融业绩如何
    				<img src="resource/img/aboutUs/line_05.jpg">
    			</div>
    			<div class="achievementMain">
    				<div class="achievementMainL">
    					<img src="resource/img/aboutUs/gread_03.jpg">
    				</div>
    				<div class="achievementMainR">
    					<div>
	    					累计总交易额
	    					<span>163<em>亿</em>5263<em>万</em>8979<em>元</em></span>
    					</div>
    					<div>
	    					平台注册人数
	    					<span>9<em>万</em>8979<em>元</em></span>
    					</div>
    					<div>
	    					为投资人赚取
	    					<span>5263<em>万</em>8979<em>元</em></span>
    					</div>
    					<div>
	    					平均收益率
	    					<span class="MainRSpan">超过14%</span>
    					</div>
    				</div>
    			</div>
    		</div>
    		<div class="procedure">
    			<div class="guideContentT">
    				<img src="resource/img/aboutUs/line_03.jpg">
    				<span class="procedureLoan">借款流程</span>/<span class="procedureInvest">投资流程</span>
    				<img src="resource/img/aboutUs/line_05.jpg">
    			</div>
    			<div class="procedureCont">
    				<div class="procedureLoanImg">
    					<img src="resource/img/aboutUs/jiekualiucheng_icon.png">
    				</div>
    				<div class="procedureInvestImg">
    					<img src="resource/img/aboutUs/touziliucheng_icon.jpg">
    				</div>
    			</div>
    		</div> -->
    	</div>
    </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/newbieGuide.js"></script>
</body>
</html>