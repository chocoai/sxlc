<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/member/mc-companyTable.css" >
<ul class="nav nav-tabs" id="navList">
	<li id="12" class="active"><a href="web/member/businessLicenseAuthen.jsp?content=12">营业执照认证</a></li>
	<li id="13"><a href="web/member/businessLicenseCerti.jsp?content=13">工商执照认证</a></li>
	<li id="14"><a href="web/member/organizationValidation.jsp?content=14">组织机构代码认证</a></li>
	<li id="15"><a href="web/member/accounOpeningLicense.jsp?content=15">开户许可证认证</a></li>
	<li id="16"><a href="web/member/companyCommonAuthen.jsp?content=16">企业银行流水认证</a></li>
	<li id="17"><a href="web/member/companyCommonAuthen.jsp?content=17">实地考察认证</a></li>
	<li id="18"><a href="web/member/taxRegistrationAuthen.jsp?content=18">税务登记认证</a></li>
	<li id="19"><a href="web/member/companyCommonAuthen.jsp?content=19">批文认证</a></li>
	<li id="20"><a href="web/member/companyCommonAuthen.jsp?content=20">财务资料认证</a></li>
	<li id="21"><a href="web/member/companyCommonAuthen.jsp?content=21">监管单位认证</a></li>
	<li id="22"><a href="web/member/companyFreeholdAuthen.jsp?content=22">房产认证</a></li>
	<li id="23"><a href="web/member/companyVitureAuthen.jsp?content=23">车产认证</a></li>
	<li id="24"><a href="web/member/companyCommonAuthen.jsp?content=24">担保考察认证</a></li>
	<li id="25"><a href="web/member/companyCommonAuthen.jsp?content=25">法人身份证认证</a></li>
	<li id="26"><a href="web/member/companyCommonAuthen.jsp?content=26">其它</a></li>
</ul>
<script>
	var num = location.search.slice(9,location.search.length);
	$("#navList li").each(function(){
		if ($(this).attr("id")==num){
			$(this).addClass("active").siblings().removeClass("active");
		}
	});
</script>				