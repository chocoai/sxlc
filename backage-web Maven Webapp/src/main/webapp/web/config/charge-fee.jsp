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
<!-- 配置中心-------------------财务设置 -->
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
				<jsp:param value="60102" name="_index_m3" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- 快捷充值手续费设置 -->
			 	<div class="config">
			 		<fieldset class="autobidfd">
			 			<legend>会员</legend>
			 			<form class="form-horizontal" role="form" name="" action="javascript:mchargefee()" id="member">
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl controlabel col3 ">充值手续费支付比例：</label>
				 				<div id="mdiv" class="i-fl">	
				 					<label class="checkbox-inline">
				 						<input type="radio" name="member" id="" value="1"> 扣除充值人千分之三
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="member" id="" value="2"> 扣除平台千分之三
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="member" id="" value="3"> 扣除充值人千分之一
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="member" id="" value="4" checked> 扣除平台千分之一
				 					</label>
				 				</div>
			 				</div>
			 				<div class="form-group">
				 				<div class="cmbtncontainer chargefeebtn">
									<a id="memberMod" class="commonbtn0">保存</a>
								</div>
				 			</div>
			 			</form>		
			 		</fieldset>
			 		<fieldset class="autobidfd">
			 			<legend>第三方合作机构</legend>
			 			<form class="form-horizontal" role="form" name="" action="javascript:ochargefee()" id="orgnization">
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl controlabel col3">充值手续费支付比例：</label>
				 				<div id="odiv" class="i-fl">	
				 					<label class="checkbox-inline">
				 						<input type="radio" name="thirdpart" id="" value="1"> 扣除充值人千分之三
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="thirdpart" id="" value="2"> 扣除平台千分之三
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="thirdpart" id="" value="3"> 扣除充值人千分之一
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="thirdpart" id="" value="4" checked> 扣除平台千分之一
				 					</label>
				 				</div>
			 				</div>
			 				<div class="form-group">
				 				<div class="cmbtncontainer chargefeebtn">
									<a id="orgMod" class="commonbtn0">保存</a>
								</div>
				 			</div>
			 			</form>		
			 		</fieldset>
			 		<fieldset class="autobidfd">
			 			<legend>平台</legend>
			 			<form class="form-horizontal" role="form" name="" action="javascript:pchargefee()" id="station">
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl controlabel col3">充值手续费支付比例：</label>
				 				<div id="sdiv" class="i-fl">	
				 					<label class="checkbox-inline">
				 						<input type="radio" name="platform" id="" value="1"> 扣除充值人千分之三
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="platform" id="" value="2"> 扣除平台千分之三
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="platform" id="" value="3"> 扣除充值人千分之一
				 					</label>
				 					<label class="checkbox-inline">
				 						<input type="radio" name="platform" id="" value="4" checked> 扣除平台千分之一
				 					</label>
				 				</div>
			 				</div>
			 				<div class="form-group">
				 				<div class="cmbtncontainer chargefeebtn">
									<a id="platMod" class="commonbtn0">保存</a>
								</div>
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
	<script type="text/javascript" src="js/config/charge-fee.js"></script>
	<script type="text/javascript" src="js/rsa/RSA.js"></script> 
	<script type="text/javascript" src="js/rsa/Barrett.js"></script>
	<script type="text/javascript" src="js/rsa/BigInt.js"></script>
	<!-- 私用js -->
	<script>
		 var publicKey_common = '<%=session.getAttribute("publicKey") %>';
	</script>
</body>

</html>