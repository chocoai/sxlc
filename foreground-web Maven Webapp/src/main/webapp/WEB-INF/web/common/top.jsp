<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 公共顶部模块 -->  
<!-- 作者:黄鑫 -->
<!-- 注释:这是所有页面顶部的公共代码 -->
<div class="top">
	<div>
		<div class="topLeft">
			<div class="topLeft1"></div>
			<div class="topLeft2">全国服务热线</div>
			<div class="topLeft3">400-888-6802</div>
			<div class="topLeft2">QQ群:</div>
			<div class="topLeft3">616489358</div>
			<div class="topLeft4">
				<div class="topLeft4Left">
					<div class="weibo"></div>
					<div class="wechat"></div>
				</div>
				<div class="topLeft4Right">
					<div class="phone"></div>
					<span>手机APP</span>
				</div>
			</div>
			<div class="boxImg">
				<img class="weibo_scan" src="resource/img/index/img.png">
				<img class="weichart_scan" src="resource/img/index/img.png">
				<img class="phone_scan" src="resource/img/index/phone_scan.png">
			</div>
		</div>
		<div class="topRight">
			<c:if test="${loginUser == null }">
				<span class="topRight1">您好，欢迎访问四象金融！</span>
				<a href="login.html" class="topRight2">快速登录</a>
				<a href="register.html" class="topRight3">免费注册</a>
			</c:if>
			<c:if test="${loginUser != null }">
				<span class="topRight1">欢迎您！</span>
				<span >
				${loginUser.logname }
				<span class="top_minFang messageNum" >0</span>
				<span><img src="resource/img/common/icos.jpg" style="vertical-align:middle"></span>
				<span class="shu-line"></span>
				</span>
				<a href="exitVisit.html" class="topRight3">安全退出</a>
				<input type="hidden" class="online">
			</c:if>
		</div>
	</div>
</div>
<jsp:include page="../common/aside.jsp"></jsp:include>
<script type="text/javascript" src="js/common/top.js"></script>