<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/member/mc-companyTable.css" >
<ul class="nav nav-tabs" id="navList">
	<li id="0" class="active"><a href="web/member/businessLicenseAuthen.jsp?content=0">营业执照认证</a></li>
	<li id="1"><a href="web/member/businessLicenseCerti.jsp?content=1">工商执照认证</a></li>
	<li id="2"><a href="web/member/organizationValidation.jsp?content=2">组织机构代码认证</a></li>
	<li id="3"><a href="web/member/accounOpeningLicense.jsp?content=3">开户许可证认证</a></li>
	<li id="4"><a href="web/member/companyCommonAuthen.jsp?content=4">企业银行流水认证</a></li>
	<li id="5"><a href="web/member/companyCommonAuthen.jsp?content=5">实地考察认证</a></li>
	<li id="6"><a href="web/member/taxRegistrationAuthen.jsp?content=6">税务登记认证</a></li>
	<li id="7"><a href="web/member/companyCommonAuthen.jsp?content=7">批文认证</a></li>
	<li id="8"><a href="web/member/companyCommonAuthen.jsp?content=8">监管单位认证</a></li>
	<li id="9"><a href="web/member/companyFreeholdAuthen.jsp?content=9">房产认证</a></li>
	<li id="10"><a href="web/member/companyVitureAuthen.jsp?content=10">车产认证</a></li>
	<li id="11"><a href="web/member/companyCommonAuthen.jsp?content=11">担保考察认证</a></li>
	<li id="12"><a href="web/member/companyCommonAuthen.jsp?content=12">法人身份证认证</a></li>
	<li id="13"><a href="web/member/companyCommonAuthen.jsp?content=13">财务资料认证</a></li>
	<li id="14"><a href="web/member/companyCommonAuthen.jsp?content=14">其它</a></li>
</ul>
<script>
	var num = location.search.slice(9,location.search.length);
	$("#navList li").each(function(){
		if ($(this).attr("id")==num){
			$(this).addClass("active").siblings().removeClass("active");
		}
	});
</script>				