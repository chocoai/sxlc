<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title>商品列表</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/integralMall/itemList.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../integralMall/intergralMallCommon.jsp"></jsp:include>
    <!-- 在这里加入页面内容 -->
    <!-- 商品列表的静态页面       胥福星       2016-3-29 -->
    <div class="nowPosition">
    	<div class="nowPositionContent">您当前位置 &gt; <a href="integralMall/mallIndex.html">积分商城</a> &gt; <span>商品列表</span></div>
    </div>
    <div class="productListArea">
    	<div class="main">
    		<div class="filter">
    			<div class="integralFilter integralFilter2">
    				<div class="filterImg"></div>
    				<ul class="clearfix filterLi">
    					<li><span class="selected">全部</span></li>
    					<li><span>200以下</span></li>
    					<li><span>200-500</span></li>
    					<li><span>501-1000</span></li>
    					<li><span>1000以上</span></li>
    				</ul>
    				<form>
    					<input class="numberReg" maxlength="10"/>
    					<div class="lineMiddle"></div>
    					<input class="numberReg" maxlength="10"/>
    					<input class="button" type="button" value="搜索" />
    				</form>
    				<div>
    					<p><span class="order">积分从低到高</span><img src="resource/img/integralMall/jfscDown.png" /></p>
    				</div>
    			</div>
    			<div class="integralFilter">
    				<div class="filterImg2"></div>
    				<ul class="clearfix filterLi i-b2">
    					<li><span class="selected">全部</span></li>
    					<c:if test="${CommodityTypeList != null && CommodityTypeList !=''}">
    						<c:forEach items="${CommodityTypeList}" var="data">
		    					<li><span>${data.commodityClassify}</span></li>
    						</c:forEach>
    					</c:if>
    					<c:if test="${CommodityTypeList == null}">
	    					<li><span></span></li>
    					</c:if>
    					<!-- <li><span>家用电器</span></li>
    					<li><span>美容美妆</span></li>
    					<li><span>日用百货</span></li>
    					<li><span>公仔玩具</span></li>
    					<li><span>体育户外</span></li>
    					<li><span>食品饮料</span></li>
    					<li><span>数码产品</span></li>
    					<li><span>创意饰品</span></li> -->
    				</ul>
    			</div>
    		</div>
    		<div class="productIntegral">
		    	<div class="productHeader">
		    		<span class="productTable">商品列表</span>
		    	</div>
		    	<ul class="productList clearfix">
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail productImg1">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_2.png" />
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail productImg1">
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail productImg1">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_7.png" />
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail">
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail productImg1">
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail productImg1">
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail productImg1">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_11.png" />
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_12.png" />
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail productImg1">
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>		    		
		    		<li class="productDetail productImg1">
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea sellOutHide">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    		<li class="productDetail productImg1">
		    			<div class="productImg">
		    				<img onclick="window.location.href='integralMall/itemDetail.html'" src="resource/img/integralMall/sp_11.png" />
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
		    			<!-- 兑换完的商品，当商品兑换完之后才出现，添加样式sellOutHide,否则就移除样式sellOutHide  -->
	    				<div class="sellOutArea">
			    			<div class="sellOut">
		    				</div>
		    				<div class="sellOutImg"></div>
		    			</div>
		    		</li>
		    	</ul>
	    	</div>
    	</div>
	    <a class="link" href="integralMall/bigWheel.html"></a>
	    <div id="pager"></div>
	    <!-- 此处添加页面切换代码        -->
    </div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
   	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
   	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" src="js/integralMall/itemList.js"></script>
</body>
</html>