<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   	   	<script type="text/javascript">
    	var publickey = '<%=session.getAttribute("publicKey")%>';
    	var basePath = '<%=basePath%>';
    </script>
   	<div class="main">
   		<div class="clearfix">
		   	<jsp:include page="../../account/accountCommonLeft.jsp"></jsp:include>
   			<div class="accountRight">
			   	<jsp:include page="../../account/accountCommonRightTop.jsp"></jsp:include>
   				<div class="accountMain clearfix">
   				<input type="hidden" id="tol" value="${tol }">
	   			<input type="hidden" id="cpage" value="${cpage }">	
	   			<input type="hidden" id="pageSize" value="${pageSize }">
	   			
	   			<input type="hidden" id="type" value="${type }">
   				<!-- 在此处写入代码 -->
	   				<ul class="tab-head" id="tab-head">
						<li class="tab-li <c:if test="${type == 1 }">tab-ing</c:if>">获取记录</li>
						<li class="tab-li <c:if test="${type == 2 }">tab-ing</c:if>">使用记录</li>
					</ul>
					<div class="tab-content">
						<div class="c-content <c:if test="${type == 1 }">content-active</c:if>">
							<div class="integral">
								<div class="integral-sum">累计积分：<span>${myPoint.sCumulativeIntegral }</span></div><!--添加背景图  -->
								<div class="usable-integral">可使用积分：<span class="orange">${myPoint.sAvailableIntegral }</span></div>
								<div class="used-integral">已使用积分：<span>${myPoint.sUsedIntegral }</span></div>
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
			   					<c:forEach items="${pointList }" var="ir">
			   						<li>
				   						<div class="contentOut1">
											<div class="content1">
												${ir.quantity }
											</div>
										</div>
										<div class="contentOut1">
											<div class="content1">
												${ir.pointName }
											</div>
										</div>
										<div class="contentOut1">
											<div class="content1">
												${ir.dateTime }
											</div>
										</div>
										<div class="contentOut1">
											<div class="content1">
												${ir.availableIntegral }
											</div>
										</div>					
			   						</li>
			   					</c:forEach>
		   					</ul>
		   					<div id="pager"></div>
						</div>
						<div class="c-content <c:if test="${type == 2 }">content-active</c:if>">
							<div class="integral">
								<div class="integral-sum">累计积分：<span>${myPoint.sCumulativeIntegral }</span></div><!--添加背景图  -->
								<div class="usable-integral">可使用积分：<span class="orange">${myPoint.sAvailableIntegral }</span></div>
								<div class="used-integral">已使用积分：<span>${myPoint.sUsedIntegral }</span></div>
							</div>
							<ul class="my-integral-table">
			   					<li>
			   						<div class="contentOut2">
										<div class="content1">消费积分</div>
									</div>
									<div class="contentOut2">
										<div class="content1">兑换类型</div>
									</div>
									<div class="contentOut2">
										<div class="content1">兑换商品名称</div>
									</div>
									<div class="contentOut2">
										<div class="content1">兑换数量</div>
									</div>
									<div class="contentOut2">
										<div class="content1">兑换时间</div>
									</div>
									<div class="contentOut2">
										<div class="content1">确认收货时间</div>
									</div>
									<div class="contentOut2">
										<div class="content1">状态</div>
									</div>
									<div class="contentOut2">
										<div class="content1">操作</div>
									</div>
			   					</li>
			   					<c:forEach items="${pointList }" var="er">
			   						<li>
				   						<div class="contentOut2">
											<div class="content1">${er.sPoints }</div>
										</div>
										<div class="contentOut2">
											<div class="content1">${er.eTypeName }</div>
										</div>
										<div class="contentOut2">
											<div class="content1">${er.goodName }</div>
										</div>
										<div class="contentOut2">
											<div class="content1">${er.numbers }</div>
										</div>
										<div class="contentOut2">
											<div class="content1">${er.eTime }</div>
										</div>
										<div class="contentOut2">
											<div class="content1">${er.confirm }</div>
										</div>
										<div class="contentOut2">
											<div class="content1">${er.statusName }</div>
										</div>	
										<div class="contentOut2">
											<div class="content1">
											<c:if test="${er.status == 2 }"><!-- 代收货 -->
												<a href="javascript:" data-eid="${er.eId }" class="confirm">确认收货</a></div>
											</c:if>
										</div>				
				   					</li>
			   					</c:forEach>
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