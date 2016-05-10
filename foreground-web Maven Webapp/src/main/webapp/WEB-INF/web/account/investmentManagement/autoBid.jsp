<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">s
    <title>自动投标</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/investmentManagement/autoBid.css">
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
   				<!-- 主体部分开始 王延君 2016-04-01 -->
   				<div class="autoBid">
   					<div class="autoBidtH">
	   					<div class="autoBidT">自动投标</div>
	   				</div>
	   				<div class="autoBidtM">
	   					<div class="autoBidtMTip"><label></label>尊敬的用户，我们将根据您的设置，自动进行投标</div>
	   					<div class="autoBidtArtical">
	   						<p>自动投标规则<br>
								1.新标上线即会在5分钟之内启动自动投标功能；<br>
								2.自动投标设定之后，系统将严格按照用户预先设定执行，请谨慎操作。<br>
								3.投标排序规则如下：<br>
							</p>
							<p class="requir">a ) 投标顺序按照开启自动投标的时间先后进行排序；<br></p>
							<p class="requir">b ) 每个用户投标后，重新回到队尾，依次循环进行投标；<br>
							<p class="requir">c ) 轮到用户进行投标时，若没有标符合用户设置的自动投标条件，视为自动放弃此次投标机会，重新排队；<br>
							<p class="requir">d ) 轮到用户投标时，若同时有多个标符合自动投标设置，则按照优先级根据用户第一条设置进行投标；</p>	     
	   					</div>
	   					<div class="allowBid">
	   						<div class="allowBidBtn">授权自动投标</div>
	   					</div>
	   				</div>
   				</div>
   				<!-- 主体部分结束 王延君 2016-04-01 -->
   				</div>
   			</div>
   			<div class="autoBidtList">
	   			<div class="myInvestmentM">
	   				<div class="myInvestmentMH">列表信息</div>
	   					<ul class="revenueRecordUl">
	   						<li>
	   							<div class="myInvestmentMTitle">
						   			<div class="terms">产品类型</div>
						   			<div class="receivablePrincipal">项目期限</div>
						   			<div class="interestReceivable">年化利率</div>
						   			<div class="scheduledPaymentDate">还款方式</div>
						   			<div class="principalInterestPaid">预留金额</div>
						   			<div class="overdueIncome">投标金额</div>
						   			<div class="actualPaymentDate">操作</div>
			   					</div>
	   						</li>
	   						<c:if test="${automaticBidSettingEntity != null }">
	   							<li>
		   							<div class="terms divOutside">
				   						<div class="divIntside">
				   							<div>${automaticBidSettingEntity.proTypesString }</div>
				   						</div>
				   					</div>
				   					<div class="receivablePrincipal divOutside">
				   						<div class="divIntside">
				   							<div>2个月</div>
				   						</div>
				   					</div>
				   					<div class="interestReceivable divOutside">
				   						<div class="divIntside">
				   							<div>${automaticBidSettingEntity.rateMin }%-${automaticBidSettingEntity.rateMax }%</div>
				   						</div>
				   					</div>
				   					<div class="scheduledPaymentDate divOutside">
				   						<div class="divIntside">
				   							<div>${automaticBidSettingEntity.proType }</div>
				   						</div>
				   					</div>
				   					<div class="principalInterestPaid divOutside">
				   						<div class="divIntside">
				   							<div class="moneyFormat">${automaticBidSettingEntity.sReservedMoney }</div>
				   						</div>
				   					</div>
				   					<div class="overdueIncome divOutside">
				   						<div class="divIntside">
				   							<div class="moneyFormat">${automaticBidSettingEntity.sEveryMoney }</div>
				   						</div>
				   					</div>
				   					<div class="actualPaymentDate divOutside">
				   						<div class="divIntside">
				   							<div class="highLight"><a class="highLight">删除</a></div>
				   						</div>
				   					</div>
		   						</li>
	   						</c:if>
	   				</ul>
	   			</div>
	   		</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<!--弹出层伍成然2016-4-6  -->
   	<div class="autoBidSet">
   		<form id="touBao">
	   	<div class="auto-top">
	   		<div class="info-input">
	   			<div class="left-title">账户可用余额:</div>
	   			<div class="orange">${authInfoEntity.memberThirdInfoEntity.userBalances }元</div>
	   		</div>
	   		<div class="info-input info  clearfix">
	   			<div class="left-title ">借款类型:</div>
	   			<label class="quanBu att1 active"><input type="checkbox" class="proType" value="-1" checked>全部</label>
	   			<c:forEach items="${projectTypes }" var="pt">
					<label class="att1 active"><input type="checkbox" class="proType" value="${pt.id }" checked>${pt.projectName }</label>
	   			</c:forEach>
	   		</div>
	   		<div class="info-input1 info clearfix">
	   			<div class="left-title ">还款方式:</div>
	   			<div class="input-group-out">
		   			<label class="quanBu active"><input type="checkbox" class="loanType"  value="-1" checked>全部</label>
					<label class="active"><input type="checkbox" class="loanType"  value="3" checked>等额本金</label>
					<label class="active"><input type="checkbox" class="loanType"  value="0" checked>等额本息</label>
					<label class="active"><input type="checkbox" class="loanType"  value="1" checked>先息后本</label>
					<label class="active"><input type="checkbox" class="loanType" value="2" checked>到期还本息</label>
	   			</div>			
	   		</div>
	   		<div class="info-input2">
	   			<div class="left-title">项目期限:</div>
	   			<div class="input-group-out">
		   			<div class="input-group">
		   				<input  class="numberReg numberReg1" id="yearMin" type="text" maxlength="4">
		   				<span>-</span>
		   				<input  class="numberReg numberReg2" id="yearMax" type="text" maxlength="4">
		   				<span class="spanTwo">年</span>
		   			</div>
		   			<div class="input-group">
		   				<input  class="numberReg numberReg1" id="monthMin" type="text" maxlength="2">
		   				<span>-</span>
		   				<input  class="numberReg numberReg2" id="monthMax" type="text" maxlength="2">
		   				<span class="spanTwo">月</span>
		   			</div>
		   			<div class="input-group">
		   				<input class="numberReg numberReg1" type="text" id="dayMin" maxlength="2">
		   				<span>-</span>
		   				<input class="numberReg numberReg2" type="text" id="dayMax" maxlength="2">
		   				<span class="spanTwo">日</span>
		   			</div>
	   			</div>
	   		</div>
	   		<div class="info-input">
	   			<div class="left-title">年化利率:</div>
	   			<div class="input-group2">
	   				<input type="text" class="yearText1" id="rateMin" maxlength="5">
	   				<span>-</span>
	   				<input type="text" class="yearText2" id="rateMax" maxlength="5">
	   				<span>%</span>
	   			</div>
	   		</div>
	   		<div class="info-input3 info-input33">
	   			<div class="left-title">每次投标金额:</div>
	   			<input datatype="acountM" class="format" type="text" id="everyMoney" lang="请输入每次投标金额" maxlength="10">
	   			<span>元</span>
	   		</div>
	   		<div class="remind">
	   			&nbsp;&nbsp;&nbsp;&nbsp;0表示投资金额为账户可用余额-最低预留金额
	   		</div>
	   		<div class="info-input3 info-input34">
	   			<div class="left-title">最低预留金额:</div>
	   			<input class=" formatM" datatype="acountM" type="text" id="reservedMoney" lang="请输入最低预留金额" maxlength="10">
	   			<span>元</span>
	   		</div>
   		</div>
   		<div class="auto-bottom">
   			<input type="button" class="autoBtn" value="确定" >
   		</div>
   		</form>
   	</div>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/investmentManagement/autoBid.js"></script>
</body>
</html>