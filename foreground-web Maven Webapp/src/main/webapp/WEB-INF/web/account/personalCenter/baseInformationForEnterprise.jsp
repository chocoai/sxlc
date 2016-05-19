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
    <title>企业会员基本信息</title>
    <script type="text/javascript">
    	var publicKey = '<%=session.getAttribute("publicKey")%>';
    	var memberType = 1;
    </script>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/baseInformation.css">
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
   				<!--伍成然2016-4-2-->
	   				<div class="head">
	   					<div class="title">
	   						企业会员
	   					</div>
		   			</div>
		   			<div class="content1 active">
		   				<div class="info clearfix">
			   				<div class="item">
			   					<div class="label1">企业名称：</div>
			   					<div class="con">${userInfo.companyInfo.compangName }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">营业执照号：</div>
			   					<div class="con">${userInfo.companyInfo.companyeBLN }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">企业地址：</div>
			   					<div class="con">${userInfo.companyInfo.companyAddress }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">法人代表：</div>
			   					<div class="con">${userInfo.companyInfo.baseInfo.personalName }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">法人身份证：</div>
			   					<div class="con">${userInfo.companyInfo.baseInfo.personalIDCard }***</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">组织机构代码：</div>
			   					<div class="con">${userInfo.companyInfo.companyOC }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">税务登记号：</div>
			   					<div class="con">${userInfo.companyInfo.taxRegNo }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">经营范围：</div>
			   					<div class="con">${userInfo.companyInfo.companyBusiness }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">经营场所：</div>
			   					<div class="con">${userInfo.companyInfo.establishments }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">注册资本来源：</div>
			   					<div class="con">${userInfo.companyInfo.companySource }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">注册资本：</div>
			   					<div class="con"><span class="moneyFormat">${userInfo.companyInfo.companyCapital }</span>元</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">地区：</div>
			   					<div class="con">${userInfo.provinceName }&nbsp;${userInfo.cityName }&nbsp;${userInfo.countyName }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">联系人：</div>
			   					<div class="con">${userInfo.baseInfo.personalName }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">联系人手机号：</div>
			   					<div class="con">${userInfo.baseInfo.personalPhone }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">联系人QQ：</div>
			   					<div class="con">${userInfo.baseInfo.qq }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label1">联系人邮箱：</div>
			   					<div class="con">${userInfo.baseInfo.personalEmail }</div>
			   				</div>
			   				<div class="item2">
			   					<div class="label1">公司简介：</div>
			   					<div class="con">${userInfo.companyInfo.companyProfile}</div>
			   				</div>
		   				</div><!--info结束  -->
		   				<div class="deal">
		   					<div class="btn modify" onselectstart="return false">修改资料</div>		   			
		   				</div>
		   			</div>
		   			<form id="testbox">
			   			<div class="content2">
			   				<div class="info clearfix">
								<div class="item">
				   					<div class="label1">企业名称：</div>
				   					<div class="con">${userInfo.companyInfo.compangName }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">营业执照号：</div>
				   					<div class="con">${userInfo.companyInfo.companyeBLN }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">企业地址：</div>
				   					<div class="con">${userInfo.companyInfo.companyAddress }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">法人代表：</div>
				   					<div class="con">${userInfo.companyInfo.baseInfo.personalName }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">法人身份证：</div>
				   					<div class="con">${userInfo.companyInfo.baseInfo.personalIDCard }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">组织机构代码：</div>
				   					<div class="con">${userInfo.companyInfo.companyOC }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">税务登记号：</div>
				   					<div class="con">${userInfo.companyInfo.taxRegNo }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">经营范围：</div>
				   					<div class="con">${userInfo.companyInfo.companyBusiness }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">经营场所：</div>
				   					<div class="con">${userInfo.companyInfo.establishments }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">注册资本来源：</div>
				   					<div class="con">${userInfo.companyInfo.companySource }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">注册资本：</div>
				   					<div class="con">${userInfo.companyInfo.companyCapital } 元</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">地区：</div>
				   					<div class="selectArea">
				   						<input class="selectValue" value="0" >
	   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
	    								<ul class="select province" onselectstart="return false">
	    								</ul>
									</div>
									<div class="selectArea">
										<input class="selectValue" value="0" >
	   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
	    								<ul class="select city" onselectstart="return false">
	    								</ul>
									</div>
									<div class="selectArea">
										<input class="selectValue" value="0" >
	   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
	    								<ul class="select county" onselectstart="return false">
	    								</ul>
									</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">联系人：</div>
				   					<div class="con">
										<input type="text" lang="请输入联系人" name="contactName" value="${userInfo.baseInfo.personalName }" class="input-contacts" maxlength="18">
									</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">联系人手机号：</div>
				   					<div class="con">${userInfo.baseInfo.personalPhone }</div>
			   					</div>
				   				<div class="item">
				   					<div class="label1">联系人QQ：</div>
				   					<div class="con">
										<input type="text" lang="请输入联系人QQ" datatype="qq" value="${userInfo.baseInfo.qq }" name="contactQq" class="input-QQ" maxlength="12">
									</div>
				   				</div>
				   				<div class="item">
				   					<div class="label1">联系人邮箱：</div>
				   					<div class="con">${userInfo.baseInfo.personalEmail }</div>
			   					</div>
				   				<div class="item2">
				   					<div class="label1">公司简介：</div>
				   					<div class="con">
									<textarea cols="50" rows="8" id="contactus" name="contactus">${userInfo.companyInfo.companyProfile}</textarea><!--样式待改  -->
									</div>
				   				</div>
			   				</div><!--info结束  -->
			   				<div class="deal">
			   					<div class="btn preserve" onselectstart="return false">保存资料</div>
			   					<div class="cancel">
			   						取消保存
			   					</div>
			   				</div>
			   			</div>			   				
			   		</form>	
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/baseInformation.js"></script>
</body>
</html>