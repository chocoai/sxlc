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
    <title>抢红包</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/integralMall/redEnvelope.css">
</head>
<body>
	<script type="text/javascript">
		var optionStatu = '${optionStatu }';
		var affairId = '${affairInfo.affairId}';
		var publickey = '<%=session.getAttribute("publicKey")%>';
	</script>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
    <!-- 此处添加代码 -->
    <!--伍成然2016-4-7  -->
    <div class="main">
    	<div class="time">
    		活动时间：${affairInfo.startDate }至${affairInfo.endDate }
    	</div>
    	<div class="reward" id="news"> 
			<ul id="listUl"> 
				<li><span>aa0a</span><span class="mid">200元红包</span><span class="right">2010-03-11&nbsp;10:00</span></li> 
				<li><span>a32a</span><span class="mid">200元红包</span><span class="right">2010-03-11&nbsp;10:00</span></li> 
				<li><span>aa1a</span><span class="mid">100元红包</span><span class="right">2010-03-11&nbsp;10:00</span></li> 
				<li><span>a5aa</span><span class="mid">200元红包</span><span class="right">2010-03-11&nbsp;10:00</span></li> 
				<li><span>a65a</span><span class="mid">100元红包</span><span class="right">2010-03-11&nbsp;10:00</span></li> 
				<li><span>a**a</span><span class="mid">100元红包</span><span class="right">2010-03-11&nbsp;10:00</span></li> 				
			</ul> 
		</div> 
		<div class="btn">
			<img class="beginBtn" src="resource/img/integralMall/qhb_btn_1.png">
			<img class="endBtn"src="resource/img/integralMall/qhb_btn_2.png" style="display:none">
		</div>
		
		<script type="text/html"  id="listM">
			{{each data as value index}}
				<li><span>{{value.userName}}</span><span class="mid">{{value.amount}}元红包</span><span class="right">{{value.sRecordDate}}</span></li> 
			{{/each}}
		</script>
		
    </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/integralMall/redEnvelope.js"></script>
</body>
</html>