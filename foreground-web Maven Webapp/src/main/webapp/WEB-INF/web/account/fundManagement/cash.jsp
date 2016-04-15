<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>我要提现</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/fundManagement/cash.css">
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
   				<!-- 李丽梅 -->
   				<!-- 我要提现 -->
   				<!-- 2016-03-30 -->
   					<div class="cashHead">
   						<span class="cashHeadFont">我要提现</span>
   					</div>
   					<div class="cashContent">
	  					<div class="cashContentCunt">
							<div class="cashDivDistance">
								<label class="cashLabel">联系人姓名：</label>
								<span class="cashAllFont">刘***</span>
							</div>
							<div class="cashDivDistance">
								<label class="cashLabel">联系人手机：</label>
								<span class="cashAllFont">135********</span>
							</div>
							<div class="cashBank clearfix">
								<label class="cashLabel i-fl">提现至银行卡：</label>
								<ul class="clearfix">
								<%for(int i = 0;i<9;i++){ %>
									<li class="">
										<input type="radio" name="cashBankLi" id="cashBankLi<%=i %>" class="cashInputRadio">
										<label for="cashBankLi<%=i %>" onselectstart="return false" class="cashBankLiOne">
											<img class="cashImgSign" alt="这是图片" src="resource/img/account/fundManagement/zjgl_9.png">
											<span>中国银行(523)</span>
										</label>
									</li>
								<%} %>
									<li class="addBank cashBankLiSolid">
										<img class="cashImgSign" alt="这是图片" src="resource/img/account/fundManagement/zjgl_plus_03.png">
										<span>添加银行卡</span>
									</li>
								</ul>
							</div>
							<div class="cashDivDistance cashClear">
								<label class="cashLabel">可提现金额：</label>
	  							<span class="cashSpan cashAllFont moneyFormat">100000000</span>
	  							<span>元</span>
							</div>
							<div class="cashDivDistance">
								<label class="cashLabel">提现金额：</label>
	  							<div class="amount"><input class="cashInput cashInput1 format cashFormat"  type="text" lang="请输入提现金额" maxlength="10"><span class="cashDistance">元</span></div>
							</div>
							<div class="cashDivDistance">
								<label class="cashLabel ">手续费：</label>
								<span class="cashAllFont cashAllFont moneyFormat">0</span>
	  							<span>元</span>
							</div>
							<div class="cashDivDistance cashFontStyle">
								<label class="cashLabel">实际到账金额：</label>
								<span class="cashAllFont moneyFormat">100000000</span>
	  							<span >元</span>
							</div>
							<div class="cashDivDistance">
								<label class="cashLabel">备注：</label>
								<input class="cashInput" type="text" lang="请输入备注内容" maxlength="25">
							</div>
							<div class="cashPhone">
								<label class="cashLabel">手机验证码：</label>
								<div class="cashPhoneCodeGet">
	 								<input class="cashCodeGet" type="text" lang="请输入验证码" maxlength="6">
	 								<span class="codeGet">获取验证码</span>
	 							</div>
							</div>
	  						<div class="btn cashBtn" onselectstart="return false"><span>提现</span></div>
	  					</div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/fundManagement/cash.js"></script>
</body>
</html>