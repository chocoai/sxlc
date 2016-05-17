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
    <title>兑换详情</title>
    <jsp:include page="../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/integralMall/exchangeDetail.css">
</head>
<body>
    <jsp:include page="../common/top.jsp"></jsp:include>
   	<jsp:include page="../integralMall/intergralMallCommon.jsp"></jsp:include>
    <!-- 在这里加入页面内容 -->
    <!-- 兑换详情界面     胥福星      2016-03-29 -->
    <div class="nowPosition">
    	<div class="nowPositionContent">您当前位置 &gt;<a href="integralMall/mallIndex.html">积分商城</a>&gt;<span>兑换详情</span></div>
    </div>
    <div class="productListArea">
    	<div class="main">
    		<div class="changeDetail">
    			<div class="productInfo">
    				<div class="infoHeader">
    					<span>商品信息</span>
    					<a href="integralMall/itemList.html">返回商品列表</a>
    				</div>
    				<div class="infoDetail">
    					<div class="head">
    						<div class="imgList"></div>
    						<div class="list1">商品名称</div>
    						<div class="list1">兑换数量</div>
    						<div class="list1">积分总数</div>
    					</div>
    					<div class="contentList">
    						<div class="imgList"><img id="commoditySmallIcon" class="goodsImg" src="${info.commoditySmallIcon}"></div><!-- resource/img/integralMall/jfsc_small.png -->
    						<div id="commodityName" class="contentLi">${info.commodityName}<!-- 可爱卡通U型枕头 --></div>
    						<div id="" class="contentLiNum exchangeNum"><!-- 2 --></div>
    						<input type="hidden" id="singlePoint" value="${info.needPoint}" />
    						<div id="" class="contentLiSum exchangePoint"><!-- 70000 --></div>
    					</div>
    				</div>
    				<div class="address">
	    				<div class="infoHeader">
	    					<span>收货地址</span>
	    				</div>
	    				<ul class="addressUl">
	    					<!-- 点击设置默认地址时，对该地址添加addressUlLi样式       -->
	    					<c:if test="${!empty Address}">
		    					<c:forEach items="${Address}" var="data">
			    					<li class="addressUlLi">
			    						<span>${data.contactName}</span>
			    						<span class="addressColor">${data.provinceName}&nbsp;${data.cityName}&nbsp;${data.countyName}&nbsp;${data.villagesName}&nbsp;${data.street}&nbsp;${data.detailedAddress}&nbsp;</span>
			    						<span class="addressColor">${data.contactPhone}</span>
			    						<a class="alertAddress">修改地址</a>
			    					</li>
					    			<div class="addressWhite">
				    					<p>修改收货地址</p>
				    					<form>
				    						<div class="list">
					    						<label>收货人姓名</label>
					    						<input value="晓大大" maxlength="20"/>
				    						</div>
				    						<div class="list">
					    						<label>所在地址</label>
					    						<div class="selectArea selectArea2">
					    							<input class="selectValue" value="1" >
												    <input class="selectInput selectInput2" type="text" lang="请选择" readOnly="true"/>
												    <ul class="select1" onselectstart="return false">
												        <li class="selectOption" value="1">四川</li>
												        <li class="selectOption" value="2">重庆</li>
												        <li class="selectOption" value="3">河南</li>
												    </ul>
												</div>
					    						<span class="lineSpan"></span>
					    						<div class="selectArea selectArea2">
					    							<input class="selectValue" value="1" >
												    <input class="selectInput selectInput2" type="text" lang="请选择" readOnly="true"/>
												    <ul class="select1" onselectstart="return false">
												        <li class="selectOption" value="1">成都</li>
												        <li class="selectOption" value="2">宜宾</li>
												    </ul>
												</div>
					    						<span class="lineSpan"></span>
					    						<div class="selectArea selectArea2">
					    							<input class="selectValue" value="1" >
												    <input class="selectInput selectInput2" type="text" lang="请选择" readOnly="true"/>
												    <ul class="select1" onselectstart="return false">
												        <li class="selectOption" value="1">青羊</li>
												        <li class="selectOption" value="2">郫县</li>
												    </ul>
												</div>
				    						</div>
				    						<div class="list">
					    						<label>详细地址</label>
					    						<input class="addressDetail" value="郫县天目路77号" maxlength="50" />
				    						</div>
				    						<div class="list">
					    						<label>收件人手机</label>
					    						<input class="numberReg" value="18885478521" maxlength="11">
				    						</div>
				    						<div class="list">
					    						<label>送件时间</label>
					    						<div class="selectArea selectArea1">
					    							<input class="selectValue" value="1" >
												    <input class="selectInput selectInput1" type="text" lang="请选择" readOnly="true"/>
												    <ul class="select1" onselectstart="return false">
												        <li class="selectOption" value="1">只限工作日</li>
												        <li class="selectOption" value="2">不限</li>
												        <li class="selectOption" value="3">只限节假日</li>
												    </ul>
												</div>
				    						</div>
				    					</form>
				    					<div class="btn">
					    					<a class="saveBtn saveBtnHover" href="javascript:;">保存收货地址</a>
					    					<a class="saveBtn" href="javascript:;">设为默认收货地址</a>
				    					</div>
				    				</div>
		    					</c:forEach>
	    					</c:if>
	    				</ul>
	    				<div class="addAddress">
	    					<span class="addSpan">新增收货地址</span>
	    				</div>
    				</div>
    				
    				<div class="addressWhite">
    					<p>新增收货地址</p>
    					<form id="zeng_shouHuo">
    						<div class="list">
	    						<label>收货人姓名</label>
	    						<input datatype="z2_20" maxlength="20"/>
    						</div>
    						<div class="list">
	    						<label>所在地址</label>
	    						<div class="selectArea selectArea2">
	    							<input class="selectValue" value="0" >
								    <input class="selectInput selectInput2" type="text" lang="请选择" readOnly="true"/>
								    <ul class="select1" onselectstart="return false">
								        <li class="selectOption" value="1">四川</li>
								        <li class="selectOption" value="2">重庆</li>
								        <li class="selectOption" value="3">河南</li>
								    </ul>
								</div>
	    						<span class="lineSpan"></span>
	    						<div class="selectArea selectArea2">
	    							<input class="selectValue" value="0" >
								    <input class="selectInput selectInput2" type="text" lang="请选择" readOnly="true"/>
								    <ul class="select1" onselectstart="return false">
								        <li class="selectOption" value="1">成都</li>
								        <li class="selectOption" value="2">宜宾</li>
								    </ul>
								</div>
	    						<span class="lineSpan"></span>
	    						<div class="selectArea selectArea2">
	    							<input class="selectValue" value="0" >
								    <input class="selectInput selectInput2" type="text" lang="请选择" readOnly="true"/>
								    <ul class="select1" onselectstart="return false">
								        <li class="selectOption" value="1">青羊</li>
								        <li class="selectOption" value="2">郫县</li>
								    </ul>
								</div>
    						</div>
    						<div class="list">
	    						<label>详细地址</label>
	    						<input class="addressDetail" datatype="enteraddr" maxlength="50"/>
    						</div>
    						<div class="list">
	    						<label>收件人手机</label>
	    						<input class="numberReg" datatype="zphone" maxlength="11"/>
    						</div>
    						<div class="list">
	    						<label>送件时间</label>
	    						<div class="selectArea selectArea1">
	    							<input class="selectValue" value="1" >
								    <input class="selectInput selectInput1" type="text" lang="请选择" readOnly="true"/>
								    <ul class="select1" onselectstart="return false">
								        <li class="selectOption" value="1">只限工作日</li>
								        <li class="selectOption" value="2">不限</li>
								        <li class="selectOption" value="3">只限节假日</li>
								    </ul>
								</div>
    						</div>
    					</form>
    					<div class="btn">
	    					<a id="addrAdd" class="saveBtn saveBtnHover" href="javascript:;">保存收货地址</a>
	    					<a class="saveBtn" href="javascript:;">设为默认收货地址</a>
    					</div>
    				</div>
    				
    				<!-- 确认信息 -->
    				<div class="submitApply">
    					<div class="sum">
    						<p>兑换数量：<samp class="exchangeNum"><!-- 2 --></samp>件</p>
    						<p>积分总数：<samp class="exchangePoint"><!-- 700000 --></samp></p>
    					</div>
    					<a class="clickUp" href="javascript:clickDown();">提交兑换申请</a>
    					<!-- 兑换成功使用clickUp();    兑换失败则使用 clickDown()  -->
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <div class="applyTalent">
   		<div class="apply-top">
   			<label>兑换成功！</label>
   			<br>
   			<span>请等待发货！</span>
   		</div>
   		<div class="apply-bottom">
   			<input type="button" class="btn" value="确定" onclick="window.location.href='integralMall/itemList.html';">
   		</div>
   	</div>
    <div class="applyTalent2">
   		<div class="apply-top">
   			<label>兑换失败！</label>
   			<br>
   			<span>请重新检查您的兑换申请！</span>
   		</div>
   		<div class="apply-bottom">
   			<input type="button" class="btn" value="确定" onclick="window.location.href='integralMall/itemList.html';">
   		</div>
   	</div>
   	<jsp:include page="../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="<%=basePath %>/js/integralMall/exchangeDetail.js"></script>
	<script type="text/javascript" src="js/plugs/valid/valid.js"></script>
	<script type="text/javascript">
		//根据id获取兑换详情
		getExchangeInfo();
	</script>
</body>
</html>