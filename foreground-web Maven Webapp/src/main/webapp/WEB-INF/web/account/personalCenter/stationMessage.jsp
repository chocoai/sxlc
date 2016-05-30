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
    <title>站内消息</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
    <script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    </script>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/stationMessage.css">
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
	   				<div class="stationMessage">
	   					<div class="stationMessageH">
	   						<div class="unRead" id="unReadMessage">未读站内消息</div>
	   						<div class="read" id="readMessage">已读站内消息</div>
	   					</div>
	   					<div class="stationMessageM">
	   						<ul class="unReadUl" id="unRead_list_ul">
	   							<li id="unRead_list_top">
	   								<div class="myInvestmentMTitle">
						   				<div class="messageContent">消息内容</div>
						   				<div class="recordTime">记录时间</div>
						   				<div class="state">状态</div>
			   						</div>
	   							</li>
	   							<!-- 消息模板 -->
	   							<script id="unRead_list" type="text/html">
								{{each results as info index}}
	   							<li>
	   								<div class="myInvestmentMCont" onselectstart="return false">
	   									<div class="contentMessage" readType="0">
	   										<div class="messageContent" style="overflow:hidden;">
	   											<label></label>{{info.msgDetail}}
	   										</div>
	   										<div class="recordTime">{{info.recordDate}}</div>
	   										<div class="state">未读</div>
		   								</div>
		   								<div class="contentInfo">
		   									<label></label>
		   									<div class="contentInfoM">
		   										{{info.msgDetail}}
		   									</div>
		   								</div>
	   								</div>
	   							</li>
								{{/each}}
								<li class="page"><div id="pager1"></div></li>
   								</script>
	   							
	   						</ul>
	   						<ul class="readUl" id="read_list_ul">
	   							<li id="read_list_top">
	   								<div class="myInvestmentMTitle">
						   				<div class="messageContent">消息内容</div>
						   				<div class="recordTime">记录时间</div>
						   				<div class="state">状态</div>
			   						</div>
	   							</li>
	   							<!-- 消息模板 -->
	   							<script id="read_list" type="text/html">
								{{each results as info index}}
	   							<li>
	   								<div class="myInvestmentMCont" onselectstart="return false">
	   									<div class="contentMessage" readType="1">
	   										<div class="messageContent" style="overflow:hidden;">
	   											<label></label>{{info.msgDetail}}
	   										</div>
	   										<div class="recordTime">{{info.recordDate}}</div>
	   										<div class="state">已读</div>
		   								</div>
		   								<div class="contentInfo">
		   									<label></label>
		   									<div class="contentInfoM">
		   										{{info.msgDetail}}
		   									</div>
		   								</div>
	   								</div>
	   							</li>
								{{/each}}
								<li class="page"><div id="pager2"></div></li>
   								</script>
	   							<%-- <%for(int i=0;i<6;i++){%>
	   							<li>
	   								<div class="myInvestmentMCont" onselectstart="return false">
	   									<div class="contentMessage">
	   										<div class="messageContent">
	   											送投资红包<span class="moneyFormat">100.00</span>元
	   										</div>
	   										<div class="recordTime">2016-09-07  14:12:00</div>
	   										<div class="state">已读</div>
		   								</div>
		   								<div class="contentInfo">
		   									<label></label>
		   									<div class="contentInfoM">
		   										感谢您使用互联网理财投资平台。恭喜！您已于2015年09月07日获得100.00元“手机验证红包”登录网站，
												在”我的红包“页可查看该红包，红包的有效期为1个月，单笔投资满1,000.00元时即可使用如有。
		   									</div>
		   								</div>
	   								</div>
	   							</li>
	   							<%}%> --%>
	   							<div id="pager2"></div>
	   						</ul>
	   					</div>
	   				</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/stationMessage.js"></script>
</body>
</html>