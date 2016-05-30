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
    <title>银行卡</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/bankCard.css">
	
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	
   	<script type="text/javascript" src="js/common/template.js"></script>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
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
	   				<ul class="card-list" id="bankListSelect">
					<script id="bankList" type="text/html">
					{{each data as value index}}
	   					<li>
	   						<div class="bank-name BOC"><!--中国银行BOC 邮政储蓄银行POSB  -->
	   							<img src="resource/img/account/personalCenter/zjgl_9.png">
	   							{{value.bankName}}
	   						</div>
	   						<div class="bank-card-num">
	   							{{value.bankCardInfoEntity.bankNo.substring(0,4)+"****"+value.bankCardInfoEntity.bankNo.substring(value.bankCardInfoEntity.bankNo.length-4,value.bankCardInfoEntity.bankNo.length)}}
	   							<span>借记卡</span>
	   						</div>
	   						<div class="deal">
	   							<div class="change" id="{{value.bankCardId}}" >
	   								修改
	   							</div>
	   							<div class="delete receiv_{{value.bankCardId}}" id="{{value.receiveCard}}" >
	   								删除
	   							</div>
	   						</div>
	   					</li>
					{{/each}}
   					</script>	   					
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
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<!--弹出层  -->
   	<div class="addBankCard">
   		<form id="bankId">
   		<div class="BCremind">亲爱的用户，为了您的财产安全，请认真仔细填写您的银行卡信息</div>
   		<div class="bankcard-top">
   			<div class="input-group">
   				<div class="left-title">用户名:</div>
   				<div class="input-info">${loginUser.logname}</div>
   			</div>
   			<div class="input-group">
   				<div class="left-title">真实姓名:</div>
   				<div class="input-info">${loginUser.personalBaseInfo.personalName}</div>
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户银行:</div>
   				<div class="selectArea selectArea1">
   					<input class="selectValue addCard_bankValue" id="addCard_bankValue" value="0" >
					<input class="selectInput select1" type="text" lang="请选择开户行" readOnly="true"/>
				    <ul class="select" id="addCard_selectBank" onselectstart="return false">
				   
				    </ul>
				</div> 
   			</div>
   			<!-- 这里是查询银行名字的模版 -->
   			<script id="bankName" type="text/html">
				{{each data as value index}}
					<li class="selectOption" value={{value.bankID}}>{{value.bankName}}</li>
				{{/each}}
   			</script>
   			<div class="input-group">
   				<div class="left-title">开户行城市:</div>
   				<div class="selectArea">
   					<input class="selectValue provinceId" value="0" >
					<input class="selectInput" type="text" lang="请选择省" readOnly="true"/>
				    <ul class="select" id="provinceSelect" onselectstart="return false" style="height:188px;overflow:auto">
				        
				    </ul>
				</div> 
				<!-- 这里是查询省份名字的模板 -->
				<script id="provinceName" type="text/html">
					{{each data as value index}}
						<li class="selectOption" value={{value.id}}>{{value.cityName}}</li>
					{{/each}}
   				</script>
				<div class="selectArea">
					<input class="selectValue cityId" value="0" >
					<input class="selectInput" type="text" lang="请选择市" readOnly="true"/>
				    <ul class="select" id="citySelect" onselectstart="return false">
				        
				    </ul>
				</div> 
				<!-- 这里是查询出城市的模板 -->
				<script id="cityName" type="text/html">
					{{each data as value index}}
						<li class="selectOption" value={{value.id}}>{{value.cityName}}<li>
					{{/each}}
				</script>
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户行支行:</div>
   				<input type="text" datatype="zbank" class="select1" id="zbank" lang="请输入开户行支行" maxlength="25">
   			</div>
   			<div class="input-group">
   				<div class="left-title">银行卡号:</div>
   				<input type="text" datatype="zbankNum" name="passID_card" id="passID_card" class="select1 numberReg cardId1" lang="请输入银行卡号" maxlength="19">
   			</div>
   			<div class="input-group">
   				<div class="left-title">确认银行卡号:</div>
   				<input type="text" datatype="*" recheck="passID_card"
   				 class="select1 numberReg cardId2" lang="请再次输入银行卡号" maxlength="19">
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户手机号:</div>
   				<input type="text" datatype="zPhone" id="zPhone" class="select1 numberReg phoneBind" lang="请输入开户手机号" maxlength="11">
   			</div>
   		</div>
   		<div class="bankcard-bottom">
   			<input type="submit" value="立即添加"  class="btn">
   		</div>
   		</form>
   	</div>
   	
   	<div class="changeBankCard">
   		<form id="xiuGai_Kard">
   		<div class="BCremind">亲爱的用户，为了您的财产安全，请认真仔细填写您的银行卡信息</div>
   		<div class="bankcard-top">
   			<div class="input-group">
   				<div class="left-title">用户名:</div>
   				<div class="input-info">${loginUser.logname}</div>
   			</div>
   			<div class="input-group">
   				<div class="left-title">真实姓名:</div>
   				<div class="input-info">${loginUser.personalBaseInfo.personalName}</div>
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户银行:</div>
   				<div class="selectArea selectArea1">
   					<input class="selectValue bank_u_val " value="1"  >
					<input class="selectInput select1 bank_u_input" type="text" lang="" readOnly="true"/>
				    <ul class="select" id="addCard_selectBank_u" onselectstart="return false">

				    </ul>
				</div> 
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户行城市:</div>
   				<div class="selectArea">
   					<input class="selectValue provinceSelect_u_val" value="1" >
					<input class="selectInput provinceSelect_u_in " type="text" lang="" readOnly="true"/>
				    <ul class="select" id="provinceSelect_u" onselectstart="return false">

				    </ul>
				</div> 
				<div class="selectArea">
					<input class="selectValue citySelect_u_val" value="1" >
					<input class="selectInput citySelect_u_in" type="text" lang="" readOnly="true"/>
				    <ul class="select" id="citySelect_u" onselectstart="return false">

				    </ul>
				</div>  
   			</div>
   			<div class="input-group">
   				<div class="left-title">开户行支行:</div>
   				<input type="text" datatype="enteraddr" class="select1 zbank_u" maxlength="25">
   			</div>
   			<div class="input-group">
   				<div class="left-title">银行卡号:</div>
   				<input type="text" datatype="zbankNum" class="select1 passID_card_u " maxlength="19">
   			</div> 		
   			<div class="input-group">
   				<div class="left-title">开户手机号:</div>
   				<input type="text" datatype="zPhone" class="select1 zPhone_u" maxlength="11">
   			</div>
   		</div>
   		<div class="bankcard-bottom">
   			<input type="button" class="btn btn_tian" value="立即修改" ">
   		</div>
   		</form>
   	</div>
   	<script type="text/javascript" src="js/account/personalCenter/bankCard.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	
</body>
</html>