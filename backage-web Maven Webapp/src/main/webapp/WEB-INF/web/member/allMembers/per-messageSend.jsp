<%@page import="product_p2p.kit.datatrans.IntegerAndString"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	long memberId =IntegerAndString.StringToLong(request.getParameter("content"), 0);
			
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
					<div class="linkMan"><label>手机号：</label><span id="memberPhone"></span></div>
					<div class="linkMan"><label>邮箱：</label><span id=memberEmail></span></div>
					<div class="mode"><label>发送方式：</label>
						<label for="transmitphone"><input name="transmit" id="transmitphone" type="radio" checked="checked" value="1">手机</label>
						<label for="transmitemail"><input name="transmit" id="transmitemail" type="radio" value="2">邮箱</label>
						<label for="transmitIemail"><input name="transmit" id="transmitIemail" type="radio"  value="3">站内信</label>
					</div>
					<input type="hidden" id="memberType" value="0">
					<div><label>消息内容：</label><textarea class="sentContent" id="remark" name="remark"></textarea></div>
				</div>
				
			</div>
			
		</div>
	</div>
		<!-- 公用js -->
	<jsp:include page="../../common/cm-js.jsp"></jsp:include>
	
	<!-- 私用js -->
	<script type="text/javascript" src="js/member/member.js"></script>
	<script type="text/javascript" src="js/member/memberSendMess.js"></script>
	<script type="text/javascript">
		var memberId = <%=memberId %>;
		var encrypt = new JSEncrypt();
		encrypt.setPublicKey(publicKey_common);
		//result 为加密后参数
		memberId = encrypt.encrypt(memberId+"");
		showMemberDetail(memberId);//会员基本信息
	</script>
	
</body>


