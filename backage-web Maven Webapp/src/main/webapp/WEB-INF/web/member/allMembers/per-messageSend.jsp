<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>

<head>
	<base href="<%=basePath%>">
	<title>会员消息发送</title>
	<!-- 公用meta -->
	<jsp:include page="../../common/top-meta.jsp"></jsp:include>
	<!-- 公用css -->
    <jsp:include page="../../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link rel="stylesheet" href="css/member/member.css" type="text/css" >
	<link rel="stylesheet" href="css/member/memberDetail.css" type="text/css" >
	<link rel="stylesheet" href="plugs/layer-v2.2/layer/skin/layer.css" type="text/css"></link>
</head>
<body class="nav-md">
	<div class="container body addContainer">
		<div class="main_container">
			<div class="w-content ishow">
				<div class="message">
					<div class="linkMan"><label>手机号：</label><span>18855848784</span></div>
					<div class="linkMan"><label>邮箱：</label><span>44845147@qq.com</span></div>
					<div class="mode"><label>发送方式：</label>
						<label for="transmitphone"><input name="transmit" id="transmitphone" type="radio" checked >手机</label>
						<label for="transmitemail"><input name="transmit" id="transmitemail" type="radio" >邮箱</label>
						<label for="transmitIemail"><input name="transmit" id="transmitIemail" type="radio" >站内信</label>
					</div>
					<div><label>消息内容：</label><textarea class="sentContent"></textarea></div>
				</div>
				
			</div>
			
		</div>
	</div>
		<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/member.js"></script>
</body>


