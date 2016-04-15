<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>自动还款</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/loanManagement/autoRepay.css">
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
   				<!--伍成然2016-3-31  -->
	   				<div class="head">
	   					<div class="title">
	   						自动还款设置
	   					</div>
	   				</div>
	   				<div class="body">
	   					<div class="remind-box">
	   						尊敬的客户，开启自动还款后，平台将自动进行还款操作。
	   					</div>
		   				<div class="auto-repay-ctrl">
		   					<div>您已开启自动还款功能</div>
		   					<input type="button" class="close-auto-repay btn" value="关闭自动还款">
		   				</div>
		   				<div class="auto-repay-ctrl active">
		   					<div>您尚未开启自动还款功能</div>
		   					<input type="button" class="open-auto-repay btn" value="开启自动还款">
		   				</div>
		   				<div class="remind-card">
		   					自动还款规则:<br>
		   					1、 用户手动开启自动还款功能，到还款时间自动将款转给投资人；<br>
							2、 开启自动还款后，当金额不足时，则不能使用自动还款功能；<br>
							3、 还款排序规则如下：<br>
	      					&nbsp;&nbsp;&nbsp;&nbsp;1)还款顺序按照借款成功时间的先后进行排序；<br>
	      					&nbsp;&nbsp;&nbsp;&nbsp;2)自动还款开启后，平台将在每天21:00开始进行检测;					
		   				</div>
		   				<div class="remind-bottom">
		   					<h3>温馨提示</h3>
		   					<p>&nbsp;&nbsp;自动还款没有期限，开启后将一直执行，直到账户金额不足为止，或者用户手动停止。</p>
		   				</div>
	   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/loanManagement/autoRepay.js"></script>
</body>
</html>