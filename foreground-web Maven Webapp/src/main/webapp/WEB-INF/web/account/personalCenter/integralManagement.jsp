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
    <title>积分管理</title>
    <jsp:include page="../../common/top_meta.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/account/account.css">
	<link rel="stylesheet" href="plugs/pager/pager_def.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/account/personalCenter/integralManagement.css">
</head>
<body> 
    <jsp:include page="../../common/top.jsp"></jsp:include>
   	<jsp:include page="../../common/mainPageTop.jsp"></jsp:include>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<!-- 在此处写入代码 -->
	   				<ul class="tab-head">
						<li class="tab-li tab-ing">获取记录</li>
						<li class="tab-li">使用记录</li>
					</ul>
					<div class="tab-content">
						<div class="c-content content-active">
							<div class="integral">
								<div class="integral-sum">累计积分：<span>4000</span></div><!--添加背景图  -->
								<div class="usable-integral">可使用积分：<span class="orange">1000</span></div>
								<div class="used-integral">已使用积分：<span>3000</span></div>
							</div>
							<ul class="my-integral-table">
			   					<li>
			   						<div class="contentOut1">
										<div class="content1">
											积分
										</div>
									</div>
									<div class="contentOut1">
										<div class="content1">
											积分类型
										</div>
									</div>
									<div class="contentOut1">
										<div class="content1">
											获取时间
										</div>
									</div>
									<div class="contentOut1">
										<div class="content1">
											获取后可用积分总计
										</div>
									</div>
			   					</li>
			   					<% for(int j = 0; j<2;j++){ %>
			   					<li>
			   						<div class="contentOut1">
										<div class="content1">
											4100
										</div>
									</div>
									<div class="contentOut1">
										<div class="content1">
											自动升级
										</div>
									</div>
									<div class="contentOut1">
										<div class="content1">
											2016-09-07&nbsp;14:12:06
										</div>
									</div>
									<div class="contentOut1">
										<div class="content1">
											100.00
										</div>
									</div>					
			   					</li>
			   					<%} %>
		   					</ul>
		   					<div id="pager"></div>
						</div>
						<div class="c-content">
							<div class="integral">
								<div class="integral-sum">累计积分：<span>4000</span></div><!--添加背景图  -->
								<div class="usable-integral">可使用积分：<span class="orange">1000</span></div>
								<div class="used-integral">已使用积分：<span>3000</span></div>
							</div>
							<ul class="my-integral-table">
			   					<li>
			   						<div class="contentOut2">
										<div class="content1">
											消费积分
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											兑换类型
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											兑换商品名称
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											兑换数量
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											兑换时间
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											确认收货时间
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											状态
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											操作
										</div>
									</div>
			   					</li>
			   					<% for(int j = 0; j<2;j++){ %>
			   					<li>
			   						<div class="contentOut2">
										<div class="content1">
											4100
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											实物
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											电风扇
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											1
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											2016-09-07<br>
											14:12:00
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											2016-05-04<br>
											09:12:00
										</div>
									</div>
									<div class="contentOut2">
										<div class="content1">
											待发货
										</div>
									</div>	
									<div class="contentOut2">
										<div class="content1">
											<a href="">确认收货</a>
										</div>
									</div>				
			   					</li>
			   					<%} %>
		   					</ul>
		   					<div id="pager1"></div>
						</div>
					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	<jsp:include page="../../common/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="js/account/account.js"></script>
	<script type="text/javascript" charset="utf-8" src="plugs/pager/pager.js"></script>
	<script type="text/javascript" src="js/account/personalCenter/integralManagement.js"></script>
</body>
</html>