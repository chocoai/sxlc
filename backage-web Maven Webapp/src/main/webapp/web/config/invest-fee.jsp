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
<!-- 配置中心-------------------财务设置  投资管理费 天标-->
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
				<jsp:param value="60108" name="_index_m3" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- 提现手续费设置 -->
			 	<div class="config">
			 		<fieldset class="investfd">
			 			<legend>投资管理费</legend>
			 			<form class="form-horizontal" role="form" name="" action="javascript:updateMange()" id="mange">
			 				<div class="form-group investfeediv">
			 					<label for="lastname" class="i-fl control-label col3">投资管理费：</label>
			 					<div class="i-fl" id="investfee">
			 						<input type="text" class="form-control" name="priceDatum" id="lastname" placeholder="" datatype="hundrednum">
			 					</div>
			 					<div class="i-fl">
			 						<span class="sign i-fl">%<i></i></span>
			 					</div>
			 					<div class="input-alert">
			 						<span></span>
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
	<script type="text/javascript" src="js/config/invest-fee.js"></script>
	<script type="text/javascript" src="js/rsa/RSA.js"></script> 
	<script type="text/javascript" src="js/rsa/Barrett.js"></script>
	<script type="text/javascript" src="js/rsa/BigInt.js"></script>
	<!-- 私用js -->
	<script>
		 var publicKey_common = '<%=session.getAttribute("publicKey") %>';
		 $(function(){
			validform5(".commonbtn0","mange",false,"3");
		});
	</script>
</body>

</html>