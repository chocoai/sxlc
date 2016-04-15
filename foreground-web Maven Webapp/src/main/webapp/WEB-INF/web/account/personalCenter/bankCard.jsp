<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>银行卡</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/bankCard.css">
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
	   				<!--伍成然2016-4-1  -->
	   				<div class="head">
	   					<div class="title">
	   						银行卡
	   					</div>
	   					<div class="add-bank-card">
	   						<span>+</span>添加银行卡<!--添加背景图  -->
	   					</div>		
	   				</div>
	   				<ul class="card-list">
	   					<li>
	   						<div class="bank-name BOC"><!--中国银行BOC 邮政储蓄银行POSB  -->
	   							<img src="resource/img/account/personalCenter/zjgl_9.png">
	   							中国银行
	   						</div>
	   						<div class="bank-card-num">
	   							6214************123
	   							<span>借记卡</span>
	   						</div>
	   						<div class="deal">
	   							<div class="change">
	   								修改
	   							</div>
	   							<div class="delete">
	   								删除<!--添加背景图  -->
	   							</div>
	   						</div>
	   					</li>
	   					<% for(int j = 0; j<3;j++){ %>
	   					<li>
	   						<div class="bank-name POSB"><!--中国银行BOC 邮政储蓄银行POSB  -->
	   							<img src="resource/img/account/personalCenter/zjgl_9.png">
	   							邮政储蓄银行
	   						</div>
	   						<div class="bank-card-num">
	   							6214************123
	   							<span>借记卡</span>
	   						</div>
	   						<div class="deal">
	   							<div class="change">
	   								修改
	   							</div>
	   							<div class="delete">
	   								删除<!--添加背景图  -->
	   							</div>
	   						</div>
	   					</li>
	   					<% } %>
	   				</ul>
	   				<div class="remind">
	   					<h2>&nbsp;&nbsp;&nbsp;&nbsp;温馨提示</h2><!--添加背景图  -->
	   					<p>1.平台可添加多张银行卡（不支持绑定信用卡），用户今后在提现时，只能使用这张银行卡。<br>
						   2.已绑定的银行卡如需更换，只能换成与原卡相同的账户名。<br>
						   3.请用户尽量填写较大的银行（如农行、工行、建行、中国银行等），避免填写那些比较少见的银行（如农村信用社、
