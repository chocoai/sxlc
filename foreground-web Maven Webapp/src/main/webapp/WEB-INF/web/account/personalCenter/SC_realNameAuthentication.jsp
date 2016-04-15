<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>实名认证</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/securityCenter.css">
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
	   					<span>实名认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
   					<div class="authenContent">
	   					<div class="authen">
	   						<p class="toolTips">请填写您本人真实有效的身份信息，一旦认证成功，信息将不可更改。</p>
			   				<ul class="inputArea">
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>姓名：</span></div>
			   						<input class="inputText" type="text" lang="请输入姓名" maxlength="20"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>民族：</span></div>
			   						<div class="selectArea nationSelect">
			   							<input class="selectValue" value="0" >
			   							<input class="selectInput" type="text" lang="请选择民族" readOnly="true">
			   							<ul class="select" onselectstart="return false">
			   								<li class="selectOption" value="1">汉族</li>
			   								<li class="selectOption" value="2">藏族</li>
			   								<li class="selectOption" value="3">白族</li>
			   								<li class="selectOption" value="4">维吾尔族</li>
			   							</ul>
			   						</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>身份证号：</span></div>
			   						<input class="inputText personId" type="text" lang="请输入您的身份证号" maxlength="18"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>籍贯：</span></div>
			   						<input class="inputText" type="text" lang="请输入籍贯" maxlength="20"/>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>性别：</span></div>
			   						<div class="gender">男</div>
			   					</li>
			   					<li class="inputList">
			   						<div class="mustLabel"><span><samp>*</samp>有效期：</span></div>
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
	   					        <li class="contetnList">
	   								<div class="btn emailBtn">确定</div>
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
	<script type="text/javascript" src="js/account/personalCenter/securityCenter.js"></script>
</body>
</html>