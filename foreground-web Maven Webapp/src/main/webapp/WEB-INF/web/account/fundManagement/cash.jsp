<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>我要提现</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>    
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/fundManagement/cash.css">
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
   				<!-- 我要提现 -->
   				<!-- 2016-03-30 -->
   					<div class="cashHead">
   						<span class="cashHeadFont">我要提现</span>
   					</div>
   					<div class="cashContent">
	  					<div class="cashContentCunt">
							<div class="cashDivDistance">
								<c:set value="${loginUser.personalBaseInfo.personalName}" scope="session" var="name"></c:set>
								<label class="cashLabel">联系人姓名：</label>
								<span class="cashAllFont">${fn:substring(name,0,1)}**</span>
							</div>
							<div class="cashDivDistance">
								<c:set value="${loginUser.personalBaseInfo.personalPhone}" scope="session" var="phone"></c:set>
								<label class="cashLabel">联系人手机：</label>
								<span class="cashAllFont">${fn:substring(phone,0,3)}*******</span>
							</div>
							<div class="cashBank clearfix">
								<label class="cashLabel i-fl">提现至银行卡：</label>
								<ul class="clearfix" id="withdrawBank" >
								<script id="withdrawBankList" type="text/html" >
									{{each bankCardList as value index}}	
									<li>
										<input type="radio" name="cashBankLi" {{if index==0}} checked="checked" {{/if}}  value="{{value.bankCardId}}" id="cashBankLi{{index+1}}" class="cashInputRadio">
										<label for="cashBankLi{{index+1}}" onselectstart="return false" value="{{index+1}}" class="cashBankLiOne">
											<img class="cashImgSign" alt="这是图片" src="resource/img/account/fundManagement/zjgl_9.png">
											<span>{{value.bankName}}({{value.bankCardInfoEntity.bankNo.substring(value.bankCardInfoEntity.bankNo.length-3,value.bankCardInfoEntity.bankNo.length)}})</span>
										</label>
									</li>
									{{/each}}
									<li class="addBank cashBankLiSolid">
										<img class="cashImgSign" alt="这是图片" src="resource/img/account/fundManagement/zjgl_plus_03.png">
										<span><a href="personalCenter/bankCard.html">添加银行卡</a></span>
									</li>
								</script>	
								</ul>
							</div>
							<input class="feeType" type="hidden">
							<input class="fee" type="hidden">
							<input class="feePingtai" type="hidden">
							<form id="tiXian" action="loanWithdraw/loanWithdraw.html" method="post"   target="_blank">
							<div class="cashDivDistance cashClear">
								<label class="cashLabel">可提现金额：</label>
	  							<span class="cashSpan cashAllFont moneyFormat userBalance ">0</span>
	  							<span>元</span>
							</div>
							<div class="cashDivDistance">
								<label class="cashLabel">提现金额：</label>
	  							<div class="amount"><input datatype="acountM" class="cashInput cashInput1"  type="text" lang="请输入提现金额" maxlength="8"><span class="cashDistance">元</span></div>
							</div>
							<div class="cashDivDistance">
								<label class="cashLabel ">手续费：</label>
								<span class="cashAllFont cashAllFont moneyFormat moneyFormat1 feeAmount">2</span>
	  							<span>元</span>
							</div>
							<div class="cashDivDistance cashFontStyle">
								<label class="cashLabel">实际到账金额：</label>
								<span class="cashAllFont moneyFormat moneyZhang">0</span>
	  							<span >元</span>
							</div>
							<div class="cashDivDistance">
								<label class="cashLabel">备注：</label>
								<input class="cashInput beiZhu" ignore="ignore" type="text" lang="请输入备注内容" maxlength="25">
							</div>
							<div class="cashPhone">
								<label class="cashLabel">手机验证码：</label>
								<div class="cashPhoneCodeGet">
	 								<input class="cashCodeGet" datatype="Z6" type="text" lang="请输入验证码" maxlength="6">
	 								<span class="codeGet">获取验证码</span>
	 							</div>
							</div>
	  						<input type="submit" class="btn cashBtn" onselectstart="return false" value="提现">
		   					<input type="hidden" name="amount" />
		   					<input type="hidden" name="remark" />
		   					<input type="hidden" name="bankCardId" />
		   					<input type="hidden" value="${sessionScope.loginUser.personalBaseInfo.personalPhone}" name="phone" />
		   					<input type="hidden" name="code" />
		   					<input type="hidden" name="sign" />	  						
	  						</form>
	  					</div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/fundManagement/cash.js"></script>
	<script type="text/javascript" src="js/account/fundManagement/cash_data.js"></script>
</body>
</html>