平安银行、恒丰银行等）。否则提现资金很容易会被退票<br>
						   4.请填写完整的联系方式，以便遇到问题时，工作人员可以及时联系到你。</p>
	   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
   	<!--弹出层  -->
   	<div class="addBankCard">
   		<div class="BCremind">亲爱的用户，为了您的财产安全，请认真仔细填写您的银行卡信息</div>
   		<div class="bankcard-top">
   			<div class="input-group">
   				<div class="left-title">用户名:</div>
   				<div class="input-info">1234</div>
   			</div>
   			<div class="input-group">
   				<div class="left-title">真实姓名:</div>
   				<div class="input-info">刘达</div>
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户银行:</div>
   				<div class="selectArea selectArea1">
   					<input class="selectValue" value="0" >
					<input class="selectInput select1" type="text" lang="请选择开户行" readOnly="true"/>
				    <ul class="select" onselectstart="return false">
				        <li class="selectOption" value="1">1<li>
				        <li class="selectOption" value="2">2<li>
				        <li class="selectOption" value="3">3<li>
				        <li class="selectOption" value="4">4<li>
				    </ul>
				</div> 
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户行城市:</div>
   				<div class="selectArea">
   					<input class="selectValue" value="0" >
					<input class="selectInput" type="text" lang="请选择省" readOnly="true"/>
				    <ul class="select" onselectstart="return false">
				        <li class="selectOption" value="1">1<li>
				        <li class="selectOption" value="2">2<li>
				        <li class="selectOption" value="3">3<li>
				        <li class="selectOption" value="5">4<li>
				    </ul>
				</div> 
				<div class="selectArea">
					<input class="selectValue" value="0" >
					<input class="selectInput" type="text" lang="请选择市" readOnly="true"/>
				    <ul class="select" onselectstart="return false">
				        <li class="selectOption" value="1">1<li>
				        <li class="selectOption" value="2">2<li>
				        <li class="selectOption" value="3">3<li>
				        <li class="selectOption" value="4">4<li>
				    </ul>
				</div> 
				<div class="selectArea">
					<input class="selectValue" value="0" >
					<input class="selectInput" type="text" lang="请选择区" readOnly="true"/>
				    <ul class="select" onselectstart="return false">
				        <li class="selectOption" value="1">1<li>
				        <li class="selectOption" value="2">2<li>
				        <li class="selectOption" value="3">3<li>
				        <li class="selectOption" value="5">4<li>
				    </ul>
				</div> 
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户行支行:</div>
   				<input type="text" class="select1" lang="请输入开户行支行" maxlength="25">
   			</div>
   			<div class="input-group">
   				<div class="left-title">银行卡号:</div>
   				<input type="text" class="select1 numberReg cardId1" lang="请输入银行卡号" maxlength="18">
   			</div>
   			<div class="input-group">
   				<div class="left-title">确认银行卡号:</div>
   				<input type="text" class="select1 numberReg cardId2" lang="请再次输入银行卡号" maxlength="18">
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户手机号:</div>
   				<input type="text" class="select1 numberReg phoneBind" lang="请输入开户手机号" maxlength="11">
   			</div>
   		</div>
   		<div class="bankcard-bottom">
   			<input type="button" value="立即添加" class="btn" onclick="layer.closeAll()">
   		</div>
   	</div>
   	<div class="changeBankCard">
   		<div class="BCremind">亲爱的用户，为了您的财产安全，请认真仔细填写您的银行卡信息</div>
   		<div class="bankcard-top">
   			<div class="input-group">
   				<div class="left-title">用户名:</div>
   				<div class="input-info">1234</div>
   			</div>
   			<div class="input-group">
   				<div class="left-title">真实姓名:</div>
   				<div class="input-info">刘达</div>
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户银行:</div>
   				<div class="selectArea selectArea1">
   					<input class="selectValue" value="1" >
					<input class="selectInput select1" type="text" lang="" readOnly="true"/>
				    <ul class="select" onselectstart="return false">
				        <li class="selectOption" value="1">中国银行<li>
				        <li class="selectOption" value="2">2<li>
				        <li class="selectOption" value="3">3<li>
				        <li class="selectOption" value="5">4<li>
				    </ul>
				</div> 
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户行城市:</div>
   				<div class="selectArea">
   					<input class="selectValue" value="1" >
					<input class="selectInput" type="text" lang="" readOnly="true"/>
				    <ul class="select" onselectstart="return false">
				        <li class="selectOption" value="1">四川<li>
				        <li class="selectOption" value="2">2<li>
				        <li class="selectOption" value="3">3<li>
				        <li class="selectOption" value="4">4<li>
				    </ul>
				</div> 
				<div class="selectArea">
					<input class="selectValue" value="1" >
					<input class="selectInput" type="text" lang="" readOnly="true"/>
				    <ul class="select" onselectstart="return false">
				        <li class="selectOption" value="1">成都<li>
				        <li class="selectOption" value="2">2<li>
				        <li class="selectOption" value="3">3<li>
				        <li class="selectOption" value="4">4<li>
				    </ul>
				</div> 
				<div class="selectArea">
					<input class="selectValue" value="1" >
					<input class="selectInput" type="text" lang="" readOnly="true"/>
				    <ul class="select" onselectstart="return false">
				        <li class="selectOption" value="1">郫县<li>
				        <li class="selectOption" value="2">2<li>
				        <li class="selectOption" value="3">3<li>
				        <li class="selectOption" value="4">4<li>
				    </ul>
				</div> 
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户行支行:</div>
   				<input type="text" class="select1" lang="成都武侯支行">
   			</div>
   			<div class="input-group">
   				<div class="left-title">银行卡号:</div>
   				<input type="text" class="select1" lang="6217903100018605618">
   			</div> 		
   			<div class="input-group">
   				<div class="left-title">开户手机号:</div>
   				<input type="text" class="select1" lang="12399809870">
   			</div>
   		</div>
   		<div class="bankcard-bottom">
   			<input type="button" class="btn" value="立即添加" onclick="layer.closeAll()">
   		</div>
   	</div>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/bankCard.js"></script>
</body>
</html>