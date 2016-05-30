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
    <title>我的好友-转账</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>    
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<script type="text/javascript" src="http://img3.job1001.com/js/ZeroClipboard/jquery.zclip.min.js"></script> 
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/friendManagement.css">
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
   					<div class="transferHeader">
	   					<span><a href="/foreground-web/personalCenter/friendManagement.html">我的好友</a> — 转账</span>
	   				</div>
					<input type="hidden" id="phone">
   					<div class="transferContent">
						<form id="transfer"  action="friendTransfer/friendTransfer.html" method="post" target="_blank">
							<input type="hidden" id="friendId"  value="${friendId }">
							<input type="hidden"  name="friendId" >
			   				<ul class="inputArea">
			   					<li class="inputList">
			   						<div class="mustLabel"><span>收款人用户名：</span></div>
			   						<div class="resiveName">${friendName }</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>可转账金额：</span></div>
			   						<div class="resiveName"><samp id="userBalance" class="moneyFormat">0</samp>元</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>转账金额：</span></div>
			   						<input id="amount" class="inputText" datatype="acountM" type="text" lang="请输入转账金额" maxlength="20"/>
			   						<input name="amount" type="hidden"> 
			   					</li>
			   					<li class="inputList">
									<div class="mustLabel"><span>备注：</span></div>
									<input id="remark" class="inputText rechargeRemarks" type="text" datatype="reMarks" ignore="ignore" lang="请输入备注内容" maxlength="200">
									<input name="remark" type="hidden"> 
								</li>
								<li class="inputList">
			   						<div class="mustLabel"><span>验证码：</span></div>
			   						<div class="phoneCode">
			   							<input id="imgCode" class="code imgCode" type="text" lang="请输入验证码" datatype="imgcode" maxlength="6" >
			   							<img class="codeImg" src="authImage.html?type=3">
			   						</div>
			   						<input name="imgCode" type="hidden"> 
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>手机验证码：</span></div>
			   						<div class="dynamicValidationPhone">
			   							<input id="code" class="code codeGet dynamicCode" type="text" lang="请输入验证码" datatype="Z6" maxlength="6" >
			   							<div class="codeBtn">获取验证码</div>
			   						</div>
			   						<input name="code" type="hidden"> 
			   					</li>
	   					        <li class="inputList">
			   						<div class="btn transferBtn1">确认转账</div>
			   					</li>
			   				</ul>
		   				</form>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<!-- <script type="text/javascript" src="js/account/personalCenter/friendManagement.js"></script> -->
	<script type="text/javascript" src="js/account/personalCenter/friendManagementTransfer.js"></script>
</body>
</html>