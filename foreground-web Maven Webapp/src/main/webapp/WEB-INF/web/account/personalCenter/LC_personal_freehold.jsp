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
    <title>房产认证</title>
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
	   					<span>房产认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
   					<div class="authenContent">
	   					<div class="clearfix"><div class="addAuthen" onselectstart="return false">添加房产认证</div></div>
	   					<div class="cloneDiv">
		   					<div class="authen">
		   						<div class="authenScale">
		   							<p class="authenScaleBtn" onselectstart="return false" onclick="scale(this);">房产认证</p>
		   						</div>
		   						<form class="person_Renzheng">
					   				<ul class="inputArea">
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>房产位置：</span></div>
					   						<input class="inputText address" datatype="enteraddr" type="text" lang="请输入房产位置" maxlength="25"/>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>面积：</span></div>
					   						<input class="inputText area" datatype="acountM"  type="text" lang="请输入房产面积" maxlength="10"/>
					   						<span class="unitPrice">米<sup>2</sup></span>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>市场价值：</span></div>
					   						<input class="inputText value" datatype="acountM" type="text" lang="请输入房产市场价值" maxlength="10"/>
					   						<span class="unitPrice">元</span>
					   					</li>
					   					<li class="inputList">
					   						<div class="mustLabel"><span><samp>*</samp>登记时间：</span></div>
					   						<input class="inputText dateSelect Wdate " onfocus="WdatePicker({readOnly:true})" type="text" lang="请选择登记时间"/>
					   					</li>
					   					<li class="inputList">
						   					<div class="mustLabel"><span><samp>*</samp>附件：</span></div>
						   					<div class="previewPicture" id="file" style="float: none;" >
						   						<img class="previewImg" id="previewImg" src="resource/img/account/common/opacity.png">
						   					</div>
						   					<div class="authPreviDiv_u"></div>
						   					<!-- <span class="hint">（请上传附件图片）</span> -->
						   				</li>
					   					<li class="inputList">
					   						<div class="btn saveSubmit holdBtn" id="${requestScope.type}" >确认并保存</div>
					   						<input type="hidden" value="0" class="editType" />
					   						<input type="hidden" value="0" class="cid" />
					   					</li>
					   				</ul>
				   				</form>
		   					</div>
	   					</div>
	   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
   	<script type="text/javascript" src="plugs/webuploader/webuploader.js" ></script>
   	<script type="text/javascript" src="js/exp-upload.js" ></script>	
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification_picText.js"></script>
	<script type="text/javascript">
		expUpload(0);
	</script>
</body>
</html>