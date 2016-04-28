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
    <title>登录</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/loginRegister/login.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
    <!-- 在这里加入页面内容 -->
    <!--伍成然2016-3-27-->
    <div class="main">
    <!--图片 -->
    	<img src="resource/img/loginRegister/login-img.png" class="img-background">
    	<!--登录框  -->
    	<form id="loginCheck">
	    	<div class="login-box">
	    		<div class="person-enterprise" >
	    			<div class="radio-select">
						<label class="radio-select1 on">
							<input class="radioclass1" type="radio" checked="checked" name="radio"  value="0">
							个人用户
						</label>
					</div>
					<div class="radio-select">
						<label class="radio-select2">
							<input class="radioclass2" type="radio" name="radio" value="1">
							  企业用户
						</label>
					</div>
	    		</div>
	    		<div class="content1 input-group clearfix">
		    		<div class="inputUserName clearfix">
		    			<input type="text" class="input-user-name" name="userNMae" datatype="logname" value="用户名/手机号" maxlength="16"
						onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
						onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
						style="color:#bfbfbf" />
					</div>
					<div class="inputPassword clearfix">
		    			<input type="password" class="input-password" datatype="regpass" maxlength="16">
		    			<span class="hint">请输入密码</span>
					</div>
					<div class="inputImgCheck clearfix">
						<div class="codeDiv">
			    			<input type="text" class="img-check" datatype="imgcode" value="验证码"  maxlength="6"
							onFocus="if(value==defaultValue){value='';this.style.color='#000';}" 
							onBlur="if(!value){value=defaultValue;this.style.color='#bfbfbf';}" 
							style="color:#bfbfbf" />
							<img src="authImage.html">
						</div>
					</div>
					<div class="checkbox-link clearfix">
						<div class="checkBox">
				        	<label>
				          		<input type="checkbox" class="check-box" name="rememberMe">记住用户名
				       		</label>
				       	</div>	
				       	<div class="forgetPassword"><a href="forgetPWD.html" class="fgPWD">忘记密码?</a><b>&nbsp;|&nbsp;</b><a href="register.html">免费注册</a></div>		      		
			      	</div>
			      	<div class="loginBtn">
			      		<input type="button" class="login-btn" value="登录">
			    	</div>
	    		</div>	
	    	</div>
    	</form>
    	<!--登录框结束  -->
    </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/loginRegister/login.js"></script>
	<script type="text/javascript" src="js/loginRegister/md5.js"></script>
</body>
</html>