<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<base href="<%=basePath%>">
	<title>配置中心--财务配置</title>
	<!-- 公用meta -->
	<jsp:include page="../common/top-meta.jsp"></jsp:include>
	<!-- 私用meta -->
	<!-- 公用css -->
	<jsp:include page="../common/cm-css.jsp"></jsp:include>
	<!-- 私用css -->
	<link href="css/config.css" rel="stylesheet" />
</head>
<!-- 配置中心-------------------财务设置    红包、代金券到期提醒-->
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- 头部 -->
			<jsp:include page="../common/cm-top.jsp">
				<jsp:param value="6" name="_index_m1"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="601" name="_index_m2" />
				<jsp:param value="60110" name="_index_m3" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- 提现手续费设置 -->
			 	<div class="config">
			 		<fieldset class="redvoucherfd">
			 			<legend>红包、代金券到期提醒</legend>
			 			<form class="form-horizontal" role="form" name="" action="javascript:addRedV()" type="post" id="red">
			 				<div class="form-group redvoucherdiv">
			 					<label for="lastname" class="i-fl control-label col3">到期前N天提醒：</label>
			 					<div class="i-fl" id="redvoucherdiv">
			 						<input id="days" type="text" class="form-control" datatype="nNum1" name="endDateRemind" placeholder="">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">天<i></i></span>
			 					</div>
			 					<div class="input-alert">
			 					</div>
			 				</div>
			 				<div class="cmbtncontainer autobidbtn">
								<a class="commonbtn0 fcstationbtn">保存</a>
							</div>
			 			</form>		
			 		</fieldset>
			 	</div>	
			 </div>
		</div>
	</div>
		
	<!-- 尾部 -->
	<!-- 公用js -->
	<jsp:include page="../common/cm-js.jsp"></jsp:include>
	<script type="text/javascript" src="js/valid.js"></script>
	<script type="text/javascript" src="js/config/red-voucher.js"></script>
	<script type="text/javascript" src="js/rsa/RSA.js"></script> 
	<script type="text/javascript" src="js/rsa/Barrett.js"></script>
	<script type="text/javascript" src="js/rsa/BigInt.js"></script>
	<!-- 私用js -->
	<script src="js/config/config.js"></script>
	<script>
		 var publicKey_common = '<%=session.getAttribute("publicKey") %>';
		 $(function(){
			validform5(".commonbtn0","red",false,"5");
		});
	</script>
</body>

</html>