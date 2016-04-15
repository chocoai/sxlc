<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>媒体报道</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/mediaCoverage.css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="/web/aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="mediaCoverage">
    	<div class="mCoverCont">
    		<div class="mCoverHeader">
    			<span class="mCoverContT">媒体报道</span>
    		</div>
			<%for(int i = 0;i<5;i++){ %>
			<div class="mCoverContMain">
				<span><img class="ContMainImg" src="resource/img/aboutUs/coverage_03.jpg"></span>
				<div class="mCoverContWord">
					<div class="mCoverContH">
						<h4 onclick="window.location='mediaCoverageDetail.html';">【人民日报】四象金融在沪斩获“年度成长价值金奖”</h4>
						<span>2016-03-08</span>
					</div>
					<div class="mCoverContP">
					<p>2015年互联网金融与征信体系建设高峰论坛在上海展览中心成功举行。作为接踵第十三届上海理财博览会的专业盛会，本次论坛成功吸引了政府机构、多家知名互金企业、权威媒体以及普通民众的参与。四项金融成功斩获“年度成长价值金奖”成为论坛一大亮点，将现场气氛推至高潮。今年是四象金融的又一个丰收年，5月，四象金融与分众传媒达成亿元战略合作；6月，成功获得3000万美5月，四象金融与分众传媒达成亿元战5月，四象金融与分众传媒达成亿元战达成亿元战略合作；6月，成功获得3000万美5月，四象金融与分众传媒达成亿元战5月，四象金融与分众传媒达成亿元战达成亿元战略合作；6月，成功获得3000万美5月，四象金融与分众传媒达成亿元战5月，四象金融与分众传媒达成亿元战达成亿元战略合作；6月，成功获得3000万美5月，四象金融与分众传媒达成亿元战5月，四象金融与分众传媒达成亿元战达成亿元战略合作；6月，成功获得3000万美5月，四象金融与分众传媒达成亿元战5月，四象金融与分众传媒达成亿元战达成亿元战略合作；6月，成功获得3000万美5月，四象金融与分众传媒达成亿元战5月，四象金融与分众传媒达成亿元战 <a href="mediaCoverageDetail.html">查看详情>></a></p>
					</div>
				</div>
			</div>
			<%} %>
    	</div>	
   	 </div>
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/mediaCoverage.js"></script>
</body>
</html>