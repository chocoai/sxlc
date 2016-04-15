
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>站内信</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/mail.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
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
   					<div class="th" onselectstart="return false">
   						<span class="thClick">收件箱</span>
   						<span>发件箱</span>
   						<a class="write" href="M_write.html">写信息</a>
   					</div>
   					<div class="inbox">
   						<div class="selectHeader">
   							<div class="selectAll" onselectstart="return false"></div>
   							<div class="delete" onselectstart="return false">删除</div>
   							<div class="selectArea" onselectstart="return false">
   								<input class="selectValue" value="0" >
   								 <input class="selectInput" type="text" lang="标记为" readOnly="true"/>
   								 <ul class="select" onselectstart="return false">
      						     	<li class="selectOption read" value="1">已读信息</li>
        					   		<li class="selectOption unRead" value="2">未读信息</li>
   								 </ul>
							</div>
							<div class="messageHead">
								<div class="sender">发件人</div>
								<div class="title">标题</div>
								<div class="time">时间</div>
							</div>
							<ul class="messageList">
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">理财达人张三</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">爱理财的乖宝宝</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-13</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">理财达人赵四</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
										<div class="selectImg selectImgClick"></div>
									</div>
									<div class="senderDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail" onclick="window.location='M_receivedDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
							</ul>
   						</div>
   						<div id="pager"></div>
   					</div>
   					<div class="senderbox">
   						<div class="selectHeader">
   							<div class="deleteArea">
	   							<div class="selectAll" onselectstart="return false"></div>
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
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">理财达人张三</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">爱理财的乖宝宝</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-13</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">理财达人赵四</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">一般人我不告诉他哦！</div>
									<div class="timeDetail">2016-01-14</div>
								</li>
								<li class="messageLi">
									<div class="messageBtn">
										<div class="selectLi" onselectstart="return false"></div>
									</div>
									<div class="senderDetail"  onclick="window.location='M_sentDetail.html'" onselectstart="return false">理财达人王五</div>
									<div class="titleDetail"  onclick="window.location='M_sentDetail.html'"onselectstart="return false">一般人我不告诉他哦！</div>
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
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/mail.js"></script>
</body>
</html>