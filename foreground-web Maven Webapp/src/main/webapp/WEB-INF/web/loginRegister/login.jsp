<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>登录</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/loginRegister/login.css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
    <!-- 在这里加入页面内容 -->
    <!--伍成然2016-3-27-->
    <div class="main">
    <!--图片 -->
    	<img src="resource/img/loginRegister/login-img.png" class="img-background">
    	<!--登录框  -->
    	<div class="login-box">
    		<div class="person-enterprise" >
    			<div class="radio-select">
					<label class="radio-select1 on">
						<input class="radioclass1" type="radio" name="radio" value="option1">
						个人用户
					</label>
				</div>
				<div class="radio-select">
					<label class="radio-select2">
						<input class="radioclass2" type="radio" name="radio" value="option2">
						  企业用户
					</label>
				</div>
    		</div>
    		<div class="input-group clearfix">
	    		<div class="inputUserName clearfix">
	    			<input type="text" class="input-user-name" value="用户名/手机号" maxlength="16"
					onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
					onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
					style="color:#bfbfbf" />
				</div>
				<div class="inputPassword clearfix">
	    			<input type="password" class="input-password" maxlength="16">
	    			<span class="hint">请输入密码</span>
				</div>
				<div class="inputImgCheck clearfix">
					<div class="codeDiv">
		    			<input type="text" class="img-check" value="验证码"  maxlength="6"
						onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
						onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
						style="color:#bfbfbf" />
						<img src="resource/img/loginRegister/7.png">
					</div>
				</div>
				<div class="checkbox-link clearfix">
					<div class="checkBox">
			        	<label>
			          		<input type="checkbox" class="check-box">记住用户名
			       		</label>
			       	</div>	
			       	<div class="forgetPassword"><a href="forgetPWD.html" class="fgPWD">忘记密码?</a><b>&nbsp;|&nbsp;</b><a href="register.html">免费注册</a></div>		      		
		      	</div>
		      	<div class="loginBtn">
		      		<input type="button" class="login-btn" value="登录">
		    	</div>
    		</div>	
    	</div>
    	<!--登录框结束  -->
    </div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/loginRegister/login.js"></script>
</body>
</html>