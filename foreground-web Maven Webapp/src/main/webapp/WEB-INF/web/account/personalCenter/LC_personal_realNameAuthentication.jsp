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
	<base href="<%=basePath%>">
    <title>实名认证</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var appPath="<%=path%>";
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="plugs/webuploader/webuploader.css">
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
	   					<span>实名认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
   					<div class="authenContent">
	   					<div class="authen">
	   						<p class="toolTips">请填写您本人真实有效的身份信息，一旦认证成功，信息将不可更改。</p>
	   						<form id="shiMing1">
		   						<ul class="inputArea">
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp>*</samp>姓名：</span></div>
				   						<input class="inputText realName" type="text" datatype="enterperson" lang="请输入姓名" maxlength="20"/>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp>*</samp>身份证号：</span></div>
				   						<input class="inputText personId" datatype="IDCard" type="text" lang="请输入您的身份证号" maxlength="18"/>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp></samp>民族：</span></div>
				   						<div class="selectArea nationSelect">
				   							<input class="selectValue" value="0">
				   							<input class="selectInput" type="text" lang="请选择民族" readOnly="true">
				   							<ul class="select" onselectstart="return false">
				   								<c:forEach items="${nationList }" var="nat">
				   									<li class="selectOption" value="${nat.iId }">${nat.sName }</li>
				   								</c:forEach>
				   							</ul>
				   						</div>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp></samp>籍贯：</span></div>
				   						<input class="inputText homeTown" type="text" lang="请输入籍贯" maxlength="20"/>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp></samp>性别：</span></div>
				   						<div class="gender">男</div>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp></samp>有效期：</span></div>
				   						<input class="inputText dateSelect Wdate" onfocus="WdatePicker()" type="text" lang="请选择有效期"/>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp></samp>附件：</span></div>
				   						<div class="previewPicture" id="file1">
				   							<img class="previewImg" id="previewImg1" src="resource/img/account/common/opacity.png">
				   							<input value="" type="hidden" class="previewHide">
				   							<!-- <input type="file"accept=".png,.jpg" class="previewInput" id="previewInput1" onchange="preImg(this.id,'previewImg1')" onblur="if(document.getElementById('previewImg1').src==null)document.getElementById('previewImg').src='resource/img/account/common/opacity.png'" > -->
				   						</div>
				   						<div class="previewPicture" id="file2">
				   							<img class="previewImg" id="previewImg2" src="resource/img/account/common/opacity.png">
				   							<input value="" type="hidden" class="previewHide">
				   							<!-- <input type="file" accept=".png,.jpg" class="previewInput" id="previewInput2" onchange="preImg(this.id,'previewImg2')" onblur="if(document.getElementById('previewImg2').src==null)document.getElementById('previewImg').src='resource/img/account/common/opacity.png'" > -->
				   						</div>
				   					</li>	
		   					        <li class="inputList">
				   						<div class="btn btn1">确认并保存</div>
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
	<script type="text/javascript" src="js/account/personalCenter/LC_personal_realNameAuthentication.js"></script>
</body>
	<script>
		expOneUpload("file1",1);
		expOneUpload("file2",1);
	</script>
</html>