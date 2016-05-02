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
<!-- 配置中心-------------------财务设置   自动投标奖励-->
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
				<jsp:param value="60109" name="_index_m3" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	
			 	<!-- 自动投标奖励设置 -->
			 	<div class="config">
			 		<fieldset class="autobidfd">
			 			<legend>自动投标奖励设置</legend>
			 			<form id="autobidtest" class="form-horizontal" role="form" name="" type="post" action="javascript:updateAuto()" id="auto">
			 				<div class="form-group autobiddiv">
			 					<label for="firstname" class="col3 i-fl control-label">自动投标奖励：</label>
			 					<div class="i-fl">
			 						<input type="text" name="autoBackRate" class="form-control" id="firstname" placeholder="" datatype="hundrednum">
				 				</div>
				 				<div class="i-fl">
				 					<span class="sign">%<i>*</i></span><!-- 放款时返还自动投资总金额的N% -->
				 				</div>
				 			</div>
				 			<div class="form-group">
				 				<div class="cmbtncontainer autobidbtn">
									<a class="commonbtn0">保存</a>
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
	<script type="text/javascript" src="js/config/auto-bid.js"></script>
	<script type="text/javascript" src="js/rsa/RSA.js"></script> 
	<script type="text/javascript" src="js/rsa/Barrett.js"></script>
	<script type="text/javascript" src="js/rsa/BigInt.js"></script>
	<!-- 私用js -->
	<script>
		 var publicKey_common = '<%=session.getAttribute("publicKey") %>';
		 $(function(){
			validform5(".commonbtn0","autobidtest",false,"3");
		});
	</script>
</body>

</html>