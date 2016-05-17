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
    <title>个人会员基本信息</title>
    <script type="text/javascript">
    	var publicKey = '<%=session.getAttribute("publicKey")%>';
    	var memberType = 0;
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
   				<!--伍成然2016-4-1-->
	   				<div class="head">
	   					<div class="title">
	   						个人会员
	   					</div>
		   			</div>
		   			<div class="content1 active">
		   				<div class="info clearfix">
			   				<div class="item">
			   					<div class="label">姓名：</div>
			   					<div class="con">${userInfo.baseInfo.personalName }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">民族：</div>
			   					<div class="con">${userInfo.baseInfo.nationName }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">性别：</div>
			   					<div class="con">${userInfo.baseInfo.sexName }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">出生日期：</div>
			   					<div class="con">${userInfo.baseInfo.birthday }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">年龄：</div>
			   					<div class="con">${userInfo.baseInfo.age }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">籍贯：</div>
			   					<div class="con">${userInfo.baseInfo.homeTown }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">身份证：</div>
			   					<div class="con">${userInfo.baseInfo.personalIDCard }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">最高学历：</div>
			   					<div class="con">${userInfo.baseInfo.educationName }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">婚姻状况：</div>
			   					<div class="con">${userInfo.baseInfo.maritalName }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">月均收入：</div>
			   					<div class="con">${userInfo.baseInfo.monthlyIncome }元</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">手机号码：</div>
			   					<div class="con">${userInfo.baseInfo.personalPhone }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">QQ：</div>
			   					<div class="con">${userInfo.baseInfo.qq }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">电子邮箱：</div>
			   					<div class="con">${userInfo.baseInfo.personalEmail }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">户籍地址：</div>
			   					<div class="con">${userInfo.baseInfo.census }</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">居住地址：</div>
			   					<div class="con">${userInfo.baseInfo.houseAddress }</div>
			   				</div>
			   				<div class="item1">
			   					<div class="label">地区：</div>
			   					<div class="con">${userInfo.provinceName }&nbsp;${userInfo.cityName }&nbsp;${userInfo.countyName }</div>
			   				</div>
		   				</div><!--info结束  -->
		   				<div class="deal">
		   					<div class="btn modify" onselectstart="return false">修改资料</div>		   			
		   				</div>
		   			</div>
		   			<form id="testbox" method="post">
			   			<div class="content2">
			   				<div class="info clearfix">
				   				<div class="item">
				   					<div class="label">姓名：</div>
				   					<div class="con">${userInfo.baseInfo.personalName }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">民族：</div>
				   					<div class="con">${userInfo.baseInfo.nationName }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">性别：</div>			   				
							   		<div class="con">${userInfo.baseInfo.sexName }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">出生日期：</div>
				   					<div class="con">${userInfo.baseInfo.birthday }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">年龄：</div>
				   					<div class="con">${userInfo.baseInfo.age }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">籍贯：</div>
				   					<div class="con">${userInfo.baseInfo.homeTown }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">身份证：</div>
				   					<div class="con">${userInfo.baseInfo.personalIDCard }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">最高学历：</div>
				   					<div class="con">${userInfo.baseInfo.educationName }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">婚姻状况：</div>
				   					<div class="con">${userInfo.baseInfo.maritalName }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">月均收入：</div>
				   					<div class="con">${userInfo.baseInfo.monthlyIncome }元</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">手机号码：</div>
				   					<div class="con">${userInfo.baseInfo.personalPhone }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">QQ：</div>
				   					<div class="con">
				   						<input type="text" lang="请输入QQ号码" datatype="qq" value="${userInfo.baseInfo.qq }" class="input-QQ numberReg" maxlength= "12">
				   					</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">电子邮箱：</div>
				   					<div class="con">${userInfo.baseInfo.personalEmail }</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">户籍地址：</div>
				   					<div class="con">
				   						<input type="text" lang="请输入户籍地址" datatype="enteraddr" value="${userInfo.baseInfo.census }" class="input-homeTown" maxlength= "12">
				   					</div>
				   				</div>
				   				<div class="item">
				   					<div class="label">居住地址：</div>
				   					<div class="con">
				   						<input type="text" lang="请输入居住地址" datatype="enteraddr" class="input-location" maxlength="50">
				   					</div>
				   				</div>
				   				<div class="item1">
				   					<div class="label">地区：</div>
				   					<div class="selectArea">
				   						<input class="selectValue" value="0" >
	   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
	    								<ul class="select province" onselectstart="return false">
	        								<li class="selectOption" value="1">北京</li>
	        								<li class="selectOption" value="2">上海</li>
	       									<li class="selectOption" value="3">江西</li>
	        								<li class="selectOption" value="4">云南</li>
	    								</ul>
									</div>
									<div class="selectArea">
										<input class="selectValue" value="0" >
	   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
	    								<ul class="select city" onselectstart="return false">
	        								<li class="selectOption" value="1">北京<li>
	        								<li class="selectOption" value="2">上海<li>
	       									<li class="selectOption" value="3">江西<li>
	        								<li class="selectOption" value="4">云南<li>
	    								</ul>
									</div>
									<div class="selectArea">
										<input class="selectValue" value="0" >
	   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
	    								<ul class="select county" onselectstart="return false">
	        								<li class="selectOption" value="1">北京<li>
	        								<li class="selectOption" value="2">上海<li>
	       									<li class="selectOption" value="3">江西<li>
	        								<li class="selectOption" value="4">云南<li>
	    								</ul>
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