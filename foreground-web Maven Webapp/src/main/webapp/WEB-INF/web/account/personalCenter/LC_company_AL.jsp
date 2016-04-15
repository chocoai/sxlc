<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>开户许可证认证</title>
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
	   					<span>开户许可证认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
   					<div class="authenContent">
	   					<div class="authen">
			   				<ul class="inputArea">
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>开户许可证编号：</span></div>
			   						<input class="inputText numberReg" type="text" lang="请输入开户许可证编号" maxlength="12"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>开户银行：</span></div>
			   						<input class="inputText" type="text" lang="请输入开户银行" maxlength="25"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>银行帐号：</span></div>
			   						<input class="inputText numberReg" type="text" lang="请输入银行帐号" maxlength="18"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span>有效期：</span></div>
			   						<input class="inputText dateSelect Wdate" onfocus="WdatePicker()" type="text" lang="请选择有效期"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>附件：</span></div>
			   						<div class="previewPicture">
			   							<img class="previewImg" id="previewImg" src="resource/img/account/common/opacity.png">
			   							<input type="file"accept=".png,.jpg" class="previewInput" id="previewInput" onchange="preImg(this.id,'previewImg')" onblur="if(document.getElementById('previewImg').src=='null')document.getElementById('previewImg').src='resource/img/account/common/opacity.png'" >
			   						</div>
			   						<span class="hint">（请上传附件图片）</span>
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