<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Cookie cookies[]=request.getCookies(); 
		Cookie sCookie=null; 
		String svalue=null; 
		String sname=null; 
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){ 
				sCookie=cookies[i]; 
				sname=sCookie.getName();
				if(sname.equals("UserName")){
					svalue=sCookie.getValue(); 
					 break;
				}
			}
		}
		if(svalue==null){
			svalue="";
		} 
		svalue = URLDecoder.decode(svalue, "utf-8");
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>后台登陆界面</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" type="text/css" href="css/longinInterface.css">
	<link rel="stylesheet" type="text/css" href="css/forget.css">
	<script type="text/javascript" src="js/md5.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/valid.js"></script>
	
	<script type="text/javascript">
		//刷新图形验证码参数
		var currentTimeMillis = "<%=System.currentTimeMillis()%>";
	</script>	    
</head>

<body class="nav-md">
	<div class="container body">
		<div class="longinTop">
			<div class="loginTopContent">
				<div class="longinTopFont longinTopImage eXingLogo i-fl">
					<span class="">e兴金融后台管理系统</span>
				</div>
				<div class="loginTopR i-fl">
					<div class="longinTopStyle longinTopImage productLogo">
						<h2>四象金融系统</h2>
						<span>-中国最安全的互联网金融系统服务商-</span>
					</div>
				</div>
			</div>
		</div>
		<div class="longinContent">
			<div class="administratorLoginCunt forget">
				<div class="loginW">
					<div class="administratorLogin">忘记密码</div>
					<form action="" id="forget_pass">
						<div class="admUser">
							<i class="loginIcon user"></i>
							<input type="text"  placeholder="手机号" name="adminPhone" id="adminPhone" maxlength="11" value="<%=svalue %>" onkeyup='this.value=this.value.replace(/\D/gi,"")'>
						</div>
						<div class="admPhoneCode">
							<i class="loginIcon phone"></i>
							<input type="text"   name="code" id="Yancode"  maxlength="4" placeholder="验证码" ><!--onkeyup='this.value=this.value.replace(/\D/gi,"")'  -->
							<img alt="点击刷新" id="vCodeImg" style="width: 90px;height:30px" class="img" title="点击刷新" src="authImage.do?tt=<%=System.currentTimeMillis()%>" onclick="refreshImg('vCodeImg');">
							<b style="display:none;margin-top:68px" id="getYan" class="getYan">验证码已发送!</b>
						</div>
						<div class="admPasword">
							<i class="loginIcon phone1"></i>
							<input type="text"  name="adminPwd" id="adminPwd" maxlength="6" placeholder="手机验证码" onkeyup='this.value=this.value.replace(/\D/gi,"")'>
							<img alt="获取验证码" id="yanzheng" style="width: 110px;height:30px;top:248px" class="img"  src="" onclick="Yanzheng()">
						</div>
						<div class="admPhoneCode1">
							<i class="loginIcon pwd"></i>
							<input type="password"  name="password1"  id="Pwdcode"  maxlength="22" placeholder="新密码">
						</div>
						<div class="admPhoneCode1">
							<i class="loginIcon pwd"></i>
							<input type="password"  name="code" id="rePwdcode"  maxlength="22" placeholder="确认新密码">
						</div>
						<div class="tijiao_change">
							<input type="hidden" id="adminId">
							<button type="button" id="Change-Btn" class="admRestL btn">提交</button>
							<button type="button" id="" class="admRestL btn" onclick="history.go(-1)">取消</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="longinBottom">
			<p>Copyright(c)蜀ICP备10201230号-1 成都四象联创科技有限公司  .All rights reserved.</p>
			<p>技术支持 ：成都四象联创客户有限公司</p>
		</div>
	</div>
	
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<!-- 私用js -->
	<script type="text/javascript"  charset="UTF-8" src="js/forget_pwd.js"></script>
</body>