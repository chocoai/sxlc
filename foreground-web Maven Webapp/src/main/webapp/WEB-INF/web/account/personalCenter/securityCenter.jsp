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
    <title>安全中心</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/securityCenter.css">
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
   					<div class="thSecurity">
   						<span>安全中心</span>
   					</div>
   					<ul class="securityArea">
   					<!-- 已经做了的过程添加tdAuthen样式，否则添加tdUnauth样式    -->
   						<c:if test="${loginUser.memberType == 0 }">
	   						<li class="tdSecurity">
	   							<span class="tdFirst">实名认证</span>
	   							<span class="tdSpan certification">
		   							<c:if test="${securityInfo.realNameStatus == 0 }">未验证</c:if>
		   							<c:if test="${securityInfo.realNameStatus == 1 }">审核中</c:if>
		   							<c:if test="${securityInfo.realNameStatus == 2 }">已验证</c:if>
		   							<c:if test="${securityInfo.realNameStatus == 3 }">已打回</c:if>
		   							<c:if test="${securityInfo.realNameStatus == 3 }">已过期</c:if>
	   							</span>
	   							<span class="tdContent">${securityInfo.realName}</span>
								<c:if test="${securityInfo.realNameStatus == 0 }">
		   							<span class="link linkUnauthen"><a href="personalCenter/authInfo/1.html">认证</a></span>
								</c:if>
	   							<c:if test="${securityInfo.realNameStatus == 1 }">
	   								<span class="link linkAlert certificationSpan"><a href="personalCenter/SC_realNameAuthentication.html">修改</a></span>
	   							</c:if>
	   						</li>
	   						<li class="tdSecurity">
	   							<span class="tdFirst">第三方开户</span>
	   							<span class="tdSpan account">
	   								<c:if test="${securityInfo.thirdStatus == 0 }">未开通</c:if>
	   								<c:if test="${securityInfo.thirdStatus == 2 }">已开通</c:if>
	   							</span>
	   							<span class="tdContent">${securityInfo.thirdPartyAccount}</span>
	   							<span class="link linkUnauthen accountSpan">
		   							<c:if test="${securityInfo.thirdStatus == 0 && (securityInfo.realNameStatus == 1 || securityInfo.realNameStatus == 2) }">
			   							<a href="personalCenter/openAccount.html">开户</a>
		   							</c:if>
	   							</span>
   							</li>
	   					</c:if>
	   					<c:if test="${loginUser.memberType == 1 }">
	   						<li class="tdSecurity">
	   							<span class="tdFirst">营业执照认证</span>
	   							<span class="tdSpan certification">
		   							<c:if test="${businessInfo.status == 0 }">未验证</c:if>
		   							<c:if test="${businessInfo.status == 1 }">审核中</c:if>
		   							<c:if test="${businessInfo.status == 2 }">已验证</c:if>
		   							<c:if test="${businessInfo.status == 3 }">已打回</c:if>
		   							<c:if test="${businessInfo.status == 3 }">已过期</c:if>
	   							</span>
	   							<span class="tdContent">${businessInfo.Firm_BLN}</span>
	   							<c:if test="${businessInfo.status == 0 }">
	   								<span class="link linkUnauthen"><a href="personalCenter/authInfo/12.html">认证</a></span>
	   							</c:if>
	   							<c:if test="${businessInfo.status == 1 }">
		   							<span class="link linkAlert certificationSpan"><a href="personalCenter/SC_realNameAuthentication.html">修改</a></span>
	   							</c:if>
	   						</li>
	   						
	   						<li class="tdSecurity">
	   							<span class="tdFirst">第三方开户</span>
	   							<span class="tdSpan account">
	   								<c:if test="${securityInfo.thirdStatus == 0 }">未开通</c:if>
	   								<c:if test="${securityInfo.thirdStatus == 2 }">已开通</c:if>
	   							</span>
	   							<span class="tdContent">${securityInfo.thirdPartyAccount}</span>
	   							<span class="link linkUnauthen accountSpan">
	   								<c:if test="${securityInfo.thirdStatus == 0 && (businessInfo.status == 1 || businessInfo.status == 2)}">
		   								<a href="personalCenter/openAccount.html">开户</a>
	   								</c:if>
	   							</span>
   							</li>
	   					</c:if>
   						<li class="tdSecurity">
   							<span class="tdFirst">手机绑定</span>
   							<span class="tdSpan">
   								<c:if test="${securityInfo.phoneStatus == 0 }">未绑定</c:if>
   								<c:if test="${securityInfo.phoneStatus == 2 }">已绑定</c:if>
   							</span>
   							<span class="tdContent">${securityInfo.personalPhone}</span>
							<c:if test="${securityInfo.phoneStatus == 2 }">
								<span class="link linkAlert"><a href="personalCenter/SC_phonebinding.html">修改</a></span>
							</c:if>
   							<c:if test="${securityInfo.phoneStatus == 0 }">
   								<span class="link unbound"><a href="personalCenter/SC_phonebinding.html">绑定</a></span>
   							</c:if>
   						</li>
   						<li class="tdSecurity">
   							<span class="tdFirst">邮箱绑定</span>

   							<span class="tdSpan">
   								<c:if test="${securityInfo.emailStatus == 0 }">未绑定</c:if>
   								<c:if test="${securityInfo.emailStatus == 2 }">已绑定</c:if>
   							</span>
   							<span class="tdContent">${securityInfo.personalEmail }</span>
							<c:if test="${securityInfo.emailStatus == 2 }">
	   							<span class="link linkAlert"><a href="personalCenter/SC_emailChange.html">修改</a></span>
							</c:if>
							<c:if test="${securityInfo.emailStatus == 0 }">
	   							<span class="link unbound"><a href="personalCenter/SC_emailbinding.html">绑定</a></span>
							</c:if>
   						</li>
   						<li class="tdSecurity">
   							<span class="tdFirst">登录密码重置</span>
   							<span class="tdSpan">--</span>
   							<span class="tdContent"></span>
   							<span class="link linkAlert"><a href="personalCenter/SC_resetPWD.html">修改</a></span>
   						</li>
   						<li class="tdSecurity">
   							<span class="tdFirst">二次分配授权</span>
   							<span class="tdSpan"><c:if test="${securityInfo.openSecondDistribute == 0}">未绑定</c:if><c:if test="${securityInfo.openSecondDistribute == 1}">已绑定</c:if></span>
   							<span class="tdContent"></span>
   							<span class="link linkUnset">
   								<c:if test="${securityInfo.openSecondDistribute == 0}">
		   							<a href="personalCenter/authorized.html">设置</a>
   								</c:if>
		   					</span>
   						</li>
   						<li class="tdSecurity">
   							<span class="tdFirst">登录验证方式</span>
   							<span class="tdSpan">已选择</span>
   							<span class="tdContent">手机验证</span>
   							<span class="link linkAlert"><a class="changeValidate">修改</a></span>
   						</li>
   					</ul>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<div class="validateMethod">
	   	<div class="selectValidate">
	   		<div class="radio-select">
				<label class="radio-select1 on">
				<input class="radioclass1" type="radio" name="optionsRadios" value="option1" checked="checked">
				   手机验证码
				</label>
			</div>
			<div class="radio-select">
				<label class="radio-select2 ">
				<input class="radioclass2" type="radio" name="optionsRadios" value="option2">
				    图形验证码
				</label>
			</div>
	   	</div>	   	
		<div class="comfirmBtn btn">确定</div>	
   	</div>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/securityCenter.js"></script>
</body>
</html>