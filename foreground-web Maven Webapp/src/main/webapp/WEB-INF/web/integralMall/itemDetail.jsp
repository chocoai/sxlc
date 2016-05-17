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
    <title>商品详情</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/integralMall/itemDetail.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../integralMall/intergralMallCommon.jsp"></jsp:include>
    <!-- 在这里加入页面内容 -->
     <!-- 商品列表的静态页面       胥福星       2016-3-29 -->
    <div class="nowPosition">
    	<div class="nowPositionContent">您当前位置 > <a href="integralMall/mallIndex.html">积分商城</a> > <span>商品详情</span></div>
    </div>
    <div id="productListArea" class="productListArea">
    	<!-- <div class="main i-b2">
    		<div class="itemDetail clearfix">
    			<img src="resource/img/integralMall/sp_15_03.png" />
    			<div class="detail">
    				<p class="head">可爱卡通U型枕头 午睡旅行靠枕 记忆棉不变形</p>
    				<p class="productIntroduce">贴心呵护，随时随地给你一个舒适的睡眠。能缓解颈椎劳累。</p>
    				<div class="integral">
    					<p>兑换积分：<samp>12000</samp></p>
    					<p>市场价格：<span class="moneyFormat">1000</span>元</p>
    				</div>
    				<div class="number">
    					<span class="subBtn" >-</span>
    					<input value="1"/>
    					<span class="addBtn" >+</span>
    				</div>
    				<a class="buy" href="integralMall/exchangeDetail.html">立即兑换</a>
    			</div>
    		</div>
    		<div class="description">
    			<div class="descripHead">
    				<span>商品详情</span>
    			</div>
    			<div class="detailEmf">
    				<div class="detailEmfli">
    					<p class="titleEmf">详细参数</p>
    					<p><span><samp>产品名称</samp>U型枕（普通款）</span><span class="rightSpan"><samp>厂家名称</samp>大刘制造厂</span></p>
    					<p><span><samp>产品品牌</samp>远宜家纺</span><span class="rightSpan"><samp>产品规格</samp>28*278*8cm</span></p>
    				</div>
    				<img class="detailImg" src="resource/img/integralMall/detail1.png" />
    				<img class="detailImg" src="resource/img/integralMall/detail2.png" />
    			</div>
    		</div>
    	</div> -->
    	
    	<script id="goodsDet" type="text/html">
    			<div class="main">
		    		<div class="itemDetail clearfix">
		    			<img class="goodsImg" src="{{commoditySmallIcon}}" />
		    			<div class="detail">
		    				<p class="head">{{commodityName}}</p>
		    				<p class="productIntroduce">{{commodityDescribe}}</p>
		    				<div class="integral">
		    					<p>兑换积分：<samp>{{needPoint}}</samp></p>
		    					<p>市场价格：<span class="moneyFormat">{{marketPrice}}</span>元</p>
		    				</div>
		    				<div class="number">
		    					<span class="subBtn" >-</span>
		    					<input id="count" value="1"/>
		    					<span class="addBtn" >+</span>
		    				</div>
		    				<a class="buy" data-href="integralMall/exchangeDetail_{{commodityId}}.html">立即兑换</a>
		    			</div>
		    		</div>
		    		<div class="description">
		    			<div class="descripHead">
		    				<span>商品详情</span>
		    			</div>
		    			<div class="detailEmf">
		    				<div class="detailEmfli">
		    					<p class="titleEmf">详细参数</p>
		    					<p><span><samp>产品名称</samp>{{commodityName}}</span><span class="rightSpan"><samp>厂家名称</samp>{{manufacturer}}</span></p>
		    					<p><span><samp>产品品牌</samp>{{brand}}</span><span class="rightSpan"><samp>产品规格</samp>28*278*8cm</span></p>
		    				</div>
		    				<img class="detailImg" src="{{commodityLargeIcon}}" />
		    			</div>
		    		</div>
		    	</div>
    	</script>
    	
    </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" src="js/common/template.js"></script>
	<script type="text/javascript" src="js/integralMall/itemDetail.js"></script>
</body>
</html>