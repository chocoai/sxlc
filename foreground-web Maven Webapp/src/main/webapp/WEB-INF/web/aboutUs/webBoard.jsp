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
    <title>网站公告</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/webBoard.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="../aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="website_notice">
    	<div class="website_noticeH">
    		<span class="plaform_content_title">网站公告</span>
    	</div>
   	   	<div class="website_notice_content">
   	   		<ul>
   	   			<%for(int i = 0;i<7;i++){ %>
   	   			<li onclick="window.location='aboutUs/webBoardDetail.html';">
   	   				<span class="circle"></span>
   	   				<span class="noticeContainer">关于农业银行暂时关闭P2P充值接口的公告</span>
   	   				<span class="notice_date"><i>08</i>2016-03</span>
   	   			</li>
   	   			<%} %>
   	   		</ul>
   	   		<div id="pager"></div>
   	   	</div>
   	 </div>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/webBoard.js"></script>
</body>
</html>