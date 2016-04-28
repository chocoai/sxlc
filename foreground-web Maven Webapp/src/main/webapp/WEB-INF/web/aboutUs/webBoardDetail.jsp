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
    <title>网站公告详情</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/webBoard.css">
	<link rel="stylesheet" href="css/aboutUs/webBoardDetail.css"></link>
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="../aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="notice_Detail">
   	 	<div class="Detail_title">
	   	 	<span class="notice_Detail_title">关于农业银行暂时关闭P2P充值接口的公告</span>
	   	   	<a href="aboutUs/webBoard.html" class="back_list">返回公告列表>></a>
   	   	</div>
   	   	<div class="notice_Detail_word">
   	   		<p class="detailWordTime">时间：2016-03-08</p>
   	   		<p>尊敬的四项金融用户：</p>
   	   		<p>您好！</p>
			<p>
			接第三方支付与中国农业银行总行通知，农业银行暂时关闭P2P充值接口。届时，您将无法使用农业银行卡的网银功能进行充值。提现功能不受此影响，仍可以正常提现到农业银行卡中。</p>
			<p>为了避免给您的理财体验带来不便，四象金融推荐“使用农业银行卡的用户”进行换绑银行卡操作。具体换绑流程如下：</P>
			<p>1.用户需提供手持身份证照片、手持已绑定农行卡照片、手持新绑定银行卡照片给客服人员进行换绑操作，2.在账户中心填写新的银行卡帐号。一切的操作只为全心保证您的帐号安全，给您带来不便还请谅解。如有其它问题，请联系四象金融客服人员，我们将竭尽全力为您提供良好的理财服务！
			</p>
			<p class="contBottom">
				<span>四象金融运营中心</span>
				<span>2016-03-08</span>
			</p>
   	   	</div>
   	   	<div class="notice_Detail_foot">
   	   		<a href="javascript:" onclick="history.back();">上一篇</a>
	   	    <a href="aboutUs/webBoard.html#">下一篇</a>
	   	    <a href="aboutUs/webBoard.html" class="back_list">返回公告列表>></a>
   	   	</div>
   	 </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/webBoard.js"></script>
</body>
</html>