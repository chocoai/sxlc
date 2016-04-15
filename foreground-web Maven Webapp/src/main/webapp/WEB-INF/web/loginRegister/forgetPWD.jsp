<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>忘记密码</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/loginRegister/forgetPWD.css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
    <!-- 在这里加入页面内容 -->
    <!--伍成然2016-3-27  -->
    <div class="main">
    	<div class="forgetPWD-box clearfix">
    		<div class="box-head">找回密码</div>
    		<div class="input-info input-group1 on">
    			<div class="inputUserName clearfix">
    				<div class="left-title">用户名:</div>
	    			<input type="text" class="input-user-name" value="请输入用户名" maxlength="16"
					onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
					onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
					style="color:#bfbfbf">
				</div>
				<div class="inputTelNum clearfix">
					<div class="left-title">手机号码:</div>
	    			<input type="text" class="input-tel-num numberReg" value="请输入手机号" maxlength="11"
					onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
					onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
					style="color:#bfbfbf">
				</div>
				<div class="inputImgCheck clearfix">
					<div class="left-title">图形验证码:</div>
					<div class="registerCode">
	    				<input type="text" class="img-check" maxlength="6">
						<img src="resource/img/loginRegister/7.png">
					</div>
				</div>
				<div class="inputTelCheck clearfix">
					<div class="left-title">手机验证:</div>
					<div class="telCode">
	    				<input type="text" class="tel-check" maxlength="6">
						<input type="button" class="get-tel-check" value="获取验证码">
					</div>
				</div>
				<div class="nextBtn">
		      		<input type="button" class="fogetPWD-btn next-btn" value="下一步">
		    	</div>
    		</div>
    		<div class="input-info input-group2">
    			<div class="inputPWDNew clearfix">
    				<div class="left-title">请输入新密码:</div>
	    			<input type="password" class="password-new" maxlength="16">
	    		</div>
	    		<div class="inputPWDNew2 clearfix">
    				<div class="left-title">请确认新密码:</div>
	    			<input type="password" class="password-new2" maxlength="16">
	    		</div>
	    		<div class="inputImgCheck clearfix">
    				<div class="left-title">图形验证码:</div>
    				<div class="imgCode">
	    				<input type="text" class="img-check" maxlength="6">
	    				<img src="resource/img/loginRegister/7.png">
    				</div>
	    		</div>
	    		<div class="submitBtn">
		      		<input type="button" class="fogetPWD-btn submit-btn" value="确认">
		    	</div>
    		</div>
    		<div class="input-info info">
    			<h2>恭喜，您的密码已修改成功</h2>
    			<p>祝您在四象金融愉快!请<a href="login.html">重新登录</a>您的账户</p>
    		</div> 
    	</div>
    </div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/loginRegister/forgetPWD.js"></script>
</body>
</html>