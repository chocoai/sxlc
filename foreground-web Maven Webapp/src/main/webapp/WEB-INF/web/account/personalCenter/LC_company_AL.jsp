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
    <title>开户许可证认证</title>
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
	   					<span>开户许可证认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
   					<div class="authenContent">
	   					<div class="authen">
	   						<form id="alBox" class="person_Renzheng" >
				   				<ul class="inputArea">
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp>*</samp>开户许可证编号：</span></div>
				   						<input class="inputText  accountOpeningCode  " datatype="accountOpen" type="text" lang="请输入开户许可证编号" maxlength="14"/>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp>*</samp>开户银行：</span></div>
				   						<input class="inputText opBank  " type="text" datatype="zbank" lang="请输入开户银行" maxlength="25"/>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp>*</samp>银行帐号：</span></div>
				   						<input class="inputText numberReg bankAccount  " type="text" datatype="zbankNum" lang="请输入银行帐号" maxlength="18"/>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span>有效期：</span></div>
				   						<input class="inputText dateSelect Wdate endTime  " onfocus="WdatePicker({readOnly:true,minDate:'%y-%M-%d'})" type="text" />
				   					</li>
				   					<li class="inputList">
					   						<div class="mustLabel"><span><samp></samp>附件：</span></div>
					   						<div class="previewPicture" id="file" style="float: none;"  >
					   							<img class="previewImg" id="previewImg" src="resource/img/account/common/opacity.png">
												<input type='hidden' class='previewHide' id="0" >
					   						</div>
					   						<!-- <span class="hint">（请上传附件图片）</span> -->
					   					</li>
				   					<li class="inputList">
				   						<div class="btn saveSubmit " id="${requestScope.type}"  >确认并保存</div>
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
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/plugs/My97DatePicker/WdatePicker.js"></script>
	   	<script type="text/javascript" src="plugs/webuploader/webuploader.js" ></script>
   	<script type="text/javascript" src="js/exp-upload.js" ></script>	
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/loanCertification_company_picText.js"></script>
	<script type="text/javascript">
		expUpload(1);
	</script>
</body>
</html>