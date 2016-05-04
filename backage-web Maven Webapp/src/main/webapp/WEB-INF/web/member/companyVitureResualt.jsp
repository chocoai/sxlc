<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String btn = request.getParameter("btn");

int content = Integer.parseInt(request.getParameter("content"));
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>车产认证与查看</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="css/member/companyMembers.css" type="text/css" >
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="2" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-member.jsp">
				<jsp:param value="202" name="_index_m2"/>
				<jsp:param value="20209" name="_index_m3"/>
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				<div class="nav-tabs-con active">
					<div class="data_display">
						<!-- tab切换 -->
						<jsp:include page="../common/mc-companyTable.jsp"></jsp:include> 
						<div class="w-content ishow detailAuthen realnameAuthen">
							<fieldset>
								<legend class="titleLen"></legend>
								<div class="introduce">
									<span><samp>企业名称：</samp>某某某</span>
									<span><samp>会员登录名：</samp>某某某</span>
									<span><samp>车辆品牌：</samp>玛莎拉蒂</span>
									<span><samp>车辆型号：</samp>15453146545215</span>
								</div>
								<div class="introduce">
									<span><samp>车牌号：</samp>川A111111</span>
									<span><samp>价值：</samp><label class="moneyFormat">120000</label>元</span>
									<span><samp>有效期：</samp>2016-10-10</span>
								</div>
								<div><samp class="appendix">认证附件：</samp><img src="resoures/img/accessory.jpg" ><img src="resoures/img/accessory.jpg" ></div>
								<div><samp>审核意见：</samp><select class="verifySelect"><option>同意</option><option>不同意</option></select></div>
								<div>
									<%
										if(btn.equals("1")){
									%>
										<button class="submitAuthen">提交</button>
									<%		
										}else{
									%>
										<button class="backAuthen">返回</button>
									<%
										}
									%>
								</div>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
		<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/companyMembers.js"></script>
	<script type="text/javascript" src="js/member/personAuthen.js"></script>
	<script type="text/javascript">
		var content = <%=content %>
		$("#"+content).addClass("active").siblings().removeClass("active");
		$(".titleLen").text($('#'+content).text());
		
		
	</script>
</body>