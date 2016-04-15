<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>大转盘</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/integralMall/bigWheel.css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/integralMall/intergralMallCommon.jsp"></jsp:include>
    <!-- 此处添加代码 -->
    <!-- 大转盘内容    伍成然    2016-04-7 -->
    <div class="main">
   		<div class="turntable-bg"> 
		    <div class="pointer"><img src="resource/img/integralMall/pointer.png" alt="pointer"/></div>
		    <div class="rotate" ><img id="rotate" src="resource/img/integralMall/turntable-2.png" alt="turntable"/></div>
		</div>
		<div class="reward" id="news"> 
			<ul> 
				<li><span>aa0a</span><span class="right">200元返现券</span></li> 
				<li><span>a32a</span><span class="right">200元返现券</span></li> 
				<li><span>aa1a</span><span class="right">10个积分</span></li> 
				<li><span>a5aa</span><span class="right">200元返现券</span></li> 
				<li><span>a65a</span><span class="right">100元返现券</span></li> 
				<li><span>a**a</span><span class="right">100元返现券</span></li> 
				<li><span>a76a</span><span class="right">200元返现券</span></li> 
			</ul> 
		</div> 
    	<div class="activity-rule">
    		(1) 本活动中奖率高达<b>100%</b>。<br>
			(2) 新用户完善账户信息（实名认证），即可中奖一次。<br>
			(3) 新老用户活动期间首次投资达到100元，即可中奖一次。<br>
			(4) 新老用户每累计投资2000元，即可多中奖一次；每累计投资达到1万元，加送一次机会。（1万元6次抽奖）<br>
			(5) 抽中实物的用户，请您及时联系四象联创客服人员登记收件信息，奖励将在活动结束后7个工作日内发放。<br>
			(6) 获得活动现金奖励的用户，将在中奖后的7个工作日内发放至其平台账号中(提现免费)。“新用户”是指完成了注册认证且从未投资过的用户。新手体验标和项目优选标不参与此活动<br>
    	</div>
    </div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/integralMall/bigWheel.js"></script>
</body>
</html>