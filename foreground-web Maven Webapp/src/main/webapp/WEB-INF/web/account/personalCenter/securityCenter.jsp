<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>安全中心</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/securityCenter.css">
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
   					<div class="thSecurity">
   						<span>安全中心</span>
   					</div>
   					<ul class="securityArea">
   					<!-- 已经做了的过程添加tdAuthen样式，否则添加tdUnauth样式    -->
   						<li class="tdSecurity">
   							<span class="tdFirst">实名认证</span>
   							<span class="tdSpan certification">已验证</span>
   							<span class="tdContent">刘**(6123****4894)</span>
   							<span class="link linkUnauthen"><a href="SC_realNameAuthentication.html">验证</a></span>
   							<span class="link linkAlert certificationSpan"><a href="SC_realNameAuthentication.html">修改</a></span>
   						</li>
   						<li class="tdSecurity">
   							<span class="tdFirst">第三方开户</span>
   							<span class="tdSpan account">已开通</span>
   							<span class="tdContent"></span>
   							<span class="link linkUnauthen accountSpan"><a>开户</a></span>
   						</li>
   						<li class="tdSecurity">
   							<span class="tdFirst">手机绑定</span>
   							<span class="tdSpan">已绑定</span>
   							<span class="tdContent">156****6891</span>
   							<span class="link linkAlert"><a href="SC_phonebinding.html">修改</a></span>
   							<span class="link unbound"><a href="SC_phonebinding.html">绑定</a></span>
   						</li>
   						<li class="tdSecurity">
   							<span class="tdFirst">邮箱绑定</span>
   							<span class="tdSpan">已绑定</span>
   							<span class="tdContent">854***12@99.com</span>
   							<span class="link linkAlert"><a href="SC_emailChange.html">修改</a></span>
   							<span class="link unbound"><a href="SC_emailbinding.html">绑定</a></span>
   						</li>
   						<li class="tdSecurity">
   							<span class="tdFirst">登录密码重置</span>
   							<span class="tdSpan">--</span>
   							<span class="tdContent"></span>
   							<span class="link linkAlert"><a href="SC_resetPWD.html">修改</a></span>
   						</li>
   						<li class="tdSecurity">
   							<span class="tdFirst">二次分配授权</span>
   							<span class="tdSpan">未设置</span>
   							<span class="tdContent"></span>
   							<span class="link linkUnset"><a href="#">设置</a></span>
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
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
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
		<div class="btn">确定</div>
   	</div>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/securityCenter.js"></script>
</body>
</html>