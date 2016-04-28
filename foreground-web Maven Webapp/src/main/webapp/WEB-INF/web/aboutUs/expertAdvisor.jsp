<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<base href="<%=basePath%>">
    <title>专家顾问</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/expertAdvisor.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="../aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="expertAdvisor">
   		<div class="expertAdvisorH">
   			<div class="expertAdvisorT">专家顾问</div>
   		</div>
    	<div class="expertAdvisorCont">
    		<div class="AdvisorContDetail">
    			<div class="AdvisorContDetailL"><img src=""></div>
    			<div class="AdvisorContDetailR">
    				<p class="ContDetailRName"></p>
    				<p class="ContDetailRPosition"></p>
    				<p class="AdvisorDetail"></p>
    			</div>
    		</div>
    		<div class="indexContFooter">
				<div class="partner">
					<div class="divMain-divWindow" id="divMain-divWindow">
						<div>
							<ul>
							<%for(int i = 0;i<6;i++){ %>
								<li>
									<img src="resource/img/aboutUs/expert_03.jpg">
									<p class="expert">李白</p>
									<p class="position">著名经济学家</p>
									<p class="dn">李白，著名管理经济学家，加拿大卡尔顿大学经济学博士，加拿大约克大学终身教授，外国专家局特聘专家，清华大学新经济研究院院长、教授，北京大学教授、博士生导师, 原北京大学汇丰商学院副院长。同时兼任深圳大学经济学院学术委员会主任，深圳市碳排放权交易专家委员会委员、碳配额分配方案主要设计人之一，兰州市兰州新区智库特聘专家，中国城乡小康发展促进中心首席经济顾问，前海股权交易中心顾问，深圳市财政学会常务理事等。出版专著《管理经济学》、《商业博弈》、《创业帮》以及《风险投资与私募股权的合同管理》等。</p>
								</li>
							<%} %>
							</ul>
						</div>
					</div>
				<div class="expertBtn">
					<label class="expertLeftBtn"></label>
					<label class="expertRightBtn"></label>
				</div>
			</div>
		</div>
    	</div>
    </div>
    
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/expertAdvisor.js"></script>
</body>
</html>