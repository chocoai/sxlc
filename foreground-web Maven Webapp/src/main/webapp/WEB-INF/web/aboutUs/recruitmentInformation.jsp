<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>招贤纳士</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/recruitmentInformation.css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="/web/aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="website_notice">
    	<div class="websiteNoticeH">
    		<span class="job_content_title">招贤纳士</span>
    	</div>
   	   	<div class="job_main">
	   	   	<div class="job_content_top">
	   	   		<p class="jobContP1">我们是一支在互联网和金融领域非常优秀的团队！我们有梦有理想，我们积极乐观，脚踏实地，充满激情！如果你也和我们一样，那么欢迎你加入我们的团队！我们会为你提供</p>
	   	   		<p><span class="job_circle"></span>在全新的互联网金融行业里开启个人事业的机会</p>
	   	   		<p><span class="job_circle"></span>富有竞争力的薪酬待遇</p>
	   	   		<p><span class="job_circle"></span>轻松惬意的工作氛围和充满活力的团队文化</p>
	   	   		<p><span class="job_circle"></span>完善的培训体系和更多的晋升机会</p>
	   	   	</div>
	   	    <div class="jobOfferWay"><p>请发送您的简历至hr@sxlc.com，标题请注明所申请职位。</p></div>
	   	   <div class="job_content_middle jobContentFirst">
	   	    	<h4 class="recruitmentPost">招聘职位</h4>
	   	    </div> 
	   	    <%for(int i = 0;i<4;i++){ %>
	   	   		<div class="job_content_middle">
	   	   			<div class="contentMiddleH">
		   	   			<h4>web前端开发工程师</h4>
		   	    		<span>招聘人数：<em>3</em><i class="glyphicon"></i></span>
	   	    		</div>
		   	   		<div class="job_middle_main">
			   	   		<div class="job_duty"><p>岗位职责</p></div>
		   	    		<div class="jobDutyCont">
		   	    			<p>1、负责WEB前端分析、设计、开发、调试和维护；<br>
				   	    		2、负责用web标准规范页面代码，优化页面，提高用户体验 ；<br>
				   	    		3、负责根据需求，分析并给出最优的前端技术解决方案；<br>
				   	    		4、负责了解产品设计逻辑及交互设计方案可行性评估；<br>
				   	    		5、负责与UI设计师以及后端开发人员协作，完成前端页面的开发、维护和优化；<br>
				   	    		6、能够对技术难点进行攻关，解决产品开发和维护中的技术问题；<br>
				   	    		7、研究和学习新的移动互联网技术，持续不断优化产品提升用户体验；
				   	    	</p>
				   	    </div>
		   	    		<div class="job_require"><p>任职要求</p></div>
		   	    		<div>
		   	    			<p>1、负责WEB前端分析、设计、开发、调试和维护；<br>
				   	    		2、负责用web标准规范页面代码，优化页面，提高用户体验 ；<br>
				   	    		3、负责根据需求，分析并给出最优的前端技术解决方案；<br>
				   	    		4、负责了解产品设计逻辑及交互设计方案可行性评估；<br>
				   	    		5、负责与UI设计师以及后端开发人员协作，完成前端页面的开发、维护和优化；<br>
				   	    		6、能够对技术难点进行攻关，解决产品开发和维护中的技术问题；
		   	    			</p>
		   	    		</div>
		   	   		</div>
	   	   		</div>
	   	   		<%} %>
	   	    <!-- <div class="job_content_bottom">
	   	    	<div class="job_bottom">
	   	    		<p>WEB前端开发工程师</p>
	   	    		<span>招聘人数：<em>3</em><i class="glyphicon glyphicon-chevron-right"></i></span>
	   	    	</div>
	   	    	<div class="job_bottom">
	   	    		<p>UI设计师</p>
	   	    		<span>招聘人数：<em>1</em><i class="glyphicon glyphicon-chevron-right"></i></span>
	   	    	</div>
	   	    	<div class="job_bottom">
	   	    		<p>总经理助理</p>
	   	    		<span>招聘人数：<em>3</em><i class="glyphicon glyphicon-chevron-right"></i></span>
	   	    	</div>
	   	    </div> -->
   	 </div>
   	 </div>
    
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/recruitmentInformation.js"></script>
</body>
</html>