<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>营业执照认证</title>
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
   					 <div class="authenHeader">
	   					<span>营业执照认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
   					<div class="authenContent">
	   					<div class="authen">
			   				<ul class="inputArea">
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>营业执照号码：</span></div>
			   						<input class="inputText numberReg" type="text" lang="请输入营业执照号码" maxlength="15"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>注册地址：</span></div>
			   						<input class="inputText" type="text" lang="请输入注册地址" maxlength="25"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>注册法人：</span></div>
			   						<input class="inputText" type="text" lang="请输入注册法人" maxlength="25"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>注册资金：</span></div>
			   						<input class="inputText format" type="text" lang="请输入注册资金" maxlength="12"/>
			   						<span class="unitPrice">元</span>
			   					</li>
			   					
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>经营范围：</span></div>
			   						<input class="inputText" type="text" lang="请选择经营范围" maxlength="25"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>公司类型：</span></div>
			   						<input class="inputText" type="text" lang="请输入公司类型" maxlength="25"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>注册时间：</span></div>
			   						<input class="inputText dateSelect Wdate" onfocus="WdatePicker()" type="text" lang="请选择注册时间"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>有效期：</span></div>
			   						<input class="inputText dateSelect Wdate" onfocus="WdatePicker()" type="text" lang="请选择有效期"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="btn">确认并保存</div>
			   					</li>
			   				</ul>
	   					</div>
	   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
</body>
</html>