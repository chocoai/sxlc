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
    <title>我要充值</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/fundManagement/recharge.css">
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
   					<!-- 李丽梅 -->
   					<!-- 我要充值 -->
   					<!-- 2016-03-30 -->
   					<div class="rechargeHead">
   						<span class="rechargeHeadFont">我要充值</span>
   					</div>
   					<div class="rechargeContent">
						<form id="chongZhi">
							<ul>
							<li class="rechargeContentLi_one">
								<label>充值方式：</label>
								<div class="selectArea rechargeSelect clearfix">
									<input class="selectValue" value="1" >
   									<input class="selectInput rechargeMethod" type="text" lang="" readOnly="true"/>
								    <ul class="select" onselectstart="return false">
								        <li class="selectOption selectOptionAab" value="1">个人网银<li>
								        <li class="selectOption selectOptionAab" value="2">汇款充值<li>
								        <li class="selectOption selectOptionAab" value="3">快捷支付<li>
								        <li class="selectOption selectOptionAab" value="4">企业网银<li>
								    </ul>
								</div>
							</li>
							<li class="rechargeContentLi">
								<label>充值金额：</label>
								<div class="amount"><input  class="rechargeInput rechargeInputFocus format cashFormat" type="text" lang="请输入充值金额" maxlength="10"><span class="rechargeDistance">元</span></div>					
							</li>
							<li class="rechargeContentLi">
								<label>备注：</label>
								<input class="rechargeInput rechargeRemarks" type="text" lang="请输入备注内容" maxlength="25">
							</li>
							<li class="rechargeContentLi">
								<label>支付充值费用：</label>
								<span class="rechargeSpan moneyFormat">10</span>
								<span>元</span>
							</li>
							<li class="rechargeContentLi">
								<label>实际到账金额：</label>
								<span class="rechargeSpan rechargeSpanFont moneyFormat">100000000</span>
								<span class="rechargeSpanFont">元</span>
							</li>
						</ul>
   						<div class="btn rechargeBtn" onselectstart="return false"><span>充值</span></div>
						</form>
   					</div>
   					<div class="rechargeButtom">
   						<div class="rechargeButtomCunt">
	   						<div class="rechargeReminder">
	   							<i></i>
	   							<span>温馨提示</span>
	   						</div>
	   						<div class="rechargeDetails">
	   							<p>1、充值功能，必须保证已经【开通】第三方账号，才可以进行充值。</p>
	   							<p>2、所有投标保证金将由第三方平台托管。</p>
	   							<p>3、平台禁止信用卡套现、虚假交易等行为，一经发现将予以处罚，包括但不限于：限制收款、冻结账号，永久停止等。</p>
	   							<p>4、快捷支付充值收取充值金额1‰的充值费用(至少收取1元费用)；企业网银、汇款充值收取20/笔的充值费用。</p>
	   						</div>
   						</div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/fundManagement/recharge.js"></script>
</body>
</html>