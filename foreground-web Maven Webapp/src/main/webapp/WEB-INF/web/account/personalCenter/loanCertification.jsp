<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>借款认证</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/loanCertification.css">
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
   				<!-- 借款认证界面      胥福星      20160330 -->
   					<div class="th" onselectstart="return false">
   						<span class="thClick">个人认证</span>
   						<span>企业认证</span>
   					</div>
   					<ul class="personalAuthen">
   						<li class="td">
   							<span class="tdFirst">实名认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="SC_realNameAuthentication.html">查看</a></span>
   							<span class="link linkAuthen"><a href="SC_realNameAuthentication.html">认证</a></span>
   							<span class="link linkAlert"><a href="SC_realNameAuthentication.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">现场认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_personal_scene.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_scene.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_scene.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">征信认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_personal_credit.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_credit.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_credit.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">住址认证</span>
   							<span class="tdSpan">审核中</span>
   							<span class="link linkCheck"><a href="LC_personal_address.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_address.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_address.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">职称认证</span>
   							<span class="tdSpan">未认证</span>
   							<span class="link linkCheck"><a href="LC_personal_title.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_title.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_title.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">社保认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_personal_socialSecurity.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_socialSecurity.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_socialSecurity.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">房产认证</span>
   							<span class="tdSpan">未认证</span>
   							<span class="link linkCheck"><a href="LC_personal_freehold.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_freehold.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_freehold.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">车产认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_personal_voiture.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_voiture.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_voiture.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">银行流水认证</span>
   							<span class="tdSpan">已过期</span>
   							<span class="link linkCheck"><a href="LC_personal_detailedStatement.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_detailedStatement.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_detailedStatement.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">婚姻认证</span>
   							<span class="tdSpan">审核中</span>
   							<span class="link linkCheck"><a href="LC_personal_marriage.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_marriage.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_marriage.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">学历认证</span>
   							<span class="tdSpan">未通过</span>
   							<span class="link linkCheck"><a href="LC_personal_education.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_personal_education.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_personal_education.html">修改</a></span>
   						</li>
   					</ul>
   					<ul class="companyAuthen">
   						<li class="td">
   							<span class="tdFirst">营业执照认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_company_BL.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_BL.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_BL.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">工商执照认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_company_ICL.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_ICL.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_ICL.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">组织机构代码认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_company_OC.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_OC.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_OC.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">开户许可证认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_company_AL.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_AL.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_AL.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">企业银行流水认证</span>
   							<span class="tdSpan">审核中</span>
   							<span class="link linkCheck"><a href="LC_company_DS.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_DS.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_DS.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">实地考察认证</span>
   							<span class="tdSpan">未认证</span>
   							<span class="link linkCheck"><a href="LC_company_scene.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_scene.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_scene.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">税务登记认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_company_TR.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_TR.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_TR.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">批文认证</span>
   							<span class="tdSpan">未认证</span>
   							<span class="link linkCheck"><a href="LC_company_approval.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_approval.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_approval.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">财务资料认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_company_FD.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_FD.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_FD.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">监管单位认证</span>
   							<span class="tdSpan">已认证</span>
   							<span class="link linkCheck"><a href="LC_company_SU.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_SU.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_SU.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">房产认证</span>
   							<span class="tdSpan">审核中</span>
   							<span class="link linkCheck"><a href="LC_company_freehold.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_freehold.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_freehold.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">车产认证</span>
   							<span class="tdSpan">已过期</span>
   							<span class="link linkCheck"><a href="LC_company_voiture.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_voiture.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_voiture.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">担保考察认证</span>
   							<span class="tdSpan">审核中</span>
   							<span class="link linkCheck"><a href="LC_company_GI.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_GI.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_GI.html">修改</a></span>
   						</li>
   						<li class="td">
   							<span class="tdFirst">法人身份证认证</span>
   							<span class="tdSpan">未通过</span>
   							<span class="link linkCheck"><a href="LC_company_corporation.html">查看</a></span>
   							<span class="link linkAuthen"><a href="LC_company_corporation.html">认证</a></span>
   							<span class="link linkAlert"><a href="LC_company_corporation.html">修改</a></span>
   						</li>
   					</ul>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
</body>
</html>