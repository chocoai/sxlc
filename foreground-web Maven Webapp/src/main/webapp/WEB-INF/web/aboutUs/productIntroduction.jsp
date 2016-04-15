<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
    <title>产品介绍</title>
    <jsp:include page="/web/common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/aboutUs/productIntroduction.css">
</head>
<body>
    <jsp:include page="/web/common/top.jsp"></jsp:include>
   	<jsp:include page="/web/common/mainPageTop.jsp"></jsp:include>
   	<jsp:include page="/web/aboutUs/aboutUsCommon.jsp"></jsp:include>
   	
    <!-- 在这里加入页面内容 -->
    <div class="production">
    	<div class="productionContentH">
    		<span class="production_content_title">产品介绍</span>
    	</div>
   	   	<div class="production_main">
   	   		<img class="product_03" src="resource/img/aboutUs/product_03.jpg"></img>
   	   		<div class="production_word">
   	   			<span class="production_word_title">信用贷</span>
   	   			<p class="firstPara">信用贷是为政府公务员、事业单位员工、个体户主、企业高管、白领阶层等量身定制的
				一款借款产品。帮助满足个人消费需求，提高生活品质。</p>
				<div class="production_word_main">
					<p class="productionWordP">
						<span>额度范围：<em>0-30万</em></span>
						<span>期限范围：1-12个月</span>
					</p>
					<p class="productionWordP">
						<span>利率范围：10.00%-18.00%</span>
						<span>会员限制：个人会员</span>
					</p>
				</div>
   	 		</div>
   	 		<button type="button" class="btn btn-primary" onclick="window.location='loan.html';">申请借款</button>
   	 	</div>
   	 	<div class="production_main">
   	   		<img class="product_03" src="resource/img/aboutUs/product.jpg"></img>
   	   		<div class="production_word">
   	   			<span class="production_word_title guarantee">担保贷</span>
   	   			<p class="firstPara">信用贷是为政府公务员、事业单位员工、个体户主、企业高管、白领阶层等量身定制的
				一款借款产品。帮助满足个人消费需求，提高生活品质。</p>
				<div class="production_word_main">
					<p class="productionWordP">
						<span>额度范围：<em>0-500万</em></span>
						<span>期限范围：1-12个月</span>
					</p>
					<p class="productionWordP">
						<span>利率范围：10.00%-18.00%</span>
						<span>会员限制：个人会员</span>
					</p>
				</div>
   	 		</div>
   	 		<button type="button" class="btn btn-primary" onclick="window.location='loan.html';">申请借款</button>
   	 	</div>
   	 	<div class="production_main mainThird">
   	   		<img class="product_03" src="resource/img/aboutUs/product_08.jpg"></img>
   	   		<div class="production_word">
   	   			<span class="production_word_title mortgage">抵押贷</span>
   	   			<p class="firstPara">信用贷是为政府公务员、事业单位员工、个体户主、企业高管、白领阶层等量身定制的
				一款借款产品。帮助满足个人消费需求，提高生活品质。</p>
				<div class="production_word_main">
					<p class="productionWordP">
						<span>额度范围：<em>0-30万</em></span>
						<span>期限范围：1-12个月</span>
					</p>
					<p class="productionWordP">
						<span>利率范围：10.00%-18.00%</span>
						<span>会员限制：个人会员</span>
					</p>
				</div>
   	 		</div>
   	 		<button type="button" class="btn btn-primary" onclick="window.location='loan.html';">申请借款</button>
   	 	</div>
   	 </div>
    
   	<jsp:include page="/web/common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/aboutUs/productIntroduction.js"></script>
</body>
</html>