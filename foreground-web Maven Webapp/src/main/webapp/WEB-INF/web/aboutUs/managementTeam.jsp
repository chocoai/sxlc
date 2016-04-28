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
    <title>管理团队</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/managementTeam.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="../aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="management">
    	<div class="manageCont">
    		<div class="manageContH">
    			<span class="s_manage_title">管理团队</span>
    		</div>
    		
			<p class="ContFirstP">四象金融管理团队汇聚了传统金融行业专家、互联网金融领域的顶尖人才，具有丰富金融运营经验和精湛的信息技术能力,他们是专业高效的实力战将，他们将在日新月异的金融变革和互联网变局中实现融金宝的伟大梦想。</p>
			<%for(int i = 0;i<4;i++){ %>
			<div class="s_manage">
				<span><img class="s_manage_img" src="resource/img/aboutUs/manager_03.jpg"></span>
				<div class="s_manage_main">
					<h4>赵寅成(董事长)</h4>
					<p class="sManageMFirstP">
						毕业于哥伦比亚大学计算机及应用专业，毕业后曾任国内顶级电子商务公司、金融机构的IT技术总监、总经理等职位，熟悉国内银行业务、风控和产品体系，是国内首批接触互联网金融的资深人士之一，曾带领旗下团队远赴瑞士、德国等地学习其先进的金融知识及运营模式。
					</p>
					<p>2013年，与合伙人共同创建互联网金融品牌——四象联创。</p>
				</div>
			</div>
			<%} %>
    	</div>	
   	 </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/managementTeam.js"></script>
</body>
</html>