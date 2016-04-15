<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/aboutUs.css">
</head>
<body>
   	<div class="aboutUsAdvert">
	   	<img src="resource/img/aboutUs/gywm_banner.jpg">
   	</div>
   	<div class="aboutUsNav"> 
	   	<div>
	   		<ul>
	   			<li>
	   				<!-- <div class="aboutUsNavChoose">
		   				<select  class="choose12" onchange="self.location.href=options[selectedIndex].value">  
							<option class="choose1" value='platformIntroduction.html'>平台简介</option>  
							<option class="choose2" value='managementTeam.html'>管理团队</option>  
							<option class="choose3" value='expertAdvisor.html'>专家顾问</option>  
						</select> 
	   				</div> -->
	   				<!-- 胥福星     修改start      20160410  -->
	   				<div class="selectM aboutUsNavChoose">
	   					<input class="choose12" type="text" value="平台简介" readonly="readonly" >
	   					<div class="selectChose">
	   						<a class="selectOption choose1"  href='platformIntroduction.html'>平台简介</a>
	   						<a class="selectOption choose2" href='managementTeam.html'>管理团队</a>
	   						<a class="selectOption choose3" href='expertAdvisor.html'>专家顾问</a>
	   						<span class="arrowUp"></span>
	   					</div>
	   				</div>
				</li>
	   			<li><a class="choose4" href="productIntroduction.html">产品介绍</a></li>
	   			<li><a class="choose5" href="webBoard.html">网站公告</a></li>
	   			<li><a class="choose6"href="mediaCoverage.html">媒体报道</a></li>
	   			<li><a class="choose7" href="securityGuarantee.html">安全保障</a></li>
	   			<li>
	   				<!-- <div class="aboutUsNavChoose">
		   				<select class="choose13" onchange="self.location.href=options[selectedIndex].value">  
							<option class="choose8" value='newbieGuide.html'>新手指南</option>  
							<option class="choose9" value='commonProblem.html'>常见问题</option>  
						</select> 
	   				</div> -->
	   				<!-- 胥福星     修改start      20160410  -->
	   				<div class="selectM aboutUsNavChoose">
	   					<input class="choose13" type="text" value="新手指南" readonly="readonly" >
	   					<div class="selectChose">
	   						<a class="selectOption choose8"  href='newbieGuide.html'>新手指南</a>
	   						<a class="selectOption choose9" href='commonProblem.html'>常见问题</a>
	   						<span class="arrowUp"></span>
	   					</div>
	   				</div>
	   			</li>
	   			<li><a class="choose10" href="legalRegulation.html">法律法规</a></li>
	   			<li><a class="choose11" href="recruitmentInformation.html">招贤纳士</a></li>
	   		</ul>
	   	</div>
   	</div>
	<script type="text/javascript" src="js/aboutUs/aboutUs.js"></script>
</body>
</html>