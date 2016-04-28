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
    <title>车产认证</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/loanCertification.css">
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
   				<!-- 在此处写入代码 -->
	   				<div class="authenHeader">
	   					<span>车产认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<div class="authenContent">
	   					<div class="cloneDiv">
		   					<div class="authen">
		   						<div class="authenScale">
		   							<p class="authenScaleBtn" onselectstart="return false" onclick="scale(this);">车产认证（川A00000）</p>
		   						</div>
				   				<ul class="inputArea">
				   					<li class="inputList">
				   						<div class="mustLabel"><span>车辆品牌：</span></div>
				   						<div class="introduceContent">玛莎拉蒂</div>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span>型号：</span></div>
				   						<div class="introduceContent">5212145485652222</div>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span>车牌号：</span></div>
				   						<div class="introduceContent">川A0000</div>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span>发票价格：</span></div>
				   						<div class="introduceContent">269万</div>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span>首次登记日期：</span></div>
				   						<div class="introduceContent">2015-09-28</div>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span>附件：</span></div>
				   						<div class="previewPicture">图片预览部分</div>
				   						<!-- <div class="previewPicture">
				   							<img class="previewImg" id="previewImg" src="resource/img/account/common/opacity.png">
				   							<input type="file"accept=".png,.jpg" class="previewInput" id="previewInput" onchange="preImg(this.id,'previewImg')" onblur="if(document.getElementById('previewImg').src=='null')document.getElementById('previewImg').src='resource/img/account/common/opacity.png'" >
				   						</div>
				   						<span class="hint">（请上传附件图片）</span> -->
				   					</li>
				   				</ul>
		   					</div>
		   				</div>
	   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
</body>
</html>
