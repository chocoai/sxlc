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
				<jsp:param value="6" name="top_menu_index"/>
			</jsp:include>
			
			<!-- 左侧菜单 -->
			<jsp:include page="../common/cm-config.jsp">
				<jsp:param value="config-0" name="config-index" />
			</jsp:include>
			<!-- 主要内容 -->
			<div class="right_col" role="main">
				<!-- 地址导航 -->
				<jsp:include page="../common/cm-addr.jsp"></jsp:include>
				
			 	<!-- 快捷充值手续费设置 -->
			 	<div class="config">
			 		<fieldset>
			 			<legend>会员</legend>
			 			<form class="form-horizontal" role="form" name="" action="javascript:mchargefee()" id="member">
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">充值手续费支付比例：</label>
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
			 					<div class="offset-col3">
			 						<button type="submit" class="btn btn-default">保存</button>
			 					</div>
			 				</div>
			 			</form>		
			 		</fieldset>
			 		<fieldset>
			 			<legend>第三方合作机构</legend>
			 			<form class="form-horizontal" role="form" name="" action="javascript:ochargefee()" id="orgnization">
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">充值手续费支付比例：</label>
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
			 					<div class="offset-col3">
			 						<button type="submit" class="btn btn-default">保存</button>
			 					</div>
			 				</div>
			 			</form>		
			 		</fieldset>
			 		<fieldset>
			 			<legend>平台</legend>
			 			<form class="form-horizontal" role="form" name="" action="javascript:pchargefee()" id="station">
			 				<div class="form-group">
			 					<label for="lastname" class="i-fl control-label col3">充值手续费支付比例：</label>
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
			 					<div class="offset-col3">
			 						<button type="submit" class="btn btn-default">保存</button>
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
	<!-- 私用js -->
</body>

</html>