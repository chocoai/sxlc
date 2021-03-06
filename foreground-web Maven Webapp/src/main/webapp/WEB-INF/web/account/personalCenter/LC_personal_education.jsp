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
    <title>学历认证</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var appPath="<%=path%>";
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/loanCertification.css">
	<link rel="stylesheet" type="text/css" href="plugs/webuploader/webuploader.css">
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
	   					<span>学历认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<div class="authenContent">
		   				<div class="authen">
		   					<form class="authEducation">
					   			<ul class="inputArea">
									<li class="inputList">
										<div class="mustLabel">
											<span><samp></samp>学历：</span>
										</div>
										<div class="selectArea nationSelect">
											<input class="selectValue" value="0"> <input
												class="selectInput" type="text" lang="请选择" readOnly="true">
											<ul class="select" onselectstart="return false">
													<li class="selectOption" value="1">小学</li>
													<li class="selectOption" value="2">初中</li>
													<li class="selectOption" value="3">中专/高中</li>
													<li class="selectOption" value="4">专科</li>
													<li class="selectOption" value="5">本科</li>
													<li class="selectOption" value="6">硕士研究生</li>
													<li class="selectOption" value="7">博士研究生</li>
											</ul>
										</div>
									</li>
									<li class="inputList">
				   						<div class="mustLabel"><span><samp></samp>有效期：</span></div>
				   						<input class="inputText dateSelect Wdate" onfocus="WdatePicker({readOnly:true,minDate:'%y-%M-%d'})" type="text"/>
					   				</li>
									<li class="inputList clearfix">
				   						<div class="mustLabel"><span><samp></samp>附件：</span></div>
				   					
				   						<div class="previewPicture" id="file" style="float: none;" >
				   							<img class="previewImg" id="previewImg" src="resource/img/account/common/opacity.png">
				   						</div>
				   						<div class="authPreviDiv_u"></div>
		   								<!-- <span class="hint">（请上传附件图片）</span> -->
					   				</li>
									<li class="inputList">
					   					<div class="btn saveSubmit">确认并保存</div>
					   					<input class="cid" name="cid" type="hidden">
					   					<input class="editType" id="editType" name="editType" type="hidden" value="0">
					   				</li>
				  				</ul>
				  			</form>
		   				</div>
		   			</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
		<script type="text/javascript" src="plugs/webuploader/webuploader.js" ></script>
   	<script type="text/javascript" src="js/exp-upload.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification_education.js"></script>
	<script type="text/javascript">
		expUpload(0);
	</script>
</body>
</html>