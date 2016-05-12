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
    <title>安全保障</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/securityGuarantee.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="../aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
     <div class="safety">
     	<div class="safeContent">
     		<!-- <div class="s_plat">
				<h4>平台安全</h4>
				<div class="s_plat_main">
					<div class="sPlatMainCont">
						四象金融平台架构基于J2EE，采用JAVA语言（银行级安全代码）、Spring MVC三层架构、最新一代云服务器，数据存储采用MD5不可逆加密，客户端输入信息RSA方式加密。四象金融采用第三方（双乾网络支付有限公司）资金托管，全方位合作，资金流转过程透明，所有资金变动及时通过手机短信实时验证，从技术层面严格保障平台运行和客户的资金安全。
					</div>
					<span><img src="resource/img/aboutUs/safety_03.jpg"></span>
				</div>
			</div>
			<div class="s_plat2">
				<div class="s_plat_main s_plat_main2">
					<img src="resource/img/aboutUs/safety_07.jpg">
					<div class="sPlatMainCont">
						<h4>资格审核</h4>
						<p>四象金融会要求融资人必须出具一系列相关资料，四象金融风控部依据这些资料对融资人严格进行审核，以确定融资人是否具有融资资质；对融资人当前负债情况、名下资产、融资用途、还款能力等进行上门实地考察，并联合多个第三方机构负责对借款人的抵押物、借款人资质以及是否涉及法律纠纷和诉讼进行专业的综合评估，确保融资人都具有良好的信用意识和稳定的还款能力。</p>
					</div>
				</div>
			</div>
			<div class="s_plat">
				<h4>资金安全</h4>
				<div class="s_plat_main">
					<div class="sPlatMainCont">
						四象金融平台上的所有借贷资金完全托管给第三方支付机构—双乾网络支付有限公司。在四象金融上的所有投资、融资等资金流动均不经过四象金融的银行账户，用户资金、网站收入、风险准备金等完全分离，避免出现资金池和道德风险，这样更符合P2P的借贷理念以及 避免因平台资金与交易双方资金交叉所带来的困扰及支付风险。避免出现资金池，平台自己不能对用户资金提现，避免出现支付风险，因此客户在四象金融的交易资金得到了充分的保障，资金的非常安全。
					</div>
					<span><img src="resource/img/aboutUs/safety_11.jpg"></span>
				</div>
			</div>
			<div class="s_plat2">
				<div class="s_plat_main s_plat_main2">
					<img src="resource/img/aboutUs/safety_15.jpg">
					<div class="sPlatMainCont">
						<h4>贷后管理</h4>
						<p>
							客户融资后，我们会对其资金实际用途进行核实。如果融资人逾期未及时归还借款，贷后管理部门将第一时间通过短信、电话等方式提醒其还款。如果用户在5个工作日内仍未归还当期借款，四象金融将会联系该用户的紧急联系人、直系亲属、单位等督促用户尽快还款。如果用户仍未还款，将交由专业的催收团队与第三方专业机构合作进行一系列的催收工作，包括上门催收等，直至采取法律手段。
						</p>
					</div>
				</div>
			</div>
			<div class="s_plat">
				<h4>个人信息安全</h4>
				<div class="s_plat_main">
					<div class="sPlatMainCont">
						四象金融严格遵守国家相关的法律法规，对用户的隐私信息进行保护。未经您的同意，四象金融不会向任何第三方公司、组织和个人披露您的个人信息、账户信息以及交易信息。但融资人还款严重逾期，四象金融因催款需要；或应国家政府机关、司法检查机关及相关机构部门的要求而披露的除外。
					</div>
				</div>
			</div>
			<div class="s_plat2 safeContLast">
				<div class="s_plat_main s_plat_main2">
					<img class="safeImg" src="resource/img/aboutUs/safety_19.jpg">
					<div class="platLawy sPlatMainCont">
						<h4>法律保障</h4>
						<h6>1、借款双方关系的合法性</h6>
						<p>《合同法》第196条规定：“借款合同是借款人向贷款人借款，到期返还借款并支付利息的合同”；根据《合同法》第十二章“借款合同”和最高人民法院《关于人民法院审理借贷案件的若干意见》，我国法律允许自然人等普通民事主体之间发生借贷关系，并允许出借方到期可以收回本金和符合法律规定的利息。理财人作为借款人，与贷款人之间形成的借贷关系受到法律保护。</p>
						<h6>2、四象金融平台提供居间服务的合法性</h6>
					</div>
				</div>
			</div>
			<div class="sPlatLawy">
				<div>《合同法》第23章专门对“居间合同”作出规定，其第424条明确定义为：“居间合同是居间人向委托人报告订立合同的机会或者提供订立合同的媒介服务，委托人支付报酬的合同”。四象金融平台是合法设立的中介服务机构，致力于为民间借贷业务提供优质高效的撮合服务，以促成借贷双方形成借贷关系，然后收取相关报酬。此种居间服务有着明确的法律依据。</div>
				<h6>3、电子合同的法律效力</h6>
				<div class="">依据《合同法》第十一条法律规定可知，电子合同是我国法律明确认可的一种书面合同形式，效力等同于传统的纸质合同</div>
				<h6>4、出借收益的合法性</h6>
				<div class=""> 根据最高人民法院《关于人民法院审理借贷案件的若干意见》第六条的相关规定，出借人通过出借获得的收益未超过银行同类贷款利率的四倍，因此该部分收益视为合法收益，是受到法律认可并保护的。</div>
			</div>
			<div class="sPlatAdverse">
				<h4>安全建议</h4>
				<h6>1.注重运行环境的安全</h6>
				<div class="col-lg-12">客户尽量不要使用公共场合电脑进行有关操作，并牢记本台官方安全网址（http://www.cdsxlc.com/）。不要通过点击来历不明的链接进入四象金融平台进行交易，谨防钓鱼和欺诈网站，并对自用电脑要经常进行病毒预防和漏洞补丁修补。因个人电脑原因带来的不良后果用户自负。</div>
				<h6>2.用户时刻注意保护个人隐私安全</h6>
				<div class="col-lg-12"> 用户在四象金融平台进行密码设置时，请最好使用字符和数字混合，不要使用纯数字或简单的字母组合，密码长度最好达到平台的最高要求。</div>
			</div> -->
     	</div>
	</div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/securityGuarantee.js"></script>
</body>
</html>