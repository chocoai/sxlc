<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title></title>
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
   					<c:set value="${type}" scope="request" var="t" />
	   				<div class="authenHeader">
	   					<span>
	   					    <c:if test="${t==2}">
	   							现场认证
	   						</c:if>
	   					    <c:if test="${t==3}">
	   							征信认证
	   						</c:if>
	   					    <c:if test="${t==4}">
	   							住址认证
	   						</c:if>	
	   					    <c:if test="${t==5}">
	   							职称认证
	   						</c:if>
	   					    <c:if test="${t==6}">
	   							社保认证
	   						</c:if>
	   					    <c:if test="${t==9}">
	   							银行流水认证
	   						</c:if>
	   					    <c:if test="${t==11}">
	   							学历认证
	   						</c:if>	
	   					    <c:if test="${t==1136091}">
	   							学位认证
	   						</c:if>	
	   					    <c:if test="${t==16}">
	   							银行流水认证
	   						</c:if>
	   					    <c:if test="${t==17}">
	   							实地考察认证
	   						</c:if>
	   					    <c:if test="${t==20}">
	   							财务资料认证
	   						</c:if>
	   					    <c:if test="${t==21}">
	   							监管单位认证
	   						</c:if>
	   					    <c:if test="${t==24}">
	   							担保考察认证
	   						</c:if>	 	   							   								   							   							   							   							   							   							   							   						 	   							   						
	   					</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
	   				<div class="authenContent">
		   				<div class="authen clearfix">
		   				    <div class="previewPictureDiv">
		   				    <div class="wdateSelect" <c:if test="${t==2||t==3 || t==4 || t==5 || t==6 || t==9||t==11 ||t==1136091|| t==16 || t==17 || t==20 || t==21 || t==24 }"> style="display:block" </c:if> >
	   							<span>有效期：</span>
	   							<input class="inputText dateSelect Wdate" onfocus="WdatePicker({readOnly:true,ychanged:showSubmit,Mchanged:showSubmit,dchanged:showSubmit,minDate:'%y-%M-%d'})" type="text" />
		   					</div>
		   					<div class="previewPicture previewPicture_f" id="file" >
		   						<img class="previewImg"   src="resource/img/account/common/opacity.png">
		   					</div>
		   					<div class="btn btn_u" id="${requestScope.type}" >确认并保存</div>
		   					<input type="hidden" value="0" class="editType" />
		   					</div>
		   					<div class="authPreviDiv_u"></div>		   							   			
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
	<script type="text/javascript" src="js/account/personalCenter/loanCertification_pic.js"></script>
	<script type="text/javascript">
		expUpload(0);
		document.title=$(".authenHeader span").html();
	</script>
</body>
</html>