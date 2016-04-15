<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>个人会员基本信息</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/baseInformation.css">
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
			   					<div class="con">王菲</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">民族：</div>
			   					<div class="con">汉</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">性别：</div>
			   					<div class="con">女</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">出生日期：</div>
			   					<div class="con">1987-02-11</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">年龄：</div>
			   					<div class="con">28</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">籍贯：</div>
			   					<div class="con">四川</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">身份证：</div>
			   					<div class="con">513723********1545</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">最高学历：</div>
			   					<div class="con">博士</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">婚姻状况：</div>
			   					<div class="con">已婚</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">月均收入：</div>
			   					<div class="con">10,000.00元</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">手机号码：</div>
			   					<div class="con">187****2377</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">QQ：</div>
			   					<div class="con">247***2377</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">电子邮箱：</div>
			   					<div class="con">847***65@qq.com</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">户籍地址：</div>
			   					<div class="con">四川成都</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">居住地址：</div>
			   					<div class="con">成都郫县77号</div>
			   				</div>
			   				<div class="item1">
			   					<div class="label">地区：</div>
			   					<div class="con">四川省&nbsp;成都市&nbsp;郫县</div>
			   				</div>
		   				</div><!--info结束  -->
		   				<div class="deal">
		   					<div class="btn modify" onselectstart="return false">修改资料</div>		   			
		   				</div>
		   			</div>
		   			<div class="content2">
		   				<div class="info clearfix">
			   				<div class="item">
			   					<div class="label">姓名：</div>
			   					<div class="con">王菲</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">民族：</div>
			   					<div class="con">汉</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">性别：</div>			   				
						   		<div class="con">女</div>
								
			   				</div>
			   				<div class="item">
			   					<div class="label">出生日期：</div>
			   					<div class="con">1987-02-11</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">年龄：</div>
			   					<div class="con">28</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">籍贯：</div>
			   					<div class="con">四川</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">身份证：</div>
			   					<div class="con">513723********1545</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">最高学历：</div>
			   					<div class="con">博士</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">婚姻状况：</div>
			   					<div class="con">已婚</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">月均收入：</div>
			   					<div class="con">10,000.00元</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">手机号码：</div>
			   					<div class="con">187****2377</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">QQ：</div>
			   					<div class="con">
			   						<input type="text" lang="请输入QQ号码" class="input-QQ numberReg" maxlength= "12">
			   					</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">电子邮箱：</div>
			   					<div class="con">847***65@qq.com</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">户籍地址：</div>
			   					<div class="selectArea">
			   						<input class="selectValue" value="0" >
   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
    								<ul class="select" onselectstart="return false">
        								<li class="selectOption" value="1">北京<li>
        								<li class="selectOption" value="2">上海<li>
       									<li class="selectOption" value="3">江西<li>
        								<li class="selectOption" value="4">云南<li>
    								</ul>
								</div>
								<div class="selectArea">
									<input class="selectValue" value="0" >
   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
    								<ul class="select" onselectstart="return false">
        								<li class="selectOption" value="1">北京<li>
        								<li class="selectOption" value="2">上海<li>
       									<li class="selectOption" value="3">江西<li>
        								<li class="selectOption" value="4">云南<li>
    								</ul>
								</div>
			   				</div>
			   				<div class="item">
			   					<div class="label">居住地址：</div>
			   					<div class="con">
			   						<input type="text" lang="请输入居住地址" class="input-location" maxlength="18">
			   					</div>
			   				</div>
			   				<div class="item1">
			   					<div class="label">地区：</div>
			   					<div class="selectArea">
			   						<input class="selectValue" value="0" >
   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
    								<ul class="select" onselectstart="return false">
        								<li class="selectOption" value="1">北京<li>
        								<li class="selectOption" value="2">上海<li>
       									<li class="selectOption" value="3">江西<li>
        								<li class="selectOption" value="4">云南<li>
    								</ul>
								</div>
								<div class="selectArea">
									<input class="selectValue" value="0" >
   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
    								<ul class="select" onselectstart="return false">
        								<li class="selectOption" value="1">北京<li>
        								<li class="selectOption" value="2">上海<li>
       									<li class="selectOption" value="3">江西<li>
        								<li class="selectOption" value="4">云南<li>
    								</ul>
								</div>
								<div class="selectArea">
									<input class="selectValue" value="0" >
   				 					<input class="selectInput" type="text" lang="请选择" readOnly="true">
    								<ul class="select" onselectstart="return false">
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
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/baseInformation.js"></script>
</body>
</html>