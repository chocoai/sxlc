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
    <title>平台简介</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/platformIntroduction.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="../aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="plaform_content">
    	<div class="plaformContentH">
    		<span class="plaform_content_title">平台简介</span>
    	</div>
   	   	<!-- <img src="resource/img/aboutUs/platform_introduce_02.jpg">
   	   	<div class="plaform_content_word">
   	   		<p>成都四象联创科技有限公司（简称：四象联创）是一家专注于企业级管理软件开发及行业信息化整体解决方案提供商。公司的主要客户集中在金融、政府信息化等领域。公司核心团队来自我国电子信息名校――电子科技大学，与电子科技大学信软学院建立了长期的产学研合作关系。公司自成立以来，一直致力于企业级软件设计、研发和大规模数据分析、传输、存储。
			      多次与政府机构合作：先后为川旅集团、四川日报、武警九支队、泸州市公安局、重庆市公安局、彭州纪委、甘孜州政府、成都市高新区政府、高新区创新服务中心、成都市软件推进办公室等100余家企事业单位完成软件信息化建设。2010年公司被成都市高新区评为软件服务优秀企业、同年公司获得四川省《大云计划》建设参与资格。
			      同时，四象科技是国内最早从事互联网民间金融管理软件及网络金融平台研发的企业之一，专注于金融软件产品的开发和定制，在行业内享有很高的知名度。通过长期的技术研发投入和多年的市场经验积累，公司拥有丰富的软件产品线，产品涵盖小贷、担保、资产管理、基金、P2P/P2C/P2B、等众多类金融行业软件。先后为戴乐网、财富宝网贷、e兴金融、汇盈贷、贵州民间借贷服务中心宜贷投、礼德财富、四川福彩地、汉易资本、快投网、川恒小贷、财智康宏、新希望万万贷、轻松理、鑫和汇、大鑫投资、365网贷等全国几十家理财公司打建交易平台及提供信息化服务。 
			      公司的技术实力雄厚，多年来一直持续在基础研发平台上大力投入资金和人力，目前已经拥有了多项自主知识产权的发明专利、实用新型专利及金融产品登记。
			      四象联创倡导“专业、专注、高效、创新”的企业精神， 四象人将付出一生的努力，始终致力于做优秀的信息化系统解决方案提供商。</p>
   	   	</div> -->
   	 </div>
    
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/platformIntroduction.js"></script>
</body>
</html>