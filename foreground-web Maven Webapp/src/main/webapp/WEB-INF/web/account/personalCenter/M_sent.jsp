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
    <title>站内信</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/mail.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
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
   					<div class="th" onselectstart="return false">
   						<span class="mail" onclick="window.location.href='personalCenter/mail.html'">收件箱</span>
   						<span class="thClick mail">发件箱</span>
   						<a class="write" href="personalCenter/M_write.html">写信息</a>
   					</div>
   					<!-- 发件箱   -->
   					<div class="senderbox">
   						<div class="selectHeader">
   							<div class="deleteArea">
	   							<label class="selectAll" onselectstart="return false"></label><input class="checkbox" value="0">
	   							<div class="delete" onselectstart="return false">删除</div>
   							</div>
							<div class="messageHead">
								<div class="sender">发件人</div>
								<div class="title">标题</div>
								<div class="time">时间</div>
							</div>
							<ul class="messageList">
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">理财达人张三</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">爱理财的乖宝宝</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-13</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">理财达人赵四</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<label class="selectLi" onselectstart="return false"></label><input class="checkbox" value="0">
									</div>
									<div class="senderDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='personalCenter/M_sentDetail.html'">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
							</ul>
   						</div>
   						<div id="pager1"></div>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/mail.js"></script>
</body>
</html>