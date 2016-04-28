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
	   					<span>实名认证</span>
	   					<a class="back" href="javascript:history.back();">返回</a>
	   				</div>
   					<div class="authenContent">
	   					<div class="authen">
	   						<p class="toolTips">请填写您本人真实有效的身份信息，一旦认证成功，信息将不可更改。</p>
	   						<form id="shiMing">
		   						<ul class="inputArea">
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp>*</samp>姓名：</span></div>
				   						<input class="inputText" type="text" datatype="enterperson" lang="请输入姓名" maxlength="20"/>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp>*</samp>民族：</span></div>
				   						<div class="selectArea nationSelect">
				   							<input class="selectValue" value="0" >
				   							<input class="selectInput" type="text" lang="请选择民族" readOnly="true">
				   							<ul class="select" onselectstart="return false">
				   								<c:forEach items="${nationList }" var="nat">
				   									<li class="selectOption" value="${nat.iId }">${nat.sName }</li>
				   								</c:forEach>
				   							</ul>
				   						</div>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp>*</samp>身份证号：</span></div>
				   						<input class="inputText personId" datatype="IDCard" type="text" lang="请输入您的身份证号" maxlength="18"/>
				   					</li>
				   					<li class="inputList">
				   						<div class="mustLabel"><span><samp>*</samp>籍贯：</span></div>
				   						<input class="inputText" type="text" datatype="enterperson" lang="请输入籍贯" maxlength="20"/>
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
				   						<!-- <div class="previewPicture"> -->
<!-- 					   						<ul class="clearfix"> -->
<!-- 					   							<li> -->
<!-- 													<div class="input-Area"> -->
<!-- 														<input type="hidden" value="2" class="shopImagsCount"> -->
<!-- 														<input type="hidden" value="2" name="projectInfoEntity.projectInfoShopEntity[${statu.index }].shopType"> -->
<!-- 														<input type="text" value="${projectInfoEntity.projectInfoShopEntity[statu.index].shopName }" maxlength="10" placeholder="请输入上传类型" name="projectInfoEntity.projectInfoShopEntity[${statu.index }].shopName"> -->
<!-- 													</div> -->
<!-- 													<div class="subPicture-Area"> -->
<!-- 														<div></div> -->
<!-- 														<span>添加图片</span> -->
<!-- 														<img id="img-${outindex+5+statu.index }" class="img" alt="" src="${projectInfoEntity.projectInfoShopEntity[statu.index ].shopUrl}"/>  -->
<!-- 														<input  name="uploadFile" type="file"  class="file" id="file-${outindex+5+statu.index }" size="28"  onchange="shoppreImg('<%=basePath %>',this.id,'img-${outindex+5+statu.index }');" /> -->
<!-- 														<button onclick="$(this).parent().parent().remove();"></button> -->
<!-- 													</div> -->
<!-- 													<div class="infor-Area"> -->
<!-- 														<input type="hidden" value="${projectInfoEntity.projectInfoShopEntity[statu.index].shopUrl }" name="projectInfoEntity.projectInfoShopEntity[${statu.index }].shopUrl"> -->
<!-- 													</div> -->
<!-- 												</li> -->
<!-- 					   						</ul> -->
				   						<!-- </div> -->
				   						<div class="previewPicture">
				   							<img class="previewImg" id="previewImg1" src="resource/img/account/common/opacity.png">
				   							<input type="file"accept=".png,.jpg" class="previewInput" id="previewInput1" onchange="preImg(this.id,'previewImg1')" onblur="if(document.getElementById('previewImg').src=='null')document.getElementById('previewImg').src='resource/img/account/common/opacity.png'" >
				   						</div>
				   						<div class="previewPicture">
				   							<img class="previewImg" id="previewImg2" src="resource/img/account/common/opacity.png">
				   							<input type="file"accept=".png,.jpg" class="previewInput" id="previewInput2" onchange="preImg(this.id,'previewImg2')" onblur="if(document.getElementById('previewImg').src=='null')document.getElementById('previewImg').src='resource/img/account/common/opacity.png'" >
				   						</div>
				   					</li>	
		   					        <li class="inputList">
				   						<div class="btn">确认并保存</div>
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
	<script type="text/javascript" src="js/account/personalCenter/loanCertification.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#shiMing").Validform({
			tiptype:3,//提示信息类型
			btnSubmit:".btn", 
			datatype:extdatatype,
			ajaxPost:{
				url:"",
				datatype:"json",
				success:function(data,obj){
		        },
		        error:function(data,obj){
		            console.log(data.status);
		        }
			}
		});
		});
	</script>
</body>
</html>