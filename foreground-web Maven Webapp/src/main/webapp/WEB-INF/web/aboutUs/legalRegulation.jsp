<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>法律法规</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/legalRegulation.css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="/web/aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="lawy">
    	<div class="lawyH">
    		<span class="lawy_title">法律法规</span>
    	</div>
   	   	<div class="lawy_content">
   	   		<p><label class="top_icon"></label><!-- <img class="top_icon" src="resource/img/aboutUs/lawy_03.jpg"></img> -->四象金融聘用了华律律师事务所作为公司的常年法律顾问。四象金融所有业务活动以及相关合同和协议均咨询法仕事务所，确保其符合相关法律法规， 团贷网合法守信经营，让四象金融的用户权益受国家法律保护。<label class="bottom_icon"></label></p>
   	   		<!-- <img class="bottom_icon" src="resource/img/aboutUs/lawy_07.jpg"></img> -->
   	   		<ul>
   	   			<%for(int i = 0;i<4;i++){ %>
   	   			<li>
   	   				<h5><img class="lawy_content_icon" src="resource/img/aboutUs/lawy_11.jpg">关于投资人及借款人双方民间借贷关系的合法性</h5>
   	   				<p>根据《合同法》第196条规定“借款合同是借款人向贷款人借款，到期返还借款并支付利息的合同”，《合同法》允许自然人等普通民事主体之 间发生借贷关系，并允许出借方到期可以收回本金和符合法律规定的利息。</p>
   	   			</li>
   	   			<%} %>
   	   		</ul>
   	   	</div>
   	 </div>
    
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/legalRegulation.js"></script>
</body>
</html>