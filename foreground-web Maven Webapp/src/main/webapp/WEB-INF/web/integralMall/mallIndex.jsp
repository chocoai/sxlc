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
    <title>商城首页</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/integralMall/mallIndex.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../integralMall/intergralMallCommon.jsp"></jsp:include>
    <!-- 在这里加入页面内容 -->
    <!-- 商城首页界面      胥福星     2016-03-28 -->
    <div class="bannerArea">
	    <div class="banner">
			<ul id="bannerUl">
				<li>
					<img src="resource/img/integralMall/banner1.png">
				</li>
				<li>
					<img src="resource/img/integralMall/banner2.png">
				</li>
				<li>
					<img src="resource/img/integralMall/banner3.png">
				</li>
			</ul>
			<script id="bannerList" type="text/html">
				{{each data as infos index}}
					<li data-href="{{infos.links}}" title="{{infos.bannerTitle}}">
						<img src="{{infos.url}}">
					</li>
				{{/each}}
			</script>
		</div>
	    <div class="main">
	    	<!--获取积分途径s -->
	    	<div class="integralApproach">
	    		<div class="integralArea"></div>
	    		<div class="integralLi">
	    			<div class="approachList">
	    				<p>注册送积分</p>
	    				<span>你注册我送奖</span>
	    				<a class="vigisterGo" href="register.html"></a>
	    			</div>
	    			<div class="flowImg"></div>
	    		</div>
	    		<div class="integralLi">
	    			<div class="approachList">
	    				<p>邀好友送积分！！</p>
	    				<span>有钱一起赚</span>
	    				<a class="friendInvest" href="personalCenter/friendManagement.html"></a>
	    			</div>
	    			<div class="flowImg2"></div>
	    		</div>
	    		<div class="integralLi">
	    			<div class="approachList">
	    				<p>投资送积分啦</p>
	    				<span>投资马上送好礼</span>
	    				<a class="investGo" href="invest/investmentZone.html"></a>
	    			</div>
	    			<div class="flowImg3"></div>
	    		</div>
	    	</div>
	    	<!-- 获取积分途径e -->
	    	<!-- <div class="productIntegral">
	    		<div class="productHeader">
	    			liftTitle、foodTitle、cardTitle、processTitle
	    			<span class="liftTitle">趣味生活</span>
	    			<a href="integralMall/itemList.html">更多></a>
	    		</div>
	    		<ul class="productList clearfix">
	    			<li class="productLi includeFlow">
	    				<img src="resource/img/integralMall/product1.png" />
	    				<div class="flowToImg">
	    					<p class="titleFlow">趣味生活</p>
	    					<p class="sloginFlow">用心为您打造品质生活</p>
	    				</div>
	    			</li>
	    			<li class="productDetail">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_3.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		    				<span><samp>所需积分：</samp><em>25000</em></span>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			<div class="flowTop">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
		    			<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    			<li class="productDetail">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_7.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		    				<span><samp>所需积分：</samp><em>25000</em></span>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			<div class="flowTop">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
		    			<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    			<li class="productDetail">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_6.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		    				<span><samp>所需积分：</samp><em>25000</em></span>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			<div class="flowTop">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
		    			<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    			<li class="productDetail">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_1.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		    				<span><samp>所需积分：</samp><em>25000</em></span>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			<div class="flowTop">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
		    			<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    		</ul>
	    	</div> -->
	    	
	    	<!-- 循环输出数据 -->
	    	<script id="goodsList" type="text/html">
	    		{{each results as goodsList index}}
	    			<div class="productIntegral">
			    		<div class="productHeader">
			    			<!--liftTitle、foodTitle、cardTitle、processTitle -->
			    			<span class="foodTitle">{{goodsList.commodityClassify}}</span>
			    			<a href="integralMall/itemList.html">更多></a>
			    		</div>
			    		<ul class="productList clearfix">
			    			<li class="productLi includeFlow">
			    				<img class="typeImg" src="${imgProfix}{{goodsList.commodityClassifyPic}}" />
			    				<div class="flowToImg">
			    					<p class="titleFlow">{{goodsList.commodityClassify}}</p>
			    					<p class="sloginFlow">{{goodsList.commodityClassifyDes}}</p>
			    				</div>
			    			</li>
							
							{{each goodsList.goods as item index}}
			    			<li class="productDetail">
				    			<div class="productImg">
				    				<img onclick="window.location.href='integralMall/itemDetail.html?goodsId={{item.commodityId}}'" src="${imgProfix}{{item.commoditySmallIcon}}" />
				    			</div>
				    			<div class="detailProduct">
				   					<p onclick="window.location.href='integralMall/itemDetail.html?goodsId={{item.commodityId}}'">{{item.commodityName}}</p>
				    				<span><samp>所需积分：</samp><em>{{item.needPoint}}</em></span>
				    				<a href="integralMall/exchangeDetail_{{item.commodityId}}.html">立即兑换</a>
				    			</div>
				    			<div class="flowTop">
				   					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">{{item.commodityName}}</p>
				    				<p><samp>所需积分：</samp><span>{{item.needPoint}}</span></p>
				    				<p><samp>市场价格：</samp><span>{{item.marketPrice}}</span></p>
				    				<a href="integralMall/exchangeDetail_{{item.commodityId}}.html">立即兑换</a>
				    			</div>
				    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
				    			<div class="sellOutArea sellOutHide">
					    			<div class="sellOut">
				    				</div>
				    				<div class="sellOutImg"></div>
				    			</div>
			    			</li>
							{{/each}}

			    		</ul>
			    	</div>
    			{{/each}}
	    	</script>
	    	
	    	<!-- <div class="productIntegral">
	    		<div class="productHeader">
	    			<span class="foodTitle">精品零食</span>
	    			<a href="integralMall/itemList.html">更多></a>
	    		</div>
	    		<ul class="productList clearfix">
	    			<li class="productLi includeFlow">
	    				<img src="resource/img/integralMall/product3.png" />
	    				<div class="flowToImg">
	    					<p class="titleFlow">精品零时</p>
	    					<p class="sloginFlow">挑动舌尖的美味</p>
	    				</div>
	    			</li>
	    			<li class="productDetail productFood">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_9.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		    				<span><samp>所需积分：</samp><em>25000</em></span>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			<div class="flowTop">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
		    			<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    			<li class="productDetail productFood">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_8.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		    				<span><samp>所需积分：</samp><em>25000</em></span>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			<div class="flowTop">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
		    			<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    			<li class="productDetail productFood">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_10.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		    				<span><samp>所需积分：</samp><em>25000</em></span>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			<div class="flowTop">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
		    			<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    			<li class="productDetail productFood">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_5.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		    				<span><samp>所需积分：</samp><em>25000</em></span>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			<div class="flowTop">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
		    			<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    		</ul>
	    	</div>
	    	<div class="productIntegral">
	    		<div class="productHeader">
	    			<span class="cardTitle">卡券兑换</span>
	    			<a href="integralMall/itemList.html">更多></a>
	    		</div>
	    		<ul class="productList clearfix">
	    			<li class="productLi includeFlow">
	    				<img src="resource/img/integralMall/product2.png" />
	    				<div class="flowToImg">
	    					<p class="titleFlow">卡券兑换</p>
	    					<p class="sloginFlow">超值兑换，收益涨涨涨</p>
	    				</div>
	    			</li>
	    			<li class="productDetail productCard">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/jfsc_14.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		   					<span><samp>所需积分：</samp><em>25000</em></span>
		   					<a href="integralMall/exchangeDetail.html">立即兑换</a>
		   				</div>
		    			<div class="flowTop">
		    				<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		   					<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    			<li class="productDetail productCard">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/jfsc_15.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p>坚果百味礼包礼盒1420g</p>
		   					<span><samp>所需积分：</samp><em>25000</em></span>
		   					<a href="integralMall/exchangeDetail.html">立即兑换</a>
		   				</div>
	    				<div class="flowTop">
	    					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    			<li class="productDetail productCard">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/jfsc_16.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		   					<span><samp>所需积分：</samp><em>25000</em></span>
		   					<a href="integralMall/exchangeDetail.html">立即兑换</a>
		   				</div>
	    				<div class="flowTop">
		    				<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
		    			兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    			<li class="productDetail productCard">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/jfsc_14.png" />
		    			</div>
		    			<div class="detailProduct">
		   					<p onclick="window.location.href='integralMall/itemDetail.html'">坚果百味礼包礼盒1420g</p>
		   					<span><samp>所需积分：</samp><em>25000</em></span>
		   					<a href="integralMall/exchangeDetail.html">立即兑换</a>
		   				</div>
	    				<div class="flowTop">
	    					<p onclick="window.location.href='integralMall/itemDetail.html'" class="dddd">可爱卡通U型枕头超舒适柔软</p>
		    				<p><samp>所需积分：</samp><span>35000</span></p>
		    				<p><samp>市场价格：</samp><span>1，500.00</span></p>
		    				<a href="integralMall/exchangeDetail.html">立即兑换</a>
		    			</div>
	    				兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide 
	    				<div class="sellOutArea">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
	    			</li>
	    		</ul>
	    	</div> -->
	    	<div class="productIntegral">
	    		<div class="productHeader">
	    			<span class="processTitle">兑换流程</span>
	    		</div>
	    		<ul class="productProcess clearfix">
	    			<li>
	    				<span class="processStep1">1.选择兑换商品</span>
	    			</li>
	    			<li>
	    				<span class="processStep2">2.填写地址</span>
	    			</li>
	    			<li>
	    				<span class="processStep3">3.等待收货</span>
	    			</li>
	    			<li>
	    				<span class="processStep4">4.兑换成功</span>
	    			</li>
	    		</ul>
	    	</div>
	    </div>
	    <a class="link" href="integralMall/bigWheel.html"></a>
    </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" src="js/common/template.js"></script>
	<script type="text/javascript" src="js/integralMall/mallIndex.js"></script>
</body>
</html>